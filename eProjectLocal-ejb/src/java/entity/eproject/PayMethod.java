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
@Table(name = "PayMethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PayMethod.findAll", query = "SELECT p FROM PayMethod p")
    , @NamedQuery(name = "PayMethod.findByPayMID", query = "SELECT p FROM PayMethod p WHERE p.payMID = :payMID")
    , @NamedQuery(name = "PayMethod.findByPayMDescription", query = "SELECT p FROM PayMethod p WHERE p.payMDescription = :payMDescription")})
public class PayMethod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PayMID")
    private Integer payMID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PayMDescription")
    private String payMDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payMID")
    private Collection<Orders> ordersCollection;

    public PayMethod() {
    }

    public PayMethod(Integer payMID) {
        this.payMID = payMID;
    }

    public PayMethod(Integer payMID, String payMDescription) {
        this.payMID = payMID;
        this.payMDescription = payMDescription;
    }

    public Integer getPayMID() {
        return payMID;
    }

    public void setPayMID(Integer payMID) {
        this.payMID = payMID;
    }

    public String getPayMDescription() {
        return payMDescription;
    }

    public void setPayMDescription(String payMDescription) {
        this.payMDescription = payMDescription;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (payMID != null ? payMID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayMethod)) {
            return false;
        }
        PayMethod other = (PayMethod) object;
        if ((this.payMID == null && other.payMID != null) || (this.payMID != null && !this.payMID.equals(other.payMID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.PayMethod[ payMID=" + payMID + " ]";
    }
    
}
