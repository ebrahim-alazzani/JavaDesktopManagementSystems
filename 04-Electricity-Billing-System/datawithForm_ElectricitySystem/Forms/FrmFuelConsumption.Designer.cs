namespace datawithForm_ElectricitySystem
{
    partial class FrmFuelConsumption
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
            this.btnAdd = new System.Windows.Forms.Button();
            this.txtCost = new System.Windows.Forms.TextBox();
            this.lblCost = new System.Windows.Forms.Label();
            this.txtQuantity = new System.Windows.Forms.TextBox();
            this.lblQuantity = new System.Windows.Forms.Label();
            this.cmbType = new System.Windows.Forms.ComboBox();
            this.lblType2 = new System.Windows.Forms.Label();
            this.cmbAsset = new System.Windows.Forms.ComboBox();
            this.lblAsset = new System.Windows.Forms.Label();
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
            this.pnlInput.Controls.Add(this.btnAdd);
            this.pnlInput.Controls.Add(this.txtCost);
            this.pnlInput.Controls.Add(this.lblCost);
            this.pnlInput.Controls.Add(this.txtQuantity);
            this.pnlInput.Controls.Add(this.lblQuantity);
            this.pnlInput.Controls.Add(this.cmbType);
            this.pnlInput.Controls.Add(this.lblType2);
            this.pnlInput.Controls.Add(this.cmbAsset);
            this.pnlInput.Controls.Add(this.lblAsset);
            this.pnlInput.Controls.Add(this.lblTitle);
            this.pnlInput.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlInput.Location = new System.Drawing.Point(0, 0);
            this.pnlInput.Name = "pnlInput";
            this.pnlInput.Padding = new System.Windows.Forms.Padding(15);
            this.pnlInput.Size = new System.Drawing.Size(834, 180);
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
            this.lblTitle.Text = "استهلاك الوقود";
            // 
            // lblAsset
            // 
            this.lblAsset.AutoSize = true;
            this.lblAsset.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblAsset.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblAsset.Location = new System.Drawing.Point(15, 50);
            this.lblAsset.Name = "lblAsset";
            this.lblAsset.Size = new System.Drawing.Size(43, 19);
            this.lblAsset.TabIndex = 1;
            this.lblAsset.Text = "الأصل:";
            // 
            // cmbAsset
            // 
            this.cmbAsset.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbAsset.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbAsset.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbAsset.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbAsset.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbAsset.Location = new System.Drawing.Point(15, 75);
            this.cmbAsset.Name = "cmbAsset";
            this.cmbAsset.Size = new System.Drawing.Size(200, 25);
            this.cmbAsset.TabIndex = 2;
            // 
            // lblType2
            // 
            this.lblType2.AutoSize = true;
            this.lblType2.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblType2.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblType2.Location = new System.Drawing.Point(230, 50);
            this.lblType2.Name = "lblType2";
            this.lblType2.Size = new System.Drawing.Size(40, 19);
            this.lblType2.TabIndex = 3;
            this.lblType2.Text = "النوع:";
            // 
            // cmbType
            // 
            this.cmbType.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbType.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbType.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbType.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbType.Items.AddRange(new object[] {
            "استهلاك",
            "شراء"});
            this.cmbType.Location = new System.Drawing.Point(230, 75);
            this.cmbType.Name = "cmbType";
            this.cmbType.Size = new System.Drawing.Size(150, 25);
            this.cmbType.TabIndex = 4;
            // 
            // lblQuantity
            // 
            this.lblQuantity.AutoSize = true;
            this.lblQuantity.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblQuantity.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblQuantity.Location = new System.Drawing.Point(395, 50);
            this.lblQuantity.Name = "lblQuantity";
            this.lblQuantity.Size = new System.Drawing.Size(43, 19);
            this.lblQuantity.TabIndex = 5;
            this.lblQuantity.Text = "الكمية:";
            // 
            // txtQuantity
            // 
            this.txtQuantity.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtQuantity.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtQuantity.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtQuantity.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtQuantity.Location = new System.Drawing.Point(395, 75);
            this.txtQuantity.Name = "txtQuantity";
            this.txtQuantity.Size = new System.Drawing.Size(120, 25);
            this.txtQuantity.TabIndex = 6;
            // 
            // lblCost
            // 
            this.lblCost.AutoSize = true;
            this.lblCost.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblCost.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblCost.Location = new System.Drawing.Point(530, 50);
            this.lblCost.Name = "lblCost";
            this.lblCost.Size = new System.Drawing.Size(50, 19);
            this.lblCost.TabIndex = 7;
            this.lblCost.Text = "التكلفة:";
            // 
            // txtCost
            // 
            this.txtCost.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.txtCost.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtCost.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.txtCost.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.txtCost.Location = new System.Drawing.Point(530, 75);
            this.txtCost.Name = "txtCost";
            this.txtCost.Size = new System.Drawing.Size(120, 25);
            this.txtCost.TabIndex = 8;
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
            this.btnAdd.Size = new System.Drawing.Size(140, 38);
            this.btnAdd.TabIndex = 9;
            this.btnAdd.Text = "إضافة";
            this.btnAdd.UseVisualStyleBackColor = false;
            this.btnAdd.Click += new System.EventHandler(this.BtnAdd_Click);
            // 
            // btnDelete
            // 
            this.btnDelete.BackColor = System.Drawing.Color.FromArgb(((int)(239)), ((int)(68)), ((int)(68)));
            this.btnDelete.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnDelete.FlatAppearance.BorderSize = 0;
            this.btnDelete.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnDelete.Font = new System.Drawing.Font("Segoe UI", 10F, System.Drawing.FontStyle.Bold);
            this.btnDelete.ForeColor = System.Drawing.Color.White;
            this.btnDelete.Location = new System.Drawing.Point(165, 120);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(140, 38);
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
            this.dgv.Size = new System.Drawing.Size(834, 331);
            this.dgv.TabIndex = 1;
            // 
            // FrmFuelConsumption
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.ClientSize = new System.Drawing.Size(834, 511);
            this.Controls.Add(this.dgv);
            this.Controls.Add(this.pnlInput);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.Name = "FrmFuelConsumption";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "استهلاك الوقود";
            this.pnlInput.ResumeLayout(false);
            this.pnlInput.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgv)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Panel pnlInput;
        private System.Windows.Forms.Label lblTitle;
        private System.Windows.Forms.Label lblAsset;
        private System.Windows.Forms.ComboBox cmbAsset;
        private System.Windows.Forms.Label lblType2;
        private System.Windows.Forms.ComboBox cmbType;
        private System.Windows.Forms.Label lblQuantity;
        private System.Windows.Forms.TextBox txtQuantity;
        private System.Windows.Forms.Label lblCost;
        private System.Windows.Forms.TextBox txtCost;
        private System.Windows.Forms.Button btnAdd;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.DataGridView dgv;
    }
}
