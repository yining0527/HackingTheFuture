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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ProfileParent extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    
    // Variables for user information
    private String email;
    private String username;
    private String password;
    private String role;
    private String locationCoordinate;
    private ArrayList<String> childrenNames = new ArrayList<>();


    /**
     * Creates new form UserAccountParent
     */
    public ProfileParent() {
        initComponents();
        setPreferredSize(new Dimension(900,600));
        setResizable(true);
        this.username = username;  // Set the username
        
    }
    
    public void setUsername(String transferUsername) {
        this.username = transferUsername;
        takeInformation1();
//        takeChildren();
        takeBookings();
}
    
    private void takeInformation1(){
        System.out.println("take information");
        User us = new User (username);
        this.email = us.getEmail();
        this.role = us.getRole();
        this.locationCoordinate= us.getLocationCoordinate();
        this. childrenNames =us.getChildren();
        System.out.println(us.getChildren());
        jLabelShowEMAIL.setText(email);
        jLabelShowUSERNAME.setText(username);
        jLabelShowROLE.setText(role);
        jLabelShowLOCATIONCOORDINATE.setText(locationCoordinate);
         // Display childrenNames using jLabelShowCHILDREN with HTML formatting for new lines
        StringBuilder childrenDisplay = new StringBuilder("<html>");
        for (String child : childrenNames) {
            childrenDisplay.append(child).append("<br>"); // Append each child's username followed by a line break in HTML
            System.out.println(childrenNames);
        }
        childrenDisplay.append("</html>"); // Close the HTML tag
        jLabelShowCHILDREN.setText(childrenDisplay.toString()); // Set the text in jLabelShowCHILDREN with HTML formatting
    }

    private void takeBookings()
    {
        System.out.println("take bookings");
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String queryBooking = "SELECT * FROM `bookingdestination` WHERE `parentName` = ?";
            pst = con.prepareStatement(queryBooking);
            pst.setString(1, username); // Set the username parameter at index 1
            
            System.out.println("SQL Query for booking: " + queryBooking); // Print SQL query for debugging
            System.out.println("Username: " + username); // Print username for debugging
            
            ResultSet rs = pst.executeQuery();
            
            // Get the table model from jTable1
            DefaultTableModel model = (DefaultTableModel) jTableShowBOOKINGS.getModel();
            
            // Add columns to the table model if they are not set in the GUI designer
            model.setColumnIdentifiers(new Object[]{"Parents", "Children", "Destination", "Visit Date"});

            // Clear existing rows
            model.setRowCount(0);
            
            while (rs.next()) {
            String childName = rs.getString("childName");
            String destination = rs.getString("destination");
            String visitDate = rs.getString("visitDate");
            
            model.addRow(new Object[]{username, childName, destination, visitDate});
            
            // Display the data
                System.out.println(username + "\t" + childName + "\t" + destination + "\t" + visitDate);
            }
            
            // Adjust the column width for the "Destination" column
            TableColumn column = jTableShowBOOKINGS.getColumnModel().getColumn(2); // Index 2 represents the "Destination" column
            column.setPreferredWidth(230); // Adjust the width as needed

        con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelEMAIL = new javax.swing.JLabel();
        jLabelUSERNAME = new javax.swing.JLabel();
        jLabelROLE = new javax.swing.JLabel();
        jLabelLOCATIONCOORDINATE = new javax.swing.JLabel();
        jLabelCHILDREN = new javax.swing.JLabel();
        jLabelShowUSERNAME = new javax.swing.JLabel();
        jLabelShowEMAIL = new javax.swing.JLabel();
        jLabelShowROLE = new javax.swing.JLabel();
        jLabelShowLOCATIONCOORDINATE = new javax.swing.JLabel();
        jLabelShowCHILDREN = new javax.swing.JLabel();
        jLabelPASTBOOKINGSMADE = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableShowBOOKINGS = new javax.swing.JTable();
        jLabelPASTBOOKINGSMADE1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 201, -1, -1));

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

        jLabelCHILDREN.setBackground(new java.awt.Color(102, 102, 102));
        jLabelCHILDREN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelCHILDREN.setForeground(new java.awt.Color(255, 153, 153));
        jLabelCHILDREN.setText("Child / Children");

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
        jLabelShowLOCATIONCOORDINATE.setText(" ");
        jLabelShowLOCATIONCOORDINATE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowCHILDREN.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowCHILDREN.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowCHILDREN.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelShowCHILDREN.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPASTBOOKINGSMADE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPASTBOOKINGSMADE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPASTBOOKINGSMADE.setForeground(new java.awt.Color(255, 153, 153));
        jLabelPASTBOOKINGSMADE.setText("Past Bookings");

        jTableShowBOOKINGS.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jTableShowBOOKINGS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Parents", "Children", "Destination", "Visit Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableShowBOOKINGS);

        jLabelPASTBOOKINGSMADE1.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPASTBOOKINGSMADE1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPASTBOOKINGSMADE1.setForeground(new java.awt.Color(255, 153, 153));
        jLabelPASTBOOKINGSMADE1.setText("Made");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCHILDREN, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelShowCHILDREN, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPASTBOOKINGSMADE, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPASTBOOKINGSMADE1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelShowROLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelROLE, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCHILDREN)
                    .addComponent(jLabelShowCHILDREN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelPASTBOOKINGSMADE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPASTBOOKINGSMADE1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 650, 568));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("Account");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 176, -1));

        backButton.setBackground(new java.awt.Color(255, 153, 153));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back3.jpg")); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 570));

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

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
            java.util.logging.Logger.getLogger(ProfileParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileParent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProfileParent ProfileParentFrame = new ProfileParent();
                ProfileParentFrame.pack(); // Pack the frame before displaying it
                ProfileParentFrame.setVisible(true);
                ProfileParentFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCHILDREN;
    private javax.swing.JLabel jLabelEMAIL;
    private javax.swing.JLabel jLabelLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelPASTBOOKINGSMADE;
    private javax.swing.JLabel jLabelPASTBOOKINGSMADE1;
    private javax.swing.JLabel jLabelROLE;
    private javax.swing.JLabel jLabelShowCHILDREN;
    private javax.swing.JLabel jLabelShowEMAIL;
    private javax.swing.JLabel jLabelShowLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelShowROLE;
    private javax.swing.JLabel jLabelShowUSERNAME;
    private javax.swing.JLabel jLabelUSERNAME;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableShowBOOKINGS;
    // End of variables declaration//GEN-END:variables
}
