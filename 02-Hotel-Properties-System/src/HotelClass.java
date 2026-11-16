/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class HotelClass {

    HotelClass(String kkkk, String llok) {

        this.Location=kkkk;
        this.Hotel_name=llok;
    }

    HotelClass() {
    }

    /**
     * @return the Hotel_ID
     */
    public int getHotel_ID() {
        return Hotel_ID;
    }

    /**
     * @param Hotel_ID the Hotel_ID to set
     */
    public void setHotel_ID(int Hotel_ID) {
        this.Hotel_ID = Hotel_ID;
    }

    /**
     * @return the Location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * @param Location the Location to set
     */
    public void setLocation(String Location) {
        this.Location = Location;
    }

    /**
     * @return the Hotel_name
     */
    public String getHotel_name() {
        return Hotel_name;
    }

    /**
     * @param Hotel_name the Hotel_name to set
     */
    public void setHotel_name(String Hotel_name) {
        this.Hotel_name = Hotel_name;
    }
    private int Hotel_ID;
    private  String Location;
    private String Hotel_name;
    
    
}
