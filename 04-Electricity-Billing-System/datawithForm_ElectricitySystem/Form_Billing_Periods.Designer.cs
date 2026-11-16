namespace datawithForm_ElectricitySystem
{
    partial class Form_Billing_Periods
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
            System.Windows.Forms.Label period_IDLabel;
            System.Windows.Forms.Label period_NameLabel;
            System.Windows.Forms.Label start_DateLabel;
            System.Windows.Forms.Label end_DateLabel;
            System.Windows.Forms.Label is_ClosedLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Billing_Periods));
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.billing_PeriodsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.billing_PeriodsTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.Billing_PeriodsTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            this.billing_PeriodsBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.billing_PeriodsBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.period_IDTextBox = new System.Windows.Forms.TextBox();
            this.period_NameTextBox = new System.Windows.Forms.TextBox();
            this.start_DateDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.end_DateDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.is_ClosedCheckBox = new System.Windows.Forms.CheckBox();
            period_IDLabel = new System.Windows.Forms.Label();
            period_NameLabel = new System.Windows.Forms.Label();
            start_DateLabel = new System.Windows.Forms.Label();
            end_DateLabel = new System.Windows.Forms.Label();
            is_ClosedLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.billing_PeriodsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.billing_PeriodsBindingNavigator)).BeginInit();
            this.billing_PeriodsBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // period_IDLabel
            // 
            period_IDLabel.AutoSize = true;
            period_IDLabel.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            period_IDLabel.Location = new System.Drawing.Point(109, 77);
            period_IDLabel.Name = "period_IDLabel";
            period_IDLabel.Size = new System.Drawing.Size(53, 13);
            period_IDLabel.TabIndex = 1;
            period_IDLabel.Text = "رقم الفترة";
            // 
            // period_NameLabel
            // 
            period_NameLabel.AutoSize = true;
            period_NameLabel.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            period_NameLabel.Location = new System.Drawing.Point(109, 103);
            period_NameLabel.Name = "period_NameLabel";
            period_NameLabel.Size = new System.Drawing.Size(58, 13);
            period_NameLabel.TabIndex = 3;
            period_NameLabel.Text = "اسم الفترة";
            // 
            // start_DateLabel
            // 
            start_DateLabel.AutoSize = true;
            start_DateLabel.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            start_DateLabel.Location = new System.Drawing.Point(109, 130);
            start_DateLabel.Name = "start_DateLabel";
            start_DateLabel.Size = new System.Drawing.Size(51, 13);
            start_DateLabel.TabIndex = 5;
            start_DateLabel.Text = "تاريخ البدء";
            // 
            // end_DateLabel
            // 
            end_DateLabel.AutoSize = true;
            end_DateLabel.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            end_DateLabel.Location = new System.Drawing.Point(109, 156);
            end_DateLabel.Name = "end_DateLabel";
            end_DateLabel.Size = new System.Drawing.Size(61, 13);
            end_DateLabel.TabIndex = 7;
            end_DateLabel.Text = "تاريخ الانتهاء";
            // 
            // is_ClosedLabel
            // 
            is_ClosedLabel.AutoSize = true;
            is_ClosedLabel.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            is_ClosedLabel.Location = new System.Drawing.Point(97, 183);
            is_ClosedLabel.Name = "is_ClosedLabel";
            is_ClosedLabel.Size = new System.Drawing.Size(61, 13);
            is_ClosedLabel.TabIndex = 9;
            is_ClosedLabel.Text = "حالة الفواتير";
            is_ClosedLabel.Click += new System.EventHandler(this.is_ClosedLabel_Click);
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // billing_PeriodsBindingSource
            // 
            this.billing_PeriodsBindingSource.DataMember = "Billing_Periods";
            this.billing_PeriodsBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // billing_PeriodsTableAdapter
            // 
            this.billing_PeriodsTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AccountsTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Billing_PeriodsTableAdapter = this.billing_PeriodsTableAdapter;
            this.tableAdapterManager.CustomersTableAdapter = null;
            this.tableAdapterManager.Fixed_AssetsTableAdapter = null;
            this.tableAdapterManager.Fuel_ConsumptionTableAdapter = null;
            this.tableAdapterManager.InvoicesTableAdapter = null;
            this.tableAdapterManager.Journal_EntriesTableAdapter = null;
            this.tableAdapterManager.TariffsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // billing_PeriodsBindingNavigator
            // 
            this.billing_PeriodsBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.billing_PeriodsBindingNavigator.BindingSource = this.billing_PeriodsBindingSource;
            this.billing_PeriodsBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.billing_PeriodsBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.billing_PeriodsBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.billing_PeriodsBindingNavigatorSaveItem});
            this.billing_PeriodsBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.billing_PeriodsBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.billing_PeriodsBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.billing_PeriodsBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.billing_PeriodsBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.billing_PeriodsBindingNavigator.Name = "billing_PeriodsBindingNavigator";
            this.billing_PeriodsBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.billing_PeriodsBindingNavigator.Size = new System.Drawing.Size(458, 25);
            this.billing_PeriodsBindingNavigator.TabIndex = 0;
            this.billing_PeriodsBindingNavigator.Text = "bindingNavigator1";
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
            // billing_PeriodsBindingNavigatorSaveItem
            // 
            this.billing_PeriodsBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.billing_PeriodsBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("billing_PeriodsBindingNavigatorSaveItem.Image")));
            this.billing_PeriodsBindingNavigatorSaveItem.Name = "billing_PeriodsBindingNavigatorSaveItem";
            this.billing_PeriodsBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.billing_PeriodsBindingNavigatorSaveItem.Text = "Save Data";
            this.billing_PeriodsBindingNavigatorSaveItem.Click += new System.EventHandler(this.billing_PeriodsBindingNavigatorSaveItem_Click);
            // 
            // period_IDTextBox
            // 
            this.period_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.billing_PeriodsBindingSource, "Period_ID", true));
            this.period_IDTextBox.Location = new System.Drawing.Point(186, 74);
            this.period_IDTextBox.Name = "period_IDTextBox";
            this.period_IDTextBox.Size = new System.Drawing.Size(200, 20);
            this.period_IDTextBox.TabIndex = 2;
            // 
            // period_NameTextBox
            // 
            this.period_NameTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.billing_PeriodsBindingSource, "Period_Name", true));
            this.period_NameTextBox.Location = new System.Drawing.Point(186, 100);
            this.period_NameTextBox.Name = "period_NameTextBox";
            this.period_NameTextBox.Size = new System.Drawing.Size(200, 20);
            this.period_NameTextBox.TabIndex = 4;
            // 
            // start_DateDateTimePicker
            // 
            this.start_DateDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.billing_PeriodsBindingSource, "Start_Date", true));
            this.start_DateDateTimePicker.Location = new System.Drawing.Point(186, 126);
            this.start_DateDateTimePicker.Name = "start_DateDateTimePicker";
            this.start_DateDateTimePicker.Size = new System.Drawing.Size(200, 20);
            this.start_DateDateTimePicker.TabIndex = 6;
            // 
            // end_DateDateTimePicker
            // 
            this.end_DateDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.billing_PeriodsBindingSource, "End_Date", true));
            this.end_DateDateTimePicker.Location = new System.Drawing.Point(186, 152);
            this.end_DateDateTimePicker.Name = "end_DateDateTimePicker";
            this.end_DateDateTimePicker.Size = new System.Drawing.Size(200, 20);
            this.end_DateDateTimePicker.TabIndex = 8;
            // 
            // is_ClosedCheckBox
            // 
            this.is_ClosedCheckBox.DataBindings.Add(new System.Windows.Forms.Binding("CheckState", this.billing_PeriodsBindingSource, "Is_Closed", true));
            this.is_ClosedCheckBox.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.is_ClosedCheckBox.Location = new System.Drawing.Point(186, 178);
            this.is_ClosedCheckBox.Name = "is_ClosedCheckBox";
            this.is_ClosedCheckBox.Size = new System.Drawing.Size(200, 24);
            this.is_ClosedCheckBox.TabIndex = 10;
            this.is_ClosedCheckBox.Text = "مغلقه";
            this.is_ClosedCheckBox.UseVisualStyleBackColor = true;
            // 
            // Form_Billing_Periods
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(458, 261);
            this.Controls.Add(period_IDLabel);
            this.Controls.Add(this.period_IDTextBox);
            this.Controls.Add(period_NameLabel);
            this.Controls.Add(this.period_NameTextBox);
            this.Controls.Add(start_DateLabel);
            this.Controls.Add(this.start_DateDateTimePicker);
            this.Controls.Add(end_DateLabel);
            this.Controls.Add(this.end_DateDateTimePicker);
            this.Controls.Add(is_ClosedLabel);
            this.Controls.Add(this.is_ClosedCheckBox);
            this.Controls.Add(this.billing_PeriodsBindingNavigator);
            this.ForeColor = System.Drawing.Color.Black;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Billing_Periods";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام الفوترة";
            this.Load += new System.EventHandler(this.Form_Billing_Periods_Load);
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.billing_PeriodsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.billing_PeriodsBindingNavigator)).EndInit();
            this.billing_PeriodsBindingNavigator.ResumeLayout(false);
            this.billing_PeriodsBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource billing_PeriodsBindingSource;
        private EElectricitySystemDataSetTableAdapters.Billing_PeriodsTableAdapter billing_PeriodsTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator billing_PeriodsBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton billing_PeriodsBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox period_IDTextBox;
        private System.Windows.Forms.TextBox period_NameTextBox;
        private System.Windows.Forms.DateTimePicker start_DateDateTimePicker;
        private System.Windows.Forms.DateTimePicker end_DateDateTimePicker;
        private System.Windows.Forms.CheckBox is_ClosedCheckBox;
    }
}