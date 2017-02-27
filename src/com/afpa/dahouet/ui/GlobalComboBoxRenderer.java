/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.ui;

import com.afpa.dahouet.model.ClasseVoilier;
import com.afpa.dahouet.model.ClubNautique;
import com.afpa.dahouet.model.Proprietaire;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 *
 * @author Afpa
 */
public class GlobalComboBoxRenderer extends BasicComboBoxRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        
         super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
         if (value instanceof ClubNautique) {
            
             ClubNautique clubNautique = (ClubNautique) value;
             setText(clubNautique.getNomClub());
             
        } 
         if (value instanceof Proprietaire) {
            
             Proprietaire proprietaire = (Proprietaire) value;
             setText(proprietaire.getFirstname() + " " + proprietaire.getName());
             
        }
         if (value instanceof ClasseVoilier) {
            
             ClasseVoilier classeVoilier = (ClasseVoilier) value;
             setText(classeVoilier.getName());
        }
         return this;
    }
    
}
