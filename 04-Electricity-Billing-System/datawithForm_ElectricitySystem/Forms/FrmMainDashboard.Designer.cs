namespace datawithForm_ElectricitySystem
{
    partial class FrmMainDashboard
    {
        private System.ComponentModel.IContainer components = null;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
                components.Dispose();
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        private void InitializeComponent()
        {
            this.pnlSidebar = new System.Windows.Forms.Panel();
            this.pnlMenuContainer = new System.Windows.Forms.Panel();
            this.btnMenuLogout = new System.Windows.Forms.Button();
            this.btnMenuVouchers = new System.Windows.Forms.Button();
            this.btnMenuUsers = new System.Windows.Forms.Button();
            this.btnMenuReports = new System.Windows.Forms.Button();
            this.btnMenuFuel = new System.Windows.Forms.Button();
            this.btnMenuAssets = new System.Windows.Forms.Button();
            this.btnMenuJournal = new System.Windows.Forms.Button();
            this.btnMenuAccounts = new System.Windows.Forms.Button();
            this.btnMenuPayments = new System.Windows.Forms.Button();
            this.btnMenuInvoices = new System.Windows.Forms.Button();
            this.btnMenuTariffs = new System.Windows.Forms.Button();
            this.btnMenuPeriods = new System.Windows.Forms.Button();
            this.btnMenuMeters = new System.Windows.Forms.Button();
            this.btnMenuCustomers = new System.Windows.Forms.Button();
            this.btnMenuDashboard = new System.Windows.Forms.Button();
            this.lblLogo = new System.Windows.Forms.Label();
            this.pnlContent = new System.Windows.Forms.Panel();
            this.pnlRecentCard = new System.Windows.Forms.Panel();
            this.dgvRecentInvoices = new System.Windows.Forms.DataGridView();
            this.lblRecentTitle = new System.Windows.Forms.Label();
            this.pnlStats = new System.Windows.Forms.FlowLayoutPanel();
            this.pnlCardCustomers = new System.Windows.Forms.Panel();
            this.lblStatCustomersTitle = new System.Windows.Forms.Label();
            this.lblStatCustomers = new System.Windows.Forms.Label();
            this.pnlCardInvoices = new System.Windows.Forms.Panel();
            this.lblStatInvoicesTitle = new System.Windows.Forms.Label();
            this.lblStatInvoices = new System.Windows.Forms.Label();
            this.pnlCardRevenue = new System.Windows.Forms.Panel();
            this.lblStatRevenueTitle = new System.Windows.Forms.Label();
            this.lblStatRevenue = new System.Windows.Forms.Label();
            this.pnlCardDebts = new System.Windows.Forms.Panel();
            this.lblStatDebtsTitle = new System.Windows.Forms.Label();
            this.lblStatDebts = new System.Windows.Forms.Label();
            this.pnlTopBar = new System.Windows.Forms.Panel();
            this.lblDate = new System.Windows.Forms.Label();
            this.lblWelcome = new System.Windows.Forms.Label();
            this.pnlSidebar.SuspendLayout();
            this.pnlMenuContainer.SuspendLayout();
            this.pnlContent.SuspendLayout();
            this.pnlRecentCard.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvRecentInvoices)).BeginInit();
            this.pnlStats.SuspendLayout();
            this.pnlCardCustomers.SuspendLayout();
            this.pnlCardInvoices.SuspendLayout();
            this.pnlCardRevenue.SuspendLayout();
            this.pnlCardDebts.SuspendLayout();
            this.pnlTopBar.SuspendLayout();
            this.SuspendLayout();
            // 
            // pnlSidebar
            // 
            this.pnlSidebar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(41)))), ((int)(((byte)(59)))));
            this.pnlSidebar.Controls.Add(this.pnlMenuContainer);
            this.pnlSidebar.Controls.Add(this.lblLogo);
            this.pnlSidebar.Dock = System.Windows.Forms.DockStyle.Left;
            this.pnlSidebar.Location = new System.Drawing.Point(1026, 0);
            this.pnlSidebar.Name = "pnlSidebar";
            this.pnlSidebar.Padding = new System.Windows.Forms.Padding(5);
            this.pnlSidebar.Size = new System.Drawing.Size(220, 661);
            this.pnlSidebar.TabIndex = 0;
            // 
            // pnlMenuContainer
            // 
            this.pnlMenuContainer.AutoScroll = true;
            this.pnlMenuContainer.Controls.Add(this.btnMenuLogout);
            this.pnlMenuContainer.Controls.Add(this.btnMenuVouchers);
            this.pnlMenuContainer.Controls.Add(this.btnMenuUsers);
            this.pnlMenuContainer.Controls.Add(this.btnMenuReports);
            this.pnlMenuContainer.Controls.Add(this.btnMenuFuel);
            this.pnlMenuContainer.Controls.Add(this.btnMenuAssets);
            this.pnlMenuContainer.Controls.Add(this.btnMenuJournal);
            this.pnlMenuContainer.Controls.Add(this.btnMenuAccounts);
            this.pnlMenuContainer.Controls.Add(this.btnMenuPayments);
            this.pnlMenuContainer.Controls.Add(this.btnMenuInvoices);
            this.pnlMenuContainer.Controls.Add(this.btnMenuTariffs);
            this.pnlMenuContainer.Controls.Add(this.btnMenuPeriods);
            this.pnlMenuContainer.Controls.Add(this.btnMenuMeters);
            this.pnlMenuContainer.Controls.Add(this.btnMenuCustomers);
            this.pnlMenuContainer.Controls.Add(this.btnMenuDashboard);
            this.pnlMenuContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pnlMenuContainer.Location = new System.Drawing.Point(5, 55);
            this.pnlMenuContainer.Name = "pnlMenuContainer";
            this.pnlMenuContainer.Size = new System.Drawing.Size(210, 601);
            this.pnlMenuContainer.TabIndex = 1;
            // 
            // btnMenuLogout
            // 
            this.btnMenuLogout.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuLogout.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuLogout.FlatAppearance.BorderSize = 0;
            this.btnMenuLogout.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuLogout.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuLogout.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(239)))), ((int)(((byte)(68)))), ((int)(((byte)(68)))));
            this.btnMenuLogout.Location = new System.Drawing.Point(3, 593);
            this.btnMenuLogout.Name = "btnMenuLogout";
            this.btnMenuLogout.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuLogout.Size = new System.Drawing.Size(200, 38);
            this.btnMenuLogout.TabIndex = 14;
            this.btnMenuLogout.Text = "🚪 تسجيل الخروج";
            this.btnMenuLogout.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuLogout.UseVisualStyleBackColor = false;
            this.btnMenuLogout.Click += new System.EventHandler(this.BtnMenuLogout_Click);
            // 
            // btnMenuVouchers
            // 
            this.btnMenuVouchers.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuVouchers.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuVouchers.FlatAppearance.BorderSize = 0;
            this.btnMenuVouchers.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuVouchers.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuVouchers.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuVouchers.Location = new System.Drawing.Point(3, 551);
            this.btnMenuVouchers.Name = "btnMenuVouchers";
            this.btnMenuVouchers.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuVouchers.Size = new System.Drawing.Size(200, 38);
            this.btnMenuVouchers.TabIndex = 13;
            this.btnMenuVouchers.Text = "📄 السندات";
            this.btnMenuVouchers.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuVouchers.UseVisualStyleBackColor = false;
            this.btnMenuVouchers.Click += new System.EventHandler(this.BtnMenuVouchers_Click);
            // 
            // btnMenuUsers
            // 
            this.btnMenuUsers.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuUsers.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuUsers.FlatAppearance.BorderSize = 0;
            this.btnMenuUsers.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuUsers.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuUsers.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuUsers.Location = new System.Drawing.Point(3, 509);
            this.btnMenuUsers.Name = "btnMenuUsers";
            this.btnMenuUsers.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuUsers.Size = new System.Drawing.Size(200, 38);
            this.btnMenuUsers.TabIndex = 12;
            this.btnMenuUsers.Text = "👤 المستخدمين";
            this.btnMenuUsers.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuUsers.UseVisualStyleBackColor = false;
            this.btnMenuUsers.Click += new System.EventHandler(this.BtnMenuUsers_Click);
            // 
            // btnMenuReports
            // 
            this.btnMenuReports.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuReports.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuReports.FlatAppearance.BorderSize = 0;
            this.btnMenuReports.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuReports.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuReports.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuReports.Location = new System.Drawing.Point(3, 467);
            this.btnMenuReports.Name = "btnMenuReports";
            this.btnMenuReports.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuReports.Size = new System.Drawing.Size(200, 38);
            this.btnMenuReports.TabIndex = 11;
            this.btnMenuReports.Text = "📊 التقارير";
            this.btnMenuReports.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuReports.UseVisualStyleBackColor = false;
            this.btnMenuReports.Click += new System.EventHandler(this.BtnMenuReports_Click);
            // 
            // btnMenuFuel
            // 
            this.btnMenuFuel.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuFuel.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuFuel.FlatAppearance.BorderSize = 0;
            this.btnMenuFuel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuFuel.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuFuel.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuFuel.Location = new System.Drawing.Point(3, 425);
            this.btnMenuFuel.Name = "btnMenuFuel";
            this.btnMenuFuel.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuFuel.Size = new System.Drawing.Size(200, 38);
            this.btnMenuFuel.TabIndex = 10;
            this.btnMenuFuel.Text = "⛽ استهلاك الوقود";
            this.btnMenuFuel.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuFuel.UseVisualStyleBackColor = false;
            this.btnMenuFuel.Click += new System.EventHandler(this.BtnMenuFuel_Click);
            // 
            // btnMenuAssets
            // 
            this.btnMenuAssets.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuAssets.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuAssets.FlatAppearance.BorderSize = 0;
            this.btnMenuAssets.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuAssets.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuAssets.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuAssets.Location = new System.Drawing.Point(3, 383);
            this.btnMenuAssets.Name = "btnMenuAssets";
            this.btnMenuAssets.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuAssets.Size = new System.Drawing.Size(200, 38);
            this.btnMenuAssets.TabIndex = 9;
            this.btnMenuAssets.Text = "🏭 الأصول الثابتة";
            this.btnMenuAssets.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuAssets.UseVisualStyleBackColor = false;
            this.btnMenuAssets.Click += new System.EventHandler(this.BtnMenuAssets_Click);
            // 
            // btnMenuJournal
            // 
            this.btnMenuJournal.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuJournal.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuJournal.FlatAppearance.BorderSize = 0;
            this.btnMenuJournal.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuJournal.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuJournal.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuJournal.Location = new System.Drawing.Point(3, 341);
            this.btnMenuJournal.Name = "btnMenuJournal";
            this.btnMenuJournal.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuJournal.Size = new System.Drawing.Size(200, 38);
            this.btnMenuJournal.TabIndex = 8;
            this.btnMenuJournal.Text = "📝 القيود المحاسبية";
            this.btnMenuJournal.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuJournal.UseVisualStyleBackColor = false;
            this.btnMenuJournal.Click += new System.EventHandler(this.BtnMenuJournal_Click);
            // 
            // btnMenuAccounts
            // 
            this.btnMenuAccounts.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuAccounts.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuAccounts.FlatAppearance.BorderSize = 0;
            this.btnMenuAccounts.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuAccounts.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuAccounts.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuAccounts.Location = new System.Drawing.Point(3, 299);
            this.btnMenuAccounts.Name = "btnMenuAccounts";
            this.btnMenuAccounts.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuAccounts.Size = new System.Drawing.Size(200, 38);
            this.btnMenuAccounts.TabIndex = 7;
            this.btnMenuAccounts.Text = "🏢 الحسابات";
            this.btnMenuAccounts.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuAccounts.UseVisualStyleBackColor = false;
            this.btnMenuAccounts.Click += new System.EventHandler(this.BtnMenuAccounts_Click);
            // 
            // btnMenuPayments
            // 
            this.btnMenuPayments.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuPayments.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuPayments.FlatAppearance.BorderSize = 0;
            this.btnMenuPayments.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuPayments.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuPayments.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuPayments.Location = new System.Drawing.Point(3, 257);
            this.btnMenuPayments.Name = "btnMenuPayments";
            this.btnMenuPayments.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuPayments.Size = new System.Drawing.Size(200, 38);
            this.btnMenuPayments.TabIndex = 6;
            this.btnMenuPayments.Text = "💵 المدفوعات";
            this.btnMenuPayments.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuPayments.UseVisualStyleBackColor = false;
            this.btnMenuPayments.Click += new System.EventHandler(this.BtnMenuPayments_Click);
            // 
            // btnMenuInvoices
            // 
            this.btnMenuInvoices.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuInvoices.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuInvoices.FlatAppearance.BorderSize = 0;
            this.btnMenuInvoices.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuInvoices.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuInvoices.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuInvoices.Location = new System.Drawing.Point(3, 215);
            this.btnMenuInvoices.Name = "btnMenuInvoices";
            this.btnMenuInvoices.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuInvoices.Size = new System.Drawing.Size(200, 38);
            this.btnMenuInvoices.TabIndex = 5;
            this.btnMenuInvoices.Text = "📄 الفواتير";
            this.btnMenuInvoices.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuInvoices.UseVisualStyleBackColor = false;
            this.btnMenuInvoices.Click += new System.EventHandler(this.BtnMenuInvoices_Click);
            // 
            // btnMenuTariffs
            // 
            this.btnMenuTariffs.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuTariffs.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuTariffs.FlatAppearance.BorderSize = 0;
            this.btnMenuTariffs.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuTariffs.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuTariffs.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuTariffs.Location = new System.Drawing.Point(3, 173);
            this.btnMenuTariffs.Name = "btnMenuTariffs";
            this.btnMenuTariffs.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuTariffs.Size = new System.Drawing.Size(200, 38);
            this.btnMenuTariffs.TabIndex = 4;
            this.btnMenuTariffs.Text = "💰 التعرفة";
            this.btnMenuTariffs.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuTariffs.UseVisualStyleBackColor = false;
            this.btnMenuTariffs.Click += new System.EventHandler(this.BtnMenuTariffs_Click);
            // 
            // btnMenuPeriods
            // 
            this.btnMenuPeriods.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuPeriods.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuPeriods.FlatAppearance.BorderSize = 0;
            this.btnMenuPeriods.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuPeriods.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuPeriods.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuPeriods.Location = new System.Drawing.Point(3, 131);
            this.btnMenuPeriods.Name = "btnMenuPeriods";
            this.btnMenuPeriods.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuPeriods.Size = new System.Drawing.Size(200, 38);
            this.btnMenuPeriods.TabIndex = 3;
            this.btnMenuPeriods.Text = "📋 فترات الفوترة";
            this.btnMenuPeriods.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuPeriods.UseVisualStyleBackColor = false;
            this.btnMenuPeriods.Click += new System.EventHandler(this.BtnMenuPeriods_Click);
            // 
            // btnMenuMeters
            // 
            this.btnMenuMeters.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuMeters.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuMeters.FlatAppearance.BorderSize = 0;
            this.btnMenuMeters.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuMeters.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuMeters.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuMeters.Location = new System.Drawing.Point(3, 89);
            this.btnMenuMeters.Name = "btnMenuMeters";
            this.btnMenuMeters.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuMeters.Size = new System.Drawing.Size(200, 38);
            this.btnMenuMeters.TabIndex = 2;
            this.btnMenuMeters.Text = "📊 العدادات";
            this.btnMenuMeters.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuMeters.UseVisualStyleBackColor = false;
            this.btnMenuMeters.Click += new System.EventHandler(this.BtnMenuMeters_Click);
            // 
            // btnMenuCustomers
            // 
            this.btnMenuCustomers.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuCustomers.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuCustomers.FlatAppearance.BorderSize = 0;
            this.btnMenuCustomers.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuCustomers.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuCustomers.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuCustomers.Location = new System.Drawing.Point(3, 47);
            this.btnMenuCustomers.Name = "btnMenuCustomers";
            this.btnMenuCustomers.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuCustomers.Size = new System.Drawing.Size(200, 38);
            this.btnMenuCustomers.TabIndex = 1;
            this.btnMenuCustomers.Text = "👥 المشتركين";
            this.btnMenuCustomers.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuCustomers.UseVisualStyleBackColor = false;
            this.btnMenuCustomers.Click += new System.EventHandler(this.BtnMenuCustomers_Click);
            // 
            // btnMenuDashboard
            // 
            this.btnMenuDashboard.BackColor = System.Drawing.Color.Transparent;
            this.btnMenuDashboard.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btnMenuDashboard.FlatAppearance.BorderSize = 0;
            this.btnMenuDashboard.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnMenuDashboard.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.btnMenuDashboard.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.btnMenuDashboard.Location = new System.Drawing.Point(3, 5);
            this.btnMenuDashboard.Name = "btnMenuDashboard";
            this.btnMenuDashboard.Padding = new System.Windows.Forms.Padding(0, 0, 10, 0);
            this.btnMenuDashboard.Size = new System.Drawing.Size(200, 38);
            this.btnMenuDashboard.TabIndex = 0;
            this.btnMenuDashboard.Text = "🏠 لوحة التحكم";
            this.btnMenuDashboard.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.btnMenuDashboard.UseVisualStyleBackColor = false;
            this.btnMenuDashboard.Click += new System.EventHandler(this.BtnMenuDashboard_Click);
            // 
            // lblLogo
            // 
            this.lblLogo.Dock = System.Windows.Forms.DockStyle.Top;
            this.lblLogo.Font = new System.Drawing.Font("Segoe UI", 13F, System.Drawing.FontStyle.Bold);
            this.lblLogo.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(59)))), ((int)(((byte)(130)))), ((int)(((byte)(246)))));
            this.lblLogo.Location = new System.Drawing.Point(5, 5);
            this.lblLogo.Name = "lblLogo";
            this.lblLogo.Size = new System.Drawing.Size(210, 50);
            this.lblLogo.TabIndex = 0;
            this.lblLogo.Text = "⚡ نظام الكهرباء";
            this.lblLogo.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // pnlContent
            // 
            this.pnlContent.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(15)))), ((int)(((byte)(23)))), ((int)(((byte)(42)))));
            this.pnlContent.Controls.Add(this.pnlRecentCard);
            this.pnlContent.Controls.Add(this.pnlStats);
            this.pnlContent.Controls.Add(this.pnlTopBar);
            this.pnlContent.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pnlContent.Location = new System.Drawing.Point(0, 0);
            this.pnlContent.Name = "pnlContent";
            this.pnlContent.Padding = new System.Windows.Forms.Padding(20);
            this.pnlContent.Size = new System.Drawing.Size(1026, 661);
            this.pnlContent.TabIndex = 1;
            this.pnlContent.Paint += new System.Windows.Forms.PaintEventHandler(this.pnlContent_Paint);
            // 
            // pnlRecentCard
            // 
            this.pnlRecentCard.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(41)))), ((int)(((byte)(59)))));
            this.pnlRecentCard.Controls.Add(this.dgvRecentInvoices);
            this.pnlRecentCard.Controls.Add(this.lblRecentTitle);
            this.pnlRecentCard.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pnlRecentCard.Location = new System.Drawing.Point(20, 190);
            this.pnlRecentCard.Name = "pnlRecentCard";
            this.pnlRecentCard.Padding = new System.Windows.Forms.Padding(15);
            this.pnlRecentCard.Size = new System.Drawing.Size(986, 451);
            this.pnlRecentCard.TabIndex = 2;
            // 
            // dgvRecentInvoices
            // 
            this.dgvRecentInvoices.AllowUserToAddRows = false;
            this.dgvRecentInvoices.AllowUserToDeleteRows = false;
            this.dgvRecentInvoices.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dgvRecentInvoices.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(41)))), ((int)(((byte)(59)))));
            this.dgvRecentInvoices.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.dgvRecentInvoices.CellBorderStyle = System.Windows.Forms.DataGridViewCellBorderStyle.SingleHorizontal;
            this.dgvRecentInvoices.ColumnHeadersHeight = 40;
            this.dgvRecentInvoices.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.DisableResizing;
            this.dgvRecentInvoices.Dock = System.Windows.Forms.DockStyle.Fill;
            this.dgvRecentInvoices.EnableHeadersVisualStyles = false;
            this.dgvRecentInvoices.GridColor = System.Drawing.Color.FromArgb(((int)(((byte)(51)))), ((int)(((byte)(65)))), ((int)(((byte)(85)))));
            this.dgvRecentInvoices.Location = new System.Drawing.Point(15, 50);
            this.dgvRecentInvoices.MultiSelect = false;
            this.dgvRecentInvoices.Name = "dgvRecentInvoices";
            this.dgvRecentInvoices.ReadOnly = true;
            this.dgvRecentInvoices.RowHeadersVisible = false;
            this.dgvRecentInvoices.RowTemplate.Height = 35;
            this.dgvRecentInvoices.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvRecentInvoices.Size = new System.Drawing.Size(956, 386);
            this.dgvRecentInvoices.TabIndex = 1;
            // 
            // lblRecentTitle
            // 
            this.lblRecentTitle.Dock = System.Windows.Forms.DockStyle.Top;
            this.lblRecentTitle.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold);
            this.lblRecentTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(245)))), ((int)(((byte)(249)))));
            this.lblRecentTitle.Location = new System.Drawing.Point(15, 15);
            this.lblRecentTitle.Name = "lblRecentTitle";
            this.lblRecentTitle.Size = new System.Drawing.Size(956, 35);
            this.lblRecentTitle.TabIndex = 0;
            this.lblRecentTitle.Text = "📋 آخر الفواتير";
            // 
            // pnlStats
            // 
            this.pnlStats.Controls.Add(this.pnlCardCustomers);
            this.pnlStats.Controls.Add(this.pnlCardInvoices);
            this.pnlStats.Controls.Add(this.pnlCardRevenue);
            this.pnlStats.Controls.Add(this.pnlCardDebts);
            this.pnlStats.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlStats.FlowDirection = System.Windows.Forms.FlowDirection.RightToLeft;
            this.pnlStats.Location = new System.Drawing.Point(20, 80);
            this.pnlStats.Name = "pnlStats";
            this.pnlStats.Padding = new System.Windows.Forms.Padding(0, 10, 0, 0);
            this.pnlStats.Size = new System.Drawing.Size(986, 110);
            this.pnlStats.TabIndex = 1;
            this.pnlStats.WrapContents = false;
            // 
            // pnlCardCustomers
            // 
            this.pnlCardCustomers.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(59)))), ((int)(((byte)(130)))), ((int)(((byte)(246)))));
            this.pnlCardCustomers.Controls.Add(this.lblStatCustomersTitle);
            this.pnlCardCustomers.Controls.Add(this.lblStatCustomers);
            this.pnlCardCustomers.Location = new System.Drawing.Point(8, 18);
            this.pnlCardCustomers.Margin = new System.Windows.Forms.Padding(8);
            this.pnlCardCustomers.Name = "pnlCardCustomers";
            this.pnlCardCustomers.Size = new System.Drawing.Size(215, 90);
            this.pnlCardCustomers.TabIndex = 0;
            // 
            // lblStatCustomersTitle
            // 
            this.lblStatCustomersTitle.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblStatCustomersTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(220)))), ((int)(((byte)(220)))), ((int)(((byte)(220)))));
            this.lblStatCustomersTitle.Location = new System.Drawing.Point(12, 55);
            this.lblStatCustomersTitle.Name = "lblStatCustomersTitle";
            this.lblStatCustomersTitle.Size = new System.Drawing.Size(190, 25);
            this.lblStatCustomersTitle.TabIndex = 1;
            this.lblStatCustomersTitle.Text = "إجمالي المشتركين";
            // 
            // lblStatCustomers
            // 
            this.lblStatCustomers.Font = new System.Drawing.Font("Segoe UI", 22F, System.Drawing.FontStyle.Bold);
            this.lblStatCustomers.ForeColor = System.Drawing.Color.White;
            this.lblStatCustomers.Location = new System.Drawing.Point(12, 8);
            this.lblStatCustomers.Name = "lblStatCustomers";
            this.lblStatCustomers.Size = new System.Drawing.Size(190, 40);
            this.lblStatCustomers.TabIndex = 0;
            this.lblStatCustomers.Text = "0";
            // 
            // pnlCardInvoices
            // 
            this.pnlCardInvoices.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(34)))), ((int)(((byte)(197)))), ((int)(((byte)(94)))));
            this.pnlCardInvoices.Controls.Add(this.lblStatInvoicesTitle);
            this.pnlCardInvoices.Controls.Add(this.lblStatInvoices);
            this.pnlCardInvoices.Location = new System.Drawing.Point(239, 18);
            this.pnlCardInvoices.Margin = new System.Windows.Forms.Padding(8);
            this.pnlCardInvoices.Name = "pnlCardInvoices";
            this.pnlCardInvoices.Size = new System.Drawing.Size(215, 90);
            this.pnlCardInvoices.TabIndex = 1;
            // 
            // lblStatInvoicesTitle
            // 
            this.lblStatInvoicesTitle.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblStatInvoicesTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(220)))), ((int)(((byte)(220)))), ((int)(((byte)(220)))));
            this.lblStatInvoicesTitle.Location = new System.Drawing.Point(12, 55);
            this.lblStatInvoicesTitle.Name = "lblStatInvoicesTitle";
            this.lblStatInvoicesTitle.Size = new System.Drawing.Size(190, 25);
            this.lblStatInvoicesTitle.TabIndex = 1;
            this.lblStatInvoicesTitle.Text = "إجمالي الفواتير";
            // 
            // lblStatInvoices
            // 
            this.lblStatInvoices.Font = new System.Drawing.Font("Segoe UI", 22F, System.Drawing.FontStyle.Bold);
            this.lblStatInvoices.ForeColor = System.Drawing.Color.White;
            this.lblStatInvoices.Location = new System.Drawing.Point(12, 8);
            this.lblStatInvoices.Name = "lblStatInvoices";
            this.lblStatInvoices.Size = new System.Drawing.Size(190, 40);
            this.lblStatInvoices.TabIndex = 0;
            this.lblStatInvoices.Text = "0";
            // 
            // pnlCardRevenue
            // 
            this.pnlCardRevenue.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(245)))), ((int)(((byte)(158)))), ((int)(((byte)(11)))));
            this.pnlCardRevenue.Controls.Add(this.lblStatRevenueTitle);
            this.pnlCardRevenue.Controls.Add(this.lblStatRevenue);
            this.pnlCardRevenue.Location = new System.Drawing.Point(470, 18);
            this.pnlCardRevenue.Margin = new System.Windows.Forms.Padding(8);
            this.pnlCardRevenue.Name = "pnlCardRevenue";
            this.pnlCardRevenue.Size = new System.Drawing.Size(215, 90);
            this.pnlCardRevenue.TabIndex = 2;
            // 
            // lblStatRevenueTitle
            // 
            this.lblStatRevenueTitle.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblStatRevenueTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(220)))), ((int)(((byte)(220)))), ((int)(((byte)(220)))));
            this.lblStatRevenueTitle.Location = new System.Drawing.Point(12, 55);
            this.lblStatRevenueTitle.Name = "lblStatRevenueTitle";
            this.lblStatRevenueTitle.Size = new System.Drawing.Size(190, 25);
            this.lblStatRevenueTitle.TabIndex = 1;
            this.lblStatRevenueTitle.Text = "إجمالي الإيرادات";
            // 
            // lblStatRevenue
            // 
            this.lblStatRevenue.Font = new System.Drawing.Font("Segoe UI", 22F, System.Drawing.FontStyle.Bold);
            this.lblStatRevenue.ForeColor = System.Drawing.Color.White;
            this.lblStatRevenue.Location = new System.Drawing.Point(12, 8);
            this.lblStatRevenue.Name = "lblStatRevenue";
            this.lblStatRevenue.Size = new System.Drawing.Size(190, 40);
            this.lblStatRevenue.TabIndex = 0;
            this.lblStatRevenue.Text = "0";
            // 
            // pnlCardDebts
            // 
            this.pnlCardDebts.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(239)))), ((int)(((byte)(68)))), ((int)(((byte)(68)))));
            this.pnlCardDebts.Controls.Add(this.lblStatDebtsTitle);
            this.pnlCardDebts.Controls.Add(this.lblStatDebts);
            this.pnlCardDebts.Location = new System.Drawing.Point(701, 18);
            this.pnlCardDebts.Margin = new System.Windows.Forms.Padding(8);
            this.pnlCardDebts.Name = "pnlCardDebts";
            this.pnlCardDebts.Size = new System.Drawing.Size(215, 90);
            this.pnlCardDebts.TabIndex = 3;
            // 
            // lblStatDebtsTitle
            // 
            this.lblStatDebtsTitle.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.lblStatDebtsTitle.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(220)))), ((int)(((byte)(220)))), ((int)(((byte)(220)))));
            this.lblStatDebtsTitle.Location = new System.Drawing.Point(12, 55);
            this.lblStatDebtsTitle.Name = "lblStatDebtsTitle";
            this.lblStatDebtsTitle.Size = new System.Drawing.Size(190, 25);
            this.lblStatDebtsTitle.TabIndex = 1;
            this.lblStatDebtsTitle.Text = "إجمالي المديونيات";
            // 
            // lblStatDebts
            // 
            this.lblStatDebts.Font = new System.Drawing.Font("Segoe UI", 22F, System.Drawing.FontStyle.Bold);
            this.lblStatDebts.ForeColor = System.Drawing.Color.White;
            this.lblStatDebts.Location = new System.Drawing.Point(12, 8);
            this.lblStatDebts.Name = "lblStatDebts";
            this.lblStatDebts.Size = new System.Drawing.Size(190, 40);
            this.lblStatDebts.TabIndex = 0;
            this.lblStatDebts.Text = "0";
            // 
            // pnlTopBar
            // 
            this.pnlTopBar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(30)))), ((int)(((byte)(41)))), ((int)(((byte)(59)))));
            this.pnlTopBar.Controls.Add(this.lblDate);
            this.pnlTopBar.Controls.Add(this.lblWelcome);
            this.pnlTopBar.Dock = System.Windows.Forms.DockStyle.Top;
            this.pnlTopBar.Location = new System.Drawing.Point(20, 20);
            this.pnlTopBar.Name = "pnlTopBar";
            this.pnlTopBar.Padding = new System.Windows.Forms.Padding(15);
            this.pnlTopBar.Size = new System.Drawing.Size(986, 60);
            this.pnlTopBar.TabIndex = 0;
            // 
            // lblDate
            // 
            this.lblDate.AutoSize = true;
            this.lblDate.Font = new System.Drawing.Font("Segoe UI", 9F);
            this.lblDate.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(148)))), ((int)(((byte)(163)))), ((int)(((byte)(184)))));
            this.lblDate.Location = new System.Drawing.Point(15, 35);
            this.lblDate.Name = "lblDate";
            this.lblDate.Size = new System.Drawing.Size(0, 15);
            this.lblDate.TabIndex = 1;
            // 
            // lblWelcome
            // 
            this.lblWelcome.AutoSize = true;
            this.lblWelcome.Font = new System.Drawing.Font("Segoe UI", 13F, System.Drawing.FontStyle.Bold);
            this.lblWelcome.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(245)))), ((int)(((byte)(249)))));
            this.lblWelcome.Location = new System.Drawing.Point(15, 8);
            this.lblWelcome.Name = "lblWelcome";
            this.lblWelcome.Size = new System.Drawing.Size(108, 25);
            this.lblWelcome.TabIndex = 0;
            this.lblWelcome.Text = "مرحباً، المدير";
            // 
            // FrmMainDashboard
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 17F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(15)))), ((int)(((byte)(23)))), ((int)(((byte)(42)))));
            this.ClientSize = new System.Drawing.Size(1246, 661);
            this.Controls.Add(this.pnlContent);
            this.Controls.Add(this.pnlSidebar);
            this.Font = new System.Drawing.Font("Segoe UI", 10F);
            this.ForeColor = System.Drawing.Color.FromArgb(((int)(((byte)(241)))), ((int)(((byte)(245)))), ((int)(((byte)(249)))));
            this.MinimumSize = new System.Drawing.Size(1000, 600);
            this.Name = "FrmMainDashboard";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "نظام إدارة الكهرباء - لوحة التحكم";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.pnlSidebar.ResumeLayout(false);
            this.pnlMenuContainer.ResumeLayout(false);
            this.pnlContent.ResumeLayout(false);
            this.pnlRecentCard.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dgvRecentInvoices)).EndInit();
            this.pnlStats.ResumeLayout(false);
            this.pnlCardCustomers.ResumeLayout(false);
            this.pnlCardInvoices.ResumeLayout(false);
            this.pnlCardRevenue.ResumeLayout(false);
            this.pnlCardDebts.ResumeLayout(false);
            this.pnlTopBar.ResumeLayout(false);
            this.pnlTopBar.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel pnlSidebar;
        private System.Windows.Forms.Panel pnlMenuContainer;
        private System.Windows.Forms.Label lblLogo;
        private System.Windows.Forms.Button btnMenuDashboard;
        private System.Windows.Forms.Button btnMenuCustomers;
        private System.Windows.Forms.Button btnMenuMeters;
        private System.Windows.Forms.Button btnMenuPeriods;
        private System.Windows.Forms.Button btnMenuTariffs;
        private System.Windows.Forms.Button btnMenuInvoices;
        private System.Windows.Forms.Button btnMenuPayments;
        private System.Windows.Forms.Button btnMenuAccounts;
        private System.Windows.Forms.Button btnMenuJournal;
        private System.Windows.Forms.Button btnMenuAssets;
        private System.Windows.Forms.Button btnMenuFuel;
        private System.Windows.Forms.Button btnMenuReports;
        private System.Windows.Forms.Button btnMenuUsers;
        private System.Windows.Forms.Button btnMenuVouchers;
        private System.Windows.Forms.Button btnMenuLogout;
        private System.Windows.Forms.Panel pnlContent;
        private System.Windows.Forms.Panel pnlTopBar;
        private System.Windows.Forms.Label lblWelcome;
        private System.Windows.Forms.Label lblDate;
        private System.Windows.Forms.FlowLayoutPanel pnlStats;
        private System.Windows.Forms.Panel pnlCardCustomers;
        private System.Windows.Forms.Label lblStatCustomers;
        private System.Windows.Forms.Label lblStatCustomersTitle;
        private System.Windows.Forms.Panel pnlCardInvoices;
        private System.Windows.Forms.Label lblStatInvoices;
        private System.Windows.Forms.Label lblStatInvoicesTitle;
        private System.Windows.Forms.Panel pnlCardRevenue;
        private System.Windows.Forms.Label lblStatRevenue;
        private System.Windows.Forms.Label lblStatRevenueTitle;
        private System.Windows.Forms.Panel pnlCardDebts;
        private System.Windows.Forms.Label lblStatDebts;
        private System.Windows.Forms.Label lblStatDebtsTitle;
        private System.Windows.Forms.Panel pnlRecentCard;
        private System.Windows.Forms.Label lblRecentTitle;
        private System.Windows.Forms.DataGridView dgvRecentInvoices;
    }
}
