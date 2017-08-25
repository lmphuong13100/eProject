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
@Table(name = "Brands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brands.findAll", query = "SELECT b FROM Brands b")
    , @NamedQuery(name = "Brands.findByBranID", query = "SELECT b FROM Brands b WHERE b.branID = :branID")
    , @NamedQuery(name = "Brands.findByBranName", query = "SELECT b FROM Brands b WHERE b.branName = :branName")
    , @NamedQuery(name = "Brands.findByBranDescription", query = "SELECT b FROM Brands b WHERE b.branDescription = :branDescription")
    , @NamedQuery(name = "Brands.findByBranImage", query = "SELECT b FROM Brands b WHERE b.branImage = :branImage")})
public class Brands implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BranID")
    private Integer branID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "BranName")
    private String branName;
    @Size(max = 500)
    @Column(name = "BranDescription")
    private String branDescription;
    @Size(max = 200)
    @Column(name = "BranImage")
    private String branImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branID")
    private Collection<Products> productsCollection;

    public Brands() {
    }

    public Brands(Integer branID) {
        this.branID = branID;
    }

    public Brands(Integer branID, String branName) {
        this.branID = branID;
        this.branName = branName;
    }

    public Integer getBranID() {
        return branID;
    }

    public void setBranID(Integer branID) {
        this.branID = branID;
    }

    public String getBranName() {
        return branName;
    }

    public void setBranName(String branName) {
        this.branName = branName;
    }

    public String getBranDescription() {
        return branDescription;
    }

    public void setBranDescription(String branDescription) {
        this.branDescription = branDescription;
    }

    public String getBranImage() {
        return branImage;
    }

    public void setBranImage(String branImage) {
        this.branImage = branImage;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branID != null ? branID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brands)) {
            return false;
        }
        Brands other = (Brands) object;
        if ((this.branID == null && other.branID != null) || (this.branID != null && !this.branID.equals(other.branID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Brands[ branID=" + branID + " ]";
    }
    
}
