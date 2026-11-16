/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;

/**
 * CREATE TABLE Hot_Drinks( AddSugar boolean, H_ID int, price double, Size int,
 * MilkType Char, ExtraHot boolean, Flavor varchar(15), PRIMARY KEY (H_ID),
 * FOREIGN KEY (H_ID)REFERENCES Order_info (Order_Info_ID) );
 *
 * @author ASUS
 */
public class Hot_Drinks extends Order_Info {

    public boolean AddSugar;
    public String Size;
    public String MilkType;
    public boolean ExtraHot;

    public Hot_Drinks(boolean AddSugar, String Size, String MilkType, boolean ExtraHot, int Order_Info_ID, Order order, Items items, int Quantity, double Item_price) {
        super(Order_Info_ID, order, items, Quantity, Item_price);
        this.AddSugar = AddSugar;
        this.Size = Size;
        this.MilkType = MilkType;
        this.ExtraHot = ExtraHot;
    }

    public Hot_Drinks(boolean AddSugar, String Size, String MilkType, boolean ExtraHot, String Flavor) {
        this.AddSugar = AddSugar;
        this.Size = Size;
        this.MilkType = MilkType;
        this.ExtraHot = ExtraHot;
    }

 
    public Hot_Drinks() {
    }

 
}
