/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Utilisateur;
import static java.util.Collections.list;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tandoum
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "EventApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    @Override
    public Utilisateur findByLoginMdp(String login,String password) {
        try {
            Query query = em.createNamedQuery("Utilisateur.findByLoginMdp");
            query.setParameter("login", login).setParameter("password", password);
            return (Utilisateur) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Utilisateur findByEmail(String email) {
        try {
            Query query = em.createNamedQuery("Utilisateur.findByEmail");
            query.setParameter("email", email);
            return (Utilisateur) query.getSingleResult();
        } catch (Exception e) {
        }
            return null;
    }
    
    @Override
    public Utilisateur findByNom(String nom) {
        try {
            Query query = em.createNamedQuery("Utilisateur.findByNom");
            query.setParameter("nom", nom);
            return (Utilisateur) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
