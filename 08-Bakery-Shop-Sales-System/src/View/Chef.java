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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ibral
 */
@MappedSuperclass
@Table(catalog = "", schema = "APP")
public class Chef implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer chefid;
    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String specialization;
    @Basic(optional = false)
    @Column(nullable = false)
    private int experience;
    @JoinColumn(name = "CHEFID", referencedColumnName = "USERID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chefid")
    private Collection<Foods> foodsCollection;

    public Chef() {
    }

    public Chef(Integer chefid) {
        this.chefid = chefid;
    }

    public Chef(Integer chefid, String specialization, int experience) {
        this.chefid = chefid;
        this.specialization = specialization;
        this.experience = experience;
    }

    public Integer getChefid() {
        return chefid;
    }

    public void setChefid(Integer chefid) {
        this.chefid = chefid;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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
        hash += (chefid != null ? chefid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chef)) {
            return false;
        }
        Chef other = (Chef) object;
        if ((this.chefid == null && other.chefid != null) || (this.chefid != null && !this.chefid.equals(other.chefid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Chef[ chefid=" + chefid + " ]";
    }
    
}
