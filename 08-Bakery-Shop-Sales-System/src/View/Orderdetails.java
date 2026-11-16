/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 *
 * @author ibral
 */
@MappedSuperclass
@Table(catalog = "", schema = "APP")
public class Orderdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer orderdetailsid;
    @Basic(optional = false)
    @Column(nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(nullable = false)
    private int price;
    @JoinColumn(name = "FOODID", referencedColumnName = "FOODID", nullable = false)
    @ManyToOne(optional = false)
    private Foods foodid;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID", nullable = false)
    @ManyToOne(optional = false)
    private Orders orderid;

    public Orderdetails() {
    }

    public Orderdetails(Integer orderdetailsid) {
        this.orderdetailsid = orderdetailsid;
    }

    public Orderdetails(Integer orderdetailsid, int quantity, int price) {
        this.orderdetailsid = orderdetailsid;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getOrderdetailsid() {
        return orderdetailsid;
    }

    public void setOrderdetailsid(Integer orderdetailsid) {
        this.orderdetailsid = orderdetailsid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Foods getFoodid() {
        return foodid;
    }

    public void setFoodid(Foods foodid) {
        this.foodid = foodid;
    }

    public Orders getOrderid() {
        return orderid;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderdetailsid != null ? orderdetailsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetails)) {
            return false;
        }
        Orderdetails other = (Orderdetails) object;
        if ((this.orderdetailsid == null && other.orderdetailsid != null) || (this.orderdetailsid != null && !this.orderdetailsid.equals(other.orderdetailsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Orderdetails[ orderdetailsid=" + orderdetailsid + " ]";
    }
    
}
