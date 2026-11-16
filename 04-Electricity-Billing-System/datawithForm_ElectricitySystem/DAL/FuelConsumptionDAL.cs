using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class FuelConsumptionDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllFuelConsumption");
        }

        public int Add(FuelConsumption fc)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddFuelConsumption",
                new SqlParameter("@Asset_ID", fc.Asset_ID),
                new SqlParameter("@Transaction_Type", (object)fc.Transaction_Type ?? "Consumption"),
                new SqlParameter("@Quantity_Used", fc.Quantity_Used),
                new SqlParameter("@Cost", fc.Cost));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void Delete(int logID)
        {
            ConnectionHelper.ExecuteNonQuery("sp_DeleteFuelConsumption",
                new SqlParameter("@Log_ID", logID));
        }
    }
}
