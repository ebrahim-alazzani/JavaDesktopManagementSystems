using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class AccountDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllAccounts");
        }

        public int Add(Account a)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddAccount",
                new SqlParameter("@Account_Name", a.Account_Name),
                new SqlParameter("@Account_Type", a.Account_Type),
                new SqlParameter("@Balance_Type", a.Balance_Type));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void Update(Account a)
        {
            ConnectionHelper.ExecuteNonQuery("sp_UpdateAccount",
                new SqlParameter("@Account_ID", a.Account_ID),
                new SqlParameter("@Account_Name", a.Account_Name),
                new SqlParameter("@Account_Type", a.Account_Type),
                new SqlParameter("@Balance_Type", a.Balance_Type));
        }

        public void Delete(int accountID)
        {
            ConnectionHelper.ExecuteNonQuery("sp_DeleteAccount",
                new SqlParameter("@Account_ID", accountID));
        }
    }
}
