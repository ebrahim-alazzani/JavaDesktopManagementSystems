/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussnuesLogacl;

import Model.Foods;
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
public class FoodsBL {
    Connection con = ConnectionDB.ConnectDB();
    DefaultTableModel model;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;
    Foods items;
      public int InsertFoods(Foods food) throws SQLException {
        int result = 0;

        String query = "INSERT INTO APP.Foods (FoodName,FoodType,Price,Quantity,Calories,FoodImg,ChefId)  VALUES (?,?,?,?,?,?,?)";
        pst = con.prepareStatement(query);
        pst.setString(1, food.getFoodName());
        pst.setString(2, food.getFoodType());

        pst.setDouble(3, food.getPrice());
        pst.setInt(4, food.getQuantity());
        pst.setInt(5, food.getCalories());
        pst.setString(6, food.getFoodImg());
        pst.setInt(7,food.getChef().getUserId());

        result = pst.executeUpdate();
        return result;

    }

    public ArrayList FoodsArrayList() {
        ArrayList<Foods> foodses = new ArrayList();
        try {

            String sql = "SELECT it.FoodId,it.FoodName,it.FoodType,it.Price,it.Quantity,it.Calories,it.FoodImg From Foods it";
                 
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
               items= new Foods(rs.getInt("FoodId"),rs.getString("FoodName"),rs.getString("FoodType"),
                       rs.getDouble("Price"),rs.getInt("Quantity"),rs.getInt("Calories"),rs.getString("FoodImg"));
                foodses.add(items);
            }
           
                        
                        

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foodses;
    }

    public ArrayList FoodsArrayList(String ItemType) {
        ArrayList<Foods> foodses = new ArrayList();
        try {

            String sql = "SELECT it.FoodId,it.FoodName,it.Price,it.Quantity,it.Calories,it.FoodImg From Foods it where it.FoodType=?";
            this.pst = con.prepareStatement(sql);
            pst.setString(1, ItemType);

            rs = this.pst.executeQuery();
            while (rs.next()) {
                   items= new Foods(rs.getInt("FoodId"),rs.getString("FoodName"),
                       rs.getDouble("Price"),rs.getInt("Quantity"),rs.getInt("Calories"),rs.getString("FoodImg"));
                foodses.add(items);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return foodses;
    }
       public void deleteFoodById(int id) {

        try {
            String sql = "DELETE FROM Foods WHERE FoodId = ?";
            pst = con.prepareCall(sql);
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
       }

}
