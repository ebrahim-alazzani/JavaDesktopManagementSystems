/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package folder;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ibral
 */
@Entity
@Table(catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Foods.findAll", query = "SELECT f FROM Foods f"),
    @NamedQuery(name = "Foods.findByFoodid", query = "SELECT f FROM Foods f WHERE f.foodid = :foodid"),
    @NamedQuery(name = "Foods.findByFoodname", query = "SELECT f FROM Foods f WHERE f.foodname = :foodname"),
    @NamedQuery(name = "Foods.findByFoodtype", query = "SELECT f FROM Foods f WHERE f.foodtype = :foodtype"),
    @NamedQuery(name = "Foods.findByPrice", query = "SELECT f FROM Foods f WHERE f.price = :price"),
    @NamedQuery(name = "Foods.findByQuantity", query = "SELECT f FROM Foods f WHERE f.quantity = :quantity"),
    @NamedQuery(name = "Foods.findByCalories", query = "SELECT f FROM Foods f WHERE f.calories = :calories"),
    @NamedQuery(name = "Foods.findByFoodimg", query = "SELECT f FROM Foods f WHERE f.foodimg = :foodimg")})
public class Foods implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer foodid;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String foodname;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String foodtype;
    @Basic(optional = false)
    @Column(nullable = false)
    private int price;
    @Basic(optional = false)
    @Column(nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(nullable = false)
    private int calories;
    @Column(length = 500)
    private String foodimg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foodid")
    private Collection<Orderdetails> orderdetailsCollection;
    @JoinColumn(name = "CHEFID", referencedColumnName = "CHEFID", nullable = false)
    @ManyToOne(optional = false)
    private Chef chefid;

    public Foods() {
    }

    public Foods(Integer foodid) {
        this.foodid = foodid;
    }

    public Foods(Integer foodid, String foodname, String foodtype, int price, int quantity, int calories) {
        this.foodid = foodid;
        this.foodname = foodname;
        this.foodtype = foodtype;
        this.price = price;
        this.quantity = quantity;
        this.calories = calories;
    }

    public Integer getFoodid() {
        return foodid;
    }

    public void setFoodid(Integer foodid) {
        this.foodid = foodid;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }

    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
    }

    public Chef getChefid() {
        return chefid;
    }

    public void setChefid(Chef chefid) {
        this.chefid = chefid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foodid != null ? foodid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Foods)) {
            return false;
        }
        Foods other = (Foods) object;
        if ((this.foodid == null && other.foodid != null) || (this.foodid != null && !this.foodid.equals(other.foodid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Foods[ foodid=" + foodid + " ]";
    }
    
}
