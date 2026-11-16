using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
namespace datawithForm_ElectricitySystem
{
    class DataBaseConnection
    {
        public SqlConnection SqlConnection;
        public DataBaseConnection()
        {
            SqlConnection = new SqlConnection(@"Server=FNOON\YSEDU;Database=EElectricitySystem;Integrated Security=True;");
        }
        public void open()
        {
            if (SqlConnection.State != ConnectionState.Open)
            {

                SqlConnection.Open();
            }
        }
        public void close() { 
                    if (SqlConnection.State != ConnectionState.Closed)
                    {
                        SqlConnection.Close();


        }
    }
}}