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
    public partial class Form_Journal_Entries : Form
    {
        public Form_Journal_Entries()
        {
            InitializeComponent();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

       
            private void Form_Journal_Entries_Load(object sender, EventArgs e)
{
    // TODO: This line of code loads data into the 'eElectricitySystemDataSet.Journal_Entries' table. You can move, or remove it, as needed.
    this.journal_EntriesTableAdapter.Fill(this.eElectricitySystemDataSet.Journal_Entries);
    // 1. تعريف سلسلة الاتصال التي وجدناها في ملف DatabaseConnection
    string connectionString = @"server=FNOON\YSEDU;Database=EElectricitySystem;integrated security=true";
    
    // 2. إنشاء الاتصال وجلب البيانات
    // ملاحظة: تأكد من كتابة اسم الجدول بدلاً من Journal_Table
    SqlConnection con = new SqlConnection(connectionString);
    SqlDataAdapter da = new SqlDataAdapter("SELECT * FROM Journal_Entries", con); 
    DataTable dt = new DataTable();
    
    // 3. ملء الجدول وعرضه في المربع الرمادي
    da.Fill(dt);
    MainDashboard.DataSource = dt;
}

            private void journal_EntriesBindingNavigatorSaveItem_Click(object sender, EventArgs e)
            {
                this.Validate();
                this.journal_EntriesBindingSource.EndEdit();
                this.tableAdapterManager.UpdateAll(this.eElectricitySystemDataSet);

            }
        }
    }

