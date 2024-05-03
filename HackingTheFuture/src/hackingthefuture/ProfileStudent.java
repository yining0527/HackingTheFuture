/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

/**
 *
 * @author yingying
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileStudent extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    
    // Variables for user information
    private String email;
    private String username;
    private String role;
    private String locationCoordinate;
    private String father;
    private String mother;

    /**
     * Creates new form ProfileStudent
     */
    public ProfileStudent() {
        initComponents();
        this.username = username;  // Set the username
    }
    
    public void setUsername(String transferUsername) {
        this.username = transferUsername;
        takeInformation();
        takeParents();
    }
    
    private void takeInformation() {
        System.out.println("take information");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT * FROM `user` WHERE `username` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, username); // Set the username parameter at index 1

            System.out.println("SQL Query: " + querySD); // Print SQL query for debugging
            System.out.println("Username: " + username); // Print username for debugging

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ResultSet contains data.");
                this.email = rs.getString("email");
                this.role = rs.getString("role");
                this.locationCoordinate = rs.getString("LocationCoordinate");
            } else {
                System.out.println("ResultSet is empty.");
            }

            con.close();
        } catch (SQLException e) {
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
    }
    
    private void takeParents()
    {
        System.out.println("take father");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT * FROM `children` WHERE `userID` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, username); // Set the username parameter at index 1

            System.out.println("SQL Query: " + querySD); // Print SQL query for debugging
            System.out.println("Username: " + username); // Print username for debugging

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
        jLabelShowFRIENDS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 550));

        jLabelEMAIL.setBackground(new java.awt.Color(102, 102, 102));
        jLabelEMAIL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEMAIL.setForeground(new java.awt.Color(153, 153, 255));
        jLabelEMAIL.setText("Email");

        jLabelUSERNAME.setBackground(new java.awt.Color(102, 102, 102));
        jLabelUSERNAME.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUSERNAME.setForeground(new java.awt.Color(153, 153, 255));
        jLabelUSERNAME.setText("Username");

        jLabelROLE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelROLE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelROLE.setForeground(new java.awt.Color(153, 153, 255));
        jLabelROLE.setText("Role");

        jLabelLOCATIONCOORDINATE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelLOCATIONCOORDINATE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLOCATIONCOORDINATE.setForeground(new java.awt.Color(153, 153, 255));
        jLabelLOCATIONCOORDINATE.setText("Location Coordinate");

        jLabelFATHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelFATHER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFATHER.setForeground(new java.awt.Color(153, 153, 255));
        jLabelFATHER.setText("Father");

        jLabelShowUSERNAME.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowUSERNAME.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowUSERNAME.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowUSERNAME.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowEMAIL.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowEMAIL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowEMAIL.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowEMAIL.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowROLE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowROLE.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowROLE.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowROLE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowLOCATIONCOORDINATE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowLOCATIONCOORDINATE.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowLOCATIONCOORDINATE.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowLOCATIONCOORDINATE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowMOTHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowMOTHER.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowMOTHER.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowMOTHER.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelMOTHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelMOTHER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMOTHER.setForeground(new java.awt.Color(153, 153, 255));
        jLabelMOTHER.setText("Mother");

        jLabelShowFATHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowFATHER.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowFATHER.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowFATHER.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPOINTS.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPOINTS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPOINTS.setForeground(new java.awt.Color(153, 153, 255));
        jLabelPOINTS.setText("Points");

        jLabelShowPOINTS.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowPOINTS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowPOINTS.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowPOINTS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPOINTS1.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPOINTS1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPOINTS1.setForeground(new java.awt.Color(153, 153, 255));
        jLabelPOINTS1.setText("Friend(s)");

        jLabelShowFRIENDS.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowFRIENDS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowFRIENDS.setForeground(new java.awt.Color(153, 153, 255));
        jLabelShowFRIENDS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelPOINTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowFRIENDS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelShowFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPOINTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowFRIENDS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    // End of variables declaration//GEN-END:variables
}