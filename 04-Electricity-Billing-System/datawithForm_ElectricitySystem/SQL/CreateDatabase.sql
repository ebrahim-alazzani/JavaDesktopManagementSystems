-- =============================================
-- نظام الكهرباء - EElectricitySystem
-- سكربت إنشاء قاعدة البيانات الكامل
-- =============================================

-- 1) إنشاء قاعدة البيانات
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'EElectricitySystem')
BEGIN
    CREATE DATABASE EElectricitySystem;
END
GO

USE EElectricitySystem;
GO

-- =============================================
-- 2) الجداول الأساسية
-- =============================================

-- 2.1 الأدوار (Roles)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Roles')
CREATE TABLE Roles (
    Role_ID INT IDENTITY(1,1) PRIMARY KEY,
    Role_Name NVARCHAR(50) NOT NULL
);
GO

-- 2.2 المستخدمون (Users)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Users')
CREATE TABLE Users (
    User_ID INT IDENTITY(1,1) PRIMARY KEY,
    UserName NVARCHAR(50) NOT NULL,
    Password NVARCHAR(100) NOT NULL,
    FullName NVARCHAR(100),
    Role_ID INT NOT NULL,
    IsActive BIT DEFAULT 1,
    CONSTRAINT FK_Users_Roles FOREIGN KEY (Role_ID) REFERENCES Roles(Role_ID)
);
GO

-- 2.3 العملاء (Customers)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Customers')
CREATE TABLE Customers (
    Customer_ID INT IDENTITY(1,1) PRIMARY KEY,
    Customer_Name NVARCHAR(200) NOT NULL,
    Phone NVARCHAR(20),
    Address NVARCHAR(200),
    Opening_Balance DECIMAL(18,2) DEFAULT 0,
    Status BIT DEFAULT 1,
    Created_Date DATETIME DEFAULT GETDATE()
);
GO

-- 2.4 العدادات (Meters)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Meters')
CREATE TABLE Meters (
    Meter_ID INT IDENTITY(1,1) PRIMARY KEY,
    Meter_No NVARCHAR(50) NOT NULL UNIQUE,
    Customer_ID INT NOT NULL,
    Installation_Date DATETIME DEFAULT GETDATE(),
    Status BIT DEFAULT 1,
    Location NVARCHAR(200),
    CONSTRAINT FK_Meters_Customers FOREIGN KEY (Customer_ID) REFERENCES Customers(Customer_ID)
);
GO

-- 2.5 فترات الفوترة (Billing_Periods)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Billing_Periods')
CREATE TABLE Billing_Periods (
    Period_ID INT IDENTITY(1,1) PRIMARY KEY,
    Period_Name NVARCHAR(50) NOT NULL,
    Start_Date DATE NOT NULL,
    End_Date DATE NOT NULL,
    Is_Closed BIT DEFAULT 0
);
GO

-- 2.6 التعرفة (Tariffs)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Tariffs')
CREATE TABLE Tariffs (
    Tariff_ID INT IDENTITY(1,1) PRIMARY KEY,
    Tariff_Name NVARCHAR(50) NOT NULL,
    Price_Per_Unit DECIMAL(18,2) NOT NULL,
    Fixed_Fee DECIMAL(18,2) DEFAULT 0,
    Is_Active BIT DEFAULT 1
);
GO

-- 2.7 قراءات العدادات (Meter_Readings)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Meter_Readings')
CREATE TABLE Meter_Readings (
    Reading_ID INT IDENTITY(1,1) PRIMARY KEY,
    Meter_ID INT NOT NULL,
    Period_ID INT NOT NULL,
    Reading_Value DECIMAL(18,2) NOT NULL,
    Reading_Date DATETIME DEFAULT GETDATE(),
    Reader_User_ID INT NULL,
    CONSTRAINT FK_MeterReadings_Meters FOREIGN KEY (Meter_ID) REFERENCES Meters(Meter_ID),
    CONSTRAINT FK_MeterReadings_Periods FOREIGN KEY (Period_ID) REFERENCES Billing_Periods(Period_ID)
);
GO

-- 2.8 الفواتير (Invoices)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Invoices')
CREATE TABLE Invoices (
    Invoice_ID INT IDENTITY(1,1) PRIMARY KEY,
    Customer_ID INT NOT NULL,
    Meter_ID INT NOT NULL,
    Period_ID INT NOT NULL,
    Tariff_ID INT NOT NULL,
    Previous_Reading DECIMAL(18,2) DEFAULT 0,
    Current_Reading DECIMAL(18,2) DEFAULT 0,
    Consumption AS (Current_Reading - Previous_Reading) PERSISTED,
    Current_Amount DECIMAL(18,2) DEFAULT 0,
    Previous_Balance DECIMAL(18,2) DEFAULT 0,
    Total_Balance AS (Current_Amount + Previous_Balance) PERSISTED,
    Invoice_Date DATETIME DEFAULT GETDATE(),
    Is_Paid BIT DEFAULT 0,
    CONSTRAINT FK_Invoices_Customers FOREIGN KEY (Customer_ID) REFERENCES Customers(Customer_ID),
    CONSTRAINT FK_Invoices_Meters FOREIGN KEY (Meter_ID) REFERENCES Meters(Meter_ID),
    CONSTRAINT FK_Invoices_Periods FOREIGN KEY (Period_ID) REFERENCES Billing_Periods(Period_ID),
    CONSTRAINT FK_Invoices_Tariffs FOREIGN KEY (Tariff_ID) REFERENCES Tariffs(Tariff_ID)
);
GO

