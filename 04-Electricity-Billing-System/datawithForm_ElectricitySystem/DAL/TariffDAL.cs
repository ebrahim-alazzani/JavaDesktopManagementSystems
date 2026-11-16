using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class TariffDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllTariffs");
        }

        public DataTable GetActive()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetActiveTariffs");
        }

        public int Add(Tariff t)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddTariff",
                new SqlParameter("@Tariff_Name", t.Tariff_Name),
                new SqlParameter("@Price_Per_Unit", t.Price_Per_Unit),
                new SqlParameter("@Fixed_Fee", t.Fixed_Fee));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void Update(Tariff t)
        {
            ConnectionHelper.ExecuteNonQuery("sp_UpdateTariff",
                new SqlParameter("@Tariff_ID", t.Tariff_ID),
                new SqlParameter("@Tariff_Name", t.Tariff_Name),
                new SqlParameter("@Price_Per_Unit", t.Price_Per_Unit),
                new SqlParameter("@Fixed_Fee", t.Fixed_Fee),
                new SqlParameter("@Is_Active", t.Is_Active));
        }

        public void Delete(int tariffID)
        {
            ConnectionHelper.ExecuteNonQuery("sp_DeleteTariff",
                new SqlParameter("@Tariff_ID", tariffID));
        }
    }
}
