namespace datawithForm_ElectricitySystem
{
    partial class Form_Journal_Entries
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
            System.Windows.Forms.Label entry_IDLabel;
            System.Windows.Forms.Label entry_DateLabel;
            System.Windows.Forms.Label descriptionLabel;
            System.Windows.Forms.Label total_DebitLabel;
            System.Windows.Forms.Label total_CreditLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Journal_Entries));
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.journal_EntriesBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.journal_EntriesTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.Journal_EntriesTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            this.journal_EntriesBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.journal_EntriesBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.entry_IDTextBox = new System.Windows.Forms.TextBox();
            this.entry_DateDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.descriptionTextBox = new System.Windows.Forms.TextBox();
            this.total_DebitTextBox = new System.Windows.Forms.TextBox();
            this.total_CreditTextBox = new System.Windows.Forms.TextBox();
            entry_IDLabel = new System.Windows.Forms.Label();
            entry_DateLabel = new System.Windows.Forms.Label();
            descriptionLabel = new System.Windows.Forms.Label();
            total_DebitLabel = new System.Windows.Forms.Label();
            total_CreditLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.journal_EntriesBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.journal_EntriesBindingNavigator)).BeginInit();
            this.journal_EntriesBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // entry_IDLabel
            // 
            entry_IDLabel.AutoSize = true;
            entry_IDLabel.Location = new System.Drawing.Point(174, 103);
            entry_IDLabel.Name = "entry_IDLabel";
            entry_IDLabel.Size = new System.Drawing.Size(49, 13);
            entry_IDLabel.TabIndex = 1;
            entry_IDLabel.Text = "رقم القيد";
            // 
            // entry_DateLabel
            // 
            entry_DateLabel.AutoSize = true;
            entry_DateLabel.Location = new System.Drawing.Point(174, 130);
            entry_DateLabel.Name = "entry_DateLabel";
            entry_DateLabel.Size = new System.Drawing.Size(53, 13);
            entry_DateLabel.TabIndex = 3;
            entry_DateLabel.Text = "تاريخ القيد";
            // 
            // descriptionLabel
            // 
            descriptionLabel.AutoSize = true;
            descriptionLabel.Location = new System.Drawing.Point(174, 155);
            descriptionLabel.Name = "descriptionLabel";
            descriptionLabel.Size = new System.Drawing.Size(31, 13);
            descriptionLabel.TabIndex = 5;
            descriptionLabel.Text = "البيان";
            // 
            // total_DebitLabel
            // 
            total_DebitLabel.AutoSize = true;
            total_DebitLabel.Location = new System.Drawing.Point(174, 181);
            total_DebitLabel.Name = "total_DebitLabel";
            total_DebitLabel.Size = new System.Drawing.Size(74, 13);
            total_DebitLabel.TabIndex = 7;
            total_DebitLabel.Text = "اجمالي المدين";
            // 
            // total_CreditLabel
            // 
            total_CreditLabel.AutoSize = true;
            total_CreditLabel.Location = new System.Drawing.Point(174, 207);
            total_CreditLabel.Name = "total_CreditLabel";
            total_CreditLabel.Size = new System.Drawing.Size(70, 13);
            total_CreditLabel.TabIndex = 9;
            total_CreditLabel.Text = "اجمالي الدائن";
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // journal_EntriesBindingSource
            // 
            this.journal_EntriesBindingSource.DataMember = "Journal_Entries";
            this.journal_EntriesBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // journal_EntriesTableAdapter
            // 
            this.journal_EntriesTableAdapter.ClearBeforeFill = true;
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
            this.tableAdapterManager.Journal_EntriesTableAdapter = this.journal_EntriesTableAdapter;
            this.tableAdapterManager.TariffsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // journal_EntriesBindingNavigator
            // 
            this.journal_EntriesBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.journal_EntriesBindingNavigator.BindingSource = this.journal_EntriesBindingSource;
            this.journal_EntriesBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.journal_EntriesBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.journal_EntriesBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.journal_EntriesBindingNavigatorSaveItem});
            this.journal_EntriesBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.journal_EntriesBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.journal_EntriesBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.journal_EntriesBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.journal_EntriesBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.journal_EntriesBindingNavigator.Name = "journal_EntriesBindingNavigator";
            this.journal_EntriesBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.journal_EntriesBindingNavigator.Size = new System.Drawing.Size(653, 25);
            this.journal_EntriesBindingNavigator.TabIndex = 0;
            this.journal_EntriesBindingNavigator.Text = "bindingNavigator1";
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
            // journal_EntriesBindingNavigatorSaveItem
            // 
            this.journal_EntriesBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.journal_EntriesBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("journal_EntriesBindingNavigatorSaveItem.Image")));
            this.journal_EntriesBindingNavigatorSaveItem.Name = "journal_EntriesBindingNavigatorSaveItem";
            this.journal_EntriesBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.journal_EntriesBindingNavigatorSaveItem.Text = "Save Data";
            this.journal_EntriesBindingNavigatorSaveItem.Click += new System.EventHandler(this.journal_EntriesBindingNavigatorSaveItem_Click);
            // 
            // entry_IDTextBox
            // 
            this.entry_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.journal_EntriesBindingSource, "Entry_ID", true));
            this.entry_IDTextBox.Location = new System.Drawing.Point(247, 100);
            this.entry_IDTextBox.Name = "entry_IDTextBox";
            this.entry_IDTextBox.Size = new System.Drawing.Size(200, 20);
            this.entry_IDTextBox.TabIndex = 2;
            // 
            // entry_DateDateTimePicker
            // 
            this.entry_DateDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.journal_EntriesBindingSource, "Entry_Date", true));
            this.entry_DateDateTimePicker.Location = new System.Drawing.Point(247, 126);
            this.entry_DateDateTimePicker.Name = "entry_DateDateTimePicker";
            this.entry_DateDateTimePicker.Size = new System.Drawing.Size(200, 20);
            this.entry_DateDateTimePicker.TabIndex = 4;
            // 
            // descriptionTextBox
            // 
            this.descriptionTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.journal_EntriesBindingSource, "Description", true));
            this.descriptionTextBox.Location = new System.Drawing.Point(247, 152);
            this.descriptionTextBox.Name = "descriptionTextBox";
            this.descriptionTextBox.Size = new System.Drawing.Size(200, 20);
            this.descriptionTextBox.TabIndex = 6;
            // 
            // total_DebitTextBox
            // 
            this.total_DebitTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.journal_EntriesBindingSource, "Total_Debit", true));
            this.total_DebitTextBox.Location = new System.Drawing.Point(247, 178);
            this.total_DebitTextBox.Name = "total_DebitTextBox";
            this.total_DebitTextBox.Size = new System.Drawing.Size(200, 20);
            this.total_DebitTextBox.TabIndex = 8;
            // 
            // total_CreditTextBox
            // 
            this.total_CreditTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.journal_EntriesBindingSource, "Total_Credit", true));
            this.total_CreditTextBox.Location = new System.Drawing.Point(247, 204);
            this.total_CreditTextBox.Name = "total_CreditTextBox";
            this.total_CreditTextBox.Size = new System.Drawing.Size(200, 20);
            this.total_CreditTextBox.TabIndex = 10;
            // 
            // Form_Journal_Entries
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(653, 392);
            this.Controls.Add(entry_IDLabel);
            this.Controls.Add(this.entry_IDTextBox);
            this.Controls.Add(entry_DateLabel);
            this.Controls.Add(this.entry_DateDateTimePicker);
            this.Controls.Add(descriptionLabel);
            this.Controls.Add(this.descriptionTextBox);
            this.Controls.Add(total_DebitLabel);
            this.Controls.Add(this.total_DebitTextBox);
            this.Controls.Add(total_CreditLabel);
            this.Controls.Add(this.total_CreditTextBox);
            this.Controls.Add(this.journal_EntriesBindingNavigator);
            this.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Journal_Entries";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام القيود اليوميه";
            this.Load += new System.EventHandler(this.Form_Journal_Entries_Load);
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.journal_EntriesBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.journal_EntriesBindingNavigator)).EndInit();
            this.journal_EntriesBindingNavigator.ResumeLayout(false);
            this.journal_EntriesBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource journal_EntriesBindingSource;
        private EElectricitySystemDataSetTableAdapters.Journal_EntriesTableAdapter journal_EntriesTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator journal_EntriesBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton journal_EntriesBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox entry_IDTextBox;
        private System.Windows.Forms.DateTimePicker entry_DateDateTimePicker;
        private System.Windows.Forms.TextBox descriptionTextBox;
        private System.Windows.Forms.TextBox total_DebitTextBox;
        private System.Windows.Forms.TextBox total_CreditTextBox;

    }
}