-- 2.9 (تم حذف جدول عناصر الفاتورة - غير مطلوب)

-- 2.10 المدفوعات (Payments)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Payments')
CREATE TABLE Payments (
    Payment_ID INT IDENTITY(1,1) PRIMARY KEY,
    Customer_ID INT NOT NULL,
    Invoice_ID INT NULL,
    Amount DECIMAL(18,2) NOT NULL,
    Payment_Date DATETIME DEFAULT GETDATE(),
    Payment_Method NVARCHAR(50),
    Reference_No NVARCHAR(50),
    CONSTRAINT FK_Payments_Customers FOREIGN KEY (Customer_ID) REFERENCES Customers(Customer_ID),
    CONSTRAINT FK_Payments_Invoices FOREIGN KEY (Invoice_ID) REFERENCES Invoices(Invoice_ID)
);
GO

-- 2.11 الحسابات (Accounts)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Accounts')
CREATE TABLE Accounts (
    Account_ID INT IDENTITY(1,1) PRIMARY KEY,
    Account_Name NVARCHAR(200) NOT NULL,
    Account_Type NVARCHAR(50) CHECK (Account_Type IN (N'أصول',N'خصوم',N'حقوق ملكية',N'إيرادات',N'مصروفات')),
    Balance_Type NVARCHAR(10) CHECK (Balance_Type IN (N'مدين',N'دائن'))
);
GO

-- 2.12 القيود المحاسبية (Journal_Entries + Lines)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Journal_Entries')
CREATE TABLE Journal_Entries (
    Entry_ID INT IDENTITY(1,1) PRIMARY KEY,
    Entry_Date DATETIME DEFAULT GETDATE(),
    Description NVARCHAR(MAX),
    Total_Debit DECIMAL(18,2) DEFAULT 0,
    Total_Credit DECIMAL(18,2) DEFAULT 0
);
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Journal_Entry_Lines')
CREATE TABLE Journal_Entry_Lines (
    Line_ID INT IDENTITY(1,1) PRIMARY KEY,
    Entry_ID INT NOT NULL,
    Account_ID INT NOT NULL,
    Debit DECIMAL(18,2) DEFAULT 0,
    Credit DECIMAL(18,2) DEFAULT 0,
    CONSTRAINT FK_JournalLines_Entries FOREIGN KEY (Entry_ID) REFERENCES Journal_Entries(Entry_ID),
    CONSTRAINT FK_JournalLines_Accounts FOREIGN KEY (Account_ID) REFERENCES Accounts(Account_ID)
);
GO

-- 2.13 الأصول الثابتة (Fixed_Assets)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Fixed_Assets')
CREATE TABLE Fixed_Assets (
    Asset_ID INT IDENTITY(1,1) PRIMARY KEY,
    Asset_Name NVARCHAR(200) NOT NULL,
    Asset_Type NVARCHAR(50),
    Purchase_Value DECIMAL(18,2),
    Purchase_Date DATETIME DEFAULT GETDATE(),
    Account_ID INT NULL,
    CONSTRAINT FK_FixedAssets_Accounts FOREIGN KEY (Account_ID) REFERENCES Accounts(Account_ID)
);
GO

-- 2.14 استهلاك الوقود (Fuel_Consumption)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Fuel_Consumption')
CREATE TABLE Fuel_Consumption (
    Log_ID INT IDENTITY(1,1) PRIMARY KEY,
    Asset_ID INT NOT NULL,
    Transaction_Type NVARCHAR(20) DEFAULT N'استهلاك',
    Quantity_Used DECIMAL(18,2) NOT NULL,
    Cost DECIMAL(18,2) DEFAULT 0,
    Log_Date DATETIME DEFAULT GETDATE(),
    CONSTRAINT FK_Fuel_Assets FOREIGN KEY (Asset_ID) REFERENCES Fixed_Assets(Asset_ID)
);
GO

-- 2.15 سجل التدقيق (Audit_Log)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Audit_Log')
CREATE TABLE Audit_Log (
    Log_ID INT IDENTITY(1,1) PRIMARY KEY,
    User_ID INT NULL,
    Action NVARCHAR(50),
    Table_Name NVARCHAR(50),
    Record_ID INT,
    Action_Date DATETIME DEFAULT GETDATE(),
    Details NVARCHAR(MAX)
);
GO

