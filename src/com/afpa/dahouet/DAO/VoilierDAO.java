/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.*;

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
public class VoilierDAO {

    public static List<Voilier> findAll() {

        List<Voilier> voiliers = new ArrayList<>();

        Connection connect = DBConnection.gettingConnected();
        Statement state = null;

        try {

            state = connect.createStatement();
            String sql = "SELECT v.numVoile, v.nomVoilier, v.id_Classe, v.id_Proprietaire FROM voilier v ";
            ResultSet res = state.executeQuery(sql);

            while (res.next()) {

                int id = res.getInt("v.numVoile");
                String nomVoilier = res.getString("v.nomVoilier");
                int idPro = res.getInt("v.id_Proprietaire");
                int idClVo = res.getInt("v.id_Classe");
                Proprietaire pro = ProprietaireDAO.findByProprietaireId(idPro);
                ClasseVoilier cv = ClasseVoilierDAO.findById(idClVo);
                Voilier voilier = new Voilier(pro, cv, nomVoilier, id);
                voiliers.add(voilier);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return voiliers;
    }

    public static Voilier finById(int id) {

        Voilier v = null;

        Connection connection = DBConnection.gettingConnected();
        String sql = "SELECT v.nomVoilier, v.id_Proprietaire, v.id_Classe FROM voilier v WHERE v.numVoile = ?";

        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String nomVoilier = rs.getString("v.nomVoilier");
                Proprietaire proprietaire = ProprietaireDAO.findByProprietaireId(rs.getInt("v.id_Proprietaire"));
                ClasseVoilier cv = ClasseVoilierDAO.findById(rs.getInt("v.id_Classe"));
                v = new Voilier(proprietaire, cv, nomVoilier);
                

            }

        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v;
    }

    public static int insertVoilier(Voilier v) {

        Connection connection = DBConnection.gettingConnected();
        String sql = "INSERT INTO voilier(nomVoilier, id_Proprietaire, id_Classe) VALUES (?,?,?)";
        int id = 0;
        try {

            System.out.println(v.getPro().getId() + " " + v.getPro().getName() + " " + v.getClasse().getId() + " " + v.getNom());
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, v.getNom());
            ps.setInt(2, v.getPro().getId_Pro());
            ps.setInt(3, v.getClasse().getId());
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

}
