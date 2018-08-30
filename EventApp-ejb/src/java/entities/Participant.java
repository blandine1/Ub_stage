/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tandoum
 */
@Entity
@Table(name = "participant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participant.findAll", query = "SELECT p FROM Participant p")
    , @NamedQuery(name = "Participant.findByIdutilisateur", query = "SELECT p FROM Participant p WHERE p.participantPK.idutilisateur = :idutilisateur")
    , @NamedQuery(name = "Participant.findByIdevenement", query = "SELECT p FROM Participant p WHERE p.participantPK.idevenement = :idevenement")
    , @NamedQuery(name = "Participant.findByIdparticpant", query = "SELECT p FROM Participant p WHERE p.participantPK.idparticpant = :idparticpant")})
public class Participant implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipantPK participantPK;
    @JoinColumn(name = "idevenement", referencedColumnName = "idevenement", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Evenement evenement;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public Participant() {
    }

    public Participant(ParticipantPK participantPK) {
        this.participantPK = participantPK;
    }

    public Participant(int idutilisateur, int idevenement, int idparticpant) {
        this.participantPK = new ParticipantPK(idutilisateur, idevenement, idparticpant);
    }

    public ParticipantPK getParticipantPK() {
        return participantPK;
    }

    public void setParticipantPK(ParticipantPK participantPK) {
        this.participantPK = participantPK;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantPK != null ? participantPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participant)) {
            return false;
        }
        Participant other = (Participant) object;
        if ((this.participantPK == null && other.participantPK != null) || (this.participantPK != null && !this.participantPK.equals(other.participantPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Participant[ participantPK=" + participantPK + " ]";
    }
    
}
