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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Stack;

/**
 *
 * @author Asus
 */
public class SViewEventPage extends javax.swing.JFrame {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private Stack<Class<?>> navigationHistory;
    public String username;
    private String email;
    private String role;
    private String locationCoordinate;
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
        takeInformation(); // Retrieve user information
    }
    
    public SViewEventPage() {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);

        fetchLiveEvents();
        fetchUpcomingEvents();

    }
    public SViewEventPage(String username) {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;  // Set the username
        takeInformation(); // Retrieve user information
        fetchLiveEvents();
        fetchUpcomingEvents();
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
     * Creates new form EventPage
     */
    
    public SViewEventPage(Stack<Class<?>> navigationHistory) {
        initComponents();
        this.navigationHistory = navigationHistory;
    }

// Method to fetch live events from the database
    private void fetchLiveEvents() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // Query to fetch live events
            String liveEventsQuery = "SELECT * FROM `event` WHERE `event date` = CURDATE()";
            pst = con.prepareStatement(liveEventsQuery);
            ResultSet resultSet = pst.executeQuery();

            // Display live events in text area
            displayLiveEvents(liveEventTextArea, resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            closeResources();
        }
    }

// Method to fetch upcoming events from the database
    private void fetchUpcomingEvents() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            // Query to fetch closest upcoming events (limit to 3)
            String upcomingEventsQuery = "SELECT * FROM `event` WHERE `event date` > CURDATE() ORDER BY `event date` LIMIT 3";
            pst = con.prepareStatement(upcomingEventsQuery);
            ResultSet resultSet = pst.executeQuery();

            // Display upcoming events in text area
            displayUpcomingEvents(upcomingEventsTextArea, resultSet);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            closeResources();
        }
    }

