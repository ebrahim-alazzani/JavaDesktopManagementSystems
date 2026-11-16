/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package folder;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Paymentcach.findAll", query = "SELECT p FROM Paymentcach p"),
    @NamedQuery(name = "Paymentcach.findByPaymentcachid", query = "SELECT p FROM Paymentcach p WHERE p.paymentcachid = :paymentcachid"),
    @NamedQuery(name = "Paymentcach.findByPaymentdate", query = "SELECT p FROM Paymentcach p WHERE p.paymentdate = :paymentdate"),
    @NamedQuery(name = "Paymentcach.findByAmount", query = "SELECT p FROM Paymentcach p WHERE p.amount = :amount")})
public class Paymentcach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer paymentcachid;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date paymentdate;
    @Basic(optional = false)
    @Column(nullable = false)
    private int amount;
    @JoinColumn(name = "PAYMENTCACHID", referencedColumnName = "ORDERID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Orders orders;

    public Paymentcach() {
    }

    public Paymentcach(Integer paymentcachid) {
        this.paymentcachid = paymentcachid;
    }

    public Paymentcach(Integer paymentcachid, Date paymentdate, int amount) {
        this.paymentcachid = paymentcachid;
        this.paymentdate = paymentdate;
        this.amount = amount;
    }

    public Integer getPaymentcachid() {
        return paymentcachid;
    }

    public void setPaymentcachid(Integer paymentcachid) {
        this.paymentcachid = paymentcachid;
    }

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentcachid != null ? paymentcachid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentcach)) {
            return false;
        }
        Paymentcach other = (Paymentcach) object;
        if ((this.paymentcachid == null && other.paymentcachid != null) || (this.paymentcachid != null && !this.paymentcachid.equals(other.paymentcachid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "folder.Paymentcach[ paymentcachid=" + paymentcachid + " ]";
    }
    
}
