/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Utilisateur;
import java.io.Serializable;
import javax.ejb.EJB;
import sessions.UtilisateurFacadeLocal;


/**
 *
 * @author Tandoum
 */
public class Authentification implements Serializable{
     
    @EJB
    UtilisateurFacadeLocal utilisateurFacadeLocal;
    private Utilisateur user= new Utilisateur();

    /**
     * Creates a new instance of Authentification
     */
    public Authentification() {
    }
    
     public String authentification() {
        try {
           Utilisateur utilisateur1= new Utilisateur();
            utilisateur1 = utilisateurFacadeLocal.findByLoginMdp(user.getLogin(),user.getPassword());
            if (utilisateur1 != null) {
                return "index.xhtml";
            } else {
                return "S'inscrire.xhtml";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "S'inscrire.xhtml";
        }
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
