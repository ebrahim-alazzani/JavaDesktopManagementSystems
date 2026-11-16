using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class Invoice
    {
        public int Invoice_ID { get; set; }
        public int Customer_ID { get; set; }
        public string Customer_Name { get; set; }
        public int Meter_ID { get; set; }
        public string Meter_No { get; set; }
        public int Period_ID { get; set; }
        public string Period_Name { get; set; }
        public int Tariff_ID { get; set; }
        public string Tariff_Name { get; set; }
        public decimal Previous_Reading { get; set; }
        public decimal Current_Reading { get; set; }
        public decimal Consumption { get; set; }
        public decimal Current_Amount { get; set; }
        public decimal Previous_Balance { get; set; }
        public decimal Total_Balance { get; set; }
        public DateTime Invoice_Date { get; set; }
        public bool Is_Paid { get; set; }
    }
}
