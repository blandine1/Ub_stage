package entities;

import entities.Dialogue;
import entities.Participant;
import entities.Ticket;
import entities.Typeevenement;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-08-31T18:20:49")
@StaticMetamodel(Evenement.class)
public class Evenement_ { 

    public static volatile SingularAttribute<Evenement, String> lieuevent;
    public static volatile SingularAttribute<Evenement, String> image;
    public static volatile SingularAttribute<Evenement, Typeevenement> idtype;
    public static volatile SingularAttribute<Evenement, String> heurdebut;
    public static volatile CollectionAttribute<Evenement, Dialogue> dialogueCollection;
    public static volatile CollectionAttribute<Evenement, Ticket> ticketCollection;
    public static volatile SingularAttribute<Evenement, String> nomevent;
    public static volatile SingularAttribute<Evenement, String> heurfin;
    public static volatile CollectionAttribute<Evenement, Participant> participantCollection;
    public static volatile SingularAttribute<Evenement, Date> datedebut;
    public static volatile SingularAttribute<Evenement, Integer> idevenement;
    public static volatile SingularAttribute<Evenement, Date> datefin;

}