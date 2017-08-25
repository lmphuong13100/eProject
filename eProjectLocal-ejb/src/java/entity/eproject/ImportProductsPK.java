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
public class ImportProductsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdID")
    private int prodID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ImpoID")
    private int impoID;

    public ImportProductsPK() {
    }

    public ImportProductsPK(int prodID, int impoID) {
        this.prodID = prodID;
        this.impoID = impoID;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public int getImpoID() {
        return impoID;
    }

    public void setImpoID(int impoID) {
        this.impoID = impoID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prodID;
        hash += (int) impoID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImportProductsPK)) {
            return false;
        }
        ImportProductsPK other = (ImportProductsPK) object;
        if (this.prodID != other.prodID) {
            return false;
        }
        if (this.impoID != other.impoID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.ImportProductsPK[ prodID=" + prodID + ", impoID=" + impoID + " ]";
    }
    
}
