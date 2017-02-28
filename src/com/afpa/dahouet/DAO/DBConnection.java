/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Valannos
 */
public class DBConnection {

    final static private String URL_DB = "jdbc:mysql://localhost:3306/dahouet";
    final static private String LOGIN_DB = "root";
    final static private String PASSWORD_DB = "";

    public static Connection gettingConnected() {

        Connection connect = null;

        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            connect = DriverManager.getConnection(URL_DB, LOGIN_DB, PASSWORD_DB);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return connect;

    }

}
