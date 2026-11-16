using System;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Windows.Forms;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem
{
    public partial class FrmVouchers : Form
    {
        private CustomerDAL customerDAL = new CustomerDAL();
        private AccountDAL accountDAL = new AccountDAL();
        private JournalEntryDAL journalDAL = new JournalEntryDAL();

        public FrmVouchers()
        {
            InitializeComponent();
            UIHelper.StyleDataGridView(dgv);
            UIHelper.SetupColumns(dgv, new string[,] {
                {"رقم السند", "رقم السند"},
                {"النوع", "النوع"},
                {"المشترك/الجهة", "المشترك/الجهة"},
                {"الحساب", "الحساب"},
                {"المبلغ", "المبلغ"},
                {"البيان", "البيان"},
                {"طريقة الدفع", "طريقة الدفع"},
                {"رقم المرجع", "رقم المرجع"},
                {"التاريخ", "التاريخ"}
            });
            LoadData();
        }

        private void LoadData()
        {
            try
            {
                // تحميل المشتركين
                cmbCustomer.DataSource = customerDAL.GetAll();
                cmbCustomer.DisplayMember = "Customer_Name";
                cmbCustomer.ValueMember = "Customer_ID";
                cmbCustomer.SelectedIndex = -1;

                // تحميل الحسابات
                cmbAccount.DataSource = accountDAL.GetAll();
                cmbAccount.DisplayMember = "Account_Name";
                cmbAccount.ValueMember = "Account_ID";
                if (cmbAccount.Items.Count > 0) cmbAccount.SelectedIndex = 0;

                // تحميل السندات
                LoadVouchers();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }

        private void LoadVouchers()
        {
            try
            {
                string sql = @"SELECT v.Voucher_ID AS [رقم السند],
                    v.Voucher_Type AS [النوع],
                    c.Customer_Name AS [المشترك/الجهة], a.Account_Name AS [الحساب],
                    v.Amount AS [المبلغ], v.Description AS [البيان],
                    v.Payment_Method AS [طريقة الدفع], v.Reference_No AS [رقم المرجع],
                    v.Voucher_Date AS [التاريخ]
                    FROM Vouchers v
                    LEFT JOIN Customers c ON v.Customer_ID = c.Customer_ID
                    LEFT JOIN Accounts a ON v.Account_ID = a.Account_ID
                    ORDER BY v.Voucher_ID DESC";
                dgv.DataSource = ConnectionHelper.ExecuteQueryText(sql);
            }
            catch { }
        }

        private void VoucherTypeChanged(object sender, EventArgs e)
        {
            if (rbReceipt.Checked)
            {
                lblTitle.Text = "سند قبض";
                lblTitle.ForeColor = Color.FromArgb(16, 185, 129);
                btnSave.Text = "حفظ سند القبض";
                btnSave.BackColor = Color.FromArgb(16, 185, 129);
            }
            else
            {
                lblTitle.Text = "سند صرف";
                lblTitle.ForeColor = Color.FromArgb(239, 68, 68);
                btnSave.Text = "حفظ سند الصرف";
                btnSave.BackColor = Color.FromArgb(239, 68, 68);
            }
        }

        private void BtnSave_Click(object sender, EventArgs e)
        {
            decimal amount = 0;
            if (!decimal.TryParse(txtAmount.Text, out amount) || amount <= 0)
            {
                UIHelper.ShowError("يرجى إدخال مبلغ صحيح");
                return;
            }
            if (cmbAccount.SelectedIndex < 0)
            {
                UIHelper.ShowError("يرجى اختيار الحساب");
                return;
            }

            try
            {
                string voucherType = rbReceipt.Checked ? "سند قبض" : "سند صرف";
                int accountID = (int)cmbAccount.SelectedValue;
                object customerID = cmbCustomer.SelectedValue;
                string desc = txtDescription.Text.Trim();
                string method = cmbMethod.Text;
                string refNo = txtReference.Text.Trim();

                // حفظ السند في جدول Vouchers
                string sql = @"INSERT INTO Vouchers(Voucher_Type, Customer_ID, Account_ID, Amount, Description, Payment_Method, Reference_No)
                    VALUES(@Type, @CID, @AID, @Amt, @Desc, @Method, @Ref); SELECT SCOPE_IDENTITY()";
                SqlParameter cidParam = new SqlParameter("@CID", SqlDbType.Int);
                if (customerID != null && customerID is int)
                    cidParam.Value = (int)customerID;
                else
                    cidParam.Value = DBNull.Value;

                object result = ConnectionHelper.ExecuteScalarText(sql,
                    new SqlParameter("@Type", voucherType),
                    cidParam,
                    new SqlParameter("@AID", accountID),
                    new SqlParameter("@Amt", amount),
                    new SqlParameter("@Desc", string.IsNullOrEmpty(desc) ? (object)DBNull.Value : desc),
                    new SqlParameter("@Method", string.IsNullOrEmpty(method) ? "نقدي" : method),
                    new SqlParameter("@Ref", string.IsNullOrEmpty(refNo) ? (object)DBNull.Value : refNo));

                // إنشاء قيد محاسبي تلقائي
                if (result != null && result != DBNull.Value)
                {
                    int voucherID = Convert.ToInt32(result);
                    string entryDesc = (rbReceipt.Checked ? "سند قبض رقم " : "سند صرف رقم ") + voucherID;
                    if (!string.IsNullOrEmpty(desc)) entryDesc += " - " + desc;

                    JournalEntry je = new JournalEntry
                    {
                        Description = entryDesc,
                        Total_Debit = amount,
                        Total_Credit = amount
                    };
                    int entryID = journalDAL.AddEntry(je);

                    if (entryID > 0)
                    {
                        if (rbReceipt.Checked)
                        {
                            // سند قبض: مدين الحساب المختار (الصندوق/البنك) - دائن ذمم المشتركين
                            journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = accountID, Debit = amount, Credit = 0 });
                            journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = 4, Debit = 0, Credit = amount });
                        }
                        else
                        {
                            // سند صرف: مدين الحساب المختار (مصروفات) - دائن الصندوق/البنك
                            journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = accountID, Debit = amount, Credit = 0 });
                            journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = 1, Debit = 0, Credit = amount });
                        }
                    }
                }

                UIHelper.ShowSuccess(rbReceipt.Checked ? "تم حفظ سند القبض بنجاح" : "تم حفظ سند الصرف بنجاح");
                txtAmount.Clear();
                txtDescription.Clear();
                txtReference.Clear();
                LoadVouchers();
            }
            catch (Exception ex) { UIHelper.ShowError(ex.Message); }
        }
    }
}
