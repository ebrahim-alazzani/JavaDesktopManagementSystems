/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safetyroadcompany;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class CreditCard extends PayCompletely {

    private int CardNumber;
    private Date expireDate;
    private int CVC;
    private String type;

    public CreditCard(int amountOfMoney, String paymentID) {
        super(amountOfMoney, paymentID);
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int CardNumber) {
        this.CardNumber = CardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public int getCVC() {
        return CVC;
    }

    public void setCVC(int CVC) {
        this.CVC = CVC;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
