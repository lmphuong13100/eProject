/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minhp
 */
@Entity
@Table(name = "ShipMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShipMethod.findAll", query = "SELECT s FROM ShipMethod s")
    , @NamedQuery(name = "ShipMethod.findByShMeID", query = "SELECT s FROM ShipMethod s WHERE s.shMeID = :shMeID")
    , @NamedQuery(name = "ShipMethod.findByShMeType", query = "SELECT s FROM ShipMethod s WHERE s.shMeType = :shMeType")
    , @NamedQuery(name = "ShipMethod.findByShMeDescription", query = "SELECT s FROM ShipMethod s WHERE s.shMeDescription = :shMeDescription")
    , @NamedQuery(name = "ShipMethod.findByShMeMin", query = "SELECT s FROM ShipMethod s WHERE s.shMeMin = :shMeMin")
    , @NamedQuery(name = "ShipMethod.findByShMeMax", query = "SELECT s FROM ShipMethod s WHERE s.shMeMax = :shMeMax")
    , @NamedQuery(name = "ShipMethod.findByShMePrice", query = "SELECT s FROM ShipMethod s WHERE s.shMePrice = :shMePrice")})
public class ShipMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShMeID")
    private Integer shMeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ShMeType")
    private String shMeType;
    @Size(max = 200)
    @Column(name = "ShMeDescription")
    private String shMeDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ShMeMin")
    private Double shMeMin;
    @Column(name = "ShMeMax")
    private Double shMeMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShMePrice")
    private int shMePrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shMeID")
    private Collection<Orders> ordersCollection;

    public ShipMethod() {
    }

    public ShipMethod(Integer shMeID) {
        this.shMeID = shMeID;
    }

    public ShipMethod(Integer shMeID, String shMeType, int shMePrice) {
        this.shMeID = shMeID;
        this.shMeType = shMeType;
        this.shMePrice = shMePrice;
    }

    public Integer getShMeID() {
        return shMeID;
    }

    public void setShMeID(Integer shMeID) {
        this.shMeID = shMeID;
    }

    public String getShMeType() {
        return shMeType;
    }

    public void setShMeType(String shMeType) {
        this.shMeType = shMeType;
    }

    public String getShMeDescription() {
        return shMeDescription;
    }

    public void setShMeDescription(String shMeDescription) {
        this.shMeDescription = shMeDescription;
    }

    public Double getShMeMin() {
        return shMeMin;
    }

    public void setShMeMin(Double shMeMin) {
        this.shMeMin = shMeMin;
    }

    public Double getShMeMax() {
        return shMeMax;
    }

    public void setShMeMax(Double shMeMax) {
        this.shMeMax = shMeMax;
    }

    public int getShMePrice() {
        return shMePrice;
    }

    public void setShMePrice(int shMePrice) {
        this.shMePrice = shMePrice;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shMeID != null ? shMeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShipMethod)) {
            return false;
        }
        ShipMethod other = (ShipMethod) object;
        if ((this.shMeID == null && other.shMeID != null) || (this.shMeID != null && !this.shMeID.equals(other.shMeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.ShipMethod[ shMeID=" + shMeID + " ]";
    }
    
}
