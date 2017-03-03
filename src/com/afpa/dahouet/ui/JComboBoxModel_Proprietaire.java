/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.ui;

import com.afpa.dahouet.DAO.ProprietaireDAO;
import com.afpa.dahouet.model.ClubNautique;
import com.afpa.dahouet.model.Proprietaire;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Afpa
 */
public class JComboBoxModel_Proprietaire extends DefaultComboBoxModel{
    
    private List<Proprietaire> proprietaires;

    public JComboBoxModel_Proprietaire(ClubNautique clubNautique) {

        this.proprietaires = ProprietaireDAO.findByClubNautique(clubNautique);
    }

    @Override
    public int getIndexOf(Object anObject) {
        return this.proprietaires.indexOf(anObject);
    }

    @Override
    public Object getElementAt(int index) {
        return proprietaires.get(index);
    }

    @Override
    public int getSize() {
        return this.proprietaires.size(); 
    }

    @Override
    public void addElement(Object anObject) {
        
        Proprietaire p = (Proprietaire) anObject;
        this.proprietaires.add(p);
        this.fireIntervalAdded(anObject, 0, 0);
        
    }
    
    
    

    
    
    
    
    
}
