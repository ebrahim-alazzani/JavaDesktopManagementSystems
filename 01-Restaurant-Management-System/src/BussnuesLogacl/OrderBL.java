/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussnuesLogacl;

import Model.Chef;
import Model.Customers;
import Model.DiningTable;
import Model.Foods;
import Model.Order;
import Model.OrderDetails;
import Model.PaymentCach;
import Model.PaymentCard;
import Model.Waiter;
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
 * @author ibral
 */
public class OrderBL {
    Connection con = ConnectionDB.ConnectDB();
    DefaultTableModel model;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;
    Foods foods;
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
       public int InsertOrders(Order order) throws SQLException {
        int result = 0;

        int id = GetNextValue("Orders", "OrderID");

        String query = "INSERT INTO APP.Orders (OrderId,OrderDate,Total,TableId,CustomerId,WaiterId)  VALUES (?,?,?,?,?,?)";
        pst = con.prepareStatement(query);
        pst.setInt(1,id);

        pst.setDate(2, order.getOrderDate());
        pst.setDouble(3, order.getTotal());
        pst.setInt(4, order.getDiningTable().getTableId());
        pst.setInt(5, order.getCustomers().getCustomerId());
        pst.setInt(6, 3);
        result = pst.executeUpdate();

        return result;

    }
      public ArrayList SelectItems(String type,int orderId) {
        ArrayList<Foods> foodses = new ArrayList();
        try {

            String sql = "SELECT f.* From Foods f where f.FOODID not in(Select d.FOODID from APP.ORDERDETAILS d where  d.ORDERID=?) and f.FoodType=?";
          
            
           this.pst = con.prepareStatement(sql);
           pst.setInt(1, orderId);
           pst.setString(2, type);
     

            rs = this.pst.executeQuery();
            while (rs.next()) {
               foods= new Foods(rs.getInt("FoodId"),rs.getString("FoodName"),
                       rs.getDouble("Price"),rs.getInt("Quantity"),rs.getInt("Calories"),rs.getString("FoodImg"));
                foodses.add(foods);
            }
           
                        
                        

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foodses;
    }
    public int InsertItemOrder(OrderDetails details) throws SQLException {
        int result = 0;
 

        String query = "INSERT INTO APP.ORDERDETAILS (OrderID,FoodId,Quantity,Price) VALUES (?,?,?,?)";
        pst = con.prepareStatement(query);
        pst.setInt(1, details.getOrder().getOrderId());
        pst.setInt(2, details.getFoods().getFoodId());
        pst.setDouble(3, details.getQuantity());
        pst.setDouble(4, details.getPrice());
        result = pst.executeUpdate();

        if (result == 1) {
            double price = SelectOrderTotalSum(details.getOrder().getOrderId());

            
            price+=details.getPrice();
            
            String sql = "UPDATE Orders set Total=?"
                    + " WHERE OrderId = ?";

            pst = con.prepareStatement(sql);
            pst.setDouble(1, price);
            pst.setInt(2, details.getOrder().getOrderId());

            pst.execute();
            
        }
                return result;
    }
    
    OrderDetails orderDetails;
    public Order OrderData(int orderId) throws SQLException {
            String sql = "SELECT o.* ,c.*,t.* From Orders o,Customers c,DiningTable t WHERE o.CustomerId=c.CustomerId and o.TableId=t.TableId and  o.ORDERID=?";
            Order order = null;
           this.pst = con.prepareStatement(sql);
           pst.setDouble(1, orderId);
           rs = this.pst.executeQuery();
            while (rs.next()) {
                 Customers customers= new Customers(rs.getInt("CustomerId"),
                       rs.getString("CustomerName"),rs.getString("Address"),
                       rs.getString("Phone"));
                 DiningTable diningTable=new DiningTable(rs.getInt("TableId"),
                         rs.getInt("TableNumber"),
                       rs.getString("CodeCharTable"),
                       rs.getInt("Capacit"),
                       rs.getInt("Status"));
                  order=new Order(rs.getInt("OrderId"),
                         rs.getDate("OrderDate"),
                       rs.getDouble("Total"),"",
                      new Waiter(),diningTable,customers);
            }
        return order;
    }

  public ArrayList ArrayListBill(int orderId) {
        ArrayList<OrderDetails> detailses = new ArrayList();
        try {

            String sql = "SELECT f.*,d.OrderDetailsId,d.QUANTITY as TotallQuantity ,d.PRICE as ToatllPrice From Foods f,APP.ORDERDETAILS d WHERE f.FOODID=d.FOODID\n" +
                    "and d.ORDERID=?";

           this.pst = con.prepareStatement(sql);
     
            pst.setDouble(1, orderId);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                 foods= new Foods(rs.getInt("FoodId"),rs.getString("FoodName"),
                       rs.getDouble("Price"),rs.getInt("Quantity"),rs.getInt("Calories"),rs.getString("FoodImg"));
                 Order order=new Order();
                 
               orderDetails= new OrderDetails(rs.getInt("OrderDetailsId"),
                       order,foods,rs.getInt("TotallQuantity"),rs.getInt("ToatllPrice"));
                detailses.add(orderDetails);
            }
           
                        
                        

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return detailses;
    }
    public int InsertPayment(Order payment) throws SQLException {
        int result = 0;

          String sql = "UPDATE Orders set TypeMothd=?"
                    + " WHERE OrderId = ?";

        pst = con.prepareStatement(sql);
        pst.setString(1, payment.getTypeMothd());
        pst.setInt(2, payment.getOrderId());

        pst.execute();
         if (payment instanceof PaymentCach) {
               String query = "INSERT INTO PaymentCach (PaymentCachId,PaymentDate,Amount) VALUES (?,?,?)";
                pst = con.prepareStatement(query);
                pst.setInt(1, payment.getOrderId());
                pst.setDate(2, ((PaymentCach) payment).getPaymentDate());
                pst.setDouble(3, ((PaymentCach) payment).getAmount());

            } else  if (payment instanceof PaymentCard) {
               String query = "INSERT INTO PaymentCard (PaymentCardId,PaymentDate,Amount,CardNumber) VALUES (?,?,?,?)";
                pst = con.prepareStatement(query);
                pst.setInt(1, payment.getOrderId());
                pst.setDate(2, ((PaymentCard) payment).getPaymentDate());
                pst.setDouble(3, ((PaymentCard) payment).getAmount());
                pst.setInt(4, ((PaymentCard) payment).getCardNumber());


            }
            result = pst.executeUpdate();
        return result;
     

    }
        public double SelectOrderTotalSum(int orderID) {

        double sumPrice = 0;
        try {

            String sql = "SELECT  Total From Orders  Where ORDERID=?";
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

//    public void updatePayment(int id,Payment payment ) {
//        try {
//            PreparedStatement newStock;
//
//            // Connection c = con();
//            String sql = "UPDATE Payment set Amount=?"
//                    + " WHERE Payment_ID = ?";
//
//            newStock = con.prepareStatement(sql);
//            newStock.setDouble(1, payment.getAmount());
//           
//
//            newStock.setInt(2, id);
//
//            newStock.execute();
//            JOptionPane.showMessageDialog(null, "Updated");
//            // tableemp();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//
//    }

}
