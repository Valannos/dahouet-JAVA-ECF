/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.ui;

import com.afpa.dahouet.DAO.ClasseVoilierDAO;
import com.afpa.dahouet.model.ClasseVoilier;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Afpa
 */
public class JComboBoxModel_Classe extends DefaultComboBoxModel {

    private List<ClasseVoilier> cvs;

    public JComboBoxModel_Classe(char s) {
        super();
        this.cvs = ClasseVoilierDAO.findBySerie(s);
    }

    @Override
    public int getIndexOf(Object anObject) {

        return this.cvs.indexOf(anObject);
    }

    @Override
    public Object getElementAt(int index) {
        return this.cvs.get(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        return this.cvs.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClasseVoilier getSelectedItem() {
        return (ClasseVoilier) super.getSelectedItem(); //To change body of generated methods, choose Tools | Templates.
    }

}
