using System;
using System.Data;
using System.Data.SqlClient;

namespace datawithForm_ElectricitySystem.DAL
{
    public class UserDAL
    {
        public DataTable Login(string userName, string password)
        {
            return ConnectionHelper.ExecuteQuery("sp_Login",
                new SqlParameter("@UserName", userName),
                new SqlParameter("@Password", password));
        }

        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllUsers");
        }

        public int Add(string userName, string password, string fullName, int roleID)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddUser",
                new SqlParameter("@UserName", userName),
                new SqlParameter("@Password", password),
                new SqlParameter("@FullName", (object)fullName ?? DBNull.Value),
                new SqlParameter("@Role_ID", roleID));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        /// <summary>
        /// إضافة مستخدم بالدور كنص
        /// </summary>
        public int Add(string userName, string password, string fullName, string roleName)
        {
            int roleID = 3; // موظف افتراضي
            if (roleName == "مدير") roleID = 1;
            else if (roleName == "محاسب") roleID = 2;
            return Add(userName, password, fullName, roleID);
        }
    }

    public class ReportDAL
    {
        public DataTable GetCustomerLedger(int customerID)
        {
            return ConnectionHelper.ExecuteQuery("sp_GetCustomerLedger",
                new SqlParameter("@Customer_ID", customerID));
        }

        public DataTable GetDashboardStats()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetDashboardStats");
        }
    }
}
