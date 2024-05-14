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
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class CreateEventPage extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement psCheckUserExists = null;
    ResultSet resultSet = null;

    private String title;
    private String description;
    private String venue;
    private String date;
    private String startTime;
    private String endTime;
    private String email;
    public String username;
    private String role;
    private String locationCoordinate;
    private int numberOfEvents;

    /**
     * Creates new form EventPage
     */
     public String getUsername(){
        return username;
    }
    public CreateEventPage(){
        initComponents();
        setPreferredSize(new Dimension(900, 600));
    }
    public void setUsername(String username) {
        this.username = username;
        takeInformation(); // Retrieve user information
    }
    public CreateEventPage(String username) {
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
        eventTitle = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        eventDescription = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        eventVenue = new javax.swing.JTextField();
        eventDate = new javax.swing.JTextField();
        eventStartTime = new javax.swing.JTextField();
        createEventButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        eventEndTime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 550));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 52)); // NOI18N
        jLabel1.setText("Create ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 180, 190, 60);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 550));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Event Title");

        eventTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eventTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventTitleActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Event Description");

        eventDescription.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eventDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventDescriptionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Event Venue");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Event Date (YYYY/MM/DD)");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("Event Start Time(HH:MM:SS)");

        eventVenue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eventVenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventVenueActionPerformed(evt);
            }
        });

        eventDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eventDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventDateActionPerformed(evt);
            }
        });

        eventStartTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eventStartTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventStartTimeActionPerformed(evt);
            }
        });

        createEventButton.setBackground(new java.awt.Color(255, 153, 153));
        createEventButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        createEventButton.setText("Create");
        createEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEventButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("Event End Time(HH:MM:SS)");

        eventEndTime.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eventEndTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventEndTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createEventButton)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(eventTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(eventDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(eventVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(eventDate, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(eventStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(eventEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventVenue, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventDate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createEventButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(235, 0, 659, 571);

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 52)); // NOI18N
        jLabel2.setText("Event");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 240, 163, 63);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(17, 6, 72, 27);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(32, 329, 163, 0);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\OneDrive\\Documents\\NetBeansProjects\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\createEvent.png")); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 340, 190, 180);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\OneDrive\\Documents\\NetBeansProjects\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back2.jpg")); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(0, 0, 240, 580);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventTitleActionPerformed

    private void eventDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventDescriptionActionPerformed

    private void eventVenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventVenueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventVenueActionPerformed

    private void eventDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventDateActionPerformed

    private void eventStartTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventStartTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventStartTimeActionPerformed

    private void createEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEventButtonActionPerformed
        if (!validateEventData()) {
            return; // Stop event creation if data validation fails
        }

        title = eventTitle.getText();
        description = eventDescription.getText();
        venue = eventVenue.getText();
        date = eventDate.getText();
        startTime = eventStartTime.getText();
        endTime = eventEndTime.getText();

        // Optionally, you can print the data to verify it's captured correctly
        System.out.println("Event Title: " + title);
        System.out.println("Event Description: " + description);
        System.out.println("Event Venue: " + venue);
        System.out.println("Event Date: " + date);
        System.out.println("Event Start Time: " + startTime);

        if (title.isEmpty() || description.isEmpty() || venue.isEmpty() || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all the blanks.");
            return;
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // Check if the event already exists based on title, description, venue, date, and time
            String query = "SELECT * FROM `event` WHERE `event title` = ? AND `event description` = ? AND `event venue` = ? AND `event date` = ? AND `event start time` = ? AND `event end time` = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, title);
            pst.setString(2, description);
            pst.setString(3, venue);
            pst.setString(4, date);
            pst.setString(5, startTime);
            pst.setString(6, endTime);
            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                // Event already exists
                JOptionPane.showMessageDialog(null, "EVENT ALREADY EXISTS");
            } else {
                // Event does not exist, insert it into the database
                String insertQuery = "INSERT INTO `event`(`event title`, `event description`, `event venue`, `event date`, `event start time`, `event end time`) VALUES (?,?,?,?,?,?)";
                pst = con.prepareStatement(insertQuery);
                pst.setString(1, title);
                pst.setString(2, description);
                pst.setString(3, venue);
                pst.setString(4, date);
                pst.setString(5, startTime);
                pst.setString(6, endTime);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "EVENT SAVED SUCCESSFULLY");
                addNumberOfEvents();
                this.dispose();
                MainPageEducator MainPageEducatorsFrame = new MainPageEducator(getUsername());
                MainPageEducatorsFrame.setVisible(true);
                MainPageEducatorsFrame.pack();
                MainPageEducatorsFrame.setLocationRelativeTo(null);
                // Optionally, you can hide the current frame here if needed
                // this.setVisible(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_createEventButtonActionPerformed

    private void addNumberOfEvents() {

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
                this.numberOfEvents = rs.getInt("numberOfEvents");

                // Add the points to the existing points
                this.numberOfEvents += 1;

                // Update the database with the new points
                String updateQuery = "UPDATE `user` SET `numberOfEvents` = ? WHERE `username` = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setInt(1, this.numberOfEvents);
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
        System.out.println(numberOfEvents);
    }
    
    private void eventEndTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventEndTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventEndTimeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainPageEducator EduFrame = new MainPageEducator();
        EduFrame.setUsername(username);
        EduFrame.setVisible(true);
        EduFrame.pack();
        EduFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed
    private boolean validateEventData() {
        // Check if required fields are empty
        if (eventTitle.getText().isEmpty()
                || eventDescription.getText().isEmpty()
                || eventVenue.getText().isEmpty()
                || eventDate.getText().isEmpty()
                || eventStartTime.getText().isEmpty() || eventEndTime.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate date format (DD/MM/YYYY)
        String datePattern = "\\d{4}/\\d{2}/\\d{2}";
        if (!eventDate.getText().matches(datePattern)) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please use YYYY/MM/DD.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate time format (HH:MM)
        String timePattern = "\\d{2}:\\d{2}:\\d{2}";
        if (!eventStartTime.getText().matches(timePattern) || !eventEndTime.getText().matches(timePattern)) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Please use HH:MM:SS.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; // All validation checks passed
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
            java.util.logging.Logger.getLogger(CreateEventPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateEventPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateEventPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateEventPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                CreateEventPage CreateEventPageFrame = new CreateEventPage();
                CreateEventPageFrame.setVisible(true);
                CreateEventPageFrame.pack();
                CreateEventPageFrame.setLocationRelativeTo(null);
                CreateEventPageFrame.takeInformation(); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createEventButton;
    private javax.swing.JTextField eventDate;
    private javax.swing.JTextField eventDescription;
    private javax.swing.JTextField eventEndTime;
    private javax.swing.JTextField eventStartTime;
    private javax.swing.JTextField eventTitle;
    private javax.swing.JTextField eventVenue;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
