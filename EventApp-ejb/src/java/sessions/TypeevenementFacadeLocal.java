/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Typeevenement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tandoum
 */
@Local
public interface TypeevenementFacadeLocal {

    void create(Typeevenement typeevenement);

    void edit(Typeevenement typeevenement);

    void remove(Typeevenement typeevenement);

    Typeevenement find(Object id);

    List<Typeevenement> findAll();

    List<Typeevenement> findRange(int[] range);

    int count();
    
}
