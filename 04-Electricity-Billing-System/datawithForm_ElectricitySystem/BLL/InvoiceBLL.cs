using System;
using System.Data;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.BLL
{
    public class InvoiceBLL
    {
        private InvoiceDAL invoiceDAL = new InvoiceDAL();
        private MeterReadingDAL readingDAL = new MeterReadingDAL();
        private TariffDAL tariffDAL = new TariffDAL();
        private JournalEntryDAL journalDAL = new JournalEntryDAL();

        /// <summary>
        /// حساب الاستهلاك
        /// </summary>
        public decimal CalculateConsumption(decimal currentReading, decimal previousReading)
        {
            decimal consumption = currentReading - previousReading;
            if (consumption < 0)
                throw new Exception("القراءة الحالية يجب أن تكون أكبر من أو تساوي القراءة السابقة");
            return consumption;
        }

        /// <summary>
        /// حساب مبلغ الفاتورة
        /// </summary>
        public decimal CalculateAmount(decimal consumption, decimal pricePerUnit, decimal fixedFee)
        {
            return (consumption * pricePerUnit) + fixedFee;
        }

        /// <summary>
        /// حساب الإجمالي مع الرصيد السابق
        /// </summary>
        public decimal CalculateTotal(decimal currentAmount, decimal previousBalance)
        {
            return currentAmount + previousBalance;
        }

        /// <summary>
        /// الحصول على آخر قراءة للعداد
        /// </summary>
        public decimal GetLastReading(int meterID)
        {
            return readingDAL.GetLastReading(meterID);
        }

        /// <summary>
        /// إنشاء فاتورة كاملة مع حفظ القراءة ومنع التكرار وإنشاء قيد محاسبي
        /// </summary>
        public int CreateInvoice(int customerID, int meterID, int periodID, int tariffID,
            decimal previousReading, decimal currentReading,
            decimal pricePerUnit, decimal fixedFee, decimal previousBalance)
        {
            // التحقق من عدم وجود فاتورة مسبقة لنفس العداد في نفس الفترة
            if (invoiceDAL.InvoiceExistsForMeterPeriod(meterID, periodID))
                throw new Exception("يوجد فاتورة مسبقة لهذا العداد في هذه الفترة. لا يمكن إنشاء فاتورة مكررة.");

            // حساب الاستهلاك والمبلغ
            decimal consumption = CalculateConsumption(currentReading, previousReading);
            decimal amount = CalculateAmount(consumption, pricePerUnit, fixedFee);

            // حفظ القراءة
            readingDAL.Add(meterID, periodID, currentReading);

            // حفظ الفاتورة
            Invoice inv = new Invoice
            {
                Customer_ID = customerID,
                Meter_ID = meterID,
                Period_ID = periodID,
                Tariff_ID = tariffID,
                Previous_Reading = previousReading,
                Current_Reading = currentReading,
                Current_Amount = amount,
                Previous_Balance = previousBalance
            };

            int invoiceID = invoiceDAL.Add(inv);

            // إنشاء قيد محاسبي تلقائي (ذمم مشتركين مدين - إيرادات الكهرباء دائن)
            if (invoiceID > 0 && amount > 0)
            {
                try
                {
                    JournalEntry je = new JournalEntry
                    {
                        Description = "فاتورة كهرباء رقم " + invoiceID,
                        Total_Debit = amount,
                        Total_Credit = amount
                    };
                    int entryID = journalDAL.AddEntry(je);
                    if (entryID > 0)
                    {
                        // مدين: ذمم المشتركين (حساب 4)
                        journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = 4, Debit = amount, Credit = 0 });
                        // دائن: إيرادات الكهرباء (حساب 3)
                        journalDAL.AddLine(new JournalEntryLine { Entry_ID = entryID, Account_ID = 3, Debit = 0, Credit = amount });
                    }
                }
                catch { } // لا نوقف الفاتورة إذا فشل القيد
            }

            return invoiceID;
        }

        public DataTable GetAllInvoices()
        {
            return invoiceDAL.GetAll();
        }

        public DataTable GetInvoicesByCustomer(int customerID)
        {
            return invoiceDAL.GetByCustomer(customerID);
        }

        public void MarkAsPaid(int invoiceID)
        {
            invoiceDAL.UpdateStatus(invoiceID, true);
        }
    }
}
