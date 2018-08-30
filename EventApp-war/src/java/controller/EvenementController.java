/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Evenement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import sessions.EvenementFacadeLocal;

/**
 *
 * @author Tandoum
 */
public class EvenementController implements Serializable{

    @EJB
    EvenementFacadeLocal evenementFacadeLocal;

    private Evenement evenement = new Evenement();
    private List<Evenement> listEvenement = new ArrayList<>();
    private String msg;
    /**
     * Creates a new instance of EvenementController
     */
    public EvenementController() {

    }

    @PostConstruct
    public void initEvenement() {
        listEvenement.clear();
        listEvenement.addAll(evenementFacadeLocal.findAll());
    }

    public String creerEvenement() {
        try {
           evenementFacadeLocal.create(evenement);
           msg="votre evenement a été correctement crée";
          initEvenement();
        } catch (Exception e) {
        e.printStackTrace();
        }
        return null;
    }
    
     public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public EvenementFacadeLocal getEvenementFacadeLocal() {
        return evenementFacadeLocal;
    }

    public void setEvenementFacadeLocal(EvenementFacadeLocal evenementFacadeLocal) {
        this.evenementFacadeLocal = evenementFacadeLocal;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public List<Evenement> getListEvenement() {
        return listEvenement;
    }

    public void setListEvenement(List<Evenement> listEvenement) {
        this.listEvenement = listEvenement;
    }
    
    

}
