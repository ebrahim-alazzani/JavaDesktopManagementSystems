/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.apache.derby.client.am.Decimal;

/**
 *
 * @author ibral
 */
public class Waiter extends Users{
    private String Shift;
    private double Salary;

    public Waiter() {
    }

    public Waiter(String Shift, double Salary) {
        this.Shift = Shift;
        this.Salary = Salary;
    }

    public Waiter(String Shift, double Salary, int UserId, String UserName, String Password, String Tybe, String Position) {
        super(UserId, UserName, Password, Tybe, Position);
        this.Shift = Shift;
        this.Salary = Salary;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String Shift) {
        this.Shift = Shift;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
    
   
}
