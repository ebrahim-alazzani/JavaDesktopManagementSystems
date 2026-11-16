-- =============================================
-- نظام الكهرباء - بيانات تجريبية للاختبار
-- يُنفذ بعد سكربت CreateDatabase.sql
-- =============================================

USE EElectricitySystem;
GO

PRINT N'===== بدء إدخال البيانات التجريبية =====';

-- =============================================
-- 1) التعرفة (Tariffs)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Tariffs)
BEGIN
    INSERT INTO Tariffs(Tariff_Name, Price_Per_Unit, Fixed_Fee, Is_Active)
    VALUES(N'تعرفة منزلية', 15.00, 50.00, 1);

    INSERT INTO Tariffs(Tariff_Name, Price_Per_Unit, Fixed_Fee, Is_Active)
    VALUES(N'تعرفة تجارية', 25.00, 100.00, 1);

    INSERT INTO Tariffs(Tariff_Name, Price_Per_Unit, Fixed_Fee, Is_Active)
    VALUES(N'تعرفة صناعية', 35.00, 200.00, 1);

    PRINT N'✅ تم إدخال 3 تعرفات';
END
GO

-- =============================================
-- 2) المشتركين (Customers) - 3 مشتركين
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Customers)
BEGIN
    INSERT INTO Customers(Customer_Name, Phone, Address, Opening_Balance, Status)
    VALUES(N'أحمد محمد علي', N'0777123456', N'حي النسيم - شارع الملك فهد', 0, 1);

    INSERT INTO Customers(Customer_Name, Phone, Address, Opening_Balance, Status)
    VALUES(N'خالد عبدالله سعيد', N'0778234567', N'حي الروضة - شارع التحلية', 150.00, 1);

    INSERT INTO Customers(Customer_Name, Phone, Address, Opening_Balance, Status)
    VALUES(N'فاطمة حسن أحمد', N'0779345678', N'حي الزهراء - شارع الأمير سلطان', 0, 1);

    PRINT N'✅ تم إدخال 3 مشتركين';
END
GO

-- =============================================
-- 3) العدادات (Meters) - 3 عدادات
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Meters)
BEGIN
    INSERT INTO Meters(Meter_No, Customer_ID, Installation_Date, Location, Status)
    VALUES(N'MTR-001', 1, '2025-01-15', N'المنزل - الدور الأرضي', 1);

    INSERT INTO Meters(Meter_No, Customer_ID, Installation_Date, Location, Status)
    VALUES(N'MTR-002', 2, '2025-02-10', N'المحل التجاري - السوق المركزي', 1);

    INSERT INTO Meters(Meter_No, Customer_ID, Installation_Date, Location, Status)
    VALUES(N'MTR-003', 3, '2025-03-01', N'المنزل - الطابق الأول', 1);

    PRINT N'✅ تم إدخال 3 عدادات';
END
GO

-- =============================================
-- 4) فترات الفوترة (Billing_Periods) - فترتين
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Billing_Periods)
BEGIN
    INSERT INTO Billing_Periods(Period_Name, Start_Date, End_Date, Is_Closed)
    VALUES(N'يناير 2026', '2026-01-01', '2026-01-31', 1);

    INSERT INTO Billing_Periods(Period_Name, Start_Date, End_Date, Is_Closed)
    VALUES(N'فبراير 2026', '2026-02-01', '2026-02-28', 0);

    PRINT N'✅ تم إدخال فترتي فوترة';
END
GO

-- =============================================
-- 5) قراءات العدادات (Meter_Readings)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Meter_Readings)
BEGIN
    -- قراءات يناير 2026
    INSERT INTO Meter_Readings(Meter_ID, Period_ID, Reading_Value, Reading_Date)
    VALUES(1, 1, 150.00, '2026-01-31');

    INSERT INTO Meter_Readings(Meter_ID, Period_ID, Reading_Value, Reading_Date)
    VALUES(2, 1, 320.00, '2026-01-31');

    INSERT INTO Meter_Readings(Meter_ID, Period_ID, Reading_Value, Reading_Date)
    VALUES(3, 1, 200.00, '2026-01-31');

    -- قراءات فبراير 2026
    INSERT INTO Meter_Readings(Meter_ID, Period_ID, Reading_Value, Reading_Date)
    VALUES(1, 2, 280.00, '2026-02-28');

    INSERT INTO Meter_Readings(Meter_ID, Period_ID, Reading_Value, Reading_Date)
    VALUES(2, 2, 510.00, '2026-02-28');

    INSERT INTO Meter_Readings(Meter_ID, Period_ID, Reading_Value, Reading_Date)
    VALUES(3, 2, 350.00, '2026-02-28');

    PRINT N'✅ تم إدخال 6 قراءات عدادات';
END
GO

