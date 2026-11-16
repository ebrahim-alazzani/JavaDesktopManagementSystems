namespace datawithForm_ElectricitySystem
{
    partial class FrmInvoices
    {
        private System.ComponentModel.IContainer components = null;
        protected override void Dispose(bool disposing) { if (disposing && (components != null)) components.Dispose(); base.Dispose(disposing); }

        #region Windows Form Designer generated code

        private void InitializeComponent()
        {
            this.pnlInput = new System.Windows.Forms.Panel();
            this.lblTitle = new System.Windows.Forms.Label();
            this.lblCustomer = new System.Windows.Forms.Label();
            this.cmbCustomer = new System.Windows.Forms.ComboBox();
            this.lblMeter = new System.Windows.Forms.Label();
            this.cmbMeter = new System.Windows.Forms.ComboBox();
            this.lblPeriod = new System.Windows.Forms.Label();
            this.cmbPeriod = new System.Windows.Forms.ComboBox();
            this.lblTariff = new System.Windows.Forms.Label();
            this.cmbTariff = new System.Windows.Forms.ComboBox();
            this.lblPrevReading = new System.Windows.Forms.Label();
            this.txtPrevReading = new System.Windows.Forms.TextBox();
            this.lblCurrReading = new System.Windows.Forms.Label();
            this.txtCurrReading = new System.Windows.Forms.TextBox();
            this.lblConsumption = new System.Windows.Forms.Label();
            this.txtConsumption = new System.Windows.Forms.TextBox();
            this.lblUnitPrice = new System.Windows.Forms.Label();
            this.txtUnitPrice = new System.Windows.Forms.TextBox();
            this.lblFixedFee = new System.Windows.Forms.Label();
            this.txtFixedFee = new System.Windows.Forms.TextBox();
            this.lblAmount = new System.Windows.Forms.Label();
            this.txtAmount = new System.Windows.Forms.TextBox();
            this.lblPrevBalance = new System.Windows.Forms.Label();
            this.txtPrevBalance = new System.Windows.Forms.TextBox();
            this.lblTotal = new System.Windows.Forms.Label();
            this.txtTotal = new System.Windows.Forms.TextBox();
            this.btnCreate = new System.Windows.Forms.Button();
            this.dgvInvoices = new System.Windows.Forms.DataGridView();
            this.pnlInput.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvInvoices)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlInput
            // 
            this.pnlInput.BackColor = System.Drawing.Color.FromArgb(30, 41, 59);
            this.pnlInput.Controls.Add(this.btnCreate);
            this.pnlInput.Controls.Add(this.txtTotal); this.pnlInput.Controls.Add(this.lblTotal);
            this.pnlInput.Controls.Add(this.txtPrevBalance); this.pnlInput.Controls.Add(this.lblPrevBalance);
            this.pnlInput.Controls.Add(this.txtAmount); this.pnlInput.Controls.Add(this.lblAmount);
            this.pnlInput.Controls.Add(this.txtFixedFee); this.pnlInput.Controls.Add(this.lblFixedFee);
            this.pnlInput.Controls.Add(this.txtUnitPrice); this.pnlInput.Controls.Add(this.lblUnitPrice);
            this.pnlInput.Controls.Add(this.txtConsumption); this.pnlInput.Controls.Add(this.lblConsumption);
            this.pnlInput.Controls.Add(this.txtCurrReading); this.pnlInput.Controls.Add(this.lblCurrReading);
            this.pnlInput.Controls.Add(this.txtPrevReading); this.pnlInput.Controls.Add(this.lblPrevReading);
            this.pnlInput.Controls.Add(this.cmbTariff); this.pnlInput.Controls.Add(this.lblTariff);
            this.pnlInput.Controls.Add(this.cmbPeriod); this.pnlInput.Controls.Add(this.lblPeriod);
            this.pnlInput.Controls.Add(this.cmbMeter); this.pnlInput.Controls.Add(this.lblMeter);
            this.pnlInput.Controls.Add(this.cmbCustomer); this.pnlInput.Controls.Add(this.lblCustomer);
            this.pnlInput.Controls.Add(this.lblTitle);
            this.pnlInput.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlInput.Name = "pnlInput";
            this.pnlInput.Padding = new System.Windows.Forms.Padding(15);
            this.pnlInput.Size = new System.Drawing.Size(1034, 310);
            this.pnlInput.TabIndex = 0;
            // 
            // lblTitle
            // 
            this.lblTitle.AutoSize = true; this.lblTitle.Font = new System.Drawing.Font("Segoe UI", 14F, System.Drawing.FontStyle.Bold);
            this.lblTitle.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.lblTitle.Location = new System.Drawing.Point(15, 10);
            this.lblTitle.Name = "lblTitle"; this.lblTitle.Text = "إنشاء فاتورة جديدة";
            // Row 1 - Combos
            this.lblCustomer.AutoSize = true; this.lblCustomer.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblCustomer.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblCustomer.Location = new System.Drawing.Point(15, 50); this.lblCustomer.Text = "المشترك:";
            this.cmbCustomer.BackColor = System.Drawing.Color.FromArgb(15, 23, 42); this.cmbCustomer.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.cmbCustomer.FlatStyle = System.Windows.Forms.FlatStyle.Flat; this.cmbCustomer.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList; this.cmbCustomer.Font = new System.Drawing.Font("Segoe UI", 10F); this.cmbCustomer.Location = new System.Drawing.Point(15, 75); this.cmbCustomer.Size = new System.Drawing.Size(240, 25); this.cmbCustomer.SelectedIndexChanged += new System.EventHandler(this.CmbCustomer_SelectedIndexChanged);
            this.lblMeter.AutoSize = true; this.lblMeter.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblMeter.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblMeter.Location = new System.Drawing.Point(270, 50); this.lblMeter.Text = "العداد:";
            this.cmbMeter.BackColor = System.Drawing.Color.FromArgb(15, 23, 42); this.cmbMeter.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.cmbMeter.FlatStyle = System.Windows.Forms.FlatStyle.Flat; this.cmbMeter.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList; this.cmbMeter.Font = new System.Drawing.Font("Segoe UI", 10F); this.cmbMeter.Location = new System.Drawing.Point(270, 75); this.cmbMeter.Size = new System.Drawing.Size(180, 25); this.cmbMeter.SelectedIndexChanged += new System.EventHandler(this.CmbMeter_SelectedIndexChanged);
            this.lblPeriod.AutoSize = true; this.lblPeriod.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblPeriod.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblPeriod.Location = new System.Drawing.Point(465, 50); this.lblPeriod.Text = "الفترة:";
            this.cmbPeriod.BackColor = System.Drawing.Color.FromArgb(15, 23, 42); this.cmbPeriod.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.cmbPeriod.FlatStyle = System.Windows.Forms.FlatStyle.Flat; this.cmbPeriod.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList; this.cmbPeriod.Font = new System.Drawing.Font("Segoe UI", 10F); this.cmbPeriod.Location = new System.Drawing.Point(465, 75); this.cmbPeriod.Size = new System.Drawing.Size(180, 25);
            this.lblTariff.AutoSize = true; this.lblTariff.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblTariff.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblTariff.Location = new System.Drawing.Point(660, 50); this.lblTariff.Text = "التعرفة:";
            this.cmbTariff.BackColor = System.Drawing.Color.FromArgb(15, 23, 42); this.cmbTariff.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.cmbTariff.FlatStyle = System.Windows.Forms.FlatStyle.Flat; this.cmbTariff.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList; this.cmbTariff.Font = new System.Drawing.Font("Segoe UI", 10F); this.cmbTariff.Location = new System.Drawing.Point(660, 75); this.cmbTariff.Size = new System.Drawing.Size(180, 25); this.cmbTariff.SelectedIndexChanged += new System.EventHandler(this.CmbTariff_SelectedIndexChanged);
            // Row 2 - Readings
            this.lblPrevReading.AutoSize = true; this.lblPrevReading.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblPrevReading.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblPrevReading.Location = new System.Drawing.Point(15, 115); this.lblPrevReading.Text = "القراءة السابقة:";
            this.txtPrevReading.BackColor = System.Drawing.Color.FromArgb(20, 30, 48); this.txtPrevReading.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtPrevReading.Font = new System.Drawing.Font("Segoe UI", 10F); this.txtPrevReading.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.txtPrevReading.Location = new System.Drawing.Point(15, 140); this.txtPrevReading.Size = new System.Drawing.Size(150, 25); this.txtPrevReading.ReadOnly = true;
            this.lblCurrReading.AutoSize = true; this.lblCurrReading.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblCurrReading.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblCurrReading.Location = new System.Drawing.Point(180, 115); this.lblCurrReading.Text = "القراءة الحالية:";
            this.txtCurrReading.BackColor = System.Drawing.Color.FromArgb(15, 23, 42); this.txtCurrReading.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtCurrReading.Font = new System.Drawing.Font("Segoe UI", 10F); this.txtCurrReading.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.txtCurrReading.Location = new System.Drawing.Point(180, 140); this.txtCurrReading.Size = new System.Drawing.Size(150, 25); this.txtCurrReading.TextChanged += new System.EventHandler(this.CalculateInvoice);
            this.lblConsumption.AutoSize = true; this.lblConsumption.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblConsumption.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblConsumption.Location = new System.Drawing.Point(345, 115); this.lblConsumption.Text = "الاستهلاك:";
            this.txtConsumption.BackColor = System.Drawing.Color.FromArgb(20, 30, 48); this.txtConsumption.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtConsumption.Font = new System.Drawing.Font("Segoe UI", 10F); this.txtConsumption.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.txtConsumption.Location = new System.Drawing.Point(345, 140); this.txtConsumption.Size = new System.Drawing.Size(120, 25); this.txtConsumption.ReadOnly = true;
            this.lblUnitPrice.AutoSize = true; this.lblUnitPrice.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblUnitPrice.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblUnitPrice.Location = new System.Drawing.Point(480, 115); this.lblUnitPrice.Text = "سعر الوحدة:";
            this.txtUnitPrice.BackColor = System.Drawing.Color.FromArgb(20, 30, 48); this.txtUnitPrice.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtUnitPrice.Font = new System.Drawing.Font("Segoe UI", 10F); this.txtUnitPrice.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.txtUnitPrice.Location = new System.Drawing.Point(480, 140); this.txtUnitPrice.Size = new System.Drawing.Size(120, 25); this.txtUnitPrice.ReadOnly = true;
            this.lblFixedFee.AutoSize = true; this.lblFixedFee.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblFixedFee.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblFixedFee.Location = new System.Drawing.Point(615, 115); this.lblFixedFee.Text = "الرسم الثابت:";
            this.txtFixedFee.BackColor = System.Drawing.Color.FromArgb(20, 30, 48); this.txtFixedFee.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtFixedFee.Font = new System.Drawing.Font("Segoe UI", 10F); this.txtFixedFee.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.txtFixedFee.Location = new System.Drawing.Point(615, 140); this.txtFixedFee.Size = new System.Drawing.Size(120, 25); this.txtFixedFee.ReadOnly = true;
            // Row 3 - Amounts
            this.lblAmount.AutoSize = true; this.lblAmount.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblAmount.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblAmount.Location = new System.Drawing.Point(15, 180); this.lblAmount.Text = "مبلغ الاستهلاك:";
            this.txtAmount.BackColor = System.Drawing.Color.FromArgb(20, 30, 48); this.txtAmount.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtAmount.Font = new System.Drawing.Font("Segoe UI", 10F); this.txtAmount.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.txtAmount.Location = new System.Drawing.Point(15, 205); this.txtAmount.Size = new System.Drawing.Size(200, 25); this.txtAmount.ReadOnly = true;
            this.lblPrevBalance.AutoSize = true; this.lblPrevBalance.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblPrevBalance.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblPrevBalance.Location = new System.Drawing.Point(230, 180); this.lblPrevBalance.Text = "الرصيد السابق:";
            this.txtPrevBalance.BackColor = System.Drawing.Color.FromArgb(15, 23, 42); this.txtPrevBalance.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtPrevBalance.Font = new System.Drawing.Font("Segoe UI", 10F); this.txtPrevBalance.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249); this.txtPrevBalance.Location = new System.Drawing.Point(230, 205); this.txtPrevBalance.Size = new System.Drawing.Size(200, 25); this.txtPrevBalance.Text = "0"; this.txtPrevBalance.TextChanged += new System.EventHandler(this.CalculateInvoice);
            this.lblTotal.AutoSize = true; this.lblTotal.Font = new System.Drawing.Font("Segoe UI", 10F); this.lblTotal.ForeColor = System.Drawing.Color.FromArgb(148, 163, 184); this.lblTotal.Location = new System.Drawing.Point(445, 180); this.lblTotal.Text = "الإجمالي:";
            this.txtTotal.BackColor = System.Drawing.Color.FromArgb(20, 30, 48); this.txtTotal.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle; this.txtTotal.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold); this.txtTotal.ForeColor = System.Drawing.Color.FromArgb(245, 158, 11); this.txtTotal.Location = new System.Drawing.Point(445, 205); this.txtTotal.Size = new System.Drawing.Size(200, 29); this.txtTotal.ReadOnly = true;
            // 
            // btnCreate
            // 
            this.btnCreate.BackColor = System.Drawing.Color.FromArgb(59, 130, 246); this.btnCreate.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnCreate.FlatAppearance.BorderSize = 0; this.btnCreate.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnCreate.Font = new System.Drawing.Font("Segoe UI", 11F, System.Drawing.FontStyle.Bold); this.btnCreate.ForeColor = System.Drawing.Color.White;
            this.btnCreate.Location = new System.Drawing.Point(15, 255); this.btnCreate.Name = "btnCreate"; this.btnCreate.Size = new System.Drawing.Size(200, 42);
            this.btnCreate.Text = "💾 حفظ الفاتورة"; this.btnCreate.UseVisualStyleBackColor = false;
            this.btnCreate.Click += new System.EventHandler(this.BtnCreate_Click);
            // 
            // dgvInvoices
            // 
            this.dgvInvoices.AllowUserToAddRows = false; this.dgvInvoices.AllowUserToDeleteRows = false;
            this.dgvInvoices.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvInvoices.BackgroundColor = System.Drawing.Color.FromArgb(30, 41, 59); this.dgvInvoices.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgvInvoices.CellBorderStyle = System.Windows.Forms.DataGridViewCellBorderStyle.SingleHorizontal;
            this.dgvInvoices.ColumnHeadersHeight = 40;
            this.dgvInvoices.ColumnHeadersDefaultCellStyle.BackColor = System.Drawing.Color.FromArgb(37, 99, 235);
            this.dgvInvoices.ColumnHeadersDefaultCellStyle.ForeColor = System.Drawing.Color.White;
            this.dgvInvoices.ColumnHeadersDefaultCellStyle.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.dgvInvoices.DefaultCellStyle.BackColor = System.Drawing.Color.FromArgb(30, 41, 59);
            this.dgvInvoices.DefaultCellStyle.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.dgvInvoices.DefaultCellStyle.SelectionBackColor = System.Drawing.Color.FromArgb(59, 130, 246);
            this.dgvInvoices.AlternatingRowsDefaultCellStyle.BackColor = System.Drawing.Color.FromArgb(25, 35, 50);
            this.dgvInvoices.Dock = System.Windows.Forms.DockStyle.Fill; this.dgvInvoices.EnableHeadersVisualStyles = false;
            this.dgvInvoices.GridColor = System.Drawing.Color.FromArgb(51, 65, 85); this.dgvInvoices.MultiSelect = false;
            this.dgvInvoices.Name = "dgvInvoices"; this.dgvInvoices.ReadOnly = true; this.dgvInvoices.RowHeadersVisible = false;
            this.dgvInvoices.RowTemplate.Height = 35; this.dgvInvoices.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            // 
            // FrmInvoices
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F); this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(15, 23, 42); this.ClientSize = new System.Drawing.Size(1034, 661);
            this.Controls.Add(this.dgvInvoices); this.Controls.Add(this.pnlInput);
            this.Font = new System.Drawing.Font("Segoe UI", 10F); this.ForeColor = System.Drawing.Color.FromArgb(241, 245, 249);
            this.Name = "FrmInvoices"; this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true; this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "📄 إدارة الفواتير";
            this.pnlInput.ResumeLayout(false); this.pnlInput.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvInvoices)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Panel pnlInput;
        private System.Windows.Forms.Label lblTitle, lblCustomer, lblMeter, lblPeriod, lblTariff;
        private System.Windows.Forms.Label lblPrevReading, lblCurrReading, lblConsumption, lblUnitPrice, lblFixedFee;
        private System.Windows.Forms.Label lblAmount, lblPrevBalance, lblTotal;
        private System.Windows.Forms.ComboBox cmbCustomer, cmbMeter, cmbPeriod, cmbTariff;
        private System.Windows.Forms.TextBox txtPrevReading, txtCurrReading, txtConsumption, txtUnitPrice, txtFixedFee;
        private System.Windows.Forms.TextBox txtAmount, txtPrevBalance, txtTotal;
        private System.Windows.Forms.Button btnCreate;
        private System.Windows.Forms.DataGridView dgvInvoices;
    }
}
