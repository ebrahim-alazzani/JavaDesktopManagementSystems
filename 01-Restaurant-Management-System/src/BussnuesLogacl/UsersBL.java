/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussnuesLogacl;

import Model.Chef;
import Model.Users;
import Model.Waiter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UsersBL {
    Connection con = ConnectionDB.ConnectDB();
    DefaultTableModel model;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;
    
    
    
      public int GetNextValue(String table, String feild) throws SQLException {
        int result = 1;

        Statement st;
        ResultSet rs;

        st = con.createStatement();
        rs = st.executeQuery("SELECT MAX(" + feild + ") FROM " + table + " ");
        while (rs.next()) {
            result = rs.getInt(1);
        }

        return (result + 1);

    }
    public Users getManager(Users users) {

        String userName = users.getUserName();
        String password =users.getPassword();
        

        try {
            if(userName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Login UserName Empty ");

            }
            else if(password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Login password Empty ");

            }
            else{
                String sql = "SELECT * From  USERS WHERE UserName=? and Password=?";
                this.pst = con.prepareStatement(sql);
                this. pst.setString(1, userName);
                this.pst.setString(2, password);
                rs = this.pst.executeQuery();
                if (rs.next()) {
                    users.setUserId(rs.getInt("UserId"));
                    users.setUserName(rs.getString("UserName"));
                    users.setTybe(rs.getString("Type"));

                    return users;

            } else {
                JOptionPane.showMessageDialog(null, "Login kkkk  not Successfully");
                }
            }
           

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Login  not Successfully"+e.getMessage());

        }
        return users;
    }
    public Chef getChef(int userId) {


        Chef c = null;
        try {
            if(userId==0){
                JOptionPane.showMessageDialog(null, "User Id not ");

            }
         
            else{
                String sql = "SELECT c.*,u.* From  USERS u ,Chef c WHERE c.ChefId=u.UserId and u.UserId=?";
                this.pst = con.prepareStatement(sql);
                this. pst.setInt(1, userId);
                rs = this.pst.executeQuery();
                if (rs.next()) {
                    c=new Chef();
                    c.setUserId(rs.getInt("UserId"));
                    c.setUserName(rs.getString("UserName"));
                    c.setTybe(rs.getString("Type"));
                    c.setPosition(rs.getString("Position"));
                    c.setExperience(rs.getInt("Experience"));
                    c.setSpecialization(rs.getString("Specialization"));


                    return c;

            } else {
                JOptionPane.showMessageDialog(null, "Login kkkk  not Successfully");
                }
            }
           

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Login  not Successfully"+e.getMessage());

        }
        return c;
    }
    public Waiter getWaiter(int userId) {


        Waiter w = null;
        try {
            if(userId==0){
                JOptionPane.showMessageDialog(null, "User Id not ");

            }
         
            else{
                String sql = "SELECT w.*,u.* From  USERS u ,Waiter w WHERE w.WaiterId=u.UserId and u.UserId=?";
                this.pst = con.prepareStatement(sql);
                this. pst.setInt(1, userId);
                rs = this.pst.executeQuery();
                if (rs.next()) {
                    w=new Waiter();
                    w.setUserId(rs.getInt("UserId"));
                    w.setUserName(rs.getString("UserName"));
                    w.setTybe(rs.getString("Type"));
                    w.setPosition(rs.getString("Position"));
                    w.setShift(rs.getString("Shift"));
                    w.setSalary(rs.getDouble("Salary"));


                    return w;

            } else {
                JOptionPane.showMessageDialog(null, "Login kkkk  not Successfully");
                }
            }
           

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Login  not Successfully"+e.getMessage());

        }
        return w;
    }

      public int InsertUser(Users user) throws SQLException {
        int result = 0;
        int id = GetNextValue("Users", "UserId");

        String query = "INSERT INTO APP.Users ( UserId,UserName,Password,Type,Position)  VALUES (?,?,?,?,?)";
        pst = con.prepareStatement(query);
       pst.setInt(1, id);

        pst.setString(2, user.getUserName());
        pst.setString(3, user.getPassword());
        pst.setString(4, user.getTybe());
        pst.setString(5, user.getPosition());

        result = pst.executeUpdate();
         if (user instanceof Chef) {
                query = "INSERT INTO Chef (ChefId,Specialization,Experience) VALUES (?,?,?)";
                pst = con.prepareStatement(query);
                pst.setInt(1, id);
                pst.setString(2, ((Chef) user).getSpecialization());
                pst.setInt(3, ((Chef) user).getExperience());

            } else if (user instanceof Waiter) {
                query = "INSERT INTO Waiter (WaiterId,Shift,Salary) VALUES (?,?,?)";
                pst = con.prepareStatement(query);
                pst.setInt(1, id);

                pst.setString(2, ((Waiter) user).getShift());
                pst.setDouble(3, ((Waiter) user).getSalary());

            }

            result = pst.executeUpdate();
        return result;

    }
      
     public ArrayList arryListEmpoleyy(String tybe) throws SQLException {
        Users user;
        ArrayList<Users> userses = new ArrayList();

        String sql = "SELECT * From Users where tybe=?";

        this.pst = con.prepareStatement(sql);
        pst.setString(1,tybe);

        rs = this.pst.executeQuery();
        while (rs.next()) {

            user = new Users();
            user.setUserId(rs.getInt("UserId"));

            user.setUserName(rs.getString("UserName"));
            user.setPosition(rs.getString("Position"));
            
            userses.add(user);
        }

        return userses;
    }
      public ArrayList arryListChef() throws SQLException {
        Chef chef;
        ArrayList<Chef> chefs = new ArrayList();

        String sql = "SELECT u.*,c.* From Users u,Chef c where u.UserId=c.ChefId";

        this.pst = con.prepareStatement(sql);

        rs = this.pst.executeQuery();
        while (rs.next()) {

            chef = new Chef();
            chef.setUserId(rs.getInt("UserId"));

            chef.setUserName(rs.getString("UserName"));
            chef.setPosition(rs.getString("Position"));
            chef.setExperience(rs.getInt("Experience"));
            chef.setSpecialization(rs.getString("Specialization"));
            
            chefs.add(chef);
        }

        return chefs;
    }
      public ArrayList arryListWaiter() throws SQLException {
        Waiter waiter;
        ArrayList<Waiter> waiters = new ArrayList();

        String sql = "SELECT u.*,w.* From Users u,Waiter w where u.UserId=w.WaiterId";

        this.pst = con.prepareStatement(sql);

        rs = this.pst.executeQuery();
        while (rs.next()) {

            waiter = new Waiter();
            waiter.setUserId(rs.getInt("UserId"));

            waiter.setUserName(rs.getString("UserName"));
            waiter.setPosition(rs.getString("Position"));
            waiter.setSalary(rs.getDouble("Salary"));
            waiter.setShift(rs.getString("Shift"));
             
            waiters.add(waiter);
        }

        return waiters;
    }

      public void deleteUserById(int id) {

        try {
            String sql = "DELETE FROM Users WHERE UserId = ?";
            pst = con.prepareCall(sql);
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }

    }

       public void deleteUserByUserName(String UserName,String Type) throws SQLException{

       
            if(getUSerNameExites(UserName,Type)){
                try {
                    String sql = "DELETE FROM Users WHERE UserName = ? and Type=?";
                    pst = con.prepareCall(sql);
                    pst.setString(1, UserName);
                    pst.setString(2, Type);

                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Deleted");
                } catch (SQLException e) {
                   JOptionPane.showMessageDialog(null, "Error ex "+e.getMessage());
               }
               catch (Exception e) {
                   JOptionPane.showMessageDialog(null, " ex "+e.getMessage());
               }
                       }
            else{
                   JOptionPane.showMessageDialog(null, " User Not Found ");

            }
           
    }
       
    public boolean getUSerNameExites(String UserName,String Type) {

        boolean resulet=true;
        try {
        
                String sql = "SELECT * From  USERS WHERE UserName=? and Tybe=?";
                this.pst = con.prepareStatement(sql);
                this. pst.setString(1, UserName);
                this.pst.setString(2, Type);
                rs = this.pst.executeQuery();
                if (rs.next()) {
                  resulet=true;

            } else {
                  resulet=false;
                }
            
           

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Login  not Successfully"+e.getMessage());

        }
        return resulet;
    }




}
