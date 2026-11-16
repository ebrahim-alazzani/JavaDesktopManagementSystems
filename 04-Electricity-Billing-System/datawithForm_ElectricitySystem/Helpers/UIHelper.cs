using System;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Windows.Forms;

namespace datawithForm_ElectricitySystem
{
    /// <summary>
    /// كلاس مساعد لتنسيق وتجميل الفورمات
    /// </summary>
    public static class UIHelper
    {
        // ===== الألوان =====
        public static Color PrimaryColor = Color.FromArgb(59, 130, 246);
        public static Color PrimaryDark = Color.FromArgb(37, 99, 235);
        public static Color SecondaryColor = Color.FromArgb(100, 116, 139);
        public static Color SuccessColor = Color.FromArgb(34, 197, 94);
        public static Color DangerColor = Color.FromArgb(239, 68, 68);
        public static Color WarningColor = Color.FromArgb(245, 158, 11);
        public static Color InfoColor = Color.FromArgb(6, 182, 212);

        public static Color BgDark = Color.FromArgb(15, 23, 42);
        public static Color BgCard = Color.FromArgb(30, 41, 59);
        public static Color BgHover = Color.FromArgb(51, 65, 85);
        public static Color BgInput = Color.FromArgb(15, 23, 42);

        public static Color TextPrimary = Color.FromArgb(241, 245, 249);
        public static Color TextSecondary = Color.FromArgb(148, 163, 184);
        public static Color BorderColor = Color.FromArgb(51, 65, 85);

        // ===== تنسيق الفورم =====
        public static void StyleForm(Form form)
        {
            form.BackColor = BgDark;
            form.ForeColor = TextPrimary;
            form.Font = new Font("Segoe UI", 10F);
            form.RightToLeft = RightToLeft.Yes;
            form.RightToLeftLayout = true;
            form.StartPosition = FormStartPosition.CenterScreen;
        }

        // ===== تنسيق DataGridView =====
        public static void StyleDataGridView(DataGridView dgv)
        {
            dgv.BackgroundColor = BgCard;
            dgv.BorderStyle = BorderStyle.None;
            dgv.GridColor = BorderColor;
            dgv.CellBorderStyle = DataGridViewCellBorderStyle.SingleHorizontal;

            dgv.EnableHeadersVisualStyles = false;
            dgv.ColumnHeadersDefaultCellStyle.BackColor = PrimaryDark;
            dgv.ColumnHeadersDefaultCellStyle.ForeColor = Color.White;
            dgv.ColumnHeadersDefaultCellStyle.Font = new Font("Segoe UI", 10F, FontStyle.Bold);
            dgv.ColumnHeadersDefaultCellStyle.Alignment = DataGridViewContentAlignment.MiddleCenter;
            dgv.ColumnHeadersHeight = 40;

            dgv.DefaultCellStyle.BackColor = BgCard;
            dgv.DefaultCellStyle.ForeColor = TextPrimary;
            dgv.DefaultCellStyle.SelectionBackColor = PrimaryColor;
            dgv.DefaultCellStyle.SelectionForeColor = Color.White;
            dgv.DefaultCellStyle.Font = new Font("Segoe UI", 9.5F);
            dgv.DefaultCellStyle.Padding = new Padding(5);

            dgv.AlternatingRowsDefaultCellStyle.BackColor = Color.FromArgb(25, 35, 50);

            dgv.RowHeadersVisible = false;
            dgv.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgv.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
            dgv.AllowUserToAddRows = false;
            dgv.AllowUserToDeleteRows = false;
            dgv.ReadOnly = true;
            dgv.MultiSelect = false;
            dgv.RowTemplate.Height = 35;
        }

        // ===== تنسيق الأزرار =====
        public static Button CreateButton(string text, Color bgColor, int width = 130, int height = 38)
        {
            Button btn = new Button();
            btn.Text = text;
            btn.Width = width;
            btn.Height = height;
            btn.FlatStyle = FlatStyle.Flat;
            btn.FlatAppearance.BorderSize = 0;
            btn.BackColor = bgColor;
            btn.ForeColor = Color.White;
            btn.Font = new Font("Segoe UI", 10F, FontStyle.Bold);
            btn.Cursor = Cursors.Hand;
            btn.FlatAppearance.MouseOverBackColor = ControlPaint.Dark(bgColor, 0.1f);

            // تأثير hover
            btn.MouseEnter += (s, e) => btn.BackColor = ControlPaint.Dark(bgColor, 0.15f);
            btn.MouseLeave += (s, e) => btn.BackColor = bgColor;
            return btn;
        }

