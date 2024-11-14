
package com.mycompany.finalassignment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author sanda
 */
public class PlayerLogin_window extends javax.swing.JFrame {

    
    String nickName;
    Double score;
    int rank;
    int gameType;
    int constraintType;
    
    private final PlayerLogin_window obj=this;
    
    public PlayerLogin_window(String nickName,Double score,int constraintType) {
 
        this.nickName=nickName;
        this.score=score;
        this.constraintType=constraintType;
        
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        WindowListener windowListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          if (Home_window.clip != null && Home_window.clip.isRunning()) {
            Home_window.clip.stop();
          }
          dispose(); 
        }
        };
        
        addWindowListener(windowListener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        easyButton = new javax.swing.JRadioButton();
        meadiumButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        hardButton = new javax.swing.JRadioButton();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 51, 204));
        jLabel1.setFont(new java.awt.Font("Snap ITC", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Nicname :");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 110, 30));

        name.setBackground(new java.awt.Color(255, 255, 255));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 350, 30));

        easyButton.setBackground(new java.awt.Color(0, 0, 204));
        buttonGroup1.add(easyButton);
        easyButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        easyButton.setForeground(new java.awt.Color(255, 255, 255));
        easyButton.setText("EASY");
        easyButton.setOpaque(true);
        easyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(easyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 100, 30));

        meadiumButton.setBackground(new java.awt.Color(0, 0, 204));
        buttonGroup1.add(meadiumButton);
        meadiumButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        meadiumButton.setForeground(new java.awt.Color(255, 255, 255));
        meadiumButton.setText("MEDIUM");
        meadiumButton.setOpaque(true);
        meadiumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meadiumButtonActionPerformed(evt);
            }
        });
        getContentPane().add(meadiumButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 100, 30));

        jLabel2.setBackground(new java.awt.Color(51, 255, 255));
        jLabel2.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText(" Choose Your Chalange ...");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 340, 50));

        startButton.setBackground(new java.awt.Color(51, 204, 0));
        startButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        startButton.setForeground(new java.awt.Color(204, 0, 0));
        startButton.setText("LET'S GO");
        startButton.setOpaque(true);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 610, 130, 30));

        hardButton.setBackground(new java.awt.Color(0, 0, 204));
        buttonGroup1.add(hardButton);
        hardButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        hardButton.setForeground(new java.awt.Color(255, 255, 255));
        hardButton.setText("HARD");
        hardButton.setOpaque(true);
        hardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardButtonActionPerformed(evt);
            }
        });
        getContentPane().add(hardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 100, 30));

        backButton.setBackground(new java.awt.Color(51, 204, 0));
        backButton.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        backButton.setForeground(new java.awt.Color(204, 0, 0));
        backButton.setText("HOME");
        backButton.setOpaque(true);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 100, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/loginImage.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
       nickName=name.getText();
        switch (constraintType) {
            case 1 -> {
                if(easyButton.isSelected()&&!"".equals(nickName)){
                    JOptionPane.showMessageDialog(this,"Relax and enjoy the puzzles at your own pace\n(5 minites and unlimited moves !!)");
                    Home_window.clip.stop();
                    setVisible(false);
                    new PuzzleGame_window(5,Integer.MAX_VALUE,obj).setVisible(true);
                }
                else if(meadiumButton.isSelected()&&!"".equals(nickName)){
                    JOptionPane.showMessageDialog(this,"A balanced challenge for experienced players.\n(3 minites and unlimited moves !!)");
                    Home_window.clip.stop();
                    setVisible(false);
                    new PuzzleGame_window(3,Integer.MAX_VALUE,obj).setVisible(true);
                }
                else if(hardButton.isSelected()&&!"".equals(nickName)){
                    JOptionPane.showMessageDialog(this,"Test your skills and speed!.\n(1 minites and unlimited moves !!)");
                    Home_window.clip.stop();
                    setVisible(false);
                    new PuzzleGame_window(1,Integer.MAX_VALUE,obj).setVisible(true);
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"FILL THE INFO !!");
                }
            }
            case 2 -> {
                if(easyButton.isSelected()&&!"".equals(nickName)){
                    JOptionPane.showMessageDialog(this,"Relax and enjoy the puzzles at your own pace\n(500 moves and Unlimited time!!)");
                    Home_window.clip.stop();
                    setVisible(false);
                    new PuzzleGame_window(Integer.MAX_VALUE,500,obj).setVisible(true);
                }
                else if(meadiumButton.isSelected()&&!"".equals(nickName)){
                    JOptionPane.showMessageDialog(this,"A balanced challenge for experienced players.\n(100 moves and Unlimited time !!)");
                    Home_window.clip.stop();
                    setVisible(false);
                    new PuzzleGame_window(Integer.MAX_VALUE,150,obj).setVisible(true);
                }
                else if(hardButton.isSelected()&&!"".equals(nickName)){
                    JOptionPane.showMessageDialog(this,"Test your skills and speed!.\n(50 moves and Unlimited time !!)");
                    Home_window.clip.stop();
                    setVisible(false);
                    new PuzzleGame_window(Integer.MAX_VALUE,50,obj).setVisible(true);
                    
                }
                else{
                    JOptionPane.showMessageDialog(this,"FILL THE INFO !!");
                }
            }
            default -> {
                if(!"".equals(nickName)){
                    JOptionPane.showMessageDialog(this,"Relax and enjoy the puzzles at your own pace");
                    Home_window.clip.stop();
                    setVisible(false);
                    new PuzzleGame_window(Integer.MAX_VALUE,Integer.MAX_VALUE,obj).setVisible(true);
                }
                
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void hardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardButtonActionPerformed
        gameType=1;
    }//GEN-LAST:event_hardButtonActionPerformed

    private void easyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyButtonActionPerformed
        gameType=3;
    }//GEN-LAST:event_easyButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
           setVisible(false);
           Home_window.clip.stop();
        try {
            new Home_window().setVisible(true);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(PlayerLogin_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void meadiumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meadiumButtonActionPerformed
        gameType=2;
    }//GEN-LAST:event_meadiumButtonActionPerformed

    
    
    
    public void saveData() throws FileNotFoundException, IOException{
    
        FileWriter fw=new FileWriter(Home_window.file,true);
        String line=nickName+","+score;
       
        
        fw.write(line+"\n");
        fw.close();
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton easyButton;
    private javax.swing.JRadioButton hardButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButton meadiumButton;
    private javax.swing.JTextField name;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
