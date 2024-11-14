/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finalassignment;

import static com.mycompany.finalassignment.Home_window.clip;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author sanda
 */
public class Game_Constraints extends javax.swing.JFrame {
    
    int constraintType;

    
    public Game_Constraints() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        WindowListener windowListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          if (clip != null && clip.isRunning()) {
            clip.stop();
          }
          dispose(); 
        }
        };
        
        addWindowListener(windowListener);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        constraintLabel = new javax.swing.JLabel();
        goButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectButton.setBackground(new java.awt.Color(0, 0, 204));
        selectButton.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        selectButton.setForeground(new java.awt.Color(255, 255, 255));
        selectButton.setText(" SELECT CONSTRAINTS");
        selectButton.setOpaque(true);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(selectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, 30));

        backButton.setBackground(new java.awt.Color(0, 204, 51));
        backButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(204, 0, 0));
        backButton.setText("BACK");
        backButton.setOpaque(true);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 110, 40));

        constraintLabel.setBackground(new java.awt.Color(255, 255, 255));
        constraintLabel.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        constraintLabel.setForeground(new java.awt.Color(0, 0, 153));
        constraintLabel.setText("      ");
        constraintLabel.setOpaque(true);
        getContentPane().add(constraintLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 230, 30));

        goButton.setBackground(new java.awt.Color(0, 204, 51));
        goButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        goButton.setForeground(new java.awt.Color(204, 0, 0));
        goButton.setText("GO");
        goButton.setOpaque(true);
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 510, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/image_2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
       String[] constraints={"Time countdown","Maximum number of moves","Unlimited expirience"};
       JComboBox comboBox=new JComboBox(constraints);
       
       JOptionPane.showConfirmDialog(this, comboBox,"SELECT CONSTRAINTS", JOptionPane.DEFAULT_OPTION);
       String str=(String)comboBox.getSelectedItem();
       constraintLabel.setText("  "+str);
       if("Time countdown".equals(str)){
           constraintType=1;
       }
       else if("Maximum number of moves".equals(str)){
           constraintType=2;
       }
       else{
           constraintType=3;
       }
       
    }//GEN-LAST:event_selectButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        
         setVisible(false);
           Home_window.clip.stop();
        try {
            new Home_window().setVisible(true);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(PlayerLogin_window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
         setVisible(false);
        switch (constraintType) {
            case 1:
                new PlayerLogin_window(null,0.0,1).setVisible(true);
                break;
            case 2:
                new PlayerLogin_window(null,0.0,2).setVisible(true);
                break;
            default:    
                new PlayerLogin_window(null,0.0,3).setVisible(true);
                break;
        }
    }//GEN-LAST:event_goButtonActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel constraintLabel;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables
}
