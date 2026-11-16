/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussnuesLogacl;

import Model.Customers;
import Model.DiningTable;
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
public class DiningTableBL {
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
    public int InsertDiningTable(DiningTable diningTable) throws SQLException {
        int result = 0;


        String query = "INSERT INTO APP.DiningTable (TableNumber,CodeCharTable,Capacit,Status,WaiterId)  VALUES (?,?,?,?,?)";
        pst = con.prepareStatement(query);
        pst.setInt(1, diningTable.getTableNumber());
        pst.setString(2, diningTable.getCodeCharTable());
        pst.setInt(3, diningTable.getCapacit());
        pst.setInt(4, diningTable.getStatus());

        pst.setInt(5,diningTable.getWaiter().getUserId());
       
        result = pst.executeUpdate();
        return result;

    }
    DiningTable diningTable;
     public ArrayList DiningTableArrayList() {
        ArrayList<DiningTable> diningTables = new ArrayList();
        try {

            String sql = "SELECT * From DiningTable ";
                 
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
               diningTable= new DiningTable(rs.getInt("TableId"),
                         rs.getInt("TableNumber"),
                       rs.getString("CodeCharTable"),
                       rs.getInt("Capacit"),
                       rs.getInt("Status"));
                diningTables.add(diningTable);
            }
           
                        
                        

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return diningTables;
    }

}
