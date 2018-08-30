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
@Table(name = "dialogue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dialogue.findAll", query = "SELECT d FROM Dialogue d")
    , @NamedQuery(name = "Dialogue.findByIddialogue", query = "SELECT d FROM Dialogue d WHERE d.iddialogue = :iddialogue")
    , @NamedQuery(name = "Dialogue.findByTexte", query = "SELECT d FROM Dialogue d WHERE d.texte = :texte")})
public class Dialogue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddialogue")
    private Integer iddialogue;
    @Size(max = 254)
    @Column(name = "texte")
    private String texte;
    @JoinColumn(name = "idevenement", referencedColumnName = "idevenement")
    @ManyToOne(optional = false)
    private Evenement idevenement;
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idutilisateur;

    public Dialogue() {
    }

    public Dialogue(Integer iddialogue) {
        this.iddialogue = iddialogue;
    }

    public Integer getIddialogue() {
        return iddialogue;
    }

    public void setIddialogue(Integer iddialogue) {
        this.iddialogue = iddialogue;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
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
        hash += (iddialogue != null ? iddialogue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dialogue)) {
            return false;
        }
        Dialogue other = (Dialogue) object;
        if ((this.iddialogue == null && other.iddialogue != null) || (this.iddialogue != null && !this.iddialogue.equals(other.iddialogue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Dialogue[ iddialogue=" + iddialogue + " ]";
    }
    
}