// Method to close database resources
    private void closeResources() {
        try {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayLiveEvents(javax.swing.JTextArea liveEventTextArea, ResultSet resultSet) throws SQLException {
        StringBuilder liveEventsBuilder = new StringBuilder();

        LocalDate currentDate = LocalDate.now(); // Get current date

        while (resultSet.next()) {
            String eventTitle = resultSet.getString("event title");
            String eventDescription = resultSet.getString("event description");
            String eventVenue = resultSet.getString("event venue");

            String eventDateStr = resultSet.getString("event date");
            String eventStartTimeStr = resultSet.getString("event start time");
            String eventEndTimeStr = resultSet.getString("event end time");

            // Parse event date string to LocalDate
            LocalDate eventDate = LocalDate.parse(eventDateStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

            // Compare event date with current date
            if (eventDate.equals(currentDate)) {
                // Customize the display format as needed
                liveEventsBuilder.append("Event: ").append(eventTitle).append("\n")
                        .append("Venue: ").append(eventVenue).append("\n")
                        .append("Description: ").append(eventDescription).append("\n")
                        .append("Date: ").append(eventDateStr).append("\n")
                        .append("Start time: ").append(eventStartTimeStr).append("\n")
                        .append("End time: ").append(eventEndTimeStr).append("\n\n");
            }
        }

        liveEventTextArea.setText(liveEventsBuilder.toString());
        liveEventTextArea.setEditable(false);
    }

    private void displayUpcomingEvents(javax.swing.JTextArea liveEventTextArea, ResultSet resultSet) throws SQLException {
        StringBuilder liveEventsBuilder = new StringBuilder();

        LocalDate currentDate = LocalDate.now(); // Get current date
        
        int count = 0;

        while (resultSet.next() & count < 3) {
            String eventTitle = resultSet.getString("event title");
            String eventDescription = resultSet.getString("event description");
            String eventVenue = resultSet.getString("event venue");

            String eventDateStr = resultSet.getString("event date");
            String eventStartTimeStr = resultSet.getString("event start time");
            String eventEndTimeStr = resultSet.getString("event end time");

            // Parse event date string to LocalDate
            LocalDate eventDate = LocalDate.parse(eventDateStr, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

            // Compare event date with current date
            if (eventDate.isAfter(currentDate)) {
                // Customize the display format as needed
                liveEventsBuilder.append("Event: ").append(eventTitle).append("\n")
                        .append("Venue: ").append(eventVenue).append("\n")
                        .append("Description: ").append(eventDescription).append("\n")
                        .append("Date: ").append(eventDateStr).append("\n")
                        .append("Start time: ").append(eventStartTimeStr).append("\n")
                        .append("End time: ").append(eventEndTimeStr).append("\n\n");
                count++;
            }
        }

        liveEventTextArea.setText(liveEventsBuilder.toString());
        liveEventTextArea.setEditable(false);
    }

//    private void fetchEvents() {
//    try {
//        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
//
//        // Query to fetch events
//        String query = "SELECT * FROM `event`";
//        pst = con.prepareStatement(query);
//        ResultSet resultSet = pst.executeQuery();
//
//        // Display events in text area
//        displayEventsInTextArea(liveEventTextArea, resultSet);
//
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//        
//    } finally {
//        try {
//            if (pst != null) {
//                pst.close();
//            }
//            if (con != null) {
//                con.close();
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
//// Method to display events in a text area
//private void displayEventsInTextArea(javax.swing.JTextArea textArea, ResultSet resultSet) throws SQLException {
//    StringBuilder eventsBuilder = new StringBuilder();
//    while (resultSet.next()) {
//        // Customize how you want to display each event
//        String eventTitle = resultSet.getString("event title");
//        String eventDescription = resultSet.getString("event description");
//        String eventVenue = resultSet.getString("event venue");
//        String eventDate = resultSet.getString("event date");
//        String eventTime = resultSet.getString("event time");
//        eventsBuilder.append(eventTitle).append(" - ").append(eventDate).append(" ").append(eventTime).append("\n")
//                     .append("Venue: ").append(eventVenue).append("\n")
//                     .append("Description: ").append(eventDescription).append("\n\n");
//    }
//    liveEventTextArea.setText(eventsBuilder.toString());
//    liveEventTextArea.setEditable(false);
//}
//   
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        makeBooking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        liveEventTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        upcomingEventsTextArea = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("View");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 181, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 550));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Live Events:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Closest 3 Upcoming Events:");

        makeBooking.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        makeBooking.setForeground(new java.awt.Color(255, 153, 153));
        makeBooking.setText("MakeBooking");
        makeBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeBookingActionPerformed(evt);
            }
        });

        liveEventTextArea.setColumns(20);
        liveEventTextArea.setRows(5);
        jScrollPane1.setViewportView(liveEventTextArea);

        upcomingEventsTextArea.setColumns(20);
        upcomingEventsTextArea.setRows(5);
        jScrollPane3.setViewportView(upcomingEventsTextArea);

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(makeBooking))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton)))
                        .addGap(29, 29, 29))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makeBooking)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, 561));

        jLabel2.setFont(new java.awt.Font("Ink Free", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Event");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 245, 149, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Asus\\OneDrive\\Documents\\NetBeansProjects\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back2.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 560));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeBookingActionPerformed
        BookEventPage MakeBookingEventPageFrame = new BookEventPage(getUsername());
        MakeBookingEventPageFrame.setVisible(true);
        MakeBookingEventPageFrame.pack();
        MakeBookingEventPageFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_makeBookingActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        MainPageChildren childrenFrame = new MainPageChildren();
        childrenFrame.setUsername(username);
        childrenFrame.setVisible(true);
        childrenFrame.pack();
        childrenFrame.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(SViewEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SViewEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SViewEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SViewEventPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

                SViewEventPage ViewEventPageFrame = new SViewEventPage();
                ViewEventPageFrame.setVisible(true);
                ViewEventPageFrame.pack();
                ViewEventPageFrame.setLocationRelativeTo(null);
                ViewEventPageFrame.takeInformation(); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea liveEventTextArea;
    private javax.swing.JButton makeBooking;
    private javax.swing.JTextArea upcomingEventsTextArea;
    // End of variables declaration//GEN-END:variables
}
