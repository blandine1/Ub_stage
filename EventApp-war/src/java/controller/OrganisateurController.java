/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.webkit.Utilities;
import entities.Utilisateur;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
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
            Utilisateur utilisateur1 = new Utilisateur();

            utilisateur1 = utilisateurFacadeLocal.findByLoginMdp(utilisateur.getLogin(), utilisateur.getPassword());
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
                msg = "cet utilisateur est deja inscrit ";
                RequestContext.getCurrentInstance().update("growl");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                return "S'inscrire.xhtml";
            } else {
                utilisateurFacadeLocal.create(this.utilisateur);
                msg = "bienvenue ";
                RequestContext.getCurrentInstance().update("growl");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
                FacesContext.getCurrentInstance().addMessage(null, message);
                return "index.xhtml";
            }
        } catch (Exception e) {
            return "S'inscrire.xhtml";
        }

    }

//    public void creerUser() {
//        try {
//            Utilisateur user = new Utilisateur();
//            user = utilisateurFacadeLocal.findByEmail(utilisateur.getEmail());
//            if (user != null) {
//                msg = "cet utilisateur est deja inscrit ";
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
//                FacesContext.getCurrentInstance().addMessage(null, message);
//            } else {
//                utilisateurFacadeLocal.create(this.utilisateur);
//                msg = "bienvenu " + utilisateur.getNom();
//                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
//                FacesContext.getCurrentInstance().addMessage(null, message);
//                
//            }
//        } catch (Exception e) {
//        }
//    }
    public void message() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "bienvenue " + utilisateur.getNom()));
    }

//// Utilisateur utilisateur1=new Utilisateur();
//        //try {
//          r //System.out.println("mail " +utilisateur.getEmail());
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
    public void handleFileUpload(FileUploadEvent event) {
        InputStream is;
        String fileName = event.getFile().getFileName();
        String dir = "C:\\Users\\Tandoum\\Documents\\NetBeansProjects\\EventApp\\EventApp-war\\web\\resources\\image";

        if (document.getPhotoProfil() != null) {
            if (document.getPhotoProfil().equals(document.getCode() + fileName)) {
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

                Utilities.messageExistance("fr");
            } else {
                try {
                    File tempFile = new File(dir + document.getCode() + fileName);
                    //File tempFileNew = new File(dir + document.getCode() + fileName);
                    if (tempFile.renameTo(tempFileNew)) {
                        tempFile = tempFileNew;
                        is = event.getFile().getInputStream();
                        OutputStream os = new FileOutputStream(tempFile);

                        byte buf[] = new byte[1024];
                        int len;
                        while ((len = is.read(buf)) > 0) {
                            os.write(buf, 0, len);
                        }
                        os.close();
                        is.close();

                        document.setPhotoProfil(document.getCode() + event.getFile().getFileName());
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            try {
                File tempFile = new File(dir + document.getCode() + fileName);
                //File tempFileNew = new File(dir + document.getCode() + fileName);
                if (tempFile.renameTo(tempFileNew)) {
                    tempFile = tempFileNew;
                    is = event.getFile().getInputStream();
                    OutputStream os = new FileOutputStream(tempFile);

                    byte buf[] = new byte[1024];
                    int len;
                    while ((len = is.read(buf)) > 0) {
                        os.write(buf, 0, len);
                    }
                    os.close();
                    is.close();

                    document.setPhotoProfil(document.getCode() + event.getFile().getFileName());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

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
