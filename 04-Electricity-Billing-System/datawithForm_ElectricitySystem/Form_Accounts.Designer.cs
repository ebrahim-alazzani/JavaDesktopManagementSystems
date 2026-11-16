namespace datawithForm_ElectricitySystem
{
    partial class Form_Accounts
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.Label account_IDLabel;
            System.Windows.Forms.Label account_NameLabel;
            System.Windows.Forms.Label account_TypeLabel;
            System.Windows.Forms.Label balance_TypeLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Accounts));
            this.accountsBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.accountsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.accountsBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.account_IDTextBox = new System.Windows.Forms.TextBox();
            this.account_NameTextBox = new System.Windows.Forms.TextBox();
            this.account_TypeTextBox = new System.Windows.Forms.TextBox();
            this.balance_TypeTextBox = new System.Windows.Forms.TextBox();
            this.accountsTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.AccountsTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            account_IDLabel = new System.Windows.Forms.Label();
            account_NameLabel = new System.Windows.Forms.Label();
            account_TypeLabel = new System.Windows.Forms.Label();
            balance_TypeLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.accountsBindingNavigator)).BeginInit();
            this.accountsBindingNavigator.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.accountsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // account_IDLabel
            // 
            account_IDLabel.AutoSize = true;
            account_IDLabel.Location = new System.Drawing.Point(75, 88);
            account_IDLabel.Name = "account_IDLabel";
            account_IDLabel.Size = new System.Drawing.Size(64, 13);
            account_IDLabel.TabIndex = 1;
            account_IDLabel.Text = "رقم الحساب";
            account_IDLabel.Click += new System.EventHandler(this.account_IDLabel_Click);
            // 
            // account_NameLabel
            // 
            account_NameLabel.AutoSize = true;
            account_NameLabel.Location = new System.Drawing.Point(75, 114);
            account_NameLabel.Name = "account_NameLabel";
            account_NameLabel.Size = new System.Drawing.Size(69, 13);
            account_NameLabel.TabIndex = 3;
            account_NameLabel.Text = "اسم الحساب";
            account_NameLabel.Click += new System.EventHandler(this.account_NameLabel_Click);
            // 
            // account_TypeLabel
            // 
            account_TypeLabel.AutoSize = true;
            account_TypeLabel.Location = new System.Drawing.Point(75, 140);
            account_TypeLabel.Name = "account_TypeLabel";
            account_TypeLabel.Size = new System.Drawing.Size(74, 13);
            account_TypeLabel.TabIndex = 5;
            account_TypeLabel.Text = "طبيعة الحساب";
            account_TypeLabel.Click += new System.EventHandler(this.account_TypeLabel_Click);
            // 
            // balance_TypeLabel
            // 
            balance_TypeLabel.AutoSize = true;
            balance_TypeLabel.Location = new System.Drawing.Point(75, 166);
            balance_TypeLabel.Name = "balance_TypeLabel";
            balance_TypeLabel.Size = new System.Drawing.Size(55, 13);
            balance_TypeLabel.TabIndex = 7;
            balance_TypeLabel.Text = "نوع الرصيد";
            balance_TypeLabel.Click += new System.EventHandler(this.balance_TypeLabel_Click);
            // 
            // accountsBindingNavigator
            // 
            this.accountsBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.accountsBindingNavigator.BindingSource = this.accountsBindingSource;
            this.accountsBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.accountsBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.accountsBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.accountsBindingNavigatorSaveItem});
            this.accountsBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.accountsBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.accountsBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.accountsBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.accountsBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.accountsBindingNavigator.Name = "accountsBindingNavigator";
            this.accountsBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.accountsBindingNavigator.Size = new System.Drawing.Size(335, 25);
            this.accountsBindingNavigator.TabIndex = 0;
            this.accountsBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorAddNewItem.Text = "Add new";
            // 
            // accountsBindingSource
            // 
            this.accountsBindingSource.DataMember = "Accounts";
            this.accountsBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(35, 22);
            this.bindingNavigatorCountItem.Text = "of {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Total number of items";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorDeleteItem.Text = "Delete";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveFirstItem.Text = "Move first";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMovePreviousItem.Text = "Move previous";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 23);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Current position";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator1";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveNextItem.Text = "Move next";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(23, 22);
            this.bindingNavigatorMoveLastItem.Text = "Move last";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator2";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 25);
            // 
            // accountsBindingNavigatorSaveItem
            // 
            this.accountsBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.accountsBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("accountsBindingNavigatorSaveItem.Image")));
            this.accountsBindingNavigatorSaveItem.Name = "accountsBindingNavigatorSaveItem";
            this.accountsBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.accountsBindingNavigatorSaveItem.Text = "Save Data";
            this.accountsBindingNavigatorSaveItem.Click += new System.EventHandler(this.accountsBindingNavigatorSaveItem_Click);
            // 
            // account_IDTextBox
            // 
            this.account_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.accountsBindingSource, "Account_ID", true));
            this.account_IDTextBox.Location = new System.Drawing.Point(161, 85);
            this.account_IDTextBox.Name = "account_IDTextBox";
            this.account_IDTextBox.Size = new System.Drawing.Size(100, 20);
            this.account_IDTextBox.TabIndex = 2;
            this.account_IDTextBox.TextChanged += new System.EventHandler(this.account_IDTextBox_TextChanged);
            // 
            // account_NameTextBox
            // 
            this.account_NameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.accountsBindingSource, "Account_Name", true));
            this.account_NameTextBox.Location = new System.Drawing.Point(161, 111);
            this.account_NameTextBox.Name = "account_NameTextBox";
            this.account_NameTextBox.Size = new System.Drawing.Size(100, 20);
            this.account_NameTextBox.TabIndex = 4;
            this.account_NameTextBox.TextChanged += new System.EventHandler(this.account_NameTextBox_TextChanged);
            // 
            // account_TypeTextBox
            // 
            this.account_TypeTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.accountsBindingSource, "Account_Type", true));
            this.account_TypeTextBox.Location = new System.Drawing.Point(161, 137);
            this.account_TypeTextBox.Name = "account_TypeTextBox";
            this.account_TypeTextBox.Size = new System.Drawing.Size(100, 20);
            this.account_TypeTextBox.TabIndex = 6;
            this.account_TypeTextBox.TextChanged += new System.EventHandler(this.account_TypeTextBox_TextChanged);
            // 
            // balance_TypeTextBox
            // 
            this.balance_TypeTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.accountsBindingSource, "Balance_Type", true));
            this.balance_TypeTextBox.Location = new System.Drawing.Point(161, 163);
            this.balance_TypeTextBox.Name = "balance_TypeTextBox";
            this.balance_TypeTextBox.Size = new System.Drawing.Size(100, 20);
            this.balance_TypeTextBox.TabIndex = 8;
            this.balance_TypeTextBox.TextChanged += new System.EventHandler(this.balance_TypeTextBox_TextChanged);
            // 
            // accountsTableAdapter
            // 
            this.accountsTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AccountsTableAdapter = this.accountsTableAdapter;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Billing_PeriodsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = null;
            this.tableAdapterManager.Fixed_AssetsTableAdapter = null;
            this.tableAdapterManager.Fuel_ConsumptionTableAdapter = null;
            this.tableAdapterManager.InvoicesTableAdapter = null;
            this.tableAdapterManager.Journal_EntriesTableAdapter = null;
            this.tableAdapterManager.TariffsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // Form_Accounts
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(335, 261);
            this.Controls.Add(account_IDLabel);
            this.Controls.Add(this.account_IDTextBox);
            this.Controls.Add(account_NameLabel);
            this.Controls.Add(this.account_NameTextBox);
            this.Controls.Add(account_TypeLabel);
            this.Controls.Add(this.account_TypeTextBox);
            this.Controls.Add(balance_TypeLabel);
            this.Controls.Add(this.balance_TypeTextBox);
            this.Controls.Add(this.accountsBindingNavigator);
            this.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Accounts";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام الحسابات";
            this.Load += new System.EventHandler(this.Form_Accounts_Load);
            ((System.ComponentModel.ISupportInitialize)(this.accountsBindingNavigator)).EndInit();
            this.accountsBindingNavigator.ResumeLayout(false);
            this.accountsBindingNavigator.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.accountsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource accountsBindingSource;
        private EElectricitySystemDataSetTableAdapters.AccountsTableAdapter accountsTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator accountsBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton accountsBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox account_IDTextBox;
        private System.Windows.Forms.TextBox account_NameTextBox;
        private System.Windows.Forms.TextBox account_TypeTextBox;
        private System.Windows.Forms.TextBox balance_TypeTextBox;
    }
}