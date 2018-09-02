package entities;

import entities.Dialogue;
import entities.Participant;
import entities.Ticket;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-08-31T18:20:49")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Integer> idutilisateur;
    public static volatile SingularAttribute<Utilisateur, String> password;
    public static volatile CollectionAttribute<Utilisateur, Dialogue> dialogueCollection;
    public static volatile CollectionAttribute<Utilisateur, Ticket> ticketCollection;
    public static volatile CollectionAttribute<Utilisateur, Participant> participantCollection;
    public static volatile SingularAttribute<Utilisateur, String> sexe;
    public static volatile SingularAttribute<Utilisateur, String> typeuser;
    public static volatile SingularAttribute<Utilisateur, String> login;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, String> prenom;
    public static volatile SingularAttribute<Utilisateur, Date> datenaiss;
    public static volatile SingularAttribute<Utilisateur, String> email;

}