/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finalassignment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author sanda
 */
public final class GameWin_window extends javax.swing.JFrame {

    
    Clip clip; 
    AudioInputStream audioInputStream; 
    static String filePath; 
    PuzzleGame_window puzzle;
    
    public GameWin_window(PlayerLogin_window player,PuzzleGame_window puzzle) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        
        this.puzzle=puzzle;
        
        
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        playSound();
        int score=(int) Math.round(player.score);
        if(player.constraintType!=3){
        scoreLable.setText("  SCORE :"+String.valueOf(score));
        }
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

        scoreLable = new javax.swing.JLabel();
        newGame_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scoreLable.setBackground(new java.awt.Color(255, 0, 0));
        scoreLable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scoreLable.setForeground(new java.awt.Color(255, 204, 0));
        scoreLable.setText(" ");
        scoreLable.setOpaque(true);
        getContentPane().add(scoreLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 140, 30));

        newGame_Button.setBackground(new java.awt.Color(0, 255, 51));
        newGame_Button.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        newGame_Button.setForeground(new java.awt.Color(0, 0, 0));
        newGame_Button.setText("New game");
        newGame_Button.setOpaque(true);
        newGame_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGame_ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(newGame_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/winImage.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newGame_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGame_ButtonActionPerformed
        
        setVisible(false); 
        puzzle.setVisible(false);
        clip.stop(); 
        clip.close();
        new Game_Constraints().setVisible(true);
    }//GEN-LAST:event_newGame_ButtonActionPerformed

    public void playSound() throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  {
        
        filePath = "gameWinAudio.wav"; 
        audioInputStream =AudioSystem.getAudioInputStream(GameWin_window.class.getResource(filePath)); 
        clip = AudioSystem.getClip(); 
        clip.open(audioInputStream);
        clip.start(); 
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton newGame_Button;
    private javax.swing.JLabel scoreLable;
    // End of variables declaration//GEN-END:variables
}
