/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.finalassignment;

import static com.mycompany.finalassignment.Home_window.file;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sanda
 */
public class Leaderboard_window extends javax.swing.JFrame {

   
   
    private static ArrayList <PlayerLogin_window> players=new ArrayList<>();
    private static DefaultTableModel tableModel;
    
    
    public Leaderboard_window() {
        
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        tableModel = (DefaultTableModel) leader_Table.getModel();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        leader_Table = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leader_Table.setBackground(new java.awt.Color(255, 255, 255));
        leader_Table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        leader_Table.setForeground(new java.awt.Color(0, 0, 0));
        leader_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rank", "Nickname", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leader_Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 420, 400));

        updateButton.setBackground(new java.awt.Color(102, 0, 204));
        updateButton.setFont(new java.awt.Font("Showcard Gothic", 1, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.setOpaque(true);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/finalassignment/leaderboard.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -60, 530, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        try {
            updateLeaderboard();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leaderboard_window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    
    public void updateLeaderboard() throws FileNotFoundException{
        
        tableModel.setRowCount(0);
        ArrayList<String> lines=new ArrayList<>();
        players.clear();
        
        try {
        
        Scanner scanFile = new Scanner(file);
        
        while(scanFile.hasNextLine()){
            lines.add(scanFile.nextLine()); 
            
        }
        
        Double[] scores=new Double[lines.size()];
        int i=0;
        for(String line:lines){
            String[] arr=line.split(",");
            players.add(new PlayerLogin_window(arr[0],Double.valueOf(arr[1]),0));
           
            scores[i]=Double.valueOf(arr[1]);
            
            i++;
        }
        
        Arrays.sort(scores);
        int rank=0;
        for(int j=lines.size()-1;j>=0;j--){
            
            for(PlayerLogin_window player:players){
                
                if(Objects.equals(scores[j], player.score)){
                   
                   
                    rank++;
                    player.rank=rank;
                    int score=(int) Math.round(player.score);
                    String [] rowData={String.valueOf(player.rank),player.nickName,String.valueOf(score)};
                    
                    tableModel.addRow(rowData);
           
                                   
                }
            }
        }
        
        
    } catch (FileNotFoundException e) {
        System.err.println("Players.txt file not found. Please ensure the file exists in the specified location.");
        e.printStackTrace(); }
        
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leader_Table;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
