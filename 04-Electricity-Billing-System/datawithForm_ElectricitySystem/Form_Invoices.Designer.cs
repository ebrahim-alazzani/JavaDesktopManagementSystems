namespace datawithForm_ElectricitySystem
{
    partial class Form_Invoices
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
            System.Windows.Forms.Label invoice_IDLabel;
            System.Windows.Forms.Label manual_Invoice_NoLabel;
            System.Windows.Forms.Label customer_IDLabel;
            System.Windows.Forms.Label period_IDLabel;
            System.Windows.Forms.Label previous_ReadingLabel;
            System.Windows.Forms.Label current_ReadingLabel;
            System.Windows.Forms.Label consumptionLabel;
            System.Windows.Forms.Label current_AmountLabel;
            System.Windows.Forms.Label previous_BalanceLabel;
            System.Windows.Forms.Label total_BalanceLabel;
            System.Windows.Forms.Label invoice_DateLabel;
            System.Windows.Forms.Label is_PaidLabel;
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form_Invoices));
            this.eElectricitySystemDataSet = new datawithForm_ElectricitySystem.EElectricitySystemDataSet();
            this.invoicesBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.invoicesTableAdapter = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.InvoicesTableAdapter();
            this.tableAdapterManager = new datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager();
            this.invoicesBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
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
            this.invoicesBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.invoice_IDTextBox = new System.Windows.Forms.TextBox();
            this.manual_Invoice_NoTextBox = new System.Windows.Forms.TextBox();
            this.customer_IDTextBox = new System.Windows.Forms.TextBox();
            this.period_IDTextBox = new System.Windows.Forms.TextBox();
            this.previous_ReadingTextBox = new System.Windows.Forms.TextBox();
            this.current_ReadingTextBox = new System.Windows.Forms.TextBox();
            this.consumptionTextBox = new System.Windows.Forms.TextBox();
            this.current_AmountTextBox = new System.Windows.Forms.TextBox();
            this.previous_BalanceTextBox = new System.Windows.Forms.TextBox();
            this.total_BalanceTextBox = new System.Windows.Forms.TextBox();
            this.invoice_DateDateTimePicker = new System.Windows.Forms.DateTimePicker();
            this.is_PaidCheckBox = new System.Windows.Forms.CheckBox();
            invoice_IDLabel = new System.Windows.Forms.Label();
            manual_Invoice_NoLabel = new System.Windows.Forms.Label();
            customer_IDLabel = new System.Windows.Forms.Label();
            period_IDLabel = new System.Windows.Forms.Label();
            previous_ReadingLabel = new System.Windows.Forms.Label();
            current_ReadingLabel = new System.Windows.Forms.Label();
            consumptionLabel = new System.Windows.Forms.Label();
            current_AmountLabel = new System.Windows.Forms.Label();
            previous_BalanceLabel = new System.Windows.Forms.Label();
            total_BalanceLabel = new System.Windows.Forms.Label();
            invoice_DateLabel = new System.Windows.Forms.Label();
            is_PaidLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.invoicesBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.invoicesBindingNavigator)).BeginInit();
            this.invoicesBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // invoice_IDLabel
            // 
            invoice_IDLabel.AutoSize = true;
            invoice_IDLabel.Location = new System.Drawing.Point(151, 78);
            invoice_IDLabel.Name = "invoice_IDLabel";
            invoice_IDLabel.Size = new System.Drawing.Size(86, 13);
            invoice_IDLabel.TabIndex = 1;
            invoice_IDLabel.Text = "رقم الفاتوره الالي";
            // 
            // manual_Invoice_NoLabel
            // 
            manual_Invoice_NoLabel.AutoSize = true;
            manual_Invoice_NoLabel.Location = new System.Drawing.Point(151, 107);
            manual_Invoice_NoLabel.Name = "manual_Invoice_NoLabel";
            manual_Invoice_NoLabel.Size = new System.Drawing.Size(93, 13);
            manual_Invoice_NoLabel.TabIndex = 3;
            manual_Invoice_NoLabel.Text = "رقم الفاتورة اليدوي";
            manual_Invoice_NoLabel.Click += new System.EventHandler(this.manual_Invoice_NoLabel_Click);
            // 
            // customer_IDLabel
            // 
            customer_IDLabel.AutoSize = true;
            customer_IDLabel.Location = new System.Drawing.Point(151, 130);
            customer_IDLabel.Name = "customer_IDLabel";
            customer_IDLabel.Size = new System.Drawing.Size(69, 13);
            customer_IDLabel.TabIndex = 5;
            customer_IDLabel.Text = "رقم المشترك";
            customer_IDLabel.Click += new System.EventHandler(this.customer_IDLabel_Click);
            // 
            // period_IDLabel
            // 
            period_IDLabel.AutoSize = true;
            period_IDLabel.Location = new System.Drawing.Point(151, 156);
            period_IDLabel.Name = "period_IDLabel";
            period_IDLabel.Size = new System.Drawing.Size(53, 13);
            period_IDLabel.TabIndex = 7;
            period_IDLabel.Text = "رقم الفترة";
            // 
            // previous_ReadingLabel
            // 
            previous_ReadingLabel.AutoSize = true;
            previous_ReadingLabel.Location = new System.Drawing.Point(151, 185);
            previous_ReadingLabel.Name = "previous_ReadingLabel";
            previous_ReadingLabel.Size = new System.Drawing.Size(75, 13);
            previous_ReadingLabel.TabIndex = 9;
            previous_ReadingLabel.Text = "القراءه السابقة";
            // 
            // current_ReadingLabel
            // 
            current_ReadingLabel.AutoSize = true;
            current_ReadingLabel.Location = new System.Drawing.Point(151, 211);
            current_ReadingLabel.Name = "current_ReadingLabel";
            current_ReadingLabel.Size = new System.Drawing.Size(68, 13);
            current_ReadingLabel.TabIndex = 11;
            current_ReadingLabel.Text = "القراءه الحالية";
            // 
            // consumptionLabel
            // 
            consumptionLabel.AutoSize = true;
            consumptionLabel.Location = new System.Drawing.Point(151, 237);
            consumptionLabel.Name = "consumptionLabel";
            consumptionLabel.Size = new System.Drawing.Size(79, 13);
            consumptionLabel.TabIndex = 13;
            consumptionLabel.Text = "كمية الاستهلاك";
            // 
            // current_AmountLabel
            // 
            current_AmountLabel.AutoSize = true;
            current_AmountLabel.Location = new System.Drawing.Point(151, 263);
            current_AmountLabel.Name = "current_AmountLabel";
            current_AmountLabel.Size = new System.Drawing.Size(67, 13);
            current_AmountLabel.TabIndex = 15;
            current_AmountLabel.Text = "المبلغ الحالي";
            // 
            // previous_BalanceLabel
            // 
            previous_BalanceLabel.AutoSize = true;
            previous_BalanceLabel.Location = new System.Drawing.Point(151, 289);
            previous_BalanceLabel.Name = "previous_BalanceLabel";
            previous_BalanceLabel.Size = new System.Drawing.Size(74, 13);
            previous_BalanceLabel.TabIndex = 17;
            previous_BalanceLabel.Text = "الرصيد السابق";
            // 
            // total_BalanceLabel
            // 
            total_BalanceLabel.AutoSize = true;
            total_BalanceLabel.Location = new System.Drawing.Point(151, 315);
            total_BalanceLabel.Name = "total_BalanceLabel";
            total_BalanceLabel.Size = new System.Drawing.Size(123, 13);
            total_BalanceLabel.TabIndex = 19;
            total_BalanceLabel.Text = "اجمالي الرصيد المستحق";
            // 
            // invoice_DateLabel
            // 
            invoice_DateLabel.AutoSize = true;
            invoice_DateLabel.Location = new System.Drawing.Point(151, 340);
            invoice_DateLabel.Name = "invoice_DateLabel";
            invoice_DateLabel.Size = new System.Drawing.Size(63, 13);
            invoice_DateLabel.TabIndex = 21;
            invoice_DateLabel.Text = "تاريخ الفاتورة";
            // 
            // is_PaidLabel
            // 
            is_PaidLabel.AutoSize = true;
            is_PaidLabel.Location = new System.Drawing.Point(151, 364);
            is_PaidLabel.Name = "is_PaidLabel";
            is_PaidLabel.Size = new System.Drawing.Size(61, 13);
            is_PaidLabel.TabIndex = 23;
            is_PaidLabel.Text = "حالة السداد";
            is_PaidLabel.Click += new System.EventHandler(this.is_PaidLabel_Click);
            // 
            // eElectricitySystemDataSet
            // 
            this.eElectricitySystemDataSet.DataSetName = "EElectricitySystemDataSet";
            this.eElectricitySystemDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // invoicesBindingSource
            // 
            this.invoicesBindingSource.DataMember = "Invoices";
            this.invoicesBindingSource.DataSource = this.eElectricitySystemDataSet;
            // 
            // invoicesTableAdapter
            // 
            this.invoicesTableAdapter.ClearBeforeFill = true;
            // 
            // tableAdapterManager
            // 
            this.tableAdapterManager.AccountsTableAdapter = null;
            this.tableAdapterManager.BackupDataSetBeforeUpdate = false;
            this.tableAdapterManager.Billing_PeriodsTableAdapter = null;
            this.tableAdapterManager.CustomersTableAdapter = null;
            this.tableAdapterManager.Fixed_AssetsTableAdapter = null;
            this.tableAdapterManager.Fuel_ConsumptionTableAdapter = null;
            this.tableAdapterManager.InvoicesTableAdapter = this.invoicesTableAdapter;
            this.tableAdapterManager.Journal_EntriesTableAdapter = null;
            this.tableAdapterManager.TariffsTableAdapter = null;
            this.tableAdapterManager.UpdateOrder = datawithForm_ElectricitySystem.EElectricitySystemDataSetTableAdapters.TableAdapterManager.UpdateOrderOption.InsertUpdateDelete;
            // 
            // invoicesBindingNavigator
            // 
            this.invoicesBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.invoicesBindingNavigator.BindingSource = this.invoicesBindingSource;
            this.invoicesBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.invoicesBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.invoicesBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
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
            this.invoicesBindingNavigatorSaveItem});
            this.invoicesBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.invoicesBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.invoicesBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.invoicesBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.invoicesBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.invoicesBindingNavigator.Name = "invoicesBindingNavigator";
            this.invoicesBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.invoicesBindingNavigator.Size = new System.Drawing.Size(621, 25);
            this.invoicesBindingNavigator.TabIndex = 0;
            this.invoicesBindingNavigator.Text = "bindingNavigator1";
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
            // invoicesBindingNavigatorSaveItem
            // 
            this.invoicesBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.invoicesBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("invoicesBindingNavigatorSaveItem.Image")));
            this.invoicesBindingNavigatorSaveItem.Name = "invoicesBindingNavigatorSaveItem";
            this.invoicesBindingNavigatorSaveItem.Size = new System.Drawing.Size(23, 22);
            this.invoicesBindingNavigatorSaveItem.Text = "Save Data";
            this.invoicesBindingNavigatorSaveItem.Click += new System.EventHandler(this.invoicesBindingNavigatorSaveItem_Click);
            // 
            // invoice_IDTextBox
            // 
            this.invoice_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Invoice_ID", true));
            this.invoice_IDTextBox.Location = new System.Drawing.Point(286, 74);
            this.invoice_IDTextBox.Name = "invoice_IDTextBox";
            this.invoice_IDTextBox.Size = new System.Drawing.Size(200, 20);
            this.invoice_IDTextBox.TabIndex = 2;
            // 
            // manual_Invoice_NoTextBox
            // 
            this.manual_Invoice_NoTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Manual_Invoice_No", true));
            this.manual_Invoice_NoTextBox.Location = new System.Drawing.Point(286, 100);
            this.manual_Invoice_NoTextBox.Name = "manual_Invoice_NoTextBox";
            this.manual_Invoice_NoTextBox.Size = new System.Drawing.Size(200, 20);
            this.manual_Invoice_NoTextBox.TabIndex = 4;
            // 
            // customer_IDTextBox
            // 
            this.customer_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Customer_ID", true));
            this.customer_IDTextBox.Location = new System.Drawing.Point(286, 126);
            this.customer_IDTextBox.Name = "customer_IDTextBox";
            this.customer_IDTextBox.Size = new System.Drawing.Size(200, 20);
            this.customer_IDTextBox.TabIndex = 6;
            // 
            // period_IDTextBox
            // 
            this.period_IDTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Period_ID", true));
            this.period_IDTextBox.Location = new System.Drawing.Point(286, 152);
            this.period_IDTextBox.Name = "period_IDTextBox";
            this.period_IDTextBox.Size = new System.Drawing.Size(200, 20);
            this.period_IDTextBox.TabIndex = 8;
            // 
            // previous_ReadingTextBox
            // 
            this.previous_ReadingTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Previous_Reading", true));
            this.previous_ReadingTextBox.Location = new System.Drawing.Point(286, 178);
            this.previous_ReadingTextBox.Name = "previous_ReadingTextBox";
            this.previous_ReadingTextBox.Size = new System.Drawing.Size(200, 20);
            this.previous_ReadingTextBox.TabIndex = 10;
            // 
            // current_ReadingTextBox
            // 
            this.current_ReadingTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Current_Reading", true));
            this.current_ReadingTextBox.Location = new System.Drawing.Point(286, 204);
            this.current_ReadingTextBox.Name = "current_ReadingTextBox";
            this.current_ReadingTextBox.Size = new System.Drawing.Size(200, 20);
            this.current_ReadingTextBox.TabIndex = 12;
            // 
            // consumptionTextBox
            // 
            this.consumptionTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Consumption", true));
            this.consumptionTextBox.Location = new System.Drawing.Point(286, 230);
            this.consumptionTextBox.Name = "consumptionTextBox";
            this.consumptionTextBox.Size = new System.Drawing.Size(200, 20);
            this.consumptionTextBox.TabIndex = 14;
            // 
            // current_AmountTextBox
            // 
            this.current_AmountTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Current_Amount", true));
            this.current_AmountTextBox.Location = new System.Drawing.Point(286, 256);
            this.current_AmountTextBox.Name = "current_AmountTextBox";
            this.current_AmountTextBox.Size = new System.Drawing.Size(200, 20);
            this.current_AmountTextBox.TabIndex = 16;
            // 
            // previous_BalanceTextBox
            // 
            this.previous_BalanceTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Previous_Balance", true));
            this.previous_BalanceTextBox.Location = new System.Drawing.Point(286, 282);
            this.previous_BalanceTextBox.Name = "previous_BalanceTextBox";
            this.previous_BalanceTextBox.Size = new System.Drawing.Size(200, 20);
            this.previous_BalanceTextBox.TabIndex = 18;
            // 
            // total_BalanceTextBox
            // 
            this.total_BalanceTextBox.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.invoicesBindingSource, "Total_Balance", true));
            this.total_BalanceTextBox.Location = new System.Drawing.Point(286, 308);
            this.total_BalanceTextBox.Name = "total_BalanceTextBox";
            this.total_BalanceTextBox.Size = new System.Drawing.Size(200, 20);
            this.total_BalanceTextBox.TabIndex = 20;
            // 
            // invoice_DateDateTimePicker
            // 
            this.invoice_DateDateTimePicker.DataBindings.Add(new System.Windows.Forms.Binding("Value", this.invoicesBindingSource, "Invoice_Date", true));
            this.invoice_DateDateTimePicker.Location = new System.Drawing.Point(286, 334);
            this.invoice_DateDateTimePicker.Name = "invoice_DateDateTimePicker";
            this.invoice_DateDateTimePicker.Size = new System.Drawing.Size(200, 20);
            this.invoice_DateDateTimePicker.TabIndex = 22;
            // 
            // is_PaidCheckBox
            // 
            this.is_PaidCheckBox.DataBindings.Add(new System.Windows.Forms.Binding("CheckState", this.invoicesBindingSource, "Is_Paid", true));
            this.is_PaidCheckBox.Location = new System.Drawing.Point(286, 364);
            this.is_PaidCheckBox.Name = "is_PaidCheckBox";
            this.is_PaidCheckBox.Size = new System.Drawing.Size(200, 24);
            this.is_PaidCheckBox.TabIndex = 24;
            this.is_PaidCheckBox.Text = "تم السداد";
            this.is_PaidCheckBox.UseVisualStyleBackColor = true;
            // 
            // Form_Invoices
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(621, 425);
            this.Controls.Add(invoice_IDLabel);
            this.Controls.Add(this.invoice_IDTextBox);
            this.Controls.Add(manual_Invoice_NoLabel);
            this.Controls.Add(this.manual_Invoice_NoTextBox);
            this.Controls.Add(customer_IDLabel);
            this.Controls.Add(this.customer_IDTextBox);
            this.Controls.Add(period_IDLabel);
            this.Controls.Add(this.period_IDTextBox);
            this.Controls.Add(previous_ReadingLabel);
            this.Controls.Add(this.previous_ReadingTextBox);
            this.Controls.Add(current_ReadingLabel);
            this.Controls.Add(this.current_ReadingTextBox);
            this.Controls.Add(consumptionLabel);
            this.Controls.Add(this.consumptionTextBox);
            this.Controls.Add(current_AmountLabel);
            this.Controls.Add(this.current_AmountTextBox);
            this.Controls.Add(previous_BalanceLabel);
            this.Controls.Add(this.previous_BalanceTextBox);
            this.Controls.Add(total_BalanceLabel);
            this.Controls.Add(this.total_BalanceTextBox);
            this.Controls.Add(invoice_DateLabel);
            this.Controls.Add(this.invoice_DateDateTimePicker);
            this.Controls.Add(is_PaidLabel);
            this.Controls.Add(this.is_PaidCheckBox);
            this.Controls.Add(this.invoicesBindingNavigator);
            this.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "Form_Invoices";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.RightToLeftLayout = true;
            this.Text = "نظام الفواتير";
            this.TransparencyKey = System.Drawing.Color.Navy;
            this.Load += new System.EventHandler(this.Form_Invoices_Load);
            ((System.ComponentModel.ISupportInitialize)(this.eElectricitySystemDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.invoicesBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.invoicesBindingNavigator)).EndInit();
            this.invoicesBindingNavigator.ResumeLayout(false);
            this.invoicesBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private EElectricitySystemDataSet eElectricitySystemDataSet;
        private System.Windows.Forms.BindingSource invoicesBindingSource;
        private EElectricitySystemDataSetTableAdapters.InvoicesTableAdapter invoicesTableAdapter;
        private EElectricitySystemDataSetTableAdapters.TableAdapterManager tableAdapterManager;
        private System.Windows.Forms.BindingNavigator invoicesBindingNavigator;
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
        private System.Windows.Forms.ToolStripButton invoicesBindingNavigatorSaveItem;
        private System.Windows.Forms.TextBox invoice_IDTextBox;
        private System.Windows.Forms.TextBox manual_Invoice_NoTextBox;
        private System.Windows.Forms.TextBox customer_IDTextBox;
        private System.Windows.Forms.TextBox period_IDTextBox;
        private System.Windows.Forms.TextBox previous_ReadingTextBox;
        private System.Windows.Forms.TextBox current_ReadingTextBox;
        private System.Windows.Forms.TextBox consumptionTextBox;
        private System.Windows.Forms.TextBox current_AmountTextBox;
        private System.Windows.Forms.TextBox previous_BalanceTextBox;
        private System.Windows.Forms.TextBox total_BalanceTextBox;
        private System.Windows.Forms.DateTimePicker invoice_DateDateTimePicker;
        private System.Windows.Forms.CheckBox is_PaidCheckBox;
    }
}