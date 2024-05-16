/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Dimension;

/**
 *
 * @author Asus
 */
public class MainPageChildren extends javax.swing.JFrame {
    private String username;

    /**
     * Creates new form EventPage
     */
    public MainPageChildren() {
        initComponents();
        setPreferredSize(new Dimension(900,600));
        setResizable(true);
    }
    
    public void setUsername(String transferUsername) {
        this.username = transferUsername;
    }
    
    public String getUsername(){
        return username;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        viewAndattemptQuiz = new javax.swing.JButton();
        viewEvent = new javax.swing.JButton();
        leaderboard = new javax.swing.JToggleButton();
        discussion = new javax.swing.JButton();
        DATASTORAGE = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        profile = new javax.swing.JLabel();
        profile1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Main Page");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(350, 20, 220, 48);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("======================================================================================");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 70, 890, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ROLE: STUDENTS");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(760, 40, 120, 30);

        viewAndattemptQuiz.setBackground(new java.awt.Color(255, 255, 204));
        viewAndattemptQuiz.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewAndattemptQuiz.setText("View & Attempt Quiz");
        viewAndattemptQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAndattemptQuizActionPerformed(evt);
            }
        });
        jPanel1.add(viewAndattemptQuiz);
        viewAndattemptQuiz.setBounds(306, 135, 247, 62);

        viewEvent.setBackground(new java.awt.Color(204, 255, 255));
        viewEvent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewEvent.setText("View Event");
        viewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEventActionPerformed(evt);
            }
        });
        jPanel1.add(viewEvent);
        viewEvent.setBounds(306, 269, 247, 62);

        leaderboard.setBackground(new java.awt.Color(255, 153, 153));
        leaderboard.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        leaderboard.setText("Global Leaderboard");
        leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardActionPerformed(evt);
            }
        });
        jPanel1.add(leaderboard);
        leaderboard.setBounds(30, 50, 180, 22);

        discussion.setBackground(new java.awt.Color(255, 204, 204));
        discussion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        discussion.setText("Discussion");
        discussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discussionActionPerformed(evt);
            }
        });
        jPanel1.add(discussion);
        discussion.setBounds(306, 403, 247, 62);

        DATASTORAGE.setBackground(new java.awt.Color(255, 153, 153));
        DATASTORAGE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DATASTORAGE.setText("Export Data");
        DATASTORAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DATASTORAGEActionPerformed(evt);
            }
        });
        jPanel1.add(DATASTORAGE);
        DATASTORAGE.setBounds(97, 18, 100, 22);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(205, 18, 72, 22);
        jPanel1.add(profile);
        profile.setBounds(0, 0, 900, 570);

        profile1.setBackground(new java.awt.Color(255, 153, 153));
        profile1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        profile1.setText("Profile");
        profile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile1ActionPerformed(evt);
            }
        });
        jPanel1.add(profile1);
        profile1.setBounds(24, 18, 67, 22);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewAndattemptQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAndattemptQuizActionPerformed
        // TODO add your handling code here:
        
        ViewQuizPage ViewQuizPageFrame = new ViewQuizPage(getUsername());
        ViewQuizPageFrame.setVisible(true);
        ViewQuizPageFrame.pack();
        ViewQuizPageFrame.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_viewAndattemptQuizActionPerformed

    private void viewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEventActionPerformed
        // TODO add your handling code here:
        SViewEventPage ViewEventPageFrame = new SViewEventPage(getUsername());
        ViewEventPageFrame.setVisible(true);
        ViewEventPageFrame.pack();
        ViewEventPageFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_viewEventActionPerformed

    private void leaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderboardActionPerformed
        // TODO add your handling code here:
        GlobalLeaderboard leaderboard = new GlobalLeaderboard();
        leaderboard.setUsername(username);
        leaderboard.setVisible(true);
        leaderboard.pack();
        leaderboard.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_leaderboardActionPerformed

    private void discussionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discussionActionPerformed
        // TODO add your handling code here:
        Discussion ViewQuizPageFrame = new Discussion(getUsername());
        ViewQuizPageFrame.setVisible(true);
        ViewQuizPageFrame.pack();
        ViewQuizPageFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_discussionActionPerformed

    private void DATASTORAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DATASTORAGEActionPerformed
        // TODO add your handling code here:
        DataStorage DataStorageFrame = new DataStorage();
        DataStorageFrame.setUsername(username);
    }//GEN-LAST:event_DATASTORAGEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void profile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile1ActionPerformed
        // TODO add your handling code here:
        ProfileStudent ProfileStudentFrame = new ProfileStudent();
        ProfileStudentFrame.setUsername(username);
        boolean isCurrentUser = username.equals(username);
        ProfileStudentFrame.setUsernameAndButtonVisibility(username, !isCurrentUser);
        ProfileStudentFrame.setInboxVisibility(username, isCurrentUser);
        ProfileStudentFrame.setFriendshipStatusVisibility(username, isCurrentUser);
        ProfileStudentFrame.setVisible(true);
        ProfileStudentFrame.pack();
        ProfileStudentFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_profile1ActionPerformed
 
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPageChildren.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPageChildren.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPageChildren.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPageChildren.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                MainPageChildren MainPageStudentsFrame = new MainPageChildren();
                MainPageStudentsFrame.setVisible(true);
                MainPageStudentsFrame.pack();
                MainPageStudentsFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton DATASTORAGE;
    private javax.swing.JButton discussion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton leaderboard;
    private javax.swing.JLabel profile;
    private javax.swing.JToggleButton profile1;
    private javax.swing.JButton viewAndattemptQuiz;
    private javax.swing.JButton viewEvent;
    // End of variables declaration//GEN-END:variables
}
