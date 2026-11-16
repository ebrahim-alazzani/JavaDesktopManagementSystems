using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class FixedAsset
    {
        public int Asset_ID { get; set; }
        public string Asset_Name { get; set; }
        public string Asset_Type { get; set; }
        public decimal Purchase_Value { get; set; }
        public DateTime Purchase_Date { get; set; }
        public int? Account_ID { get; set; }
    }
}
