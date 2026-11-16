namespace datawithForm_ElectricitySystem
{
    partial class FrmPayments
    {
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        private void InitializeComponent()
        {
            this.pnlInput = new System.Windows.Forms.Panel();
            this.lblTitle = new System.Windows.Forms.Label();
            this.lblCust = new System.Windows.Forms.Label();
            this.cmbCustomer = new System.Windows.Forms.ComboBox();
            this.lblInv = new System.Windows.Forms.Label();
            this.cmbInvoice = new System.Windows.Forms.ComboBox();
            this.lblAmt = new System.Windows.Forms.Label();
            this.txtAmount = new System.Windows.Forms.TextBox();
            this.lblMeth = new System.Windows.Forms.Label();
            this.txtMethod = new System.Windows.Forms.TextBox();
            this.lblRef = new System.Windows.Forms.Label();
            this.txtReference = new System.Windows.Forms.TextBox();
            this.btnAdd = new System.Windows.Forms.Button();
            this.pnlDetails = new System.Windows.Forms.Panel();
            this.lblTotalDebt = new System.Windows.Forms.Label();
            this.lblInvoiceTotal = new System.Windows.Forms.Label();
            this.lblPaid = new System.Windows.Forms.Label();
            this.lblRemaining = new System.Windows.Forms.Label();
            this.dgvPayments = new System.Windows.Forms.DataGridView();
            this.pnlInput.SuspendLayout();
            this.pnlDetails.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvPayments)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlInput
            // 
            this.pnlInput.BackColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.pnlInput.Controls.Add(this.btnAdd);
            this.pnlInput.Controls.Add(this.txtReference);
            this.pnlInput.Controls.Add(this.lblRef);
            this.pnlInput.Controls.Add(this.txtMethod);
            this.pnlInput.Controls.Add(this.lblMeth);
            this.pnlInput.Controls.Add(this.txtAmount);
            this.pnlInput.Controls.Add(this.lblAmt);
            this.pnlInput.Controls.Add(this.cmbInvoice);
            this.pnlInput.Controls.Add(this.lblInv);
            this.pnlInput.Controls.Add(this.cmbCustomer);
            this.pnlInput.Controls.Add(this.lblCust);
            this.pnlInput.Controls.Add(this.lblTitle);
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
            this.lblTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.lblTitle.Location = new System.Drawing.Point(15, 10);
            this.lblTitle.Name = "lblTitle";
            this.lblTitle.Size = new System.Drawing.Size(133, 25);
            this.lblTitle.TabIndex = 0;
            this.lblTitle.Text = "تسجيل المدفوعات";
            // 
            // lblCust
            // 
            this.lblCust.AutoSize = true;
            this.lblCust.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblCust.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblCust.Location = new System.Drawing.Point(15, 50);
            this.lblCust.Name = "lblCust";
            this.lblCust.Size = new System.Drawing.Size(60, 19);
            this.lblCust.TabIndex = 1;
            this.lblCust.Text = "المشترك:";
            // 
            // cmbCustomer
            // 
            this.cmbCustomer.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbCustomer.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbCustomer.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbCustomer.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbCustomer.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbCustomer.Location = new System.Drawing.Point(15, 75);
            this.cmbCustomer.Name = "cmbCustomer";
            this.cmbCustomer.Size = new System.Drawing.Size(200, 25);
            this.cmbCustomer.TabIndex = 2;
            this.cmbCustomer.SelectedIndexChanged += new System.EventHandler(this.CmbCustomer_SelectedIndexChanged);
            // 
            // lblInv
            // 
            this.lblInv.AutoSize = true;
            this.lblInv.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblInv.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblInv.Location = new System.Drawing.Point(230, 50);
            this.lblInv.Name = "lblInv";
            this.lblInv.Size = new System.Drawing.Size(55, 19);
            this.lblInv.TabIndex = 3;
            this.lblInv.Text = "الفاتورة:";
            // 
            // cmbInvoice
            // 
            this.cmbInvoice.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbInvoice.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbInvoice.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbInvoice.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbInvoice.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbInvoice.Location = new System.Drawing.Point(230, 75);
            this.cmbInvoice.Name = "cmbInvoice";
            this.cmbInvoice.Size = new System.Drawing.Size(200, 25);
            this.cmbInvoice.TabIndex = 4;
            this.cmbInvoice.SelectedIndexChanged += new System.EventHandler(this.CmbInvoice_SelectedIndexChanged);
            // 
            // lblAmt
            // 
            this.lblAmt.AutoSize = true;
            this.lblAmt.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblAmt.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblAmt.Location = new System.Drawing.Point(445, 50);
            this.lblAmt.Name = "lblAmt";
            this.lblAmt.Size = new System.Drawing.Size(43, 19);
            this.lblAmt.TabIndex = 5;
            this.lblAmt.Text = "المبلغ:";
            // 
            // txtAmount
            // 
            this.txtAmount.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtAmount.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtAmount.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtAmount.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtAmount.Location = new System.Drawing.Point(445, 75);
            this.txtAmount.Name = "txtAmount";
            this.txtAmount.Size = new System.Drawing.Size(130, 25);
            this.txtAmount.TabIndex = 6;
            // 
            // lblMeth
            // 
            this.lblMeth.AutoSize = true;
            this.lblMeth.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblMeth.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblMeth.Location = new System.Drawing.Point(590, 50);
            this.lblMeth.Name = "lblMeth";
            this.lblMeth.Size = new System.Drawing.Size(71, 19);
            this.lblMeth.TabIndex = 7;
            this.lblMeth.Text = "طريقة الدفع:";
            // 
            // txtMethod
            // 
            this.txtMethod.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtMethod.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtMethod.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtMethod.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtMethod.Location = new System.Drawing.Point(590, 75);
            this.txtMethod.Name = "txtMethod";
            this.txtMethod.Size = new System.Drawing.Size(120, 25);
            this.txtMethod.TabIndex = 8;
            this.txtMethod.Text = "نقدي";
            // 
            // lblRef
            // 
            this.lblRef.AutoSize = true;
            this.lblRef.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblRef.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblRef.Location = new System.Drawing.Point(725, 50);
            this.lblRef.Name = "lblRef";
            this.lblRef.Size = new System.Drawing.Size(65, 19);
            this.lblRef.TabIndex = 9;
            this.lblRef.Text = "رقم المرجع:";
            // 
            // txtReference
            // 
            this.txtReference.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtReference.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtReference.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtReference.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtReference.Location = new System.Drawing.Point(725, 75);
            this.txtReference.Name = "txtReference";
            this.txtReference.Size = new System.Drawing.Size(130, 25);
            this.txtReference.TabIndex = 10;
            // 
            // btnAdd
            // 
            this.btnAdd.BackColor = System.Drawing.Color.FromArgb(((int)(34)), ((int)(197)), ((int)(94)));
            this.btnAdd.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnAdd.FlatAppearance.BorderSize = 0;
            this.btnAdd.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAdd.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnAdd.ForeColor = System.Drawing.Color.White;
            this.btnAdd.Location = new System.Drawing.Point(15, 140);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(160, 40);
            this.btnAdd.TabIndex = 11;
            this.btnAdd.Text = "تسجيل الدفعة";
            this.btnAdd.UseVisualStyleBackColor = false;
            this.btnAdd.Click += new System.EventHandler(this.BtnAdd_Click);
            // 
            // pnlDetails
            // 
            this.pnlDetails.BackColor = System.Drawing.Color.FromArgb(((int)(25)), ((int)(35)), ((int)(50)));
            this.pnlDetails.Controls.Add(this.lblRemaining);
            this.pnlDetails.Controls.Add(this.lblPaid);
            this.pnlDetails.Controls.Add(this.lblInvoiceTotal);
            this.pnlDetails.Controls.Add(this.lblTotalDebt);
            this.pnlDetails.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlDetails.Location = new System.Drawing.Point(0, 200);
            this.pnlDetails.Name = "pnlDetails";
            this.pnlDetails.Padding = new System.Windows.Forms.Padding(15, 8, 15, 8);
            this.pnlDetails.Size = new System.Drawing.Size(884, 45);
            this.pnlDetails.TabIndex = 1;
            // 
            // lblTotalDebt
            // 
            this.lblTotalDebt.AutoSize = true;
            this.lblTotalDebt.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.lblTotalDebt.ForeColor = System.Drawing.Color.FromArgb(((int)(239)), ((int)(68)), ((int)(68)));
            this.lblTotalDebt.Location = new System.Drawing.Point(15, 12);
            this.lblTotalDebt.Name = "lblTotalDebt";
            this.lblTotalDebt.Size = new System.Drawing.Size(150, 19);
            this.lblTotalDebt.TabIndex = 0;
            this.lblTotalDebt.Text = "إجمالي المديونية: 0 ريال";
            // 
            // lblInvoiceTotal
            // 
            this.lblInvoiceTotal.AutoSize = true;
            this.lblInvoiceTotal.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.lblInvoiceTotal.ForeColor = System.Drawing.Color.FromArgb(((int)(245)), ((int)(158)), ((int)(11)));
            this.lblInvoiceTotal.Location = new System.Drawing.Point(250, 12);
            this.lblInvoiceTotal.Name = "lblInvoiceTotal";
            this.lblInvoiceTotal.Size = new System.Drawing.Size(150, 19);
            this.lblInvoiceTotal.TabIndex = 1;
            this.lblInvoiceTotal.Text = "إجمالي الفاتورة: 0 ريال";
            // 
            // lblPaid
            // 
            this.lblPaid.AutoSize = true;
            this.lblPaid.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.lblPaid.ForeColor = System.Drawing.Color.FromArgb(((int)(34)), ((int)(197)), ((int)(94)));
            this.lblPaid.Location = new System.Drawing.Point(480, 12);
            this.lblPaid.Name = "lblPaid";
            this.lblPaid.Size = new System.Drawing.Size(120, 19);
            this.lblPaid.TabIndex = 2;
            this.lblPaid.Text = "المدفوع: 0 ريال";
            // 
            // lblRemaining
            // 
            this.lblRemaining.AutoSize = true;
            this.lblRemaining.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.lblRemaining.ForeColor = System.Drawing.Color.FromArgb(((int)(59)), ((int)(130)), ((int)(246)));
            this.lblRemaining.Location = new System.Drawing.Point(680, 12);
            this.lblRemaining.Name = "lblRemaining";
            this.lblRemaining.Size = new System.Drawing.Size(120, 19);
            this.lblRemaining.TabIndex = 3;
            this.lblRemaining.Text = "المتبقي: 0 ريال";
            // 
            // dgvPayments
            // 
            this.dgvPayments.AllowUserToAddRows = false;
            this.dgvPayments.AllowUserToDeleteRows = false;
            this.dgvPayments.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvPayments.BackgroundColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.dgvPayments.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgvPayments.ColumnHeadersHeight = 40;
            this.dgvPayments.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvPayments.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvPayments.EnableHeadersVisualStyles = false;
            this.dgvPayments.GridColor = System.Drawing.Color.FromArgb(((int)(51)), ((int)(65)), ((int)(85)));
            this.dgvPayments.Location = new System.Drawing.Point(0, 245);
            this.dgvPayments.MultiSelect = false;
            this.dgvPayments.Name = "dgvPayments";
            this.dgvPayments.ReadOnly = true;
            this.dgvPayments.RowHeadersVisible = false;
            this.dgvPayments.RowTemplate.Height = 35;
            this.dgvPayments.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvPayments.Size = new System.Drawing.Size(884, 316);
            this.dgvPayments.TabIndex = 2;
            // 
            // FrmPayments
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.ClientSize = new System.Drawing.Size(884, 561);
            this.Controls.Add(this.dgvPayments);
            this.Controls.Add(this.pnlDetails);
            this.Controls.Add(this.pnlInput);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.Name = "FrmPayments";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "تسجيل المدفوعات";
            this.pnlInput.ResumeLayout(false);
            this.pnlInput.PerformLayout();
            this.pnlDetails.ResumeLayout(false);
            this.pnlDetails.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvPayments)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Panel pnlInput;
        private System.Windows.Forms.Label lblTitle;
        private System.Windows.Forms.Label lblCust;
        private System.Windows.Forms.ComboBox cmbCustomer;
        private System.Windows.Forms.Label lblInv;
        private System.Windows.Forms.ComboBox cmbInvoice;
        private System.Windows.Forms.Label lblAmt;
        private System.Windows.Forms.TextBox txtAmount;
        private System.Windows.Forms.Label lblMeth;
        private System.Windows.Forms.TextBox txtMethod;
        private System.Windows.Forms.Label lblRef;
        private System.Windows.Forms.TextBox txtReference;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Panel pnlDetails;
        private System.Windows.Forms.Label lblTotalDebt;
        private System.Windows.Forms.Label lblInvoiceTotal;
        private System.Windows.Forms.Label lblPaid;
        private System.Windows.Forms.Label lblRemaining;
        private System.Windows.Forms.DataGridView dgvPayments;
    }
}
