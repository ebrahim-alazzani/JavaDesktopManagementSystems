using System;
using System.Data;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmMeters : Form
    {
        private MeterDAL dal = new MeterDAL();
        private CustomerDAL customerDAL = new CustomerDAL();
        private MeterReadingDAL readingDAL = new MeterReadingDAL();

        public FrmMeters()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgv);
            UIHelper.SetupColumns(dgv, new string[,] {
                {"Meter_ID", "الرقم"},
                {"Meter_No", "رقم العداد"},
                {"Customer_Name", "المشترك"},
                {"Installation_Date", "تاريخ التركيب"},
                {"Location", "الموقع"},
                {"Status", "الحالة"}
            });
            LoadCombos();
            LoadData();
        }

        private void LoadCombos()
        {
            try
            {
                cmbCustomer.DataSource = customerDAL.GetAll();
                cmbCustomer.DisplayMember = "Customer_Name";
                cmbCustomer.ValueMember = "Customer_ID";
                cmbCustomer.SelectedIndex = -1;
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void LoadData()
        {
            try
            {
                dgv.DataSource = dal.GetAll();
            }
            catch (Exception ex) { UIHelper.ShowError("خطأ في تحميل البيانات: " + ex.Message); }
        }

        private void ClearFields()
        {
            txtMeterNo.Clear();
            txtLocation.Clear();
            txtOpenReading.Text = "0";
            cmbCustomer.SelectedIndex = -1;
            dgv.ClearSelection();
            txtMeterNo.Focus();
        }

        private void Dgv_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            DataGridViewRow row = dgv.Rows[e.RowIndex];
            txtMeterNo.Text = row.Cells["Meter_No"].Value != null ? row.Cells["Meter_No"].Value.ToString() : "";
            txtLocation.Text = row.Cells["Location"].Value != null ? row.Cells["Location"].Value.ToString() : "";
            if (dgv.Columns.Contains("Customer_ID"))
            {
                try { cmbCustomer.SelectedValue = Convert.ToInt32(row.Cells["Customer_ID"].Value); }
                catch { }
            }
        }

        private void BtnAdd_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtMeterNo.Text))
            {
                UIHelper.ShowError("يرجى إدخال رقم العداد");
                return;
            }
            if (cmbCustomer.SelectedIndex < 0)
            {
                UIHelper.ShowError("يرجى اختيار المشترك");
                return;
            }
            try
            {
                Meter m = new Meter
                {
                    Meter_No = txtMeterNo.Text.Trim(),
                    Customer_ID = (int)cmbCustomer.SelectedValue,
                    Installation_Date = DateTime.Now,
                    Location = txtLocation.Text.Trim()
                };
                int meterID = dal.Add(m);

                // حفظ القراءة الافتتاحية
                decimal openReading = 0;
                if (meterID > 0 && decimal.TryParse(txtOpenReading.Text, out openReading) && openReading > 0)
                {
                    try { readingDAL.Add(meterID, 0, openReading); } catch { }
                }

                UIHelper.ShowSuccess("تم إضافة العداد بنجاح");
                ClearFields();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnUpdate_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد عداد"); return; }
            if (string.IsNullOrWhiteSpace(txtMeterNo.Text)) { UIHelper.ShowError("يرجى إدخال رقم العداد"); return; }
            try
            {
                Meter m = new Meter
                {
                    Meter_ID = Convert.ToInt32(dgv.CurrentRow.Cells["Meter_ID"].Value),
                    Meter_No = txtMeterNo.Text.Trim(),
                    Customer_ID = (int)cmbCustomer.SelectedValue,
                    Location = txtLocation.Text.Trim(),
                    Status = true
                };
                dal.Update(m);
                UIHelper.ShowSuccess("تم تعديل العداد بنجاح");
                ClearFields();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void BtnDelete_Click(object sender, EventArgs e)
        {
            if (dgv.CurrentRow == null) { UIHelper.ShowError("يرجى تحديد عداد"); return; }
            if (!UIHelper.ShowConfirm("هل أنت متأكد من حذف هذا العداد؟")) return;
            try
            {
                dal.Delete(Convert.ToInt32(dgv.CurrentRow.Cells["Meter_ID"].Value));
                UIHelper.ShowSuccess("تم حذف العداد بنجاح");
                ClearFields();
                LoadData();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
