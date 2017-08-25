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
@Table(name = "Functions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Functions.findAll", query = "SELECT f FROM Functions f")
    , @NamedQuery(name = "Functions.findByDepaID", query = "SELECT f FROM Functions f WHERE f.functionsPK.depaID = :depaID")
    , @NamedQuery(name = "Functions.findByRoleID", query = "SELECT f FROM Functions f WHERE f.functionsPK.roleID = :roleID")
    , @NamedQuery(name = "Functions.findByManagedBrand", query = "SELECT f FROM Functions f WHERE f.managedBrand = :managedBrand")
    , @NamedQuery(name = "Functions.findByManagedProvider", query = "SELECT f FROM Functions f WHERE f.managedProvider = :managedProvider")
    , @NamedQuery(name = "Functions.findByStatistStore", query = "SELECT f FROM Functions f WHERE f.statistStore = :statistStore")
    , @NamedQuery(name = "Functions.findByStatistOrder", query = "SELECT f FROM Functions f WHERE f.statistOrder = :statistOrder")
    , @NamedQuery(name = "Functions.findByStaitstShip", query = "SELECT f FROM Functions f WHERE f.staitstShip = :staitstShip")
    , @NamedQuery(name = "Functions.findByViewProduct", query = "SELECT f FROM Functions f WHERE f.viewProduct = :viewProduct")
    , @NamedQuery(name = "Functions.findByEditProduct", query = "SELECT f FROM Functions f WHERE f.editProduct = :editProduct")
    , @NamedQuery(name = "Functions.findByDeleteProduct", query = "SELECT f FROM Functions f WHERE f.deleteProduct = :deleteProduct")
    , @NamedQuery(name = "Functions.findByAddProduct", query = "SELECT f FROM Functions f WHERE f.addProduct = :addProduct")
    , @NamedQuery(name = "Functions.findByViewStore", query = "SELECT f FROM Functions f WHERE f.viewStore = :viewStore")
    , @NamedQuery(name = "Functions.findByEditStore", query = "SELECT f FROM Functions f WHERE f.editStore = :editStore")
    , @NamedQuery(name = "Functions.findByDeleteStore", query = "SELECT f FROM Functions f WHERE f.deleteStore = :deleteStore")
    , @NamedQuery(name = "Functions.findByAddStore", query = "SELECT f FROM Functions f WHERE f.addStore = :addStore")
    , @NamedQuery(name = "Functions.findByViewShip", query = "SELECT f FROM Functions f WHERE f.viewShip = :viewShip")
    , @NamedQuery(name = "Functions.findByEditShip", query = "SELECT f FROM Functions f WHERE f.editShip = :editShip")
    , @NamedQuery(name = "Functions.findByDeleteShip", query = "SELECT f FROM Functions f WHERE f.deleteShip = :deleteShip")
    , @NamedQuery(name = "Functions.findByAddShip", query = "SELECT f FROM Functions f WHERE f.addShip = :addShip")})
