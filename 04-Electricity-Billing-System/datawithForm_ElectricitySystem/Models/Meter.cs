using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class Meter
    {
        public int Meter_ID { get; set; }
        public string Meter_No { get; set; }
        public int Customer_ID { get; set; }
        public string Customer_Name { get; set; }
        public DateTime Installation_Date { get; set; }
        public bool Status { get; set; }
        public string Location { get; set; }
    }
}
