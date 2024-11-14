
package com.mycompany.finalassignment;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author sanda
 */
public final class Home_window extends javax.swing.JFrame {

    
    static File file=new File("Players.txt");
    private static Leaderboard_window leaderboard;
    
    static Clip clip; 
    static AudioInputStream audioInputStream; 
    static String filePath;
  
    public Home_window() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        leaderboard=new Leaderboard_window();
        leaderboard.updateLeaderboard();
        
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        playSound();
        
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

        startButton = new javax.swing.JButton();
        leaderButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startButton.setBackground(new java.awt.Color(0, 0, 204));
        startButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("START A NEWGAME");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 220, 40));

        leaderButton.setBackground(new java.awt.Color(0, 0, 204));
        leaderButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        leaderButton.setForeground(new java.awt.Color(255, 255, 255));
        leaderButton.setText("GO TO LEADERBOARD");
        leaderButton.setOpaque(true);
        leaderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderButtonActionPerformed(evt);
            }
        });
        getContentPane().add(leaderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 220, 40));

        quitButton.setBackground(new java.awt.Color(0, 0, 204));
        quitButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        quitButton.setForeground(new java.awt.Color(255, 255, 255));
        quitButton.setText("QUIT");
        quitButton.setOpaque(true);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, 127, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/homeImage.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        
        setVisible(false); 
        new Game_Constraints().setVisible(true);
    }//GEN-LAST:event_startButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
       
        setVisible(false);
        clip.stop();
    }//GEN-LAST:event_quitButtonActionPerformed

    private void leaderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderButtonActionPerformed
        
        leaderboard.setVisible(true);
    }//GEN-LAST:event_leaderButtonActionPerformed

  
    public void playSound() throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  {
        
        filePath = "puzzleAudio.wav"; 
        audioInputStream =AudioSystem.getAudioInputStream(Home_window.class.getResource(filePath)); 
        clip = AudioSystem.getClip(); 
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        clip.start();
    }
    
    public static void main(String args[]) throws FileNotFoundException {
        
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Home_window().setVisible(true);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(Home_window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton leaderButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
