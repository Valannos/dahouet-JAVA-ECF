/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet;

import com.afpa.dahouet.model.Personne;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Afpa
 */
public class Utils {

    /**
     * Return a boolean depending on the validity of e-mail format received in
     * parameters
     *
     * @param mail
     * @return true if format is valid, else false
     */
    public static boolean checkMail(String mail) {

        int atSignPosition = -1;
        int pointPosition = -1;

        for (int i = 0; i < mail.length(); i++) {
            //     System.out.println("Checking @ position : " + i);

            if (mail.charAt(i) == '@') {

                atSignPosition = i;
                //        System.out.println("FOUND @ : " + i);
                break;
            }
        }

        if (atSignPosition == -1) {
            return false;
        }

        for (int i = atSignPosition + 1; i < mail.length(); i++) {
            //    System.out.println("Checking . position : " + i);
            if (mail.charAt(i) == '.') {

                pointPosition = i;
                //        System.out.println("FOUND . : " + i);

            }
        }

        if (pointPosition == -1) {
            return false;
        }

        String substrBfrAt = mail.substring(0, atSignPosition);
        //    System.out.println(substrBfrAt);
        //    System.out.println("First part lenght : " + substrBfrAt.length());

        if (substrBfrAt.length() < 2) {
            return false;
        }

        String substrBtwAtAndPt = mail.substring(atSignPosition + 1, pointPosition);
        //    System.out.println(substrBtwAtAndPt);
        //     System.out.println("Middle part lenght : " + substrBtwAtAndPt.length());

        if (substrBtwAtAndPt.length() < 2) {

            return false;
        }

        String substrAftPt = mail.substring(pointPosition + 1, mail.length());
        //     System.out.println(substrAftPt);
        //      System.out.println("Laster part lenght :" + substrAftPt.length());
        if (substrAftPt.length() < 2) {

            return false;
        }

        return true;
    }

    /**
     * Performs concatenation of toString from a <b>Personne</b> list
     *
     * @param personnes
     * @return A string of concatenated String object
     */
    public static String toStringList(List<Personne> personnes) {

        String listing = "";

        for (Personne personne : personnes) {

            listing += personne.toString() + "\n";

        }

        return listing;
    }

    /**
     *
     * @param personnes a list of <b>Personne</b> objects
     * @see Personne
     * @return An integer value equals to the average of all Personne instance
     * provided by the list
     */
    public static int averageAge(List<Personne> personnes) {

        int somme = 0;
        for (Personne personne : personnes) {

            somme += personne.getAge();

        }
        int moy = (int) (somme / personnes.size());

        return moy;
    }

    /**
     * Determine the median age value of a <b>Personne</b> list.
     *
     * @param personnes
     * @return median age value
     */
    public static int medianAge(List<Personne> personnes) {

        int median = 0;
        Collections.sort(personnes);

        int indexMedian = (personnes.size() + 1) / 2;
        System.out.println(indexMedian);
        median = personnes.get(indexMedian).getAge();

        return median;
    }

}