-- 2.16 سندات القبض والصرف (Vouchers)
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Vouchers')
CREATE TABLE Vouchers (
    Voucher_ID INT IDENTITY(1,1) PRIMARY KEY,
    Voucher_Type NVARCHAR(20) NOT NULL CHECK (Voucher_Type IN (N'سند قبض',N'سند صرف')),
    Customer_ID INT NULL,
    Account_ID INT NOT NULL,
    Amount DECIMAL(18,2) NOT NULL,
    Description NVARCHAR(MAX),
    Payment_Method NVARCHAR(50) DEFAULT N'نقدي',
    Reference_No NVARCHAR(50),
    Voucher_Date DATETIME DEFAULT GETDATE(),
    CONSTRAINT FK_Vouchers_Customers FOREIGN KEY (Customer_ID) REFERENCES Customers(Customer_ID),
    CONSTRAINT FK_Vouchers_Accounts FOREIGN KEY (Account_ID) REFERENCES Accounts(Account_ID)
);
GO

-- =============================================
-- 3) الإجراءات المخزنة (Stored Procedures)
-- =============================================

-- ========== العملاء (Customers) ==========
IF OBJECT_ID('sp_GetAllCustomers') IS NOT NULL DROP PROCEDURE sp_GetAllCustomers;
GO
CREATE PROCEDURE sp_GetAllCustomers
AS
BEGIN
    SELECT * FROM Customers ORDER BY Customer_ID DESC;
END
GO

IF OBJECT_ID('sp_GetCustomerByID') IS NOT NULL DROP PROCEDURE sp_GetCustomerByID;
GO
CREATE PROCEDURE sp_GetCustomerByID @Customer_ID INT
AS
BEGIN
    SELECT * FROM Customers WHERE Customer_ID = @Customer_ID;
END
GO

IF OBJECT_ID('sp_SearchCustomers') IS NOT NULL DROP PROCEDURE sp_SearchCustomers;
GO
CREATE PROCEDURE sp_SearchCustomers @SearchText NVARCHAR(100)
AS
BEGIN
    SELECT * FROM Customers
    WHERE Customer_Name LIKE '%' + @SearchText + '%'
       OR Phone LIKE '%' + @SearchText + '%'
       OR Address LIKE '%' + @SearchText + '%'
    ORDER BY Customer_ID DESC;
END
GO

IF OBJECT_ID('sp_AddCustomer') IS NOT NULL DROP PROCEDURE sp_AddCustomer;
GO
CREATE PROCEDURE sp_AddCustomer
    @Customer_Name NVARCHAR(200),
    @Phone NVARCHAR(20) = NULL,
    @Address NVARCHAR(200) = NULL,
    @Opening_Balance DECIMAL(18,2) = 0
AS
BEGIN
    INSERT INTO Customers(Customer_Name, Phone, Address, Opening_Balance)
    VALUES(@Customer_Name, @Phone, @Address, @Opening_Balance);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

IF OBJECT_ID('sp_UpdateCustomer') IS NOT NULL DROP PROCEDURE sp_UpdateCustomer;
GO
CREATE PROCEDURE sp_UpdateCustomer
    @Customer_ID INT,
    @Customer_Name NVARCHAR(200),
    @Phone NVARCHAR(20) = NULL,
    @Address NVARCHAR(200) = NULL,
    @Opening_Balance DECIMAL(18,2) = 0,
    @Status BIT = 1
AS
BEGIN
    UPDATE Customers
    SET Customer_Name=@Customer_Name, Phone=@Phone, Address=@Address,
        Opening_Balance=@Opening_Balance, Status=@Status
    WHERE Customer_ID=@Customer_ID;
END
GO

IF OBJECT_ID('sp_DeleteCustomer') IS NOT NULL DROP PROCEDURE sp_DeleteCustomer;
GO
CREATE PROCEDURE sp_DeleteCustomer @Customer_ID INT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Meters WHERE Customer_ID=@Customer_ID)
       AND NOT EXISTS (SELECT 1 FROM Invoices WHERE Customer_ID=@Customer_ID)
    BEGIN
        DELETE FROM Customers WHERE Customer_ID=@Customer_ID;
    END
    ELSE
        RAISERROR(N'لا يمكن حذف العميل لوجود بيانات مرتبطة به',16,1);
END
GO

-- ========== العدادات (Meters) ==========
IF OBJECT_ID('sp_GetAllMeters') IS NOT NULL DROP PROCEDURE sp_GetAllMeters;
GO
CREATE PROCEDURE sp_GetAllMeters
AS
BEGIN
    SELECT m.*, c.Customer_Name
    FROM Meters m INNER JOIN Customers c ON m.Customer_ID = c.Customer_ID
    ORDER BY m.Meter_ID DESC;
END
GO

IF OBJECT_ID('sp_GetMetersByCustomer') IS NOT NULL DROP PROCEDURE sp_GetMetersByCustomer;
GO
CREATE PROCEDURE sp_GetMetersByCustomer @Customer_ID INT
AS
BEGIN
    SELECT * FROM Meters WHERE Customer_ID = @Customer_ID AND Status = 1;
END
GO

