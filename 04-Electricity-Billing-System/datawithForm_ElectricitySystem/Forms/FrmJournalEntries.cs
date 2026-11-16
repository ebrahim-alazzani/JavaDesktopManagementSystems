using System;
using System.Data;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.BLL;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmJournalEntries : Form
    {
        private JournalEntryBLL journalBLL = new JournalEntryBLL();

        public FrmJournalEntries()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgvEntries);
            UIHelper.StyleDataGridView(dgvLines);
            UIHelper.SetupColumns(dgvEntries, new string[,] {
                {"Entry_ID", "رقم القيد"},
                {"Entry_Date", "التاريخ"},
                {"Description", "الوصف"},
                {"Total_Debit", "إجمالي المدين"},
                {"Total_Credit", "إجمالي الدائن"}
            });
            UIHelper.SetupColumns(dgvLines, new string[,] {
                {"Line_ID", "رقم السطر"},
                {"Account_Name", "الحساب"},
                {"Account_ID", "رقم الحساب"},
                {"Debit", "مدين"},
                {"Credit", "دائن"}
            });
            LoadEntries();
        }

        private void LoadEntries()
        {
            try
            {
                dgvEntries.DataSource = journalBLL.GetAllEntries();
            }
            catch (Exception ex) { UIHelper.ShowError("خطأ في تحميل القيود: " + ex.Message); }
        }

        private void DgvEntries_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            try
            {
                int entryID = Convert.ToInt32(dgvEntries.Rows[e.RowIndex].Cells["Entry_ID"].Value);
                dgvLines.DataSource = journalBLL.GetEntryLines(entryID);
                lblLines.Text = "تفاصيل القيد رقم: " + entryID;
            }
            catch (Exception ex) { UIHelper.ShowError("خطأ في تحميل تفاصيل القيد: " + ex.Message); }
        }
    }
}
