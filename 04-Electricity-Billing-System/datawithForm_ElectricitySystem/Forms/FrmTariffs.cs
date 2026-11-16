using System;
using System.Data;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmTariffs : Form
    {
        private TariffDAL dal = new TariffDAL();

        public FrmTariffs()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgv);
            UIHelper.SetupColumns(dgv, new string[,] {
                {"Tariff_ID", "الرقم"},
                {"Tariff_Name", "اسم التعرفة"},
                {"Price_Per_Unit", "سعر الوحدة"},
                {"Fixed_Fee", "الرسم الثابت"},
                {"Is_Active", "نشطة"}
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
            txtName.Text = r.Cells["Tariff_Name"].Value != null ? r.Cells["Tariff_Name"].Value.ToString() : "";
            txtPrice.Text = r.Cells["Price_Per_Unit"].Value != null ? r.Cells["Price_Per_Unit"].Value.ToString() : "";
            txtFee.Text = r.Cells["Fixed_Fee"].Value != null ? r.Cells["Fixed_Fee"].Value.ToString() : "";
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtName.Text))
            {
                UIHelper.ShowError("يرجى إدخال اسم التعرفة");
                return;
            }
            try
            {
                decimal fee = 0;
                decimal.TryParse(txtFee.Text, out fee);
                dal.Add(new Tariff
                {
                    Tariff_Name = txtName.Text,
                    Price_Per_Unit = decimal.Parse(txtPrice.Text),
                    Fixed_Fee = fee
                });
                UIHelper.ShowSuccess("تم إضافة التعرفة بنجاح");
                txtName.Clear();
                txtPrice.Clear();
                txtFee.Clear();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد تعرفة"); return; }
            try
            {
                decimal fee = 0;
                decimal.TryParse(txtFee.Text, out fee);
                dal.Update(new Tariff
                {
                    Tariff_ID = Convert.ToInt32(dgv.CurrentRow.Cells["Tariff_ID"].Value),
                    Tariff_Name = txtName.Text,
                    Price_Per_Unit = decimal.Parse(txtPrice.Text),
                    Fixed_Fee = fee,
                    Is_Active = chkActive.Checked
                });
                UIHelper.ShowSuccess("تم تعديل التعرفة بنجاح");
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null || !UIHelper.ShowConfirm("تأكيد الحذف؟")) return;
            try
            {
                dal.Delete(Convert.ToInt32(dgv.CurrentRow.Cells["Tariff_ID"].Value));
                UIHelper.ShowSuccess("تم الحذف بنجاح");
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
