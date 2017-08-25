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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByProdID", query = "SELECT p FROM Products p WHERE p.prodID = :prodID")
    , @NamedQuery(name = "Products.findByProdName", query = "SELECT p FROM Products p WHERE p.prodName = :prodName")
    , @NamedQuery(name = "Products.findByProdPrice", query = "SELECT p FROM Products p WHERE p.prodPrice = :prodPrice")
    , @NamedQuery(name = "Products.findByProdImage", query = "SELECT p FROM Products p WHERE p.prodImage = :prodImage")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdID")
    private Integer prodID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ProdName")
    private String prodName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdPrice")
    private int prodPrice;
    @Size(max = 200)
    @Column(name = "ProdImage")
    private String prodImage;
    @JoinColumn(name = "BranID", referencedColumnName = "BranID")
    @ManyToOne(optional = false)
    private Brands branID;
    @JoinColumn(name = "CateID", referencedColumnName = "CateID")
    @ManyToOne(optional = false)
    private Categories cateID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Collection<OrderProduct> orderProductCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Collection<Storages> storagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private Collection<ImportProducts> importProductsCollection;

    public Products() {
    }

    public Products(Integer prodID) {
        this.prodID = prodID;
    }

    public Products(Integer prodID, String prodName, int prodPrice) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public Integer getProdID() {
        return prodID;
    }

    public void setProdID(Integer prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getProdImage() {
        return prodImage;
    }

    public void setProdImage(String prodImage) {
        this.prodImage = prodImage;
    }

    public Brands getBranID() {
        return branID;
    }

    public void setBranID(Brands branID) {
        this.branID = branID;
    }

    public Categories getCateID() {
        return cateID;
    }

    public void setCateID(Categories cateID) {
        this.cateID = cateID;
    }

    @XmlTransient
    public Collection<OrderProduct> getOrderProductCollection() {
        return orderProductCollection;
    }

    public void setOrderProductCollection(Collection<OrderProduct> orderProductCollection) {
        this.orderProductCollection = orderProductCollection;
    }

    @XmlTransient
    public Collection<Storages> getStoragesCollection() {
        return storagesCollection;
    }

    public void setStoragesCollection(Collection<Storages> storagesCollection) {
        this.storagesCollection = storagesCollection;
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
        hash += (prodID != null ? prodID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.prodID == null && other.prodID != null) || (this.prodID != null && !this.prodID.equals(other.prodID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Products[ prodID=" + prodID + " ]";
    }
    
}
