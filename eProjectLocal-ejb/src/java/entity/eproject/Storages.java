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
@Table(name = "Storages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storages.findAll", query = "SELECT s FROM Storages s")
    , @NamedQuery(name = "Storages.findByProdID", query = "SELECT s FROM Storages s WHERE s.storagesPK.prodID = :prodID")
    , @NamedQuery(name = "Storages.findByStorID", query = "SELECT s FROM Storages s WHERE s.storagesPK.storID = :storID")
    , @NamedQuery(name = "Storages.findByQuantity", query = "SELECT s FROM Storages s WHERE s.quantity = :quantity")})
public class Storages implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StoragesPK storagesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "ProdID", referencedColumnName = "ProdID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;
    @JoinColumn(name = "StorID", referencedColumnName = "StorID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Stores stores;

    public Storages() {
    }

    public Storages(StoragesPK storagesPK) {
        this.storagesPK = storagesPK;
    }

    public Storages(StoragesPK storagesPK, int quantity) {
        this.storagesPK = storagesPK;
        this.quantity = quantity;
    }

    public Storages(int prodID, int storID) {
        this.storagesPK = new StoragesPK(prodID, storID);
    }

    public StoragesPK getStoragesPK() {
        return storagesPK;
    }

    public void setStoragesPK(StoragesPK storagesPK) {
        this.storagesPK = storagesPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Stores getStores() {
        return stores;
    }

    public void setStores(Stores stores) {
        this.stores = stores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storagesPK != null ? storagesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storages)) {
            return false;
        }
        Storages other = (Storages) object;
        if ((this.storagesPK == null && other.storagesPK != null) || (this.storagesPK != null && !this.storagesPK.equals(other.storagesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Storages[ storagesPK=" + storagesPK + " ]";
    }
    
}
