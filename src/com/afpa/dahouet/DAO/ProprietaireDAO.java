/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.ClubNautique;
import com.afpa.dahouet.model.Proprietaire;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valannos
 */
public class ProprietaireDAO {
    
    public static List<Proprietaire> findAll() {
        
        List<Proprietaire> proprietaires = new ArrayList<>();
        
        Connection connect = DBConnection.gettingConnected();
        Statement state = null;
        
        try {
            
            state = connect.createStatement();
            String sql = "SELECT pers.id, pers.nomPersonne, pers.prenomPersonne, pers.dateNaissance, pro.id, pro.id_Club_Nautique FROM proprietaire pro INNER JOIN personne pers ON pers.id = pro.id_Personne";
            ResultSet res = state.executeQuery(sql);
            
            while (res.next()) {
                
                Date date = res.getDate("pers.dateNaissance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int id = res.getInt("pers.id");
                int id_Pro = res.getInt("pro.id");
                ClubNautique clubNautique = ClubNautiqueDAO.findById(res.getInt("pro.id_Club_Nautique"));
                Proprietaire pro = new Proprietaire(clubNautique, id, id_Pro, res.getString("pers.nomPersonne"), res.getString("pers.prenomPersonne"), cal.get(Calendar.YEAR));
                proprietaires.add(pro);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proprietaires;
    }

    /**
     * Fetch in database a Proprietaire object based on id_Proprietaire
     *
     * @param id
     * @return Proprietaire object
     */
    public static Proprietaire findByProprietaireId(int id) {
        
        Proprietaire pro = null;
        Connection connect = DBConnection.gettingConnected();
        PreparedStatement ps = null;
        
        try {
            
            String sql = "SELECT pers.nomPersonne, pers.id, pers.prenomPersonne, pers.dateNaissance, pro.id_Club_Nautique FROM proprietaire pro INNER JOIN personne pers ON pers.id = pro.id_Personne WHERE pro.id = ?";
            ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                
                Date date = res.getDate("pers.dateNaissance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int id_Personne = res.getInt("pers.id");
                ClubNautique clubNautique = ClubNautiqueDAO.findById(res.getInt("pro.id_Club_Nautique"));
                pro = new Proprietaire(clubNautique, id_Personne, id, res.getString("pers.nomPersonne"), res.getString("pers.prenomPersonne"), cal.get(Calendar.YEAR));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pro;
    }

    /**
     * Fetch in database a list of Proprietaire affilated to the same
     * ClubNautique
     *
     * @param clubNautique
     * @return
     */
    public static List<Proprietaire> findByClubNautique(ClubNautique clubNautique) {
        
        List<Proprietaire> proprietaires = new ArrayList<>();
        
        Connection connect = DBConnection.gettingConnected();
        
        try {
            String sql = "SELECT pers.id, pers.nomPersonne, pers.prenomPersonne, pro.id, pers.dateNaissance FROM proprietaire pro INNER JOIN personne pers ON pers.id = pro.id_Personne WHERE pro.id_Club_Nautique = ?";
            PreparedStatement state = connect.prepareStatement(sql);
            state.setInt(1, clubNautique.getId());
            ResultSet res = state.executeQuery();
            
            while (res.next()) {
                
                Date date = res.getDate("pers.dateNaissance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int id = res.getInt("pers.id");
                int id_Pro = res.getInt("pro.id");
                Proprietaire pro = new Proprietaire(clubNautique, id, id_Pro, res.getString("pers.nomPersonne"), res.getString("pers.prenomPersonne"), cal.get(Calendar.YEAR));
                proprietaires.add(pro);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proprietaires;
        
    }

    /**
     * this method fetch in database the id value of a <b>Proprietaire</b>
     * instance
     *
     * @param p : An instance of Proprietaire
     * @return identifier of related Personne
     */
    @Deprecated
    public static int getProprietaireId(Proprietaire p) {
        
        Connection connect = DBConnection.gettingConnected();
        int id = 0;
        
        try {
            String sql = "SELECT id FROM proprietaire WHERE id_Personne = ?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ResultSet resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                
                id = resultSet.getInt("id");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProprietaireDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
    
    public static int insertProprietaire(Proprietaire proprietaire) {
        
        int id_Pro = 0;
        int id = 0;
        
        Connection connection = DBConnection.gettingConnected();
        String sql = "INSERT INTO personne (nomPersonne, prenomPersonne, dateNaissance) VALUES (?,?,?)";
        String sql_pro = "INSERT INTO proprietaire (id_Personne, id_Club_Nautique) VALUES (?,?)";
        
        try {
            
            System.out.println(proprietaire.getDateNaissance() + " " + proprietaire.getFirstname() + " " + proprietaire.getName() + " " + proprietaire.getClubNautique().getNomClub());
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proprietaire.getName());
            ps.setString(2, proprietaire.getFirstname());
            ps.setDate(3, new java.sql.Date(proprietaire.getDateNaissance().getTime()));
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            PreparedStatement ps = connection.prepareStatement(sql_pro, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, proprietaire.getClubNautique().getId());
            
             ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                id_Pro = generatedKeys.getInt(1);
            }
            
            
        } catch (Exception e) {
        }
        
        
        
        return id_Pro;
    }
    
}