IF OBJECT_ID('sp_AddMeter') IS NOT NULL DROP PROCEDURE sp_AddMeter;
GO
CREATE PROCEDURE sp_AddMeter
    @Meter_No NVARCHAR(50),
    @Customer_ID INT,
    @Installation_Date DATETIME = NULL,
    @Location NVARCHAR(200) = NULL
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Meters WHERE Meter_No=@Meter_No)
    BEGIN
        INSERT INTO Meters(Meter_No, Customer_ID, Installation_Date, Location)
        VALUES(@Meter_No, @Customer_ID, ISNULL(@Installation_Date, GETDATE()), @Location);
        SELECT SCOPE_IDENTITY() AS NewID;
    END
    ELSE
        RAISERROR(N'رقم العداد موجود مسبقاً',16,1);
END
GO

IF OBJECT_ID('sp_UpdateMeter') IS NOT NULL DROP PROCEDURE sp_UpdateMeter;
GO
CREATE PROCEDURE sp_UpdateMeter
    @Meter_ID INT,
    @Meter_No NVARCHAR(50),
    @Customer_ID INT,
    @Location NVARCHAR(200) = NULL,
    @Status BIT = 1
AS
BEGIN
    UPDATE Meters SET Meter_No=@Meter_No, Customer_ID=@Customer_ID,
        Location=@Location, Status=@Status
    WHERE Meter_ID=@Meter_ID;
END
GO

IF OBJECT_ID('sp_DeleteMeter') IS NOT NULL DROP PROCEDURE sp_DeleteMeter;
GO
CREATE PROCEDURE sp_DeleteMeter @Meter_ID INT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Meter_Readings WHERE Meter_ID=@Meter_ID)
       AND NOT EXISTS (SELECT 1 FROM Invoices WHERE Meter_ID=@Meter_ID)
        DELETE FROM Meters WHERE Meter_ID=@Meter_ID;
    ELSE
        RAISERROR(N'لا يمكن حذف العداد لوجود بيانات مرتبطة',16,1);
END
GO

-- ========== فترات الفوترة (Billing_Periods) ==========
IF OBJECT_ID('sp_GetAllBillingPeriods') IS NOT NULL DROP PROCEDURE sp_GetAllBillingPeriods;
GO
CREATE PROCEDURE sp_GetAllBillingPeriods
AS
BEGIN
    SELECT * FROM Billing_Periods ORDER BY Period_ID DESC;
END
GO

IF OBJECT_ID('sp_GetOpenBillingPeriods') IS NOT NULL DROP PROCEDURE sp_GetOpenBillingPeriods;
GO
CREATE PROCEDURE sp_GetOpenBillingPeriods
AS
BEGIN
    SELECT * FROM Billing_Periods WHERE Is_Closed = 0 ORDER BY Start_Date DESC;
END
GO

IF OBJECT_ID('sp_AddBillingPeriod') IS NOT NULL DROP PROCEDURE sp_AddBillingPeriod;
GO
CREATE PROCEDURE sp_AddBillingPeriod
    @Period_Name NVARCHAR(50),
    @Start_Date DATE,
    @End_Date DATE
AS
BEGIN
    INSERT INTO Billing_Periods(Period_Name, Start_Date, End_Date)
    VALUES(@Period_Name, @Start_Date, @End_Date);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

IF OBJECT_ID('sp_UpdateBillingPeriod') IS NOT NULL DROP PROCEDURE sp_UpdateBillingPeriod;
GO
CREATE PROCEDURE sp_UpdateBillingPeriod
    @Period_ID INT,
    @Period_Name NVARCHAR(50),
    @Start_Date DATE,
    @End_Date DATE,
    @Is_Closed BIT = 0
AS
BEGIN
    UPDATE Billing_Periods SET Period_Name=@Period_Name, Start_Date=@Start_Date,
        End_Date=@End_Date, Is_Closed=@Is_Closed
    WHERE Period_ID=@Period_ID;
END
GO

IF OBJECT_ID('sp_DeleteBillingPeriod') IS NOT NULL DROP PROCEDURE sp_DeleteBillingPeriod;
GO
CREATE PROCEDURE sp_DeleteBillingPeriod @Period_ID INT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Invoices WHERE Period_ID=@Period_ID)
        DELETE FROM Billing_Periods WHERE Period_ID=@Period_ID;
    ELSE
        RAISERROR(N'لا يمكن حذف الفترة لوجود فواتير مرتبطة',16,1);
END
GO

-- ========== التعرفة (Tariffs) ==========
IF OBJECT_ID('sp_GetAllTariffs') IS NOT NULL DROP PROCEDURE sp_GetAllTariffs;
GO
CREATE PROCEDURE sp_GetAllTariffs
AS
BEGIN
    SELECT * FROM Tariffs ORDER BY Tariff_ID DESC;
END
GO

IF OBJECT_ID('sp_GetActiveTariffs') IS NOT NULL DROP PROCEDURE sp_GetActiveTariffs;
GO
CREATE PROCEDURE sp_GetActiveTariffs
AS
BEGIN
    SELECT * FROM Tariffs WHERE Is_Active = 1;
END
GO

IF OBJECT_ID('sp_AddTariff') IS NOT NULL DROP PROCEDURE sp_AddTariff;
GO
CREATE PROCEDURE sp_AddTariff
    @Tariff_Name NVARCHAR(50),
    @Price_Per_Unit DECIMAL(18,2),
    @Fixed_Fee DECIMAL(18,2) = 0
