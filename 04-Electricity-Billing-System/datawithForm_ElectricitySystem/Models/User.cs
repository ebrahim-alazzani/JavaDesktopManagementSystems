namespace datawithForm_ElectricitySystem.Models
{
    public class User
    {
        public int User_ID { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string FullName { get; set; }
        public int Role_ID { get; set; }
        public string Role_Name { get; set; }
        public bool IsActive { get; set; }
    }

    public class Role
    {
        public int Role_ID { get; set; }
        public string Role_Name { get; set; }
    }

    public class DashboardStats
    {
        public int TotalCustomers { get; set; }
        public int TotalInvoices { get; set; }
        public decimal TotalRevenue { get; set; }
        public decimal TotalDebts { get; set; }
        public decimal TotalPayments { get; set; }
    }
}
