/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.Challenge;
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

public class ChallengeDAO {

    public static List<Challenge> findAll() {
        String sql = "SELECT c.id, c.debChal, c.finChal FROM challenge c ";
        List<Challenge> challenges = new ArrayList<>();

        try {

            Connection connection = DBConnection.gettingConnected();
            Statement state = connection.createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            while (rs.next()) {
                     String id = rs.getString("c.id");
            Date startingDate = rs.getDate("c.debChal");
            Date endingDate = rs.getDate("c.finChal");
            Challenge challenge = new Challenge(id, startingDate, endingDate);
            challenges.add(challenge);
                
                
            }
       

        } catch (SQLException ex) {
            Logger.getLogger(ChallengeDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return challenges;

    }

    public static Challenge findById(String id) {

        String sql = "SELECT c.debChal, c.finChal FROM challenge c WHERE c.id = ?";
        Challenge challenge = null;

         try {

            Connection connection = DBConnection.gettingConnected();
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setString(1, id);
             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {
              
                 Date debChal = rs.getDate("c.debChal");
                 Date finChal = rs.getDate("c.finChal");
                 
                 challenge = new Challenge(id, finChal, finChal);
                 
                 
             }

        } catch (SQLException ex) {
            Logger.getLogger(ChallengeDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return challenge;
    }
    
    public static Challenge getCurrentChallenge() {
        
        Challenge challenge = null;
                
                 String sql = "SELECT c.id, c.debChal, c.finChal FROM challenge c WHERE c.debChal < CURRENT_DATE AND c.finChal > CURRENT_DATE ";
      

         try {

            Connection connection = DBConnection.gettingConnected();
            Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql);
             while (rs.next()) {
              
                 Date debChal = rs.getDate("c.debChal");
                 Date finChal = rs.getDate("c.finChal");
                 String id = rs.getString("c.id");
                 
                 challenge = new Challenge(id, finChal, finChal);
                 
                 
             }

        } catch (SQLException ex) {
            Logger.getLogger(ChallengeDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return challenge;
        
        
        
        
    }

}
