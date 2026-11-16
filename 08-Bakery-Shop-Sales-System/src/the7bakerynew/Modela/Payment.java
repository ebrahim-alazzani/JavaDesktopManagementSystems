/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Payment extends Order {
    
    private double Amount;

    public Payment(int Order_ID, Customer customer, Date OrderDate, double Total) {
        super(Order_ID, customer, OrderDate, Total);
    }

    public Payment() {
    }

    public Payment(double Amount) {
        this.Amount = Amount;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
}
