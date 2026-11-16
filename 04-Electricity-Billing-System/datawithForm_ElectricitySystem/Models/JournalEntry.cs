using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class JournalEntry
    {
        public int Entry_ID { get; set; }
        public DateTime Entry_Date { get; set; }
        public string Description { get; set; }
        public decimal Total_Debit { get; set; }
        public decimal Total_Credit { get; set; }
    }

    public class JournalEntryLine
    {
        public int Line_ID { get; set; }
        public int Entry_ID { get; set; }
        public int Account_ID { get; set; }
        public string Account_Name { get; set; }
        public decimal Debit { get; set; }
        public decimal Credit { get; set; }
    }
}
