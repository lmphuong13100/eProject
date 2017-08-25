/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author minhp
 */
@Embeddable
public class StoragesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdID")
    private int prodID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StorID")
    private int storID;

    public StoragesPK() {
    }

    public StoragesPK(int prodID, int storID) {
        this.prodID = prodID;
        this.storID = storID;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public int getStorID() {
        return storID;
    }

    public void setStorID(int storID) {
        this.storID = storID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prodID;
        hash += (int) storID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StoragesPK)) {
            return false;
        }
        StoragesPK other = (StoragesPK) object;
        if (this.prodID != other.prodID) {
            return false;
        }
        if (this.storID != other.storID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.StoragesPK[ prodID=" + prodID + ", storID=" + storID + " ]";
    }
    
}
