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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class DataService {
  Connection con=DBconnect.ConnectDB();
     
     DefaultTableModel model;
     Statement stmt;
    PreparedStatement pst;
    ResultSet rs;
    
    public ArrayList SelectCate() {
        ArrayList<Categ> categorieses = new ArrayList();
        try {

            String sql = "SELECT * FROM categories";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                categorieses.add(new Categ(rs.getInt("CategorieId"),
                        rs.getString("CategorieName")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categorieses;
    }
       public ArrayList Selectemployee() {
         ArrayList<Employee> employees = new ArrayList();
        try {
           
            String sql = "select * from employee";
            this.newStock = con.prepareStatement(sql);
            rs = this.newStock.executeQuery();
            while (rs.next()){
               employees.add( new Employee(rs.getInt("id"), rs.getString("frist_name"), rs.getString("last_name"), rs.getString("gender"),
            (rs.getDate("hire_date")), rs.getDouble("salary"), rs.getLong("phone_number"), rs.getInt("job_id"),rs.getInt("state")));   
            }
           
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        return employees ;
    }

    // Opration User Class
       public ArrayList SelectUser() {
         ArrayList<User> user = new ArrayList();
        try {
           
            String sql = "select * from user";
            this.newStock = con.prepareStatement(sql);
            rs = this.newStock.executeQuery();
            while (rs.next()){
               user.add( new User(rs.getInt("id"), rs.getString("user_name"), rs.getString("password1"), rs.getString("password2"),
                    rs.getInt("state"), rs.getInt("role"), rs.getDate("date")));   
            }
           
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        return user ;
    }

    public int InsertUser(User user) throws SQLException {
               int result=0;
     
                PreparedStatement newStock;
                String sql = "INSERT INTO user (user_name,password1,password2,state,role) VALUES ( ?,?,?,?,?)";
              //  con = con()
                newStock = con.prepareStatement(sql);
                newStock.setString(1, user.getUser_name());
                newStock.setString(2, user.getPasswrod());
                newStock.setString(3, user.getPasswrod1());
                newStock.setInt(4,user.getState());
                newStock.setInt(5, user.getState());    
                result=newStock.executeUpdate();
                return result;
                
 }
     public int UpdayeUser(User user) throws SQLException {
    int result=0;
     
    PreparedStatement newStock;
   String sql = "UPDATE user set user_name = ?, password1 = ?, password2 = ?, state = ?, role = ? where id = ?";

                newStock = con.prepareStatement(sql);
              newStock = con.prepareStatement(sql);
                newStock.setString(1, user.getUser_name());
                newStock.setString(2, user.getPasswrod());
                newStock.setString(3, user.getPasswrod1());
                newStock.setInt(4,user.getState());
                newStock.setInt(5, user.getState());    
                newStock.setInt(6, user.getId());

                result=newStock.executeUpdate();
         
    return result;        
 }
   
public int DeleteCustomer(int id) throws SQLException {
               int result=0;

                PreparedStatement ps;
                ps = con.prepareStatement("delete from user where id = ?");

                ps.setInt(1, id);
            
                result=ps.executeUpdate();
                return result;
                
 }
public void insert( String first_name,  String last_name, double salary, String phone_number, String gender, int job_id) 
    {
      

        try {
    PreparedStatement newStock;

            String sql = "INSERT INTO employee (frist_name,last_name,gender,salary,phone_number,job_id)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            
            
            newStock = con.prepareStatement(sql);
            
           newStock.setString(1,first_name);
           newStock.setString(2,last_name);
           newStock.setString(3,gender);
           newStock.setDouble(4,salary);
           newStock.setString(5,phone_number);
           newStock.setInt(6,job_id);
            
            
           newStock.execute();
            JOptionPane.showMessageDialog(null, "Add Successfuly");
           
            //jobname=" ";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }  
public void update(int id, String first_name,  String last_name, double salary, String phone_number, String gender, int job_id) 
    {  
            try {
                    PreparedStatement newStock;

               // Connection c = con();
                String sql = "UPDATE employee set frist_name = ?,last_name = ?, gender = ?"
                        + ",salary = ?, phone_number = ?, job_id = ? where id = ?";

             
                   newStock = con.prepareStatement(sql);
                   newStock.setString(1,first_name);
                   newStock.setString(2,last_name);
                   newStock.setString(3,gender);
                   newStock.setDouble(4,salary);
                   newStock.setString(5,phone_number);
                   newStock.setInt(6,job_id);
                   newStock.setInt(7, id);

                newStock.execute();
                 JOptionPane.showMessageDialog(null, "Updated");
               // tableemp();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

    }
    
    public void delete(int id){
    
  
            try {
                                    PreparedStatement newStock;

               // Connection c = con();
                String sql = "DELETE FROM employee WHERE id = ?";
                newStock = con.prepareCall(sql);
                newStock.setInt(1, id);
                newStock.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        
}                PreparedStatement newStock;

    
        public int insertitem(Product product) throws SQLException {
               int result=0;
     
               String sql = "INSERT INTO item (name,price,description,state,category_id,quantity,img)values(?,?,?,?,?,?,?)";
              //  con = con()
                newStock = con.prepareStatement(sql);

                newStock = con.prepareStatement(sql);
                newStock.setString(1, product.getName());
                newStock.setDouble(2, product.getPrice());
                newStock.setString(3, product.getDescription());
                newStock.setInt(4, product.getState());
                newStock.setInt(5, product.getCategory_id());

                newStock.setDouble(6, product.getQuantity());
                newStock.setString(7, product.getImg());    
                result=newStock.executeUpdate();
                return result;
                
 }

        public int update_item(Product product,int id) throws SQLException {
               int result=0;
     
                String sql = "UPDATE item set name =?, price =? , description =?,state =? ,category_id=?, quantity =?, img = ? where id=?";
              //  con = con()
                newStock = con.prepareStatement(sql);

                newStock = con.prepareStatement(sql);
                newStock.setString(1, product.getName());
                newStock.setDouble(2, product.getPrice());
                newStock.setString(3, product.getDescription());
                newStock.setInt(4, product.getState());
                newStock.setInt(5, product.getCategory_id());

                newStock.setDouble(6, product.getQuantity());
                newStock.setString(7, product.getImg());  
                newStock.setInt(8, id);    

                result=newStock.executeUpdate();
                return result;
                
 }


        public int inser_category(category c) throws SQLException {
               int result=0;
     
               String sql = "INSERT INTO category (name,state) VALUES(?,?)";
              //  con = con()

                newStock = con.prepareStatement(sql);
                newStock.setString(1, c.getName());
                newStock.setDouble(2, c.getState());

                result=newStock.executeUpdate();
                return result;
                
 }

   public ArrayList Selectjobs() {
         ArrayList<Job> jobs = new ArrayList();
        try {
           
            String sql = "select * from categories";
            this.newStock = con.prepareStatement(sql);
            rs = this.newStock.executeQuery();
            while (rs.next()){
               
               jobs.add( new Job(this.rs.getInt("CategorieId"), this.rs.getNString("CategorieName")));   
            }
           
        } catch (Exception e) {
                System.out.println(e.getMessage());
        }
        return jobs ;
    }

    public void updatejob(String name, int id) {

        try {
           
            String sql = "UPDATE job set name =? where id=?";
            newStock = con.prepareStatement(sql);
            newStock.setString(1, name);
            newStock.setInt(2, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public  void insertjob(String name) {
        try {

           
            String sql = "INSERT INTO job (name) VALUES (?)";
            newStock = con.prepareStatement(sql);
            newStock.setString(1, name);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Added");

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // TODO add your handling code here:
    }

    public   void deletejob(int id) {

        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");

        if (check == 0) {

            try {
             //    Connection c = con();
                String sql = "DELETE FROM job WHERE id =?";
                newStock = con.prepareCall(sql);
                newStock.setInt(1,id);
               newStock.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }

    }
    
    
    
     public  void select_table(JTable tab) {

        DefaultTableModel model = new DefaultTableModel(new String[]{"id ", "name", "capacity", "state"}, 0);

        try {
        //    c = con();
   
            String sql = "select * from tables";
            newStock = con.prepareStatement(sql);
            rs = newStock.executeQuery();
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
            newStock = con.prepareStatement(sql);
            newStock.execute();
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
                newStock = con.prepareStatement(sql);
                newStock.setString(1, name);
                newStock.setInt(2, cap);
                newStock.setInt(3, sta);
                newStock.setInt(4, id);
                //sss.setInt(5, id);
                newStock.execute();
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
                newStock = con.prepareCall(sql);
                newStock.setInt(1,id);
                newStock.execute();
                JOptionPane.showMessageDialog(null, "Deleted");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }
    }

}



