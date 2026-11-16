namespace datawithForm_ElectricitySystem
{
    partial class FrmReports
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
            this.pnlTop = new System.Windows.Forms.Panel();
            this.lblReportTitle = new System.Windows.Forms.Label();
            this.cmbCustomer = new System.Windows.Forms.ComboBox();
            this.lblCustomer = new System.Windows.Forms.Label();
            this.pnlButtons = new System.Windows.Forms.FlowLayoutPanel();
            this.btnLedger = new System.Windows.Forms.Button();
            this.btnAllInvoices = new System.Windows.Forms.Button();
            this.btnDebts = new System.Windows.Forms.Button();
            this.btnPayments = new System.Windows.Forms.Button();
            this.btnJournalReport = new System.Windows.Forms.Button();
            this.btnAssetsReport = new System.Windows.Forms.Button();
            this.btnFuelReport = new System.Windows.Forms.Button();
            this.btnSummary = new System.Windows.Forms.Button();
            this.dgvReport = new System.Windows.Forms.DataGridView();
            this.pnlTop.SuspendLayout();
            this.pnlButtons.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvReport)).BeginInit();
            this.SuspendLayout();
            // 
            // pnlTop
            // 
            this.pnlTop.BackColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.pnlTop.Controls.Add(this.lblReportTitle);
            this.pnlTop.Controls.Add(this.cmbCustomer);
            this.pnlTop.Controls.Add(this.lblCustomer);
            this.pnlTop.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlTop.Location = new System.Drawing.Point(0, 0);
            this.pnlTop.Name = "pnlTop";
            this.pnlTop.Padding = new System.Windows.Forms.Padding(15);
            this.pnlTop.Size = new System.Drawing.Size(984, 60);
            this.pnlTop.TabIndex = 0;
            // 
            // lblReportTitle
            // 
            this.lblReportTitle.AutoSize = true;
            this.lblReportTitle.Font = new System.Drawing.Font("Segoe UI", 14F, System.Drawing.FontStyle.Bold);
            this.lblReportTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(59)), ((int)(130)), ((int)(246)));
            this.lblReportTitle.Location = new System.Drawing.Point(15, 15);
            this.lblReportTitle.Name = "lblReportTitle";
            this.lblReportTitle.Size = new System.Drawing.Size(180, 25);
            this.lblReportTitle.TabIndex = 0;
            this.lblReportTitle.Text = "التقارير - اختر تقرير";
            // 
            // lblCustomer
            // 
            this.lblCustomer.AutoSize = true;
            this.lblCustomer.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblCustomer.ForeColor = System.Drawing.Color.FromArgb(((int)(148)), ((int)(163)), ((int)(184)));
            this.lblCustomer.Location = new System.Drawing.Point(610, 20);
            this.lblCustomer.Name = "lblCustomer";
            this.lblCustomer.Size = new System.Drawing.Size(60, 19);
            this.lblCustomer.TabIndex = 1;
            this.lblCustomer.Text = "المشترك:";
            // 
            // cmbCustomer
            // 
            this.cmbCustomer.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.cmbCustomer.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbCustomer.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.cmbCustomer.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.cmbCustomer.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.cmbCustomer.Location = new System.Drawing.Point(680, 16);
            this.cmbCustomer.Name = "cmbCustomer";
            this.cmbCustomer.Size = new System.Drawing.Size(280, 25);
            this.cmbCustomer.TabIndex = 2;
            // 
            // pnlButtons
            // 
            this.pnlButtons.AutoScroll = true;
            this.pnlButtons.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.pnlButtons.Controls.Add(this.btnLedger);
            this.pnlButtons.Controls.Add(this.btnAllInvoices);
            this.pnlButtons.Controls.Add(this.btnDebts);
            this.pnlButtons.Controls.Add(this.btnPayments);
            this.pnlButtons.Controls.Add(this.btnJournalReport);
            this.pnlButtons.Controls.Add(this.btnAssetsReport);
            this.pnlButtons.Controls.Add(this.btnFuelReport);
            this.pnlButtons.Controls.Add(this.btnSummary);
            this.pnlButtons.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlButtons.Location = new System.Drawing.Point(0, 60);
            this.pnlButtons.Name = "pnlButtons";
            this.pnlButtons.Padding = new System.Windows.Forms.Padding(10, 5, 10, 5);
            this.pnlButtons.Size = new System.Drawing.Size(984, 50);
            this.pnlButtons.TabIndex = 1;
            //
            System.Drawing.Font btnFont = new System.Drawing.Font("Segoe UI", 9F, System.Drawing.FontStyle.Bold);
            System.Drawing.Size btnSz = new System.Drawing.Size(110, 35);
            //
            // btnLedger
            //
            this.btnLedger.BackColor = System.Drawing.Color.FromArgb(((int)(59)), ((int)(130)), ((int)(246)));
            this.btnLedger.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnLedger.FlatAppearance.BorderSize = 0;
            this.btnLedger.Font = btnFont;
            this.btnLedger.ForeColor = System.Drawing.Color.White;
            this.btnLedger.Size = btnSz;
            this.btnLedger.Name = "btnLedger";
            this.btnLedger.Text = "كشف حساب";
            this.btnLedger.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnLedger.Click += new System.EventHandler(this.BtnLedger_Click);
            //
            // btnAllInvoices
            //
            this.btnAllInvoices.BackColor = System.Drawing.Color.FromArgb(((int)(16)), ((int)(185)), ((int)(129)));
            this.btnAllInvoices.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAllInvoices.FlatAppearance.BorderSize = 0;
            this.btnAllInvoices.Font = btnFont;
            this.btnAllInvoices.ForeColor = System.Drawing.Color.White;
            this.btnAllInvoices.Size = btnSz;
            this.btnAllInvoices.Name = "btnAllInvoices";
            this.btnAllInvoices.Text = "الفواتير";
            this.btnAllInvoices.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnAllInvoices.Click += new System.EventHandler(this.BtnAllInvoices_Click);
            //
            // btnDebts
            //
            this.btnDebts.BackColor = System.Drawing.Color.FromArgb(((int)(239)), ((int)(68)), ((int)(68)));
            this.btnDebts.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnDebts.FlatAppearance.BorderSize = 0;
            this.btnDebts.Font = btnFont;
            this.btnDebts.ForeColor = System.Drawing.Color.White;
            this.btnDebts.Size = btnSz;
            this.btnDebts.Name = "btnDebts";
            this.btnDebts.Text = "المديونيات";
            this.btnDebts.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnDebts.Click += new System.EventHandler(this.BtnDebts_Click);
            //
            // btnPayments
            //
            this.btnPayments.BackColor = System.Drawing.Color.FromArgb(((int)(245)), ((int)(158)), ((int)(11)));
            this.btnPayments.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnPayments.FlatAppearance.BorderSize = 0;
            this.btnPayments.Font = btnFont;
            this.btnPayments.ForeColor = System.Drawing.Color.White;
            this.btnPayments.Size = btnSz;
            this.btnPayments.Name = "btnPayments";
            this.btnPayments.Text = "المدفوعات";
            this.btnPayments.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnPayments.Click += new System.EventHandler(this.BtnPayments_Click);
            //
            // btnJournalReport
            //
            this.btnJournalReport.BackColor = System.Drawing.Color.FromArgb(((int)(139)), ((int)(92)), ((int)(246)));
            this.btnJournalReport.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnJournalReport.FlatAppearance.BorderSize = 0;
            this.btnJournalReport.Font = btnFont;
            this.btnJournalReport.ForeColor = System.Drawing.Color.White;
            this.btnJournalReport.Size = btnSz;
            this.btnJournalReport.Name = "btnJournalReport";
            this.btnJournalReport.Text = "القيود";
            this.btnJournalReport.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnJournalReport.Click += new System.EventHandler(this.BtnJournalReport_Click);
            //
            // btnAssetsReport
            //
            this.btnAssetsReport.BackColor = System.Drawing.Color.FromArgb(((int)(20)), ((int)(184)), ((int)(166)));
            this.btnAssetsReport.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnAssetsReport.FlatAppearance.BorderSize = 0;
            this.btnAssetsReport.Font = btnFont;
            this.btnAssetsReport.ForeColor = System.Drawing.Color.White;
            this.btnAssetsReport.Size = btnSz;
            this.btnAssetsReport.Name = "btnAssetsReport";
            this.btnAssetsReport.Text = "الأصول";
            this.btnAssetsReport.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnAssetsReport.Click += new System.EventHandler(this.BtnAssetsReport_Click);
            //
            // btnFuelReport
            //
            this.btnFuelReport.BackColor = System.Drawing.Color.FromArgb(((int)(236)), ((int)(72)), ((int)(153)));
            this.btnFuelReport.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnFuelReport.FlatAppearance.BorderSize = 0;
            this.btnFuelReport.Font = btnFont;
            this.btnFuelReport.ForeColor = System.Drawing.Color.White;
            this.btnFuelReport.Size = btnSz;
            this.btnFuelReport.Name = "btnFuelReport";
            this.btnFuelReport.Text = "الوقود";
            this.btnFuelReport.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnFuelReport.Click += new System.EventHandler(this.BtnFuelReport_Click);
            //
            // btnSummary
            //
            this.btnSummary.BackColor = System.Drawing.Color.FromArgb(((int)(99)), ((int)(102)), ((int)(241)));
            this.btnSummary.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSummary.FlatAppearance.BorderSize = 0;
            this.btnSummary.Font = btnFont;
            this.btnSummary.ForeColor = System.Drawing.Color.White;
            this.btnSummary.Size = btnSz;
            this.btnSummary.Name = "btnSummary";
            this.btnSummary.Text = "ملخص عام";
            this.btnSummary.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnSummary.Click += new System.EventHandler(this.BtnSummary_Click);
            // 
            // dgvReport
            // 
            this.dgvReport.AllowUserToAddRows = false;
            this.dgvReport.AllowUserToDeleteRows = false;
            this.dgvReport.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvReport.BackgroundColor = System.Drawing.Color.FromArgb(((int)(30)), ((int)(41)), ((int)(59)));
            this.dgvReport.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgvReport.ColumnHeadersHeight = 40;
            this.dgvReport.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvReport.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvReport.EnableHeadersVisualStyles = false;
            this.dgvReport.GridColor = System.Drawing.Color.FromArgb(((int)(51)), ((int)(65)), ((int)(85)));
            this.dgvReport.Location = new System.Drawing.Point(0, 110);
            this.dgvReport.MultiSelect = false;
            this.dgvReport.Name = "dgvReport";
            this.dgvReport.ReadOnly = true;
            this.dgvReport.RowHeadersVisible = false;
            this.dgvReport.RowTemplate.Height = 35;
            this.dgvReport.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvReport.Size = new System.Drawing.Size(984, 451);
            this.dgvReport.TabIndex = 2;
            // 
            // FrmReports
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(15)), ((int)(23)), ((int)(42)));
            this.ClientSize = new System.Drawing.Size(984, 561);
            this.Controls.Add(this.dgvReport);
            this.Controls.Add(this.pnlButtons);
            this.Controls.Add(this.pnlTop);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(241)), ((int)(245)), ((int)(249)));
            this.Name = "FrmReports";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "التقارير";
            this.pnlTop.ResumeLayout(false);
            this.pnlTop.PerformLayout();
            this.pnlButtons.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvReport)).EndInit();
            this.ResumeLayout(false);
        }

        #endregion

        private System.Windows.Forms.Panel pnlTop;
        private System.Windows.Forms.Label lblReportTitle;
        private System.Windows.Forms.ComboBox cmbCustomer;
        private System.Windows.Forms.Label lblCustomer;
        private System.Windows.Forms.FlowLayoutPanel pnlButtons;
        private System.Windows.Forms.Button btnLedger;
        private System.Windows.Forms.Button btnAllInvoices;
        private System.Windows.Forms.Button btnDebts;
        private System.Windows.Forms.Button btnPayments;
        private System.Windows.Forms.Button btnJournalReport;
        private System.Windows.Forms.Button btnAssetsReport;
        private System.Windows.Forms.Button btnFuelReport;
        private System.Windows.Forms.Button btnSummary;
        private System.Windows.Forms.DataGridView dgvReport;
    }
}
