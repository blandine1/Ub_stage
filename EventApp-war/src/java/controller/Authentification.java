/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Utilisateur;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import sessions.UtilisateurFacadeLocal;

/**
 *
 * @author Tandoum
 */
public class Authentification implements Serializable {

    @EJB
    UtilisateurFacadeLocal utilisateurFacadeLocal;
    private Utilisateur user = new Utilisateur();
    private String msg;

    /**
     * Creates a new instance of Authentification
     */
    public Authentification() {
    }

    public String authentification() {
        try {
            Utilisateur utilisateur1 = new Utilisateur();
            utilisateur1 = utilisateurFacadeLocal.findByLoginMdp(user.getLogin(), user.getPassword());
            if (utilisateur1 != null) {
                msg = "bienvenue ";
                RequestContext.getCurrentInstance().update("growl");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                return "index.xhtml";
            } else {
                RequestContext.getCurrentInstance().update("growl");
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "login ou password invalide!!!  "));
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "S'inscrire.xhtml";
        }
    }

    public void message() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "bienvenue " + user.getNom()));
    }

    public UtilisateurFacadeLocal getUtilisateurFacadeLocal() {
        return utilisateurFacadeLocal;
    }

    public void setUtilisateurFacadeLocal(UtilisateurFacadeLocal utilisateurFacadeLocal) {
        this.utilisateurFacadeLocal = utilisateurFacadeLocal;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

}
