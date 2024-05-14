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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class BookEventPage extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;

    // Variables for user information
    private String email;
    public String username;
    private String role;
    private int points;
    private int pointsToAdd;
    private String locationCoordinate;
    ResultSet rs;
    PreparedStatement psCheckUserExists = null;
    ResultSet resultSet = null;
    private boolean success = false;

    /**
     * Creates new form EventPage
     */
    public BookEventPage() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        takeInformation(); // Retrieve user information
        fillCombo();
    }

    public BookEventPage(String username) {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;  // Set the username
        takeInformation(); // Retrieve user information
        fillCombo();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        eventBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Booking Event");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 30, 390, 60);

        jLabel4.setBackground(new java.awt.Color(255, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Choose the Name of Events You Want To Join:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(240, 150, 485, 25);

        jLabel6.setBackground(new java.awt.Color(255, 153, 153));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("======================================================================================");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 90, 900, 20);

        doneButton.setBackground(new java.awt.Color(255, 153, 153));
        doneButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
        jPanel1.add(doneButton);
        doneButton.setBounds(720, 500, 90, 32);

        backButton.setBackground(new java.awt.Color(255, 153, 153));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton);
        backButton.setBounds(100, 490, 72, 32);

        eventBox.setBackground(new java.awt.Color(255, 153, 153));
        eventBox.setForeground(new java.awt.Color(204, 204, 255));
        eventBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventBoxActionPerformed(evt);
            }
        });
        jPanel1.add(eventBox);
        eventBox.setBounds(240, 190, 398, 51);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\OneDrive\\Documents\\NetBeansProjects\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\sunLiveEvent.png")); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(330, 310, 170, 160);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\OneDrive\\Documents\\NetBeansProjects\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back1.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(900, 600));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 900, 570);

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\OneDrive\\Documents\\NetBeansProjects\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\sunLiveEvent.png")); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(350, 310, 190, 150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        String eventTitle = (String) eventBox.getSelectedItem();

        if (eventTitle == null || eventTitle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a event title before booking the event", "Reminder", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Check if the selected quiz title is valid
            if (isEventValid(eventTitle) && !checkClashingOrRepeatedEvent(eventTitle, takeEventDate(eventTitle))) {
                addPoints(5);
                insertBookingEvent(eventTitle, takeEventDate(eventTitle));
                JOptionPane.showMessageDialog(null, "Event successfully booked. You have earned 2 marks", "Marks Earned", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } 
        }
       
    }//GEN-LAST:event_doneButtonActionPerformed

    private void addPoints(int pointsToAdd) {
        System.out.println(pointsToAdd);

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

    private boolean isEventValid(String userInput) {
        boolean eventValid = false;
        try {
            // Establish connection to the database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // SQL query to retrieve events from the database
            String query = "SELECT * FROM `event` WHERE `event title` = ?"; // Adjust query according to your database schema

            // Create a prepared statement for the query
            pst = con.prepareStatement(query);

            // Set the event title parameter
            pst.setString(1, userInput);

            // Execute the query and obtain the result set
            ResultSet resultSet = pst.executeQuery();

            // Iterate through the result set
            while (resultSet.next()) {
                // Get the event name from the result set
                String eventName = resultSet.getString("event title");

                // Compare the user input with the event name
                if (userInput.equalsIgnoreCase(eventName)) {
                    // If there's a match, set eventValid to true and break the loop
                    eventValid = true;
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
        return eventValid;
    }

    private String takeEventDate(String eventName) {
        String eventDate = null; // Initialize eventDate variable

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String queryChildren = "SELECT * FROM `event` WHERE `event title` = ?";
            pst = con.prepareStatement(queryChildren);
            pst.setString(1, eventName); // Set the eventName parameter

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                eventDate = rs.getString("event date");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query for children: " + e.getMessage());
        }

        return eventDate;
    }

//    private String writeBookingInfo(String eventName) {
//        try {
//            // Retrieve the event date using takeEventDate method
//            String eventDate = takeEventDate(eventName);
//            if (eventDate != null) { // Check if eventDate is not null
//                checkClashingOrRepeatedEvent(eventName, eventDate);
//            } else {
//                JOptionPane.showMessageDialog(null, "Event date not found for event: " + eventName);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }

    private boolean checkClashingOrRepeatedEvent(String eventName, String eventDate) {
        boolean clashedOrRepeated = false;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            String queryChildren = "SELECT * FROM `bookingevent` WHERE `username` = ?";
            pst = con.prepareStatement(queryChildren);
            pst.setString(1, username); // Set the username parameter at index 1

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String existingEventName = rs.getString("eventName");
                String existingEventDate = rs.getString("eventDate");

                if (eventName.equals(existingEventName)) {
                    JOptionPane.showMessageDialog(null, eventName + " already registered!");
                    clashedOrRepeated = true;
                } else if (eventDate.equals(existingEventDate)) {
                    JOptionPane.showMessageDialog(null, eventName + " clashed with other event!");
                    clashedOrRepeated = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query for children: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return clashedOrRepeated;
    }

    private void insertBookingEvent(String eventName, String eventDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            String query = "INSERT INTO `bookingevent`(`username`, `eventName`, `eventDate`) VALUES (?,?,?)";

            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, eventName);
            pst.setString(3, eventDate);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed

        SViewEventPage SViewEventPageFrame = new SViewEventPage(getUsername());
        SViewEventPageFrame.setUsername(username);
        SViewEventPageFrame.setVisible(true);
        SViewEventPageFrame.pack();
        SViewEventPageFrame.setLocationRelativeTo(null);

    }//GEN-LAST:event_backButtonActionPerformed

    private void eventBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventBoxActionPerformed

    private void fetchLiveEvents() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // Query to fetch live events
            String liveEventsQuery = "SELECT `event title` FROM `event` WHERE `event date` = CURDATE()";
            pst = con.prepareStatement(liveEventsQuery);
            ResultSet resultSet = pst.executeQuery();

            // Create an ArrayList to store live events
            List<String> liveEventsList = new ArrayList<>();

            // Add live events to the ArrayList
            while (resultSet.next()) {
                String eventTitle = resultSet.getString("event title");
                liveEventsList.add(eventTitle);
            }

            // Clear existing items in the eventBox before adding new items
            eventBox.removeAllItems();

            // Add live events to the eventBox
            for (String event : liveEventsList) {
                eventBox.addItem(event);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void fetchUpcomingEvents() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // Query to fetch closest upcoming events (limit to 3)
            String upcomingEventsQuery = "SELECT `event title` FROM `event` WHERE `event date` > CURDATE() ORDER BY `event date` LIMIT 3";
            pst = con.prepareStatement(upcomingEventsQuery);
            ResultSet resultSet = pst.executeQuery();

            // Clear existing items in the eventBox before adding new items
            eventBox.removeAllItems();

            // Add each upcoming event to the eventBox
            while (resultSet.next()) {
                String eventTitle = resultSet.getString("event title");
                eventBox.addItem(eventTitle);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void fillCombo() {
        fetchLiveEvents();
        fetchUpcomingEvents();
//        try {
//            // Establish the database connection
//            System.out.println("Attempting database connection...");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
//
//            // Prepare the SQL query to fetch all quiz contents
//            String allEventsQuery = "SELECT `event title` FROM `event`";
//            System.out.println("Executing SQL query: " + allEventsQuery);
//            PreparedStatement pst = con.prepareStatement(allEventsQuery);
//
//            // Execute the query and obtain the result set
//            ResultSet resultSet = pst.executeQuery();
//
//            // Clear existing items in the LinkBox before adding new items
//            eventBox.removeAllItems();
//
//            // Iterate through the result set and add quiz contents to the LinkBox
//            while (resultSet.next()) {
//                String eventTitle = resultSet.getString("event title");
//                System.out.println("Adding quiz content to LinkBox: " + eventTitle);
//                eventBox.addItem(eventTitle); // Add quiz content as an item to the LinkBox
//            }
//
//            // Close the resources
//            con.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.err.println("Error executing SQL query: " + ex.getMessage());
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */                     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(BookEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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

                BookEventPage MakeBookingEventPageFrame = new BookEventPage();
                MakeBookingEventPageFrame.setVisible(true);
                MakeBookingEventPageFrame.pack();
                MakeBookingEventPageFrame.setLocationRelativeTo(null);
                MakeBookingEventPageFrame.takeInformation();
                MakeBookingEventPageFrame.fillCombo();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JComboBox<String> eventBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
