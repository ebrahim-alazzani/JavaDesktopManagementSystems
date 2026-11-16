/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ibral
 */
@MappedSuperclass
@Table(catalog = "", schema = "APP")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer userid;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String password;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String type;
    @Column(length = 30)
    private String position;
    private Boolean status;
    @Column(length = 100)
    private String fullname;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Chef chef;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Waiter waiter;

    public Users() {
    }

    public Users(Integer userid) {
        this.userid = userid;
    }

    public Users(Integer userid, String username, String password, String type) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Users[ userid=" + userid + " ]";
    }
    
}
