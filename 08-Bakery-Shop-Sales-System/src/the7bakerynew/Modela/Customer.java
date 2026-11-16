/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Customer {

    private int Customer_ID;
    private String Fname;
    private String Lname;
    private String Email;

    private String Phone_No;
    private String UserName;
    private String CPassword;

    public Customer(int Customer_ID, String Fname, String Lname, String Email, String Phone_No, String UserName, String CPassword) {
        this.Customer_ID = Customer_ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Email = Email;
        this.Phone_No = Phone_No;
        this.UserName = UserName;
        this.CPassword = CPassword;
    }

    public Customer() {
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int Customer_ID) {
        this.Customer_ID = Customer_ID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone_No() {
        return Phone_No;
    }

    public void setPhone_No(String Phone_No) {
        this.Phone_No = Phone_No;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }

}
