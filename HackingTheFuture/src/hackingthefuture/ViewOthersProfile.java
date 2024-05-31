/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Dimension;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yingying
 */
public class ViewOthersProfile extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;

    private String username;

    /**
     * Creates new form GlobalLeaderboard
     */
    public ViewOthersProfile() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;  // Set the username
        viewProfile();
    }

    public void setUsername(String transferUsername) {
        this.username = transferUsername;
        takeInformation();
        viewProfile();
    }

    public void takeInformation() {
        System.out.println("Retrieving user information...");

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT email, username, role FROM user";
            pst = con.prepareStatement(querySD);

            System.out.println("SQL Query: " + querySD);
            System.out.println("Current Username: " + username);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTableOthersProfileBoard.getModel();
            model.setColumnIdentifiers(new Object[]{"Email", "Username", "Role"});
            model.setRowCount(0); // Clear existing rows

            while (rs.next()) {
                String email = rs.getString("email");
                String usernames = rs.getString("username");
                String role = rs.getString("role");

                model.addRow(new Object[]{email, usernames, role});

                // Display the data for debugging
                System.out.println(email + "\t" + usernames + "\t" + role);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    private void viewProfile() {
        int selectedRow = jTableOthersProfileBoard.getSelectedRow();
        if (selectedRow != -1) { // If a row is selected
            // Retrieve player data from the selected row
            String username1 = jTableOthersProfileBoard.getValueAt(selectedRow, 1).toString(); // Assuming username is in the first column
            String role = jTableOthersProfileBoard.getValueAt(selectedRow, 2).toString();
            System.out.println(username1);

            if (role != null) {
                switch (role.trim()) {
                    case "parent":
                        ProfileParent ProfileParentFrame = new ProfileParent();
                        ProfileParentFrame.pack();
                        ProfileParentFrame.setLocationRelativeTo(null);
                        ProfileParentFrame.setUsername(username1);
                        ProfileParentFrame.setVisible(true);
                        break;
                    case "educator":
                        //Display educator's profile
                        ProfileEducator profileEducatorFrame = new ProfileEducator();
                        profileEducatorFrame.setUsername(username1); // Set the username for the educator's profile
                        profileEducatorFrame.pack();
                        profileEducatorFrame.setLocationRelativeTo(null);
                        profileEducatorFrame.setVisible(true);
                        break;
                    case "children":
                        System.out.println("Opening ProfileStudentX frame...");
                        ProfileStudentX aframe = new ProfileStudentX();
                        aframe.setUsername(username1);
                        aframe.pack(); // Pack the frame before displaying it
                        aframe.setLocationRelativeTo(null);
                        aframe.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Unknown role: " + role);
                        return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Could not retrieve the role for the selected user.");
            }
        } else {
//            // Inform the user to select a row
//            JOptionPane.showMessageDialog(this, "Please select a user from the others' profile board to view their profile.");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOthersProfileBoard = new javax.swing.JTable();
        jLabelLeaderboard = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(850, 550));
        jPanel1.setLayout(null);

        jTableOthersProfileBoard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Email", "Username", "Role"
            }
        ));
        jTableOthersProfileBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableOthersProfileBoardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableOthersProfileBoard);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 110, 780, 380);

        jLabelLeaderboard.setBackground(new java.awt.Color(255, 255, 255));
        jLabelLeaderboard.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabelLeaderboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeaderboard.setText("Others' Profile");
        jLabelLeaderboard.setToolTipText("");
        jPanel1.add(jLabelLeaderboard);
        jLabelLeaderboard.setBounds(140, 50, 600, 60);

        backButton.setBackground(new java.awt.Color(255, 153, 153));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton);
        backButton.setBounds(20, 20, 72, 22);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back1.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableOthersProfileBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableOthersProfileBoardMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) { // Double-click action (you can change this based on your requirement)
            viewProfile(); // View profile on double-click
        }
    }//GEN-LAST:event_jTableOthersProfileBoardMouseClicked

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
            java.util.logging.Logger.getLogger(ViewOthersProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOthersProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOthersProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOthersProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewOthersProfile othersProfileFrame = new ViewOthersProfile();
                othersProfileFrame.pack(); // Pack the frame before displaying it
                othersProfileFrame.setVisible(true);
                othersProfileFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLeaderboard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableOthersProfileBoard;
    // End of variables declaration//GEN-END:variables
}
