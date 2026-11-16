/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussnuesLogacl;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ibral
 */
public class ConnectionDB {
     Connection conn = null;
    //The mysql driver 
    static String driverName = "org.apache.derby.jdbc.ClientDriver";
    //Local mysql Server URL
    static String DBURL = "jdbc:derby://localhost:1527/RestaurantDB";

    boolean vcon = false;

    public static Connection ConnectDB() {
        try {

          Class.forName(driverName);
            Connection conn;
            conn = DriverManager.getConnection(DBURL);
            
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
