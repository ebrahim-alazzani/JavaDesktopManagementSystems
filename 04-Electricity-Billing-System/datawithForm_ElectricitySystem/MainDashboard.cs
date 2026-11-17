using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace datawithForm_ElectricitySystem
{
    public partial class MainDashboard : Form
    {
        public MainDashboard()
        {


            InitializeComponent();


            foreach (Control control in this.Controls)
            {
                if (control is MdiClient)
                {
                    control.BackColor = SystemColors.Control; // ضع اللون الذي تريده هنا ليناسب شعار المحطة
                    break;
                }
            }
        }
        // دالة موحدة لفتح أي واجهة في المنتصف وبحجم ثابت
        private void OpenChildForm(Form childForm)
        {
            // 1. إغلاق الواجهات المفتوحة مسبقاً لمنع التراكم
            foreach (Form child in this.MdiChildren)
            {
                child.Close();
            }

            // 2. إعدادات المظهر والارتباط بالحاوية
            childForm.MdiParent = this;
            childForm.FormBorderStyle = FormBorderStyle.FixedSingle;
            childForm.MaximizeBox = false;

            // 3. تحديد حجم موحد (يمكنك تعديل الأرقام حسب رغبتك)
            childForm.Size = new Size(800, 600);

            // 4. وضع الواجهة في المنتصف تماماً
            childForm.StartPosition = FormStartPosition.Manual;
            childForm.Location = new Point(
                (this.ClientSize.Width - childForm.Width) / 2,
                ((this.ClientSize.Height - childForm.Height) / 2) - 40
            );

            childForm.Show();
        }
        // 1. زر واجهة الحسابات
        private void btnAccounts_Click(object sender, EventArgs e)
        {
            Form_Accounts frm = new Form_Accounts();
            frm.Show(); // تفتح واجهة الحسابات
        }


        // 2. زر واجهة المشتركين
        private void btnCustomers_Click(object sender, EventArgs e)
        {
            Form_Customers frm = new Form_Customers();
            frm.Show();
        }

        // 3. زر واجهة الفواتير
        private void btnInvoices_Click(object sender, EventArgs e)
        {
            Form_Invoices frm = new Form_Invoices();
            frm.Show();
        }


        private void btnOpenForm_Click(object sender, EventArgs e)
        {

        }

        private void billingPeriodsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //foreach (Form child in this.MdiChildren) { child.Close(); }
           // Form_Billing_Periods frm = new Form_Billing_Periods();
           // frm.MdiParent = this;
            //frm.Show();
            OpenChildForm(new Form_Billing_Periods());
        }

       // private void accountsToolStripMenuItem_Click(object sender, EventArgs e)
      //  {
             //  foreach (Form child in this.MdiChildren) { child.Close(); }
           // Form_Accounts frm = new Form_Accounts();
           // frm.MdiParent = this;
           // frm.Show();
       // }

        private void journalEntriesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //foreach (Form child in this.MdiChildren) { child.Close(); }
           // foreach (Form child in this.MdiChildren) { child.Close(); }
          //  { Form_Journal_Entries frm = new Form_Journal_Entries(); frm.MdiParent = this; frm.Show(); }
            //   وتأكي من تكرار العملية لبقية القوائم الأخرى مثل Fixed_Assets وCustomers بنفس الطريقة.
           // OpenChildForm(new Form_Journal_Entries());
        }

        //  public static DataTable DataSource { get; set; }

        private void customersToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //foreach (Form child in this.MdiChildren) { child.Close(); }
           // { Form_Customers frm = new Form_Customers(); frm.MdiParent = this; frm.Show(); }
            OpenChildForm(new Form_Customers());
        }

        private void fixedAssetsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //foreach (Form child in this.MdiChildren) { child.Close(); }
           // { Form_Fixed_Assets frm = new Form_Fixed_Assets(); frm.MdiParent = this; frm.Show(); } 
            OpenChildForm(new Form_Fixed_Assets());
        }

        private void fuelConsumptionToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //foreach (Form child in this.MdiChildren) { child.Close(); }
           // { Form_Fuel_Consumption frm = new Form_Fuel_Consumption(); frm.MdiParent = this; frm.Show(); }   
            OpenChildForm(new Form_Fuel_Consumption());
        }

        private void invoicesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //foreach (Form child in this.MdiChildren) { child.Close(); }
           //{ Form_Invoices frm = new Form_Invoices(); frm.MdiParent = this; frm.Show(); } 
            OpenChildForm(new Form_Invoices());
        }

        private void tariffsToolStripMenuItem_Click(object sender, EventArgs e)
        {
           // foreach (Form child in this.MdiChildren) { child.Close(); }
           // { Form_Tariffs frm = new Form_Tariffs(); frm.MdiParent = this; frm.Show(); } 
            OpenChildForm(new Form_Tariffs());

        }

        private void accountsToolStripMenuItem1_Click(object sender, EventArgs e)
        
{
    OpenChildForm(new Form_Accounts());
}
        


            private void MainDashboard_Load(object sender, EventArgs e)
{
    //  foreach (Control control in this.Controls)
 //   {
        //   if (control is MdiClient)
       // {
            // يمكنك اختيار أي لون هنا بدلاً من White
            //   control.BackColor = Color.Navy; 
       // }
    //  }
}

            private void خروجToolStripMenuItem_Click(object sender, EventArgs e)
            {
                DialogResult result = MessageBox.Show("هل أنت متأكد من رغبتك في الخروج؟", "تأكيد الخروج", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
                if (result == DialogResult.Yes)
                {
                    Application.Exit();
                }
            }

            private void مساعدةToolStripMenuItem_Click(object sender, EventArgs e)
           
{
    MessageBox.Show("نظام محاسبي لمحطة الكهرباء:\n\n1. استخدم القائمة العلوية للتنقل.\n2. تأكد من إدخال البيانات بشكل صحيح قبل الحفظ.\n3. للدعم الفني اتصل بالرقم: 776040000", 
                    "تعليمات المساعدة", 
                    MessageBoxButtons.OK, 
                    MessageBoxIcon.Information);
}

            private void حولالنظامToolStripMenuItem_Click(object sender, EventArgs e)
            
{
    string info = "نظام محاسبي لمحطة الكهرباء\n" +
                  "الإصدار: 1.0.0\n" +
                  "تطوير: سايبر برو للأعمال التقنية والهندسية\n" +
                  "حقوق النشر © 2026 جميع الحقوق محفوظة.";

    MessageBox.Show(info, "حول النظام", MessageBoxButtons.OK, MessageBoxIcon.Information);
}

            private void التقاريرToolStripMenuItem_Click(object sender, EventArgs e)
           
{
    MessageBox.Show("قسم التقارير قيد التطوير حالياً وسيتم ربطه بقاعدة البيانات قريباً.", 
                    "تنبيه", 
                    MessageBoxButtons.OK, 
                    MessageBoxIcon.Information);

            }

            public static DataTable DataSource { get; set; }
    }
            }
        
    





    

