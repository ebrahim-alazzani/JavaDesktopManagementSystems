/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ibral
 */
public class Foods {
    private int FoodId;
    private String FoodName;
    private String FoodType;

    private double Price;
    private int Quantity;
    private int Calories;
    private String FoodImg;
    private  Chef chef;

    public Foods() {
    }

    public Foods(int FoodId, String FoodName, String FoodType, double Price, int Quantity, int Calories, String FoodImg, Chef chef) {
        this.FoodId = FoodId;
        this.FoodName = FoodName;
        this.FoodType = FoodType;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Calories = Calories;
        this.FoodImg = FoodImg;
        this.chef = chef;
    }

    public Foods(int FoodId, String FoodName, String FoodType, double Price, int Quantity, int Calories, String FoodImg) {
        this.FoodId = FoodId;
        this.FoodName = FoodName;
        this.FoodType = FoodType;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Calories = Calories;
        this.FoodImg = FoodImg;
    }

    public Foods(int FoodId, String FoodName, double Price, int Quantity, int Calories, String FoodImg) {
        this.FoodId = FoodId;
        this.FoodName = FoodName;
        this.Price = Price;
        this.Quantity = Quantity;
        this.Calories = Calories;
        this.FoodImg = FoodImg;
    }

    public int getFoodId() {
        return FoodId;
    }

    public void setFoodId(int FoodId) {
        this.FoodId = FoodId;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String FoodName) {
        this.FoodName = FoodName;
    }

    public String getFoodType() {
        return FoodType;
    }

    public void setFoodType(String FoodType) {
        this.FoodType = FoodType;
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

    public int getCalories() {
        return Calories;
    }

    public void setCalories(int Calories) {
        this.Calories = Calories;
    }

    public String getFoodImg() {
        return FoodImg;
    }

    public void setFoodImg(String FoodImg) {
        this.FoodImg = FoodImg;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
    
       @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FoodId);
        sb.append(" ").append(FoodName);
       
        return sb.toString();
    }
    
}
