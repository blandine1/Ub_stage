/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Utilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import sessions.UtilisateurFacadeLocal;

/**
 *
 * @author Tandoum
 */
public class OrganisateurController implements Serializable {

    @EJB
    UtilisateurFacadeLocal utilisateurFacadeLocal;
    private Utilisateur utilisateur = new Utilisateur();
    // private Utilisateur utilisateur1 = new Utilisateur();
    private List<Utilisateur> listeUtilisateur = new ArrayList<>();
    private String msg;

    /**
     * Creates a new instance of OrganisateurController
     */
    public OrganisateurController() {
    }

    @PostConstruct
    public void initUtilisateur() {
        listeUtilisateur.clear();
        listeUtilisateur.addAll(utilisateurFacadeLocal.findAll());
    }

    public String authentification() {
        try {
           Utilisateur utilisateur1= new Utilisateur();
           
            utilisateur1 = utilisateurFacadeLocal.findByLoginMdp(utilisateur.getLogin(),utilisateur.getPassword());
            if (utilisateur1 == null) {
                return "S'inscrire.xhtml";
            } else {
                return "index.xhtml";
            }
        } catch (Exception e) {
        }
            return null;
    }

    public String creerutilisateur() {
        try {
            Utilisateur user = new Utilisateur();
            user = utilisateurFacadeLocal.findByEmail(utilisateur.getEmail());
            if (user != null) {
                return "S'inscrire.xhtml";
            } else {
                utilisateurFacadeLocal.create(this.utilisateur);
                return "index.xhtml";
            }
        } catch (Exception e) {
        }
        return null;

    }
    
      public void execute() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "bienvenue "+utilisateur.getNom()));
    }

//// Utilisateur utilisateur1=new Utilisateur();
//        //try {
//            //System.out.println("mail " +utilisateur.getEmail());
//           // if (utilisateur == null) {
//                //System.out.println("bienvenue monsieur");
//                utilisateurFacadeLocal.create(utilisateur);
//                return "index.xhtml";
//           // } else {
//               // return "S'inscrire.xhtml";
//                // System.out.println("cet utilisateur existe déjà");
//            }
//    
//        //} catch (Exception e) {
//            //return null;
//        //}
//    }
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("bienvenue " + utilisateur.getSexe());
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public UtilisateurFacadeLocal getUtilisateurFacadeLocal() {
        return utilisateurFacadeLocal;
    }

    public void setUtilisateurFacadeLocal(UtilisateurFacadeLocal utilisateurFacadeLocal) {
        this.utilisateurFacadeLocal = utilisateurFacadeLocal;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Utilisateur> getListeUtilisateur() {
        return listeUtilisateur;
    }

    public void setListeUtilisateur(List<Utilisateur> listeUtilisateur) {
        this.listeUtilisateur = listeUtilisateur;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
