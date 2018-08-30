/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Dialogue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tandoum
 */
@Local
public interface DialogueFacadeLocal {

    void create(Dialogue dialogue);

    void edit(Dialogue dialogue);

    void remove(Dialogue dialogue);

    Dialogue find(Object id);

    List<Dialogue> findAll();

    List<Dialogue> findRange(int[] range);

    int count();
    
}
