using System;
using System.Data;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.BLL
{
    public class PaymentBLL
    {
        private PaymentDAL paymentDAL = new PaymentDAL();
        private InvoiceDAL invoiceDAL = new InvoiceDAL();
        private JournalEntryDAL journalDAL = new JournalEntryDAL();

        /// <summary>
        /// تسجيل دفعة جديدة مع قيد محاسبي
        /// </summary>
        public int AddPayment(int customerID, int? invoiceID, decimal amount,
            string paymentMethod, string referenceNo)
        {
            if (amount <= 0)
                throw new Exception("مبلغ الدفع يجب أن يكون أكبر من صفر");

            Payment p = new Payment
            {
                Customer_ID = customerID,
                Invoice_ID = invoiceID,
                Amount = amount,
                Payment_Method = paymentMethod,
                Reference_No = referenceNo
            };

            int paymentID = paymentDAL.Add(p);

            // تحديث حالة الفاتورة إذا تم سداد كامل المبلغ
            if (invoiceID.HasValue && invoiceID.Value > 0)
            {
                decimal totalPaid = invoiceDAL.GetTotalPaidForInvoice(invoiceID.Value);
                DataTable details = invoiceDAL.GetInvoiceDetails(invoiceID.Value);
                if (details.Rows.Count > 0)
                {
                    decimal invoiceTotal = Convert.ToDecimal(details.Rows[0]["Current_Amount"]);
                    if (totalPaid >= invoiceTotal)
                        invoiceDAL.UpdateStatus(invoiceID.Value, true);
                }
            }

            // إنشاء قيد محاسبي تلقائي (الصندوق/البنك مدين - ذمم المشتركين دائن)
            if (paymentID > 0 && amount > 0)
            {
                try
                {
                    int cashAccountID = 1; // الصندوق
                    if (!string.IsNullOrEmpty(paymentMethod) &&
                        (paymentMethod.Contains("بنك") || paymentMethod.Contains("تحويل")))
                        cashAccountID = 2; // البنك

                    JournalEntry je = new JournalEntry
                    {
                        Description = "تحصيل دفعة رقم " + paymentID,
                        Total_Debit = amount,
                        Total_Credit = amount
                    };
                    int entryID = journalDAL.AddEntry(je);
                    if (entryID > 0)
                    {
                        // مدين: الصندوق أو البنك
                        journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = cashAccountID, Debit = amount, Credit = 0 });
                        // دائن: ذمم المشتركين (حساب 4)
                        journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = 4, Debit = 0, Credit = amount });
                    }
                }
                catch { }
            }

            return paymentID;
        }

        public DataTable GetAllPayments()
        {
            return paymentDAL.GetAll();
        }

        public DataTable GetPaymentsByCustomer(int customerID)
        {
            return paymentDAL.GetByCustomer(customerID);
        }
    }
}