-- =============================================
-- 6) الفواتير (Invoices)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Invoices)
BEGIN
    -- فواتير يناير 2026
    -- أحمد: استهلاك 150 × 15 + 50 = 2300
    INSERT INTO Invoices(Customer_ID, Meter_ID, Period_ID, Tariff_ID, Previous_Reading, Current_Reading, Current_Amount, Previous_Balance, Is_Paid)
    VALUES(1, 1, 1, 1, 0, 150, 2300.00, 0, 1);

    -- خالد: استهلاك 320 × 25 + 100 = 8100
    INSERT INTO Invoices(Customer_ID, Meter_ID, Period_ID, Tariff_ID, Previous_Reading, Current_Reading, Current_Amount, Previous_Balance, Is_Paid)
    VALUES(2, 2, 1, 2, 0, 320, 8100.00, 150.00, 0);

    -- فاطمة: استهلاك 200 × 15 + 50 = 3050
    INSERT INTO Invoices(Customer_ID, Meter_ID, Period_ID, Tariff_ID, Previous_Reading, Current_Reading, Current_Amount, Previous_Balance, Is_Paid)
    VALUES(3, 3, 1, 1, 0, 200, 3050.00, 0, 1);

    -- فواتير فبراير 2026
    -- أحمد: استهلاك 130 × 15 + 50 = 2000
    INSERT INTO Invoices(Customer_ID, Meter_ID, Period_ID, Tariff_ID, Previous_Reading, Current_Reading, Current_Amount, Previous_Balance, Is_Paid)
    VALUES(1, 1, 2, 1, 150, 280, 2000.00, 0, 0);

    -- خالد: استهلاك 190 × 25 + 100 = 4850
    INSERT INTO Invoices(Customer_ID, Meter_ID, Period_ID, Tariff_ID, Previous_Reading, Current_Reading, Current_Amount, Previous_Balance, Is_Paid)
    VALUES(2, 2, 2, 2, 320, 510, 4850.00, 8250.00, 0);

    -- فاطمة: استهلاك 150 × 15 + 50 = 2300
    INSERT INTO Invoices(Customer_ID, Meter_ID, Period_ID, Tariff_ID, Previous_Reading, Current_Reading, Current_Amount, Previous_Balance, Is_Paid)
    VALUES(3, 3, 2, 1, 200, 350, 2300.00, 0, 0);

    PRINT N'✅ تم إدخال 6 فواتير (3 يناير + 3 فبراير)';
END
GO

-- =============================================
-- 7) المدفوعات (Payments)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Payments)
BEGIN
    -- أحمد دفع فاتورة يناير كاملة
    INSERT INTO Payments(Customer_ID, Invoice_ID, Amount, Payment_Date, Payment_Method, Reference_No)
    VALUES(1, 1, 2300.00, '2026-02-05', N'نقدي', N'PAY-001');

    -- فاطمة دفعت فاتورة يناير كاملة
    INSERT INTO Payments(Customer_ID, Invoice_ID, Amount, Payment_Date, Payment_Method, Reference_No)
    VALUES(3, 3, 3050.00, '2026-02-10', N'تحويل بنكي', N'PAY-002');

    -- خالد دفع جزء من فاتورة يناير
    INSERT INTO Payments(Customer_ID, Invoice_ID, Amount, Payment_Date, Payment_Method, Reference_No)
    VALUES(2, 2, 5000.00, '2026-02-15', N'نقدي', N'PAY-003');

    -- أحمد دفعة مقدمة
    INSERT INTO Payments(Customer_ID, Invoice_ID, Amount, Payment_Date, Payment_Method, Reference_No)
    VALUES(1, NULL, 1000.00, '2026-03-01', N'نقدي', N'PAY-004');

    PRINT N'✅ تم إدخال 4 مدفوعات';
END
GO

