/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.Proprietaire;
import java.sql.Connection;
import java.sql.Date;
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
            String sql = "SELECT pers.nomPersonne, pers.prenomPersonne, pers.dateNaissance FROM proprietaire pro INNER JOIN personne pers ON pers.id = pro.id_Personne";
            ResultSet res = state.executeQuery(sql);
            
            while (res.next()) {
                
                Date date = res.getDate("pers.dateNaissance");
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                Proprietaire pro = new Proprietaire(res.getString("pers.prenomPersonne"), res.getString("pers.nomPersonne"), cal.get(Calendar.YEAR));
                proprietaires.add(pro);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return proprietaires;
    }
    
    
}
