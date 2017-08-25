/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minhp
 */
@Entity
@Table(name = "ImportProducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImportProducts.findAll", query = "SELECT i FROM ImportProducts i")
    , @NamedQuery(name = "ImportProducts.findByProdID", query = "SELECT i FROM ImportProducts i WHERE i.importProductsPK.prodID = :prodID")
    , @NamedQuery(name = "ImportProducts.findByImpoID", query = "SELECT i FROM ImportProducts i WHERE i.importProductsPK.impoID = :impoID")
    , @NamedQuery(name = "ImportProducts.findByQuantity", query = "SELECT i FROM ImportProducts i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "ImportProducts.findByImPrPrice", query = "SELECT i FROM ImportProducts i WHERE i.imPrPrice = :imPrPrice")})
public class ImportProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImportProductsPK importProductsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImPrPrice")
    private int imPrPrice;
    @JoinColumn(name = "ImpoID", referencedColumnName = "ImpoID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Imports imports;
    @JoinColumn(name = "ProdID", referencedColumnName = "ProdID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;

    public ImportProducts() {
    }

    public ImportProducts(ImportProductsPK importProductsPK) {
        this.importProductsPK = importProductsPK;
    }

    public ImportProducts(ImportProductsPK importProductsPK, int quantity, int imPrPrice) {
        this.importProductsPK = importProductsPK;
        this.quantity = quantity;
        this.imPrPrice = imPrPrice;
    }

    public ImportProducts(int prodID, int impoID) {
        this.importProductsPK = new ImportProductsPK(prodID, impoID);
    }

    public ImportProductsPK getImportProductsPK() {
        return importProductsPK;
    }

    public void setImportProductsPK(ImportProductsPK importProductsPK) {
        this.importProductsPK = importProductsPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImPrPrice() {
        return imPrPrice;
    }

    public void setImPrPrice(int imPrPrice) {
        this.imPrPrice = imPrPrice;
    }

    public Imports getImports() {
        return imports;
    }

    public void setImports(Imports imports) {
        this.imports = imports;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (importProductsPK != null ? importProductsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImportProducts)) {
            return false;
        }
        ImportProducts other = (ImportProducts) object;
        if ((this.importProductsPK == null && other.importProductsPK != null) || (this.importProductsPK != null && !this.importProductsPK.equals(other.importProductsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.ImportProducts[ importProductsPK=" + importProductsPK + " ]";
    }
    
}
