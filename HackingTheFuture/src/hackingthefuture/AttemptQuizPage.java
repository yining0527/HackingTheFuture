/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Stack;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class AttemptQuizPage extends javax.swing.JFrame {

    private Stack<Class<?>> navigationHistory = new Stack<>();
    Connection con = null;
    PreparedStatement pst = null;

    // Variables for user information
    private String email;
    public String username;
    private String role;
    private String locationCoordinate;
    ResultSet rs;
    private int points;

    /**
     * Creates new form EventPage
     */
    public AttemptQuizPage() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        takeInformation(); // Retrieve user information
    }
     public AttemptQuizPage(String username) {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;  // Set the username
        takeInformation(); // Retrieve user information
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
    
    // Add a print statement to check the value of locationCoordinate
    System.out.println("Location Coordinate: " + locationCoordinate);

    System.out.println("Email: " + email);
    System.out.println(username);
    System.out.println(role);
    System.out.println(locationCoordinate);
}

    public AttemptQuizPage(Stack<Class<?>> navigationHistory) {
        initComponents();
        this.navigationHistory = navigationHistory;
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
        QuizizzLink = new javax.swing.JTextField();
        completeButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Attempt");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 550));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Please enter the Quizizz Link:");

        QuizizzLink.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        QuizizzLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuizizzLinkActionPerformed(evt);
            }
        });

        completeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        completeButton.setText("Complete");
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(completeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(QuizizzLink, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QuizizzLink, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(completeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quiz");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(210, 210, 210))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuizizzLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuizizzLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuizizzLinkActionPerformed

    private boolean isQuizValid(String userInput) {
        boolean quizValid = false;
        try {
            // Establish connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // SQL query to retrieve events from the database
            String query = "SELECT * FROM `quiz` WHERE `quiz content` = ?"; // Adjust query according to your database schema

            // Create a prepared statement for the query
            pst = con.prepareStatement(query);

            // Set the event title parameter
            pst.setString(1, userInput);

            // Execute the query and obtain the result set
            ResultSet resultSet = pst.executeQuery();

            // Iterate through the result set
            while (resultSet.next()) {
                // Get the event name from the result set
                String quizlink = resultSet.getString("quiz content");

                // Compare the user input with the event name
                if (userInput.equalsIgnoreCase(quizlink)) {
                    // If there's a match, set eventValid to true and break the loop
                    quizValid = true;
                    break;
                }
            }
        } catch (SQLException ex) {
            // Handle any SQL exceptions
            ex.printStackTrace();
        } finally {
            // Close the result set, statement, and connection
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return quizValid;
    }
    
    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButtonActionPerformed
        String quizLink = QuizizzLink.getText().trim(); // Remove leading and trailing whitespaces

        if (quizLink.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please don't forget to paste the quiz link before attempting it", "Reminder", JOptionPane.INFORMATION_MESSAGE);
        } else if (!quizLink.startsWith("https://")) {
            JOptionPane.showMessageDialog(null, "Please copy the valid quiz link", "Invalid Link", JOptionPane.ERROR_MESSAGE);
        } else if(!isQuizValid(quizLink)){
            JOptionPane.showMessageDialog(null, "No such quizz");
        }else {
            addPoints(2);
            JOptionPane.showMessageDialog(null, "You have earned 2 marks", "Marks Earned", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }



    }//GEN-LAST:event_completeButtonActionPerformed

    private void addPoints(int pointsToAdd) {

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
                this.points = rs.getInt("points");

                // Add the points to the existing points
                this.points += pointsToAdd;

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


    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
//        if (navigationHistory != null && !navigationHistory.isEmpty()) {
//            navigationHistory.pop(); // Remove current screen from history
//            if (!navigationHistory.isEmpty()) {
//                // Navigate back to the previous screen
//                Class<?> previousScreen = navigationHistory.peek();
//                try {
//                    javax.swing.JFrame previousFrame = (javax.swing.JFrame) previousScreen.newInstance();
//                    previousFrame.setVisible(true);
//                    previousFrame.pack();
//                    previousFrame.setLocationRelativeTo(null);
//                    this.dispose();
//                } catch (InstantiationException | IllegalAccessException ex) {
//                    // Handle exception
//                    ex.printStackTrace();
//                }
//            }
//        }

        ViewQuizPage ViewQuizPageFrame = new ViewQuizPage(getUsername());
        ViewQuizPageFrame.setUsername(username);
        ViewQuizPageFrame.setVisible(true);
        ViewQuizPageFrame.pack();
        ViewQuizPageFrame.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(AttemptQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AttemptQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AttemptQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AttemptQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                AttemptQuizPage AttemptQuizPageFrame = new AttemptQuizPage();
                AttemptQuizPageFrame.setVisible(true);
                AttemptQuizPageFrame.pack();
                AttemptQuizPageFrame.setLocationRelativeTo(null);
                AttemptQuizPageFrame.takeInformation(); 

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField QuizizzLink;
    private javax.swing.JButton backButton;
    private javax.swing.JButton completeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
