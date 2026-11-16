/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safetyroadcompany;

public class payment {
    
//    variables declaration: 
    
    int AmountOfMoney;
    private String paymentID;
    
//    parameterized constructor:
    
    public payment(int amountOfMoney,String paymentID )
    {
        this.AmountOfMoney=amountOfMoney;
        this.paymentID=paymentID;
    }
    
//    the setter for paymentID:
    
    public void setID(String paymentID)
    {
        this.paymentID=paymentID;
    }
    
//    the getter for paymentID:
    
    public String getID()
    {
        return paymentID;
    }
       
  
}
   

