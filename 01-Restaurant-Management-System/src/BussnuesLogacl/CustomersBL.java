/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussnuesLogacl;

import Model.Customers;
import Model.Foods;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ibral
 */
public class CustomersBL {
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
    public int InsertCustomer(Customers customers) throws SQLException {
        int result = 0;

        String query = "INSERT INTO APP.Customers (customerName,Address,Phone,WaiterId)  VALUES (?,?,?,?)";
        pst = con.prepareStatement(query);
        pst.setString(1, customers.getCustomerName());
        pst.setString(2, customers.getAddress());

        pst.setString(3, customers.getPhone());
        pst.setInt(4,customers.getWaiter().getUserId());
       
        result = pst.executeUpdate();
        return result;

    }
    Customers customers;
     public ArrayList CustomerArrayList() {
        ArrayList<Customers> customerses = new ArrayList();
        try {

            String sql = "SELECT * From Customers ";
                 
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
               customers= new Customers(rs.getInt("CustomerId"),rs.getString("CustomerName"),rs.getString("Address"),
                       rs.getString("Phone"));
                customerses.add(customers);
            }
           
                        
                        

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customerses;
    }

}
