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
import javax.swing.JOptionPane;

/**
 *
 * @author sanda
 */
public final class GameOver_window extends javax.swing.JFrame {

    PlayerLogin_window player;
    Clip clip; 
    AudioInputStream audioInputStream; 
    static String filePath; 
    PuzzleGame_window puzzle;
    
    public GameOver_window(PlayerLogin_window player,PuzzleGame_window puzzle) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        this.player=player;
        this.puzzle=puzzle;
        
        playSound();
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

        retryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        retryButton.setBackground(new java.awt.Color(255, 255, 255));
        retryButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        retryButton.setForeground(new java.awt.Color(0, 102, 0));
        retryButton.setText("Try Again");
        retryButton.setOpaque(true);
        retryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(retryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/gameOver.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retryButtonActionPerformed
        
        clip.stop();
        if(player.constraintType==1){
           JOptionPane.showMessageDialog(this,"Enjoy unlimited moves.and test skill with time !!)");
           
           setVisible(false);
           puzzle.setVisible(false);
           new PuzzleGame_window(1,50,player).setVisible(true);
        }
        if(player.gameType==2){
           JOptionPane.showMessageDialog(this,"Enjoy unlimited time.and test skill with moves !!)");
           
           setVisible(false);
           puzzle.setVisible(false);
           new PuzzleGame_window(3,100,player).setVisible(true);
        }
        if(player.gameType==3){
           JOptionPane.showMessageDialog(this,"Relax and enjoy the puzzles at your own pace !!)");
           
           setVisible(false);
           puzzle.setVisible(false);
           new PuzzleGame_window(5,500,player).setVisible(true);
        }
    }//GEN-LAST:event_retryButtonActionPerformed

    
    public void playSound() throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  {
        
        filePath = "gameOver.wav"; 
        audioInputStream =AudioSystem.getAudioInputStream(GameOver_window.class.getResource(filePath)); 
        clip = AudioSystem.getClip(); 
        clip.open(audioInputStream);
        clip.start(); 
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton retryButton;
    // End of variables declaration//GEN-END:variables
}
