using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class FixedAssetDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllAssets");
        }

        public int Add(FixedAsset fa)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddAsset",
                new SqlParameter("@Asset_Name", fa.Asset_Name),
                new SqlParameter("@Asset_Type", (object)fa.Asset_Type ?? DBNull.Value),
                new SqlParameter("@Purchase_Value", fa.Purchase_Value),
                new SqlParameter("@Account_ID", fa.Account_ID.HasValue ? (object)fa.Account_ID.Value : DBNull.Value));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void Update(FixedAsset fa)
        {
            ConnectionHelper.ExecuteNonQuery("sp_UpdateAsset",
                new SqlParameter("@Asset_ID", fa.Asset_ID),
                new SqlParameter("@Asset_Name", fa.Asset_Name),
                new SqlParameter("@Asset_Type", (object)fa.Asset_Type ?? DBNull.Value),
                new SqlParameter("@Purchase_Value", fa.Purchase_Value),
                new SqlParameter("@Account_ID", fa.Account_ID.HasValue ? (object)fa.Account_ID.Value : DBNull.Value));
        }

        public void Delete(int assetID)
        {
            ConnectionHelper.ExecuteNonQuery("sp_DeleteAsset",
                new SqlParameter("@Asset_ID", assetID));
        }
    }
}
