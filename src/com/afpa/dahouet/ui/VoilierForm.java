/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.dahouet.ui;

import com.afpa.dahouet.DAO.VoilierDAO;
import com.afpa.dahouet.model.ClasseVoilier;
import com.afpa.dahouet.model.ClubNautique;
import com.afpa.dahouet.model.Proprietaire;
import com.afpa.dahouet.model.Voilier;
import javax.swing.JOptionPane;

/**
 *
 * @author Afpa
 */
public class VoilierForm extends javax.swing.JFrame {
    
    JComboBoxModel_Proprietaire boxModel_Proprietaire;

    /**
     * Creates new form VoilierForm
     */
    public VoilierForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jPanel_List = new javax.swing.JPanel();
        jLabel_ListVoilier = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel_Form = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_Proprietaire = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox_H = new javax.swing.JCheckBox();
        jCheckBox_Q = new javax.swing.JCheckBox();
        jLabel_ClubNautique = new javax.swing.JLabel();
        jComboBox_Club = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField_NameVoilier = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_Classe = new javax.swing.JComboBox<>();
        jButton_Add_Pro = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        JFileMenu = new javax.swing.JMenu();
        jMenuItem_AddProprio = new javax.swing.JMenuItem();
        jMenuItem_Quit = new javax.swing.JMenuItem();
        JEditMenu = new javax.swing.JMenu();
        JRepportMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        JHelpMenu = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu6.setText("File");
        jMenuBar2.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar2.add(jMenu7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_ListVoilier.setText("Liste des voiliers");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel_ListLayout = new javax.swing.GroupLayout(jPanel_List);
        jPanel_List.setLayout(jPanel_ListLayout);
        jPanel_ListLayout.setHorizontalGroup(
            jPanel_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_ListVoilier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_ListLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel_ListLayout.setVerticalGroup(
            jPanel_ListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ListLayout.createSequentialGroup()
                .addComponent(jLabel_ListVoilier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("Ajouter un voilier");

        jLabel2.setText("Propriétaire :");

        jComboBox_Proprietaire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisisez un club..." }));
        jComboBox_Proprietaire.setEnabled(false);
        jComboBox_Proprietaire.setRenderer(new GlobalComboBoxRenderer());
        jComboBox_Proprietaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ProprietaireActionPerformed(evt);
            }
        });

        jLabel3.setText("Série :");

        jCheckBox_H.setText("Habitables");
        jCheckBox_H.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_HItemStateChanged(evt);
            }
        });
        jCheckBox_H.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_HStateChanged(evt);
            }
        });
        jCheckBox_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_HActionPerformed(evt);
            }
        });

        jCheckBox_Q.setText("Quillards");
        jCheckBox_Q.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_QItemStateChanged(evt);
            }
        });
        jCheckBox_Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_QActionPerformed(evt);
            }
        });

        jLabel_ClubNautique.setText("Club Nautique :");

        jComboBox_Club.setModel(new JComboBoxModel_ClubNautique());
        jComboBox_Club.setRenderer(new com.afpa.dahouet.ui.GlobalComboBoxRenderer());
        jComboBox_Club.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ClubActionPerformed(evt);
            }
        });

        jLabel4.setText("Nom du voilier :");

        jButton2.setText("Réinitialiser");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Confirmer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Classe : ");

        jComboBox_Classe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cochez une série..." }));
        jComboBox_Classe.setEnabled(false);
        jComboBox_Classe.setRenderer(new GlobalComboBoxRenderer());
        jComboBox_Classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ClasseActionPerformed(evt);
            }
        });

        jButton_Add_Pro.setText("Ajouter Propriétaire...");
        jButton_Add_Pro.setEnabled(false);
        jButton_Add_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_ProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_FormLayout = new javax.swing.GroupLayout(jPanel_Form);
        jPanel_Form.setLayout(jPanel_FormLayout);
        jPanel_FormLayout.setHorizontalGroup(
            jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_FormLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Add_Pro)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel_FormLayout.createSequentialGroup()
                        .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel_FormLayout.createSequentialGroup()
                                    .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel_FormLayout.createSequentialGroup()
                                            .addComponent(jCheckBox_H, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCheckBox_Q, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jComboBox_Proprietaire, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel_FormLayout.createSequentialGroup()
                                    .addComponent(jLabel_ClubNautique)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox_Club, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel_FormLayout.createSequentialGroup()
                                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField_NameVoilier, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                    .addComponent(jComboBox_Classe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 88, Short.MAX_VALUE))))
        );
        jPanel_FormLayout.setVerticalGroup(
            jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ClubNautique)
                    .addComponent(jComboBox_Club, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_Proprietaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_H)
                    .addComponent(jCheckBox_Q))
                .addGap(18, 18, 18)
                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox_Classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_NameVoilier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel_FormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton_Add_Pro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JFileMenu.setText("Fichier");
        JFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFileMenuActionPerformed(evt);
            }
        });

        jMenuItem_AddProprio.setText("Ajouter Propriétaire...");
        jMenuItem_AddProprio.setEnabled(false);
        jMenuItem_AddProprio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AddProprioActionPerformed(evt);
            }
        });
        JFileMenu.add(jMenuItem_AddProprio);

        jMenuItem_Quit.setText("Quitter");
        jMenuItem_Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_QuitActionPerformed(evt);
            }
        });
        JFileMenu.add(jMenuItem_Quit);

        jMenuBar1.add(JFileMenu);

        JEditMenu.setText("Edition");
        jMenuBar1.add(JEditMenu);

        JRepportMenu.setText("Rapport");

        jMenuItem1.setText("Générer apointement régate");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JRepportMenu.add(jMenuItem1);

        jMenuBar1.add(JRepportMenu);

        JHelpMenu.setText("?");
        jMenuBar1.add(JHelpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_List, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_List, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel_Form, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_ProprietaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ProprietaireActionPerformed
        

    }//GEN-LAST:event_jComboBox_ProprietaireActionPerformed

    private void jCheckBox_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_HActionPerformed

    private void jCheckBox_QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_QActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_QActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField_NameVoilier.setText("");
        jComboBox_Classe.setSelectedIndex(-1);
        if (jComboBox_Classe.isEnabled()) {
            jComboBox_Classe.setEnabled(false);
        }
        
        jComboBox_Club.setSelectedIndex(-1);
        jComboBox_Proprietaire.setSelectedIndex(-1);
        if (jComboBox_Proprietaire.isEnabled()) {
            jComboBox_Proprietaire.setEnabled(false);
        }
        
        jCheckBox_H.setSelected(false);
        jCheckBox_Q.setSelected(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Integer indexClub = jComboBox_Club.getSelectedIndex();
        Integer indexProprio = jComboBox_Proprietaire.getSelectedIndex();
        Integer indexClasse = jComboBox_Club.getSelectedIndex();
        String nom = jTextField_NameVoilier.getText();
        
        if (indexProprio == null || indexClasse == null || indexClub == null || nom.isEmpty()) {
            
            JOptionPane.showMessageDialog(jPanel_Form, "Certains Champs sont vides", "Erreur", JOptionPane.ERROR_MESSAGE);
            
        } else {
            
            int confirm = JOptionPane.showConfirmDialog(jPanel_Form, "Voulez vous vraiment ajouter le voilier \"" + nom + "\" ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                Proprietaire proprietaire = (Proprietaire) jComboBox_Proprietaire.getSelectedItem();
                ClasseVoilier classeVoilier = (ClasseVoilier) jComboBox_Classe.getSelectedItem();
                Voilier voilier = new Voilier(proprietaire, classeVoilier, nom);
                
                int result = VoilierDAO.insertVoilier(voilier);
                if (result == 0) {
                    
                    JOptionPane.showMessageDialog(jPanel_Form, "Une erreur s'est produite.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    
                } else {
                    
                    JOptionPane.showMessageDialog(jPanel_Form, "Ajout réussi !", "Succès", JOptionPane.INFORMATION_MESSAGE);
                    
                }
                
            }
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_ClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ClasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_ClasseActionPerformed

    private void jCheckBox_HStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_HStateChanged
//        if (jCheckBox_Q.isEnabled()) {
//            jCheckBox_Q.setEnabled(false);
//        }
    }//GEN-LAST:event_jCheckBox_HStateChanged

    private void jCheckBox_HItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_HItemStateChanged
        if (jCheckBox_H.isSelected()) {
            jCheckBox_Q.setEnabled(false);
            jComboBox_Classe.setModel(new JComboBoxModel_Classe('H'));
            jComboBox_Classe.setEnabled(true);
        } else {
            jCheckBox_Q.setEnabled(true);
            jComboBox_Classe.setEnabled(false);
            jComboBox_Classe.setSelectedIndex(-1);
            
        }

    }//GEN-LAST:event_jCheckBox_HItemStateChanged

    private void jCheckBox_QItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_QItemStateChanged
        if (jCheckBox_Q.isSelected()) {
            jCheckBox_H.setEnabled(false);
            jComboBox_Classe.setModel(new JComboBoxModel_Classe('Q'));
            jComboBox_Classe.setEnabled(true);
        } else {
            jCheckBox_H.setEnabled(true);
            jComboBox_Classe.setSelectedIndex(-1);
            jComboBox_Classe.setEnabled(false);
            
        }
    }//GEN-LAST:event_jCheckBox_QItemStateChanged

    private void jComboBox_ClubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ClubActionPerformed
        if (jComboBox_Club.getSelectedIndex() != -1) {
            ClubNautique clubNautique = (ClubNautique) jComboBox_Club.getModel().getSelectedItem();
            jButton_Add_Pro.setEnabled(true);
            jMenuItem_AddProprio.setEnabled(true);
            boxModel_Proprietaire = new JComboBoxModel_Proprietaire(clubNautique);
            jComboBox_Proprietaire.setModel(boxModel_Proprietaire);
             
            jComboBox_Proprietaire.setEnabled(true);
        }
        

    }//GEN-LAST:event_jComboBox_ClubActionPerformed

    private void JFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFileMenuActionPerformed

    }//GEN-LAST:event_JFileMenuActionPerformed

    private void jMenuItem_QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_QuitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem_QuitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton_Add_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ProActionPerformed
        FormProprietaire formProprietaire = new FormProprietaire(this, rootPaneCheckingEnabled, boxModel_Proprietaire);
        formProprietaire.setVisible(true);
    }//GEN-LAST:event_jButton_Add_ProActionPerformed

    private void jMenuItem_AddProprioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AddProprioActionPerformed
        FormProprietaire formProprietaire = new FormProprietaire(this, rootPaneCheckingEnabled, boxModel_Proprietaire);
        formProprietaire.setVisible(true);
    }//GEN-LAST:event_jMenuItem_AddProprioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoilierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoilierForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JEditMenu;
    private javax.swing.JMenu JFileMenu;
    private javax.swing.JMenu JHelpMenu;
    private javax.swing.JMenu JRepportMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_Add_Pro;
    private javax.swing.JCheckBox jCheckBox_H;
    private javax.swing.JCheckBox jCheckBox_Q;
    private javax.swing.JComboBox<String> jComboBox_Classe;
    private javax.swing.JComboBox<String> jComboBox_Club;
    private javax.swing.JComboBox<String> jComboBox_Proprietaire;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_ClubNautique;
    private javax.swing.JLabel jLabel_ListVoilier;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem_AddProprio;
    private javax.swing.JMenuItem jMenuItem_Quit;
    private javax.swing.JPanel jPanel_Form;
    private javax.swing.JPanel jPanel_List;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_NameVoilier;
    // End of variables declaration//GEN-END:variables
}
