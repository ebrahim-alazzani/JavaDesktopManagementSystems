/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safetyroadcompany;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS 
 */
public class DataService {

    Connection con = DBconnect.ConnectDB();
    DefaultTableModel model;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;

 

    public int InsertAdmin(Admin admin) throws SQLException {
        int result = 0;

        PreparedStatement newStock;

        String query = "Insert Into admin(`AdminID`, `AdminName`, `AdminEmail`, `AdminPassword`, `AdminUserName`, `AdminPhoneNumber`, `administatorID`) VALUES (?,?,?,?,?,?,?)";
        newStock = con.prepareStatement(query);
          newStock.setInt(1, admin.getAdminID());
        newStock.setString(2, admin.getAdminName());
        newStock.setString(3, admin.getAdminEmail());
        newStock.setString(4, admin.getAdminPassword());
        newStock.setString(5, admin.getAdminUserName());
        newStock.setString(6, admin.getAdminPhoneNumber());
        newStock.setInt(7, admin.getAdministatorID());

     

        result = newStock.executeUpdate();

        return result;

    }

   

}
