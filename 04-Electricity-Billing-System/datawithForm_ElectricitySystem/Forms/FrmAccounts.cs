using System;
using System.Data;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmAccounts : Form
    {
        private AccountDAL dal = new AccountDAL();

        public FrmAccounts()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgv);
            UIHelper.SetupColumns(dgv, new string[,] {
                {"Account_ID", "الرقم"},
                {"Account_Name", "اسم الحساب"},
                {"Account_Type", "نوع الحساب"},
                {"Balance_Type", "طبيعة الرصيد"}
            });
            LoadData();
        }

        private void LoadData()
        {
            try
            {
                dgv.DataSource = dal.GetAll();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void Dgv_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            DataGridViewRow r = dgv.Rows[e.RowIndex];
            txtName.Text = r.Cells["Account_Name"].Value != null ? r.Cells["Account_Name"].Value.ToString() : "";
            cmbType.Text = r.Cells["Account_Type"].Value != null ? r.Cells["Account_Type"].Value.ToString() : "";
            cmbBalance.Text = r.Cells["Balance_Type"].Value != null ? r.Cells["Balance_Type"].Value.ToString() : "";
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtName.Text))
            {
                UIHelper.ShowError("يرجى إدخال اسم الحساب");
                return;
            }
            if (string.IsNullOrWhiteSpace(cmbType.Text) || string.IsNullOrWhiteSpace(cmbBalance.Text))
            {
                UIHelper.ShowError("يرجى اختيار نوع الحساب والطبيعة");
                return;
            }
            try
            {
                dal.Add(new Account { Account_Name = txtName.Text, Account_Type = cmbType.Text, Balance_Type = cmbBalance.Text });
                UIHelper.ShowSuccess("تم إضافة الحساب بنجاح");
                txtName.Clear();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد حساب"); return; }
            try
            {
                dal.Update(new Account
                {
                    Account_ID = Convert.ToInt32(dgv.CurrentRow.Cells["Account_ID"].Value),
                    Account_Name = txtName.Text,
                    Account_Type = cmbType.Text,
                    Balance_Type = cmbBalance.Text
                });
                UIHelper.ShowSuccess("تم تعديل الحساب بنجاح");
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null || !UIHelper.ShowConfirm("تأكيد الحذف؟")) return;
            try
            {
                dal.Delete(Convert.ToInt32(dgv.CurrentRow.Cells["Account_ID"].Value));
                UIHelper.ShowSuccess("تم الحذف بنجاح");
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
