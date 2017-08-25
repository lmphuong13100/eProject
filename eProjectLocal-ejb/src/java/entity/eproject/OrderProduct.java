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
@Table(name = "OrderProduct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderProduct.findAll", query = "SELECT o FROM OrderProduct o")
    , @NamedQuery(name = "OrderProduct.findByOrdeID", query = "SELECT o FROM OrderProduct o WHERE o.orderProductPK.ordeID = :ordeID")
    , @NamedQuery(name = "OrderProduct.findByProdID", query = "SELECT o FROM OrderProduct o WHERE o.orderProductPK.prodID = :prodID")
    , @NamedQuery(name = "OrderProduct.findByQuantity", query = "SELECT o FROM OrderProduct o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "OrderProduct.findByGia", query = "SELECT o FROM OrderProduct o WHERE o.gia = :gia")})
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderProductPK orderProductPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "gia")
    private Integer gia;
    @JoinColumn(name = "OrdeID", referencedColumnName = "OrdeID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orders orders;
    @JoinColumn(name = "ProdID", referencedColumnName = "ProdID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;

    public OrderProduct() {
    }

    public OrderProduct(OrderProductPK orderProductPK) {
        this.orderProductPK = orderProductPK;
    }

    public OrderProduct(OrderProductPK orderProductPK, int quantity) {
        this.orderProductPK = orderProductPK;
        this.quantity = quantity;
    }

    public OrderProduct(int ordeID, int prodID) {
        this.orderProductPK = new OrderProductPK(ordeID, prodID);
    }

    public OrderProductPK getOrderProductPK() {
        return orderProductPK;
    }

    public void setOrderProductPK(OrderProductPK orderProductPK) {
        this.orderProductPK = orderProductPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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
        hash += (orderProductPK != null ? orderProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderProduct)) {
            return false;
        }
        OrderProduct other = (OrderProduct) object;
        if ((this.orderProductPK == null && other.orderProductPK != null) || (this.orderProductPK != null && !this.orderProductPK.equals(other.orderProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.OrderProduct[ orderProductPK=" + orderProductPK + " ]";
    }
    
}