AS
BEGIN
    INSERT INTO Tariffs(Tariff_Name, Price_Per_Unit, Fixed_Fee)
    VALUES(@Tariff_Name, @Price_Per_Unit, @Fixed_Fee);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

IF OBJECT_ID('sp_UpdateTariff') IS NOT NULL DROP PROCEDURE sp_UpdateTariff;
GO
CREATE PROCEDURE sp_UpdateTariff
    @Tariff_ID INT,
    @Tariff_Name NVARCHAR(50),
    @Price_Per_Unit DECIMAL(18,2),
    @Fixed_Fee DECIMAL(18,2) = 0,
    @Is_Active BIT = 1
AS
BEGIN
    UPDATE Tariffs SET Tariff_Name=@Tariff_Name, Price_Per_Unit=@Price_Per_Unit,
        Fixed_Fee=@Fixed_Fee, Is_Active=@Is_Active
    WHERE Tariff_ID=@Tariff_ID;
END
GO

IF OBJECT_ID('sp_DeleteTariff') IS NOT NULL DROP PROCEDURE sp_DeleteTariff;
GO
CREATE PROCEDURE sp_DeleteTariff @Tariff_ID INT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Invoices WHERE Tariff_ID=@Tariff_ID)
        DELETE FROM Tariffs WHERE Tariff_ID=@Tariff_ID;
    ELSE
        RAISERROR(N'لا يمكن حذف التعرفة لوجود فواتير مرتبطة',16,1);
END
GO

-- ========== قراءات العدادات (Meter_Readings) ==========
IF OBJECT_ID('sp_GetReadingsByMeter') IS NOT NULL DROP PROCEDURE sp_GetReadingsByMeter;
GO
CREATE PROCEDURE sp_GetReadingsByMeter @Meter_ID INT
AS
BEGIN
    SELECT mr.*, bp.Period_Name
    FROM Meter_Readings mr INNER JOIN Billing_Periods bp ON mr.Period_ID = bp.Period_ID
    WHERE mr.Meter_ID = @Meter_ID ORDER BY mr.Reading_Date DESC;
END
GO

IF OBJECT_ID('sp_GetLastReading') IS NOT NULL DROP PROCEDURE sp_GetLastReading;
GO
CREATE PROCEDURE sp_GetLastReading @Meter_ID INT
AS
BEGIN
    SELECT TOP 1 Reading_Value FROM Meter_Readings
    WHERE Meter_ID = @Meter_ID ORDER BY Reading_Date DESC;
END
GO

IF OBJECT_ID('sp_AddMeterReading') IS NOT NULL DROP PROCEDURE sp_AddMeterReading;
GO
CREATE PROCEDURE sp_AddMeterReading
    @Meter_ID INT,
    @Period_ID INT,
    @Reading_Value DECIMAL(18,2),
    @Reader_User_ID INT = NULL
AS
BEGIN
    INSERT INTO Meter_Readings(Meter_ID, Period_ID, Reading_Value, Reader_User_ID)
    VALUES(@Meter_ID, @Period_ID, @Reading_Value, @Reader_User_ID);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

-- ========== الفواتير (Invoices) ==========
IF OBJECT_ID('sp_GetAllInvoices') IS NOT NULL DROP PROCEDURE sp_GetAllInvoices;
GO
CREATE PROCEDURE sp_GetAllInvoices
AS
BEGIN
    SELECT i.*, c.Customer_Name, m.Meter_No, bp.Period_Name, t.Tariff_Name
    FROM Invoices i
    INNER JOIN Customers c ON i.Customer_ID = c.Customer_ID
    INNER JOIN Meters m ON i.Meter_ID = m.Meter_ID
    INNER JOIN Billing_Periods bp ON i.Period_ID = bp.Period_ID
    INNER JOIN Tariffs t ON i.Tariff_ID = t.Tariff_ID
    ORDER BY i.Invoice_ID DESC;
END
GO

IF OBJECT_ID('sp_GetInvoicesByCustomer') IS NOT NULL DROP PROCEDURE sp_GetInvoicesByCustomer;
GO
CREATE PROCEDURE sp_GetInvoicesByCustomer @Customer_ID INT
AS
BEGIN
    SELECT i.*, m.Meter_No, bp.Period_Name, t.Tariff_Name
    FROM Invoices i
    INNER JOIN Meters m ON i.Meter_ID = m.Meter_ID
    INNER JOIN Billing_Periods bp ON i.Period_ID = bp.Period_ID
    INNER JOIN Tariffs t ON i.Tariff_ID = t.Tariff_ID
    WHERE i.Customer_ID = @Customer_ID
    ORDER BY i.Invoice_ID DESC;
END
GO

IF OBJECT_ID('sp_AddInvoice') IS NOT NULL DROP PROCEDURE sp_AddInvoice;
GO
CREATE PROCEDURE sp_AddInvoice
    @Customer_ID INT,
    @Meter_ID INT,
    @Period_ID INT,
    @Tariff_ID INT,
    @Previous_Reading DECIMAL(18,2),
    @Current_Reading DECIMAL(18,2),
    @Current_Amount DECIMAL(18,2),
    @Previous_Balance DECIMAL(18,2)
