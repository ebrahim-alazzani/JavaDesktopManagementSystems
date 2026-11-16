/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ibral
 */
public class OrderDetails {
    private int OrderDetailsId;
    private Order order;
    private Foods foods;
    private int Quantity;
    private double Price;

    public OrderDetails() {
    }

    public OrderDetails(int OrderDetailsId, Order order, Foods foods, int Quantity, double Price) {
        this.OrderDetailsId = OrderDetailsId;
        this.order = order;
        this.foods = foods;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public int getOrderDetailsId() {
        return OrderDetailsId;
    }

    public void setOrderDetailsId(int OrderDetailsId) {
        this.OrderDetailsId = OrderDetailsId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Foods getFoods() {
        return foods;
    }

    public void setFoods(Foods foods) {
        this.foods = foods;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
    
}
