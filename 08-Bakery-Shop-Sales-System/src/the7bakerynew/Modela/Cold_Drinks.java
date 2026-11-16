/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;

/**
 *
 * @author ASUS
 */
public class Cold_Drinks extends Order_Info{
      public  boolean AddSugar;
    public  String MalikType;
    public  String Size;
    public  String Ice_Shaped;

    public Cold_Drinks(boolean AddSugar, String MalikType, String Size, String Ice_Shaped, int Order_Info_ID, Order order, Items items, int Quantity, double Item_price) {
        super(Order_Info_ID, order, items, Quantity, Item_price);
        this.AddSugar = AddSugar;
        this.MalikType = MalikType;
        this.Size = Size;
        this.Ice_Shaped = Ice_Shaped;
    }

    public Cold_Drinks(boolean AddSugar, String MalikType, String Size, String Ice_Shaped) {
        this.AddSugar = AddSugar;
        this.MalikType = MalikType;
        this.Size = Size;
        this.Ice_Shaped = Ice_Shaped;
    }

    

    public Cold_Drinks() {
    }
  
}
