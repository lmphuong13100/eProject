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
@Table(name = "Providers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Providers.findAll", query = "SELECT p FROM Providers p")
    , @NamedQuery(name = "Providers.findByProvID", query = "SELECT p FROM Providers p WHERE p.provID = :provID")
    , @NamedQuery(name = "Providers.findByProvName", query = "SELECT p FROM Providers p WHERE p.provName = :provName")
    , @NamedQuery(name = "Providers.findByProvAddress", query = "SELECT p FROM Providers p WHERE p.provAddress = :provAddress")
    , @NamedQuery(name = "Providers.findByProvPhone", query = "SELECT p FROM Providers p WHERE p.provPhone = :provPhone")
    , @NamedQuery(name = "Providers.findByProviEmail", query = "SELECT p FROM Providers p WHERE p.proviEmail = :proviEmail")
    , @NamedQuery(name = "Providers.findByProvImage", query = "SELECT p FROM Providers p WHERE p.provImage = :provImage")})
public class Providers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProvID")
    private Integer provID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "ProvName")
    private String provName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ProvAddress")
    private String provAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ProvPhone")
    private String provPhone;
    @Size(max = 100)
    @Column(name = "ProviEmail")
    private String proviEmail;
    @Size(max = 200)
    @Column(name = "ProvImage")
    private String provImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provID")
    private Collection<Imports> importsCollection;

    public Providers() {
    }

    public Providers(Integer provID) {
        this.provID = provID;
    }

    public Providers(Integer provID, String provName, String provAddress, String provPhone) {
        this.provID = provID;
        this.provName = provName;
        this.provAddress = provAddress;
        this.provPhone = provPhone;
    }

    public Integer getProvID() {
        return provID;
    }

    public void setProvID(Integer provID) {
        this.provID = provID;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public String getProvAddress() {
        return provAddress;
    }

    public void setProvAddress(String provAddress) {
        this.provAddress = provAddress;
    }

    public String getProvPhone() {
        return provPhone;
    }

    public void setProvPhone(String provPhone) {
        this.provPhone = provPhone;
    }

    public String getProviEmail() {
        return proviEmail;
    }

    public void setProviEmail(String proviEmail) {
        this.proviEmail = proviEmail;
    }

    public String getProvImage() {
        return provImage;
    }

    public void setProvImage(String provImage) {
        this.provImage = provImage;
    }

    @XmlTransient
    public Collection<Imports> getImportsCollection() {
        return importsCollection;
    }

    public void setImportsCollection(Collection<Imports> importsCollection) {
        this.importsCollection = importsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provID != null ? provID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Providers)) {
            return false;
        }
        Providers other = (Providers) object;
        if ((this.provID == null && other.provID != null) || (this.provID != null && !this.provID.equals(other.provID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Providers[ provID=" + provID + " ]";
    }
    
}
