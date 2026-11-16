using System;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmReports : Form
    {
        private CustomerDAL customerDAL = new CustomerDAL();

        public FrmReports()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgvReport);
            LoadCustomers();
        }

        private void LoadCustomers()
        {
            try
            {
                cmbCustomer.DataSource = customerDAL.GetAll();
                cmbCustomer.DisplayMember = "Customer_Name";
                cmbCustomer.ValueMember = "Customer_ID";
                cmbCustomer.SelectedIndex = -1;
            }
            catch { }
        }

        // ==================== تقرير كشف حساب مشترك ====================
        private void BtnLedger_Click(object sender, EventArgs e)
        {
            if (cmbCustomer.SelectedIndex < 0) { UIHelper.ShowError("يرجى اختيار المشترك"); return; }
            try
            {
                int cid = (int)cmbCustomer.SelectedValue;
                string sql = @"
                    SELECT N'رصيد افتتاحي' AS النوع, NULL AS التاريخ, 
                        CASE WHEN Opening_Balance > 0 THEN Opening_Balance ELSE 0 END AS مدين,
                        CASE WHEN Opening_Balance < 0 THEN ABS(Opening_Balance) ELSE 0 END AS دائن,
                        NULL AS المرجع
                    FROM Customers WHERE Customer_ID = @CID AND Opening_Balance <> 0
                    UNION ALL
                    SELECT N'فاتورة كهرباء' AS النوع, Invoice_Date AS التاريخ, 
                        Current_Amount AS مدين, 0 AS دائن, 
                        CAST(Invoice_ID AS NVARCHAR) AS المرجع
                    FROM Invoices WHERE Customer_ID = @CID
                    UNION ALL
                    SELECT N'دفعة' AS النوع, Payment_Date AS التاريخ, 
                        0 AS مدين, Amount AS دائن, 
                        CAST(Payment_ID AS NVARCHAR) AS المرجع
                    FROM Payments WHERE Customer_ID = @CID
                    ORDER BY التاريخ";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql, new SqlParameter("@CID", cid));
                lblReportTitle.Text = "كشف حساب: " + cmbCustomer.Text;
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        // ==================== تقرير جميع الفواتير ====================
        private void BtnAllInvoices_Click(object sender, EventArgs e)
        {
            try
            {
                string sql = @"SELECT i.Invoice_ID AS [رقم الفاتورة], c.Customer_Name AS [المشترك], 
                    m.Meter_No AS [العداد], bp.Period_Name AS [الفترة],
                    i.Previous_Reading AS [قراءة سابقة], i.Current_Reading AS [قراءة حالية],
                    i.Consumption AS [الاستهلاك], i.Current_Amount AS [المبلغ],
                    i.Previous_Balance AS [رصيد سابق], i.Total_Balance AS [الإجمالي],
                    i.Invoice_Date AS [التاريخ],
                    CASE WHEN i.Is_Paid = 1 THEN N'مدفوعة' ELSE N'غير مدفوعة' END AS [الحالة]
                    FROM Invoices i
                    INNER JOIN Customers c ON i.Customer_ID = c.Customer_ID
                    INNER JOIN Meters m ON i.Meter_ID = m.Meter_ID
                    INNER JOIN Billing_Periods bp ON i.Period_ID = bp.Period_ID
                    ORDER BY i.Invoice_ID DESC";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql);
                lblReportTitle.Text = "أرشيف جميع الفواتير";
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        // ==================== تقرير المديونيات ====================
        private void BtnDebts_Click(object sender, EventArgs e)
        {
            try
            {
                string sql = @"SELECT c.Customer_ID AS [رقم المشترك], c.Customer_Name AS [المشترك], 
                    c.Phone AS [الهاتف],
                    ISNULL(c.Opening_Balance, 0) AS [الرصيد الافتتاحي],
                    ISNULL((SELECT SUM(Current_Amount) FROM Invoices WHERE Customer_ID = c.Customer_ID), 0) AS [إجمالي الفواتير],
                    ISNULL((SELECT SUM(Amount) FROM Payments WHERE Customer_ID = c.Customer_ID), 0) AS [إجمالي المدفوعات],
                    ISNULL(c.Opening_Balance, 0) + 
                        ISNULL((SELECT SUM(Current_Amount) FROM Invoices WHERE Customer_ID = c.Customer_ID), 0) -
                        ISNULL((SELECT SUM(Amount) FROM Payments WHERE Customer_ID = c.Customer_ID), 0) AS [المتبقي]
                    FROM Customers c
                    WHERE (ISNULL(c.Opening_Balance, 0) + 
                        ISNULL((SELECT SUM(Current_Amount) FROM Invoices WHERE Customer_ID = c.Customer_ID), 0) -
                        ISNULL((SELECT SUM(Amount) FROM Payments WHERE Customer_ID = c.Customer_ID), 0)) > 0
                    ORDER BY [المتبقي] DESC";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql);
                lblReportTitle.Text = "تقرير المديونيات والديون المستحقة";
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        // ==================== تقرير المدفوعات ====================
        private void BtnPayments_Click(object sender, EventArgs e)
        {
            try
            {
                string sql = @"SELECT p.Payment_ID AS [رقم السند], c.Customer_Name AS [المشترك],
                    p.Amount AS [المبلغ], p.Payment_Date AS [التاريخ],
                    ISNULL(p.Payment_Method, N'نقدي') AS [طريقة الدفع],
                    ISNULL(p.Reference_No, N'-') AS [رقم المرجع],
                    ISNULL(CAST(p.Invoice_ID AS NVARCHAR), N'-') AS [رقم الفاتورة]
                    FROM Payments p
                    INNER JOIN Customers c ON p.Customer_ID = c.Customer_ID
                    ORDER BY p.Payment_ID DESC";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql);
                lblReportTitle.Text = "تقرير المدفوعات وسندات القبض";
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        // ==================== تقرير القيود المحاسبية ====================
        private void BtnJournalReport_Click(object sender, EventArgs e)
        {
            try
            {
                string sql = @"SELECT je.Entry_ID AS [رقم القيد], je.Entry_Date AS [التاريخ],
                    je.Description AS [الوصف], je.Total_Debit AS [إجمالي المدين],
                    je.Total_Credit AS [إجمالي الدائن]
                    FROM Journal_Entries je ORDER BY je.Entry_ID DESC";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql);
                lblReportTitle.Text = "تقرير القيود المحاسبية";
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        // ==================== تقرير الأصول الثابتة ====================
        private void BtnAssetsReport_Click(object sender, EventArgs e)
        {
            try
            {
                string sql = @"SELECT fa.Asset_ID AS [الرقم], fa.Asset_Name AS [اسم الأصل],
                    fa.Asset_Type AS [النوع], fa.Purchase_Value AS [قيمة الشراء],
                    fa.Purchase_Date AS [تاريخ الشراء],
                    ISNULL((SELECT SUM(Cost) FROM Fuel_Consumption WHERE Asset_ID = fa.Asset_ID), 0) AS [تكلفة الوقود الإجمالية]
                    FROM Fixed_Assets fa ORDER BY fa.Asset_ID";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql);
                lblReportTitle.Text = "تقرير الأصول الثابتة وتكاليفها";
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        // ==================== تقرير ملخص عام ====================
        private void BtnSummary_Click(object sender, EventArgs e)
        {
            try
            {
                string sql = @"SELECT 
                    N'عدد المشتركين' AS البيان, CAST(COUNT(*) AS NVARCHAR) AS القيمة FROM Customers WHERE Status=1
                    UNION ALL
                    SELECT N'عدد الفواتير', CAST(COUNT(*) AS NVARCHAR) FROM Invoices
                    UNION ALL
                    SELECT N'الفواتير غير المسددة', CAST(COUNT(*) AS NVARCHAR) FROM Invoices WHERE Is_Paid=0
                    UNION ALL
                    SELECT N'إجمالي الإيرادات', CAST(ISNULL(SUM(Current_Amount),0) AS NVARCHAR) FROM Invoices
                    UNION ALL
                    SELECT N'إجمالي المدفوعات', CAST(ISNULL(SUM(Amount),0) AS NVARCHAR) FROM Payments
                    UNION ALL
                    SELECT N'إجمالي المديونيات', CAST(
                        ISNULL((SELECT SUM(ISNULL(Opening_Balance,0)) FROM Customers),0) +
                        ISNULL((SELECT SUM(Current_Amount) FROM Invoices),0) -
                        ISNULL((SELECT SUM(Amount) FROM Payments),0) AS NVARCHAR)
                    UNION ALL
                    SELECT N'عدد العدادات', CAST(COUNT(*) AS NVARCHAR) FROM Meters WHERE Status=1
                    UNION ALL
                    SELECT N'عدد الأصول الثابتة', CAST(COUNT(*) AS NVARCHAR) FROM Fixed_Assets
                    UNION ALL
                    SELECT N'قيمة الأصول الثابتة', CAST(ISNULL(SUM(Purchase_Value),0) AS NVARCHAR) FROM Fixed_Assets";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql);
                lblReportTitle.Text = "ملخص عام للنظام";
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        // ==================== تقرير استهلاك الوقود ====================
        private void BtnFuelReport_Click(object sender, EventArgs e)
        {
            try
            {
                string sql = @"SELECT fc.Log_ID AS [الرقم], fa.Asset_Name AS [الأصل],
                    fc.Transaction_Type AS [النوع], fc.Quantity_Used AS [الكمية],
                    fc.Cost AS [التكلفة], fc.Log_Date AS [التاريخ]
                    FROM Fuel_Consumption fc
                    INNER JOIN Fixed_Assets fa ON fc.Asset_ID = fa.Asset_ID
                    ORDER BY fc.Log_ID DESC";
                dgvReport.DataSource = ConnectionHelper.ExecuteQueryText(sql);
                lblReportTitle.Text = "تقرير استهلاك الوقود";
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
