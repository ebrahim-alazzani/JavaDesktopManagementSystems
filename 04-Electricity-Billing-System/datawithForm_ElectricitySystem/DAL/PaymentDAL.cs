using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class PaymentDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllPayments");
        }

        public DataTable GetByCustomer(int customerID)
        {
            return ConnectionHelper.ExecuteQuery("sp_GetPaymentsByCustomer",
                new SqlParameter("@Customer_ID", customerID));
        }

        public int Add(Payment p)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddPayment",
                new SqlParameter("@Customer_ID", p.Customer_ID),
                new SqlParameter("@Invoice_ID", p.Invoice_ID.HasValue ? (object)p.Invoice_ID.Value : DBNull.Value),
                new SqlParameter("@Amount", p.Amount),
                new SqlParameter("@Payment_Method", (object)p.Payment_Method ?? DBNull.Value),
                new SqlParameter("@Reference_No", (object)p.Reference_No ?? DBNull.Value));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        /// <summary>
        /// حساب إجمالي المدفوعات لفاتورة محددة
        /// </summary>
        public decimal GetTotalPaidForInvoice(int invoiceID)
        {
            try
            {
                string sql = "SELECT ISNULL(SUM(Amount), 0) FROM Payments WHERE Invoice_ID = @IID";
                object result = ConnectionHelper.ExecuteScalarText(sql, new SqlParameter("@IID", invoiceID));
                return result != null && result != DBNull.Value ? Convert.ToDecimal(result) : 0;
            }
            catch { return 0; }
        }
    }
}
