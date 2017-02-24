/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet;

import com.afpa.dahouet.model.Personne;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Afpa
 */
public class Utils {

    public static boolean checkMail(String mail) {

        boolean check = false;
        int atSignPosition = 0;
        int pointPosition = 0;

        for (int i = 0; i < mail.length(); i++) {
            System.out.println("Checking @ position : " + i);

            if (mail.charAt(i) == '@') {

                check = true;
                atSignPosition = i;
                System.out.println("FOUND @ : " + i);
                break;
            }
        }

        if (!check) {

            return false;

        }

        check = false;

        for (int i = atSignPosition + 1; i < mail.length(); i++) {

            System.out.println("Checking . position : " + i);
            if (mail.charAt(i) == '.') {

                check = true;
                pointPosition = i;
                System.out.println("FOUND . : " + i);

                break;

            }

        }

        if (!check) {

            return false;

        }

        String substr1 = mail.substring(0, atSignPosition);
        System.out.println(substr1);
        System.out.println("First part lenght : " + substr1.length());

        if (substr1.length() < 2) {

            check = false;

        }

        if (!check) {

            return false;

        }

        String substr2 = mail.substring(atSignPosition + 1, pointPosition);
        System.out.println(substr2);
        System.out.println("Middle part lenght : " + substr2.length());

        if (substr2.length() < 2) {

            check = false;
        }

        if (!check) {

            return false;

        }

        String substr3 = mail.substring(pointPosition + 1, mail.length());
        System.out.println(substr3);
        System.out.println("Laster part lenght :" + substr3.length());
        if (substr3.length() < 2) {

            check = false;
        }

        if (!check) {

            return false;

        }

        return true;
    }

    public static String toStringList(List<Personne> personnes) {

        String listing = "";

        for (Personne personne : personnes) {

            listing += personne.toString() + "\n";

        }

        return listing;
    }

    public static int averageAge(List<Personne> personnes) {

        int somme = 0;
        for (Personne personne : personnes) {

            somme += personne.getAge();

        }
        int moy = (int) (somme / personnes.size());

        return moy;
    }
    
    public static int medianAge(List<Personne> personnes) {
        
        int median = 0;
        Collections.sort(personnes, new Comparator<Personne>() {
            @Override
            public int compare(Personne o1, Personne o2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
           
        });
        
        
        return median;
    }

}
