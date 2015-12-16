/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chot;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "computeruser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computeruser.findAll", query = "SELECT c FROM Computeruser c"),
    @NamedQuery(name = "Computeruser.findByComputerID", query = "SELECT c FROM Computeruser c WHERE c.computerID = :computerID")})
public class Computeruser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ComputerID")
    private String computerID;
    @JoinColumn(name = "ComputerID", referencedColumnName = "ComputerID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Computer computer;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private User userID;

    public Computeruser() {
    }

    public Computeruser(String computerID) {
        this.computerID = computerID;
    }

    public String getComputerID() {
        return computerID;
    }

    public void setComputerID(String computerID) {
        this.computerID = computerID;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
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
        if (!(object instanceof Computeruser)) {
            return false;
        }
        Computeruser other = (Computeruser) object;
        if ((this.computerID == null && other.computerID != null) || (this.computerID != null && !this.computerID.equals(other.computerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chot.Computeruser[ computerID=" + computerID + " ]";
    }
    
}
