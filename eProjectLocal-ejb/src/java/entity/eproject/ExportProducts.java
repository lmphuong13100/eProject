/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minhp
 */
@Entity
@Table(name = "ExportProducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExportProducts.findAll", query = "SELECT e FROM ExportProducts e")
    , @NamedQuery(name = "ExportProducts.findByExpoID", query = "SELECT e FROM ExportProducts e WHERE e.expoID = :expoID")
    , @NamedQuery(name = "ExportProducts.findByExpoDate", query = "SELECT e FROM ExportProducts e WHERE e.expoDate = :expoDate")})
public class ExportProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExpoID")
    private Integer expoID;
    @Column(name = "ExpoDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expoDate;
    @JoinColumn(name = "EmplID", referencedColumnName = "EmplID")
    @ManyToOne(optional = false)
    private Employees emplID;
    @JoinColumn(name = "OrdeID", referencedColumnName = "OrdeID")
    @ManyToOne(optional = false)
    private Orders ordeID;

    public ExportProducts() {
    }

    public ExportProducts(Integer expoID) {
        this.expoID = expoID;
    }

    public Integer getExpoID() {
        return expoID;
    }

    public void setExpoID(Integer expoID) {
        this.expoID = expoID;
    }

    public Date getExpoDate() {
        return expoDate;
    }

    public void setExpoDate(Date expoDate) {
        this.expoDate = expoDate;
    }

    public Employees getEmplID() {
        return emplID;
    }

    public void setEmplID(Employees emplID) {
        this.emplID = emplID;
    }

    public Orders getOrdeID() {
        return ordeID;
    }

    public void setOrdeID(Orders ordeID) {
        this.ordeID = ordeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expoID != null ? expoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExportProducts)) {
            return false;
        }
        ExportProducts other = (ExportProducts) object;
        if ((this.expoID == null && other.expoID != null) || (this.expoID != null && !this.expoID.equals(other.expoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.ExportProducts[ expoID=" + expoID + " ]";
    }
    
}
