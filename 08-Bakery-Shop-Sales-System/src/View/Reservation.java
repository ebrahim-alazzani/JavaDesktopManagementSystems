/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ibral
 */
@MappedSuperclass
@Table(catalog = "", schema = "APP")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer reservationid;
    @Temporal(TemporalType.DATE)
    private Date reservationdate;
    @Temporal(TemporalType.TIME)
    private Date starttime;
    @Temporal(TemporalType.TIME)
    private Date endtime;
    private Integer countprson;
    private Integer status;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID", nullable = false)
    @ManyToOne(optional = false)
    private Customers customerid;
    @JoinColumn(name = "TABLEID", referencedColumnName = "TABLEID", nullable = false)
    @ManyToOne(optional = false)
    private Diningtable tableid;
    @JoinColumn(name = "WAITERID", referencedColumnName = "WAITERID", nullable = false)
    @ManyToOne(optional = false)
    private Waiter waiterid;

    public Reservation() {
    }

    public Reservation(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public Integer getReservationid() {
        return reservationid;
    }

    public void setReservationid(Integer reservationid) {
        this.reservationid = reservationid;
    }

    public Date getReservationdate() {
        return reservationdate;
    }

    public void setReservationdate(Date reservationdate) {
        this.reservationdate = reservationdate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getCountprson() {
        return countprson;
    }

    public void setCountprson(Integer countprson) {
        this.countprson = countprson;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reservationid != null ? reservationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.reservationid == null && other.reservationid != null) || (this.reservationid != null && !this.reservationid.equals(other.reservationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Reservation[ reservationid=" + reservationid + " ]";
    }
    
}
