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
import java.util.Scanner;

/**
 *
 * @author Afpa
 */
public class ComAfpaDahouet {

    public Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();

        Licencie lic1 = new Licencie(100, 100, 2016, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        personnes.add(lic1);
        Licencie lic2 = new Licencie(100, 100, 2017, "Le Gall", "Nicolas", "jmng@plouf.fr", 1990);
        personnes.add(lic2);
        Licencie lic3 = new Licencie(100, 100, 2017, "Le Floc\'h", "Nicolas", "jmng@plouf.fr", 1990);
        personnes.add(lic3);
        Commissaire comi1 = new Commissaire("Sud-Bretagne", "Goff", "Erwann", "ccc@ccc.com", 1978);
        personnes.add(comi1);

        Date date = new Date();

        System.out.print(personnes.toString());

        try {
            double pts = lic1.calculPoints(date, 20.5);
            System.out.print("Nombre de pts : " + pts);
        } catch (MismatchYearsException e) {

            System.err.println("ERREUR : " + e.getMessage());
        }

    }

}
