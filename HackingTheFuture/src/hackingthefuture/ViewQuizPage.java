/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Stack;

/**
 *
 * @author Asus
 */
public class ViewQuizPage extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public String username;

    /**
     * Creates new form EventPage
     */
    public ViewQuizPage() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        displayScienceQuizzes();
        displayTechnologyQuizzes();
        displayEngineeringQuizzes();
        displayMathematicsQuizzes();
    }
    
    public ViewQuizPage(String username){
        
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;
        displayScienceQuizzes();
        displayTechnologyQuizzes();
        displayEngineeringQuizzes();
        displayMathematicsQuizzes();
    }
    
    public String getUsername(){
        return username;
    }

    private void displayScienceQuizzes() {
        // Fetch and display Science-themed quizzes from your dataset
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            String scienceQuizQuery = "SELECT * FROM `quiz` WHERE `quiz theme` = 'Science'";
            pst = con.prepareStatement(scienceQuizQuery);
            ResultSet resultSet = pst.executeQuery();

            StringBuilder scienceQuizzes = new StringBuilder();
            while (resultSet.next()) {
                // Customize how you want to display each quiz
                String quizTitle = resultSet.getString("quiz title");
                String quizDescription = resultSet.getString("quiz description");
                String quizContent = resultSet.getString("quiz content");
                scienceQuizzes.append(quizTitle).append("\n").append(quizDescription).append("\n").append(quizContent).append("\n\n");
            }

            ScienceList.setEditable(true); // Set editable to true
            ScienceList.setText(scienceQuizzes.toString());
            ScienceList.setEditable(false); // Set editable back to false

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayTechnologyQuizzes() {
        // Fetch and display Science-themed quizzes from your dataset
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            String scienceQuizQuery = "SELECT * FROM `quiz` WHERE `quiz theme` = 'Technology'";
            pst = con.prepareStatement(scienceQuizQuery);
            ResultSet resultSet = pst.executeQuery();

            StringBuilder scienceQuizzes = new StringBuilder();
            while (resultSet.next()) {
                // Customize how you want to display each quiz
                String quizTitle = resultSet.getString("quiz title");
                String quizDescription = resultSet.getString("quiz description");
                String quizContent = resultSet.getString("quiz content");
                scienceQuizzes.append(quizTitle).append("\n").append(quizDescription).append("\n").append(quizContent).append("\n\n");
            }

            techList.setEditable(true); // Set editable to true
            techList.setText(scienceQuizzes.toString());
            techList.setEditable(false); // Set editable back to false

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayEngineeringQuizzes() {
        // Fetch and display Science-themed quizzes from your dataset
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            String scienceQuizQuery = "SELECT * FROM `quiz` WHERE `quiz theme` = 'Engineering'";
            pst = con.prepareStatement(scienceQuizQuery);
            ResultSet resultSet = pst.executeQuery();

            StringBuilder scienceQuizzes = new StringBuilder();
            while (resultSet.next()) {
                // Customize how you want to display each quiz
                String quizTitle = resultSet.getString("quiz title");
                String quizDescription = resultSet.getString("quiz description");
                String quizContent = resultSet.getString("quiz content");
                scienceQuizzes.append(quizTitle).append("\n").append(quizDescription).append("\n").append(quizContent).append("\n\n");
            }

            engList.setEditable(true); // Set editable to true
            engList.setText(scienceQuizzes.toString());
            engList.setEditable(false); // Set editable back to false

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayMathematicsQuizzes() {
        // Fetch and display Science-themed quizzes from your dataset
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            String scienceQuizQuery = "SELECT * FROM `quiz` WHERE `quiz theme` = 'Mathematics'";
            pst = con.prepareStatement(scienceQuizQuery);
            ResultSet resultSet = pst.executeQuery();

            StringBuilder scienceQuizzes = new StringBuilder();
            while (resultSet.next()) {
                // Customize how you want to display each quiz
                String quizTitle = resultSet.getString("quiz title");
                String quizDescription = resultSet.getString("quiz description");
                String quizContent = resultSet.getString("quiz content");
                scienceQuizzes.append(quizTitle).append("\n").append(quizDescription).append("\n").append(quizContent).append("\n\n");
            }

            mathList.setEditable(true); // Set editable to true
            mathList.setText(scienceQuizzes.toString());
            mathList.setEditable(false); // Set editable back to false

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Other methods and GUI components...
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
        scienceButton = new javax.swing.JButton();
        technologyButton = new javax.swing.JButton();
        engineeringButton = new javax.swing.JButton();
        mathematicsButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        techList = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ScienceList = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        mathList = new javax.swing.JTextPane();
        AttemptQuizButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        engList = new javax.swing.JTextPane();
        returnButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Theme: ");

        scienceButton.setBackground(new java.awt.Color(255, 153, 153));
        scienceButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scienceButton.setText("Science");
        scienceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scienceButtonActionPerformed(evt);
            }
        });

        technologyButton.setBackground(new java.awt.Color(255, 204, 153));
        technologyButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        technologyButton.setText("Technology");
        technologyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologyButtonActionPerformed(evt);
            }
        });

        engineeringButton.setBackground(new java.awt.Color(255, 255, 153));
        engineeringButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        engineeringButton.setText("Engineering");
        engineeringButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engineeringButtonActionPerformed(evt);
            }
        });

        mathematicsButton.setBackground(new java.awt.Color(204, 255, 204));
        mathematicsButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mathematicsButton.setText("Mathematics");
        mathematicsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mathematicsButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Science");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Technology");

        techList.setBackground(new java.awt.Color(255, 204, 153));
        jScrollPane2.setViewportView(techList);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Engineering");

        ScienceList.setBackground(new java.awt.Color(255, 153, 153));
        jScrollPane3.setViewportView(ScienceList);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Mathematics");

        mathList.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane4.setViewportView(mathList);

        AttemptQuizButton.setBackground(new java.awt.Color(153, 255, 255));
        AttemptQuizButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AttemptQuizButton.setText("AttemptQuiz");
        AttemptQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttemptQuizButtonActionPerformed(evt);
            }
        });

        engList.setBackground(new java.awt.Color(255, 255, 153));
        jScrollPane5.setViewportView(engList);

        returnButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scienceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(technologyButton)
                .addGap(10, 10, 10)
                .addComponent(engineeringButton)
                .addGap(10, 10, 10)
                .addComponent(mathematicsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(returnButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AttemptQuizButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(backButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scienceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(technologyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(engineeringButton)
                            .addComponent(mathematicsButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AttemptQuizButton)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(returnButton)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AttemptQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttemptQuizButtonActionPerformed
        AttemptQuizPage AttemptQuizPageFrame = new AttemptQuizPage(getUsername());
        AttemptQuizPageFrame.setVisible(true);
        AttemptQuizPageFrame.pack();
        AttemptQuizPageFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_AttemptQuizButtonActionPerformed

    private void mathematicsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mathematicsButtonActionPerformed
        // TODO add your handling code here:
        mathList.setVisible(!mathList.isVisible());

        if (mathList.isVisible()) {
            // Fetch and display Science-themed quizzes from your dataset
            displayMathematicsQuizzes();
            mathematicsButton.setBackground(new java.awt.Color(204, 255, 204));
        } else {
            // Clear the text pane if it's hidden
            mathList.setText("");
            mathematicsButton.setBackground(Color.gray);
        }
    }//GEN-LAST:event_mathematicsButtonActionPerformed

    private void engineeringButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_engineeringButtonActionPerformed
        // TODO add your handling code here:
        engList.setVisible(!engList.isVisible());

        if (engList.isVisible()) {
            // Fetch and display Science-themed quizzes from your dataset
            displayEngineeringQuizzes();
            engineeringButton.setBackground(new java.awt.Color(255, 255, 153));
        } else {
            // Clear the text pane if it's hidden
            engList.setText("");
            engineeringButton.setBackground(Color.gray);
        }
    }//GEN-LAST:event_engineeringButtonActionPerformed

    private void technologyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_technologyButtonActionPerformed
        // TODO add your handling code here:
        techList.setVisible(!techList.isVisible());

        if (techList.isVisible()) {
            // Fetch and display Science-themed quizzes from your dataset
            displayTechnologyQuizzes();
            technologyButton.setBackground(new java.awt.Color(255, 204, 153));
        } else {
            // Clear the text pane if it's hidden
            techList.setText("");
            technologyButton.setBackground(Color.gray);
        }
    }//GEN-LAST:event_technologyButtonActionPerformed

    private void scienceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scienceButtonActionPerformed
        // TODO add your handling code here:
        // Toggle the visibility of ScienceList
        ScienceList.setVisible(!ScienceList.isVisible());

        if (ScienceList.isVisible()) {
            // Fetch and display Science-themed quizzes from your dataset
            displayScienceQuizzes();
            scienceButton.setBackground(new java.awt.Color(255, 153, 153));
        } else {
            // Clear the text pane if it's hidden
            ScienceList.setText("");
            scienceButton.setBackground(Color.gray);
        }

        //        displayScienceQuizzes();
    }//GEN-LAST:event_scienceButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_returnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQuizPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                ViewQuizPage ViewQuizPageFrame = new ViewQuizPage();
                ViewQuizPageFrame.setVisible(true);
                ViewQuizPageFrame.pack();
                ViewQuizPageFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttemptQuizButton;
    private javax.swing.JTextPane ScienceList;
    private javax.swing.JButton backButton;
    private javax.swing.JTextPane engList;
    private javax.swing.JButton engineeringButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane mathList;
    private javax.swing.JButton mathematicsButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton scienceButton;
    private javax.swing.JTextPane techList;
    private javax.swing.JButton technologyButton;
    // End of variables declaration//GEN-END:variables
}
