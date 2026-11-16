/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;

/**
 *
 * 
Create table Sandwich
(
Sandwitch_ID int not null primary key,
Spicy boolean not null,
Price int not null,
BreadType char not null,
Calories int not null,
ProteinType char not null,
foreign key (Sandwitch_ID) references Order_info(Order_info)
);
 
 * @author ASUS
 */
public class Sandwich extends Order_Info{
    
    public  boolean Spicy;
    public  String BreadType;
    public  String ProteinType;

    public Sandwich(boolean Spicy, String BreadType, String ProteinType, int Order_Info_ID, Order order, Items items, int Quantity, double Item_price) {
        super(Order_Info_ID, order, items, Quantity, Item_price);
        this.Spicy = Spicy;
        this.BreadType = BreadType;
        this.ProteinType = ProteinType;
    }

    public Sandwich(boolean Spicy, String BreadType, String ProteinType) {
        this.Spicy = Spicy;
        this.BreadType = BreadType;
        this.ProteinType = ProteinType;
    }

   
    public Sandwich() {
    }

   
}
