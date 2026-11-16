/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import DB.DBconnect;
import Modela.Cake;
import Modela.Categories;
import Modela.Cold_Drinks;
import Modela.Customer;
import Modela.Hot_Drinks;
import Modela.Items;
import Modela.Order;
import Modela.Order_Info;
import Modela.Payment;
import Modela.Sandwich;
import Modela.Staff;

import java.sql.Connection;
import java.sql.Date;
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

    public Customer getUser(Customer customer) {

        String email = customer.getUserName();
        String password = customer.getCPassword();

        try {

            String sql = "SELECT * From Customer  WHERE UserName=? and CPassword=?";

            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {

//                JOptionPane.showMessageDialog(null, "Login Successfully" + "  " + preson.getUserName());
                customer.setCustomer_ID(rs.getInt("Customer_ID"));

                customer.setUserName(rs.getString("UserName"));
                customer.setFname(rs.getString("Fname"));
                customer.setLname(rs.getString("Lname"));
                customer.setPhone_No(rs.getString("Phone_No"));
                customer.setEmail(rs.getString("Email"));

                return customer;

            } else {
                JOptionPane.showMessageDialog(null, "Login  not Successfully");
                /*if(Integer.valueOf(username.getText()) == 774145082 && Integer.valueOf(password.getText()) == 4321 )
          {
              new create_account_users().setVisible(true);
              this.dispose();
          }*/
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Logi" + e.getMessage());

        }
        return customer;
    }

    public Staff getAdmin(Staff admin) {

        String email = admin.getUserName();
        String password = admin.getPassword();

        try {

            String sql = "SELECT * From Staff  WHERE UserName=? and Password=?";

            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {

                admin.setStaff_ID(rs.getInt("Staff_ID"));

                admin.setUserName(rs.getString("Useramne"));
                admin.setFname(rs.getString("Fname"));
                admin.setLname(rs.getString("Lname"));
                admin.setEmail(rs.getString("EMAIL"));
                admin.setPhone(rs.getInt("Phone"));

                admin.setPassword(rs.getString("Password"));
                admin.setShift(rs.getString("Shift"));
                admin.setGender(rs.getString("Genader"));
                admin.setSalary(rs.getDouble("Salary"));
                admin.setDateBirth(rs.getDate("DayOfBirth"));

                return admin;

            } else {
                JOptionPane.showMessageDialog(null, "Login  not Successfully");
                /*if(Integer.valueOf(username.getText()) == 774145082 && Integer.valueOf(password.getText()) == 4321 )
          {
              new create_account_users().setVisible(true);
              this.dispose();
          }*/
            }

        } catch (Exception e) {

        }
        return admin;
    }

    public int InsertCustomer(Customer Customer) throws SQLException {
        int result = 0;

        PreparedStatement newStock;

        int id = GetNextValue("Customer", "Customer_ID");
        String query = " INSERT INTO Customer(Customer_ID,Email,Fname, Lname, Phone_No, UserName, CPassword) VALUES (?,?,?,?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);
        newStock.setString(2, Customer.getEmail());
        newStock.setString(3, Customer.getFname());
        newStock.setString(4, Customer.getLname());
        newStock.setString(5, Customer.getPhone_No());
        newStock.setString(6, Customer.getUserName());
        newStock.setString(7, Customer.getCPassword());

        result = newStock.executeUpdate();

        return result;

    }

    public int InsertStaff(Staff staff) throws SQLException {
        int result = 0;

        PreparedStatement newStock;

        int id = GetNextValue("Staff", "Staff_ID");
        String query = " INSERT INTO Staff(Staff_ID,Email,Fname, Lname, Phone, Username, Password,Salary,Shift,Gender,DateBirth)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);
        newStock.setString(2, staff.getEmail());
        newStock.setString(3, staff.getFname());
        newStock.setString(4, staff.getLname());
        newStock.setInt(5, staff.getPhone());
        newStock.setString(6, staff.getUserName());
        newStock.setString(7, staff.getPassword());
        newStock.setDouble(8, staff.getSalary());
        newStock.setString(9, staff.getShift());
        newStock.setString(10, staff.getGender());
        newStock.setDate(11, staff.getDateBirth());

        result = newStock.executeUpdate();

        return result;

    }

    public void updateStaff(int id, Staff staff) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE Staff set Email=?,Fname=?, Lname=?, Phone=?, Username=?,"
                    + " Password=?,Salary=?,Shift=?,Gender=?,DateBirth=?"
                    + " WHERE Staff_ID = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, staff.getEmail());
            newStock.setString(2, staff.getFname());
            newStock.setString(3, staff.getLname());
            newStock.setInt(4, staff.getPhone());
            newStock.setString(5, staff.getUserName());
            newStock.setString(6, staff.getPassword());
            newStock.setDouble(7, staff.getSalary());
            newStock.setString(8, staff.getShift());
            newStock.setString(9, staff.getGender());
            newStock.setDate(10, staff.getDateBirth());

            newStock.setInt(11, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public ArrayList getUserAll() throws SQLException {
        Customer customer;
        ArrayList<Customer> customers = new ArrayList();

        String sql = "SELECT * From Customer";

        this.pst = con.prepareStatement(sql);
        rs = this.pst.executeQuery();
        while (rs.next()) {

            customer = new Customer();
            customer.setCustomer_ID(rs.getInt("Customer_ID"));

            customer.setUserName(rs.getString("UserName"));
            customer.setFname(rs.getString("Fname"));
            customer.setLname(rs.getString("Lname"));
            customer.setPhone_No(rs.getString("Phone_No"));
            customers.add(customer);
        }

        return customers;
    }

    public ArrayList getStaffAll() throws SQLException {
        Staff staff;
        ArrayList<Staff> staffs = new ArrayList();

        String sql = "SELECT * From Staff";

        this.pst = con.prepareStatement(sql);
        rs = this.pst.executeQuery();
        while (rs.next()) {

            staff = new Staff();
            staff.setStaff_ID(rs.getInt("Staff_ID"));

            staff.setUserName(rs.getString("UserName"));
            staff.setFname(rs.getString("Fname"));
            staff.setLname(rs.getString("Lname"));
            staff.setPhone(rs.getInt("Phone"));
            staff.setGender(rs.getString("Gender"));
            staff.setDateBirth(rs.getDate("DateBirth"));
            staff.setSalary(rs.getDouble("Salary"));
            staff.setShift(rs.getString("Shift"));
            staffs.add(staff);
        }

        return staffs;
    }

    //Stadiums Sql
    public int InsertItem(Items items) throws SQLException {
        int result = 0;
        int id = GetNextValue("ITEMS", "ITEM_ID");
        PreparedStatement newStock;

        String query = "INSERT INTO APP.ITEMS (ITEM_ID, NAME,CATEGORIE_ID, PRICE,ITEMIMG)  VALUES (?,?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);

        newStock.setString(2, items.getName());
        newStock.setInt(3, items.getCategories().getCategorieId());

        newStock.setDouble(4, items.getPrice());
        newStock.setString(5, items.getItemImg());

        result = newStock.executeUpdate();

        return result;

    }

    public ArrayList SelectItems() {
        ArrayList<Items> itemses = new ArrayList();
        try {

            String sql = "SELECT i.ITEM_ID,i.\"NAME\",i.PRICE,i.ITEMIMG,c.CATEGORIE_ID,c.CATEGORIE_NAME \n"
                    + "FROM ITEMS i,categories c\n"
                    + "\n"
                    + "where i.CATEGORIE_ID=c.CATEGORIE_ID";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories(rs.getInt("CATEGORIE_ID"), rs.getString("CATEGORIE_NAME"));
                itemses.add(new Items(rs.getInt("ITEM_ID"),
                        rs.getString("NAME"), rs.getDouble("PRICE"),
                        5, categories, rs.getString("ITEMIMG"),0));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemses;
    }

    public ArrayList SelectItems(int categorieId) {
        ArrayList<Items> itemses = new ArrayList();
        try {

            String sql = "SELECT i.ITEM_ID,i.\"NAME\",i.PRICE,i.ITEMIMG,c.CATEGORIE_ID,c.CATEGORIE_NAME \n"
                    + "FROM ITEMS i,categories c\n"
                    + "\n"
                    + "where i.CATEGORIE_ID=c.CATEGORIE_ID and c.CATEGORIE_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, categorieId);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories(rs.getInt("CATEGORIE_ID"), rs.getString("CATEGORIE_NAME"));
                itemses.add(new Items(rs.getInt("ITEM_ID"),
                        rs.getString("NAME"), rs.getDouble("PRICE"),
                        5, categories, rs.getString("ITEMIMG"),0));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemses;
    }

    public void updateItems(int id, Items items) {
        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "UPDATE ITEMS set NAME=?, PRICE=?, CATEGORIE_ID =?,ITEMIMG=?"
                    + " WHERE ITEM_ID = ?";

            newStock = con.prepareStatement(sql);
            newStock.setString(1, items.getName());
            newStock.setDouble(2, items.getPrice());
            newStock.setInt(3, items.getCategories().getCategorieId());
            newStock.setString(4, items.getItemImg());

            newStock.setInt(5, id);

            newStock.execute();
            JOptionPane.showMessageDialog(null, "Updated");
            // tableemp();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deleteStadiums(int id) {

        try {
            PreparedStatement newStock;

            // Connection c = con();
            String sql = "DELETE FROM ITEMS WHERE ITEM_ID = ?";
            newStock = con.prepareCall(sql);
            newStock.setInt(1, id);
            newStock.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public ArrayList SelectCategories() {
        ArrayList<Categories> categorieses = new ArrayList();
        try {

            String sql = "SELECT * FROM categories";
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                categorieses.add(new Categories(rs.getInt("Categorie_ID"),
                        rs.getString("Categorie_Name")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return categorieses;
    }

    public int InsertOrders(Order order) throws SQLException {
        int result = 0;
        int id = GetNextValue("Orders", "Order_ID");

        PreparedStatement newStock;

        String query = "INSERT INTO APP.Orders (Order_ID, Customer_ID,Order_Date,Total)  VALUES (?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);

        newStock.setInt(2, order.getCustomer().getCustomer_ID());
        newStock.setDate(3, order.getOrderDate());

        newStock.setDouble(4, order.getTotal());

        result = newStock.executeUpdate();

        return result;

    }

    public int InsertPayment(Payment payment) throws SQLException {
        int result = 0;
        int id = GetNextValue("Orders", "Order_ID");

        PreparedStatement newStock;

        String query = "INSERT INTO APP.Payment (Payment_ID, Amount)  VALUES (?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, payment.getOrder_ID());

        newStock.setDouble(2, payment.getAmount());

        result = newStock.executeUpdate();

        return result;

    }

    public Payment SelectPayment(int orderId) {
                    Payment payment = new Payment();

        try {
            String sql = "SELECT * FROM Payment where Payment_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);

            rs = this.pst.executeQuery();
            if (rs.next()) {

                payment.setOrder_ID(rs.getInt("Payment_ID"));

                payment.setAmount(rs.getDouble("Amount"));

                return payment;

            } else {
            }

        } catch (Exception e) {

        }
        return payment;
    }

    public ArrayList SelectOrder() {
        ArrayList<Order> orders = new ArrayList();
        try {

            String sql = "SELECT * FROM Orders";

            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_ID(rs.getInt("Customer_ID"));
                orders.add(new Order(rs.getInt("Order_ID"), customer,
                        rs.getDate("Order_Date"), rs.getDouble("Total")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    public int InsertItemOrder(Order_Info item) throws SQLException {
        int result = 0;
        int id = GetNextValue("Order_Info", "Order_Info_ID");

        PreparedStatement newStock;

        String query = "INSERT INTO Order_Info (Order_Info_ID,Order_ID,Item_ID,Quantity,Item_price) VALUES (?,?,?,?,?)";
        newStock = con.prepareStatement(query);
        newStock.setInt(1, id);
        newStock.setInt(2, item.getOrder().getOrder_ID());
        newStock.setInt(3, item.getItems().getItem_ID());
        newStock.setDouble(4, item.getQuantity());
        newStock.setDouble(5, item.getItem_price());
        result = newStock.executeUpdate();

        if (result == 1) {
            double price = SelectOrderTotalSum(item.getOrder().getOrder_ID());
            String sql = "UPDATE Orders set Total=?"
                    + " WHERE Order_ID = ?";

            newStock = con.prepareStatement(sql);
            newStock.setDouble(1, price);
            newStock.setInt(2, item.getOrder().getOrder_ID());

            newStock.execute();
            if (item instanceof Cake) {
                query = "INSERT INTO Cake (Cake_ID,Size,Layer,Frosting,Flavor) VALUES (?,?,?,?,?)";
                newStock = con.prepareStatement(query);
                newStock.setInt(1, id);
                newStock.setString(2, ((Cake) item).Size);
                newStock.setInt(3, ((Cake) item).Layer);
                newStock.setString(4, ((Cake) item).Frosting);
                newStock.setString(5, ((Cake) item).Flavor);

            } else if (item instanceof Sandwich) {
                query = "INSERT INTO Sandwich (Sandwich_ID,Spicy,BreadType,ProteinType) VALUES (?,?,?,?)";
                newStock = con.prepareStatement(query);
                newStock.setInt(1, id);

                newStock.setBoolean(2, ((Sandwich) item).Spicy);
                newStock.setString(3, ((Sandwich) item).BreadType);
                newStock.setString(4, ((Sandwich) item).ProteinType);

            } else if (item instanceof Hot_Drinks) {
                query = "INSERT INTO HOT_DRINKS (H_ID,AddSugar,Size,ExtraHot,MilkType) VALUES (?,?,?,?,?)";
                newStock = con.prepareStatement(query);
                newStock.setInt(1, id);
                newStock.setBoolean(2, ((Hot_Drinks) item).AddSugar);
                newStock.setString(3, ((Hot_Drinks) item).Size);
                newStock.setBoolean(4, ((Hot_Drinks) item).ExtraHot);
                newStock.setString(5, ((Hot_Drinks) item).MilkType);

            } else if (item instanceof Cold_Drinks) {
                query = "INSERT INTO Cold_Drinks (C_ID,AddSugar,Size,MilkType,Ice_Shaped) VALUES (?,?,?,?,?)";
                newStock = con.prepareStatement(query);
                newStock.setInt(1, id);
                newStock.setBoolean(2, ((Cold_Drinks) item).AddSugar);
                newStock.setString(3, ((Cold_Drinks) item).Size);
                newStock.setString(4, ((Cold_Drinks) item).MalikType);
                newStock.setString(5, ((Cold_Drinks) item).Ice_Shaped);
            }

            result = newStock.executeUpdate();

        }
        return result;

    }

    public double SelectOrderTotalSum(int orderID) {

        double sumPrice = 0;
        try {

            String sql = "SELECT Sum(o.Item_Price) as Total From Order_Info o,Items i where   i.Item_ID=o.Item_ID and  o.Order_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, orderID);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                sumPrice = rs.getDouble("Total");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sumPrice;
    }

    public ArrayList SelectOrderItems(int orderID) {
        ArrayList<Order_Info> order_Infos = new ArrayList();
        try {

            String sql = "SELECT o.*,i.* From Order_Info o,Items i where   i.Item_ID=o.Item_ID and  o.Order_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, orderID);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories();

                Order order = new Order();
               Items items = new Items(rs.getInt("ITEM_ID"),
                        rs.getString("NAME"), rs.getDouble("PRICE"),
                        5, categories, rs.getString("ITEMIMG"),rs.getInt("Calories"));
                order_Infos.add(new Order_Info(rs.getInt("Order_Info_ID"), order, items,
                        rs.getInt("Quantity"), rs.getDouble("Item_price")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return order_Infos;
    }

    public ArrayList SelectOrderCake(int orderID) {
        ArrayList<Cake> cakes = new ArrayList();
        try {

            String sql = "SELECT o.*,c.*,i.* From Order_Info o,Cake c,Items i where c.Cake_ID=o.Order_Info_ID and i.Item_ID=o.Item_ID and  o.Order_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, orderID);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories();

                Order order = new Order();
                Items items = new Items(rs.getInt("ITEM_ID"),
                        rs.getString("NAME"), rs.getDouble("PRICE"),
                        5, categories, rs.getString("ITEMIMG"),rs.getInt("Calories"));
                cakes.add(new Cake(rs.getString("Size"),
                        rs.getInt("Layer"), rs.getString("Frosting"), rs.getString("Flavor"), rs.getInt("Order_Info_ID"), order, items,
                        rs.getInt("Quantity"), rs.getDouble("Item_price")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cakes;
    }

    public ArrayList SelectOrderCold_Drinkse(int orderID) {
        ArrayList<Cold_Drinks> drinkses = new ArrayList();
        try {

            String sql = "SELECT o.*,c.*,i.* From Order_Info o,Cold_Drinks c,Items i where c.C_ID=o.Order_Info_ID and i.Item_ID=o.Item_ID and  o.Order_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, orderID);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories();

                Order order = new Order();
                Items items = new Items(rs.getInt("ITEM_ID"),
                        rs.getString("NAME"), rs.getDouble("PRICE"),
                        5, categories, rs.getString("ITEMIMG"),rs.getInt("Calories"));
                drinkses.add(new Cold_Drinks(rs.getBoolean("AddSugar"),
                        rs.getString("MalikType"), rs.getString("Size"),
                        rs.getString("Ice_Shaped"), rs.getInt("Order_Info_ID"), order, items,
                        rs.getInt("Quantity"), rs.getDouble("Item_price")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return drinkses;
    }

    public ArrayList SelectOrderHot_Drinks(int orderID) {
        ArrayList<Hot_Drinks> hot_Drinkses = new ArrayList();
        try {

            String sql = "SELECT o.*,c.*,i.* From Order_Info o,Hot_Drinks c,Items i where c.H_ID=o.Order_Info_ID and i.Item_ID=o.Item_ID and  o.Order_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, orderID);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories();

                Order order = new Order();
              Items items = new Items(rs.getInt("ITEM_ID"),
                        rs.getString("NAME"), rs.getDouble("PRICE"),
                        5, categories, rs.getString("ITEMIMG"),rs.getInt("Calories"));
                hot_Drinkses.add(new Hot_Drinks(rs.getBoolean("AddSugar"),
                        rs.getString("Size"), rs.getString("MilkType"),
                        rs.getBoolean("ExtraHot"), rs.getInt("Order_Info_ID"), order, items,
                        rs.getInt("Quantity"), rs.getDouble("Item_price")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hot_Drinkses;
    }

    public ArrayList SelectOrderSandwich(int orderID) {
        ArrayList<Sandwich> sandwichs = new ArrayList();
        try {

            String sql = "SELECT o.*,c.*,i.* From Order_Info o,Sandwich c,Items i where c.Sandwich_ID=o.Order_Info_ID and i.Item_ID=o.Item_ID and  o.Order_ID=?";
            this.pst = con.prepareStatement(sql);
            pst.setInt(1, orderID);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                Categories categories = new Categories();

                Order order = new Order();
               Items items = new Items(rs.getInt("ITEM_ID"),
                        rs.getString("NAME"), rs.getDouble("PRICE"),
                        5, categories, rs.getString("ITEMIMG"),rs.getInt("Calories"));

                sandwichs.add(new Sandwich(rs.getBoolean("Spicy"),
                        rs.getString("BreadType"), rs.getString("ProteinType"),
                        rs.getInt("Order_Info_ID"), order, items,
                        rs.getInt("Quantity"), rs.getDouble("Item_price")));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sandwichs;
    }
}

//SELECT o.*,c.*,i.* From Order_Info o,Cake c,Items i where c.Cake_ID=o.Order_Info_ID
//                    and i.Item_ID=o.Item_ID and  o.Order_ID=1;
//
//SELECT o.*,c.*,i.* From Order_Info o,Cold_Drinks c,Items i where c.C_ID=o.Order_Info_ID
//                    and i.Item_ID=o.Item_ID and  o.Order_ID=1;
//SELECT o.*,c.*,i.* From Order_Info o,Hot_Drinks c,Items i where c.H_ID=o.Order_Info_ID
//                    and i.Item_ID=o.Item_ID and  o.Order_ID=1;
//SELECT o.*,c.*,i.* From Order_Info o,Sandwich c,Items i where c.Sandwich_ID=o.Order_Info_ID
//                    and i.Item_ID=o.Item_ID and  o.Order_ID=1;
