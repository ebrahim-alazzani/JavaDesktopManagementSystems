package food;


import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Computer
 */
public class Connectdb {
  // Connection db = 
   private java.sql.Connection con ;
    Connectdb(){
    try{   
    Class.forName("com.mysql.jdbc.Driver");
          String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasepro22"+unicode, "root", "");
   
}catch(Exception e){
    
}
 }     //  return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8012/database", "root", "");
 
    public  java.sql.Connection openDb(){
        return  con;
    }
    
}
