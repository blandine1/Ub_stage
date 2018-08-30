/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Tandoum
 */
@Embeddable
public class ParticipantPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idutilisateur")
    private int idutilisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idevenement")
    private int idevenement;
    @Basic(optional = false)
    @Column(name = "idparticpant")
    private int idparticpant;

    public ParticipantPK() {
    }

    public ParticipantPK(int idutilisateur, int idevenement, int idparticpant) {
        this.idutilisateur = idutilisateur;
        this.idevenement = idevenement;
        this.idparticpant = idparticpant;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(int idevenement) {
        this.idevenement = idevenement;
    }

    public int getIdparticpant() {
        return idparticpant;
    }

    public void setIdparticpant(int idparticpant) {
        this.idparticpant = idparticpant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idutilisateur;
        hash += (int) idevenement;
        hash += (int) idparticpant;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantPK)) {
            return false;
        }
        ParticipantPK other = (ParticipantPK) object;
        if (this.idutilisateur != other.idutilisateur) {
            return false;
        }
        if (this.idevenement != other.idevenement) {
            return false;
        }
        if (this.idparticpant != other.idparticpant) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ParticipantPK[ idutilisateur=" + idutilisateur + ", idevenement=" + idevenement + ", idparticpant=" + idparticpant + " ]";
    }
    
}
