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
@Table(name = "Customers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCustID", query = "SELECT c FROM Customers c WHERE c.custID = :custID")
    , @NamedQuery(name = "Customers.findByCustName", query = "SELECT c FROM Customers c WHERE c.custName = :custName")
    , @NamedQuery(name = "Customers.findByCustAddress", query = "SELECT c FROM Customers c WHERE c.custAddress = :custAddress")
    , @NamedQuery(name = "Customers.findByCustPhone", query = "SELECT c FROM Customers c WHERE c.custPhone = :custPhone")
    , @NamedQuery(name = "Customers.findByCustPassword", query = "SELECT c FROM Customers c WHERE c.custPassword = :custPassword")
    , @NamedQuery(name = "Customers.findByCustBirthDay", query = "SELECT c FROM Customers c WHERE c.custBirthDay = :custBirthDay")
    , @NamedQuery(name = "Customers.findByCustGender", query = "SELECT c FROM Customers c WHERE c.custGender = :custGender")
    , @NamedQuery(name = "Customers.findByCustImage", query = "SELECT c FROM Customers c WHERE c.custImage = :custImage")
    , @NamedQuery(name = "Customers.findByCustEmail", query = "SELECT c FROM Customers c WHERE c.custEmail = :custEmail")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustID")
    private Integer custID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CustName")
    private String custName;
    @Size(max = 200)
    @Column(name = "CustAddress")
    private String custAddress;
    @Size(max = 20)
    @Column(name = "CustPhone")
    private String custPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CustPassword")
    private String custPassword;
    @Size(max = 10)
    @Column(name = "CustBirthDay")
    private String custBirthDay;
    @Column(name = "CustGender")
    private Integer custGender;
    @Size(max = 100)
    @Column(name = "CustImage")
    private String custImage;
    @Size(max = 200)
    @Column(name = "CustEmail")
    private String custEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custID")
    private Collection<Orders> ordersCollection;

    public Customers() {
    }

    public Customers(Integer custID) {
        this.custID = custID;
    }

    public Customers(Integer custID, String custName, String custPassword) {
        this.custID = custID;
        this.custName = custName;
        this.custPassword = custPassword;
    }

    public Integer getCustID() {
        return custID;
    }

    public void setCustID(Integer custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustBirthDay() {
        return custBirthDay;
    }

    public void setCustBirthDay(String custBirthDay) {
        this.custBirthDay = custBirthDay;
    }

    public Integer getCustGender() {
        return custGender;
    }

    public void setCustGender(Integer custGender) {
        this.custGender = custGender;
    }

    public String getCustImage() {
        return custImage;
    }

    public void setCustImage(String custImage) {
        this.custImage = custImage;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
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
        hash += (custID != null ? custID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.custID == null && other.custID != null) || (this.custID != null && !this.custID.equals(other.custID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Customers[ custID=" + custID + " ]";
    }
    
}
