using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class BillingPeriod
    {
        public int Period_ID { get; set; }
        public string Period_Name { get; set; }
        public DateTime Start_Date { get; set; }
        public DateTime End_Date { get; set; }
        public bool Is_Closed { get; set; }
    }
}
