/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Participant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Tandoum
 */
@Local
public interface ParticipantFacadeLocal {

    void create(Participant participant);

    void edit(Participant participant);

    void remove(Participant participant);

    Participant find(Object id);

    List<Participant> findAll();

    List<Participant> findRange(int[] range);

    int count();
    
}
