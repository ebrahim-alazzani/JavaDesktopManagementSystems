using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;


namespace datawithForm_ElectricitySystem
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {

        }

        private void menuStrip1_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }

        private void loginToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void invoicesToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                DataBaseConnection db = new DataBaseConnection();
                db.open();

                // التعديل هنا: استخدمنا Account_Name و Password الجديد
                string query = "SELECT COUNT(*) FROM dbo.Accounts WHERE Account_Name=@user AND Password=@pass";

                SqlCommand cmd = new SqlCommand(query, db.SqlConnection);

                cmd.Parameters.AddWithValue("@user", Username.Text);
                cmd.Parameters.AddWithValue("@pass", Password.Text);

                int result = (int)cmd.ExecuteScalar();

                if (result > 0)
                {
                    MessageBox.Show("تم تسجيل الدخول بنجاح!", "مرحباً", MessageBoxButtons.OK, MessageBoxIcon.Information);

                    // فتح الشاشة الرئيسية

                    MainDashboard main = new MainDashboard();
                    main.Show();
                    this.Hide(); // إخفاء شاشة الدخول
                }
                
                else
                {
                    MessageBox.Show("اسم المستخدم أو كلمة المرور غير صحيحة", "خطأ", MessageBoxButtons.OK, MessageBoxIcon.Stop);
                }

                db.close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("حدث خطأ: " + ex.Message);
            }
        }

        private void button2_Click_1(object sender, EventArgs e)
        
{
    // رسالة تأكيد اختيارية لضمان عدم الخروج بالخطأ
    DialogResult result = MessageBox.Show("هل أنت متأكد من رغبتك في إغلاق النظام؟", "تأكيد الخروج", MessageBoxButtons.YesNo, MessageBoxIcon.Question);

    if (result == DialogResult.Yes)
    {
        Application.Exit(); // هذا الأمر يغلق البرنامج وكل العمليات المرتبطة به
    }
}

        private void Username_TextChanged(object sender, EventArgs e)
        {

        }
        }
    }
