/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Food;

/**
 *
 * @author AZZ
 */
public class order {
    private int id;
    private String type;
    private double total;
    private double quantity;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getTotal() {
        return total;
    }

    public double getQuantity() {
        return quantity;
    }
    
    
}
