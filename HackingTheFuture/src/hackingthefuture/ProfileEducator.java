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

public class ProfileEducator extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    
    // Variables for user information
    private String email;
    private String username;
    private String role;
    private String locationCoordinate;
    private int numberOfQuizzes;
    private int numberOfEvents;

    /**
     * Creates new form ProfileEducator
     */
    public ProfileEducator() {
        initComponents();
        setPreferredSize(new Dimension(900,600));
        setResizable(true);
        this.username = username;  // Set the username
    }
    
    public void setUsername(String transferUsername) {
        this.username = transferUsername;
        takeInformation();
    }
    
    private void takeInformation() {
          User us = new User (username);
        this.email = us.getEmail();
        this.role = us.getRole();
        this.locationCoordinate= us.getLocationCoordinate();
        
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            String querySD = "SELECT * FROM `user` WHERE `username` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, username); // Set the username parameter at index 1
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                this.numberOfQuizzes = rs.getInt("numberOfQuizzes");
                this.numberOfEvents = rs.getInt("numberOfEvents");
            }
            
            con.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        System.out.println("Email: " + email);
        System.out.println(username);
        System.out.println(role);
        System.out.println(locationCoordinate);

        jLabelShowEMAIL.setText(email);
        jLabelShowUSERNAME.setText(username);
        jLabelShowROLE.setText(role);
        jLabelShowLOCATIONCOORDINATE.setText(locationCoordinate);
        jLabelShowQUIZZESCREATED.setText(String.valueOf(numberOfQuizzes));
        jLabelShowEVENTSCREATED.setText(String.valueOf(numberOfEvents));
        
        
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
        jLabelShowUSERNAME = new javax.swing.JLabel();
        jLabelShowEMAIL = new javax.swing.JLabel();
        jLabelShowROLE = new javax.swing.JLabel();
        jLabelShowLOCATIONCOORDINATE = new javax.swing.JLabel();
        jLabelLQUIZZESCREATED = new javax.swing.JLabel();
        jLabelEVENTSCREATED = new javax.swing.JLabel();
        jLabelShowQUIZZESCREATED = new javax.swing.JLabel();
        jLabelShowEVENTSCREATED = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 205, -1, -1));

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

        jLabelLQUIZZESCREATED.setBackground(new java.awt.Color(102, 102, 102));
        jLabelLQUIZZESCREATED.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLQUIZZESCREATED.setForeground(new java.awt.Color(255, 153, 153));
        jLabelLQUIZZESCREATED.setText("Quizzes Created");

        jLabelEVENTSCREATED.setBackground(new java.awt.Color(102, 102, 102));
        jLabelEVENTSCREATED.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEVENTSCREATED.setForeground(new java.awt.Color(255, 153, 153));
        jLabelEVENTSCREATED.setText("Events Created");

        jLabelShowQUIZZESCREATED.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowQUIZZESCREATED.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowQUIZZESCREATED.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowEVENTSCREATED.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowEVENTSCREATED.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowEVENTSCREATED.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelLQUIZZESCREATED, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelShowQUIZZESCREATED, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelEVENTSCREATED, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelShowEVENTSCREATED, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelShowROLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelShowQUIZZESCREATED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLQUIZZESCREATED, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelShowEVENTSCREATED, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEVENTSCREATED, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 580, 568));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("Account");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 269, 176, -1));

        backButton.setBackground(new java.awt.Color(255, 153, 153));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back3.jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(ProfileEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                ProfileEducator ProfileEducatorFrame = new ProfileEducator();
                ProfileEducatorFrame.pack(); // Pack the frame before displaying it
                ProfileEducatorFrame.setVisible(true);
                ProfileEducatorFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelEMAIL;
    private javax.swing.JLabel jLabelEVENTSCREATED;
    private javax.swing.JLabel jLabelLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelLQUIZZESCREATED;
    private javax.swing.JLabel jLabelROLE;
    private javax.swing.JLabel jLabelShowEMAIL;
    private javax.swing.JLabel jLabelShowEVENTSCREATED;
    private javax.swing.JLabel jLabelShowLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelShowQUIZZESCREATED;
    private javax.swing.JLabel jLabelShowROLE;
    private javax.swing.JLabel jLabelShowUSERNAME;
    private javax.swing.JLabel jLabelUSERNAME;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