AS
BEGIN
    INSERT INTO Invoices(Customer_ID, Meter_ID, Period_ID, Tariff_ID,
        Previous_Reading, Current_Reading, Current_Amount, Previous_Balance)
    VALUES(@Customer_ID, @Meter_ID, @Period_ID, @Tariff_ID,
        @Previous_Reading, @Current_Reading, @Current_Amount, @Previous_Balance);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

IF OBJECT_ID('sp_UpdateInvoiceStatus') IS NOT NULL DROP PROCEDURE sp_UpdateInvoiceStatus;
GO
CREATE PROCEDURE sp_UpdateInvoiceStatus
    @Invoice_ID INT,
    @Is_Paid BIT
AS
BEGIN
    UPDATE Invoices SET Is_Paid = @Is_Paid WHERE Invoice_ID = @Invoice_ID;
END
GO

-- ========== المدفوعات (Payments) ==========
IF OBJECT_ID('sp_GetAllPayments') IS NOT NULL DROP PROCEDURE sp_GetAllPayments;
GO
CREATE PROCEDURE sp_GetAllPayments
AS
BEGIN
    SELECT p.*, c.Customer_Name
    FROM Payments p INNER JOIN Customers c ON p.Customer_ID = c.Customer_ID
    ORDER BY p.Payment_ID DESC;
END
GO

IF OBJECT_ID('sp_GetPaymentsByCustomer') IS NOT NULL DROP PROCEDURE sp_GetPaymentsByCustomer;
GO
CREATE PROCEDURE sp_GetPaymentsByCustomer @Customer_ID INT
AS
BEGIN
    SELECT * FROM Payments WHERE Customer_ID = @Customer_ID ORDER BY Payment_Date DESC;
END
GO

IF OBJECT_ID('sp_AddPayment') IS NOT NULL DROP PROCEDURE sp_AddPayment;
GO
CREATE PROCEDURE sp_AddPayment
    @Customer_ID INT,
    @Invoice_ID INT = NULL,
    @Amount DECIMAL(18,2),
    @Payment_Method NVARCHAR(50) = NULL,
    @Reference_No NVARCHAR(50) = NULL
AS
BEGIN
    INSERT INTO Payments(Customer_ID, Invoice_ID, Amount, Payment_Method, Reference_No)
    VALUES(@Customer_ID, @Invoice_ID, @Amount, @Payment_Method, @Reference_No);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

-- ========== الحسابات (Accounts) ==========
IF OBJECT_ID('sp_GetAllAccounts') IS NOT NULL DROP PROCEDURE sp_GetAllAccounts;
GO
CREATE PROCEDURE sp_GetAllAccounts
AS
BEGIN
    SELECT * FROM Accounts ORDER BY Account_ID;
END
GO

IF OBJECT_ID('sp_AddAccount') IS NOT NULL DROP PROCEDURE sp_AddAccount;
GO
CREATE PROCEDURE sp_AddAccount
    @Account_Name NVARCHAR(200),
    @Account_Type NVARCHAR(50),
    @Balance_Type NVARCHAR(10)
AS
BEGIN
    INSERT INTO Accounts(Account_Name, Account_Type, Balance_Type)
    VALUES(@Account_Name, @Account_Type, @Balance_Type);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

IF OBJECT_ID('sp_UpdateAccount') IS NOT NULL DROP PROCEDURE sp_UpdateAccount;
GO
CREATE PROCEDURE sp_UpdateAccount
    @Account_ID INT,
    @Account_Name NVARCHAR(200),
    @Account_Type NVARCHAR(50),
    @Balance_Type NVARCHAR(10)
AS
BEGIN
    UPDATE Accounts SET Account_Name=@Account_Name, Account_Type=@Account_Type,
        Balance_Type=@Balance_Type
    WHERE Account_ID=@Account_ID;
END
GO

IF OBJECT_ID('sp_DeleteAccount') IS NOT NULL DROP PROCEDURE sp_DeleteAccount;
GO
CREATE PROCEDURE sp_DeleteAccount @Account_ID INT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Journal_Entry_Lines WHERE Account_ID=@Account_ID)
        DELETE FROM Accounts WHERE Account_ID=@Account_ID;
    ELSE
        RAISERROR(N'لا يمكن حذف الحساب لوجود قيود مرتبطة',16,1);
END
GO

-- ========== القيود المحاسبية (Journal_Entries) ==========
IF OBJECT_ID('sp_GetAllJournalEntries') IS NOT NULL DROP PROCEDURE sp_GetAllJournalEntries;
GO
CREATE PROCEDURE sp_GetAllJournalEntries
AS
BEGIN
    SELECT * FROM Journal_Entries ORDER BY Entry_ID DESC;
END
GO

IF OBJECT_ID('sp_GetJournalEntryLines') IS NOT NULL DROP PROCEDURE sp_GetJournalEntryLines;
GO
CREATE PROCEDURE sp_GetJournalEntryLines @Entry_ID INT
AS
BEGIN
    SELECT jl.*, a.Account_Name
    FROM Journal_Entry_Lines jl INNER JOIN Accounts a ON jl.Account_ID = a.Account_ID
    WHERE jl.Entry_ID = @Entry_ID;
