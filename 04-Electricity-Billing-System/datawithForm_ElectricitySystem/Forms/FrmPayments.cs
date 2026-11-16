using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.BLL;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmPayments : Form
    {
        private CustomerDAL customerDAL = new CustomerDAL();
        private InvoiceDAL invoiceDAL = new InvoiceDAL();
        private PaymentBLL paymentBLL = new PaymentBLL();
        private PaymentDAL paymentDAL = new PaymentDAL();

        public FrmPayments()
        {
            InitializeComponent();
            LoadData();
            UIHelper.StyleDataGridView(dgvPayments);
            UIHelper.SetupColumns(dgvPayments, new string[,] {
                {"Payment_ID", "رقم الدفعة"},
                {"Customer_Name", "المشترك"},
                {"Invoice_ID", "رقم الفاتورة"},
                {"Amount", "المبلغ المدفوع"},
                {"Payment_Date", "التاريخ"},
                {"Payment_Method", "طريقة الدفع"},
                {"Reference_No", "رقم المرجع"}
            });
        }

        private void LoadData()
        {
            try
            {
                cmbCustomer.DataSource = customerDAL.GetAll();
                cmbCustomer.DisplayMember = "Customer_Name";
                cmbCustomer.ValueMember = "Customer_ID";
                cmbCustomer.SelectedIndex = -1;
                dgvPayments.DataSource = paymentBLL.GetAllPayments();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void CmbCustomer_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmbCustomer.SelectedValue == null || !(cmbCustomer.SelectedValue is int)) return;
            try
            {
                int customerID = (int)cmbCustomer.SelectedValue;

                // تحميل الفواتير غير المسددة
                DataTable unpaid = invoiceDAL.GetUnpaidByCustomer(customerID);
                cmbInvoice.DataSource = unpaid;
                cmbInvoice.DisplayMember = "DisplayText";
                cmbInvoice.ValueMember = "Invoice_ID";
                if (cmbInvoice.Items.Count > 0) cmbInvoice.SelectedIndex = 0;

                // عرض إجمالي رصيد المشترك
                decimal balance = invoiceDAL.GetCustomerBalance(customerID);
                lblTotalDebt.Text = "إجمالي المديونية: " + balance.ToString("N2") + " ريال";
            }
            catch { }
        }

        private void CmbInvoice_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmbInvoice.SelectedValue == null || !(cmbInvoice.SelectedValue is int)) return;
            try
            {
                int invoiceID = (int)cmbInvoice.SelectedValue;

                // جلب تفاصيل الفاتورة
                DataTable details = invoiceDAL.GetInvoiceDetails(invoiceID);
                if (details.Rows.Count > 0)
                {
                    DataRow row = details.Rows[0];
                    decimal totalAmount = 0;
                    if (details.Columns.Contains("Current_Amount"))
                        totalAmount = Convert.ToDecimal(row["Current_Amount"]);

                    decimal prevBalance = 0;
                    if (details.Columns.Contains("Previous_Balance"))
                        prevBalance = Convert.ToDecimal(row["Previous_Balance"]);

                    decimal invoiceTotal = totalAmount + prevBalance;
                    decimal totalPaid = paymentDAL.GetTotalPaidForInvoice(invoiceID);
                    decimal remaining = invoiceTotal - totalPaid;

                    lblInvoiceTotal.Text = "إجمالي الفاتورة: " + invoiceTotal.ToString("N2") + " ريال";
                    lblPaid.Text = "المدفوع: " + totalPaid.ToString("N2") + " ريال";
                    lblRemaining.Text = "المتبقي: " + remaining.ToString("N2") + " ريال";

                    // تعبئة المبلغ المتبقي تلقائياً
                    if (remaining > 0) txtAmount.Text = remaining.ToString("N2");
                }
            }
            catch { }
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (cmbCustomer.SelectedIndex < 0)
            {
                UIHelper.ShowError("يرجى اختيار المشترك");
                return;
            }
            decimal amount = 0;
            if (!decimal.TryParse(txtAmount.Text, out amount) || amount <= 0)
            {
                UIHelper.ShowError("يرجى إدخال مبلغ صحيح");
                return;
            }
            try
            {
                int? invID = null;
                if (cmbInvoice.SelectedValue != null)
                    invID = Convert.ToInt32(cmbInvoice.SelectedValue);

                paymentBLL.AddPayment((int)cmbCustomer.SelectedValue, invID, amount, txtMethod.Text.Trim(), txtReference.Text.Trim());
                UIHelper.ShowSuccess("تم تسجيل الدفعة بنجاح");
                txtAmount.Clear();
                txtReference.Clear();
                dgvPayments.DataSource = paymentBLL.GetAllPayments();
                FormatGrid();

                // تحديث تفاصيل الفاتورة بعد الدفع
                if (cmbInvoice.SelectedValue != null)
                    CmbInvoice_SelectedIndexChanged(null, null);
                if (cmbCustomer.SelectedValue is int)
                {
                    int cid = (int)cmbCustomer.SelectedValue;
                    decimal balance = invoiceDAL.GetCustomerBalance(cid);
                    lblTotalDebt.Text = "إجمالي المديونية: " + balance.ToString("N2") + " ريال";
                }
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
