/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ibral
 */
public class Order {
    
    private  int OrderId;
    private  Date OrderDate;
    private double Total;
    private String TypeMothd;

    private Waiter waiter;
    private  DiningTable diningTable;
    private Customers customers;

    public Order() {
    }

    public Order(int OrderId, Date OrderDate, double Total, String TypeMothd, Waiter waiter, DiningTable diningTable, Customers customers) {
        this.OrderId = OrderId;
        this.OrderDate = OrderDate;
        this.Total = Total;
        this.TypeMothd = TypeMothd;
        this.waiter = waiter;
        this.diningTable = diningTable;
        this.customers = customers;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
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

    public String getTypeMothd() {
        return TypeMothd;
    }

    public void setTypeMothd(String TypeMothd) {
        this.TypeMothd = TypeMothd;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public DiningTable getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

   
    
    
}
