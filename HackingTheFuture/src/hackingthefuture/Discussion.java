/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Discussion extends javax.swing.JFrame {

    private String email;
    private String role;
    private String locationCoordinate;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    public String username;

    public Discussion() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        fetchPost(); // Move fetchPost() call here to fetch posts after initializing UI
    }
    
    // Method to fetch the four most recent posts
    private void fetchPost() {
        try {
            // Connect to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // Query to fetch the four most recent posts
            String postDetails = "SELECT * FROM `discussion` ORDER BY `time` DESC LIMIT 4";
            pst = con.prepareStatement(postDetails);
            ResultSet resultSet = pst.executeQuery();

            // Display the fetched posts in the text area
            displayPost(postField, resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Discussion(String username) {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;  // Set the username
        fetchPost();
        takeInformation(); // Retrieve user information
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        takeInformation(); // Retrieve user information
    }

    private void takeInformation() {
        System.out.println("take information");
        User us = new User(username);
        this.email = us.getEmail();
        this.role = us.getRole();
        this.locationCoordinate = us.getLocationCoordinate();
        // Add a print statement to check the value of locationCoordinate
        System.out.println("Location Coordinate: " + locationCoordinate);

        System.out.println("Email: " + email);
        System.out.println(username);
        System.out.println(role);
        System.out.println(locationCoordinate);
    }

    /**
     * Creates new form EventPage
     */
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
        jScrollPane1 = new javax.swing.JScrollPane();
        postField = new javax.swing.JTextPane();
        seeAllPosts = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        writePost = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Discussion");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 80, 300, 58);

        postField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        postField.setPreferredSize(new java.awt.Dimension(353, 185));
        jScrollPane1.setViewportView(postField);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(83, 166, 723, 310);

        seeAllPosts.setBackground(new java.awt.Color(255, 153, 153));
        seeAllPosts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seeAllPosts.setText("More posts");
        seeAllPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeAllPostsActionPerformed(evt);
            }
        });
        jPanel1.add(seeAllPosts);
        seeAllPosts.setBounds(739, 503, 120, 39);

        backButton.setBackground(new java.awt.Color(255, 153, 153));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton);
        backButton.setBounds(22, 12, 72, 27);

        writePost.setBackground(new java.awt.Color(255, 153, 153));
        writePost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        writePost.setText("Write post");
        writePost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writePostActionPerformed(evt);
            }
        });
        jPanel1.add(writePost);
        writePost.setBounds(32, 503, 119, 39);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(590, 10, 164, 148);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\kekyi\\Downloads\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back1.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 900, 570);

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(700, 40, 38, 16);

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seeAllPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeAllPostsActionPerformed
        // show all posts
        fetchAllPosts();
    }//GEN-LAST:event_seeAllPostsActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        switch (role) {
            case "educator":
                MainPageEducator eduFrame = new MainPageEducator();
                eduFrame.setUsername(username);
                eduFrame.setVisible(true);
                eduFrame.pack();
                eduFrame.setLocationRelativeTo(null);
                break;
            case "parent":
                MainPageParent parentFrame = new MainPageParent();
                parentFrame.setUsername(username);
                parentFrame.setVisible(true);
                parentFrame.pack();
                parentFrame.setLocationRelativeTo(null);
                break;
            case "children":
                MainPageChildren childrenFrame = new MainPageChildren();
                childrenFrame.setUsername(username);
                childrenFrame.setVisible(true);
                childrenFrame.pack();
                childrenFrame.setLocationRelativeTo(null);
                break;
            default:
                // Handle the case when the role is unknown or not supported
                System.out.println("Unsupported role: " + role);
                break;
        }

        // Close the current Discussion frame
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void writePostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writePostActionPerformed
        // TODO add your handling code here:
        WritingPost WritingPostFrame = new WritingPost(getUsername());
        WritingPostFrame.setVisible(true);
        WritingPostFrame.pack();
        WritingPostFrame.setLocationRelativeTo(null);

    }//GEN-LAST:event_writePostActionPerformed

    

    private void fetchAllPosts() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // Query to fetch all posts sorted by time in descending order
            String postDetails = "SELECT * FROM `discussion` ORDER BY `time` DESC";
            pst = con.prepareStatement(postDetails);
            ResultSet resultSet = pst.executeQuery();

            // Display the fetched posts in the text area
            displayPost(postField, resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayPost(javax.swing.JTextPane postField, ResultSet resultSet) throws SQLException {

        StringBuilder liveEventsBuilder = new StringBuilder();

        // Loop through the result set to retrieve and display each post
        while (resultSet.next()) {
            String postUsername = resultSet.getString("username");
            String postTitle = resultSet.getString("title");
            String postContent = resultSet.getString("content");
            String postTime = resultSet.getString("time");

            // Customize the display format as needed
            liveEventsBuilder.append("Name: ").append(postUsername).append("\n")
                    .append("Title: ").append(postTitle).append("\n")
                    .append("Content: ").append(postContent).append("\n")
                    .append("Post time: ").append(postTime).append("\n\n");
        }

        // Set the text of the text pane after retrieving all posts
        postField.setText(liveEventsBuilder.toString());
        postField.setEditable(false);
    }

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
            java.util.logging.Logger.getLogger(Discussion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Discussion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Discussion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Discussion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

                Discussion DiscussionFrame = new Discussion();
                DiscussionFrame.setVisible(true);
                DiscussionFrame.pack();
                DiscussionFrame.setLocationRelativeTo(null);
                DiscussionFrame.takeInformation();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane postField;
    private javax.swing.JButton seeAllPosts;
    private javax.swing.JButton writePost;
    // End of variables declaration//GEN-END:variables
}
