/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

/**
 *
 * @author Valannos
 */
public class Voilier {
    
    private Proprietaire pro;
    private ClasseVoillier cv;
    private String nom;

    public Voilier(Proprietaire pro, ClasseVoillier classe, String nom) {
        this.pro = pro;
        this.cv = classe;
        this.nom = nom;
    }

    public Proprietaire getPro() {
        return pro;
    }

    public void setPro(Proprietaire pro) {
        this.pro = pro;
    }

    public ClasseVoillier getClasse() {
        return cv;
    }

    public void setClasse(ClasseVoillier classe) {
        this.cv = classe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    
    
    
    
    
    
}
