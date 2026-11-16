/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safetyroadcompany;

/**
 *
 * @author ASUS
 */
public class Cheque extends PayCompletely{

     public  String CustomerName;
    private String ChequeID;
    public Cheque(int amountOfMoney, String paymentID) {
        super(amountOfMoney, paymentID);
    }

    public String getChequeID() {
        return ChequeID;
    }

    public void setChequeID(String ChequeID) {
        this.ChequeID = ChequeID;
    }
    
}
