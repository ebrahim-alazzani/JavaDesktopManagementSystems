/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;
import java.sql.Date;

/**
 *CREATE TABLE Orders(
Order_ID INT NOT NULL primary key,
Customer_ID INT NOT NULL,
Order_Date Date NOT NULL,
Total DOUBLE NOT NULL,
FOREIGN KEY (Customer_ID)REFERENCES Customer (Customer_ID)

);
 * @author ASUS
 */
public class Order {
  private int Order_ID;
  private Customer customer;
  private Date  OrderDate;
  private double Total	;

    public Order(int Order_ID, Customer customer, Date OrderDate, double Total) {
        this.Order_ID = Order_ID;
        this.customer = customer;
        this.OrderDate = OrderDate;
        this.Total = Total;
    }

    public Order() {
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int Order_ID) {
        this.Order_ID = Order_ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
  
  

}
