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
public class Concurrent extends Personne {
    
 private int numLicence;
 private int anneLicence;

    public Concurrent(int numLicence, int anneLicence, String name, String firstname, int anneeNaissance) {
        super(name, firstname, anneeNaissance);
        this.numLicence = numLicence;
        this.anneLicence = anneLicence;
    }

    public int getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(int numLicence) {
        this.numLicence = numLicence;
    }

    public int getAnneLicence() {
        return anneLicence;
    }

    public void setAnneLicence(int anneLicence) {
        this.anneLicence = anneLicence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }
    
    
 
 
    
    
    
}
