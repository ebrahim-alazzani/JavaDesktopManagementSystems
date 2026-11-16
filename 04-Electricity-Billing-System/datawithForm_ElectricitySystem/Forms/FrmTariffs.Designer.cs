namespace datawithForm_ElectricitySystem
{
    partial class FrmTariffs
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
            this.chkActive = new System.Windows.Forms.CheckBox();
            this.txtFee = new System.Windows.Forms.TextBox();
            this.lblFee = new System.Windows.Forms.Label();
            this.txtPrice = new System.Windows.Forms.TextBox();
            this.lblPrice = new System.Windows.Forms.Label();
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
            this.pnlInput.Controls.Add(this.chkActive);
            this.pnlInput.Controls.Add(this.txtFee);
            this.pnlInput.Controls.Add(this.lblFee);
            this.pnlInput.Controls.Add(this.txtPrice);
            this.pnlInput.Controls.Add(this.lblPrice);
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
            this.lblTitle.Size = new System.Drawing.Size(116, 25);
            this.lblTitle.TabIndex = 0;
            this.lblTitle.Text = "إدارة التعرفة";
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblName.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblName.Location = new System.Drawing.Point(15, 50);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(50, 19);
            this.lblName.TabIndex = 1;
            this.lblName.Text = "التعرفة:";
            // 
            // txtName
            // 
            this.txtName.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtName.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtName.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtName.Location = new System.Drawing.Point(15, 75);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(200, 25);
            this.txtName.TabIndex = 2;
            // 
            // lblPrice
            // 
            this.lblPrice.AutoSize = true;
            this.lblPrice.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblPrice.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblPrice.Location = new System.Drawing.Point(230, 50);
            this.lblPrice.Name = "lblPrice";
            this.lblPrice.Size = new System.Drawing.Size(75, 19);
            this.lblPrice.TabIndex = 3;
            this.lblPrice.Text = "سعر الوحدة:";
            // 
            // txtPrice
            // 
            this.txtPrice.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtPrice.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtPrice.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtPrice.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtPrice.Location = new System.Drawing.Point(230, 75);
            this.txtPrice.Name = "txtPrice";
            this.txtPrice.Size = new System.Drawing.Size(150, 25);
            this.txtPrice.TabIndex = 4;
            // 
            // lblFee
            // 
            this.lblFee.AutoSize = true;
            this.lblFee.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblFee.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblFee.Location = new System.Drawing.Point(395, 50);
            this.lblFee.Name = "lblFee";
            this.lblFee.Size = new System.Drawing.Size(78, 19);
            this.lblFee.TabIndex = 5;
            this.lblFee.Text = "الرسم الثابت:";
            // 
            // txtFee
            // 
            this.txtFee.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtFee.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtFee.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtFee.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtFee.Location = new System.Drawing.Point(395, 75);
            this.txtFee.Name = "txtFee";
            this.txtFee.Size = new System.Drawing.Size(150, 25);
            this.txtFee.TabIndex = 6;
            // 
            // chkActive
            // 
            this.chkActive.AutoSize = true;
            this.chkActive.Checked = true;
            this.chkActive.CheckState = System.Windows.Forms.CheckState.Checked;
            this.chkActive.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.chkActive.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.chkActive.Location = new System.Drawing.Point(560, 77);
            this.chkActive.Name = "chkActive";
            this.chkActive.Size = new System.Drawing.Size(52, 23);
            this.chkActive.TabIndex = 7;
            this.chkActive.Text = "نشطة";
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
            this.btnAdd.TabIndex = 8;
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
            this.btnUpdate.TabIndex = 9;
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
            this.btnDelete.TabIndex = 10;
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
            // FrmTariffs
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.ClientSize = new System.Drawing.Size(784, 511);
            this.Controls.Add(this.dgv);
            this.Controls.Add(this.pnlInput);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.Name = "FrmTariffs";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "إدارة التعرفة";
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
        private System.Windows.Forms.Label lblPrice;
        private System.Windows.Forms.TextBox txtPrice;
        private System.Windows.Forms.Label lblFee;
        private System.Windows.Forms.TextBox txtFee;
        private System.Windows.Forms.CheckBox chkActive;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnUpdate;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.DataGridView dgv;
    }
}
