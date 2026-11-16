using System;
using System.Data;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmFuelConsumption : Form
    {
        private FuelConsumptionDAL dal = new FuelConsumptionDAL();
        private FixedAssetDAL assetDAL = new FixedAssetDAL();

        public FrmFuelConsumption()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgv);
            UIHelper.SetupColumns(dgv, new string[,] {
                {"Log_ID", "الرقم"},
                {"Asset_Name", "الأصل"},
                {"Transaction_Type", "النوع"},
                {"Quantity_Used", "الكمية"},
                {"Cost", "التكلفة"},
                {"Log_Date", "التاريخ"}
            });
            try
            {
                cmbAsset.DataSource = assetDAL.GetAll();
                cmbAsset.DisplayMember = "Asset_Name";
                cmbAsset.ValueMember = "Asset_ID";
            }
            catch { }
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

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            decimal q = 0;
            if (cmbAsset.SelectedIndex < 0 || !decimal.TryParse(txtQuantity.Text, out q))
            {
                UIHelper.ShowError("يرجى ملء البيانات");
                return;
            }
            try
            {
                decimal cost = 0;
                decimal.TryParse(txtCost.Text, out cost);
                dal.Add(new FuelConsumption
                {
                    Asset_ID = (int)cmbAsset.SelectedValue,
                    Transaction_Type = cmbType.Text,
                    Quantity_Used = q,
                    Cost = cost
                });
                UIHelper.ShowSuccess("تم تسجيل الاستهلاك بنجاح");
                txtQuantity.Clear();
                txtCost.Clear();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null || !UIHelper.ShowConfirm("تأكيد الحذف؟")) return;
            try
            {
                dal.Delete(Convert.ToInt32(dgv.CurrentRow.Cells["Log_ID"].Value));
                UIHelper.ShowSuccess("تم الحذف بنجاح");
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
