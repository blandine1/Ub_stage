/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tandoum
 */
@Entity
@Table(name = "typeevenement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typeevenement.findAll", query = "SELECT t FROM Typeevenement t")
    , @NamedQuery(name = "Typeevenement.findByIdtype", query = "SELECT t FROM Typeevenement t WHERE t.idtype = :idtype")
    , @NamedQuery(name = "Typeevenement.findByNomtype", query = "SELECT t FROM Typeevenement t WHERE t.nomtype = :nomtype")})
public class Typeevenement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtype")
    private Integer idtype;
    @Size(max = 254)
    @Column(name = "nomtype")
    private String nomtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtype")
    private Collection<Evenement> evenementCollection;

    public Typeevenement() {
    }

    public Typeevenement(Integer idtype) {
        this.idtype = idtype;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    @XmlTransient
    public Collection<Evenement> getEvenementCollection() {
        return evenementCollection;
    }

    public void setEvenementCollection(Collection<Evenement> evenementCollection) {
        this.evenementCollection = evenementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtype != null ? idtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typeevenement)) {
            return false;
        }
        Typeevenement other = (Typeevenement) object;
        if ((this.idtype == null && other.idtype != null) || (this.idtype != null && !this.idtype.equals(other.idtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Typeevenement[ idtype=" + idtype + " ]";
    }
    
}
