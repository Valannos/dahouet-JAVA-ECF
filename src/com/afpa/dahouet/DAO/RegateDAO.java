/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.Challenge;
import com.afpa.dahouet.model.Commissaire;
import com.afpa.dahouet.model.Regate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valannos
 */
public class RegateDAO {

    public static List<Regate> findAll() {

        List<Regate> regates = new ArrayList<>();
        String sql = "SELECT reg.id, reg.dateReg, reg.distance, reg.id_Challenge FROM regate reg";
        Connection connection = DBConnection.gettingConnected();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {

                Challenge challenge = ChallengeDAO.findById(rs.getString("reg.id_Challenge"));
                Date dateReg = rs.getDate("reg.dateReg");
                double distance = rs.getDouble("reg.distance");
                String id = rs.getString("reg.id");

                Regate regate = new Regate(id, dateReg, distance, challenge);
                List<Commissaire> commissaire = CommissaireDAO.findCommissairesFromRegate(regate);
                regate.setCommissaires(commissaire);
                regates.add(regate);

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return regates;
    }

    public static Regate findById(String id) {

        Regate regate = null;
        Connection connection = DBConnection.gettingConnected();
        String sql = "SELECT reg.dateReg, reg.distance, reg.id_Challenge, chal.debChal, chal.finChal FROM regate reg INNER JOIN challenge chal ON chal.id = reg.id_Challenge WHERE reg.id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Challenge challenge = ChallengeDAO.findById(rs.getString("reg.id_Challenge"));
                Date dateReg = rs.getDate("reg.dateReg");
                double distance = rs.getDouble("reg.distance");

                regate = new Regate(id, dateReg, distance, challenge);
                List<Commissaire> commissaire = CommissaireDAO.findCommissairesFromRegate(regate);
                regate.setCommissaires(commissaire);

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return regate;
    }

}
