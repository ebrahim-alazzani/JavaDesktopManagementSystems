using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class Payment
    {
        public int Payment_ID { get; set; }
        public int Customer_ID { get; set; }
        public string Customer_Name { get; set; }
        public int? Invoice_ID { get; set; }
        public decimal Amount { get; set; }
        public DateTime Payment_Date { get; set; }
        public string Payment_Method { get; set; }
        public string Reference_No { get; set; }
    }
}
