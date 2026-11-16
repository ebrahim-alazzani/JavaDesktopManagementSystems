/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package food;

import java.util.Date;

/**
 *
 * @author AZZ
 */
public class User {
   private int id ;
   private String user_name ;
   private String passwrod;
   private String passwrod1;
   private int state;
   private int role ;
   private Date add_date ;

    public User(int id, String user_name, String passwrod, String passwrod1, int state, int role, Date add_date) {
        this.id = id;
        this.user_name = user_name;
        this.passwrod = passwrod;
        this.passwrod1 = passwrod1;
        this.state = state;
        this.role = role;
        this.add_date = add_date;
    }

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public void setPasswrod1(String passwrod1) {
        this.passwrod1 = passwrod1;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

   
    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public String getPasswrod1() {
        return passwrod1;
    }

    public int getState() {
        return state;
    }

    public int getRole() {
        return role;
    }

    public Date getAdd_date() {
        return add_date;
    }
   
}
