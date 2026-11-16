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
    public partial class Form_Tariffs : Form
    {
        public Form_Tariffs()
        {
            InitializeComponent();
        }

        private void tariffsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.tariffsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.eElectricitySystemDataSet);

        }

        private void Form_Tariffs_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'eElectricitySystemDataSet.Tariffs' table. You can move, or remove it, as needed.
            this.tariffsTableAdapter.Fill(this.eElectricitySystemDataSet.Tariffs);

        }
    }
}
