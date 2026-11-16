using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class MeterDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllMeters");
        }

        public DataTable GetByCustomer(int customerID)
        {
            return ConnectionHelper.ExecuteQuery("sp_GetMetersByCustomer",
                new SqlParameter("@Customer_ID", customerID));
        }

        public int Add(Meter m)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddMeter",
                new SqlParameter("@Meter_No", m.Meter_No),
                new SqlParameter("@Customer_ID", m.Customer_ID),
                new SqlParameter("@Installation_Date", m.Installation_Date),
                new SqlParameter("@Location", (object)m.Location ?? DBNull.Value));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void Update(Meter m)
        {
            ConnectionHelper.ExecuteNonQuery("sp_UpdateMeter",
                new SqlParameter("@Meter_ID", m.Meter_ID),
                new SqlParameter("@Meter_No", m.Meter_No),
                new SqlParameter("@Customer_ID", m.Customer_ID),
                new SqlParameter("@Location", (object)m.Location ?? DBNull.Value),
                new SqlParameter("@Status", m.Status));
        }

        public void Delete(int meterID)
        {
            ConnectionHelper.ExecuteNonQuery("sp_DeleteMeter",
                new SqlParameter("@Meter_ID", meterID));
        }
    }
}
