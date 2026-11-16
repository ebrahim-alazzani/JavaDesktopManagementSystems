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
    public partial class Form_Fuel_Consumption : Form
    {
        public Form_Fuel_Consumption()
        {
            InitializeComponent();
        }

        private void fuel_ConsumptionBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.fuel_ConsumptionBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.eElectricitySystemDataSet);

        }

        private void Form_Fuel_Consumption_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'eElectricitySystemDataSet.Fuel_Consumption' table. You can move, or remove it, as needed.
            this.fuel_ConsumptionTableAdapter.Fill(this.eElectricitySystemDataSet.Fuel_Consumption);

        }

        private void asset_IDLabel_Click(object sender, EventArgs e)
        {

        }

        private void log_IDLabel_Click(object sender, EventArgs e)
        {

        }

        private void log_DateLabel_Click(object sender, EventArgs e)
        {

        }
    }
}
