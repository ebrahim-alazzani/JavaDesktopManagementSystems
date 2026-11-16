using System;
using System.Windows.Forms;

namespace datawithForm_ElectricitySystem
{
    static class Program
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            // تسجيل الدخول أولاً
            FrmLogin loginForm = new FrmLogin();
            if (loginForm.ShowDialog() == DialogResult.OK)
            {
                // فتح لوحة التحكم الرئيسية
                Application.Run(new FrmMainDashboard());
            }
        }
    }
}
