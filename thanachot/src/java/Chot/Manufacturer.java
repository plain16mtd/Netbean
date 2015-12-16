/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chot;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author Windows 8.1
 */
@Entity
@Table(name = "manufacturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manufacturer.findAll", query = "SELECT m FROM Manufacturer m"),
    @NamedQuery(name = "Manufacturer.findByManufacturerID", query = "SELECT m FROM Manufacturer m WHERE m.manufacturerID = :manufacturerID"),
    @NamedQuery(name = "Manufacturer.findByManufacturerName", query = "SELECT m FROM Manufacturer m WHERE m.manufacturerName = :manufacturerName"),
    @NamedQuery(name = "Manufacturer.findByManufacturerContact", query = "SELECT m FROM Manufacturer m WHERE m.manufacturerContact = :manufacturerContact")})
public class Manufacturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ManufacturerID")
    private String manufacturerID;
    @Size(max = 40)
    @Column(name = "ManufacturerName")
    private String manufacturerName;
    @Size(max = 40)
    @Column(name = "ManufacturerContact")
    private String manufacturerContact;
    @OneToMany(mappedBy = "manufacturerID")
    private Collection<Computer> computerCollection;

    public Manufacturer() {
    }

    public Manufacturer(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerContact() {
        return manufacturerContact;
    }

    public void setManufacturerContact(String manufacturerContact) {
        this.manufacturerContact = manufacturerContact;
    }

    @XmlTransient
    public Collection<Computer> getComputerCollection() {
        return computerCollection;
    }

    public void setComputerCollection(Collection<Computer> computerCollection) {
        this.computerCollection = computerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (manufacturerID != null ? manufacturerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manufacturer)) {
            return false;
        }
        Manufacturer other = (Manufacturer) object;
        if ((this.manufacturerID == null && other.manufacturerID != null) || (this.manufacturerID != null && !this.manufacturerID.equals(other.manufacturerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chot.Manufacturer[ manufacturerID=" + manufacturerID + " ]";
    }
    
}
