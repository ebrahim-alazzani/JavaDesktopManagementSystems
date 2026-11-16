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
    public partial class Form_Fixed_Assets : Form
    {
        public Form_Fixed_Assets()
        {
            InitializeComponent();
        }

        private void fixed_AssetsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.fixed_AssetsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.eElectricitySystemDataSet);

        }

        private void Form_Fixed_Assets_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'eElectricitySystemDataSet.Fixed_Assets' table. You can move, or remove it, as needed.
            this.fixed_AssetsTableAdapter.Fill(this.eElectricitySystemDataSet.Fixed_Assets);

        }

        private void account_IDLabel_Click(object sender, EventArgs e)
        {

        }

        private void asset_IDLabel_Click(object sender, EventArgs e)
        {

        }

        private void asset_NameLabel_Click(object sender, EventArgs e)
        {

        }
    }
}