-- =============================================
-- 8) القيود المحاسبية (Journal Entries + Lines)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Journal_Entries)
BEGIN
    -- قيد فاتورة أحمد يناير
    INSERT INTO Journal_Entries(Entry_Date, Description, Total_Debit, Total_Credit)
    VALUES('2026-01-31', N'فاتورة كهرباء - أحمد محمد - يناير 2026', 2300.00, 2300.00);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(1, 4, 2300.00, 0); -- ذمم المشتركين مدين
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(1, 3, 0, 2300.00); -- إيرادات دائن

    -- قيد فاتورة خالد يناير
    INSERT INTO Journal_Entries(Entry_Date, Description, Total_Debit, Total_Credit)
    VALUES('2026-01-31', N'فاتورة كهرباء - خالد عبدالله - يناير 2026', 8100.00, 8100.00);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(2, 4, 8100.00, 0);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(2, 3, 0, 8100.00);

    -- قيد فاتورة فاطمة يناير
    INSERT INTO Journal_Entries(Entry_Date, Description, Total_Debit, Total_Credit)
    VALUES('2026-01-31', N'فاتورة كهرباء - فاطمة حسن - يناير 2026', 3050.00, 3050.00);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(3, 4, 3050.00, 0);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(3, 3, 0, 3050.00);

    -- قيد تحصيل دفعة أحمد
    INSERT INTO Journal_Entries(Entry_Date, Description, Total_Debit, Total_Credit)
    VALUES('2026-02-05', N'تحصيل دفعة - أحمد محمد - فاتورة يناير', 2300.00, 2300.00);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(4, 1, 2300.00, 0); -- الصندوق مدين
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(4, 4, 0, 2300.00); -- ذمم المشتركين دائن

    -- قيد تحصيل دفعة فاطمة (تحويل بنكي)
    INSERT INTO Journal_Entries(Entry_Date, Description, Total_Debit, Total_Credit)
    VALUES('2026-02-10', N'تحصيل دفعة - فاطمة حسن - تحويل بنكي', 3050.00, 3050.00);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(5, 2, 3050.00, 0); -- البنك مدين
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(5, 4, 0, 3050.00); -- ذمم المشتركين دائن

    -- قيد تحصيل جزئي خالد
    INSERT INTO Journal_Entries(Entry_Date, Description, Total_Debit, Total_Credit)
    VALUES('2026-02-15', N'تحصيل جزئي - خالد عبدالله', 5000.00, 5000.00);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(6, 1, 5000.00, 0);
    INSERT INTO Journal_Entry_Lines(Entry_ID, Account_ID, Debit, Credit) VALUES(6, 4, 0, 5000.00);

    PRINT N'✅ تم إدخال 6 قيود محاسبية مع تفاصيلها';
END
GO

-- =============================================
-- 9) الأصول الثابتة (Fixed_Assets)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Fixed_Assets)
BEGIN
    INSERT INTO Fixed_Assets(Asset_Name, Asset_Type, Purchase_Value, Purchase_Date, Account_ID)
    VALUES(N'مولد كهرباء ديزل 500 كيلو واط', N'مولدات', 250000.00, '2025-01-01', 6);

    INSERT INTO Fixed_Assets(Asset_Name, Asset_Type, Purchase_Value, Purchase_Date, Account_ID)
    VALUES(N'محول كهربائي 250 كيلو فولت', N'محولات', 180000.00, '2025-03-15', 6);

    INSERT INTO Fixed_Assets(Asset_Name, Asset_Type, Purchase_Value, Purchase_Date, Account_ID)
    VALUES(N'سيارة تويوتا هايلكس - صيانة', N'مركبات', 120000.00, '2025-06-01', 6);

    INSERT INTO Fixed_Assets(Asset_Name, Asset_Type, Purchase_Value, Purchase_Date, Account_ID)
    VALUES(N'جهاز قراءة العدادات الإلكتروني', N'أجهزة', 15000.00, '2025-08-10', 6);

    PRINT N'✅ تم إدخال 4 أصول ثابتة';
END
GO

-- =============================================
-- 10) استهلاك الوقود (Fuel_Consumption)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Fuel_Consumption)
BEGIN
    -- استهلاك المولد
    INSERT INTO Fuel_Consumption(Asset_ID, Transaction_Type, Quantity_Used, Cost, Log_Date)
    VALUES(1, N'استهلاك', 500.00, 7500.00, '2026-01-15');

    INSERT INTO Fuel_Consumption(Asset_ID, Transaction_Type, Quantity_Used, Cost, Log_Date)
    VALUES(1, N'استهلاك', 480.00, 7200.00, '2026-02-15');

    INSERT INTO Fuel_Consumption(Asset_ID, Transaction_Type, Quantity_Used, Cost, Log_Date)
    VALUES(1, N'تعبئة', 1000.00, 15000.00, '2026-02-01');

    -- استهلاك سيارة الصيانة
    INSERT INTO Fuel_Consumption(Asset_ID, Transaction_Type, Quantity_Used, Cost, Log_Date)
    VALUES(3, N'استهلاك', 120.00, 1800.00, '2026-01-20');

    INSERT INTO Fuel_Consumption(Asset_ID, Transaction_Type, Quantity_Used, Cost, Log_Date)
    VALUES(3, N'استهلاك', 100.00, 1500.00, '2026-02-20');

    PRINT N'✅ تم إدخال 5 سجلات استهلاك وقود';
END
GO

