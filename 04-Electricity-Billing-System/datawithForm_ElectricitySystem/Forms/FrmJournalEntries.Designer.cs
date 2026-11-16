namespace datawithForm_ElectricitySystem
{
    partial class FrmJournalEntries
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
            this.splitContainer = new System.Windows.Forms.SplitContainer();
            this.dgvEntries = new System.Windows.Forms.DataGridView();
            this.lblEntries = new System.Windows.Forms.Label();
            this.dgvLines = new System.Windows.Forms.DataGridView();
            this.lblLines = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer)).BeginInit();
            this.splitContainer.Panel1.SuspendLayout();
            this.splitContainer.Panel2.SuspendLayout();
            this.splitContainer.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvEntries)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvLines)).BeginInit();
            this.SuspendLayout();
            // 
            // splitContainer
            // 
            this.splitContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer.Location = new System.Drawing.Point(0, 0);
            this.splitContainer.Name = "splitContainer";
            this.splitContainer.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer.Panel1
            // 
            this.splitContainer.Panel1.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.splitContainer.Panel1.Controls.Add(this.dgvEntries);
            this.splitContainer.Panel1.Controls.Add(this.lblEntries);
            // 
            // splitContainer.Panel2
            // 
            this.splitContainer.Panel2.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.splitContainer.Panel2.Controls.Add(this.dgvLines);
            this.splitContainer.Panel2.Controls.Add(this.lblLines);
            this.splitContainer.Size = new System.Drawing.Size(884, 561);
            this.splitContainer.SplitterDistance = 280;
            this.splitContainer.SplitterWidth = 5;
            this.splitContainer.TabIndex = 0;
            // 
            // lblEntries
            // 
            this.lblEntries.BackColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.lblEntries.Dock = System.Windows.Forms.DockStyle.Top;
            this.lblEntries.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold);
            this.lblEntries.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.lblEntries.Location = new System.Drawing.Point(0, 0);
            this.lblEntries.Name = "lblEntries";
            this.lblEntries.Padding = new System.Windows.Forms.Padding(15, 0, 0, 0);
            this.lblEntries.Size = new System.Drawing.Size(884, 35);
            this.lblEntries.TabIndex = 0;
            this.lblEntries.Text = "القيود المحاسبية";
            this.lblEntries.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // dgvEntries
            // 
            this.dgvEntries.AllowUserToAddRows = false;
            this.dgvEntries.AllowUserToDeleteRows = false;
            this.dgvEntries.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvEntries.BackgroundColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.dgvEntries.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgvEntries.ColumnHeadersHeight = 40;
            this.dgvEntries.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvEntries.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvEntries.EnableHeadersVisualStyles = false;
            this.dgvEntries.GridColor = System.Drawing.Color.FromArgb(((int)(51)), ((int)(65)), ((int)(85)));
            this.dgvEntries.Location = new System.Drawing.Point(0, 35);
            this.dgvEntries.MultiSelect = false;
            this.dgvEntries.Name = "dgvEntries";
            this.dgvEntries.ReadOnly = true;
            this.dgvEntries.RowHeadersVisible = false;
            this.dgvEntries.RowTemplate.Height = 35;
            this.dgvEntries.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvEntries.Size = new System.Drawing.Size(884, 245);
            this.dgvEntries.TabIndex = 1;
            this.dgvEntries.CellClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.DgvEntries_CellClick);
            // 
            // lblLines
            // 
            this.lblLines.BackColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.lblLines.Dock = System.Windows.Forms.DockStyle.Top;
            this.lblLines.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold);
            this.lblLines.ForeColor = System.Drawing.Color.FromArgb(((int)(59)), ((int)(130)), ((int)(246)));
            this.lblLines.Location = new System.Drawing.Point(0, 0);
            this.lblLines.Name = "lblLines";
            this.lblLines.Padding = new System.Windows.Forms.Padding(15, 0, 0, 0);
            this.lblLines.Size = new System.Drawing.Size(884, 35);
            this.lblLines.TabIndex = 0;
            this.lblLines.Text = "تفاصيل القيد - اختر قيد من الأعلى";
            this.lblLines.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // dgvLines
            // 
            this.dgvLines.AllowUserToAddRows = false;
            this.dgvLines.AllowUserToDeleteRows = false;
            this.dgvLines.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvLines.BackgroundColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.dgvLines.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgvLines.ColumnHeadersHeight = 40;
            this.dgvLines.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvLines.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvLines.EnableHeadersVisualStyles = false;
            this.dgvLines.GridColor = System.Drawing.Color.FromArgb(((int)(51)), ((int)(65)), ((int)(85)));
            this.dgvLines.Location = new System.Drawing.Point(0, 35);
            this.dgvLines.MultiSelect = false;
            this.dgvLines.Name = "dgvLines";
            this.dgvLines.ReadOnly = true;
            this.dgvLines.RowHeadersVisible = false;
            this.dgvLines.RowTemplate.Height = 35;
            this.dgvLines.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvLines.Size = new System.Drawing.Size(884, 241);
            this.dgvLines.TabIndex = 1;
            // 
            // FrmJournalEntries
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.ClientSize = new System.Drawing.Size(884, 561);
            this.Controls.Add(this.splitContainer);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.Name = "FrmJournalEntries";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "القيود المحاسبية";
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer)).EndInit();
            this.splitContainer.Panel1.ResumeLayout(false);
            this.splitContainer.Panel2.ResumeLayout(false);
            this.splitContainer.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvEntries)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dgvLines)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.SplitContainer splitContainer;
        private System.Windows.Forms.Label lblEntries;
        private System.Windows.Forms.DataGridView dgvEntries;
        private System.Windows.Forms.Label lblLines;
        private System.Windows.Forms.DataGridView dgvLines;
    }
}
