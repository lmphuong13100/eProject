/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minhp
 */
@Entity
@Table(name = "Imports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imports.findAll", query = "SELECT i FROM Imports i")
    , @NamedQuery(name = "Imports.findByImpoID", query = "SELECT i FROM Imports i WHERE i.impoID = :impoID")
    , @NamedQuery(name = "Imports.findByImpoDate", query = "SELECT i FROM Imports i WHERE i.impoDate = :impoDate")
    , @NamedQuery(name = "Imports.findByImpoPrice", query = "SELECT i FROM Imports i WHERE i.impoPrice = :impoPrice")})
public class Imports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImpoID")
    private Integer impoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImpoDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date impoDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImpoPrice")
    private int impoPrice;
    @JoinColumn(name = "EmplID", referencedColumnName = "EmplID")
    @ManyToOne(optional = false)
    private Employees emplID;
    @JoinColumn(name = "ProvID", referencedColumnName = "ProvID")
    @ManyToOne(optional = false)
    private Providers provID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "imports")
    private Collection<ImportProducts> importProductsCollection;

    public Imports() {
    }

    public Imports(Integer impoID) {
        this.impoID = impoID;
    }

    public Imports(Integer impoID, Date impoDate, int impoPrice) {
        this.impoID = impoID;
        this.impoDate = impoDate;
        this.impoPrice = impoPrice;
    }

    public Integer getImpoID() {
        return impoID;
    }

    public void setImpoID(Integer impoID) {
        this.impoID = impoID;
    }

    public Date getImpoDate() {
        return impoDate;
    }

    public void setImpoDate(Date impoDate) {
        this.impoDate = impoDate;
    }

    public int getImpoPrice() {
        return impoPrice;
    }

    public void setImpoPrice(int impoPrice) {
        this.impoPrice = impoPrice;
    }

    public Employees getEmplID() {
        return emplID;
    }

    public void setEmplID(Employees emplID) {
        this.emplID = emplID;
    }

    public Providers getProvID() {
        return provID;
    }

    public void setProvID(Providers provID) {
        this.provID = provID;
    }

    @XmlTransient
    public Collection<ImportProducts> getImportProductsCollection() {
        return importProductsCollection;
    }

    public void setImportProductsCollection(Collection<ImportProducts> importProductsCollection) {
        this.importProductsCollection = importProductsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (impoID != null ? impoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imports)) {
            return false;
        }
        Imports other = (Imports) object;
        if ((this.impoID == null && other.impoID != null) || (this.impoID != null && !this.impoID.equals(other.impoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Imports[ impoID=" + impoID + " ]";
    }
    
}
