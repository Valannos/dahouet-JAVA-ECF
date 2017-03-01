/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.CodeResultat;
import com.afpa.dahouet.model.Concurrent;
import com.afpa.dahouet.model.Participation;
import com.afpa.dahouet.model.Regate;
import com.afpa.dahouet.model.Voilier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
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
        String sql = "SELECT part.id, part.id_Regate, part.tpsReel, part.numVoile_Voilier, part.numLicence_Concurrent  FROM participation part";

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
/**
 * Fetch in database for all Participations in a single Regate where NO results has not been yet colleted
 * @param regate
 * @return A list of Participation
 */
    public static List<Participation> findFromRegateWithoutResult(Regate regate) {

        List<Participation> participations = new ArrayList<>();

        Connection connection = DBConnection.gettingConnected();
        String sql = "SELECT part.id, part.id_Regate, part.tpsReel, part.numVoile_Voilier, part.numLicence_Concurrent  FROM participation part WHERE part.id_Regate = ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, regate.getId());

            ResultSet rs = ps.executeQuery();

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
/**
 * Return a list of Participation with Skipper, Voilier and Commissaire using a constructor that define no result
 * @param regate
 * @return list of Participation
 */
    public static List<Participation> findFromRegateWithResults(Regate regate) {

        List<Participation> participations = new ArrayList<>();
        Connection connection = DBConnection.gettingConnected();

        String sql = "SELECT p.id, p.tpsComp, p.tpsReel, p.rangReg, p.scrReg, p.numVoile_Voilier, p.numLicence_Concurrent, p.id_Codes_Resultats FROM participation p WHERE p.id_Regate = ?";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setString(1, regate.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("p.id");
                Time tpsReg = rs.getTime("p.tpsComp");
                Time tpsReel = rs.getTime("p.tpsReel");
                int scrReg = rs.getInt("p.scrReg");

                Voilier voilier = VoilierDAO.finById(rs.getInt("p.numVoile_Voilier"));
                Concurrent skipper = ConcurrentDAO.findById(rs.getInt("p.numLicence_Concurrent"));
                CodeResultat codeResultat = CodeResultatDAO.findById(rs.getInt("p.id_Codes_Resultats"));
                Participation participation = new Participation(id, tpsReg, tpsReel, scrReg, regate, voilier, skipper, codeResultat);
                participations.add(participation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return participations;

    }

}