        // ===== تنسيق TextBox =====
        public static void StyleTextBox(TextBox txt)
        {
            txt.BackColor = BgInput;
            txt.ForeColor = TextPrimary;
            txt.BorderStyle = BorderStyle.FixedSingle;
            txt.Font = new Font("Segoe UI", 10F);
            txt.Height = 30;
        }

        // ===== تنسيق ComboBox =====
        public static void StyleComboBox(ComboBox cmb)
        {
            cmb.BackColor = BgInput;
            cmb.ForeColor = TextPrimary;
            cmb.FlatStyle = FlatStyle.Flat;
            cmb.Font = new Font("Segoe UI", 10F);
            cmb.DropDownStyle = ComboBoxStyle.DropDownList;
        }

        // ===== تنسيق Label =====
        public static Label CreateLabel(string text, bool isTitle = false)
        {
            Label lbl = new Label();
            lbl.Text = text;
            lbl.ForeColor = isTitle ? TextPrimary : TextSecondary;
            lbl.Font = isTitle ? new Font("Segoe UI", 14F, FontStyle.Bold) : new Font("Segoe UI", 10F);
            lbl.AutoSize = true;
            return lbl;
        }

        // ===== تنسيق Panel (بطاقة) =====
        public static Panel CreateCard(int width, int height)
        {
            Panel pnl = new Panel();
            pnl.Width = width;
            pnl.Height = height;
            pnl.BackColor = BgCard;
            pnl.Padding = new Padding(15);
            return pnl;
        }

        // ===== بطاقة الإحصائيات في لوحة التحكم =====
        public static Panel CreateStatCard(string title, string value, Color gradientColor, int width = 220, int height = 100)
        {
            Panel card = new Panel();
            card.Width = width;
            card.Height = height;
            card.BackColor = gradientColor;
            card.Padding = new Padding(15);

            Label lblValue = new Label();
            lblValue.Text = value;
            lblValue.Font = new Font("Segoe UI", 22F, FontStyle.Bold);
            lblValue.ForeColor = Color.White;
            lblValue.AutoSize = true;
            lblValue.Location = new Point(15, 12);
            lblValue.Tag = "stat_value";

            Label lblTitle = new Label();
            lblTitle.Text = title;
            lblTitle.Font = new Font("Segoe UI", 10F);
            lblTitle.ForeColor = Color.FromArgb(220, 220, 220);
            lblTitle.AutoSize = true;
            lblTitle.Location = new Point(15, 55);

            card.Controls.Add(lblValue);
            card.Controls.Add(lblTitle);
            return card;
        }

        // ===== رسالة نجاح =====
        public static void ShowSuccess(string message)
        {
            MessageBox.Show(message, "نجاح", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        // ===== رسالة خطأ =====
        public static void ShowError(string message)
        {
            MessageBox.Show(message, "خطأ", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        // ===== رسالة تأكيد =====
        public static bool ShowConfirm(string message)
        {
            return MessageBox.Show(message, "تأكيد", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes;
        }

        // ===== تنسيق GroupBox =====
        public static void StyleGroupBox(GroupBox grp)
        {
            grp.ForeColor = TextPrimary;
            grp.Font = new Font("Segoe UI", 10F, FontStyle.Bold);
            grp.BackColor = BgCard;
        }

        // ===== تنسيق DateTimePicker =====
        public static void StyleDatePicker(DateTimePicker dtp)
        {
            dtp.CalendarMonthBackground = BgInput;
            dtp.CalendarForeColor = TextPrimary;
            dtp.Font = new Font("Segoe UI", 10F);
            dtp.Format = DateTimePickerFormat.Short;
        }

        // ===== إعداد أعمدة DataGridView مسبقاً =====
        /// <summary>
        /// إضافة أعمدة DataGridView مسبقاً لتظهر أثناء التطوير
        /// cols: مصفوفة ثنائية الأبعاد [,] {{"اسم_الحقل","عنوان_العمود"}}
        /// </summary>
        public static void SetupColumns(DataGridView dgv, string[,] cols)
        {
            dgv.AutoGenerateColumns = false;
            dgv.Columns.Clear();
            for (int i = 0; i < cols.GetLength(0); i++)
            {
                DataGridViewTextBoxColumn col = new DataGridViewTextBoxColumn();
                col.Name = cols[i, 0];
                col.DataPropertyName = cols[i, 0];
                col.HeaderText = cols[i, 1];
                col.AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill;
                dgv.Columns.Add(col);
            }
        }
    }
}
