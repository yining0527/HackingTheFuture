/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

/**
 *
 * @author yingying
 */

import java.awt.Dimension;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.BorderLayout;
import java.util.ArrayList;


public class ProfileStudentX extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    
    // Variables for user information
    private String email;
    private String currentUsername;
    private String role;
    private String locationCoordinate;
    private String father;
    private String mother;
    private ArrayList<String> friends;

    
    private int points;

    /**
     * Creates new form ProfileStudent
     */
    public ProfileStudentX() {
        initComponents();
        setPreferredSize(new Dimension(900,600));
        setResizable(true);
        this.currentUsername = currentUsername;  // Set the username
    }
    
    public void setUsername(String transferUsername) {
        this.currentUsername = transferUsername;
        takeInformation();
        takeParents();
        takeFriends();
//        fetchUserRole();
//        checkFriendshipAndDisplayButton();
    }

    private void takeInformation() {
         User us = new User (currentUsername);
        this.email = us.getEmail();
        this.role = us.getRole();
        this.locationCoordinate= us.getLocationCoordinate();

        System.out.println("Email: " + email);
        System.out.println(currentUsername);
        System.out.println(role);
        System.out.println(locationCoordinate);
        System.out.println(points);

        jLabelShowEMAIL.setText(email);
        jLabelShowUSERNAME.setText(currentUsername);
        jLabelShowROLE.setText(role);
        jLabelShowLOCATIONCOORDINATE.setText(locationCoordinate);
        jLabelShowPOINTS.setText(String.valueOf(points));
    }
    
    private void takeParents()
    {
        System.out.println("take father");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT * FROM `children` WHERE `userID` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, currentUsername); // Set the username parameter at index 1

            System.out.println("SQL Query: " + querySD); // Print SQL query for debugging
            System.out.println("Username: " + currentUsername); // Print username for debugging

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ResultSet contains data.");
                this.father = rs.getString("Father");
                this.mother = rs.getString("Mother");
            } else {
                System.out.println("ResultSet is empty.");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        System.out.println("father: " + father);
        System.out.println("mother: " + mother);

        jLabelShowFATHER.setText(father);
        jLabelShowMOTHER.setText(mother);
    }
    
    private void takeFriends() {
        friends = new ArrayList<>();
        StringBuilder friendNames = new StringBuilder();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String queryFriends = "SELECT * FROM `friend_requests` WHERE status = 'accepted'";
            pst = con.prepareStatement(queryFriends);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String friendName = "";
                if (currentUsername.equals(rs.getString("sender_username"))) {
                    friendName = rs.getString("receiver_username");
                } else if (currentUsername.equals(rs.getString("receiver_username"))) {
                    friendName = rs.getString("sender_username");
                }

                if (!friendName.isEmpty()) {
                    friends.add(friendName); // Add friend's username to the ArrayList
                    friendNames.append(friendName).append("\n"); // Append friend's username to the StringBuilder
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query for friends: " + e.getMessage());
        }

        System.out.println("Friends Names: " + friends);

        // Set the text content of jLabelShowFRIENDS to the names with HTML formatting (optional)
        StringBuilder friendDisplay = new StringBuilder("<html>");
        for (String friend : friends) {
            friendDisplay.append(friend).append("<br>"); // Append each friend's username followed by a line break in HTML
        }
        friendDisplay.append("</html>"); // Close the HTML tag
        jLabelShowFRIENDS.setText(friendDisplay.toString()); // Set the text in jLabelShowFRIENDS with HTML formatting

        System.out.println("Friends HTML: " + friendDisplay.toString());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelEMAIL = new javax.swing.JLabel();
        jLabelUSERNAME = new javax.swing.JLabel();
        jLabelROLE = new javax.swing.JLabel();
        jLabelLOCATIONCOORDINATE = new javax.swing.JLabel();
        jLabelFATHER = new javax.swing.JLabel();
        jLabelShowUSERNAME = new javax.swing.JLabel();
        jLabelShowEMAIL = new javax.swing.JLabel();
        jLabelShowROLE = new javax.swing.JLabel();
        jLabelShowLOCATIONCOORDINATE = new javax.swing.JLabel();
        jLabelShowMOTHER = new javax.swing.JLabel();
        jLabelMOTHER = new javax.swing.JLabel();
        jLabelShowFATHER = new javax.swing.JLabel();
        jLabelPOINTS = new javax.swing.JLabel();
        jLabelShowPOINTS = new javax.swing.JLabel();
        jLabelPOINTS1 = new javax.swing.JLabel();
        jScrollPaneShowFRIENDS = new javax.swing.JScrollPane();
        jLabelShowFRIENDS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel1.setText("User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 199, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 550));

        jLabelEMAIL.setBackground(new java.awt.Color(102, 102, 102));
        jLabelEMAIL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEMAIL.setForeground(new java.awt.Color(255, 153, 153));
        jLabelEMAIL.setText("Email");

        jLabelUSERNAME.setBackground(new java.awt.Color(102, 102, 102));
        jLabelUSERNAME.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUSERNAME.setForeground(new java.awt.Color(255, 153, 153));
        jLabelUSERNAME.setText("Username");

        jLabelROLE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelROLE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelROLE.setForeground(new java.awt.Color(255, 153, 153));
        jLabelROLE.setText("Role");

        jLabelLOCATIONCOORDINATE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelLOCATIONCOORDINATE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLOCATIONCOORDINATE.setForeground(new java.awt.Color(255, 153, 153));
        jLabelLOCATIONCOORDINATE.setText("Location Coordinate");

        jLabelFATHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelFATHER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFATHER.setForeground(new java.awt.Color(255, 153, 153));
        jLabelFATHER.setText("Father");

        jLabelShowUSERNAME.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowUSERNAME.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowUSERNAME.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowEMAIL.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowEMAIL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowEMAIL.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowROLE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowROLE.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowROLE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowLOCATIONCOORDINATE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowLOCATIONCOORDINATE.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowLOCATIONCOORDINATE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowMOTHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowMOTHER.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowMOTHER.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelMOTHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelMOTHER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMOTHER.setForeground(new java.awt.Color(255, 153, 153));
        jLabelMOTHER.setText("Mother");

        jLabelShowFATHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowFATHER.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowFATHER.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPOINTS.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPOINTS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPOINTS.setForeground(new java.awt.Color(255, 153, 153));
        jLabelPOINTS.setText("Points");

        jLabelShowPOINTS.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowPOINTS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowPOINTS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPOINTS1.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPOINTS1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPOINTS1.setForeground(new java.awt.Color(255, 153, 153));
        jLabelPOINTS1.setText("Friend(s)");

        jScrollPaneShowFRIENDS.setBackground(new java.awt.Color(255, 255, 255));

        jLabelShowFRIENDS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jScrollPaneShowFRIENDS.setViewportView(jLabelShowFRIENDS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPOINTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowROLE, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowMOTHER, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowPOINTS, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jScrollPaneShowFRIENDS)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(106, 438, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelShowFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(156, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPOINTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneShowFRIENDS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 590, 568));

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel2.setText("Account");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 263, 176, -1));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed
 
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
            java.util.logging.Logger.getLogger(ProfileStudentX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileStudentX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileStudentX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileStudentX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProfileStudentX ProfileStudentFrame = new ProfileStudentX();
                ProfileStudentFrame.pack(); // Pack the frame before displaying it
                ProfileStudentFrame.setVisible(true);
                ProfileStudentFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEMAIL;
    private javax.swing.JLabel jLabelFATHER;
    private javax.swing.JLabel jLabelLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelMOTHER;
    private javax.swing.JLabel jLabelPOINTS;
    private javax.swing.JLabel jLabelPOINTS1;
    private javax.swing.JLabel jLabelROLE;
    private javax.swing.JLabel jLabelShowEMAIL;
    private javax.swing.JLabel jLabelShowFATHER;
    private javax.swing.JLabel jLabelShowFRIENDS;
    private javax.swing.JLabel jLabelShowLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelShowMOTHER;
    private javax.swing.JLabel jLabelShowPOINTS;
    private javax.swing.JLabel jLabelShowROLE;
    private javax.swing.JLabel jLabelShowUSERNAME;
    private javax.swing.JLabel jLabelUSERNAME;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneShowFRIENDS;
    // End of variables declaration//GEN-END:variables
}
