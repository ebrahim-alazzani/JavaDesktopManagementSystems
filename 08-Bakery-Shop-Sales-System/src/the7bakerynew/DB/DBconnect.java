/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DBconnect {

    Connection conn = null;
    //The mysql driver 
    static String driverName = "org.apache.derby.jdbc.ClientDriver";
    //Local mysql Server URL
    static String DBURL = "jdbc:derby://localhost:1527/TheBakerySystemDB";
    //Database server [root on APP]
    static String DB = "thebakerydb";
    //Database server username
    static String DBUser = "root";
    //Database server password
    static String DBPwd = "";
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
