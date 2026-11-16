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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ibral
 */
@Entity
@Table(catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Waiter.findAll", query = "SELECT w FROM Waiter w"),
    @NamedQuery(name = "Waiter.findByWaiterid", query = "SELECT w FROM Waiter w WHERE w.waiterid = :waiterid"),
    @NamedQuery(name = "Waiter.findByShift", query = "SELECT w FROM Waiter w WHERE w.shift = :shift"),
    @NamedQuery(name = "Waiter.findBySalary", query = "SELECT w FROM Waiter w WHERE w.salary = :salary")})
public class Waiter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer waiterid;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String shift;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 52)
    private Double salary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waiterid")
    private Collection<Customers> customersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waiterid")
    private Collection<Reservation> reservationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waiterid")
    private Collection<Orders> ordersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "waiterid")
    private Collection<Diningtable> diningtableCollection;
    @JoinColumn(name = "WAITERID", referencedColumnName = "USERID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;

    public Waiter() {
    }

    public Waiter(Integer waiterid) {
        this.waiterid = waiterid;
    }

    public Waiter(Integer waiterid, String shift) {
        this.waiterid = waiterid;
        this.shift = shift;
    }

    public Integer getWaiterid() {
        return waiterid;
    }

    public void setWaiterid(Integer waiterid) {
        this.waiterid = waiterid;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Collection<Customers> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers> customersCollection) {
        this.customersCollection = customersCollection;
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

    public Collection<Diningtable> getDiningtableCollection() {
        return diningtableCollection;
    }

    public void setDiningtableCollection(Collection<Diningtable> diningtableCollection) {
        this.diningtableCollection = diningtableCollection;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (waiterid != null ? waiterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Waiter)) {
            return false;
        }
        Waiter other = (Waiter) object;
        if ((this.waiterid == null && other.waiterid != null) || (this.waiterid != null && !this.waiterid.equals(other.waiterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Waiter[ waiterid=" + waiterid + " ]";
    }
    
}
