/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ibral
 */
@MappedSuperclass
@Table(catalog = "", schema = "APP")
public class Paymentcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer paymentcardid;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date paymentdate;
    @Basic(optional = false)
    @Column(nullable = false)
    private int amount;
    @Basic(optional = false)
    @Column(nullable = false)
    private int cardnumber;
    @JoinColumn(name = "PAYMENTCARDID", referencedColumnName = "ORDERID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Orders orders;

    public Paymentcard() {
    }

    public Paymentcard(Integer paymentcardid) {
        this.paymentcardid = paymentcardid;
    }

    public Paymentcard(Integer paymentcardid, Date paymentdate, int amount, int cardnumber) {
        this.paymentcardid = paymentcardid;
        this.paymentdate = paymentdate;
        this.amount = amount;
        this.cardnumber = cardnumber;
    }

    public Integer getPaymentcardid() {
        return paymentcardid;
    }

    public void setPaymentcardid(Integer paymentcardid) {
        this.paymentcardid = paymentcardid;
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

    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
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
        hash += (paymentcardid != null ? paymentcardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymentcard)) {
            return false;
        }
        Paymentcard other = (Paymentcard) object;
        if ((this.paymentcardid == null && other.paymentcardid != null) || (this.paymentcardid != null && !this.paymentcardid.equals(other.paymentcardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Paymentcard[ paymentcardid=" + paymentcardid + " ]";
    }
    
}
