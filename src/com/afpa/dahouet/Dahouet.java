/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet;

import com.afpa.dahouet.model.*;
import com.afpa.dahouet.model.Licencie;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Afpa
 */
public class Dahouet {

 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();

        Licencie lic1 = new Licencie(100, 100, 2016, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        personnes.add(lic1);
        Licencie lic2 = new Licencie(100, 100, 2017, "Le Gall", "Nicolas", "jmng@plouf.fr", 1990);
        personnes.add(lic2);
        Licencie lic3 = new Licencie(100, 100, 2017, "Le Floc\'h", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic3);
        Commissaire comi1 = new Commissaire("Sud-Bretagne", "Goff", "Erwann", "ccc@ccc.com", 1970);
        personnes.add(comi1);
        Proprietaire pro1 = new Proprietaire("Le Hire", "Dédé", "sfggf@gsr.fr", 1965);
        personnes.add(pro1);
        Proprietaire pro2 = new Proprietaire("Le Gronec", "Gwen", "sdfgdsfg@sdfg.com", 1975);
        personnes.add(pro2);

        Date date = new Date();

        System.out.println("Moyenne d\'âge : " + Utils.averageAge(personnes));
        System.out.println("Valeur médiane : " + Utils.medianAge(personnes));

        System.out.print(Utils.toStringList(personnes));

        try {
            double pts = lic1.calculPoints(date, 20.5);
            System.out.print("Nombre de pts : " + pts);
        } catch (MismatchYearsException e) {

            System.err.println("ERREUR : " + e.getMessage());
        }

    }

}