END
GO

IF OBJECT_ID('sp_AddJournalEntry') IS NOT NULL DROP PROCEDURE sp_AddJournalEntry;
GO
CREATE PROCEDURE sp_AddJournalEntry
    @Description NVARCHAR(MAX),
    @Total_Debit DECIMAL(18,2),
    @Total_Credit DECIMAL(18,2)
AS
BEGIN
    IF @Total_Debit <> @Total_Credit
        RAISERROR(N'مجموع المدين يجب أن يساوي مجموع الدائن',16,1);
    ELSE
    BEGIN
        INSERT INTO Journal_Entries(Description, Total_Debit, Total_Credit)
        VALUES(@Description, @Total_Debit, @Total_Credit);
        SELECT SCOPE_IDENTITY() AS NewID;
    END
END
GO

IF OBJECT_ID('sp_AddJournalEntryLine') IS NOT NULL DROP PROCEDURE sp_AddJournalEntryLine;
GO
CREATE PROCEDURE sp_AddJournalEntryLine
    @Entry_ID INT,
    @Account_ID INT,
    @Debit DECIMAL(18,2) = 0,
    @Credit DECIMAL(18,2) = 0
AS
BEGIN
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit)
    VALUES(@Entry_ID, @Account_ID, @Debit, @Credit);
END
GO

-- ========== الأصول الثابتة (Fixed_Assets) ==========
IF OBJECT_ID('sp_GetAllAssets') IS NOT NULL DROP PROCEDURE sp_GetAllAssets;
GO
CREATE PROCEDURE sp_GetAllAssets
AS
BEGIN
    SELECT * FROM Fixed_Assets ORDER BY Asset_ID DESC;
END
GO

IF OBJECT_ID('sp_AddAsset') IS NOT NULL DROP PROCEDURE sp_AddAsset;
GO
CREATE PROCEDURE sp_AddAsset
    @Asset_Name NVARCHAR(200),
    @Asset_Type NVARCHAR(50) = NULL,
    @Purchase_Value DECIMAL(18,2) = 0,
    @Account_ID INT = NULL
AS
BEGIN
    INSERT INTO Fixed_Assets(Asset_Name, Asset_Type, Purchase_Value, Account_ID)
    VALUES(@Asset_Name, @Asset_Type, @Purchase_Value, @Account_ID);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

IF OBJECT_ID('sp_UpdateAsset') IS NOT NULL DROP PROCEDURE sp_UpdateAsset;
GO
CREATE PROCEDURE sp_UpdateAsset
    @Asset_ID INT,
    @Asset_Name NVARCHAR(200),
    @Asset_Type NVARCHAR(50) = NULL,
    @Purchase_Value DECIMAL(18,2) = 0,
    @Account_ID INT = NULL
AS
BEGIN
    UPDATE Fixed_Assets SET Asset_Name=@Asset_Name, Asset_Type=@Asset_Type,
        Purchase_Value=@Purchase_Value, Account_ID=@Account_ID
    WHERE Asset_ID=@Asset_ID;
END
GO

IF OBJECT_ID('sp_DeleteAsset') IS NOT NULL DROP PROCEDURE sp_DeleteAsset;
GO
CREATE PROCEDURE sp_DeleteAsset @Asset_ID INT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Fuel_Consumption WHERE Asset_ID=@Asset_ID)
        DELETE FROM Fixed_Assets WHERE Asset_ID=@Asset_ID;
    ELSE
        RAISERROR(N'لا يمكن حذف الأصل لوجود سجلات وقود مرتبطة',16,1);
END
GO

-- ========== استهلاك الوقود (Fuel_Consumption) ==========
IF OBJECT_ID('sp_GetAllFuelConsumption') IS NOT NULL DROP PROCEDURE sp_GetAllFuelConsumption;
GO
CREATE PROCEDURE sp_GetAllFuelConsumption
AS
BEGIN
    SELECT fc.*, fa.Asset_Name
    FROM Fuel_Consumption fc INNER JOIN Fixed_Assets fa ON fc.Asset_ID = fa.Asset_ID
    ORDER BY fc.Log_ID DESC;
END
GO

IF OBJECT_ID('sp_AddFuelConsumption') IS NOT NULL DROP PROCEDURE sp_AddFuelConsumption;
GO
CREATE PROCEDURE sp_AddFuelConsumption
    @Asset_ID INT,
    @Transaction_Type NVARCHAR(20) = N'استهلاك',
    @Quantity_Used DECIMAL(18,2),
    @Cost DECIMAL(18,2) = 0
AS
BEGIN
    INSERT INTO Fuel_Consumption(Asset_ID, Transaction_Type, Quantity_Used, Cost)
    VALUES(@Asset_ID, @Transaction_Type, @Quantity_Used, @Cost);
    SELECT SCOPE_IDENTITY() AS NewID;
END
GO

IF OBJECT_ID('sp_DeleteFuelConsumption') IS NOT NULL DROP PROCEDURE sp_DeleteFuelConsumption;
GO
CREATE PROCEDURE sp_DeleteFuelConsumption @Log_ID INT
AS
BEGIN
    DELETE FROM Fuel_Consumption WHERE Log_ID = @Log_ID;
