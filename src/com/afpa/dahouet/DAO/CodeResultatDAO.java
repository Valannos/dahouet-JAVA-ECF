/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.ClasseVoilier;
import com.afpa.dahouet.model.ClubNautique;
import com.afpa.dahouet.model.CodeResultat;
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
public class CodeResultatDAO {

    public static List<CodeResultat> findAll() {

        List<CodeResultat> crs = new ArrayList<>();
        Statement state = null;
        ResultSet rs = null;
        Connection connect = DBConnection.gettingConnected();
        try {
            state = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseVoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM codes_resultats";
        try {
            rs = state.executeQuery(sql);

            while (rs.next()) {

                String code = rs.getString("code");
                int id = rs.getInt("id");
                CodeResultat cr = new CodeResultat(code, id);
                crs.add(cr);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClasseVoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return crs;
    }

    public static CodeResultat findById(int id) {

        CodeResultat codeResultat = null;

        PreparedStatement state = null;
        ResultSet rs = null;
        Connection connect = DBConnection.gettingConnected();

        try {

            String sql = "SELECT * FROM codes_resultats WHERE id = ?";
            state = connect.prepareStatement(sql);
            state.setInt(1, id);
            rs = state.executeQuery();
            while (rs.next()) {

                String code = rs.getString("code");
                codeResultat = new CodeResultat(code, id);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClubNautiqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codeResultat;
    }

}
