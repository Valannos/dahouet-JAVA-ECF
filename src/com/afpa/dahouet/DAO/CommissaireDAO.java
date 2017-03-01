/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.Commissaire;
import com.afpa.dahouet.model.Regate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Afpa
 */
public class CommissaireDAO {

    public static Commissaire finById(int id) {

        Commissaire commissaire = null;

        Connection connect = DBConnection.gettingConnected();
        try {

            String sql = "SELECT c.id, p.nomPersonne, p.prenomPersonne, p.dateNaissance, cr.nomComite FROM comissaire c\n"
                    + "INNER JOIN personne p \n"
                    + "ON c.id_Personne = p.id\n"
                    + "INNER JOIN comite_regional cr \n"
                    + "ON cr.id = c.id_Comite_Regional\n"
                    + "WHERE c.id = ?";
            PreparedStatement state = connect.prepareStatement(sql);
            state.setInt(1, id);

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {

                String name = rs.getString("p.nomPersonne");
                String firstname = rs.getString("p.prenomPersonne");
                Date date = rs.getDate("p.dateNaissance");
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int anneeNaissance = c.get(Calendar.YEAR);
                String nameComite = rs.getString("cr.nomComite");
                commissaire = new Commissaire(nameComite, name, firstname, anneeNaissance);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CommissaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return commissaire;
    }
/**
 * Fetch in database for a list of Commissaires in charge of Regate supervision
 * 
 * @param regate
 * @return A List of Commissaire objects
 */
    public static List<Commissaire> findCommissairesFromRegate(Regate regate) {

        List<Commissaire> comissaires = new ArrayList<>();
        Connection connect = DBConnection.gettingConnected();
        try {

            String sql = "SELECT c.id, p.nomPersonne, p.prenomPersonne, p.dateNaissance, cr.nomComite FROM comissaire c INNER JOIN personne p ON c.id_Personne = p.id INNER JOIN juger j ON j.id_Comissaire = c.id INNER JOIN comite_regional cr ON cr.id = c.id_Comite_Regional WHERE j.id_Regate = ?";
            PreparedStatement state = connect.prepareStatement(sql);
                  System.out.println(" " +regate.getId());
         state.setString(1, regate.getId());

            ResultSet rs = state.executeQuery();

            while (rs.next()) {

                String name = rs.getString("p.nomPersonne");
                String firstname = rs.getString("p.prenomPersonne");
                Date date = rs.getDate("p.dateNaissance");
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                int anneeNaissance = c.get(Calendar.YEAR);
                String nameComite = rs.getString("cr.nomComite");
                Commissaire commissaire = new Commissaire(nameComite, name, firstname, anneeNaissance);
                comissaires.add(commissaire);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConcurrentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comissaires;
    }

}
