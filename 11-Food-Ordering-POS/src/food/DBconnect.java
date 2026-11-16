/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DBconnect {
     Connection conn=null;
  static  String driverName = "com.mysql.cj.jdbc.Driver";   //The mysql driver 
   static String DBURL = "jdbc:mysql://localhost:3306/"; //Local mysql Server URL
  static  String DB = " footballstadiumdb";                      //Database server
  static  String DBUser = "root";                        //Database server username
  static  String DBPwd = "";                             //Database server password
    boolean vcon = false;
    public static Connection ConnectDB(){       
        try {
            
         
            Class.forName(driverName);         
            Connection conn;
            conn = DriverManager.getConnection(DBURL + DB, DBUser, DBPwd);
            return conn;   
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
} 





