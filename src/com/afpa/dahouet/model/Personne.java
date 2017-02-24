/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import java.util.Calendar;

/**
 *
 * @author Afpa
 */
public abstract class Personne {

    protected String name;
    protected String firstname;
    protected String email;
    protected int anneeNaissance;

    public Personne(String name, String firstname, String email, int anneeNaissance) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
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

    @Override
    public String toString() {
        Calendar cal = Calendar.getInstance();
        int age = cal.get(Calendar.YEAR) - this.anneeNaissance;
        return ", name=" + name + ", firstname=" + firstname + ", email=" + email + ", age=" + age + '}' + "\n";
    }

}
