using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmCustomers : Form
    {
        private CustomerDAL dal = new CustomerDAL();

        public FrmCustomers()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgvCustomers);
            UIHelper.SetupColumns(dgvCustomers, new string[,] {
                {"Customer_ID", "الرقم"},
                {"Customer_Name", "الاسم"},
                {"Phone", "الهاتف"},
                {"Address", "العنوان"},
                {"Opening_Balance", "الرصيد الافتتاحي"},
                {"Status", "الحالة"},
                {"Created_Date", "تاريخ الإنشاء"}
            });
            LoadData();
        }

        private void LoadData()
        {
            try { dgvCustomers.DataSource = dal.GetAll(); }
            catch (Exception ex) { UIHelper.ShowError("خطأ في تحميل البيانات: " + ex.Message); }
        }

        private void ClearFields()
        {
            txtName.Clear(); txtPhone.Clear(); txtAddress.Clear(); txtBalance.Text = "0";
            dgvCustomers.ClearSelection(); txtName.Focus();
        }

        private void DgvCustomers_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            DataGridViewRow row = dgvCustomers.Rows[e.RowIndex];
            txtName.Text = row.Cells["Customer_Name"].Value != null ? row.Cells["Customer_Name"].Value.ToString() : "";
            txtPhone.Text = row.Cells["Phone"].Value != null ? row.Cells["Phone"].Value.ToString() : "";
            txtAddress.Text = row.Cells["Address"].Value != null ? row.Cells["Address"].Value.ToString() : "";
            txtBalance.Text = row.Cells["Opening_Balance"].Value != null ? row.Cells["Opening_Balance"].Value.ToString() : "0";
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtName.Text)) { UIHelper.ShowError("يرجى إدخال اسم المشترك"); return; }
            try
            {
                decimal bal = 0;
                decimal.TryParse(txtBalance.Text, out bal);
                dal.Add(new Customer { Customer_Name = txtName.Text.Trim(), Phone = txtPhone.Text.Trim(), Address = txtAddress.Text.Trim(), Opening_Balance = bal });
                UIHelper.ShowSuccess("تم إضافة المشترك بنجاح"); ClearFields(); LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (dgvCustomers.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد مشترك"); return; }
            if (string.IsNullOrWhiteSpace(txtName.Text)) { UIHelper.ShowError("يرجى إدخال اسم المشترك"); return; }
            try
            {
                decimal bal = 0;
                decimal.TryParse(txtBalance.Text, out bal);
                dal.Update(new Customer { Customer_ID = Convert.ToInt32(dgvCustomers.CurrentRow.Cells["Customer_ID"].Value), Customer_Name = txtName.Text.Trim(), Phone = txtPhone.Text.Trim(), Address = txtAddress.Text.Trim(), Opening_Balance = bal, Status = true });
                UIHelper.ShowSuccess("تم تعديل المشترك بنجاح"); ClearFields(); LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            if (dgvCustomers.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد مشترك"); return; }
            if (!UIHelper.ShowConfirm("هل أنت متأكد من حذف هذا المشترك؟")) return;
            try
            {
                dal.Delete(Convert.ToInt32(dgvCustomers.CurrentRow.Cells["Customer_ID"].Value));
                UIHelper.ShowSuccess("تم حذف المشترك بنجاح"); ClearFields(); LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void TxtSearch_TextChanged(object sender, EventArgs e)
        {
            try
            {
                if (txtSearch.ForeColor == UIHelper.TextSecondary) return;
                if (string.IsNullOrWhiteSpace(txtSearch.Text)) LoadData();
                else dgvCustomers.DataSource = dal.Search(txtSearch.Text.Trim());
                FormatGrid();
            }
            catch { }
        }

        private void TxtSearch_GotFocus(object sender, EventArgs e)
        {
            if (txtSearch.ForeColor == UIHelper.TextSecondary) { txtSearch.Text = ""; txtSearch.ForeColor = UIHelper.TextPrimary; }
        }

        private void TxtSearch_LostFocus(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtSearch.Text)) { txtSearch.Text = "بحث بالاسم أو الهاتف أو العنوان..."; txtSearch.ForeColor = UIHelper.TextSecondary; }
        }
    }
}
