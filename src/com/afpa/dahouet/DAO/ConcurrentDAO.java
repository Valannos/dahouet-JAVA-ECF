/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import com.afpa.dahouet.model.Concurrent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valannos
 */
public class ConcurrentDAO {

    public static List<Concurrent> findAll() {

        List<Concurrent> concurrents = new ArrayList<>();
        Connection connect = DBConnection.gettingConnected();
        try {
            Statement state = connect.createStatement();
            String sql = "SELECT c.numLicence, c.anneeLic, p.nomPersonne, p.prenomPersonne, p.dateNaissance FROM concurrent c INNER JOIN personne p ON p.id = c.id_Personne";
            ResultSet rs = state.executeQuery(sql);
            Date date = rs.getDate("p.dateNaissance");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            Concurrent concurrent = new Concurrent(rs.getInt("c.numLicence"), rs.getInt("c.anneeLic"), rs.getString("p.nomPersonne"), rs.getString("p.prenomPersonne"), cal.get(Calendar.YEAR));
            concurrents.add(concurrent);
        } catch (SQLException ex) {
            Logger.getLogger(ConcurrentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return concurrents;
    }

    public static Concurrent findById(int id) {

        Concurrent concurrent = null;
        Connection connect = DBConnection.gettingConnected();
        String sql = "SELECT c.numLicence, c.anneeLic, p.nomPersonne, p.prenomPersonne, p.dateNaissance FROM concurrent c INNER JOIN personne p ON p.id = c.id_Personne WHERE c.numLicence = ?";
        
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                
                int numLicence = rs.getInt("c.numLicence");
                int anneeLic = rs.getInt("c.anneeLic");
                String name = rs.getString("p.nomPersonne");
                String firstname = rs.getString("p.firstname");
                Date dateNaissance = rs.getDate("p.dateNaissance");
                Calendar c = Calendar.getInstance();
                c.setTime(dateNaissance);
                int anneeNaissance = c.get(Calendar.YEAR);
                
                concurrent = new Concurrent(numLicence, anneeLic, name, firstname, anneeNaissance);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConcurrentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        return concurrent;
    }

}
