using System;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;

namespace datawithForm_ElectricitySystem.DAL
{
    /// <summary>
    /// كلاس مساعد للاتصال بقاعدة البيانات
    /// </summary>
    public static class ConnectionHelper
    {
        private static string _connectionString;

        public static string ConnectionString
        {
            get
            {
                if (string.IsNullOrEmpty(_connectionString))
                {
                    var cs = ConfigurationManager.ConnectionStrings["EElectricityDB"];
                    _connectionString = cs != null ? cs.ConnectionString
                        : @"data source=DESKTOP-54L3D1N;initial catalog=EElectricitySystem;trustservercertificate=True;integrated security=false;user id=sa;password=abi773256961;";
                }
                return _connectionString;
            }
            set { _connectionString = value; }
        }

        public static SqlConnection GetConnection()
        {
            return new SqlConnection(ConnectionString);
        }

        /// <summary>
        /// تنفيذ استعلام وإرجاع DataTable
        /// </summary>
        public static DataTable ExecuteQuery(string storedProcedure, params SqlParameter[] parameters)
        {
            DataTable dt = new DataTable();
            using (SqlConnection conn = GetConnection())
            {
                using (SqlCommand cmd = new SqlCommand(storedProcedure, conn))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    if (parameters != null)
                        cmd.Parameters.AddRange(parameters);
                    SqlDataAdapter da = new SqlDataAdapter(cmd);
                    da.Fill(dt);
                }
            }
            return dt;
        }

        /// <summary>
        /// تنفيذ أمر وإرجاع عدد الصفوف المتأثرة
        /// </summary>
        public static int ExecuteNonQuery(string storedProcedure, params SqlParameter[] parameters)
        {
            using (SqlConnection conn = GetConnection())
            {
                using (SqlCommand cmd = new SqlCommand(storedProcedure, conn))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    if (parameters != null)
                        cmd.Parameters.AddRange(parameters);
                    conn.Open();
                    return cmd.ExecuteNonQuery();
                }
            }
        }

        /// <summary>
        /// تنفيذ أمر وإرجاع قيمة واحدة (مثل ID جديد)
        /// </summary>
        public static object ExecuteScalar(string storedProcedure, params SqlParameter[] parameters)
        {
            using (SqlConnection conn = GetConnection())
            {
                using (SqlCommand cmd = new SqlCommand(storedProcedure, conn))
                {
                    cmd.CommandType = CommandType.StoredProcedure;
                    if (parameters != null)
                        cmd.Parameters.AddRange(parameters);
                    conn.Open();
                    return cmd.ExecuteScalar();
                }
            }
        }

        /// <summary>
        /// تنفيذ استعلام نصي (ليس Stored Procedure)
        /// </summary>
        public static DataTable ExecuteQueryText(string sql, params SqlParameter[] parameters)
        {
            DataTable dt = new DataTable();
            using (SqlConnection conn = GetConnection())
            {
                using (SqlCommand cmd = new SqlCommand(sql, conn))
                {
                    cmd.CommandType = CommandType.Text;
                    if (parameters != null)
                        cmd.Parameters.AddRange(parameters);
                    SqlDataAdapter da = new SqlDataAdapter(cmd);
                    da.Fill(dt);
                }
            }
            return dt;
        }

        /// <summary>
        /// تنفيذ استعلام نصي وإرجاع قيمة واحدة
        /// </summary>
        public static object ExecuteScalarText(string sql, params SqlParameter[] parameters)
        {
            using (SqlConnection conn = GetConnection())
            {
                using (SqlCommand cmd = new SqlCommand(sql, conn))
                {
                    cmd.CommandType = CommandType.Text;
                    if (parameters != null)
                        cmd.Parameters.AddRange(parameters);
                    conn.Open();
                    return cmd.ExecuteScalar();
                }
            }
        }
    }
}
