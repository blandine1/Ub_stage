package entities;

import entities.Evenement;
import entities.ParticipantPK;
import entities.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-08-31T18:20:49")
@StaticMetamodel(Participant.class)
public class Participant_ { 

    public static volatile SingularAttribute<Participant, ParticipantPK> participantPK;
    public static volatile SingularAttribute<Participant, Utilisateur> utilisateur;
    public static volatile SingularAttribute<Participant, Evenement> evenement;

}