/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author AZZ
 */
public class Employee extends Job{
   
   
    private int id;
    private String frist_name;
    private String last_name;
    private String gander;
        private String ganders;

    private Date hire_date;
    private double sealary;
    private long phone_number;
    private int state;
    public Employee(int id, String frist_name, String last_name, String ganders, Date hire_date, double sealary, long phone_number, int ids,String name) {
        super(id, name);
        this.id = id;
        this.frist_name = frist_name;
        this.last_name = last_name;
        this.ganders = ganders;
        this.hire_date = hire_date;
        this.sealary = sealary;
        this.phone_number = phone_number;
    }

    public Employee(int id, String frist_name, String last_name, String ganders, Date hire_date, double sealary, long phone_number,int idd,int state) {
        this.id = id;
        this.frist_name = frist_name;
        this.last_name = last_name;
        this.ganders = ganders;
        this.hire_date = hire_date;
        this.sealary = sealary;
        this.phone_number = phone_number;
        this.state=state;
    }

    public Employee() {
    }

    public void setFrist_name(String frist_name) {
        this.frist_name = frist_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public void setSealary(double sealary) {
        this.sealary = sealary;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getFrist_name() {
        return frist_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String isGander() {
        return gander;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public double getSealary() {
        return sealary;
    }

    public long getPhone_number() {
        return phone_number;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * @return the ganders
     */
    public String getGanders() {
        return ganders;
    }

    /**
     * @param ganders the ganders to set
     */
    public void setGanders(String ganders) {
        this.ganders = ganders;
    }

    /**
     * @return the id
     */
    public int getIdE() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setIdE(int id) {
        this.id = id;
    }


}