/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modela;

/**
 *
 * CREATE TABLE Items( Item_ID INT NOT NULL primary key, Name varchar(50) NOT
 * NULL, Price Date NOT NULL, Categorie_ID int not null, FOREIGN KEY
 * (Categorie_ID)REFERENCES Categories (Categorie_ID)
 *
 * );
 *
 * @author ASUS
 */
public class Items {

    private int Item_ID;
    private String Name;
    private double Price;
    private int Quantity;
    private int Calories;
    private Categories categories;
    private String ItemImg;

    public Items(int Item_ID, String Name, double Price, int Quantity, Categories categories,String ItemImg,int Calories) {
        this.Item_ID = Item_ID;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.categories = categories;
        this.ItemImg=ItemImg;
        this.Calories=Calories;
    }

    public Items() {
    }

    public String getItemImg() {
        return ItemImg;
    }

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int Calories) {
        this.Calories = Calories;
    }

    public void setItemImg(String ItemImg) {
        this.ItemImg = ItemImg;
    }

    public int getItem_ID() {
        return Item_ID;
    }

    public void setItem_ID(int Item_ID) {
        this.Item_ID = Item_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Item_ID);
        sb.append(" ").append(Name);
       
        return sb.toString();
    }

    
}
