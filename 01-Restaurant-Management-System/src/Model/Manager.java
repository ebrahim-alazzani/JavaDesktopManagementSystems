/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ibral
 */
public class Manager extends Users{

    private double Salary;
    private boolean IsSenior;

    public Manager(double Salary, boolean IsSenior) {
        this.Salary = Salary;
        this.IsSenior = IsSenior;
    }

    public Manager(double Salary, boolean IsSenior, int UserId, String UserName, String Password, String Tybe, String Position) {
        super(UserId, UserName, Password, Tybe, Position);
        this.Salary = Salary;
        this.IsSenior = IsSenior;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public boolean isIsSenior() {
        return IsSenior;
    }

    public void setIsSenior(boolean IsSenior) {
        this.IsSenior = IsSenior;
    }
    

   
}
