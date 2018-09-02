package entities;

import entities.Evenement;
import entities.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2018-08-31T18:20:49")
@StaticMetamodel(Dialogue.class)
public class Dialogue_ { 

    public static volatile SingularAttribute<Dialogue, Utilisateur> idutilisateur;
    public static volatile SingularAttribute<Dialogue, Integer> iddialogue;
    public static volatile SingularAttribute<Dialogue, String> texte;
    public static volatile SingularAttribute<Dialogue, Evenement> idevenement;

}