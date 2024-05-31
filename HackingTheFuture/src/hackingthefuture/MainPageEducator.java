/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Dimension;

/**
 *
 * @author Asus
 */
public class MainPageEducator extends javax.swing.JFrame {

    private String username;

    /**
     * Creates new form EventPage
     */
    public MainPageEducator() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
    }

    public void setUsername(String transferUsername) {
        this.username = transferUsername;
    }

    public String getUsername() {
        return username;
    }

    public MainPageEducator(String username) {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;  // Set the username
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
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        createQuiz = new javax.swing.JButton();
        viewEvent = new javax.swing.JButton();
        createEvent = new javax.swing.JButton();
        discussion = new javax.swing.JButton();
        jButtonPROFILE = new javax.swing.JButton();
        jButtonDATASTORAGE = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ViewOthersProfile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Main Page");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 20, 220, 60);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("======================================================================================");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 70, 910, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("ROLE: EDUCATOR");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(750, 40, 130, 20);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(507, 14, 0, 0);

        createQuiz.setBackground(new java.awt.Color(204, 255, 204));
        createQuiz.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createQuiz.setText("Create Quiz");
        createQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createQuizActionPerformed(evt);
            }
        });
        jPanel1.add(createQuiz);
        createQuiz.setBounds(330, 200, 247, 62);

        viewEvent.setBackground(new java.awt.Color(204, 255, 255));
        viewEvent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewEvent.setText("View Event");
        viewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEventActionPerformed(evt);
            }
        });
        jPanel1.add(viewEvent);
        viewEvent.setBounds(330, 290, 247, 62);

        createEvent.setBackground(new java.awt.Color(255, 255, 204));
        createEvent.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createEvent.setText("Create Event ");
        createEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEventActionPerformed(evt);
            }
        });
        jPanel1.add(createEvent);
        createEvent.setBounds(330, 100, 247, 62);

        discussion.setBackground(new java.awt.Color(255, 204, 204));
        discussion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        discussion.setText("Discussion");
        discussion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discussionActionPerformed(evt);
            }
        });
        jPanel1.add(discussion);
        discussion.setBounds(330, 380, 247, 62);

        jButtonPROFILE.setBackground(new java.awt.Color(255, 153, 153));
        jButtonPROFILE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPROFILE.setText("Profile");
        jButtonPROFILE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPROFILEActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPROFILE);
        jButtonPROFILE.setBounds(19, 16, 72, 22);

        jButtonDATASTORAGE.setBackground(new java.awt.Color(255, 153, 153));
        jButtonDATASTORAGE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonDATASTORAGE.setText("Export Data");
        jButtonDATASTORAGE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDATASTORAGEActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDATASTORAGE);
        jButtonDATASTORAGE.setBounds(109, 16, 100, 22);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(223, 16, 72, 22);

        ViewOthersProfile.setBackground(new java.awt.Color(204, 204, 255));
        ViewOthersProfile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ViewOthersProfile.setText("View Others' Profile");
        ViewOthersProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewOthersProfileActionPerformed(evt);
            }
        });
        jPanel1.add(ViewOthersProfile);
        ViewOthersProfile.setBounds(330, 470, 250, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back1.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, -10, 910, 570);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createQuizActionPerformed
        // TODO add your handling code here:
        CreateQuizPage CreateQuizPageFrame = new CreateQuizPage(getUsername());
        CreateQuizPageFrame.setUsername(username);
        CreateQuizPageFrame.setVisible(true);
        CreateQuizPageFrame.pack();
        CreateQuizPageFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_createQuizActionPerformed

    private void viewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEventActionPerformed
        // TODO add your handling code here:
        ViewEventPage ViewEventPageFrame = new ViewEventPage(getUsername());
        ViewEventPageFrame.setUsername(username);
        ViewEventPageFrame.setVisible(true);
        ViewEventPageFrame.pack();
        ViewEventPageFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_viewEventActionPerformed

    private void createEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEventActionPerformed
        // TODO add your handling code here:
        CreateEventPage CreateEventPageFrame = new CreateEventPage(getUsername());
        CreateEventPageFrame.setUsername(username);
        CreateEventPageFrame.setVisible(true);
        CreateEventPageFrame.pack();
        CreateEventPageFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_createEventActionPerformed

    private void discussionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discussionActionPerformed
        // TODO add your handling code here:

        Discussion DiscussionFrame = new Discussion(getUsername());
        DiscussionFrame.setUsername(username);
         DiscussionFrame.setVisible(true);
         DiscussionFrame.pack();
         DiscussionFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_discussionActionPerformed

    private void jButtonPROFILEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPROFILEActionPerformed
        // TODO add your handling code here:
        ProfileEducator ProfileEducatorFrame = new ProfileEducator();
        ProfileEducatorFrame.setUsername(username);
        ProfileEducatorFrame.setVisible(true);
        ProfileEducatorFrame.pack();
        ProfileEducatorFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButtonPROFILEActionPerformed

    private void jButtonDATASTORAGEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDATASTORAGEActionPerformed
        // TODO add your handling code here:
        DataStorage DataStorageFrame = new DataStorage();
        DataStorageFrame.setUsername(username);
    }//GEN-LAST:event_jButtonDATASTORAGEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ViewOthersProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewOthersProfileActionPerformed
        // TODO add your handling code here:
        ViewOthersProfile othersProfileFrame = new ViewOthersProfile();
        othersProfileFrame.setUsername(username);
        othersProfileFrame.pack(); // Pack the frame before displaying it
        othersProfileFrame.setVisible(true);
        othersProfileFrame.setLocationRelativeTo(null);

    }//GEN-LAST:event_ViewOthersProfileActionPerformed

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
            java.util.logging.Logger.getLogger(MainPageEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPageEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPageEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPageEducator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                MainPageEducator MainPageEducatorsFrame = new MainPageEducator();
                MainPageEducatorsFrame.setVisible(true);
                MainPageEducatorsFrame.pack();
                MainPageEducatorsFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewOthersProfile;
    private javax.swing.JButton createEvent;
    private javax.swing.JButton createQuiz;
    private javax.swing.JButton discussion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDATASTORAGE;
    private javax.swing.JButton jButtonPROFILE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton viewEvent;
    // End of variables declaration//GEN-END:variables
}
