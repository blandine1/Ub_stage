package entities;

import entities.Evenement;
import entities.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-08-31T18:20:49")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Utilisateur> idutilisateur;
    public static volatile SingularAttribute<Ticket, String> delai;
    public static volatile SingularAttribute<Ticket, Integer> quantitetiket;
    public static volatile SingularAttribute<Ticket, Integer> idticket;
    public static volatile SingularAttribute<Ticket, String> nomevent;
    public static volatile SingularAttribute<Ticket, String> libelle;
    public static volatile SingularAttribute<Ticket, Integer> numeroticket;
    public static volatile SingularAttribute<Ticket, String> nomuser;
    public static volatile SingularAttribute<Ticket, Evenement> idevenement;

}