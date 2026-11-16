using System;
using System.Data;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmBillingPeriods : Form
    {
        private BillingPeriodDAL dal = new BillingPeriodDAL();

        public FrmBillingPeriods()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgv);
            UIHelper.SetupColumns(dgv, new string[,] {
                {"Period_ID", "الرقم"},
                {"Period_Name", "اسم الفترة"},
                {"Start_Date", "تاريخ البداية"},
                {"End_Date", "تاريخ النهاية"},
                {"Is_Closed", "مغلقة"}
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
            txtName.Text = r.Cells["Period_Name"].Value != null ? r.Cells["Period_Name"].Value.ToString() : "";
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtName.Text))
            {
                UIHelper.ShowError("يرجى إدخال اسم الفترة");
                return;
            }
            try
            {
                dal.Add(new BillingPeriod { Period_Name = txtName.Text, Start_Date = dtpStart.Value, End_Date = dtpEnd.Value });
                UIHelper.ShowSuccess("تم إضافة الفترة بنجاح");
                txtName.Clear();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد فترة"); return; }
            try
            {
                dal.Update(new BillingPeriod
                {
                    Period_ID = Convert.ToInt32(dgv.CurrentRow.Cells["Period_ID"].Value),
                    Period_Name = txtName.Text,
                    Start_Date = dtpStart.Value,
                    End_Date = dtpEnd.Value,
                    Is_Closed = chkClosed.Checked
                });
                UIHelper.ShowSuccess("تم تعديل الفترة بنجاح");
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null || !UIHelper.ShowConfirm("تأكيد الحذف؟")) return;
            try
            {
                dal.Delete(Convert.ToInt32(dgv.CurrentRow.Cells["Period_ID"].Value));
                UIHelper.ShowSuccess("تم الحذف بنجاح");
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
