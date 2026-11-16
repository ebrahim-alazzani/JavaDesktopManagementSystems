/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussnuesLogacl;

import Model.Customers;
import Model.DiningTable;
import Model.Reservation;
import Model.Waiter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ibral
 */
public class ReservationBL {
    Connection con = ConnectionDB.ConnectDB();
    DefaultTableModel model;
    Statement stmt;
    PreparedStatement pst;
    ResultSet rs;
    public int InsertReservation(Reservation reservation) throws SQLException {
        int result = 0;


        String query = "INSERT INTO APP.Reservation (ReservationDate,StartTime,EndTime,CountPrson,Status,TableId,CustomerId,waiterId)  VALUES (?,?,?,?,?,?,?,?)";
        pst = con.prepareStatement(query);
        pst.setDate(1, reservation.getReservationDate());
        pst.setTime(2, reservation.getStartTime());
        pst.setTime(3, reservation.getEndTime());

        pst.setInt(4, reservation.getCountPrson());
        pst.setInt(5, reservation.getStatus());
        pst.setInt(6,reservation.getDiningTable().getTableId());
        pst.setInt(7,reservation.getCustomer().getCustomerId());

        pst.setInt(8,reservation.getWaiter().getUserId());
       
        result = pst.executeUpdate();
        return result;

    }
    Reservation reservation;
     public ArrayList ReservationArrayList() {
        ArrayList<Reservation> reservations = new ArrayList();
        try {

            String sql = "SELECT r.*,c.*,d.* From Reservation r,Customers c,DiningTable d"
                    + " where c.CustomerId=r.CustomerId and d.TableId=r.TableId";
                 
            this.pst = con.prepareStatement(sql);
            rs = this.pst.executeQuery();
            while (rs.next()) {
                DiningTable diningTable= new DiningTable(rs.getInt("TableId"),
                         rs.getInt("TableNumber"),
                       rs.getString("CodeCharTable"),
                       rs.getInt("Capacit"),
                       rs.getInt("Status"));
               Customers customers= new Customers(rs.getInt("CustomerId"),rs.getString("CustomerName"),rs.getString("Address"),
                       rs.getString("Phone"));
              reservation = new Reservation(rs.getInt("ReservationId"),
                         rs.getDate("ReservationDate"),
                       rs.getTime("StartTime"),
                       rs.getTime("EndTime"),
                       rs.getInt("CountPrson"),
                rs.getInt("Status"),diningTable,customers,new Waiter()
               
               );
                reservations.add(reservation);
            }
           
                        
                        

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    } 
       public void deleteReservationById(int id) {

        try {
            String sql = "DELETE FROM Reservation WHERE ReservationId = ?";
            pst = con.prepareCall(sql);
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }

    }
}
