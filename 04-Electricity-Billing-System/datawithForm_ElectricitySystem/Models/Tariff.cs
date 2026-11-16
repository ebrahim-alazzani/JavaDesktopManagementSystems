namespace datawithForm_ElectricitySystem.Models
{
    public class Tariff
    {
        public int Tariff_ID { get; set; }
        public string Tariff_Name { get; set; }
        public decimal Price_Per_Unit { get; set; }
        public decimal Fixed_Fee { get; set; }
        public bool Is_Active { get; set; }
    }
}
