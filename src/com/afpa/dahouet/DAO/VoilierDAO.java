/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.Voilier;
import java.sql.Connection;
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
        
        List<Voilier> voil = new ArrayList<>();
        
        Connection connect = DBConnection.gettingConnected();
        Statement state = null;
        
        try {
            
            state = connect.createStatement();
            String sql = "SELECT ";
            
            
        } catch (SQLException ex) {
            Logger.getLogger(VoilierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return voil;
    }
    
}
