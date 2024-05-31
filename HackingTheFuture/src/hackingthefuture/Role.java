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
    private int numberOfQuizzes;
    private int numberOfEvents;
    private int points;

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
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonEducator = new javax.swing.JRadioButton();
        jRadioButtonParent = new javax.swing.JRadioButton();
        jRadioButtonChildren = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        signUp = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGN UP");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("<html>Hacking The Future </html>");
        jLabel1.setToolTipText("");
        jLabel1.setAutoscrolls(true);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.FLASH_OPTION);
        jLabel1.setFocusable(false);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jLabel1.setName(""); // NOI18N
        jLabel1.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 112, 290, 316));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back3.jpg")); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 390, 650));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(-10, -20, 400, 620);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Role");

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Select your Role");

        jRadioButtonEducator.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButtonEducator.setForeground(new java.awt.Color(255, 153, 153));
        jRadioButtonEducator.setText("Educator");
        jRadioButtonEducator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEducatorActionPerformed(evt);
            }
        });

        jRadioButtonParent.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButtonParent.setForeground(new java.awt.Color(255, 153, 153));
        jRadioButtonParent.setText("Parent");
        jRadioButtonParent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonParentActionPerformed(evt);
            }
        });

        jRadioButtonChildren.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jRadioButtonChildren.setForeground(new java.awt.Color(255, 153, 153));
        jRadioButtonChildren.setText("Children");
        jRadioButtonChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonChildrenActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\Teacher (1).png")); // NOI18N

        signUp.setBackground(new java.awt.Color(255, 153, 153));
        signUp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        signUp.setText("Next");
        signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\Children (1).png")); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\Parent (1).png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jRadioButtonEducator)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButtonChildren)
                                    .addComponent(jRadioButtonParent))
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 32, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jRadioButtonParent)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jRadioButtonChildren))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jRadioButtonEducator))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(206, 206, 206)
                        .addComponent(signUp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(390, 0, 480, 650);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                setPoints();
                children children = new children();
                children.setUsername(username,role);
                children.setVisible(true);
                children.pack();
                children.setLocationRelativeTo(null);
            } else if (role.equalsIgnoreCase("educator")) {
                setNumberOfQuizzesAndEvents();
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

    public void setNumberOfQuizzesAndEvents() {
        System.out.println("Take information");
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
                // Check if numberOfEvents is NULL and set it to 0
                this.numberOfEvents = rs.getInt("numberOfEvents");
                if (rs.wasNull()) {
                    this.numberOfEvents = 0;
                }

                // Check if quizz is NULL and set it to 0
                this.numberOfQuizzes = rs.getInt("numberOfQuizzes");
                if (rs.wasNull()) {
                    this.numberOfQuizzes = 0;
                }

                // Update the database with the new points
                String updateQuery = "UPDATE `user` SET `numberOfEvents` = ?, `numberOfQuizzes` = ? WHERE `username` = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setInt(1, this.numberOfEvents);
                pst.setInt(2, this.numberOfQuizzes);
                pst.setString(3, username);
                pst.executeUpdate();

            } else {
                System.out.println("ResultSet is empty.");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        System.out.println(username);
        System.out.println(numberOfEvents);
        System.out.println(numberOfQuizzes);
    }

    public void setPoints() {
        System.out.println("Take information");
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
                // Check if points is NULL and set it to 0
                this.points = rs.getInt("points");
                if (rs.wasNull()) {
                    this.points = 0;
                }
                // Update the database with the new points
                String updateQuery = "UPDATE `user` SET `points` = ? WHERE `username` = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setInt(1, this.points);
                pst.setString(2, username);
                pst.executeUpdate();
            } else {
                System.out.println("ResultSet is empty.");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        System.out.println(username);
        System.out.println(points);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButtonChildren;
    private javax.swing.JRadioButton jRadioButtonEducator;
    private javax.swing.JRadioButton jRadioButtonParent;
    private javax.swing.JButton signUp;
    // End of variables declaration//GEN-END:variables
}
