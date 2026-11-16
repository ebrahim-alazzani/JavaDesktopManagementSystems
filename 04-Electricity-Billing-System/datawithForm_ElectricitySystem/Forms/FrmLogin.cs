using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmLogin : Form
    {
        private UserDAL userDAL = new UserDAL();
        public static DataRow CurrentUser;

        public FrmLogin()
        {
            InitializeComponent();
        }

        private void BtnLogin_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtUsername.Text))
            {
                UIHelper.ShowError("يرجى إدخال اسم المستخدم");
                txtUsername.Focus();
                return;
            }
            if (string.IsNullOrWhiteSpace(txtPassword.Text))
            {
                UIHelper.ShowError("يرجى إدخال كلمة المرور");
                txtPassword.Focus();
                return;
            }

            try
            {
                DataTable dt = userDAL.Login(txtUsername.Text.Trim(), txtPassword.Text.Trim());
                if (dt.Rows.Count > 0)
                {
                    CurrentUser = dt.Rows[0];
                    this.DialogResult = DialogResult.OK;
                    this.Close();
                }
                else
                {
                    UIHelper.ShowError("اسم المستخدم أو كلمة المرور غير صحيحة");
                    txtPassword.Clear();
                    txtPassword.Focus();
                }
            }
            catch (Exception ex)
            {
                UIHelper.ShowError("خطأ في الاتصال: " + ex.Message);
            }
        }
    }
}
