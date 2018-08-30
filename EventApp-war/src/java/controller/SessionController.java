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
public class SessionController implements Serializable{
    
    @EJB
     private UtilisateurFacadeLocal utilisateurFacadeLocal;
    
    private Utilisateur utilisateur=new Utilisateur();
    private Utilisateur utilisateur1;

    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
        
    }
    
    public String authentification(){
        try {
            utilisateur = utilisateurFacadeLocal.findByLoginMdp(utilisateur.getLogin(), utilisateur.getPassword());
            System.out.println("Login  " +utilisateur.getNom());
            if(utilisateur != null ){
                return "index.xhtml";
            }else{
                return "S'inscrire.xhtml";
            } 
        }catch (Exception e) {
            return null;
        }
        
    }
}