-- =============================================
-- 11) سندات القبض والصرف (Vouchers)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Vouchers)
BEGIN
    -- سندات قبض
    INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No, Voucher_Date)
    VALUES(N'سند قبض', 1, 1, 2300.00, N'تحصيل فاتورة يناير - أحمد محمد', N'نقدي', N'VCR-001', '2026-02-05');

    INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No, Voucher_Date)
    VALUES(N'سند قبض', 3, 2, 3050.00, N'تحصيل فاتورة يناير - فاطمة حسن', N'تحويل بنكي', N'VCR-002', '2026-02-10');

    INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No, Voucher_Date)
    VALUES(N'سند قبض', 2, 1, 5000.00, N'تحصيل جزئي - خالد عبدالله', N'نقدي', N'VCR-003', '2026-02-15');

    -- سندات صرف
    INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No, Voucher_Date)
    VALUES(N'سند صرف', NULL, 5, 7500.00, N'شراء وقود ديزل للمولد - يناير', N'نقدي', N'VPY-001', '2026-01-15');

    INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No, Voucher_Date)
    VALUES(N'سند صرف', NULL, 5, 1800.00, N'وقود سيارة الصيانة - يناير', N'نقدي', N'VPY-002', '2026-01-20');

    INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No, Voucher_Date)
    VALUES(N'سند صرف', NULL, 5, 15000.00, N'تعبئة خزان وقود المولد', N'تحويل بنكي', N'VPY-003', '2026-02-01');

    INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No, Voucher_Date)
    VALUES(N'سند صرف', NULL, 5, 3500.00, N'صيانة المولد الكهربائي', N'نقدي', N'VPY-004', '2026-02-20');

    PRINT N'✅ تم إدخال 7 سندات (3 قبض + 4 صرف)';
END
GO

-- =============================================
-- 12) مستخدمين إضافيين (Users)
-- =============================================
IF (SELECT COUNT(*) FROM Users) <= 1
BEGIN
    -- مستخدم عادي
    INSERT INTO Users(UserName, Password, FullName, Role_ID, IsActive)
    VALUES(N'user1', N'user123', N'محمد العامري', 2, 1);

    -- قارئ عدادات
    INSERT INTO Users(UserName, Password, FullName, Role_ID, IsActive)
    VALUES(N'reader1', N'reader123', N'سالم القحطاني', 3, 1);

    PRINT N'✅ تم إدخال مستخدمين إضافيين';
END
GO

-- =============================================
-- 13) سجل تدقيق تجريبي (Audit_Log)
-- =============================================
IF NOT EXISTS (SELECT 1 FROM Audit_Log)
BEGIN
    INSERT INTO Audit_Log(User_ID, Action, Table_Name, Record_ID, Action_Date, Details)
    VALUES(1, N'إضافة', N'Customers', 1, '2026-01-01', N'إضافة مشترك جديد: أحمد محمد علي');

    INSERT INTO Audit_Log(User_ID, Action, Table_Name, Record_ID, Action_Date, Details)
    VALUES(1, N'إضافة', N'Customers', 2, '2026-01-01', N'إضافة مشترك جديد: خالد عبدالله سعيد');

    INSERT INTO Audit_Log(User_ID, Action, Table_Name, Record_ID, Action_Date, Details)
    VALUES(1, N'إنشاء فاتورة', N'Invoices', 1, '2026-01-31', N'فاتورة كهرباء لأحمد محمد - يناير 2026');

    PRINT N'✅ تم إدخال سجل تدقيق تجريبي';
END
GO

-- =============================================
-- عرض ملخص البيانات المدخلة
-- =============================================
PRINT N'';
PRINT N'========================================';
PRINT N'  ملخص البيانات التجريبية المدخلة:';
PRINT N'========================================';

SELECT N'التعرفات' AS [الجدول], COUNT(*) AS [العدد] FROM Tariffs
UNION ALL
SELECT N'المشتركين', COUNT(*) FROM Customers
UNION ALL
SELECT N'العدادات', COUNT(*) FROM Meters
UNION ALL
SELECT N'فترات الفوترة', COUNT(*) FROM Billing_Periods
UNION ALL
SELECT N'قراءات العدادات', COUNT(*) FROM Meter_Readings
UNION ALL
SELECT N'الفواتير', COUNT(*) FROM Invoices
UNION ALL
SELECT N'المدفوعات', COUNT(*) FROM Payments
UNION ALL
SELECT N'الحسابات', COUNT(*) FROM Accounts
UNION ALL
SELECT N'القيود المحاسبية', COUNT(*) FROM Journal_Entries
UNION ALL
SELECT N'سطور القيود', COUNT(*) FROM Journal_Entry_Lines
UNION ALL
SELECT N'الأصول الثابتة', COUNT(*) FROM Fixed_Assets
UNION ALL
SELECT N'استهلاك الوقود', COUNT(*) FROM Fuel_Consumption
UNION ALL
SELECT N'السندات', COUNT(*) FROM Vouchers
UNION ALL
SELECT N'المستخدمين', COUNT(*) FROM Users
UNION ALL
SELECT N'سجل التدقيق', COUNT(*) FROM Audit_Log;

PRINT N'';
PRINT N'✅ تم إدخال جميع البيانات التجريبية بنجاح!';
PRINT N'========================================';
GO
