using System;
using System.Data;
using datawithForm_ElectricitySystem.DAL;
using datawithForm_ElectricitySystem.Models;

namespace datawithForm_ElectricitySystem.BLL
{
    public class JournalEntryBLL
    {
        private JournalEntryDAL journalDAL = new JournalEntryDAL();

        /// <summary>
        /// إنشاء قيد محاسبي مع التحقق من التوازن
        /// </summary>
        public int CreateEntry(string description, DataTable lines)
        {
            decimal totalDebit = 0;
            decimal totalCredit = 0;

            foreach (DataRow row in lines.Rows)
            {
                totalDebit += Convert.ToDecimal(row["Debit"]);
                totalCredit += Convert.ToDecimal(row["Credit"]);
            }

            if (totalDebit != totalCredit)
                throw new Exception("مجموع المدين يجب أن يساوي مجموع الدائن");

            JournalEntry je = new JournalEntry
            {
                Description = description,
                Total_Debit = totalDebit,
                Total_Credit = totalCredit
            };

            int entryID = journalDAL.AddEntry(je);

            // حفظ خطوط القيد
            foreach (DataRow row in lines.Rows)
            {
                JournalEntryLine line = new JournalEntryLine
                {
                    Entry_ID = entryID,
                    Account_ID = Convert.ToInt32(row["Account_ID"]),
                    Debit = Convert.ToDecimal(row["Debit"]),
                    Credit = Convert.ToDecimal(row["Credit"])
                };
                journalDAL.AddLine(line);
            }

            return entryID;
        }

        public DataTable GetAllEntries()
        {
            return journalDAL.GetAll();
        }

        public DataTable GetEntryLines(int entryID)
        {
            return journalDAL.GetLines(entryID);
        }
    }
}
