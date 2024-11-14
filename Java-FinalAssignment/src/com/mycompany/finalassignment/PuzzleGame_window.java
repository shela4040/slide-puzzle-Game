/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finalassignment;




import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.Timer;


import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;
/**
 *
 * @author sanda
 */
public final class PuzzleGame_window extends javax.swing.JFrame {

    private Timer timer;
    private long startTime;
    private final long timeLimit;
    private final int moveLimit;
    private int moveCount=0;
    private long elapsedTime;
    private final PlayerLogin_window player;
    private static PuzzleGame_window puzzle;
    private ArrayList <Integer> numbers;
   
    
     
    
    public PuzzleGame_window(long min,int move,PlayerLogin_window obj){
        
        
        this.timeLimit=min;
        this.moveLimit=move;
        this. player=obj;
        puzzle=this;
        
        Home_window.clip.loop(Clip.LOOP_CONTINUOUSLY);
        Home_window.clip.start();
        initComponents();
        
        if(player.constraintType==3){
             score.setFont(new java.awt.Font("Snap ITC", 1, 18));
             score.setText("  Ejoy !");
             }
        
         
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        numbers= new ArrayList<>();
        
        for(int i=1;i<16;i++){
            numbers.add(i);
        }
        
        
        shuffleNumbers();
        
        WindowListener windowListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
          if (Home_window.clip != null && Home_window.clip.isRunning()) {
            Home_window.clip.stop();
            timer.stop();
          }
          dispose(); 
        }
        };
        
        addWindowListener(windowListener);

    }
    
    public void shuffleNumbers(){
        Collections.shuffle(numbers);
        if(isSolvable()){
        shufflePuzzle();
        }
        else{
        shuffleNumbers();  
        }
    }
    
    public boolean isSolvable(){
        int inversions=getInversions();
        return inversions  % 2 == 0;
        
    }
    
    public int getInversions(){
        int inversions=0;
        
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
             if(numbers.get(i)>numbers.get(j)){
                 inversions++;
             }
            }
        }
        
        return inversions;
    }
    
    
    public void shufflePuzzle(){
        
        button_1.setText(String.valueOf(numbers.get(0)));
        button_2.setText(String.valueOf(numbers.get(1)));
        button_3.setText(String.valueOf(numbers.get(2)));
        button_4.setText(String.valueOf(numbers.get(3)));
        button_8.setText(String.valueOf(numbers.get(4)));
        button_7.setText(String.valueOf(numbers.get(5)));
        button_6.setText(String.valueOf(numbers.get(6)));
        button_5.setText(String.valueOf(numbers.get(7)));
        button_9.setText(String.valueOf(numbers.get(8)));
        button_10.setText(String.valueOf(numbers.get(9)));
        button_11.setText(String.valueOf(numbers.get(10)));
        button_12.setText(String.valueOf(numbers.get(11)));
        button_15.setText(String.valueOf(numbers.get(12)));
        button_14.setText(String.valueOf(numbers.get(13)));
        button_13.setText(String.valueOf(numbers.get(14)));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timerLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        emptyButton = new javax.swing.JButton();
        button_15 = new javax.swing.JButton();
        button_14 = new javax.swing.JButton();
        button_13 = new javax.swing.JButton();
        button_1 = new javax.swing.JButton();
        button_2 = new javax.swing.JButton();
        button_3 = new javax.swing.JButton();
        button_4 = new javax.swing.JButton();
        button_7 = new javax.swing.JButton();
        button_5 = new javax.swing.JButton();
        button_8 = new javax.swing.JButton();
        button_6 = new javax.swing.JButton();
        button_11 = new javax.swing.JButton();
        button_9 = new javax.swing.JButton();
        button_12 = new javax.swing.JButton();
        button_10 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        score = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        soundOff = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        solutionButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        moveButton1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timerLabel.setBackground(new java.awt.Color(255, 255, 255));
        timerLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timerLabel.setForeground(new java.awt.Color(0, 0, 0));
        timerLabel.setText("        00:00");
        timerLabel.setOpaque(true);
        timerLabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                timerLabelAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(timerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 110, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  Preview :");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 70, 40));

        jTextField1.setBackground(new java.awt.Color(0, 0, 204));
        jTextField1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 204, 0));
        jTextField1.setText("Time :");
        jTextField1.setOpaque(true);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 80, 30));

        emptyButton.setBackground(new java.awt.Color(102, 102, 102));
        emptyButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        emptyButton.setForeground(new java.awt.Color(255, 0, 0));
        emptyButton.setText("     ");
        emptyButton.setOpaque(true);
        emptyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emptyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(emptyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 90, 70));

        button_15.setBackground(new java.awt.Color(255, 255, 255));
        button_15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_15.setForeground(new java.awt.Color(255, 0, 0));
        button_15.setText("10");
        button_15.setOpaque(true);
        button_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_15ActionPerformed(evt);
            }
        });
        getContentPane().add(button_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 80, 70));

        button_14.setBackground(new java.awt.Color(255, 255, 255));
        button_14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_14.setForeground(new java.awt.Color(255, 0, 0));
        button_14.setText("14");
        button_14.setOpaque(true);
        button_14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_14ActionPerformed(evt);
            }
        });
        getContentPane().add(button_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 80, 70));

        button_13.setBackground(new java.awt.Color(255, 255, 255));
        button_13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_13.setForeground(new java.awt.Color(204, 0, 0));
        button_13.setText("13");
        button_13.setOpaque(true);
        button_13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_13ActionPerformed(evt);
            }
        });
        getContentPane().add(button_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 80, 70));

        button_1.setBackground(new java.awt.Color(255, 255, 255));
        button_1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_1.setForeground(new java.awt.Color(255, 0, 0));
        button_1.setText("1");
        button_1.setOpaque(true);
        button_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_1ActionPerformed(evt);
            }
        });
        getContentPane().add(button_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 90, 70));

        button_2.setBackground(new java.awt.Color(255, 255, 255));
        button_2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_2.setForeground(new java.awt.Color(255, 0, 0));
        button_2.setText("2");
        button_2.setOpaque(true);
        button_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_2ActionPerformed(evt);
            }
        });
        getContentPane().add(button_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 80, 70));

        button_3.setBackground(new java.awt.Color(255, 255, 255));
        button_3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_3.setForeground(new java.awt.Color(255, 0, 0));
        button_3.setText("3");
        button_3.setOpaque(true);
        button_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_3ActionPerformed(evt);
            }
        });
        getContentPane().add(button_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, 80, 70));

        button_4.setBackground(new java.awt.Color(255, 255, 255));
        button_4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_4.setForeground(new java.awt.Color(255, 0, 0));
        button_4.setText("4");
        button_4.setOpaque(true);
        button_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_4ActionPerformed(evt);
            }
        });
        getContentPane().add(button_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 80, 70));

        button_7.setBackground(new java.awt.Color(255, 255, 255));
        button_7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_7.setForeground(new java.awt.Color(255, 0, 0));
        button_7.setText("7");
        button_7.setOpaque(true);
        button_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_7ActionPerformed(evt);
            }
        });
        getContentPane().add(button_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 80, 70));

        button_5.setBackground(new java.awt.Color(255, 255, 255));
        button_5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_5.setForeground(new java.awt.Color(204, 0, 0));
        button_5.setText("5");
        button_5.setOpaque(true);
        button_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_5ActionPerformed(evt);
            }
        });
        getContentPane().add(button_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 80, 70));

        button_8.setBackground(new java.awt.Color(255, 255, 255));
        button_8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_8.setForeground(new java.awt.Color(255, 0, 0));
        button_8.setText("8");
        button_8.setOpaque(true);
        button_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_8ActionPerformed(evt);
            }
        });
        getContentPane().add(button_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 90, 70));

        button_6.setBackground(new java.awt.Color(255, 255, 255));
        button_6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_6.setForeground(new java.awt.Color(255, 0, 0));
        button_6.setText("6");
        button_6.setOpaque(true);
        button_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_6ActionPerformed(evt);
            }
        });
        getContentPane().add(button_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 80, 70));

        button_11.setBackground(new java.awt.Color(255, 255, 255));
        button_11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_11.setForeground(new java.awt.Color(255, 0, 0));
        button_11.setText("11");
        button_11.setOpaque(true);
        button_11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_11ActionPerformed(evt);
            }
        });
        getContentPane().add(button_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, 80, 70));

        button_9.setBackground(new java.awt.Color(255, 255, 255));
        button_9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_9.setForeground(new java.awt.Color(255, 0, 0));
        button_9.setText("15");
        button_9.setOpaque(true);
        button_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_9ActionPerformed(evt);
            }
        });
        getContentPane().add(button_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 90, 70));

        button_12.setBackground(new java.awt.Color(255, 255, 255));
        button_12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_12.setForeground(new java.awt.Color(204, 0, 0));
        button_12.setText("12");
        button_12.setOpaque(true);
        button_12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_12ActionPerformed(evt);
            }
        });
        getContentPane().add(button_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 80, 70));

        button_10.setBackground(new java.awt.Color(255, 255, 255));
        button_10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        button_10.setForeground(new java.awt.Color(255, 0, 0));
        button_10.setText("9");
        button_10.setOpaque(true);
        button_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_10ActionPerformed(evt);
            }
        });
        getContentPane().add(button_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 80, 70));

        jButton30.setBackground(new java.awt.Color(255, 255, 255));
        jButton30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 0, 0));
        jButton30.setText("2");
        jButton30.setOpaque(true);
        getContentPane().add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 50, 20));

        jButton32.setBackground(new java.awt.Color(255, 255, 255));
        jButton32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 0, 0));
        jButton32.setText("3");
        jButton32.setOpaque(true);
        getContentPane().add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 50, 20));

        jButton33.setBackground(new java.awt.Color(255, 255, 255));
        jButton33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 0, 0));
        jButton33.setText("4");
        jButton33.setOpaque(true);
        getContentPane().add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 50, 20));

        jButton31.setBackground(new java.awt.Color(255, 255, 255));
        jButton31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 0, 0));
        jButton31.setText("1");
        jButton31.setOpaque(true);
        getContentPane().add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 50, 20));

        jButton34.setBackground(new java.awt.Color(255, 255, 255));
        jButton34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 0, 0));
        jButton34.setText("7");
        jButton34.setOpaque(true);
        getContentPane().add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 50, 20));

        jButton35.setBackground(new java.awt.Color(255, 255, 255));
        jButton35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 0, 0));
        jButton35.setText("6");
        jButton35.setOpaque(true);
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 50, 20));

        jButton36.setBackground(new java.awt.Color(255, 255, 255));
        jButton36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton36.setForeground(new java.awt.Color(255, 0, 0));
        jButton36.setText("5");
        jButton36.setOpaque(true);
        getContentPane().add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 50, 20));

        jButton37.setBackground(new java.awt.Color(255, 255, 255));
        jButton37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton37.setForeground(new java.awt.Color(255, 0, 0));
        jButton37.setText("8");
        jButton37.setOpaque(true);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 50, 20));

        jButton38.setBackground(new java.awt.Color(255, 255, 255));
        jButton38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton38.setForeground(new java.awt.Color(255, 0, 0));
        jButton38.setText("10");
        jButton38.setOpaque(true);
        getContentPane().add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 50, 20));

        jButton39.setBackground(new java.awt.Color(255, 255, 255));
        jButton39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 0, 0));
        jButton39.setText("11");
        jButton39.setOpaque(true);
        getContentPane().add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 50, 20));

        jButton40.setBackground(new java.awt.Color(255, 255, 255));
        jButton40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton40.setForeground(new java.awt.Color(255, 0, 0));
        jButton40.setText("12");
        jButton40.setOpaque(true);
        getContentPane().add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 50, 20));

        jButton41.setBackground(new java.awt.Color(255, 255, 255));
        jButton41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton41.setForeground(new java.awt.Color(255, 0, 0));
        jButton41.setText("9");
        jButton41.setOpaque(true);
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 50, 20));

        jButton42.setBackground(new java.awt.Color(255, 255, 255));
        jButton42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton42.setForeground(new java.awt.Color(255, 0, 0));
        jButton42.setText("15");
        jButton42.setOpaque(true);
        getContentPane().add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 50, 20));

        jButton43.setBackground(new java.awt.Color(255, 255, 255));
        jButton43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton43.setForeground(new java.awt.Color(255, 0, 0));
        jButton43.setText("14");
        jButton43.setOpaque(true);
        getContentPane().add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 50, 20));

        jButton44.setBackground(new java.awt.Color(255, 255, 255));
        jButton44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton44.setForeground(new java.awt.Color(255, 0, 0));
        jButton44.setText("13");
        jButton44.setOpaque(true);
        getContentPane().add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 50, 20));

        jButton45.setBackground(new java.awt.Color(102, 102, 102));
        jButton45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton45.setForeground(new java.awt.Color(255, 0, 0));
        jButton45.setText(" ");
        jButton45.setOpaque(true);
        getContentPane().add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 60, 20));

        jLabel1.setBackground(new java.awt.Color(0, 0, 204));
        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText(" Moves :");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 90, 30));

        score.setBackground(new java.awt.Color(255, 255, 255));
        score.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        score.setForeground(new java.awt.Color(0, 0, 0));
        score.setText("          00");
        score.setOpaque(true);
        score.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                scoreAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(score, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 100, 30));

        homeButton.setBackground(new java.awt.Color(0, 0, 204));
        homeButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        homeButton.setForeground(new java.awt.Color(255, 255, 255));
        homeButton.setText("Home");
        homeButton.setOpaque(true);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 70, 40));

        quitButton.setBackground(new java.awt.Color(0, 0, 204));
        quitButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        quitButton.setForeground(new java.awt.Color(255, 255, 255));
        quitButton.setText("Quit");
        quitButton.setOpaque(true);
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 60, 40));

        soundOff.setBackground(new java.awt.Color(255, 255, 255));
        soundOff.setText(" ");
        soundOff.setOpaque(true);
        soundOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soundOffActionPerformed(evt);
            }
        });
        getContentPane().add(soundOff, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 18, 40));

        jLabel3.setBackground(new java.awt.Color(0, 0, 204));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/soundImage.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 50, 40));

        solutionButton.setBackground(new java.awt.Color(0, 204, 51));
        solutionButton.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        solutionButton.setForeground(new java.awt.Color(0, 0, 0));
        solutionButton.setText("Solution");
        solutionButton.setOpaque(true);
        solutionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionButtonActionPerformed(evt);
            }
        });
        getContentPane().add(solutionButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 90, 40));

        resetButton.setBackground(new java.awt.Color(0, 0, 204));
        resetButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("Restart");
        resetButton.setOpaque(true);
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 80, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/score.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 550, -1, 90));

        moveButton1.setBackground(new java.awt.Color(255, 255, 255));
        moveButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        moveButton1.setForeground(new java.awt.Color(0, 0, 0));
        moveButton1.setText("         00");
        moveButton1.setOpaque(true);
        moveButton1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                moveButton1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(moveButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 120, 30));

        jButton1.setBackground(new java.awt.Color(0, 204, 51));
        jButton1.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Go LeaderBoard>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, 170, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/puzzleImage.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void button_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_1ActionPerformed
        if("".equals(button_2.getText())){
            button_2.setText(button_1.getText());
            button_1.setText("");
            button_1.setBackground(new java.awt.Color(102, 102, 102));
            button_2.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        else if("".equals(button_8.getText())){
            button_8.setText(button_1.getText());
            button_1.setText("");
            button_1.setBackground(new java.awt.Color(102, 102, 102));
            button_8.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("1".equals(button_1.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_1ActionPerformed

    private void button_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_2ActionPerformed
         if("".equals(button_1.getText())){
            button_1.setText(button_2.getText());
            button_2.setText("");
            button_2.setBackground(new java.awt.Color(102, 102, 102));
            button_1.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
         if("".equals(button_3.getText())){
            button_3.setText(button_2.getText());
            button_2.setText("");
            button_2.setBackground(new java.awt.Color(102, 102, 102));
            button_3.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_7.getText())){
            button_7.setText(button_2.getText());
            button_2.setText("");
            button_2.setBackground(new java.awt.Color(102, 102, 102));
            button_7.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("2".equals(button_2.getText())){
       
             try {
                 checkAccurate();
             } catch (IOException ex) {
                 Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }//GEN-LAST:event_button_2ActionPerformed

    private void button_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_3ActionPerformed
        if("".equals(button_2.getText())){
            button_2.setText(button_3.getText());
            button_3.setText("");
            button_3.setBackground(new java.awt.Color(102, 102, 102));
            button_2.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_6.getText())){
            button_6.setText(button_3.getText());
            button_3.setText("");
            button_3.setBackground(new java.awt.Color(102, 102, 102));
            button_6.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_4.getText())){
            button_4.setText(button_3.getText());
            button_3.setText("");
            button_3.setBackground(new java.awt.Color(102, 102, 102));
            button_4.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("3".equals(button_3.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_3ActionPerformed

    private void button_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_4ActionPerformed
        if("".equals(button_3.getText())){
            button_3.setText(button_4.getText());
            button_4.setText("");
            button_4.setBackground(new java.awt.Color(102, 102, 102));
            button_3.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_5.getText())){
            button_5.setText(button_4.getText());
            button_4.setText("");
            button_4.setBackground(new java.awt.Color(102, 102, 102));
            button_5.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
       if("4".equals(button_4.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_4ActionPerformed

    private void button_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_5ActionPerformed
         if("".equals(button_4.getText())){
            button_4.setText(button_5.getText());
            button_5.setText("");
            button_5.setBackground(new java.awt.Color(102, 102, 102));
            button_4.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
         if("".equals(button_6.getText())){
            button_6.setText(button_5.getText());
            button_5.setText("");
            button_5.setBackground(new java.awt.Color(102, 102, 102));
            button_6.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_12.getText())){
            button_12.setText(button_5.getText());
            button_5.setText("");
            button_5.setBackground(new java.awt.Color(102, 102, 102));
            button_12.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("5".equals(button_5.getText())){
       
             try {
                 checkAccurate();
             } catch (IOException ex) {
                 Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_button_5ActionPerformed

    private void button_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_6ActionPerformed
        if("".equals(button_3.getText())){
            button_3.setText(button_6.getText());
            button_6.setText("");
            button_6.setBackground(new java.awt.Color(102, 102, 102));
            button_3.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_5.getText())){
            button_5.setText(button_6.getText());
            button_6.setText("");
            button_6.setBackground(new java.awt.Color(102, 102, 102));
            button_5.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_7.getText())){
            button_7.setText(button_6.getText());
            button_6.setText("");
            button_6.setBackground(new java.awt.Color(102, 102, 102));
            button_7.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_11.getText())){
            button_11.setText(button_6.getText());
            button_6.setText("");
            button_6.setBackground(new java.awt.Color(102, 102, 102));
            button_11.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("6".equals(button_6.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_6ActionPerformed

    private void button_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_7ActionPerformed
        if("".equals(button_2.getText())){
            button_2.setText(button_7.getText());
            button_7.setText("");
            button_7.setBackground(new java.awt.Color(102, 102, 102));
            button_2.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_8.getText())){
            button_8.setText(button_7.getText());
            button_7.setText("");
            button_7.setBackground(new java.awt.Color(102, 102, 102));
            button_8.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_10.getText())){
            button_10.setText(button_7.getText());
            button_7.setText("");
            button_7.setBackground(new java.awt.Color(102, 102, 102));
            button_10.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_6.getText())){
            button_6.setText(button_7.getText());
            button_7.setText("");
            button_7.setBackground(new java.awt.Color(102, 102, 102));
            button_6.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("7".equals(button_7.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_7ActionPerformed

    private void button_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_8ActionPerformed
         if("".equals(button_1.getText())){
            button_1.setText(button_8.getText());
            button_8.setText("");
            button_8.setBackground(new java.awt.Color(102, 102, 102));
            button_1.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
         if("".equals(button_7.getText())){
            button_7.setText(button_8.getText());
            button_8.setText("");
            button_8.setBackground(new java.awt.Color(102, 102, 102));
            button_7.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_9.getText())){
            button_9.setText(button_8.getText());
            button_8.setText("");
            button_8.setBackground(new java.awt.Color(102, 102, 102));
            button_9.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("8".equals(button_8.getText())){
       
             try {
                 checkAccurate();
             } catch (IOException ex) {
                 Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_button_8ActionPerformed

    private void button_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_9ActionPerformed
         if("".equals(button_8.getText())){
            button_8.setText(button_9.getText());
            button_9.setText("");
            button_9.setBackground(new java.awt.Color(102, 102, 102));
            button_8.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
         if("".equals(button_10.getText())){
            button_10.setText(button_9.getText());
            button_9.setText("");
            button_9.setBackground(new java.awt.Color(102, 102, 102));
            button_10.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
          if("".equals(emptyButton.getText().trim())){
            emptyButton.setText(button_9.getText());
            button_9.setText("");
            button_9.setBackground(new java.awt.Color(102, 102, 102));
            emptyButton.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
         
         if("9".equals(button_9.getText())){
       
             try {
                 checkAccurate();
             } catch (IOException ex) {
                 Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
       
    }//GEN-LAST:event_button_9ActionPerformed

    private void button_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_10ActionPerformed
        if("".equals(button_7.getText())){
            button_7.setText(button_10.getText());
            button_10.setText("");
            button_10.setBackground(new java.awt.Color(102, 102, 102));
            button_7.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_9.getText())){
            button_9.setText(button_10.getText());
            button_10.setText("");
            button_10.setBackground(new java.awt.Color(102, 102, 102));
            button_9.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_15.getText())){
            button_15.setText(button_10.getText());
            button_10.setText("");
            button_10.setBackground(new java.awt.Color(102, 102, 102));
            button_15.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_11.getText())){
            button_11.setText(button_10.getText());
            button_10.setText("");
            button_10.setBackground(new java.awt.Color(102, 102, 102));
            button_11.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("10".equals(button_10.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_10ActionPerformed

    private void button_11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_11ActionPerformed
       if("".equals(button_6.getText())){
            button_6.setText(button_11.getText());
            button_11.setText("");
            button_11.setBackground(new java.awt.Color(102, 102, 102));
            button_6.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_10.getText())){
            button_10.setText(button_11.getText());
            button_11.setText("");
            button_11.setBackground(new java.awt.Color(102, 102, 102));
            button_10.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_12.getText())){
            button_12.setText(button_11.getText());
            button_11.setText("");
            button_11.setBackground(new java.awt.Color(102, 102, 102));
            button_12.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_14.getText())){
            button_14.setText(button_11.getText());
            button_11.setText("");
            button_11.setBackground(new java.awt.Color(102, 102, 102));
            button_14.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("11".equals(button_11.getText())){
       
           try {
               checkAccurate();
           } catch (IOException ex) {
               Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_button_11ActionPerformed

    private void button_12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_12ActionPerformed
        
        if("".equals(button_5.getText())){
            button_5.setText(button_12.getText());
            button_12.setText("");
            button_12.setBackground(new java.awt.Color(102, 102, 102));
            button_5.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_13.getText())){
            button_13.setText(button_12.getText());
            button_12.setText("");
            button_12.setBackground(new java.awt.Color(102, 102, 102));
            button_13.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_11.getText())){
            button_11.setText(button_12.getText());
            button_12.setText("");
            button_12.setBackground(new java.awt.Color(102, 102, 102));
            button_11.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("12".equals(button_12.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_12ActionPerformed

    private void button_13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_13ActionPerformed
        if("".equals(button_12.getText())){
            button_12.setText(button_13.getText());
            button_13.setText("");
            button_13.setBackground(new java.awt.Color(102, 102, 102));
            button_12.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_14.getText())){
            button_14.setText(button_13.getText());
            button_13.setText("");
            button_13.setBackground(new java.awt.Color(102, 102, 102));
            button_14.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("13".equals(button_13.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_13ActionPerformed

    private void button_14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_14ActionPerformed
        if("".equals(button_11.getText())){
            button_11.setText(button_14.getText());
            button_14.setText("");
            button_14.setBackground(new java.awt.Color(102, 102, 102));
            button_11.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_13.getText())){
            button_13.setText(button_14.getText());
            button_14.setText("");
            button_14.setBackground(new java.awt.Color(102, 102, 102));
            button_13.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_15.getText())){
            button_15.setText(button_14.getText());
            button_14.setText("");
            button_14.setBackground(new java.awt.Color(102, 102, 102));
            button_15.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("14".equals(button_14.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_14ActionPerformed

    private void button_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_15ActionPerformed
        if("".equals(button_10.getText())){
            button_10.setText(button_15.getText());
            button_15.setText("");
            button_15.setBackground(new java.awt.Color(102, 102, 102));
            button_10.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(button_14.getText())){
            button_14.setText(button_15.getText());
            button_15.setText("");
            button_15.setBackground(new java.awt.Color(102, 102, 102));
            button_14.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        if("".equals(emptyButton.getText().trim())){
           
            emptyButton.setText(button_15.getText());
            button_15.setText("");
            button_15.setBackground(new java.awt.Color(102, 102, 102));
            emptyButton.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
            
        }
        
        
        if("15".equals(button_15.getText())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_button_15ActionPerformed

    private void emptyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emptyButtonActionPerformed
        if("".equals(button_9.getText())){
            
            button_9.setText(emptyButton.getText());
            emptyButton.setText("");
            emptyButton.setBackground(new java.awt.Color(102, 102, 102));
            button_9.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
            
            
        }
        if("".equals(button_15.getText())){
           
            button_15.setText(emptyButton.getText());
            emptyButton.setText("");
            emptyButton.setBackground(new java.awt.Color(102, 102, 102));
            button_15.setBackground(new java.awt.Color(255, 255, 255));
            moveCount++;
        }
        
        if("".equals(emptyButton.getText().trim())){
       
            try {
                checkAccurate();
            } catch (IOException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_emptyButtonActionPerformed

    int count=0;
    private void timerLabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_timerLabelAncestorAdded
   
         startTime = System.currentTimeMillis();
         timer = new Timer(50, new ActionListener() {
             
      @Override
      public void actionPerformed(ActionEvent e) {
          
            boolean isGameOver=false;
            
            elapsedTime = System.currentTimeMillis() - startTime;
            long minutes = (int) (elapsedTime / (1000 * 60));
            long seconds = (elapsedTime /1000)% 60;
            long milliseconds =elapsedTime % 1000;
            timerLabel.setText(String.format("   %02d:%02d:%03d", minutes, seconds, milliseconds));
                
                   
            if(minutes==timeLimit){
                
                
                isGameOver=true;
                player.score= 0.0;
                player.rank=0;
                
                timer.stop();
                Home_window.clip.stop(); 
                
                try {
                    new GameOver_window(player,puzzle).setVisible(true);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            
             moveButton1.setText(String.valueOf(moveCount));
             if(moveCount==moveLimit){
                 
                isGameOver=true; 
                player.score=0.0;
                player.rank=0;
                timer.stop();
                
                try {
                    Home_window.clip.stop(); 
                    new GameOver_window(player,puzzle).setVisible(true);
                }   catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                    Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                   
        }
             
             if(count!=moveCount){
             if(player.constraintType!=3){
             calculateScore();
             score.setText(String.valueOf(player.score));
             }
             count=moveCount;
             }
             
             
             if(!isGameOver){
             if(soundOff.isSelected()){
                Home_window.clip.stop();
             }
             else{
                Home_window.clip.start(); 
             }
             }
             
      }
    });
       
        timer.start();
      
    }//GEN-LAST:event_timerLabelAncestorAdded

    private void scoreAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_scoreAncestorAdded
        
       
    }//GEN-LAST:event_scoreAncestorAdded

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        
        timer.stop();
        Home_window.clip.stop();
        setVisible(false);
        try {
            new Home_window().setVisible(true);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_homeButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed

        
        timer.stop();
        setVisible(false);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed

        timer.stop();
        setVisible(false);
        new PuzzleGame_window(timeLimit,moveLimit,player).setVisible(true);
        
    }//GEN-LAST:event_resetButtonActionPerformed

    private void solutionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionButtonActionPerformed
        
    }//GEN-LAST:event_solutionButtonActionPerformed

    private void soundOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soundOffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soundOffActionPerformed

    private void moveButton1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_moveButton1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_moveButton1AncestorAdded

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        new Leaderboard_window().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    public void checkAccurate() throws IOException{
        
        
        
        if ("1".equals(button_1.getText()) && "2".equals(button_2.getText()) && "3".equals(button_3.getText()) && "4".equals(button_4.getText()) && "5".equals(button_5.getText()) && "6".equals(button_6.getText()) && "7".equals(button_7.getText())
        && "8".equals(button_8.getText()) && "9".equals(button_9.getText()) && "10".equals(button_10.getText()) && "11".equals(button_11.getText()) && "12".equals(button_12.getText()) && "13".equals(button_13.getText()) && "14".equals(button_14.getText()) && "15".equals(button_15.getText())) {
 
            
            long endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime; 
            
            calculateScore();
            
            if(player.score!=0.0){
            player.saveData();
            }
            timer.stop();
            
            
            Home_window.clip.stop(); 
            
            try {
                new GameWin_window(player,puzzle).setVisible(true);
            } catch (UnsupportedAudioFileException | LineUnavailableException ex) {
                Logger.getLogger(PuzzleGame_window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
}

         
        
    }
    
    public void calculateScore(){
        
        switch (player.constraintType) {
            case 1:
                if(player.gameType==1){
                    player.score=(double)1500-(timeLimit*1000*60-elapsedTime)/1000;
                }
                if(player.gameType==2){
                    player.score=(double)1500-(timeLimit*1000*60- elapsedTime)/3000;
                }
                if(player.gameType==3){
                    player.score=(double)1500-(timeLimit*1000*60- elapsedTime)/5000;
                }
                break;
            case 2:
                if(player.gameType==1){
                    player.score=(double)1500- 100*(moveLimit-moveCount)/50;
                }
                if(player.gameType==2){
                    player.score=(double)1500-100*(moveLimit- moveCount)/150;
                }
                if(player.gameType==3){
                    player.score=(double)1500-100*(moveLimit- moveCount)/500;
                }
                break;
            default:
                player.score=0.0; 
                break;
        }
        
      }
    
    
   
    
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_1;
    private javax.swing.JButton button_10;
    private javax.swing.JButton button_11;
    private javax.swing.JButton button_12;
    private javax.swing.JButton button_13;
    private javax.swing.JButton button_14;
    private javax.swing.JButton button_15;
    private javax.swing.JButton button_2;
    private javax.swing.JButton button_3;
    private javax.swing.JButton button_4;
    private javax.swing.JButton button_5;
    private javax.swing.JButton button_6;
    private javax.swing.JButton button_7;
    private javax.swing.JButton button_8;
    private javax.swing.JButton button_9;
    private javax.swing.JButton emptyButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel moveButton1;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel score;
    private javax.swing.JButton solutionButton;
    private javax.swing.JRadioButton soundOff;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
