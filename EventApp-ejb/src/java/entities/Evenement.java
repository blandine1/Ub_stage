/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tandoum
 */
@Entity
@Table(name = "evenement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e")
    , @NamedQuery(name = "Evenement.findByIdevenement", query = "SELECT e FROM Evenement e WHERE e.idevenement = :idevenement")
    , @NamedQuery(name = "Evenement.findByNomevent", query = "SELECT e FROM Evenement e WHERE e.nomevent = :nomevent")
    , @NamedQuery(name = "Evenement.findByImage", query = "SELECT e FROM Evenement e WHERE e.image = :image")
    , @NamedQuery(name = "Evenement.findByDatedebut", query = "SELECT e FROM Evenement e WHERE e.datedebut = :datedebut")
    , @NamedQuery(name = "Evenement.findByDatefin", query = "SELECT e FROM Evenement e WHERE e.datefin = :datefin")
    , @NamedQuery(name = "Evenement.findByLieuevent", query = "SELECT e FROM Evenement e WHERE e.lieuevent = :lieuevent")
    , @NamedQuery(name = "Evenement.findByHeurdebut", query = "SELECT e FROM Evenement e WHERE e.heurdebut = :heurdebut")
    , @NamedQuery(name = "Evenement.findByHeurfin", query = "SELECT e FROM Evenement e WHERE e.heurfin = :heurfin")
    , @NamedQuery(name = "Evenement.findByVille", query = "SELECT e FROM Evenement e WHERE e.ville = :ville")})
public class Evenement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevenement")
    private Integer idevenement;
    @Size(max = 254)
    @Column(name = "nomevent")
    private String nomevent;
    @Size(max = 254)
    @Column(name = "image")
    private String image;
    @Column(name = "datedebut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Column(name = "datefin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @Size(max = 254)
    @Column(name = "lieuevent")
    private String lieuevent;
    @Size(max = 254)
    @Column(name = "heurdebut")
    private String heurdebut;
    @Size(max = 254)
    @Column(name = "heurfin")
    private String heurfin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idevenement")
    private Collection<Ticket> ticketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idevenement")
    private Collection<Dialogue> dialogueCollection;
    @JoinColumn(name = "idtype", referencedColumnName = "idtype")
    @ManyToOne(optional = false)
    private Typeevenement idtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evenement")
    private Collection<Participant> participantCollection;

    public Evenement() {
    }

    public Evenement(Integer idevenement) {
        this.idevenement = idevenement;
    }

    public Integer getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(Integer idevenement) {
        this.idevenement = idevenement;
    }

    public String getNomevent() {
        return nomevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getLieuevent() {
        return lieuevent;
    }

    public void setLieuevent(String lieuevent) {
        this.lieuevent = lieuevent;
    }

    public String getHeurdebut() {
        return heurdebut;
    }

    public void setHeurdebut(String heurdebut) {
        this.heurdebut = heurdebut;
    }

    public String getHeurfin() {
        return heurfin;
    }

    public void setHeurfin(String heurfin) {
        this.heurfin = heurfin;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @XmlTransient
    public Collection<Dialogue> getDialogueCollection() {
        return dialogueCollection;
    }

    public void setDialogueCollection(Collection<Dialogue> dialogueCollection) {
        this.dialogueCollection = dialogueCollection;
    }

    public Typeevenement getIdtype() {
        return idtype;
    }

    public void setIdtype(Typeevenement idtype) {
        this.idtype = idtype;
    }

    @XmlTransient
    public Collection<Participant> getParticipantCollection() {
        return participantCollection;
    }

    public void setParticipantCollection(Collection<Participant> participantCollection) {
        this.participantCollection = participantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idevenement != null ? idevenement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.idevenement == null && other.idevenement != null) || (this.idevenement != null && !this.idevenement.equals(other.idevenement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Evenement[ idevenement=" + idevenement + " ]";
    }
    
}
