namespace datawithForm_ElectricitySystem
{
    partial class Form_Fuel_Consumption
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
            System.Windows.Forms.Label log_IDLabel;
            System.Windows.Forms.Label asset_IDLabel;
            System.Windows.Forms.Label quantity_UsedLabel;
            System.Windows.Forms.Label log_DateLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Fuel_Consumption));
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.fuel_ConsumptionBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.fuel_ConsumptionTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.Fuel_ConsumptionTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            this.fuel_ConsumptionBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.fuel_ConsumptionBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.log_IDTextBox = new System.Windows.Forms.TextBox();
            this.asset_IDTextBox = new System.Windows.Forms.TextBox();
            this.quantity_UsedTextBox = new System.Windows.Forms.TextBox();
            this.log_DateDateTimePicker = new System.Windows.Forms.DateTimePicker();
            log_IDLabel = new System.Windows.Forms.Label();
            asset_IDLabel = new System.Windows.Forms.Label();
            quantity_UsedLabel = new System.Windows.Forms.Label();
            log_DateLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.fuel_ConsumptionBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.fuel_ConsumptionBindingNavigator)).BeginInit();
            this.fuel_ConsumptionBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // log_IDLabel
            // 
            log_IDLabel.AutoSize = true;
            log_IDLabel.Location = new System.Drawing.Point(80, 83);
            log_IDLabel.Name = "log_IDLabel";
            log_IDLabel.Size = new System.Drawing.Size(60, 13);
            log_IDLabel.TabIndex = 1;
            log_IDLabel.Text = "رقم السجل";
            log_IDLabel.Click += new System.EventHandler(this.log_IDLabel_Click);
            // 
            // asset_IDLabel
            // 
            asset_IDLabel.AutoSize = true;
            asset_IDLabel.Location = new System.Drawing.Point(80, 106);
            asset_IDLabel.Name = "asset_IDLabel";
            asset_IDLabel.Size = new System.Drawing.Size(54, 13);
            asset_IDLabel.TabIndex = 3;
            asset_IDLabel.Text = "رقم المولد";
            asset_IDLabel.Click += new System.EventHandler(this.asset_IDLabel_Click);
            // 
            // quantity_UsedLabel
            // 
            quantity_UsedLabel.AutoSize = true;
            quantity_UsedLabel.Location = new System.Drawing.Point(77, 135);
            quantity_UsedLabel.Name = "quantity_UsedLabel";
            quantity_UsedLabel.Size = new System.Drawing.Size(93, 13);
            quantity_UsedLabel.TabIndex = 5;
            quantity_UsedLabel.Text = "الكمية المستخدمة";
            // 
            // log_DateLabel
            // 
            log_DateLabel.AutoSize = true;
            log_DateLabel.Location = new System.Drawing.Point(80, 164);
            log_DateLabel.Name = "log_DateLabel";
            log_DateLabel.Size = new System.Drawing.Size(64, 13);
            log_DateLabel.TabIndex = 7;
            log_DateLabel.Text = "تاريخ السجل";
            log_DateLabel.Click += new System.EventHandler(this.log_DateLabel_Click);
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // fuel_ConsumptionBindingSource
            // 
            this.fuel_ConsumptionBindingSource.DataMember = "Fuel_Consumption";
            this.fuel_ConsumptionBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // fuel_ConsumptionTableAdapter
            // 
            this.fuel_ConsumptionTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AccountsTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Billing_PeriodsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = null;
            this.tableAdapterManager.Fixed_AssetsTableAdapter = null;
            this.tableAdapterManager.Fuel_ConsumptionTableAdapter = this.fuel_ConsumptionTableAdapter;
            this.tableAdapterManager.InvoicesTableAdapter = null;
            this.tableAdapterManager.Journal_EntriesTableAdapter = null;
            this.tableAdapterManager.TariffsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // fuel_ConsumptionBindingNavigator
            // 
            this.fuel_ConsumptionBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.fuel_ConsumptionBindingNavigator.BindingSource = this.fuel_ConsumptionBindingSource;
            this.fuel_ConsumptionBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.fuel_ConsumptionBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.fuel_ConsumptionBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.fuel_ConsumptionBindingNavigatorSaveItem});
            this.fuel_ConsumptionBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.fuel_ConsumptionBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.fuel_ConsumptionBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.fuel_ConsumptionBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.fuel_ConsumptionBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.fuel_ConsumptionBindingNavigator.Name = "fuel_ConsumptionBindingNavigator";
            this.fuel_ConsumptionBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.fuel_ConsumptionBindingNavigator.Size = new System.Drawing.Size(437, 25);
            this.fuel_ConsumptionBindingNavigator.TabIndex = 0;
            this.fuel_ConsumptionBindingNavigator.Text = "bindingNavigator1";
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
            // fuel_ConsumptionBindingNavigatorSaveItem
            // 
            this.fuel_ConsumptionBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.fuel_ConsumptionBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("fuel_ConsumptionBindingNavigatorSaveItem.Image")));
            this.fuel_ConsumptionBindingNavigatorSaveItem.Name = "fuel_ConsumptionBindingNavigatorSaveItem";
            this.fuel_ConsumptionBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.fuel_ConsumptionBindingNavigatorSaveItem.Text = "Save Data";
            this.fuel_ConsumptionBindingNavigatorSaveItem.Click += new System.EventHandler(this.fuel_ConsumptionBindingNavigatorSaveItem_Click);
            // 
            // log_IDTextBox
            // 
            this.log_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.fuel_ConsumptionBindingSource, "Log_ID", true));
            this.log_IDTextBox.Location = new System.Drawing.Point(176, 80);
            this.log_IDTextBox.Name = "log_IDTextBox";
            this.log_IDTextBox.Size = new System.Drawing.Size(200, 20);
            this.log_IDTextBox.TabIndex = 2;
            // 
            // asset_IDTextBox
            // 
            this.asset_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.fuel_ConsumptionBindingSource, "Asset_ID", true));
            this.asset_IDTextBox.Location = new System.Drawing.Point(176, 106);
            this.asset_IDTextBox.Name = "asset_IDTextBox";
            this.asset_IDTextBox.Size = new System.Drawing.Size(200, 20);
            this.asset_IDTextBox.TabIndex = 4;
            // 
            // quantity_UsedTextBox
            // 
            this.quantity_UsedTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.fuel_ConsumptionBindingSource, "Quantity_Used", true));
            this.quantity_UsedTextBox.Location = new System.Drawing.Point(176, 132);
            this.quantity_UsedTextBox.Name = "quantity_UsedTextBox";
            this.quantity_UsedTextBox.Size = new System.Drawing.Size(200, 20);
            this.quantity_UsedTextBox.TabIndex = 6;
            // 
            // log_DateDateTimePicker
            // 
            this.log_DateDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.fuel_ConsumptionBindingSource, "Log_Date", true));
            this.log_DateDateTimePicker.Location = new System.Drawing.Point(176, 158);
            this.log_DateDateTimePicker.Name = "log_DateDateTimePicker";
            this.log_DateDateTimePicker.Size = new System.Drawing.Size(200, 20);
            this.log_DateDateTimePicker.TabIndex = 8;
            // 
            // Form_Fuel_Consumption
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(437, 261);
            this.Controls.Add(log_IDLabel);
            this.Controls.Add(this.log_IDTextBox);
            this.Controls.Add(asset_IDLabel);
            this.Controls.Add(this.asset_IDTextBox);
            this.Controls.Add(quantity_UsedLabel);
            this.Controls.Add(this.quantity_UsedTextBox);
            this.Controls.Add(log_DateLabel);
            this.Controls.Add(this.log_DateDateTimePicker);
            this.Controls.Add(this.fuel_ConsumptionBindingNavigator);
            this.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Fuel_Consumption";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام استهلاك الوقود";
            this.Load += new System.EventHandler(this.Form_Fuel_Consumption_Load);
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.fuel_ConsumptionBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.fuel_ConsumptionBindingNavigator)).EndInit();
            this.fuel_ConsumptionBindingNavigator.ResumeLayout(false);
            this.fuel_ConsumptionBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource fuel_ConsumptionBindingSource;
        private EElectricitySystemDataSetTableAdapters.Fuel_ConsumptionTableAdapter fuel_ConsumptionTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator fuel_ConsumptionBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton fuel_ConsumptionBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox log_IDTextBox;
        private System.Windows.Forms.TextBox asset_IDTextBox;
        private System.Windows.Forms.TextBox quantity_UsedTextBox;
        private System.Windows.Forms.DateTimePicker log_DateDateTimePicker;
    }
}