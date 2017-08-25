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
@Table(name = "Departments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departments.findAll", query = "SELECT d FROM Departments d")
    , @NamedQuery(name = "Departments.findByDepaID", query = "SELECT d FROM Departments d WHERE d.depaID = :depaID")
    , @NamedQuery(name = "Departments.findByDepaName", query = "SELECT d FROM Departments d WHERE d.depaName = :depaName")
    , @NamedQuery(name = "Departments.findByDepaDescription", query = "SELECT d FROM Departments d WHERE d.depaDescription = :depaDescription")})
public class Departments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DepaID")
    private Integer depaID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DepaName")
    private String depaName;
    @Size(max = 500)
    @Column(name = "DepaDescription")
    private String depaDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depaID")
    private Collection<Shippers> shippersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depaID")
    private Collection<Employees> employeesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departments")
    private Collection<Functions> functionsCollection;

    public Departments() {
    }

    public Departments(Integer depaID) {
        this.depaID = depaID;
    }

    public Departments(Integer depaID, String depaName) {
        this.depaID = depaID;
        this.depaName = depaName;
    }

    public Integer getDepaID() {
        return depaID;
    }

    public void setDepaID(Integer depaID) {
        this.depaID = depaID;
    }

    public String getDepaName() {
        return depaName;
    }

    public void setDepaName(String depaName) {
        this.depaName = depaName;
    }

    public String getDepaDescription() {
        return depaDescription;
    }

    public void setDepaDescription(String depaDescription) {
        this.depaDescription = depaDescription;
    }

    @XmlTransient
    public Collection<Shippers> getShippersCollection() {
        return shippersCollection;
    }

    public void setShippersCollection(Collection<Shippers> shippersCollection) {
        this.shippersCollection = shippersCollection;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @XmlTransient
    public Collection<Functions> getFunctionsCollection() {
        return functionsCollection;
    }

    public void setFunctionsCollection(Collection<Functions> functionsCollection) {
        this.functionsCollection = functionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depaID != null ? depaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departments)) {
            return false;
        }
        Departments other = (Departments) object;
        if ((this.depaID == null && other.depaID != null) || (this.depaID != null && !this.depaID.equals(other.depaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Departments[ depaID=" + depaID + " ]";
    }
    
}
