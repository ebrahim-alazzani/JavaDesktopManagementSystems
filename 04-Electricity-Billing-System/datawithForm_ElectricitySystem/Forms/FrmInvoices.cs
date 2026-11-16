using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.BLL;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmInvoices : Form
    {
        private CustomerDAL customerDAL = new CustomerDAL();
        private MeterDAL meterDAL = new MeterDAL();
        private BillingPeriodDAL periodDAL = new BillingPeriodDAL();
        private TariffDAL tariffDAL = new TariffDAL();
        private InvoiceBLL invoiceBLL = new InvoiceBLL();
        private InvoiceDAL invoiceDAL = new InvoiceDAL();

        public FrmInvoices()
        {
            InitializeComponent();
            LoadCombos();
            LoadInvoices();
            UIHelper.StyleDataGridView(dgvInvoices);
            UIHelper.SetupColumns(dgvInvoices, new string[,] {
                {"Invoice_ID", "رقم الفاتورة"},
                {"Customer_Name", "المشترك"},
                {"Meter_No", "العداد"},
                {"Period_Name", "الفترة"},
                {"Previous_Reading", "قراءة سابقة"},
                {"Current_Reading", "قراءة حالية"},
                {"Consumption", "الاستهلاك"},
                {"Current_Amount", "المبلغ"},
                {"Previous_Balance", "الرصيد السابق"},
                {"Total_Balance", "الإجمالي"},
                {"Invoice_Date", "التاريخ"},
                {"Is_Paid", "مدفوعة"}
            });
        }

        private void LoadCombos()
        {
            try
            {
                cmbCustomer.DataSource = customerDAL.GetAll();
                cmbCustomer.DisplayMember = "Customer_Name";
                cmbCustomer.ValueMember = "Customer_ID";
                cmbCustomer.SelectedIndex = -1;

                cmbPeriod.DataSource = periodDAL.GetOpen();
                cmbPeriod.DisplayMember = "Period_Name";
                cmbPeriod.ValueMember = "Period_ID";
                if (cmbPeriod.Items.Count > 0) cmbPeriod.SelectedIndex = 0;

                cmbTariff.DataSource = tariffDAL.GetActive();
                cmbTariff.DisplayMember = "Tariff_Name";
                cmbTariff.ValueMember = "Tariff_ID";
                if (cmbTariff.Items.Count > 0) cmbTariff.SelectedIndex = 0;
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void LoadInvoices()
        {
            try
            {
                dgvInvoices.DataSource = invoiceBLL.GetAllInvoices();
            }
            catch { }
        }

        private void CmbCustomer_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmbCustomer.SelectedValue == null || !(cmbCustomer.SelectedValue is int)) return;
            try
            {
                int customerID = (int)cmbCustomer.SelectedValue;

                // تحميل العدادات للمشترك
                cmbMeter.DataSource = meterDAL.GetByCustomer(customerID);
                cmbMeter.DisplayMember = "Meter_No";
                cmbMeter.ValueMember = "Meter_ID";
                if (cmbMeter.Items.Count > 0) cmbMeter.SelectedIndex = 0;

                // جلب الرصيد السابق للمشترك تلقائياً
                // يشمل الرصيد الافتتاحي + الفواتير - المدفوعات
                decimal balance = invoiceDAL.GetCustomerBalance(customerID);
                txtPrevBalance.Text = balance.ToString("N2");
            }
            catch { }
        }

        private void CmbMeter_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmbMeter.SelectedValue == null || !(cmbMeter.SelectedValue is int)) return;
            try
            {
                // جلب القراءة السابقة تلقائياً من آخر قراءة للعداد
                decimal lastReading = invoiceBLL.GetLastReading((int)cmbMeter.SelectedValue);
                txtPrevReading.Text = lastReading.ToString("N2");
            }
            catch { }
        }

        private void CmbTariff_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (cmbTariff.SelectedIndex < 0) return;
            try
            {
                DataRowView drv = cmbTariff.SelectedItem as DataRowView;
                if (drv != null)
                {
                    txtUnitPrice.Text = Convert.ToDecimal(drv["Price_Per_Unit"]).ToString("N2");
                    txtFixedFee.Text = Convert.ToDecimal(drv["Fixed_Fee"]).ToString("N2");
                }
            }
            catch { }
        }

        private void CalculateInvoice(object sender, EventArgs e)
        {
            try
            {
                decimal prev = 0, curr = 0, up = 0, ff = 0, pb = 0;
                decimal.TryParse(txtPrevReading.Text, out prev);
                decimal.TryParse(txtCurrReading.Text, out curr);
                decimal.TryParse(txtUnitPrice.Text, out up);
                decimal.TryParse(txtFixedFee.Text, out ff);
                decimal.TryParse(txtPrevBalance.Text, out pb);

                decimal cons = invoiceBLL.CalculateConsumption(curr, prev);
                decimal amt = invoiceBLL.CalculateAmount(cons, up, ff);
                decimal total = invoiceBLL.CalculateTotal(amt, pb);

                txtConsumption.Text = cons.ToString("N2");
                txtAmount.Text = amt.ToString("N2");
                txtTotal.Text = total.ToString("N2");
            }
            catch
            {
                txtConsumption.Text = "0";
                txtAmount.Text = "0";
                txtTotal.Text = "0";
            }
        }

        private void BtnCreate_Click(object sender, EventArgs e)
        {
            if (cmbCustomer.SelectedIndex < 0 || cmbMeter.SelectedIndex < 0 ||
                cmbPeriod.SelectedIndex < 0 || cmbTariff.SelectedIndex < 0)
            {
                UIHelper.ShowError("يرجى ملء جميع الحقول");
                return;
            }
            if (string.IsNullOrWhiteSpace(txtCurrReading.Text))
            {
                UIHelper.ShowError("يرجى إدخال القراءة الحالية");
                return;
            }
            try
            {
                decimal pb = 0;
                decimal.TryParse(txtPrevBalance.Text, out pb);

                invoiceBLL.CreateInvoice(
                    (int)cmbCustomer.SelectedValue,
                    (int)cmbMeter.SelectedValue,
                    (int)cmbPeriod.SelectedValue,
                    (int)cmbTariff.SelectedValue,
                    decimal.Parse(txtPrevReading.Text),
                    decimal.Parse(txtCurrReading.Text),
                    decimal.Parse(txtUnitPrice.Text),
                    decimal.Parse(txtFixedFee.Text),
                    pb);

                UIHelper.ShowSuccess("تم إنشاء الفاتورة بنجاح");
                txtCurrReading.Clear();
                txtConsumption.Text = "0";
                txtAmount.Text = "0";
                txtTotal.Text = "0";

                // تحديث الرصيد السابق بعد الإنشاء
                if (cmbCustomer.SelectedValue is int)
                {
                    int cid = (int)cmbCustomer.SelectedValue;
                    txtPrevBalance.Text = invoiceDAL.GetCustomerBalance(cid).ToString("N2");
                }
                // تحديث القراءة السابقة
                if (cmbMeter.SelectedValue is int)
                {
                    int mid = (int)cmbMeter.SelectedValue;
                    txtPrevReading.Text = invoiceBLL.GetLastReading(mid).ToString("N2");
                }
                LoadInvoices();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
