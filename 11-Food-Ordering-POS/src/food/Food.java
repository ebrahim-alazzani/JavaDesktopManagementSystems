/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package food;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Computer
 */
public class Food {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
       
        //sales n = new sales();
        new login().setVisible(true);
       // n.setVisible(true);
    }
}
