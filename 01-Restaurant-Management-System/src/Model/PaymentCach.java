/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import javax.xml.crypto.Data;
import org.apache.derby.client.am.Decimal;

/**
 *
 * @author ibral
 */
public class PaymentCach extends Order{
      private Date PaymentDate;
      private double Amount;

    public PaymentCach() {
    }

    public PaymentCach(Date PaymentDate, double Amount) {
        this.PaymentDate = PaymentDate;
        this.Amount = Amount;
    }

    public Date getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(Date PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

 
   
}
