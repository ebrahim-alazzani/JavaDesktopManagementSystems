using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmMainDashboard : Form
    {
        private ReportDAL reportDAL = new ReportDAL();

        public FrmMainDashboard()
        {
            InitializeComponent();
            lblDate.Text = DateTime.Now.ToString("yyyy/MM/dd - dddd");
            LoadDashboard();
        }

        private void LoadDashboard()
        {
            try
            {
                DataTable stats = reportDAL.GetDashboardStats();
                if (stats.Rows.Count > 0)
                {
                    DataRow row = stats.Rows[0];
                    lblStatCustomers.Text = row["TotalCustomers"].ToString();
                    lblStatInvoices.Text = row["TotalInvoices"].ToString();
                    lblStatRevenue.Text = Convert.ToDecimal(row["TotalRevenue"]).ToString("N0");
                    lblStatDebts.Text = Convert.ToDecimal(row["TotalDebts"]).ToString("N0");
                }

                InvoiceDAL invDAL = new InvoiceDAL();
                dgvRecentInvoices.DataSource = invDAL.GetAll();
                FormatInvoiceGrid();
            }
            catch { }
        }

        private void FormatInvoiceGrid()
        {
            if (dgvRecentInvoices.Columns.Count > 0)
            {
                foreach (DataGridViewColumn col in dgvRecentInvoices.Columns)
                    col.Visible = false;
                SetColVisible("Customer_Name", "المشترك");
                SetColVisible("Meter_No", "العداد");
                SetColVisible("Consumption", "الاستهلاك");
                SetColVisible("Current_Amount", "المبلغ");
                SetColVisible("Total_Balance", "الإجمالي");
                SetColVisible("Invoice_Date", "التاريخ");
                SetColVisible("Is_Paid", "مدفوعة");
            }
        }

        private void SetColVisible(string name, string header)
        {
            if (dgvRecentInvoices.Columns.Contains(name))
            {
                dgvRecentInvoices.Columns[name].Visible = true;
                dgvRecentInvoices.Columns[name].HeaderText = header;
            }
        }

        // ========== أحداث القائمة ==========
        private void BtnMenuDashboard_Click(object sender, EventArgs e) { LoadDashboard(); }
        private void BtnMenuCustomers_Click(object sender, EventArgs e) { new FrmCustomers().ShowDialog(); LoadDashboard(); }
        private void BtnMenuMeters_Click(object sender, EventArgs e) { new FrmMeters().ShowDialog(); LoadDashboard(); }
        private void BtnMenuPeriods_Click(object sender, EventArgs e) { new FrmBillingPeriods().ShowDialog(); LoadDashboard(); }
        private void BtnMenuTariffs_Click(object sender, EventArgs e) { new FrmTariffs().ShowDialog(); LoadDashboard(); }
        private void BtnMenuInvoices_Click(object sender, EventArgs e) { new FrmInvoices().ShowDialog(); LoadDashboard(); }
        private void BtnMenuPayments_Click(object sender, EventArgs e) { new FrmPayments().ShowDialog(); LoadDashboard(); }
        private void BtnMenuAccounts_Click(object sender, EventArgs e) { new FrmAccounts().ShowDialog(); LoadDashboard(); }
        private void BtnMenuJournal_Click(object sender, EventArgs e) { new FrmJournalEntries().ShowDialog(); LoadDashboard(); }
        private void BtnMenuAssets_Click(object sender, EventArgs e) { new FrmFixedAssets().ShowDialog(); LoadDashboard(); }
        private void BtnMenuFuel_Click(object sender, EventArgs e) { new FrmFuelConsumption().ShowDialog(); LoadDashboard(); }

        private void BtnMenuReports_Click(object sender, EventArgs e) { new FrmReports().ShowDialog(); LoadDashboard(); }
        private void BtnMenuUsers_Click(object sender, EventArgs e) { new FrmUsers().ShowDialog(); LoadDashboard(); }
        private void BtnMenuVouchers_Click(object sender, EventArgs e) { new FrmVouchers().ShowDialog(); LoadDashboard(); }

        private void BtnMenuLogout_Click(object sender, EventArgs e)
        {
            if (UIHelper.ShowConfirm("هل تريد تسجيل الخروج؟"))
                this.Close();
        }

        private void pnlContent_Paint(object sender, PaintEventArgs e)
        {

        }
    }
}
