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
@Table(name = "Stores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stores.findAll", query = "SELECT s FROM Stores s")
    , @NamedQuery(name = "Stores.findByStorID", query = "SELECT s FROM Stores s WHERE s.storID = :storID")
    , @NamedQuery(name = "Stores.findByStorLocate", query = "SELECT s FROM Stores s WHERE s.storLocate = :storLocate")
    , @NamedQuery(name = "Stores.findByStorBin", query = "SELECT s FROM Stores s WHERE s.storBin = :storBin")})
public class Stores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StorID")
    private Integer storID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "StorLocate")
    private String storLocate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StorBin")
    private int storBin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stores")
    private Collection<Storages> storagesCollection;

    public Stores() {
    }

    public Stores(Integer storID) {
        this.storID = storID;
    }

    public Stores(Integer storID, String storLocate, int storBin) {
        this.storID = storID;
        this.storLocate = storLocate;
        this.storBin = storBin;
    }

    public Integer getStorID() {
        return storID;
    }

    public void setStorID(Integer storID) {
        this.storID = storID;
    }

    public String getStorLocate() {
        return storLocate;
    }

    public void setStorLocate(String storLocate) {
        this.storLocate = storLocate;
    }

    public int getStorBin() {
        return storBin;
    }

    public void setStorBin(int storBin) {
        this.storBin = storBin;
    }

    @XmlTransient
    public Collection<Storages> getStoragesCollection() {
        return storagesCollection;
    }

    public void setStoragesCollection(Collection<Storages> storagesCollection) {
        this.storagesCollection = storagesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storID != null ? storID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stores)) {
            return false;
        }
        Stores other = (Stores) object;
        if ((this.storID == null && other.storID != null) || (this.storID != null && !this.storID.equals(other.storID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Stores[ storID=" + storID + " ]";
    }
    
}
