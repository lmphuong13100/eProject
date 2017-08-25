/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Shippers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shippers.findAll", query = "SELECT s FROM Shippers s")
    , @NamedQuery(name = "Shippers.findByShipID", query = "SELECT s FROM Shippers s WHERE s.shipID = :shipID")
    , @NamedQuery(name = "Shippers.findByShipName", query = "SELECT s FROM Shippers s WHERE s.shipName = :shipName")
    , @NamedQuery(name = "Shippers.findByShipLocation", query = "SELECT s FROM Shippers s WHERE s.shipLocation = :shipLocation")
    , @NamedQuery(name = "Shippers.findByShipImage", query = "SELECT s FROM Shippers s WHERE s.shipImage = :shipImage")})
public class Shippers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ShipID")
    private Integer shipID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ShipName")
    private String shipName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ShipLocation")
    private String shipLocation;
    @Size(max = 200)
    @Column(name = "ShipImage")
    private String shipImage;
    @ManyToMany(mappedBy = "shippersCollection")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "DepaID", referencedColumnName = "DepaID")
    @ManyToOne(optional = false)
    private Departments depaID;

    public Shippers() {
    }

    public Shippers(Integer shipID) {
        this.shipID = shipID;
    }

    public Shippers(Integer shipID, String shipName, String shipLocation) {
        this.shipID = shipID;
        this.shipName = shipName;
        this.shipLocation = shipLocation;
    }

    public Integer getShipID() {
        return shipID;
    }

    public void setShipID(Integer shipID) {
        this.shipID = shipID;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(String shipLocation) {
        this.shipLocation = shipLocation;
    }

    public String getShipImage() {
        return shipImage;
    }

    public void setShipImage(String shipImage) {
        this.shipImage = shipImage;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    public Departments getDepaID() {
        return depaID;
    }

    public void setDepaID(Departments depaID) {
        this.depaID = depaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipID != null ? shipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shippers)) {
            return false;
        }
        Shippers other = (Shippers) object;
        if ((this.shipID == null && other.shipID != null) || (this.shipID != null && !this.shipID.equals(other.shipID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Shippers[ shipID=" + shipID + " ]";
    }
    
}
