/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.ui;

import com.afpa.dahouet.DAO.ClubNautiqueDAO;
import com.afpa.dahouet.model.ClubNautique;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Afpa
 */
public class JComboBoxModel_ClubNautique extends DefaultComboBoxModel{

    private List<ClubNautique> clubNautiques;

    public JComboBoxModel_ClubNautique() {
        super();
        clubNautiques = ClubNautiqueDAO.findAll();
        
    }

    @Override
    public int getIndexOf(Object anObject) {
        return this.clubNautiques.indexOf(anObject); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getElementAt(int index) {
        return this.clubNautiques.get(index).getNomClub(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        return this.clubNautiques.size(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    
    
    
    
   

  



  
    
  

    
    
    
  
    
    
    
    
    
    
    
    
}
