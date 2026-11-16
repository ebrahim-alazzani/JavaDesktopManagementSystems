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
    @NamedQuery(name = "Diningtable.findAll", query = "SELECT d FROM Diningtable d"),
    @NamedQuery(name = "Diningtable.findByTableid", query = "SELECT d FROM Diningtable d WHERE d.tableid = :tableid"),
    @NamedQuery(name = "Diningtable.findByTablenumber", query = "SELECT d FROM Diningtable d WHERE d.tablenumber = :tablenumber"),
    @NamedQuery(name = "Diningtable.findByCodechartable", query = "SELECT d FROM Diningtable d WHERE d.codechartable = :codechartable"),
    @NamedQuery(name = "Diningtable.findByCapacit", query = "SELECT d FROM Diningtable d WHERE d.capacit = :capacit"),
    @NamedQuery(name = "Diningtable.findByStatus", query = "SELECT d FROM Diningtable d WHERE d.status = :status")})
public class Diningtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer tableid;
    @Basic(optional = false)
    @Column(nullable = false)
    private int tablenumber;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String codechartable;
    @Basic(optional = false)
    @Column(nullable = false)
    private int capacit;
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableid")
    private Collection<Reservation> reservationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tableid")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "WAITERID", referencedColumnName = "WAITERID", nullable = false)
    @ManyToOne(optional = false)
    private Waiter waiterid;

    public Diningtable() {
    }

    public Diningtable(Integer tableid) {
        this.tableid = tableid;
    }

    public Diningtable(Integer tableid, int tablenumber, String codechartable, int capacit) {
        this.tableid = tableid;
        this.tablenumber = tablenumber;
        this.codechartable = codechartable;
        this.capacit = capacit;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public int getTablenumber() {
        return tablenumber;
    }

    public void setTablenumber(int tablenumber) {
        this.tablenumber = tablenumber;
    }

    public String getCodechartable() {
        return codechartable;
    }

    public void setCodechartable(String codechartable) {
        this.codechartable = codechartable;
    }

    public int getCapacit() {
        return capacit;
    }

    public void setCapacit(int capacit) {
        this.capacit = capacit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Waiter getWaiterid() {
        return waiterid;
    }

    public void setWaiterid(Waiter waiterid) {
        this.waiterid = waiterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tableid != null ? tableid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diningtable)) {
            return false;
        }
        Diningtable other = (Diningtable) object;
        if ((this.tableid == null && other.tableid != null) || (this.tableid != null && !this.tableid.equals(other.tableid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Diningtable[ tableid=" + tableid + " ]";
    }
    
}
