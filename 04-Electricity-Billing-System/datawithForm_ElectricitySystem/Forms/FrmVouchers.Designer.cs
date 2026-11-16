namespace datawithForm_ElectricitySystem
{
    partial class FrmVouchers
    {
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null)) components.Dispose();
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        private void InitializeComponent()
        {
            this.pnlInput = new System.Windows.Forms.Panel();
            this.lblTitle = new System.Windows.Forms.Label();
            this.rbReceipt = new System.Windows.Forms.RadioButton();
            this.rbPaymentOut = new System.Windows.Forms.RadioButton();
            this.lblAccount = new System.Windows.Forms.Label();
            this.cmbAccount = new System.Windows.Forms.ComboBox();
            this.lblCustomer = new System.Windows.Forms.Label();
            this.cmbCustomer = new System.Windows.Forms.ComboBox();
            this.lblAmount = new System.Windows.Forms.Label();
            this.txtAmount = new System.Windows.Forms.TextBox();
            this.lblDescription = new System.Windows.Forms.Label();
            this.txtDescription = new System.Windows.Forms.TextBox();
            this.lblMethod = new System.Windows.Forms.Label();
            this.cmbMethod = new System.Windows.Forms.ComboBox();
            this.lblReference = new System.Windows.Forms.Label();
            this.txtReference = new System.Windows.Forms.TextBox();
            this.btnSave = new System.Windows.Forms.Button();
            this.dgv = new System.Windows.Forms.DataGridView();
            this.pnlInput.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlInput
            // 
            this.pnlInput.BackColor = System.Drawing.Color.FromArgb(30, 41, 59);
            this.pnlInput.Controls.Add(this.lblTitle);
            this.pnlInput.Controls.Add(this.rbReceipt);
            this.pnlInput.Controls.Add(this.rbPaymentOut);
            this.pnlInput.Controls.Add(this.lblCustomer);
            this.pnlInput.Controls.Add(this.cmbCustomer);
            this.pnlInput.Controls.Add(this.lblAccount);
            this.pnlInput.Controls.Add(this.cmbAccount);
            this.pnlInput.Controls.Add(this.lblAmount);
            this.pnlInput.Controls.Add(this.txtAmount);
            this.pnlInput.Controls.Add(this.lblDescription);
            this.pnlInput.Controls.Add(this.txtDescription);
            this.pnlInput.Controls.Add(this.lblMethod);
            this.pnlInput.Controls.Add(this.cmbMethod);
            this.pnlInput.Controls.Add(this.lblReference);
            this.pnlInput.Controls.Add(this.txtReference);
            this.pnlInput.Controls.Add(this.btnSave);
            this.pnlInput.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlInput.Location = new System.Drawing.Point(0, 0);
            this.pnlInput.Name = "pnlInput";
            this.pnlInput.Padding = new System.Windows.Forms.Padding(15);
            this.pnlInput.Size = new System.Drawing.Size(884, 200);
            this.pnlInput.TabIndex = 0;
            // 
            // lblTitle
            // 
            this.lblTitle.AutoSize = true;
            this.lblTitle.Font = new System.Drawing.Font("Segoe UI", 14F, System.Drawing.FontStyle.Bold);
            this.lblTitle.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.lblTitle.Location = new System.Drawing.Point(15, 10);
            this.lblTitle.Name = "lblTitle";
            this.lblTitle.Size = new System.Drawing.Size(200, 25);
            this.lblTitle.TabIndex = 0;
            this.lblTitle.Text = "سندات القبض والصرف";
            // 
            // rbReceipt
            // 
            this.rbReceipt.AutoSize = true;
            this.rbReceipt.Checked = true;
            this.rbReceipt.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.rbReceipt.ForeColor = System.Drawing.Color.FromArgb(16, 185, 129);
            this.rbReceipt.Location = new System.Drawing.Point(15, 45);
            this.rbReceipt.Name = "rbReceipt";
            this.rbReceipt.Size = new System.Drawing.Size(90, 23);
            this.rbReceipt.TabIndex = 1;
            this.rbReceipt.TabStop = true;
            this.rbReceipt.Text = "سند قبض";
            this.rbReceipt.CheckedChanged += new System.EventHandler(this.VoucherTypeChanged);
            // 
            // rbPaymentOut
            // 
            this.rbPaymentOut.AutoSize = true;
            this.rbPaymentOut.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.rbPaymentOut.ForeColor = System.Drawing.Color.FromArgb(239, 68, 68);
            this.rbPaymentOut.Location = new System.Drawing.Point(120, 45);
            this.rbPaymentOut.Name = "rbPaymentOut";
            this.rbPaymentOut.Size = new System.Drawing.Size(90, 23);
            this.rbPaymentOut.TabIndex = 2;
            this.rbPaymentOut.Text = "سند صرف";
            this.rbPaymentOut.CheckedChanged += new System.EventHandler(this.VoucherTypeChanged);
            // 
            // lblCustomer
            // 
            this.lblCustomer.AutoSize = true;
            this.lblCustomer.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblCustomer.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184);
            this.lblCustomer.Location = new System.Drawing.Point(15, 80);
            this.lblCustomer.Name = "lblCustomer";
            this.lblCustomer.Size = new System.Drawing.Size(60, 19);
            this.lblCustomer.TabIndex = 3;
            this.lblCustomer.Text = "المشترك:";
            // 
            // cmbCustomer
            // 
            this.cmbCustomer.BackColor = System.Drawing.Color.FromArgb(15, 23, 42);
            this.cmbCustomer.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbCustomer.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbCustomer.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbCustomer.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.cmbCustomer.Location = new System.Drawing.Point(15, 105);
            this.cmbCustomer.Name = "cmbCustomer";
            this.cmbCustomer.Size = new System.Drawing.Size(200, 25);
            this.cmbCustomer.TabIndex = 4;
            // 
            // lblAccount
            // 
            this.lblAccount.AutoSize = true;
            this.lblAccount.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblAccount.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184);
            this.lblAccount.Location = new System.Drawing.Point(230, 80);
            this.lblAccount.Name = "lblAccount";
            this.lblAccount.Size = new System.Drawing.Size(55, 19);
            this.lblAccount.TabIndex = 5;
            this.lblAccount.Text = "الحساب:";
            // 
            // cmbAccount
            // 
            this.cmbAccount.BackColor = System.Drawing.Color.FromArgb(15, 23, 42);
            this.cmbAccount.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbAccount.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbAccount.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbAccount.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.cmbAccount.Location = new System.Drawing.Point(230, 105);
            this.cmbAccount.Name = "cmbAccount";
            this.cmbAccount.Size = new System.Drawing.Size(180, 25);
            this.cmbAccount.TabIndex = 6;
            // 
            // lblAmount
            // 
            this.lblAmount.AutoSize = true;
            this.lblAmount.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblAmount.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184);
            this.lblAmount.Location = new System.Drawing.Point(425, 80);
            this.lblAmount.Name = "lblAmount";
            this.lblAmount.Size = new System.Drawing.Size(45, 19);
            this.lblAmount.TabIndex = 7;
            this.lblAmount.Text = "المبلغ:";
            // 
            // txtAmount
            // 
            this.txtAmount.BackColor = System.Drawing.Color.FromArgb(15, 23, 42);
            this.txtAmount.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtAmount.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtAmount.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.txtAmount.Location = new System.Drawing.Point(425, 105);
            this.txtAmount.Name = "txtAmount";
            this.txtAmount.Size = new System.Drawing.Size(120, 25);
            this.txtAmount.TabIndex = 8;
            // 
            // lblDescription
            // 
            this.lblDescription.AutoSize = true;
            this.lblDescription.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblDescription.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184);
            this.lblDescription.Location = new System.Drawing.Point(560, 80);
            this.lblDescription.Name = "lblDescription";
            this.lblDescription.Size = new System.Drawing.Size(45, 19);
            this.lblDescription.TabIndex = 9;
            this.lblDescription.Text = "البيان:";
            // 
            // txtDescription
            // 
            this.txtDescription.BackColor = System.Drawing.Color.FromArgb(15, 23, 42);
            this.txtDescription.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtDescription.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtDescription.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.txtDescription.Location = new System.Drawing.Point(560, 105);
            this.txtDescription.Name = "txtDescription";
            this.txtDescription.Size = new System.Drawing.Size(300, 25);
            this.txtDescription.TabIndex = 10;
            // 
            // lblMethod
            // 
            this.lblMethod.AutoSize = true;
            this.lblMethod.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblMethod.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184);
            this.lblMethod.Location = new System.Drawing.Point(15, 140);
            this.lblMethod.Name = "lblMethod";
            this.lblMethod.Size = new System.Drawing.Size(75, 19);
            this.lblMethod.TabIndex = 11;
            this.lblMethod.Text = "طريقة الدفع:";
            // 
            // cmbMethod
            // 
            this.cmbMethod.BackColor = System.Drawing.Color.FromArgb(15, 23, 42);
            this.cmbMethod.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbMethod.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbMethod.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.cmbMethod.Items.AddRange(new object[] { "نقدي", "تحويل بنكي", "شيك" });
            this.cmbMethod.Location = new System.Drawing.Point(15, 165);
            this.cmbMethod.Name = "cmbMethod";
            this.cmbMethod.Size = new System.Drawing.Size(150, 25);
            this.cmbMethod.TabIndex = 12;
            this.cmbMethod.Text = "نقدي";
            // 
            // lblReference
            // 
            this.lblReference.AutoSize = true;
            this.lblReference.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblReference.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184);
            this.lblReference.Location = new System.Drawing.Point(180, 140);
            this.lblReference.Name = "lblReference";
            this.lblReference.Size = new System.Drawing.Size(70, 19);
            this.lblReference.TabIndex = 13;
            this.lblReference.Text = "رقم المرجع:";
            // 
            // txtReference
            // 
            this.txtReference.BackColor = System.Drawing.Color.FromArgb(15, 23, 42);
            this.txtReference.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtReference.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtReference.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.txtReference.Location = new System.Drawing.Point(180, 165);
            this.txtReference.Name = "txtReference";
            this.txtReference.Size = new System.Drawing.Size(150, 25);
            this.txtReference.TabIndex = 14;
            // 
            // btnSave
            // 
            this.btnSave.BackColor = System.Drawing.Color.FromArgb(59, 130, 246);
            this.btnSave.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnSave.FlatAppearance.BorderSize = 0;
            this.btnSave.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSave.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnSave.ForeColor = System.Drawing.Color.White;
            this.btnSave.Location = new System.Drawing.Point(350, 155);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(140, 38);
            this.btnSave.TabIndex = 15;
            this.btnSave.Text = "حفظ السند";
            this.btnSave.UseVisualStyleBackColor = false;
            this.btnSave.Click += new System.EventHandler(this.BtnSave_Click);
            // 
            // dgv
            // 
            this.dgv.AllowUserToAddRows = false;
            this.dgv.AllowUserToDeleteRows = false;
            this.dgv.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgv.BackgroundColor = System.Drawing.Color.FromArgb(30, 41, 59);
            this.dgv.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgv.ColumnHeadersHeight = 40;
            this.dgv.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgv.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgv.EnableHeadersVisualStyles = false;
            this.dgv.GridColor = System.Drawing.Color.FromArgb(51, 65, 85);
            this.dgv.Location = new System.Drawing.Point(0, 200);
            this.dgv.MultiSelect = false;
            this.dgv.Name = "dgv";
            this.dgv.ReadOnly = true;
            this.dgv.RowHeadersVisible = false;
            this.dgv.RowTemplate.Height = 35;
            this.dgv.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgv.Size = new System.Drawing.Size(884, 361);
            this.dgv.TabIndex = 1;
            // 
            // FrmVouchers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(15, 23, 42);
            this.ClientSize = new System.Drawing.Size(884, 561);
            this.Controls.Add(this.dgv);
            this.Controls.Add(this.pnlInput);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.Name = "FrmVouchers";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "سندات القبض والصرف";
            this.pnlInput.ResumeLayout(false);
            this.pnlInput.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Panel pnlInput;
        private System.Windows.Forms.Label lblTitle;
        private System.Windows.Forms.RadioButton rbReceipt;
        private System.Windows.Forms.RadioButton rbPaymentOut;
        private System.Windows.Forms.Label lblCustomer;
        private System.Windows.Forms.ComboBox cmbCustomer;
        private System.Windows.Forms.Label lblAccount;
        private System.Windows.Forms.ComboBox cmbAccount;
        private System.Windows.Forms.Label lblAmount;
        private System.Windows.Forms.TextBox txtAmount;
        private System.Windows.Forms.Label lblDescription;
        private System.Windows.Forms.TextBox txtDescription;
        private System.Windows.Forms.Label lblMethod;
        private System.Windows.Forms.ComboBox cmbMethod;
        private System.Windows.Forms.Label lblReference;
        private System.Windows.Forms.TextBox txtReference;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.DataGridView dgv;
    }
}
