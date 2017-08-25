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
public class OrderProductPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdeID")
    private int ordeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProdID")
    private int prodID;

    public OrderProductPK() {
    }

    public OrderProductPK(int ordeID, int prodID) {
        this.ordeID = ordeID;
        this.prodID = prodID;
    }

    public int getOrdeID() {
        return ordeID;
    }

    public void setOrdeID(int ordeID) {
        this.ordeID = ordeID;
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ordeID;
        hash += (int) prodID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderProductPK)) {
            return false;
        }
        OrderProductPK other = (OrderProductPK) object;
        if (this.ordeID != other.ordeID) {
            return false;
        }
        if (this.prodID != other.prodID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.OrderProductPK[ ordeID=" + ordeID + ", prodID=" + prodID + " ]";
    }
    
}
