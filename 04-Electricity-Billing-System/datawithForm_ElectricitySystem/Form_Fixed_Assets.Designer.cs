namespace datawithForm_ElectricitySystem
{
    partial class Form_Fixed_Assets
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
            System.Windows.Forms.Label asset_IDLabel;
            System.Windows.Forms.Label asset_NameLabel;
            System.Windows.Forms.Label purchase_ValueLabel;
            System.Windows.Forms.Label account_IDLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Fixed_Assets));
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.fixed_AssetsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.fixed_AssetsTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.Fixed_AssetsTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            this.fixed_AssetsBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
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
            this.fixed_AssetsBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.asset_IDTextBox = new System.Windows.Forms.TextBox();
            this.asset_NameTextBox = new System.Windows.Forms.TextBox();
            this.purchase_ValueTextBox = new System.Windows.Forms.TextBox();
            this.account_IDTextBox = new System.Windows.Forms.TextBox();
            asset_IDLabel = new System.Windows.Forms.Label();
            asset_NameLabel = new System.Windows.Forms.Label();
            purchase_ValueLabel = new System.Windows.Forms.Label();
            account_IDLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.fixed_AssetsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.fixed_AssetsBindingNavigator)).BeginInit();
            this.fixed_AssetsBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // asset_IDLabel
            // 
            asset_IDLabel.AutoSize = true;
            asset_IDLabel.Location = new System.Drawing.Point(54, 98);
            asset_IDLabel.Name = "asset_IDLabel";
            asset_IDLabel.Size = new System.Drawing.Size(54, 13);
            asset_IDLabel.TabIndex = 1;
            asset_IDLabel.Text = "رقم الاصل";
            asset_IDLabel.Click += new System.EventHandler(this.asset_IDLabel_Click);
            // 
            // asset_NameLabel
            // 
            asset_NameLabel.AutoSize = true;
            asset_NameLabel.Location = new System.Drawing.Point(54, 124);
            asset_NameLabel.Name = "asset_NameLabel";
            asset_NameLabel.Size = new System.Drawing.Size(59, 13);
            asset_NameLabel.TabIndex = 3;
            asset_NameLabel.Text = "اسم الاصل";
            asset_NameLabel.Click += new System.EventHandler(this.asset_NameLabel_Click);
            // 
            // purchase_ValueLabel
            // 
            purchase_ValueLabel.AutoSize = true;
            purchase_ValueLabel.Location = new System.Drawing.Point(54, 150);
            purchase_ValueLabel.Name = "purchase_ValueLabel";
            purchase_ValueLabel.Size = new System.Drawing.Size(62, 13);
            purchase_ValueLabel.TabIndex = 5;
            purchase_ValueLabel.Text = "قيمة الشراء";
            // 
            // account_IDLabel
            // 
            account_IDLabel.AutoSize = true;
            account_IDLabel.Location = new System.Drawing.Point(54, 172);
            account_IDLabel.Name = "account_IDLabel";
            account_IDLabel.Size = new System.Drawing.Size(100, 13);
            account_IDLabel.TabIndex = 7;
            account_IDLabel.Text = "رقم الحساب المرتبط";
            account_IDLabel.Click += new System.EventHandler(this.account_IDLabel_Click);
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // fixed_AssetsBindingSource
            // 
            this.fixed_AssetsBindingSource.DataMember = "Fixed_Assets";
            this.fixed_AssetsBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // fixed_AssetsTableAdapter
            // 
            this.fixed_AssetsTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AccountsTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Billing_PeriodsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = null;
            this.tableAdapterManager.Fixed_AssetsTableAdapter = this.fixed_AssetsTableAdapter;
            this.tableAdapterManager.Fuel_ConsumptionTableAdapter = null;
            this.tableAdapterManager.InvoicesTableAdapter = null;
            this.tableAdapterManager.Journal_EntriesTableAdapter = null;
            this.tableAdapterManager.TariffsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // fixed_AssetsBindingNavigator
            // 
            this.fixed_AssetsBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.fixed_AssetsBindingNavigator.BindingSource = this.fixed_AssetsBindingSource;
            this.fixed_AssetsBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.fixed_AssetsBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.fixed_AssetsBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.fixed_AssetsBindingNavigatorSaveItem});
            this.fixed_AssetsBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.fixed_AssetsBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.fixed_AssetsBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.fixed_AssetsBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.fixed_AssetsBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.fixed_AssetsBindingNavigator.Name = "fixed_AssetsBindingNavigator";
            this.fixed_AssetsBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.fixed_AssetsBindingNavigator.Size = new System.Drawing.Size(298, 25);
            this.fixed_AssetsBindingNavigator.TabIndex = 0;
            this.fixed_AssetsBindingNavigator.Text = "bindingNavigator1";
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
            // fixed_AssetsBindingNavigatorSaveItem
            // 
            this.fixed_AssetsBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.fixed_AssetsBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("fixed_AssetsBindingNavigatorSaveItem.Image")));
            this.fixed_AssetsBindingNavigatorSaveItem.Name = "fixed_AssetsBindingNavigatorSaveItem";
            this.fixed_AssetsBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.fixed_AssetsBindingNavigatorSaveItem.Text = "Save Data";
            this.fixed_AssetsBindingNavigatorSaveItem.Click += new System.EventHandler(this.fixed_AssetsBindingNavigatorSaveItem_Click);
            // 
            // asset_IDTextBox
            // 
            this.asset_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.fixed_AssetsBindingSource, "Asset_ID", true));
            this.asset_IDTextBox.Location = new System.Drawing.Point(160, 91);
            this.asset_IDTextBox.Name = "asset_IDTextBox";
            this.asset_IDTextBox.Size = new System.Drawing.Size(100, 20);
            this.asset_IDTextBox.TabIndex = 2;
            // 
            // asset_NameTextBox
            // 
            this.asset_NameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.fixed_AssetsBindingSource, "Asset_Name", true));
            this.asset_NameTextBox.Location = new System.Drawing.Point(160, 117);
            this.asset_NameTextBox.Name = "asset_NameTextBox";
            this.asset_NameTextBox.Size = new System.Drawing.Size(100, 20);
            this.asset_NameTextBox.TabIndex = 4;
            // 
            // purchase_ValueTextBox
            // 
            this.purchase_ValueTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.fixed_AssetsBindingSource, "Purchase_Value", true));
            this.purchase_ValueTextBox.Location = new System.Drawing.Point(160, 143);
            this.purchase_ValueTextBox.Name = "purchase_ValueTextBox";
            this.purchase_ValueTextBox.Size = new System.Drawing.Size(100, 20);
            this.purchase_ValueTextBox.TabIndex = 6;
            // 
            // account_IDTextBox
            // 
            this.account_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.fixed_AssetsBindingSource, "Account_ID", true));
            this.account_IDTextBox.Location = new System.Drawing.Point(160, 169);
            this.account_IDTextBox.Name = "account_IDTextBox";
            this.account_IDTextBox.Size = new System.Drawing.Size(100, 20);
            this.account_IDTextBox.TabIndex = 8;
            // 
            // Form_Fixed_Assets
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(298, 261);
            this.Controls.Add(asset_IDLabel);
            this.Controls.Add(this.asset_IDTextBox);
            this.Controls.Add(asset_NameLabel);
            this.Controls.Add(this.asset_NameTextBox);
            this.Controls.Add(purchase_ValueLabel);
            this.Controls.Add(this.purchase_ValueTextBox);
            this.Controls.Add(account_IDLabel);
            this.Controls.Add(this.account_IDTextBox);
            this.Controls.Add(this.fixed_AssetsBindingNavigator);
            this.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Fixed_Assets";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام الاصول الثابتة";
            this.Load += new System.EventHandler(this.Form_Fixed_Assets_Load);
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.fixed_AssetsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.fixed_AssetsBindingNavigator)).EndInit();
            this.fixed_AssetsBindingNavigator.ResumeLayout(false);
            this.fixed_AssetsBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource fixed_AssetsBindingSource;
        private EElectricitySystemDataSetTableAdapters.Fixed_AssetsTableAdapter fixed_AssetsTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator fixed_AssetsBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton fixed_AssetsBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox asset_IDTextBox;
        private System.Windows.Forms.TextBox asset_NameTextBox;
        private System.Windows.Forms.TextBox purchase_ValueTextBox;
        private System.Windows.Forms.TextBox account_IDTextBox;
    }
}