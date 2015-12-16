/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chot;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Windows 8.1
 */
@Entity
@Table(name = "computer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computer.findAll", query = "SELECT c FROM Computer c"),
    @NamedQuery(name = "Computer.findByComputerID", query = "SELECT c FROM Computer c WHERE c.computerID = :computerID"),
    @NamedQuery(name = "Computer.findByComputerName", query = "SELECT c FROM Computer c WHERE c.computerName = :computerName"),
    @NamedQuery(name = "Computer.findByOs", query = "SELECT c FROM Computer c WHERE c.os = :os")})
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ComputerID")
    private String computerID;
    @Size(max = 40)
    @Column(name = "ComputerName")
    private String computerName;
    @Size(max = 40)
    @Column(name = "OS")
    private String os;
    @JoinColumn(name = "ComputerTypeID", referencedColumnName = "ComputerTypeID")
    @ManyToOne
    private Computertype computerTypeID;
    @JoinColumn(name = "ManufacturerID", referencedColumnName = "ManufacturerID")
    @ManyToOne
    private Manufacturer manufacturerID;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "computer")
    private Computeruser computeruser;

    public Computer() {
    }

    public Computer(String computerID) {
        this.computerID = computerID;
    }

    public String getComputerID() {
        return computerID;
    }

    public void setComputerID(String computerID) {
        this.computerID = computerID;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public Computertype getComputerTypeID() {
        return computerTypeID;
    }

    public void setComputerTypeID(Computertype computerTypeID) {
        this.computerTypeID = computerTypeID;
    }

    public Manufacturer getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(Manufacturer manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public Computeruser getComputeruser() {
        return computeruser;
    }

    public void setComputeruser(Computeruser computeruser) {
        this.computeruser = computeruser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (computerID != null ? computerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Computer)) {
            return false;
        }
        Computer other = (Computer) object;
        if ((this.computerID == null && other.computerID != null) || (this.computerID != null && !this.computerID.equals(other.computerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chot.Computer[ computerID=" + computerID + " ]";
    }
    
}
