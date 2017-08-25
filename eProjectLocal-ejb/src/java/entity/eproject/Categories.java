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
@Table(name = "Categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
    , @NamedQuery(name = "Categories.findByCateID", query = "SELECT c FROM Categories c WHERE c.cateID = :cateID")
    , @NamedQuery(name = "Categories.findByCateName", query = "SELECT c FROM Categories c WHERE c.cateName = :cateName")
    , @NamedQuery(name = "Categories.findByCateImage", query = "SELECT c FROM Categories c WHERE c.cateImage = :cateImage")})
public class Categories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CateID")
    private Integer cateID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CateName")
    private String cateName;
    @Size(max = 200)
    @Column(name = "CateImage")
    private String cateImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cateID")
    private Collection<Products> productsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cateID")
    private Collection<Promotions> promotionsCollection;

    public Categories() {
    }

    public Categories(Integer cateID) {
        this.cateID = cateID;
    }

    public Categories(Integer cateID, String cateName) {
        this.cateID = cateID;
        this.cateName = cateName;
    }

    public Integer getCateID() {
        return cateID;
    }

    public void setCateID(Integer cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateImage() {
        return cateImage;
    }

    public void setCateImage(String cateImage) {
        this.cateImage = cateImage;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @XmlTransient
    public Collection<Promotions> getPromotionsCollection() {
        return promotionsCollection;
    }

    public void setPromotionsCollection(Collection<Promotions> promotionsCollection) {
        this.promotionsCollection = promotionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateID != null ? cateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.cateID == null && other.cateID != null) || (this.cateID != null && !this.cateID.equals(other.cateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Categories[ cateID=" + cateID + " ]";
    }
    
}