public class Functions implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FunctionsPK functionsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ManagedBrand")
    private boolean managedBrand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ManagedProvider")
    private boolean managedProvider;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatistStore")
    private boolean statistStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StatistOrder")
    private boolean statistOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StaitstShip")
    private boolean staitstShip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ViewProduct")
    private boolean viewProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EditProduct")
    private boolean editProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DeleteProduct")
    private boolean deleteProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AddProduct")
    private boolean addProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ViewStore")
    private boolean viewStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EditStore")
    private boolean editStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DeleteStore")
    private boolean deleteStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AddStore")
    private boolean addStore;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ViewShip")
    private boolean viewShip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EditShip")
    private boolean editShip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DeleteShip")
    private boolean deleteShip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AddShip")
    private boolean addShip;
    @JoinColumn(name = "DepaID", referencedColumnName = "DepaID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Departments departments;
    @JoinColumn(name = "RoleID", referencedColumnName = "RoleID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roles roles;

    public Functions() {
    }

    public Functions(FunctionsPK functionsPK) {
        this.functionsPK = functionsPK;
    }

    public Functions(FunctionsPK functionsPK, boolean managedBrand, boolean managedProvider, boolean statistStore, boolean statistOrder, boolean staitstShip, boolean viewProduct, boolean editProduct, boolean deleteProduct, boolean addProduct, boolean viewStore, boolean editStore, boolean deleteStore, boolean addStore, boolean viewShip, boolean editShip, boolean deleteShip, boolean addShip) {
        this.functionsPK = functionsPK;
        this.managedBrand = managedBrand;
        this.managedProvider = managedProvider;
        this.statistStore = statistStore;
        this.statistOrder = statistOrder;
        this.staitstShip = staitstShip;
        this.viewProduct = viewProduct;
        this.editProduct = editProduct;
        this.deleteProduct = deleteProduct;
        this.addProduct = addProduct;
        this.viewStore = viewStore;
        this.editStore = editStore;
        this.deleteStore = deleteStore;
        this.addStore = addStore;
        this.viewShip = viewShip;
        this.editShip = editShip;
        this.deleteShip = deleteShip;
        this.addShip = addShip;
    }

    public Functions(int depaID, int roleID) {
        this.functionsPK = new FunctionsPK(depaID, roleID);
    }

    public FunctionsPK getFunctionsPK() {
        return functionsPK;
    }

    public void setFunctionsPK(FunctionsPK functionsPK) {
        this.functionsPK = functionsPK;
    }

    public boolean getManagedBrand() {
        return managedBrand;
    }

    public void setManagedBrand(boolean managedBrand) {
        this.managedBrand = managedBrand;
    }

    public boolean getManagedProvider() {
        return managedProvider;
    }

    public void setManagedProvider(boolean managedProvider) {
        this.managedProvider = managedProvider;
    }

    public boolean getStatistStore() {
        return statistStore;
    }

    public void setStatistStore(boolean statistStore) {
        this.statistStore = statistStore;
    }

    public boolean getStatistOrder() {
        return statistOrder;
    }

    public void setStatistOrder(boolean statistOrder) {
        this.statistOrder = statistOrder;
    }

    public boolean getStaitstShip() {
        return staitstShip;
    }

    public void setStaitstShip(boolean staitstShip) {
        this.staitstShip = staitstShip;
    }

    public boolean getViewProduct() {
        return viewProduct;
    }

    public void setViewProduct(boolean viewProduct) {
        this.viewProduct = viewProduct;
    }

    public boolean getEditProduct() {
        return editProduct;
    }

    public void setEditProduct(boolean editProduct) {
        this.editProduct = editProduct;
    }

    public boolean getDeleteProduct() {
        return deleteProduct;
    }

    public void setDeleteProduct(boolean deleteProduct) {
        this.deleteProduct = deleteProduct;
    }

    public boolean getAddProduct() {
        return addProduct;
    }

    public void setAddProduct(boolean addProduct) {
        this.addProduct = addProduct;
    }

    public boolean getViewStore() {
        return viewStore;
    }

    public void setViewStore(boolean viewStore) {
        this.viewStore = viewStore;
    }

    public boolean getEditStore() {
        return editStore;
    }

    public void setEditStore(boolean editStore) {
        this.editStore = editStore;
    }

    public boolean getDeleteStore() {
        return deleteStore;
    }

    public void setDeleteStore(boolean deleteStore) {
        this.deleteStore = deleteStore;
    }

    public boolean getAddStore() {
        return addStore;
    }

    public void setAddStore(boolean addStore) {
        this.addStore = addStore;
    }

    public boolean getViewShip() {
        return viewShip;
    }

    public void setViewShip(boolean viewShip) {
        this.viewShip = viewShip;
    }

    public boolean getEditShip() {
        return editShip;
    }

    public void setEditShip(boolean editShip) {
        this.editShip = editShip;
    }

    public boolean getDeleteShip() {
        return deleteShip;
    }

    public void setDeleteShip(boolean deleteShip) {
        this.deleteShip = deleteShip;
    }

    public boolean getAddShip() {
        return addShip;
    }

    public void setAddShip(boolean addShip) {
        this.addShip = addShip;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (functionsPK != null ? functionsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Functions)) {
            return false;
        }
        Functions other = (Functions) object;
        if ((this.functionsPK == null && other.functionsPK != null) || (this.functionsPK != null && !this.functionsPK.equals(other.functionsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Functions[ functionsPK=" + functionsPK + " ]";
    }
    
}
