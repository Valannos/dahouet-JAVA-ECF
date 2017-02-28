/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.Concurrent;
import com.afpa.dahouet.model.Participation;
import com.afpa.dahouet.model.Regate;
import com.afpa.dahouet.model.Voilier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Afpa
 */
public class ParticipationDAO {

    public static List<Participation> findAllWithoutResult() {

        List<Participation> participations = new ArrayList<>();

        Connection connection = DBConnection.gettingConnected();
        String sql = "SELECT part.id, part.id_Regate, part.numVoile_Voilier, part.numLicence_Concurrent  FROM participation part";

        try {

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("part.id");
                Regate regate = RegateDAO.findById(rs.getString("part.id_Regate"));
                Voilier voilier = VoilierDAO.finById(rs.getInt("part.numVoile_Voilier"));
                Concurrent skipper = ConcurrentDAO.findById(rs.getInt("part.numLicence_Concurrent"));
                Participation p = new Participation(id, regate, voilier, skipper);
                participations.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ParticipationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participations;
    }

    public static List<Participation> findAllWithResults() {
        return null;

    }

    public static List<Participation> findAllWithoutResultFromRegate(Regate regate) {
       
         List<Participation> participations = new ArrayList<>();

        Connection connection = DBConnection.gettingConnected();
        String sql = "SELECT part.id, part.id_Regate, part.numVoile_Voilier, part.numLicence_Concurrent  FROM participation part WHERE part.id_Regate = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, regate.getId());
            
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("part.id");
                
                Voilier voilier = VoilierDAO.finById(rs.getInt("part.numVoile_Voilier"));
                Concurrent skipper = ConcurrentDAO.findById(rs.getInt("part.numLicence_Concurrent"));
                Participation p = new Participation(id, regate, voilier, skipper);
                participations.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ParticipationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participations;

    }

    public static List<Participation> findAllWithResultsFromRegate(Regate regate) {
        return null;

    }

}
