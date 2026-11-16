/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import static product.Product.con;

/**
 *
 * @author AZZ
 */
public class TableRest {
     Connection con = new Connectdb().openDb();

    //public static Connection c;
    public  PreparedStatement sss = null;
    public  ResultSet rs = null;
    private int id;
    private String name;
    private int capacity;

    public TableRest() {

    }
    public TableRest(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setStare(boolean stare) {
        this.stare = stare;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isStare() {
        return stare;
    }
    private boolean stare;
    
    public String toString(){
      return name +" cap " + capacity;  
    }

    public  void select_table(JTable tab) {

        DefaultTableModel model = new DefaultTableModel(new String[]{"id ", "name", "capacity", "state"}, 0);

        try {
        //    c = con();
   
            String sql = "select * from tables";
            sss = con.prepareStatement(sql);
            rs = sss.executeQuery();
            while (rs.next()) {
                /// System.out.println(rs.getString("name") + "");
                model.addRow(new Object[]{rs.getString("id"), rs.getString("name"), rs.getString("capacity"), rs.getString("state")});

            }
            tab.setModel(model);
        } catch (Exception e) {
            System.out.println("// select"+e.getMessage());
        }

    }

    /**
     *
     */
    public void inserttable(String name, int ca, int s) {

        try {
           // Connection con = new Connectdb().openDb();
          //  c = con();

            String sql = "INSERT INTO tables (name,capacity,state) VALUES ('" + name + "','" + ca + "','" + s + "')";
            sss = con.prepareStatement(sql);
            sss.execute();
            JOptionPane.showMessageDialog(null, "Add table sucessfuly");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // TODO add your handling code here:

    }

    public void updatetables(int  id, String name, int cap, int sta) {

        if (name != null) {
            try {
              //  Connection c = con();
                String sql = "update tables set name=?,capacity=?,state=? WHERE id=? ";
                sss = con.prepareStatement(sql);
                sss.setString(1, name);
                sss.setInt(2, cap);
                sss.setInt(3, sta);
                sss.setInt(4, id);
                //sss.setInt(5, id);
                sss.execute();
                JOptionPane.showMessageDialog(null, "Updated sucessfuly");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Empty Filed not accept plase: fill it");
        }
    }

    public void deletetables(int id) {

        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");

        if (check == 0) {

            try {
               // Connection c = con();
                String sql = "DELETE FROM tables WHERE id =?";
                sss = con.prepareCall(sql);
                sss.setInt(1,id);
                sss.execute();
                JOptionPane.showMessageDialog(null, "Deleted");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }
    }

}
