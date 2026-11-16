namespace datawithForm_ElectricitySystem
{
    partial class FrmMeters
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
            this.btnDelete = new System.Windows.Forms.Button();
            this.btnUpdate = new System.Windows.Forms.Button();
            this.btnAdd = new System.Windows.Forms.Button();
            this.txtOpenReading = new System.Windows.Forms.TextBox();
            this.lblOpenReading = new System.Windows.Forms.Label();
            this.txtLocation = new System.Windows.Forms.TextBox();
            this.lblLocation = new System.Windows.Forms.Label();
            this.cmbCustomer = new System.Windows.Forms.ComboBox();
            this.lblCustomer = new System.Windows.Forms.Label();
            this.txtMeterNo = new System.Windows.Forms.TextBox();
            this.lblMeterNo = new System.Windows.Forms.Label();
            this.lblTitle = new System.Windows.Forms.Label();
            this.dgv = new System.Windows.Forms.DataGridView();
            this.pnlInput.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlInput
            // 
            this.pnlInput.BackColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.pnlInput.Controls.Add(this.btnDelete);
            this.pnlInput.Controls.Add(this.btnUpdate);
            this.pnlInput.Controls.Add(this.btnAdd);
            this.pnlInput.Controls.Add(this.txtOpenReading);
            this.pnlInput.Controls.Add(this.lblOpenReading);
            this.pnlInput.Controls.Add(this.txtLocation);
            this.pnlInput.Controls.Add(this.lblLocation);
            this.pnlInput.Controls.Add(this.cmbCustomer);
            this.pnlInput.Controls.Add(this.lblCustomer);
            this.pnlInput.Controls.Add(this.txtMeterNo);
            this.pnlInput.Controls.Add(this.lblMeterNo);
            this.pnlInput.Controls.Add(this.lblTitle);
            this.pnlInput.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlInput.Location = new System.Drawing.Point(0, 0);
            this.pnlInput.Name = "pnlInput";
            this.pnlInput.Padding = new System.Windows.Forms.Padding(15);
            this.pnlInput.Size = new System.Drawing.Size(884, 180);
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
            this.lblTitle.Text = "إدارة العدادات";
            // 
            // lblMeterNo
            // 
            this.lblMeterNo.AutoSize = true;
            this.lblMeterNo.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblMeterNo.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblMeterNo.Location = new System.Drawing.Point(15, 50);
            this.lblMeterNo.Name = "lblMeterNo";
            this.lblMeterNo.Size = new System.Drawing.Size(68, 19);
            this.lblMeterNo.TabIndex = 1;
            this.lblMeterNo.Text = "رقم العداد:";
            // 
            // txtMeterNo
            // 
            this.txtMeterNo.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtMeterNo.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtMeterNo.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtMeterNo.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtMeterNo.Location = new System.Drawing.Point(15, 75);
            this.txtMeterNo.Name = "txtMeterNo";
            this.txtMeterNo.Size = new System.Drawing.Size(150, 25);
            this.txtMeterNo.TabIndex = 2;
            // 
            // lblCustomer
            // 
            this.lblCustomer.AutoSize = true;
            this.lblCustomer.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblCustomer.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblCustomer.Location = new System.Drawing.Point(180, 50);
            this.lblCustomer.Name = "lblCustomer";
            this.lblCustomer.Size = new System.Drawing.Size(60, 19);
            this.lblCustomer.TabIndex = 3;
            this.lblCustomer.Text = "المشترك:";
            // 
            // cmbCustomer
            // 
            this.cmbCustomer.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbCustomer.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbCustomer.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbCustomer.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbCustomer.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbCustomer.Location = new System.Drawing.Point(180, 75);
            this.cmbCustomer.Name = "cmbCustomer";
            this.cmbCustomer.Size = new System.Drawing.Size(200, 25);
            this.cmbCustomer.TabIndex = 4;
            // 
            // lblLocation
            // 
            this.lblLocation.AutoSize = true;
            this.lblLocation.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblLocation.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblLocation.Location = new System.Drawing.Point(395, 50);
            this.lblLocation.Name = "lblLocation";
            this.lblLocation.Size = new System.Drawing.Size(48, 19);
            this.lblLocation.TabIndex = 5;
            this.lblLocation.Text = "الموقع:";
            // 
            // txtLocation
            // 
            this.txtLocation.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtLocation.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtLocation.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtLocation.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtLocation.Location = new System.Drawing.Point(395, 75);
            this.txtLocation.Name = "txtLocation";
            this.txtLocation.Size = new System.Drawing.Size(180, 25);
            this.txtLocation.TabIndex = 6;
            // 
            // lblOpenReading
            // 
            this.lblOpenReading.AutoSize = true;
            this.lblOpenReading.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblOpenReading.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblOpenReading.Location = new System.Drawing.Point(590, 50);
            this.lblOpenReading.Name = "lblOpenReading";
            this.lblOpenReading.Size = new System.Drawing.Size(100, 19);
            this.lblOpenReading.TabIndex = 7;
            this.lblOpenReading.Text = "القراءة الافتتاحية:";
            // 
            // txtOpenReading
            // 
            this.txtOpenReading.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtOpenReading.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtOpenReading.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtOpenReading.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtOpenReading.Location = new System.Drawing.Point(590, 75);
            this.txtOpenReading.Name = "txtOpenReading";
            this.txtOpenReading.Size = new System.Drawing.Size(130, 25);
            this.txtOpenReading.TabIndex = 8;
            this.txtOpenReading.Text = "0";
            // 
            // btnAdd
            // 
            this.btnAdd.BackColor = System.Drawing.Color.FromArgb(((int)(59)), ((int)(130)), ((int)(246)));
            this.btnAdd.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnAdd.FlatAppearance.BorderSize = 0;
            this.btnAdd.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAdd.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnAdd.ForeColor = System.Drawing.Color.White;
            this.btnAdd.Location = new System.Drawing.Point(15, 120);
            this.btnAdd.Name = "btnAdd";
            this.btnAdd.Size = new System.Drawing.Size(120, 38);
            this.btnAdd.TabIndex = 9;
            this.btnAdd.Text = "إضافة";
            this.btnAdd.UseVisualStyleBackColor = false;
            this.btnAdd.Click += new System.EventHandler(this.BtnAdd_Click);
            // 
            // btnUpdate
            // 
            this.btnUpdate.BackColor = System.Drawing.Color.FromArgb(((int)(245)), ((int)(158)), ((int)(11)));
            this.btnUpdate.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnUpdate.FlatAppearance.BorderSize = 0;
            this.btnUpdate.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnUpdate.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnUpdate.ForeColor = System.Drawing.Color.White;
            this.btnUpdate.Location = new System.Drawing.Point(145, 120);
            this.btnUpdate.Name = "btnUpdate";
            this.btnUpdate.Size = new System.Drawing.Size(120, 38);
            this.btnUpdate.TabIndex = 10;
            this.btnUpdate.Text = "تعديل";
            this.btnUpdate.UseVisualStyleBackColor = false;
            this.btnUpdate.Click += new System.EventHandler(this.BtnUpdate_Click);
            // 
            // btnDelete
            // 
            this.btnDelete.BackColor = System.Drawing.Color.FromArgb(((int)(239)), ((int)(68)), ((int)(68)));
            this.btnDelete.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnDelete.FlatAppearance.BorderSize = 0;
            this.btnDelete.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnDelete.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnDelete.ForeColor = System.Drawing.Color.White;
            this.btnDelete.Location = new System.Drawing.Point(275, 120);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(120, 38);
            this.btnDelete.TabIndex = 11;
            this.btnDelete.Text = "حذف";
            this.btnDelete.UseVisualStyleBackColor = false;
            this.btnDelete.Click += new System.EventHandler(this.BtnDelete_Click);
            // 
            // dgv
            // 
            this.dgv.AllowUserToAddRows = false;
            this.dgv.AllowUserToDeleteRows = false;
            this.dgv.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgv.BackgroundColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.dgv.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgv.ColumnHeadersHeight = 40;
            this.dgv.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgv.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgv.EnableHeadersVisualStyles = false;
            this.dgv.GridColor = System.Drawing.Color.FromArgb(((int)(51)), ((int)(65)), ((int)(85)));
            this.dgv.Location = new System.Drawing.Point(0, 180);
            this.dgv.MultiSelect = false;
            this.dgv.Name = "dgv";
            this.dgv.ReadOnly = true;
            this.dgv.RowHeadersVisible = false;
            this.dgv.RowTemplate.Height = 35;
            this.dgv.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgv.Size = new System.Drawing.Size(884, 381);
            this.dgv.TabIndex = 1;
            this.dgv.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.Dgv_CellClick);
            // 
            // FrmMeters
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.ClientSize = new System.Drawing.Size(884, 561);
            this.Controls.Add(this.dgv);
            this.Controls.Add(this.pnlInput);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.Name = "FrmMeters";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "إدارة العدادات";
            this.pnlInput.ResumeLayout(false);
            this.pnlInput.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Panel pnlInput;
        private System.Windows.Forms.Label lblTitle;
        private System.Windows.Forms.Label lblMeterNo;
        private System.Windows.Forms.TextBox txtMeterNo;
        private System.Windows.Forms.Label lblCustomer;
        private System.Windows.Forms.ComboBox cmbCustomer;
        private System.Windows.Forms.Label lblLocation;
        private System.Windows.Forms.TextBox txtLocation;
        private System.Windows.Forms.Label lblOpenReading;
        private System.Windows.Forms.TextBox txtOpenReading;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnUpdate;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.DataGridView dgv;
    }
}
