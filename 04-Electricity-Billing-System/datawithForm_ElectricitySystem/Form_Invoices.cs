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
    public partial class Form_Invoices : Form
    {
        public Form_Invoices()
        {
            InitializeComponent();
        }

        private void invoicesBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.invoicesBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.eElectricitySystemDataSet);

        }

        private void Form_Invoices_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'eElectricitySystemDataSet.Invoices' table. You can move, or remove it, as needed.
            this.invoicesTableAdapter.Fill(this.eElectricitySystemDataSet.Invoices);

        }

        private void manual_Invoice_NoLabel_Click(object sender, EventArgs e)
        {

        }

        private void customer_IDLabel_Click(object sender, EventArgs e)
        {

        }

        private void is_PaidLabel_Click(object sender, EventArgs e)
        {

        }
    }
}
