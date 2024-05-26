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
    
    public void setUsername(String username) {
        this.username = username;
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
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Theme: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 9, -1, -1));

        scienceButton.setBackground(new java.awt.Color(255, 153, 153));
        scienceButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        scienceButton.setForeground(new java.awt.Color(0, 0, 0));
        scienceButton.setText("Science");
        scienceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scienceButtonActionPerformed(evt);
            }
        });
        jPanel1.add(scienceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(287, 11, 98, 35));

        technologyButton.setBackground(new java.awt.Color(255, 204, 153));
        technologyButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        technologyButton.setForeground(new java.awt.Color(0, 0, 0));
        technologyButton.setText("Technology");
        technologyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                technologyButtonActionPerformed(evt);
            }
        });
        jPanel1.add(technologyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 11, -1, 35));

        engineeringButton.setBackground(new java.awt.Color(255, 255, 153));
        engineeringButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        engineeringButton.setForeground(new java.awt.Color(0, 0, 0));
        engineeringButton.setText("Engineering");
        engineeringButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                engineeringButtonActionPerformed(evt);
            }
        });
        jPanel1.add(engineeringButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 13, -1, -1));

        mathematicsButton.setBackground(new java.awt.Color(204, 255, 204));
        mathematicsButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        mathematicsButton.setForeground(new java.awt.Color(0, 0, 0));
        mathematicsButton.setText("Mathematics");
        mathematicsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mathematicsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(mathematicsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 13, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Science");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 73, 119, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Technology");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 73, 121, -1));

        techList.setBackground(new java.awt.Color(255, 204, 153));
        jScrollPane2.setViewportView(techList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 104, 353, 179));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Engineering");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 307, 120, -1));

        ScienceList.setBackground(new java.awt.Color(255, 153, 153));
        jScrollPane3.setViewportView(ScienceList);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 104, 353, 180));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Mathematics");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 301, 119, -1));

        mathList.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane4.setViewportView(mathList);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(478, 338, 353, 180));

        AttemptQuizButton.setBackground(new java.awt.Color(153, 255, 255));
        AttemptQuizButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AttemptQuizButton.setForeground(new java.awt.Color(0, 0, 0));
        AttemptQuizButton.setText("AttemptQuiz");
        AttemptQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttemptQuizButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AttemptQuizButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(726, 524, 127, -1));

        engList.setBackground(new java.awt.Color(255, 255, 153));
        jScrollPane5.setViewportView(engList);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 338, 353, 180));

        returnButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        returnButton.setText("Return");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 537, -1, -1));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\kekyi\\Downloads\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back1.jpg")); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 570));

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
    private javax.swing.JLabel jLabel6;
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
