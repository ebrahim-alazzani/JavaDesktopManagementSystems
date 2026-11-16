using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace datawithForm_ElectricitySystem
{
    public partial class Form_Billing_Periods : Form
    {
        public Form_Billing_Periods()
        {
            InitializeComponent();
        }

        private void billing_PeriodsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.billing_PeriodsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.eElectricitySystemDataSet);

        }

        private void Form_Billing_Periods_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'eElectricitySystemDataSet.Billing_Periods' table. You can move, or remove it, as needed.
            this.billing_PeriodsTableAdapter.Fill(this.eElectricitySystemDataSet.Billing_Periods);

        }

        private void is_ClosedLabel_Click(object sender, EventArgs e)
        {

        }
    }
}
