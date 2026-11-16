using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class BillingPeriodDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllBillingPeriods");
        }

        public DataTable GetOpen()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetOpenBillingPeriods");
        }

        public int Add(BillingPeriod bp)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddBillingPeriod",
                new SqlParameter("@Period_Name", bp.Period_Name),
                new SqlParameter("@Start_Date", bp.Start_Date),
                new SqlParameter("@End_Date", bp.End_Date));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void Update(BillingPeriod bp)
        {
            ConnectionHelper.ExecuteNonQuery("sp_UpdateBillingPeriod",
                new SqlParameter("@Period_ID", bp.Period_ID),
                new SqlParameter("@Period_Name", bp.Period_Name),
                new SqlParameter("@Start_Date", bp.Start_Date),
                new SqlParameter("@End_Date", bp.End_Date),
                new SqlParameter("@Is_Closed", bp.Is_Closed));
        }

        public void Delete(int periodID)
        {
            ConnectionHelper.ExecuteNonQuery("sp_DeleteBillingPeriod",
                new SqlParameter("@Period_ID", periodID));
        }
    }
}
