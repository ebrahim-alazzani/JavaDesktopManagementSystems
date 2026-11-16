using System;
using System.Data;
using System.Data.SqlClient;

namespace datawithForm_ElectricitySystem.DAL
{
    public class MeterReadingDAL
    {
        public DataTable GetByMeter(int meterID)
        {
            return ConnectionHelper.ExecuteQuery("sp_GetReadingsByMeter",
                new SqlParameter("@Meter_ID", meterID));
        }

        public decimal GetLastReading(int meterID)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_GetLastReading",
                new SqlParameter("@Meter_ID", meterID));
            return result != null && result != DBNull.Value ? Convert.ToDecimal(result) : 0;
        }

        public int Add(int meterID, int periodID, decimal readingValue, int? readerUserID = null)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddMeterReading",
                new SqlParameter("@Meter_ID", meterID),
                new SqlParameter("@Period_ID", periodID),
                new SqlParameter("@Reading_Value", readingValue),
                new SqlParameter("@Reader_User_ID", readerUserID.HasValue ? (object)readerUserID.Value : DBNull.Value));
            return result != null ? Convert.ToInt32(result) : 0;
        }
    }
}
