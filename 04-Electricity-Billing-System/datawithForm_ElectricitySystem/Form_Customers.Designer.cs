namespace datawithForm_ElectricitySystem
{
    partial class Form_Customers
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
            System.Windows.Forms.Label customer_IDLabel;
            System.Windows.Forms.Label customer_NameLabel;
            System.Windows.Forms.Label meter_NoLabel;
            System.Windows.Forms.Label phoneLabel;
            System.Windows.Forms.Label opening_BalanceLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Customers));
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.customersBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.customersTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.CustomersTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            this.customersBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.customersBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.customer_IDTextBox = new System.Windows.Forms.TextBox();
            this.customer_NameTextBox = new System.Windows.Forms.TextBox();
            this.meter_NoTextBox = new System.Windows.Forms.TextBox();
            this.phoneTextBox = new System.Windows.Forms.TextBox();
            this.opening_BalanceTextBox = new System.Windows.Forms.TextBox();
            customer_IDLabel = new System.Windows.Forms.Label();
            customer_NameLabel = new System.Windows.Forms.Label();
            meter_NoLabel = new System.Windows.Forms.Label();
            phoneLabel = new System.Windows.Forms.Label();
            opening_BalanceLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.customersBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.customersBindingNavigator)).BeginInit();
            this.customersBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // customer_IDLabel
            // 
            customer_IDLabel.AutoSize = true;
            customer_IDLabel.Location = new System.Drawing.Point(138, 117);
            customer_IDLabel.Name = "customer_IDLabel";
            customer_IDLabel.Size = new System.Drawing.Size(69, 13);
            customer_IDLabel.TabIndex = 1;
            customer_IDLabel.Text = "رقم المشترك";
            customer_IDLabel.Click += new System.EventHandler(this.customer_IDLabel_Click);
            // 
            // customer_NameLabel
            // 
            customer_NameLabel.AutoSize = true;
            customer_NameLabel.Location = new System.Drawing.Point(138, 139);
            customer_NameLabel.Name = "customer_NameLabel";
            customer_NameLabel.Size = new System.Drawing.Size(74, 13);
            customer_NameLabel.TabIndex = 3;
            customer_NameLabel.Text = "اسم المشترك";
            // 
            // meter_NoLabel
            // 
            meter_NoLabel.AutoSize = true;
            meter_NoLabel.Location = new System.Drawing.Point(138, 165);
            meter_NoLabel.Name = "meter_NoLabel";
            meter_NoLabel.Size = new System.Drawing.Size(53, 13);
            meter_NoLabel.TabIndex = 5;
            meter_NoLabel.Text = "رقم العداد";
            // 
            // phoneLabel
            // 
            phoneLabel.AutoSize = true;
            phoneLabel.Location = new System.Drawing.Point(138, 191);
            phoneLabel.Name = "phoneLabel";
            phoneLabel.Size = new System.Drawing.Size(55, 13);
            phoneLabel.TabIndex = 7;
            phoneLabel.Text = "رقم الهاتف";
            // 
            // opening_BalanceLabel
            // 
            opening_BalanceLabel.AutoSize = true;
            opening_BalanceLabel.Location = new System.Drawing.Point(138, 217);
            opening_BalanceLabel.Name = "opening_BalanceLabel";
            opening_BalanceLabel.Size = new System.Drawing.Size(84, 13);
            opening_BalanceLabel.TabIndex = 9;
            opening_BalanceLabel.Text = "الرصيد الافتتاحي";
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // customersBindingSource
            // 
            this.customersBindingSource.DataMember = "Customers";
            this.customersBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // customersTableAdapter
            // 
            this.customersTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AccountsTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Billing_PeriodsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = this.customersTableAdapter;
            this.tableAdapterManager.Fixed_AssetsTableAdapter = null;
            this.tableAdapterManager.Fuel_ConsumptionTableAdapter = null;
            this.tableAdapterManager.InvoicesTableAdapter = null;
            this.tableAdapterManager.Journal_EntriesTableAdapter = null;
            this.tableAdapterManager.TariffsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // customersBindingNavigator
            // 
            this.customersBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.customersBindingNavigator.BindingSource = this.customersBindingSource;
            this.customersBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.customersBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.customersBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.customersBindingNavigatorSaveItem});
            this.customersBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.customersBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.customersBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.customersBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.customersBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.customersBindingNavigator.Name = "customersBindingNavigator";
            this.customersBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.customersBindingNavigator.Size = new System.Drawing.Size(515, 25);
            this.customersBindingNavigator.TabIndex = 0;
            this.customersBindingNavigator.Text = "bindingNavigator1";
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
            // customersBindingNavigatorSaveItem
            // 
            this.customersBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.customersBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("customersBindingNavigatorSaveItem.Image")));
            this.customersBindingNavigatorSaveItem.Name = "customersBindingNavigatorSaveItem";
            this.customersBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.customersBindingNavigatorSaveItem.Text = "Save Data";
            this.customersBindingNavigatorSaveItem.Click += new System.EventHandler(this.customersBindingNavigatorSaveItem_Click);
            // 
            // customer_IDTextBox
            // 
            this.customer_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.customersBindingSource, "Customer_ID", true));
            this.customer_IDTextBox.Location = new System.Drawing.Point(235, 110);
            this.customer_IDTextBox.Name = "customer_IDTextBox";
            this.customer_IDTextBox.Size = new System.Drawing.Size(100, 20);
            this.customer_IDTextBox.TabIndex = 2;
            // 
            // customer_NameTextBox
            // 
            this.customer_NameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.customersBindingSource, "Customer_Name", true));
            this.customer_NameTextBox.Location = new System.Drawing.Point(235, 136);
            this.customer_NameTextBox.Name = "customer_NameTextBox";
            this.customer_NameTextBox.Size = new System.Drawing.Size(100, 20);
            this.customer_NameTextBox.TabIndex = 4;
            // 
            // meter_NoTextBox
            // 
            this.meter_NoTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.customersBindingSource, "Meter_No", true));
            this.meter_NoTextBox.Location = new System.Drawing.Point(235, 162);
            this.meter_NoTextBox.Name = "meter_NoTextBox";
            this.meter_NoTextBox.Size = new System.Drawing.Size(100, 20);
            this.meter_NoTextBox.TabIndex = 6;
            // 
            // phoneTextBox
            // 
            this.phoneTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.customersBindingSource, "Phone", true));
            this.phoneTextBox.Location = new System.Drawing.Point(235, 188);
            this.phoneTextBox.Name = "phoneTextBox";
            this.phoneTextBox.Size = new System.Drawing.Size(100, 20);
            this.phoneTextBox.TabIndex = 8;
            // 
            // opening_BalanceTextBox
            // 
            this.opening_BalanceTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.customersBindingSource, "Opening_Balance", true));
            this.opening_BalanceTextBox.Location = new System.Drawing.Point(235, 214);
            this.opening_BalanceTextBox.Name = "opening_BalanceTextBox";
            this.opening_BalanceTextBox.Size = new System.Drawing.Size(100, 20);
            this.opening_BalanceTextBox.TabIndex = 10;
            // 
            // Form_Customers
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(515, 368);
            this.Controls.Add(customer_IDLabel);
            this.Controls.Add(this.customer_IDTextBox);
            this.Controls.Add(customer_NameLabel);
            this.Controls.Add(this.customer_NameTextBox);
            this.Controls.Add(meter_NoLabel);
            this.Controls.Add(this.meter_NoTextBox);
            this.Controls.Add(phoneLabel);
            this.Controls.Add(this.phoneTextBox);
            this.Controls.Add(opening_BalanceLabel);
            this.Controls.Add(this.opening_BalanceTextBox);
            this.Controls.Add(this.customersBindingNavigator);
            this.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Customers";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام المشتركين";
            this.Load += new System.EventHandler(this.Form_Customers_Load);
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.customersBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.customersBindingNavigator)).EndInit();
            this.customersBindingNavigator.ResumeLayout(false);
            this.customersBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource customersBindingSource;
        private EElectricitySystemDataSetTableAdapters.CustomersTableAdapter customersTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator customersBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton customersBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox customer_IDTextBox;
        private System.Windows.Forms.TextBox customer_NameTextBox;
        private System.Windows.Forms.TextBox meter_NoTextBox;
        private System.Windows.Forms.TextBox phoneTextBox;
        private System.Windows.Forms.TextBox opening_BalanceTextBox;
    }
}