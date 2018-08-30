/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tandoum
 */
@Entity
@Table(name = "ticket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findByIdticket", query = "SELECT t FROM Ticket t WHERE t.idticket = :idticket")
    , @NamedQuery(name = "Ticket.findByQuantitetiket", query = "SELECT t FROM Ticket t WHERE t.quantitetiket = :quantitetiket")
    , @NamedQuery(name = "Ticket.findByNomevent", query = "SELECT t FROM Ticket t WHERE t.nomevent = :nomevent")
    , @NamedQuery(name = "Ticket.findByNumeroticket", query = "SELECT t FROM Ticket t WHERE t.numeroticket = :numeroticket")
    , @NamedQuery(name = "Ticket.findByLibelle", query = "SELECT t FROM Ticket t WHERE t.libelle = :libelle")
    , @NamedQuery(name = "Ticket.findByNomuser", query = "SELECT t FROM Ticket t WHERE t.nomuser = :nomuser")
    , @NamedQuery(name = "Ticket.findByDelai", query = "SELECT t FROM Ticket t WHERE t.delai = :delai")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idticket")
    private Integer idticket;
    @Column(name = "quantitetiket")
    private Integer quantitetiket;
    @Size(max = 254)
    @Column(name = "nomevent")
    private String nomevent;
    @Column(name = "numeroticket")
    private Integer numeroticket;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 254)
    @Column(name = "nomuser")
    private String nomuser;
    @Size(max = 254)
    @Column(name = "delai")
    private String delai;
    @JoinColumn(name = "idevenement", referencedColumnName = "idevenement")
    @ManyToOne(optional = false)
    private Evenement idevenement;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Ticket() {
    }

    public Ticket(Integer idticket) {
        this.idticket = idticket;
    }

    public Integer getIdticket() {
        return idticket;
    }

    public void setIdticket(Integer idticket) {
        this.idticket = idticket;
    }

    public Integer getQuantitetiket() {
        return quantitetiket;
    }

    public void setQuantitetiket(Integer quantitetiket) {
        this.quantitetiket = quantitetiket;
    }

    public String getNomevent() {
        return nomevent;
    }

    public void setNomevent(String nomevent) {
        this.nomevent = nomevent;
    }

    public Integer getNumeroticket() {
        return numeroticket;
    }

    public void setNumeroticket(Integer numeroticket) {
        this.numeroticket = numeroticket;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public String getDelai() {
        return delai;
    }

    public void setDelai(String delai) {
        this.delai = delai;
    }

    public Evenement getIdevenement() {
        return idevenement;
    }

    public void setIdevenement(Evenement idevenement) {
        this.idevenement = idevenement;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idticket != null ? idticket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idticket == null && other.idticket != null) || (this.idticket != null && !this.idticket.equals(other.idticket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ticket[ idticket=" + idticket + " ]";
    }
    
}
