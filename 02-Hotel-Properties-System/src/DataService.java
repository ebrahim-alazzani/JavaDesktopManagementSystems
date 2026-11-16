
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class DataService {
     Connection con=DBconnect.ConnectDB();
    public int InsertCustomer(HotelClass hotelClass) throws SQLException {
     int result=0;
     
    PreparedStatement newStock;
   
   String  query = "INSERT INTO hotel (Location,Hotel_name) VALUES (?,?)";
                newStock = con.prepareStatement(query);
                newStock.setString(1, hotelClass.getLocation());
                newStock.setString(2, hotelClass.getHotel_name());
               
               
                result=newStock.executeUpdate();
                
           
                return result;
                
 }

}
