/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author minhp
 */
@Entity
@Table(name = "Orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrdeID", query = "SELECT o FROM Orders o WHERE o.ordeID = :ordeID")
    , @NamedQuery(name = "Orders.findByOrdeAddress", query = "SELECT o FROM Orders o WHERE o.ordeAddress = :ordeAddress")
    , @NamedQuery(name = "Orders.findByOrdeDate", query = "SELECT o FROM Orders o WHERE o.ordeDate = :ordeDate")
    , @NamedQuery(name = "Orders.findByOrdeReceive", query = "SELECT o FROM Orders o WHERE o.ordeReceive = :ordeReceive")
    , @NamedQuery(name = "Orders.findByCustReceive", query = "SELECT o FROM Orders o WHERE o.custReceive = :custReceive")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdeID")
    private Integer ordeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "OrdeAddress")
    private String ordeAddress;
    @Column(name = "OrdeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordeDate;
    @Size(max = 10)
    @Column(name = "OrdeReceive")
    private String ordeReceive;
    @Size(max = 10)
    @Column(name = "CustReceive")
    private String custReceive;
    @JoinTable(name = "ShipOrder", joinColumns = {
        @JoinColumn(name = "OrdeID", referencedColumnName = "OrdeID")}, inverseJoinColumns = {
        @JoinColumn(name = "ShipID", referencedColumnName = "ShipID")})
    @ManyToMany
    private Collection<Shippers> shippersCollection;
    @JoinColumn(name = "CustID", referencedColumnName = "CustID")
    @ManyToOne(optional = false)
    private Customers custID;
    @JoinColumn(name = "PayMID", referencedColumnName = "PayMID")
    @ManyToOne(optional = false)
    private PayMethod payMID;
    @JoinColumn(name = "ShMeID", referencedColumnName = "ShMeID")
    @ManyToOne(optional = false)
    private ShipMethod shMeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
    private Collection<OrderProduct> orderProductCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordeID")
    private Collection<ExportProducts> exportProductsCollection;

    public Orders() {
    }

    public Orders(Integer ordeID) {
        this.ordeID = ordeID;
    }

    public Orders(Integer ordeID, String ordeAddress) {
        this.ordeID = ordeID;
        this.ordeAddress = ordeAddress;
    }

    public Integer getOrdeID() {
        return ordeID;
    }

    public void setOrdeID(Integer ordeID) {
        this.ordeID = ordeID;
    }

    public String getOrdeAddress() {
        return ordeAddress;
    }

    public void setOrdeAddress(String ordeAddress) {
        this.ordeAddress = ordeAddress;
    }

    public Date getOrdeDate() {
        return ordeDate;
    }

    public void setOrdeDate(Date ordeDate) {
        this.ordeDate = ordeDate;
    }

    public String getOrdeReceive() {
        return ordeReceive;
    }

    public void setOrdeReceive(String ordeReceive) {
        this.ordeReceive = ordeReceive;
    }

    public String getCustReceive() {
        return custReceive;
    }

    public void setCustReceive(String custReceive) {
        this.custReceive = custReceive;
    }

    @XmlTransient
    public Collection<Shippers> getShippersCollection() {
        return shippersCollection;
    }

    public void setShippersCollection(Collection<Shippers> shippersCollection) {
        this.shippersCollection = shippersCollection;
    }

    public Customers getCustID() {
        return custID;
    }

    public void setCustID(Customers custID) {
        this.custID = custID;
    }

    public PayMethod getPayMID() {
        return payMID;
    }

    public void setPayMID(PayMethod payMID) {
        this.payMID = payMID;
    }

    public ShipMethod getShMeID() {
        return shMeID;
    }

    public void setShMeID(ShipMethod shMeID) {
        this.shMeID = shMeID;
    }

    @XmlTransient
    public Collection<OrderProduct> getOrderProductCollection() {
        return orderProductCollection;
    }

    public void setOrderProductCollection(Collection<OrderProduct> orderProductCollection) {
        this.orderProductCollection = orderProductCollection;
    }

    @XmlTransient
    public Collection<ExportProducts> getExportProductsCollection() {
        return exportProductsCollection;
    }

    public void setExportProductsCollection(Collection<ExportProducts> exportProductsCollection) {
        this.exportProductsCollection = exportProductsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordeID != null ? ordeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.ordeID == null && other.ordeID != null) || (this.ordeID != null && !this.ordeID.equals(other.ordeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Orders[ ordeID=" + ordeID + " ]";
    }
    
}
