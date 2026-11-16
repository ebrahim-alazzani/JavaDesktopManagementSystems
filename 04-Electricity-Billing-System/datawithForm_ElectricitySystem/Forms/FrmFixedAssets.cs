using System;
using System.Data;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmFixedAssets : Form
    {
        private FixedAssetDAL dal = new FixedAssetDAL();

        public FrmFixedAssets()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgv);
            UIHelper.SetupColumns(dgv, new string[,] {
                {"Asset_ID", "الرقم"},
                {"Asset_Name", "اسم الأصل"},
                {"Asset_Type", "النوع"},
                {"Purchase_Value", "القيمة"},
                {"Purchase_Date", "تاريخ الشراء"}
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
            txtName.Text = r.Cells["Asset_Name"].Value != null ? r.Cells["Asset_Name"].Value.ToString() : "";
            txtType.Text = r.Cells["Asset_Type"].Value != null ? r.Cells["Asset_Type"].Value.ToString() : "";
            txtValue.Text = r.Cells["Purchase_Value"].Value != null ? r.Cells["Purchase_Value"].Value.ToString() : "";
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtName.Text))
            {
                UIHelper.ShowError("يرجى إدخال اسم الأصل");
                return;
            }
            try
            {
                decimal val = 0;
                decimal.TryParse(txtValue.Text, out val);
                dal.Add(new FixedAsset { Asset_Name = txtName.Text, Asset_Type = txtType.Text, Purchase_Value = val });
                UIHelper.ShowSuccess("تم إضافة الأصل بنجاح");
                ClearFields();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد أصل"); return; }
            try
            {
                decimal val = 0;
                decimal.TryParse(txtValue.Text, out val);
                dal.Update(new FixedAsset
                {
                    Asset_ID = Convert.ToInt32(dgv.CurrentRow.Cells["Asset_ID"].Value),
                    Asset_Name = txtName.Text,
                    Asset_Type = txtType.Text,
                    Purchase_Value = val
                });
                UIHelper.ShowSuccess("تم تعديل الأصل بنجاح");
                ClearFields();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null || !UIHelper.ShowConfirm("تأكيد الحذف؟")) return;
            try
            {
                dal.Delete(Convert.ToInt32(dgv.CurrentRow.Cells["Asset_ID"].Value));
                UIHelper.ShowSuccess("تم حذف الأصل بنجاح");
                ClearFields();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void ClearFields()
        {
            txtName.Clear();
            txtType.Clear();
            txtValue.Text = "0";
            dgv.ClearSelection();
        }
    }
}
