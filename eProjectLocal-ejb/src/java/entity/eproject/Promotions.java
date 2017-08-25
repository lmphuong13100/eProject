/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.eproject;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author minhp
 */
@Entity
@Table(name = "Promotions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotions.findAll", query = "SELECT p FROM Promotions p")
    , @NamedQuery(name = "Promotions.findByPromCode", query = "SELECT p FROM Promotions p WHERE p.promCode = :promCode")
    , @NamedQuery(name = "Promotions.findByStartDate", query = "SELECT p FROM Promotions p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "Promotions.findByEndDate", query = "SELECT p FROM Promotions p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "Promotions.findByNumbers", query = "SELECT p FROM Promotions p WHERE p.numbers = :numbers")})
public class Promotions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PromCode")
    private String promCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "StartDate")
    private String startDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "EndDate")
    private String endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numbers")
    private int numbers;
    @JoinColumn(name = "CateID", referencedColumnName = "CateID")
    @ManyToOne(optional = false)
    private Categories cateID;

    public Promotions() {
    }

    public Promotions(String promCode) {
        this.promCode = promCode;
    }

    public Promotions(String promCode, String startDate, String endDate, int numbers) {
        this.promCode = promCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numbers = numbers;
    }

    public String getPromCode() {
        return promCode;
    }

    public void setPromCode(String promCode) {
        this.promCode = promCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public Categories getCateID() {
        return cateID;
    }

    public void setCateID(Categories cateID) {
        this.cateID = cateID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promCode != null ? promCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotions)) {
            return false;
        }
        Promotions other = (Promotions) object;
        if ((this.promCode == null && other.promCode != null) || (this.promCode != null && !this.promCode.equals(other.promCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.eproject.Promotions[ promCode=" + promCode + " ]";
    }
    
}
