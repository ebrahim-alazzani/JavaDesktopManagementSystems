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
public class Staff {

    private int Mng_staffID;
    private int Phone;
    private int Staff_ID;
    private String Password;
    private String UserName;
    private String Fname;
    private String Lname;
    private double Salary;
    private String Shift;
    private String Gender;
    private String Email;
    private Date DateBirth;
 
    private  Staff Mang;

    public Staff getMang() {
        return Mang;
    }

    public void setMang(Staff Mang) {
        this.Mang = Mang;
    }

    public Staff(int Mng_staffID, int Phone, int Staff_ID, String Password, String UserName, String Fname, String Lname, double Salary, String Shift, String Gender, String Email, Date DateBirth, Staff Mang) {
        this.Mng_staffID = Mng_staffID;
        this.Phone = Phone;
        this.Staff_ID = Staff_ID;
        this.Password = Password;
        this.UserName = UserName;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Salary = Salary;
        this.Shift = Shift;
        this.Gender = Gender;
        this.Email = Email;
        this.DateBirth = DateBirth;
        this.Mang = Mang;
    }

    public Staff(int Mng_staffID, int Phone, int Staff_ID, String Password, String UserName, String Fname, String Lname, double Salary, String Shift, String Gender, String Email, Date DateBirth) {
        this.Mng_staffID = Mng_staffID;
        this.Phone = Phone;
        this.Staff_ID = Staff_ID;
        this.Password = Password;
        this.UserName = UserName;
        this.Fname = Fname;
        this.Lname = Lname;
        this.Salary = Salary;
        this.Shift = Shift;
        this.Gender = Gender;
        this.Email = Email;
        this.DateBirth = DateBirth;
    }

    public Staff() {
    }

    public int getMng_staffID() {
        return Mng_staffID;
    }

    public void setMng_staffID(int Mng_staffID) {
        this.Mng_staffID = Mng_staffID;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public int getStaff_ID() {
        return Staff_ID;
    }

    public void setStaff_ID(int Staff_ID) {
        this.Staff_ID = Staff_ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
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

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDateBirth() {
        return DateBirth;
    }

    public void setDateBirth(Date DateBirth) {
        this.DateBirth = DateBirth;
    }

   
}
