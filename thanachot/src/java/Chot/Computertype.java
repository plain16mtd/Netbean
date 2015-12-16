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
@Table(name = "computertype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computertype.findAll", query = "SELECT c FROM Computertype c"),
    @NamedQuery(name = "Computertype.findByComputerTypeID", query = "SELECT c FROM Computertype c WHERE c.computerTypeID = :computerTypeID"),
    @NamedQuery(name = "Computertype.findByTypeName", query = "SELECT c FROM Computertype c WHERE c.typeName = :typeName"),
    @NamedQuery(name = "Computertype.findByTypeDescription", query = "SELECT c FROM Computertype c WHERE c.typeDescription = :typeDescription")})
public class Computertype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ComputerTypeID")
    private String computerTypeID;
    @Size(max = 40)
    @Column(name = "TypeName")
    private String typeName;
    @Size(max = 100)
    @Column(name = "TypeDescription")
    private String typeDescription;
    @OneToMany(mappedBy = "computerTypeID")
    private Collection<Computer> computerCollection;

    public Computertype() {
    }

    public Computertype(String computerTypeID) {
        this.computerTypeID = computerTypeID;
    }

    public String getComputerTypeID() {
        return computerTypeID;
    }

    public void setComputerTypeID(String computerTypeID) {
        this.computerTypeID = computerTypeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
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
        hash += (computerTypeID != null ? computerTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Computertype)) {
            return false;
        }
        Computertype other = (Computertype) object;
        if ((this.computerTypeID == null && other.computerTypeID != null) || (this.computerTypeID != null && !this.computerTypeID.equals(other.computerTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chot.Computertype[ computerTypeID=" + computerTypeID + " ]";
    }
    
}
