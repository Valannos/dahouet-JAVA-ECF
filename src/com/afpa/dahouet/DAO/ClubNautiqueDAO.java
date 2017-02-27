/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.ClubNautique;
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
public class ClubNautiqueDAO {

    public static List<ClubNautique> findAll() {

        List<ClubNautique> clubNautiques = new ArrayList<>();

        Connection connect = DBConnection.gettingConnected();
        try {
            Statement state = connect.createStatement();

            String sql = "SELECT cn.nomClub, cn.id FROM club_nautique cn";
            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {

                String nomClub = rs.getString("cn.nomClub");
                int id = rs.getInt("cn.id");
                ClubNautique clubNautique = new ClubNautique(id, nomClub);
              //  System.out.println(clubNautique.getNomClub());
                clubNautiques.add(clubNautique);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClasseVoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clubNautiques;
    }

    public static ClubNautique findById(int id) {

        ClubNautique clubNautique = null;

        PreparedStatement state = null;
        ResultSet rs = null;
        Connection connect = DBConnection.gettingConnected();

        try {

            String sql = "SELECT * FROM club_nautique WHERE id = ?";
            state = connect.prepareStatement(sql);
            state.setInt(1, id);
            rs = state.executeQuery();
            while (rs.next()) {

                String nomClub = rs.getString("nomClub");
                clubNautique = new ClubNautique(id, nomClub);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClubNautiqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clubNautique;
    }

}
