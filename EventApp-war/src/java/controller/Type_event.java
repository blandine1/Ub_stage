/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Typeevenement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import sessions.TypeevenementFacadeLocal;

/**
 *
 * @author Tandoum
 */
public class Type_event implements Serializable {
    
    @EJB
    TypeevenementFacadeLocal typeevenementFacadeLocal;
    private Typeevenement type_event= new Typeevenement();
    private List<Typeevenement> listtypeevenement=new ArrayList<>();
    private String msg;
    /**
     * Creates a new instance of Type_event
     */
    public Type_event() {
    }
    
    @PostConstruct
    public void initType(){
        listtypeevenement.clear();
        listtypeevenement.addAll(typeevenementFacadeLocal.findAll());
    }

    public TypeevenementFacadeLocal getTypeevenementFacadeLocal() {
        return typeevenementFacadeLocal;
    }

    public void setTypeevenementFacadeLocal(TypeevenementFacadeLocal typeevenementFacadeLocal) {
        this.typeevenementFacadeLocal = typeevenementFacadeLocal;
    }

    public Typeevenement getType_event() {
        return type_event;
    }

    public void setType_event(Typeevenement type_event) {
        this.type_event = type_event;
    }

    public List<Typeevenement> getListtypeevenement() {
        return listtypeevenement;
    }

    public void setListtypeevenement(List<Typeevenement> listtypeevenement) {
        this.listtypeevenement = listtypeevenement;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
