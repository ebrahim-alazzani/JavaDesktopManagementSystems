using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class FuelConsumption
    {
        public int Log_ID { get; set; }
        public int Asset_ID { get; set; }
        public string Asset_Name { get; set; }
        public string Transaction_Type { get; set; }
        public decimal Quantity_Used { get; set; }
        public decimal Cost { get; set; }
        public DateTime Log_Date { get; set; }
    }
}
