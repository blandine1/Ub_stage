/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Typeevenement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tandoum
 */
@Stateless
public class TypeevenementFacade extends AbstractFacade<Typeevenement> implements TypeevenementFacadeLocal {

    @PersistenceContext(unitName = "EventApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TypeevenementFacade() {
        super(Typeevenement.class);
    }
    
}
