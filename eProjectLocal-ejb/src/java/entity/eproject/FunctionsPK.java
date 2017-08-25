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
public class FunctionsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "DepaID")
    private int depaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RoleID")
    private int roleID;

    public FunctionsPK() {
    }

    public FunctionsPK(int depaID, int roleID) {
        this.depaID = depaID;
        this.roleID = roleID;
    }

    public int getDepaID() {
        return depaID;
    }

    public void setDepaID(int depaID) {
        this.depaID = depaID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) depaID;
        hash += (int) roleID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FunctionsPK)) {
            return false;
        }
        FunctionsPK other = (FunctionsPK) object;
        if (this.depaID != other.depaID) {
            return false;
        }
        if (this.roleID != other.roleID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.FunctionsPK[ depaID=" + depaID + ", roleID=" + roleID + " ]";
    }
    
}
