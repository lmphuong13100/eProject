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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmplID", query = "SELECT e FROM Employees e WHERE e.emplID = :emplID")
    , @NamedQuery(name = "Employees.findByEmplName", query = "SELECT e FROM Employees e WHERE e.emplName = :emplName")
    , @NamedQuery(name = "Employees.findByEmplAddress", query = "SELECT e FROM Employees e WHERE e.emplAddress = :emplAddress")
    , @NamedQuery(name = "Employees.findByEmplPhone", query = "SELECT e FROM Employees e WHERE e.emplPhone = :emplPhone")
    , @NamedQuery(name = "Employees.findByEmplEmail", query = "SELECT e FROM Employees e WHERE e.emplEmail = :emplEmail")
    , @NamedQuery(name = "Employees.findByWorkDate", query = "SELECT e FROM Employees e WHERE e.workDate = :workDate")
    , @NamedQuery(name = "Employees.findByEmplImage", query = "SELECT e FROM Employees e WHERE e.emplImage = :emplImage")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmplID")
    private Integer emplID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EmplName")
    private String emplName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "EmplAddress")
    private String emplAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EmplPhone")
    private String emplPhone;
    @Size(max = 100)
    @Column(name = "EmplEmail")
    private String emplEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "WorkDate")
    private String workDate;
    @Size(max = 100)
    @Column(name = "EmplImage")
    private String emplImage;
    @JoinColumn(name = "DepaID", referencedColumnName = "DepaID")
    @ManyToOne(optional = false)
    private Departments depaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emplID")
    private Collection<ExportProducts> exportProductsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emplID")
    private Collection<Imports> importsCollection;

    public Employees() {
    }

    public Employees(Integer emplID) {
        this.emplID = emplID;
    }

    public Employees(Integer emplID, String emplName, String emplAddress, String emplPhone, String workDate) {
        this.emplID = emplID;
        this.emplName = emplName;
        this.emplAddress = emplAddress;
        this.emplPhone = emplPhone;
        this.workDate = workDate;
    }

    public Integer getEmplID() {
        return emplID;
    }

    public void setEmplID(Integer emplID) {
        this.emplID = emplID;
    }

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    public String getEmplAddress() {
        return emplAddress;
    }

    public void setEmplAddress(String emplAddress) {
        this.emplAddress = emplAddress;
    }

    public String getEmplPhone() {
        return emplPhone;
    }

    public void setEmplPhone(String emplPhone) {
        this.emplPhone = emplPhone;
    }

    public String getEmplEmail() {
        return emplEmail;
    }

    public void setEmplEmail(String emplEmail) {
        this.emplEmail = emplEmail;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getEmplImage() {
        return emplImage;
    }

    public void setEmplImage(String emplImage) {
        this.emplImage = emplImage;
    }

    public Departments getDepaID() {
        return depaID;
    }

    public void setDepaID(Departments depaID) {
        this.depaID = depaID;
    }

    @XmlTransient
    public Collection<ExportProducts> getExportProductsCollection() {
        return exportProductsCollection;
    }

    public void setExportProductsCollection(Collection<ExportProducts> exportProductsCollection) {
        this.exportProductsCollection = exportProductsCollection;
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
        hash += (emplID != null ? emplID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.emplID == null && other.emplID != null) || (this.emplID != null && !this.emplID.equals(other.emplID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Employees[ emplID=" + emplID + " ]";
    }
    
}
