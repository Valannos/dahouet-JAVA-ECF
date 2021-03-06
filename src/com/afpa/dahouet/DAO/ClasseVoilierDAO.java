/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.ClasseVoilier;
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
 * @author Valannos
 */
public class ClasseVoilierDAO {

    /**
     * Fetch ClasseVoilier from database and build a list of ClasseVoilier
     * objcts
     *
     * @return a list of ClassVoilier
     */
    public static List<ClasseVoilier> findAll() {

        List<ClasseVoilier> cvs = new ArrayList<>();
        Statement state = null;
        ResultSet rs = null;
        Connection connect = DBConnection.gettingConnected();
        try {
            state = connect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ClasseVoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT * FROM classe";
        try {
            rs = state.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nomClasse = rs.getString("nomClasse");
                double coefClasse = rs.getDouble("coefClasse");
                char typeSerie = rs.getString("typeSerie").charAt(0);
                ClasseVoilier cv = new ClasseVoilier(id, nomClasse, typeSerie, coefClasse);
                cvs.add(cv);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClasseVoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cvs;
    }

    public static ClasseVoilier findById(int id) {

        ClasseVoilier cv = null;
        PreparedStatement state = null;

        Connection connect = DBConnection.gettingConnected();
        try {
            String sql = "SELECT * FROM classe WHERE id = ?";
            state = connect.prepareStatement(sql);
            state.setInt(1, id);
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                String nomClasse = rs.getString("nomClasse");
                double coefClasse = rs.getDouble("coefClasse");
                char typeSerie = rs.getString("typeSerie").charAt(0);
                cv = new ClasseVoilier(id, nomClasse, typeSerie, coefClasse);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClasseVoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cv;
    }
/**
 * Fetch in databse 
 * @param s
 * @return 
 */
    public static List<ClasseVoilier> findBySerie(char s) {

        List<ClasseVoilier> classeVoiliers = new ArrayList<>();
        Statement state = null;
        String sql = null;
        if (s == 'H') {

            sql = "SELECT * FROM classe c WHERE c.typeSerie = 'H'";

        } else if (s == 'Q') {
            sql = "SELECT * FROM classe c WHERE c.typeSerie = 'Q'";
        }

        Connection connect = DBConnection.gettingConnected();
        try {

            state = connect.createStatement();

            ResultSet rs = state.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomClasse = rs.getString("nomClasse");
                double coefClasse = rs.getDouble("coefClasse");
                char typeSerie = rs.getString("typeSerie").charAt(0);
                ClasseVoilier cv = new ClasseVoilier(id, nomClasse, typeSerie, coefClasse);
                classeVoiliers.add(cv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClasseVoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return classeVoiliers;
    }

}
