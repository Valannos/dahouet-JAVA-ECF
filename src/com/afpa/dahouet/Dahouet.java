/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet;

import com.afpa.dahouet.DAO.ChallengeDAO;
import com.afpa.dahouet.DAO.ParticipationDAO;
import com.afpa.dahouet.DAO.RegateDAO;
import com.afpa.dahouet.model.*;
import com.afpa.dahouet.model.Licencie;
import com.afpa.dahouet.ui.VoilierForm;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 *
 * @author Afpa
 */
public class Dahouet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* UI */
        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Dahouet.class.getName()).log(Level.SEVERE, null, ex);
        }
        VoilierForm win = new VoilierForm();
        win.setVisible(true);

        /* CONSOLE */
        System.out.println(Color.ANSI_PURPLE + "****RESULTATS ALGORITHMIE & OBJECT****" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_PURPLE + "----Creation d'une liste de personnes----" + Color.ANSI_RESET);
        List<Personne> personnes = new ArrayList<>();

        Licencie lic1 = new Licencie(100, 100, 2016, "Nagepas", "Jean-Michel", "jmng@plouf.fr", 1980);
        personnes.add(lic1);
        Licencie lic2 = new Licencie(100, 150, 2017, "Le Gall", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic2);
        Licencie lic3 = new Licencie(100, 200, 2017, "Le Floc\'h", "Nicolas", "jmng@plouf.fr", 1995);
        personnes.add(lic3);
        Commissaire comi1 = new Commissaire("Sud-Bretagne", "Goff", "Erwann", "ccc@ccc.com", 1970);
        personnes.add(comi1);
        Proprietaire pro1 = new Proprietaire("Le Hire", "Dédé", "sfggf@gsr.fr", 1965);
        personnes.add(pro1);
        Proprietaire pro2 = new Proprietaire("Le Gronec", "Gwen", "sdfgdsfg@sdfg.com", 1975);
        personnes.add(pro2);

        Date date = new Date();
        System.out.println(Color.ANSI_YELLOW + "Longueur de la liste : " + Color.ANSI_RESET + personnes.size());
        System.out.println(Color.ANSI_PURPLE + "----Calcul de la moyenne et de la médiane----" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_YELLOW + "Moyenne d\'âge : " + Color.ANSI_RESET + Utils.averageAge(personnes));
        System.out.println(Color.ANSI_YELLOW + "Valeur médiane : " + Color.ANSI_RESET + Utils.medianAge(personnes));
        System.out.println(Color.ANSI_PURPLE + "----Affichage des personnes----" + Color.ANSI_RESET);
        System.out.print(Utils.toStringList(personnes));

        System.out.println(Color.ANSI_PURPLE + "----Ajout d'une personne----" + Color.ANSI_RESET);

        personnes.add(new Commissaire("Normadie", "Jacq", "Daniel", "Blo@fgf.fr", 1985));
        System.out.println(Color.ANSI_YELLOW + "Longueur de la liste : " + Color.ANSI_RESET + personnes.size());
        System.out.println(Color.ANSI_BLUE + personnes.get(personnes.size() - 1).toString());
        System.out.println(Color.ANSI_PURPLE + "----Calcul de la moyenne et de la médiane----" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_YELLOW + "Moyenne d\'âge : " + Color.ANSI_RESET + Utils.averageAge(personnes));
        System.out.println(Color.ANSI_YELLOW + "Valeur médiane : " + Color.ANSI_RESET + Utils.medianAge(personnes));
        System.out.println(Color.ANSI_PURPLE + "----Test de la méthode de calcul de points----" + Color.ANSI_RESET);
        try {
            double pts = lic1.calculPoints(date, 20.5);
            System.out.print(Color.ANSI_YELLOW + "Nombre de pts : " + Color.ANSI_RESET + pts);
        } catch (MismatchYearsException e) {

            System.err.println("ERREUR : " + e.getClass() + " : " + e.getMessage());
        }

        try {
            double pts = lic2.calculPoints(date, 20.5);
            System.out.println(Color.ANSI_YELLOW + "Nombre de pts : " + Color.ANSI_RESET + pts);
        } catch (MismatchYearsException e) {

            System.err.println("ERREUR : " + e.getClass() + " : " + e.getMessage());
        }
        try {
            double pts = lic3.calculPoints(date, 20.5);
            System.out.println(Color.ANSI_YELLOW + "Nombre de pts : " + Color.ANSI_RESET + pts);
        } catch (MismatchYearsException e) {

            System.err.println("ERREUR : " + e.getClass() + " : " + e.getMessage());
        }

        System.out.println(Color.ANSI_PURPLE + "****FIN RESULTATS ALGORITHMIE & POO****" + Color.ANSI_RESET);

        /* FIN CONSOLE */
        get("/hello", (Request req, Response res) -> {

            List<Challenge> cs = ChallengeDAO.findAll();
            Gson gson = new Gson();
            String json = gson.toJson(cs);
            return json;
        });

        /**
         * Return current Challenge based on local date
         */
        get("/currentChallenge", (Request req, Response res) -> {

            Challenge challenge = ChallengeDAO.getCurrentChallenge();
            Gson gson = new Gson();
            String json = gson.toJson(challenge);
            res.type("application/json");
            return json;

        }
        );

        get("/currentRegates", (Request req, Response res) -> {

            Challenge challenge = ChallengeDAO.getCurrentChallenge();
            List<Regate> regates = RegateDAO.findByChallenge(challenge);
            Gson gson = new Gson();
            res.type("application/json");
            return gson.toJson(regates);

        });

        get("/participation", (Request req, Response res) -> {
            Gson gson = new Gson();
            Challenge challenge = ChallengeDAO.getCurrentChallenge();
            List<Regate> regates = RegateDAO.findByChallenge(challenge);
            List<Participation> participations = new ArrayList<>();
            for (Regate regate : regates) {

                participations.addAll(ParticipationDAO.findFromRegateWithResults(regate));

            }
            gson.toJson(participations);
            return gson.toJson(participations);

        });

        get("/participations_without_result/:id", (req, res) -> {

            String id = req.params(":id");
            Regate regate = RegateDAO.findById(id);
            List<Participation> participations = ParticipationDAO.findFromRegateWithoutResult(regate);
            Gson gson = new Gson();
            String json = gson.toJson(participations);

            res.type("application/json");

            return json;
        });

        get("/participations_with_result/:id", (req, res) -> {

            String id = req.params(":id");
            Regate regate = RegateDAO.findById(id);
            List<Participation> participations = ParticipationDAO.findFromRegateWithResults(regate);
            Gson gson = new Gson();
            String json = gson.toJson(participations);

            res.type("application/json");

            return json;
        });

    }

//         List<Proprietaire> proprietaires = ProprietaireDAO.findAll();
//        for (Proprietaire proprietaire : proprietaires) {
//            
//            System.out.println(proprietaire.toString() +proprietaire.getClubNautique().getNomClub());
//            
//        }
//        List<Voilier> vs = VoilierDAO.findAll();
//        for (Voilier v : vs) {
//            System.out.println(v.getNom());
//        }
}
