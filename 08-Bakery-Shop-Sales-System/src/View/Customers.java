/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ibral
 */
@MappedSuperclass
@Table(catalog = "", schema = "APP")
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer customerid;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String customername;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String address;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String phone;
    @JoinColumn(name = "WAITERID", referencedColumnName = "WAITERID", nullable = false)
    @ManyToOne(optional = false)
    private Waiter waiterid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<Reservation> reservationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private Collection<Orders> ordersCollection;

    public Customers() {
    }

    public Customers(Integer customerid) {
        this.customerid = customerid;
    }

    public Customers(Integer customerid, String customername, String address, String phone) {
        this.customerid = customerid;
        this.customername = customername;
        this.address = address;
        this.phone = phone;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Waiter getWaiterid() {
        return waiterid;
    }

    public void setWaiterid(Waiter waiterid) {
        this.waiterid = waiterid;
    }

    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Customers[ customerid=" + customerid + " ]";
    }
    
}
