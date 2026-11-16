using System;

namespace datawithForm_ElectricitySystem.Models
{
    public class Customer
    {
        public int Customer_ID { get; set; }
        public string Customer_Name { get; set; }
        public string Phone { get; set; }
        public string Address { get; set; }
        public decimal Opening_Balance { get; set; }
        public bool Status { get; set; }
        public DateTime Created_Date { get; set; }
    }
}
