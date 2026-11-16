using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmUsers : Form
    {
        private UserDAL userDAL = new UserDAL();

        public FrmUsers()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgvUsers);
            UIHelper.SetupColumns(dgvUsers, new string[,] {
                {"User_ID", "الرقم"},
                {"UserName", "اسم المستخدم"},
                {"FullName", "الاسم الكامل"},
                {"Role_Name", "الدور"},
                {"IsActive", "نشط"}
            });
            LoadUsers();
        }

        private void LoadUsers()
        {
            try
            {
                dgvUsers.DataSource = userDAL.GetAll();
            }
            catch (Exception ex) { UIHelper.ShowError("خطأ في تحميل المستخدمين: " + ex.Message); }
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtUserName.Text) || string.IsNullOrWhiteSpace(txtPassword.Text))
            {
                UIHelper.ShowError("يرجى ملء جميع الحقول المطلوبة");
                return;
            }
            try
            {
                userDAL.Add(txtUserName.Text.Trim(), txtPassword.Text.Trim(),
                    txtFullName.Text.Trim(), cmbRole.Text);
                UIHelper.ShowSuccess("تم إضافة المستخدم بنجاح");
                ClearFields();
                LoadUsers();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void ClearFields()
        {
            txtUserName.Clear();
            txtPassword.Clear();
            txtFullName.Clear();
            if (cmbRole.Items.Count > 0) cmbRole.SelectedIndex = 0;
            dgvUsers.ClearSelection();
        }

        private void Dgv_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            DataGridViewRow row = dgvUsers.Rows[e.RowIndex];
            txtUserName.Text = row.Cells["User_Name"].Value != null ? row.Cells["User_Name"].Value.ToString() : "";
            txtFullName.Text = row.Cells["Full_Name"].Value != null ? row.Cells["Full_Name"].Value.ToString() : "";
            if (dgvUsers.Columns.Contains("Role_Name") && row.Cells["Role_Name"].Value != null)
                cmbRole.Text = row.Cells["Role_Name"].Value.ToString();
        }
    }
}
