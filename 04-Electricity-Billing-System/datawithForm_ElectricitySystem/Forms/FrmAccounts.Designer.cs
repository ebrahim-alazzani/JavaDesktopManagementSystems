namespace datawithForm_ElectricitySystem
{
    partial class FrmAccounts
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
            this.cmbBalance = new System.Windows.Forms.ComboBox();
            this.lblBalance = new System.Windows.Forms.Label();
            this.cmbType = new System.Windows.Forms.ComboBox();
            this.lblType = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.lblName = new System.Windows.Forms.Label();
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
            this.pnlInput.Controls.Add(this.cmbBalance);
            this.pnlInput.Controls.Add(this.lblBalance);
            this.pnlInput.Controls.Add(this.cmbType);
            this.pnlInput.Controls.Add(this.lblType);
            this.pnlInput.Controls.Add(this.txtName);
            this.pnlInput.Controls.Add(this.lblName);
            this.pnlInput.Controls.Add(this.lblTitle);
            this.pnlInput.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlInput.Location = new System.Drawing.Point(0, 0);
            this.pnlInput.Name = "pnlInput";
            this.pnlInput.Padding = new System.Windows.Forms.Padding(15);
            this.pnlInput.Size = new System.Drawing.Size(784, 180);
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
            this.lblTitle.Text = "إدارة الحسابات";
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblName.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblName.Location = new System.Drawing.Point(15, 50);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(78, 19);
            this.lblName.TabIndex = 1;
            this.lblName.Text = "اسم الحساب:";
            // 
            // txtName
            // 
            this.txtName.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtName.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtName.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtName.Location = new System.Drawing.Point(15, 75);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(220, 25);
            this.txtName.TabIndex = 2;
            // 
            // lblType
            // 
            this.lblType.AutoSize = true;
            this.lblType.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblType.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblType.Location = new System.Drawing.Point(250, 50);
            this.lblType.Name = "lblType";
            this.lblType.Size = new System.Drawing.Size(40, 19);
            this.lblType.TabIndex = 3;
            this.lblType.Text = "النوع:";
            // 
            // cmbType
            // 
            this.cmbType.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbType.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbType.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbType.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbType.Items.AddRange(new object[] {
            "أصول",
            "خصوم",
            "حقوق ملكية",
            "إيرادات",
            "مصروفات"});
            this.cmbType.Location = new System.Drawing.Point(250, 75);
            this.cmbType.Name = "cmbType";
            this.cmbType.Size = new System.Drawing.Size(180, 25);
            this.cmbType.TabIndex = 4;
            // 
            // lblBalance
            // 
            this.lblBalance.AutoSize = true;
            this.lblBalance.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblBalance.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblBalance.Location = new System.Drawing.Point(445, 50);
            this.lblBalance.Name = "lblBalance";
            this.lblBalance.Size = new System.Drawing.Size(52, 19);
            this.lblBalance.TabIndex = 5;
            this.lblBalance.Text = "الطبيعة:";
            // 
            // cmbBalance
            // 
            this.cmbBalance.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbBalance.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbBalance.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbBalance.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbBalance.Items.AddRange(new object[] {
            "مدين",
            "دائن"});
            this.cmbBalance.Location = new System.Drawing.Point(445, 75);
            this.cmbBalance.Name = "cmbBalance";
            this.cmbBalance.Size = new System.Drawing.Size(150, 25);
            this.cmbBalance.TabIndex = 6;
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
            this.btnAdd.TabIndex = 7;
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
            this.btnUpdate.TabIndex = 8;
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
            this.btnDelete.TabIndex = 9;
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
            this.dgv.Size = new System.Drawing.Size(784, 331);
            this.dgv.TabIndex = 1;
            this.dgv.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.Dgv_CellClick);
            // 
            // FrmAccounts
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.ClientSize = new System.Drawing.Size(784, 511);
            this.Controls.Add(this.dgv);
            this.Controls.Add(this.pnlInput);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.Name = "FrmAccounts";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "إدارة الحسابات";
            this.pnlInput.ResumeLayout(false);
            this.pnlInput.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Panel pnlInput;
        private System.Windows.Forms.Label lblTitle;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.Label lblType;
        private System.Windows.Forms.ComboBox cmbType;
        private System.Windows.Forms.Label lblBalance;
        private System.Windows.Forms.ComboBox cmbBalance;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnUpdate;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.DataGridView dgv;
    }
}
