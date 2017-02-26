/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.*;

import java.sql.Connection;
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
            
            while  (res.next()) {
                
               int id = res.getInt("v.numVoile");
               String nomVoilier = res.getString("v.nomVoilier");
               int idPro = res.getInt("v.id_Proprietaire");
               int idClVo = res.getInt("v.id_Classe");
               Proprietaire pro = ProprietaireDAO.findById(idPro);
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
        
        return v;
    }
    
}