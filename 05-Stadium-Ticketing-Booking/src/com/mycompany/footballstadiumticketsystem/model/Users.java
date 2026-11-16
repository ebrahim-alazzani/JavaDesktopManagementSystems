/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.footballstadiumticketsystem.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String tybe;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String fullname;
    @Column(length = 30)
    private String position;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Foods> foodsCollection;

    public Users() {
    }

    public Users(Integer userid) {
        this.userid = userid;
    }

    public Users(Integer userid, String username, String password, String tybe, String fullname) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.tybe = tybe;
        this.fullname = fullname;
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

    public String getTybe() {
        return tybe;
    }

    public void setTybe(String tybe) {
        this.tybe = tybe;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Collection<Foods> getFoodsCollection() {
        return foodsCollection;
    }

    public void setFoodsCollection(Collection<Foods> foodsCollection) {
        this.foodsCollection = foodsCollection;
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
        return "com.mycompany.footballstadiumticketsystem.model.Users[ userid=" + userid + " ]";
    }
    
}
