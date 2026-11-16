/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package folder;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ibral
 */
@Entity
@Table(catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderid", query = "SELECT o FROM Orders o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Orders.findByOrderdate", query = "SELECT o FROM Orders o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "Orders.findByTotal", query = "SELECT o FROM Orders o WHERE o.total = :total"),
    @NamedQuery(name = "Orders.findByTypemothd", query = "SELECT o FROM Orders o WHERE o.typemothd = :typemothd")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer orderid;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    @Basic(optional = false)
    @Column(nullable = false)
    private int total;
    @Column(length = 30)
    private String typemothd;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orders")
    private Paymentcach paymentcach;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID", nullable = false)
    @ManyToOne(optional = false)
    private Customers customerid;
    @JoinColumn(name = "TABLEID", referencedColumnName = "TABLEID", nullable = false)
    @ManyToOne(optional = false)
    private Diningtable tableid;
    @JoinColumn(name = "WAITERID", referencedColumnName = "WAITERID", nullable = false)
    @ManyToOne(optional = false)
    private Waiter waiterid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Collection<Orderdetails> orderdetailsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orders")
    private Paymentcard paymentcard;

    public Orders() {
    }

    public Orders(Integer orderid) {
        this.orderid = orderid;
    }

    public Orders(Integer orderid, Date orderdate, int total) {
        this.orderid = orderid;
        this.orderdate = orderdate;
        this.total = total;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTypemothd() {
        return typemothd;
    }

    public void setTypemothd(String typemothd) {
        this.typemothd = typemothd;
    }

    public Paymentcach getPaymentcach() {
        return paymentcach;
    }

    public void setPaymentcach(Paymentcach paymentcach) {
        this.paymentcach = paymentcach;
    }

    public Customers getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customers customerid) {
        this.customerid = customerid;
    }

    public Diningtable getTableid() {
        return tableid;
    }

    public void setTableid(Diningtable tableid) {
        this.tableid = tableid;
    }

    public Waiter getWaiterid() {
        return waiterid;
    }

    public void setWaiterid(Waiter waiterid) {
        this.waiterid = waiterid;
    }

    public Collection<Orderdetails> getOrderdetailsCollection() {
        return orderdetailsCollection;
    }

    public void setOrderdetailsCollection(Collection<Orderdetails> orderdetailsCollection) {
        this.orderdetailsCollection = orderdetailsCollection;
    }

    public Paymentcard getPaymentcard() {
        return paymentcard;
    }

    public void setPaymentcard(Paymentcard paymentcard) {
        this.paymentcard = paymentcard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Orders[ orderid=" + orderid + " ]";
    }
    
}
