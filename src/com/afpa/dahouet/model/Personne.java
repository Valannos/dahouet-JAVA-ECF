/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.model;

import com.afpa.dahouet.Color;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Vanel
 * @see
 * http://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
 */
public abstract class Personne implements Comparable {

    protected String name;
    protected String firstname;
    protected String email;
    protected int anneeNaissance;
    protected Date dateNaissance;

    public Personne(String name, String firstname, String email, int anneeNaissance) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
    }

    public Personne(String name, String firstname, int anneeNaissance) {
        this.name = name;
        this.firstname = firstname;
        this.anneeNaissance = anneeNaissance;
    }

    public Personne(String name, String firstname, String email, Date dateNaissance) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.dateNaissance = dateNaissance;
    }

    public Personne(String name, String firstname, Date dateNaissance) {
        this.name = name;
        this.firstname = firstname;
        this.dateNaissance = dateNaissance;
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

    public int getAge() {

        Calendar cal = Calendar.getInstance();
        int age = cal.get(Calendar.YEAR) - this.anneeNaissance;
        return age;

    }

    @Override
    public String toString() {
        int age = getAge();
        return "name=" + name + ", firstname=" + firstname + ", email=" + email + ", age=" + age + '}' + Color.ANSI_RESET /*+ "\n"*/;
    }

    @Override
    public int compareTo(Object o) {
        Personne p = (Personne) o;
        return this.getAge() - p.getAge();
    }

}
