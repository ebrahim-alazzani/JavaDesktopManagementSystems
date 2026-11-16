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
    public partial class Form_Accounts : Form
    {
        public Form_Accounts()
        {
            InitializeComponent();
        }

        private void accountsBindingNavigatorSaveItem_Click(object sender, EventArgs e)
        {
            this.Validate();
            this.accountsBindingSource.EndEdit();
            this.tableAdapterManager.UpdateAll(this.eElectricitySystemDataSet);

        }

        private void Form_Accounts_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'eElectricitySystemDataSet.Accounts' table. You can move, or remove it, as needed.
            this.accountsTableAdapter.Fill(this.eElectricitySystemDataSet.Accounts);

        }

        private void account_IDLabel_Click(object sender, EventArgs e)
        {

        }

        private void account_IDTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void account_NameLabel_Click(object sender, EventArgs e)
        {

        }

        private void account_NameTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void account_TypeLabel_Click(object sender, EventArgs e)
        {

        }

        private void account_TypeTextBox_TextChanged(object sender, EventArgs e)
        {

        }

        private void balance_TypeLabel_Click(object sender, EventArgs e)
        {

        }

        private void balance_TypeTextBox_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
