using System;
using System.Data;
using System.Data.SqlClient;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.DAL
{
    public class InvoiceDAL
    {
        public DataTable GetAll()
        {
            return ConnectionHelper.ExecuteQuery("sp_GetAllInvoices");
        }

        public DataTable GetByCustomer(int customerID)
        {
            return ConnectionHelper.ExecuteQuery("sp_GetInvoicesByCustomer",
                new SqlParameter("@Customer_ID", customerID));
        }

        public int Add(Invoice inv)
        {
            object result = ConnectionHelper.ExecuteScalar("sp_AddInvoice",
                new SqlParameter("@Customer_ID", inv.Customer_ID),
                new SqlParameter("@Meter_ID", inv.Meter_ID),
                new SqlParameter("@Period_ID", inv.Period_ID),
                new SqlParameter("@Tariff_ID", inv.Tariff_ID),
                new SqlParameter("@Previous_Reading", inv.Previous_Reading),
                new SqlParameter("@Current_Reading", inv.Current_Reading),
                new SqlParameter("@Current_Amount", inv.Current_Amount),
                new SqlParameter("@Previous_Balance", inv.Previous_Balance));
            return result != null ? Convert.ToInt32(result) : 0;
        }

        public void UpdateStatus(int invoiceID, bool isPaid)
        {
            ConnectionHelper.ExecuteNonQuery("sp_UpdateInvoiceStatus",
                new SqlParameter("@Invoice_ID", invoiceID),
                new SqlParameter("@Is_Paid", isPaid));
        }

        /// <summary>
        /// التحقق من وجود فاتورة لنفس العداد في نفس الفترة
        /// </summary>
        public bool InvoiceExistsForMeterPeriod(int meterID, int periodID)
        {
            try
            {
                string sql = "SELECT COUNT(*) FROM Invoices WHERE Meter_ID = @MID AND Period_ID = @PID";
                object result = ConnectionHelper.ExecuteScalarText(sql,
                    new SqlParameter("@MID", meterID),
                    new SqlParameter("@PID", periodID));
                return result != null && Convert.ToInt32(result) > 0;
            }
            catch { return false; }
        }

        /// <summary>
        /// حساب رصيد المشترك المتبقي (إجمالي الفواتير - إجمالي المدفوعات + الرصيد الافتتاحي)
        /// </summary>
        public decimal GetCustomerBalance(int customerID)
        {
            try
            {
                string sql = @"SELECT ISNULL(
                    (SELECT ISNULL(Opening_Balance, 0) FROM Customers WHERE Customer_ID = @CID), 0) +
                    ISNULL((SELECT SUM(Current_Amount) FROM Invoices WHERE Customer_ID = @CID), 0) -
                    ISNULL((SELECT SUM(Amount) FROM Payments WHERE Customer_ID = @CID), 0)";
                object result = ConnectionHelper.ExecuteScalarText(sql, new SqlParameter("@CID", customerID));
                return result != null && result != DBNull.Value ? Convert.ToDecimal(result) : 0;
            }
            catch { return 0; }
        }

        /// <summary>
        /// حساب المبلغ المدفوع لفاتورة محددة
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

        /// <summary>
        /// جلب تفاصيل فاتورة محددة
        /// </summary>
        public DataTable GetInvoiceDetails(int invoiceID)
        {
            try
            {
                string sql = @"SELECT i.*, c.Customer_Name, m.Meter_No 
                    FROM Invoices i 
                    LEFT JOIN Customers c ON i.Customer_ID = c.Customer_ID
                    LEFT JOIN Meters m ON i.Meter_ID = m.Meter_ID
                    WHERE i.Invoice_ID = @IID";
                return ConnectionHelper.ExecuteQueryText(sql, new SqlParameter("@IID", invoiceID));
            }
            catch { return new DataTable(); }
        }

        /// <summary>
        /// جلب الفواتير غير المسددة لمشترك
        /// </summary>
        public DataTable GetUnpaidByCustomer(int customerID)
        {
            try
            {
                string sql = @"SELECT Invoice_ID, 
                    CAST(Invoice_ID AS NVARCHAR) + N' - ' + CAST(Current_Amount AS NVARCHAR) + N' ريال' AS DisplayText,
                    Current_Amount, Previous_Balance
                    FROM Invoices WHERE Customer_ID = @CID AND Is_Paid = 0 ORDER BY Invoice_ID";
                return ConnectionHelper.ExecuteQueryText(sql, new SqlParameter("@CID", customerID));
            }
            catch { return new DataTable(); }
        }
    }
}