END
GO

-- ========== المستخدمون (Users) ==========
IF OBJECT_ID('sp_Login') IS NOT NULL DROP PROCEDURE sp_Login;
GO
CREATE PROCEDURE sp_Login
    @UserName NVARCHAR(50),
    @Password NVARCHAR(100)
AS
BEGIN
    SELECT u.*, r.Role_Name
    FROM Users u INNER JOIN Roles r ON u.Role_ID = r.Role_ID
    WHERE u.UserName = @UserName AND u.Password = @Password AND u.IsActive = 1;
END
GO

IF OBJECT_ID('sp_GetAllUsers') IS NOT NULL DROP PROCEDURE sp_GetAllUsers;
GO
CREATE PROCEDURE sp_GetAllUsers
AS
BEGIN
    SELECT u.User_ID, u.UserName, u.FullName, u.IsActive, r.Role_Name
    FROM Users u INNER JOIN Roles r ON u.Role_ID = r.Role_ID;
END
GO

IF OBJECT_ID('sp_AddUser') IS NOT NULL DROP PROCEDURE sp_AddUser;
GO
CREATE PROCEDURE sp_AddUser
    @UserName NVARCHAR(50),
    @Password NVARCHAR(100),
    @FullName NVARCHAR(100) = NULL,
    @Role_ID INT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM Users WHERE UserName=@UserName)
    BEGIN
        INSERT INTO Users(UserName, Password, FullName, Role_ID)
        VALUES(@UserName, @Password, @FullName, @Role_ID);
        SELECT SCOPE_IDENTITY() AS NewID;
    END
    ELSE
        RAISERROR(N'اسم المستخدم موجود مسبقاً',16,1);
END
GO

-- ========== تقارير (Reports) ==========
IF OBJECT_ID('sp_GetCustomerLedger') IS NOT NULL DROP PROCEDURE sp_GetCustomerLedger;
GO
CREATE PROCEDURE sp_GetCustomerLedger @Customer_ID INT
AS
BEGIN
    SELECT 'فاتورة' AS Type, Invoice_Date AS Date, Total_Balance AS Debit, 0 AS Credit, Invoice_ID AS RefID
    FROM Invoices WHERE Customer_ID = @Customer_ID
    UNION ALL
    SELECT 'دفعة' AS Type, Payment_Date AS Date, 0 AS Debit, Amount AS Credit, Payment_ID AS RefID
    FROM Payments WHERE Customer_ID = @Customer_ID
    ORDER BY Date;
END
GO

IF OBJECT_ID('sp_GetDashboardStats') IS NOT NULL DROP PROCEDURE sp_GetDashboardStats;
GO
CREATE PROCEDURE sp_GetDashboardStats
AS
BEGIN
    SELECT
        (SELECT COUNT(*) FROM Customers WHERE Status=1) AS TotalCustomers,
        (SELECT COUNT(*) FROM Invoices) AS TotalInvoices,
        (SELECT ISNULL(SUM(Current_Amount),0) FROM Invoices) AS TotalRevenue,
        (SELECT ISNULL(SUM(Total_Balance),0) FROM Invoices WHERE Is_Paid=0) AS TotalDebts,
        (SELECT ISNULL(SUM(Amount),0) FROM Payments) AS TotalPayments;
END
GO

-- =============================================
-- 4) بيانات افتراضية
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Roles)
BEGIN
    INSERT INTO Roles(Role_Name) VALUES(N'مدير');
    INSERT INTO Roles(Role_Name) VALUES(N'مستخدم');
    INSERT INTO Roles(Role_Name) VALUES(N'قارئ عدادات');
END

IF NOT EXISTS (SELECT 1 FROM Users)
BEGIN
    INSERT INTO Users(UserName, Password, FullName, Role_ID)
    VALUES('admin', 'admin123', N'مدير النظام', 1);
END

IF NOT EXISTS (SELECT 1 FROM Accounts)
BEGIN
    INSERT INTO Accounts(Account_Name, Account_Type, Balance_Type) VALUES(N'الصندوق', N'أصول', N'مدين');
    INSERT INTO Accounts(Account_Name, Account_Type, Balance_Type) VALUES(N'البنك', N'أصول', N'مدين');
    INSERT INTO Accounts(Account_Name, Account_Type, Balance_Type) VALUES(N'إيرادات الكهرباء', N'إيرادات', N'دائن');
    INSERT INTO Accounts(Account_Name, Account_Type, Balance_Type) VALUES(N'ذمم المشتركين', N'أصول', N'مدين');
    INSERT INTO Accounts(Account_Name, Account_Type, Balance_Type) VALUES(N'مصاريف الوقود', N'مصروفات', N'مدين');
    INSERT INTO Accounts(Account_Name, Account_Type, Balance_Type) VALUES(N'الأصول الثابتة', N'أصول', N'مدين');
END

PRINT N'تم إنشاء قاعدة البيانات والجداول والإجراءات المخزنة بنجاح!';
GO
