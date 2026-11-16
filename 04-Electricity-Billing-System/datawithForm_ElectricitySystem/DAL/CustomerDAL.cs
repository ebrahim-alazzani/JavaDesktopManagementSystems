using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class CustomerDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllCustomers");
        }

        public DataTable GetByID(int customerID)
        {
            return ConnectionHelper.ExecuteQuery("sp_GetCustomerByID",
                new SqlParameter("@Customer_ID", customerID));
        }

        public DataTable Search(string searchText)
        {
            return ConnectionHelper.ExecuteQuery("sp_SearchCustomers",
                new SqlParameter("@SearchText", searchText));
        }

        public int Add(Customer c)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddCustomer",
                new SqlParameter("@Customer_Name", c.Customer_Name),
                new SqlParameter("@Phone", (object)c.Phone ?? DBNull.Value),
                new SqlParameter("@Address", (object)c.Address ?? DBNull.Value),
                new SqlParameter("@Opening_Balance", c.Opening_Balance));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void Update(Customer c)
        {
            ConnectionHelper.ExecuteNonQuery("sp_UpdateCustomer",
                new SqlParameter("@Customer_ID", c.Customer_ID),
                new SqlParameter("@Customer_Name", c.Customer_Name),
                new SqlParameter("@Phone", (object)c.Phone ?? DBNull.Value),
                new SqlParameter("@Address", (object)c.Address ?? DBNull.Value),
                new SqlParameter("@Opening_Balance", c.Opening_Balance),
                new SqlParameter("@Status", c.Status));
        }

        public void Delete(int customerID)
        {
            ConnectionHelper.ExecuteNonQuery("sp_DeleteCustomer",
                new SqlParameter("@Customer_ID", customerID));
        }
    }
}
