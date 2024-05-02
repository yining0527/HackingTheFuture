package hackingthefuture;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.util.Random;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

public class Role extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement psCheckUserExists = null;
    ResultSet resultSet = null;
    String role = null;

    private String username, email, pass;

    public Role() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        buttonGroup1.add(jRadioButtonEducator); // Add your radio buttons to the ButtonGroup
        buttonGroup1.add(jRadioButtonParent);
        buttonGroup1.add(jRadioButtonChildren);


    }

    public void setUsername(String transferUsername, String email, String pass) {
        username = transferUsername;
        this.email = email;
        this.pass = pass;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        signUp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonEducator = new javax.swing.JRadioButton();
        jRadioButtonParent = new javax.swing.JRadioButton();
        jRadioButtonChildren = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGN UP");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html>Hacking The Future </html>");
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel1.setName(""); // NOI18N
        jLabel1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(222, 222, 222))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(-10, -20, 400, 650);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        signUp.setBackground(new java.awt.Color(204, 204, 255));
        signUp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signUp.setForeground(new java.awt.Color(255, 255, 255));
        signUp.setText("Next");
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 255));
        jLabel2.setText("Role");

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 255));
        jLabel5.setText("Select your Role");

        jRadioButtonEducator.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButtonEducator.setText("Educator");
        jRadioButtonEducator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEducatorActionPerformed(evt);
            }
        });

        jRadioButtonParent.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButtonParent.setText("Parent");
        jRadioButtonParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonParentActionPerformed(evt);
            }
        });

        jRadioButtonChildren.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButtonChildren.setText("Children");
        jRadioButtonChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonChildrenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButtonEducator)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel2))
                            .addComponent(jRadioButtonParent)
                            .addComponent(jRadioButtonChildren))
                        .addContainerGap(160, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jRadioButtonParent)
                .addGap(27, 27, 27)
                .addComponent(jRadioButtonChildren)
                .addGap(30, 30, 30)
                .addComponent(jRadioButtonEducator)
                .addGap(36, 36, 36)
                .addComponent(signUp)
                .addGap(92, 92, 92))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(390, 10, 440, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpActionPerformed
        JFrame frame = new JFrame("Radio Button Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (!jRadioButtonEducator.isSelected() && !jRadioButtonParent.isSelected() && !jRadioButtonChildren.isSelected()) {
            JOptionPane.showMessageDialog(frame, "Please select an option", "Selection Required", JOptionPane.WARNING_MESSAGE);

        } else {
            double x = generateRandomCoordinate();
            double y = generateRandomCoordinate();
            String locationC = "(" + x + ", " + y + ")";

            try {
                // Establish connection to the database
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

                // Prepare the SQL query to update the role
                String query = "UPDATE `user` SET `role` = ?,`LocationCoordinate` = ? WHERE `email` = ? AND `username` = ? AND `password` = ?";

                // Create a PreparedStatement object
                pst = con.prepareStatement(query);

                // Set the parameters for the PreparedStatement
                pst.setString(1, role); // newRole is the new value for the role field
                pst.setString(2, locationC);
                pst.setString(3, email); // Assuming email.getText() retrieves the current email value
                pst.setString(4, username); // Assuming username.getText() retrieves the current username value
                pst.setString(5, pass); // Assuming pass.getText() retrieves the current password value

                // Execute the update operation
                pst.executeUpdate();

                // Optionally, you can add a success message here if needed
            } catch (SQLException ex) {
                // Handle any SQL errors here
                ex.printStackTrace();
            }

            //Hide the SignUp frame
            this.setVisible(false);

            if (role.equalsIgnoreCase("parent")) {
                numberofChildren NoChildFrame = new numberofChildren();
                NoChildFrame.setUsername(username);
                NoChildFrame.setVisible(true);
                NoChildFrame.pack();
                NoChildFrame.setLocationRelativeTo(null);

            } else if (role.equalsIgnoreCase("children")) {
                children children = new children();
                children.setUsername(username);
                children.setVisible(true);
                children.pack();
                children.setLocationRelativeTo(null);
            } else {

                Login LoginFrame = new Login();
                LoginFrame.setVisible(true);
                LoginFrame.pack();
                LoginFrame.setLocationRelativeTo(null);
            }
        }


    }//GEN-LAST:event_signUpActionPerformed

    public static double generateRandomCoordinate() {
        Random rand = new Random();
        double min = -500.0;
        double max = 500.0;
        double randomCoordinate = min + (max - min) * rand.nextDouble();
        return Math.round(randomCoordinate * 10.0) / 10.0; // Round to one decimal place
    }


    private void jRadioButtonEducatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEducatorActionPerformed
        // TODO add your handling code here:
        role = "educator";
    }//GEN-LAST:event_jRadioButtonEducatorActionPerformed

    private void jRadioButtonChildrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonChildrenActionPerformed
        // TODO add your handling code here:
        role = "children";
    }//GEN-LAST:event_jRadioButtonChildrenActionPerformed

    private void jRadioButtonParentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonParentActionPerformed
        // TODO add your handling code here:
        role = "parent";
    }//GEN-LAST:event_jRadioButtonParentActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Role signUpFrame = new Role();
                signUpFrame.setVisible(true);
                signUpFrame.pack();
                signUpFrame.setLocationRelativeTo(null);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonChildren;
    private javax.swing.JRadioButton jRadioButtonEducator;
    private javax.swing.JRadioButton jRadioButtonParent;
    private javax.swing.JButton signUp;
    // End of variables declaration//GEN-END:variables
}
