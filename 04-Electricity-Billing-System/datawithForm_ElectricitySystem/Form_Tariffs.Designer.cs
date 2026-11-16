namespace datawithForm_ElectricitySystem
{
    partial class Form_Tariffs
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
            System.Windows.Forms.Label tariff_IDLabel;
            System.Windows.Forms.Label tariff_NameLabel;
            System.Windows.Forms.Label price_Per_UnitLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Tariffs));
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.tariffsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.tariffsTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TariffsTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            this.tariffsBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.tariffsBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.tariff_IDTextBox = new System.Windows.Forms.TextBox();
            this.tariff_NameTextBox = new System.Windows.Forms.TextBox();
            this.price_Per_UnitTextBox = new System.Windows.Forms.TextBox();
            tariff_IDLabel = new System.Windows.Forms.Label();
            tariff_NameLabel = new System.Windows.Forms.Label();
            price_Per_UnitLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tariffsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.tariffsBindingNavigator)).BeginInit();
            this.tariffsBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // tariff_IDLabel
            // 
            tariff_IDLabel.AutoSize = true;
            tariff_IDLabel.Location = new System.Drawing.Point(92, 95);
            tariff_IDLabel.Name = "tariff_IDLabel";
            tariff_IDLabel.Size = new System.Drawing.Size(59, 13);
            tariff_IDLabel.TabIndex = 1;
            tariff_IDLabel.Text = "رقم التعرفة";
            // 
            // tariff_NameLabel
            // 
            tariff_NameLabel.AutoSize = true;
            tariff_NameLabel.Location = new System.Drawing.Point(92, 121);
            tariff_NameLabel.Name = "tariff_NameLabel";
            tariff_NameLabel.Size = new System.Drawing.Size(64, 13);
            tariff_NameLabel.TabIndex = 3;
            tariff_NameLabel.Text = "اسم التعرفة";
            // 
            // price_Per_UnitLabel
            // 
            price_Per_UnitLabel.AutoSize = true;
            price_Per_UnitLabel.Location = new System.Drawing.Point(92, 147);
            price_Per_UnitLabel.Name = "price_Per_UnitLabel";
            price_Per_UnitLabel.Size = new System.Drawing.Size(61, 13);
            price_Per_UnitLabel.TabIndex = 5;
            price_Per_UnitLabel.Text = "سعر الوحدة";
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // tariffsBindingSource
            // 
            this.tariffsBindingSource.DataMember = "Tariffs";
            this.tariffsBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // tariffsTableAdapter
            // 
            this.tariffsTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AccountsTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Billing_PeriodsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = null;
            this.tableAdapterManager.Fixed_AssetsTableAdapter = null;
            this.tableAdapterManager.Fuel_ConsumptionTableAdapter = null;
            this.tableAdapterManager.InvoicesTableAdapter = null;
            this.tableAdapterManager.Journal_EntriesTableAdapter = null;
            this.tableAdapterManager.TariffsTableAdapter = this.tariffsTableAdapter;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // tariffsBindingNavigator
            // 
            this.tariffsBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.tariffsBindingNavigator.BindingSource = this.tariffsBindingSource;
            this.tariffsBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.tariffsBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.tariffsBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.tariffsBindingNavigatorSaveItem});
            this.tariffsBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.tariffsBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.tariffsBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.tariffsBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.tariffsBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.tariffsBindingNavigator.Name = "tariffsBindingNavigator";
            this.tariffsBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.tariffsBindingNavigator.Size = new System.Drawing.Size(389, 25);
            this.tariffsBindingNavigator.TabIndex = 0;
            this.tariffsBindingNavigator.Text = "bindingNavigator1";
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
            // tariffsBindingNavigatorSaveItem
            // 
            this.tariffsBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.tariffsBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("tariffsBindingNavigatorSaveItem.Image")));
            this.tariffsBindingNavigatorSaveItem.Name = "tariffsBindingNavigatorSaveItem";
            this.tariffsBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.tariffsBindingNavigatorSaveItem.Text = "Save Data";
            this.tariffsBindingNavigatorSaveItem.Click += new System.EventHandler(this.tariffsBindingNavigatorSaveItem_Click);
            // 
            // tariff_IDTextBox
            // 
            this.tariff_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.tariffsBindingSource, "Tariff_ID", true));
            this.tariff_IDTextBox.Location = new System.Drawing.Point(173, 92);
            this.tariff_IDTextBox.Name = "tariff_IDTextBox";
            this.tariff_IDTextBox.Size = new System.Drawing.Size(100, 20);
            this.tariff_IDTextBox.TabIndex = 2;
            // 
            // tariff_NameTextBox
            // 
            this.tariff_NameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.tariffsBindingSource, "Tariff_Name", true));
            this.tariff_NameTextBox.Location = new System.Drawing.Point(173, 118);
            this.tariff_NameTextBox.Name = "tariff_NameTextBox";
            this.tariff_NameTextBox.Size = new System.Drawing.Size(100, 20);
            this.tariff_NameTextBox.TabIndex = 4;
            // 
            // price_Per_UnitTextBox
            // 
            this.price_Per_UnitTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.tariffsBindingSource, "Price_Per_Unit", true));
            this.price_Per_UnitTextBox.Location = new System.Drawing.Point(173, 144);
            this.price_Per_UnitTextBox.Name = "price_Per_UnitTextBox";
            this.price_Per_UnitTextBox.Size = new System.Drawing.Size(100, 20);
            this.price_Per_UnitTextBox.TabIndex = 6;
            // 
            // Form_Tariffs
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(389, 261);
            this.Controls.Add(tariff_IDLabel);
            this.Controls.Add(this.tariff_IDTextBox);
            this.Controls.Add(tariff_NameLabel);
            this.Controls.Add(this.tariff_NameTextBox);
            this.Controls.Add(price_Per_UnitLabel);
            this.Controls.Add(this.price_Per_UnitTextBox);
            this.Controls.Add(this.tariffsBindingNavigator);
            this.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Tariffs";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام التعرفة";
            this.Load += new System.EventHandler(this.Form_Tariffs_Load);
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tariffsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.tariffsBindingNavigator)).EndInit();
            this.tariffsBindingNavigator.ResumeLayout(false);
            this.tariffsBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource tariffsBindingSource;
        private EElectricitySystemDataSetTableAdapters.TariffsTableAdapter tariffsTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator tariffsBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton tariffsBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox tariff_IDTextBox;
        private System.Windows.Forms.TextBox tariff_NameTextBox;
        private System.Windows.Forms.TextBox price_Per_UnitTextBox;
    }
}