using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class MeterReading
    {
        public int Reading_ID { get; set; }
        public int Meter_ID { get; set; }
        public int Period_ID { get; set; }
        public string Period_Name { get; set; }
        public decimal Reading_Value { get; set; }
        public DateTime Reading_Date { get; set; }
        public int? Reader_User_ID { get; set; }
    }
}
