/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.util.stream.Collectors;
import javax.swing.JTextArea;


/**
 *
 * @author Asus
 */
public class ShowDestinationPage extends javax.swing.JFrame {

    String name;
    double x, y;
    Connection con = null;
    PreparedStatement pst = null;

    // Variables for user information
    private String email;
    public String username;
    private String role;
    private String locationCoordinate;
    private String childEventDate;
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyy/MM/dd");

    /**
     * Creates new form EventPage
     */
    // Modify the constructor or setter method to accept username parameter
    public ShowDestinationPage(String username) {
        initComponents();
        setPreferredSize(new Dimension(900, 600));
        setResizable(true);
        this.username = username;  // Set the username
        takeInformation(); // Retrieve user information
        displayBookingDestination();// Display booking destinations
    }

    public ShowDestinationPage() {
        initComponents();
        // Ensure TimeSlot JTextPane is properly initialized and configured

    }

    // Setter method to set the username
    public void setUsername(String username) {
        this.username = username;
        takeInformation(); // Retrieve user information
        displayBookingDestination(); // Display booking destinations
    }
    
    public String getUsername(){
        return username;
    }

    public ShowDestinationPage(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    private void takeInformation() {
         User us = new User (username);
        this.email = us.getEmail();
        this.role = us.getRole();
        this.locationCoordinate= us.getLocationCoordinate();
        System.out.println("Location Coordinate: " + locationCoordinate);

        System.out.println("Email: " + email);
        System.out.println(username);
        System.out.println(role);
        System.out.println(locationCoordinate);
    }

    public void displayBookingDestination() {
        List<ShowDestinationPage> destinations = readBookingDestination();

        String[] coordinates = locationCoordinate.replace('(', ',').replace(')', ',').split(",");
        double userX = Double.parseDouble(coordinates[1]);
        double userY = Double.parseDouble(coordinates[2]);
        System.out.println(userX + "," + userY);

        destinations.sort((d1, d2) -> Double.compare(calculateEuclideanDistance(userX, userY, d1.x, d1.y),
                calculateEuclideanDistance(userX, userY, d2.x, d2.y)));

        StringBuilder display = new StringBuilder("Booking Page\n=============================================================================");
        for (int i = 0; i < destinations.size(); i++) {
            ShowDestinationPage destination = destinations.get(i);
            double distance = calculateEuclideanDistance(userX, userY, destination.x, destination.y);
            String formattedDistance = String.format("%.2f", distance);
            display.append("\n[").append(i + 1).append("] ").append(destination.name);
            display.append("\n").append(formattedDistance).append(" km away");
            display.append("\n");
        }

        displayDestination.setText(display.toString());

    }

    private static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public List<ShowDestinationPage> readBookingDestination() {
        List<ShowDestinationPage> destinations = new ArrayList<>();
        try {
            Scanner inputStream = new Scanner(new FileInputStream("BookingDestination.txt"));
            while (inputStream.hasNextLine()) {
                String name = inputStream.nextLine().trim();
                if (!inputStream.hasNextLine()) {
                    break;
                }
                String[] coordinates = inputStream.nextLine().split(",");
                if (coordinates.length >= 2) {
                    double x = Double.parseDouble(coordinates[0].trim());
                    double y = Double.parseDouble(coordinates[1].trim());
                    destinations.add(new ShowDestinationPage(name, x, y));
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinations;
    }

    private List<String> getChildEventDates(String childName) {
        List<String> eventDates = new ArrayList<>();

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String queryChildren = "SELECT * FROM `bookingevent` WHERE `username` = ?";
            pst = con.prepareStatement(queryChildren);
            pst.setString(1, childName); // Set the childName parameter

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String eventDate = rs.getString("eventDate");
                eventDates.add(eventDate);
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query for children: " + e.getMessage());
        }

        return eventDates;
    }

    // Method to calculate the next 7 days from the current date
    private List<LocalDate> getNext7Days() {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            dates.add(currentDate.plusDays(i));
        }
        return dates;
    }

    public void displayAvailableTimeSlots(List<String> childEventDates) {
        List<LocalDate> availableDates = getNext7Days();

        // Convert child event dates to LocalDate objects
        List<LocalDate> childDates = childEventDates.stream()
                .map(date -> LocalDate.parse(date, dateFormatter))
                .collect(Collectors.toList());

        // Remove all occurrences of the child's event dates from the list of available dates
        availableDates.removeAll(childDates);

        StringBuilder availableSlots = new StringBuilder();
        for (int i = 0; i < availableDates.size(); i++) {
            availableSlots.append("[").append(i + 1).append("] ").append(availableDates.get(i).format(dateFormatter)).append("\n");
        }

        // Display available time slots in the chooseTimeSlot JTextArea
        chooseTimeSlot.setText(availableSlots.toString());
    }

    // Method to insert booking destination if no clashes
    private void insertBookingDestination(String parentName, String childName, String destination, String visitDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");

            String query = "INSERT INTO `bookingdestination`(`parentName`, `childName`, `destination`,`visitDate`) VALUES (?,?,?,?)";

            pst = con.prepareStatement(query);
            pst.setString(1, parentName);
            pst.setString(2, childName);
            pst.setString(3, destination);
            pst.setString(4, visitDate);
            pst.executeUpdate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

    private boolean checkForClashes(String destination, String visitDate, List<String> childEventDates) {
        boolean clashesFound = false;

        //Iterate over each child event date
        for (String childEventDate : childEventDates) {
            if (childEventDate.equals(visitDate)) {
                JOptionPane.showMessageDialog(null, visitDate + " already booked");
                clashesFound = true;
                break;
            }
        }

        return clashesFound;
    }

    // Method to handle booking insertion process
    public void handleBooking(String parentName, String childName, String destination, String visitDate) {
        List<String> childEventDates = getChildEventDates(childName);
        displayAvailableTimeSlots(childEventDates);

        // Check for repeated destinations or clashes
        if (!checkForClashes(destination, visitDate, childEventDates)) {
            // If no clashes, insert booking destination
            insertBookingDestination(parentName, childName, destination, visitDate);
        } else {
            // Handle clashes or repeated destinations
            System.out.println("Clashes found or destination already registered.");
        }
    }
    
    private boolean bookingExists(String childName, String visitDate) {
        String query = "SELECT COUNT(*) FROM bookingdestination WHERE childName = ? AND visitDate = ?";

        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");  PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, childName);
            preparedStatement.setString(2, visitDate);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // If count > 0, booking exists; otherwise, it doesn't
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean isValidDateFormat(String date) {
        String regex = "\\d{4}/\\d{2}/\\d{2}";

        if (!date.matches(regex)) {
            return false; // Return false if the format doesn't match
        }
        return true;
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
        bookButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        displayDestination = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        DestinationID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DestinationName = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        childUsername = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        chooseTimeSlot = new javax.swing.JTextArea();
        visitDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Booking Page");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("========================================================================================================");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 60, -1, -1));

        bookButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bookButton.setText("Book");
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });
        jPanel1.add(bookButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(793, 515, -1, -1));

        displayDestination.setColumns(20);
        displayDestination.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        displayDestination.setRows(5);
        jScrollPane5.setViewportView(displayDestination);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 90, 318, 396));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Child username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 96, 241, 35));

        DestinationID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DestinationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationIDActionPerformed(evt);
            }
        });
        jPanel1.add(DestinationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 149, 136, 45));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Selected booking for                ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 212, 218, 51));

        DestinationName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(DestinationName);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 239, 43));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Available time slots             ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 281, 204, 34));

        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 22, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Enter the time slot");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 437, 226, 48));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Enter destination ID for booking ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 155, 241, 35));

        childUsername.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        childUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                childUsernameActionPerformed(evt);
            }
        });
        jPanel1.add(childUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 86, 136, 45));

        chooseTimeSlot.setColumns(20);
        chooseTimeSlot.setRows(5);
        jScrollPane2.setViewportView(chooseTimeSlot);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 281, 239, 138));

        visitDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitDateActionPerformed(evt);
            }
        });
        jPanel1.add(visitDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 438, 239, 48));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\kekyi\\Downloads\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back1.jpg")); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        JTextArea textArea = chooseTimeSlot;

        String enteredDate = visitDate.getText().trim();

        if (!isValidDateFormat(enteredDate)) {
            JOptionPane.showMessageDialog(this, "Please enter the date in the format yyyy/mm/dd.", "Date Format Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if the format is incorrect
        }

        // Split the text area content by newline to get individual dates
        String[] availableDates = textArea.getText().split("\\n");

        // Check if the entered date is in the list of available dates
        boolean dateFound = false;
        for (String date : availableDates) {
            // Extract the date part without the "[n] " prefix
            String trimmedDate = date.substring(date.indexOf(" ") + 1);

            if (trimmedDate.equals(enteredDate)) {
              dateFound = true;
                break;
            }
        }

        if (!dateFound) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date shown in available time slots.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        // If the format is correct and the date is valid, proceed to check for existing booking
        String childName = childUsername.getText();
        String destination = DestinationName.getText();
        String selectedVisitDate = visitDate.getText();

        // Check if a booking already exists for the child on the selected visit date
        if (bookingExists(childName, selectedVisitDate)) {
            JOptionPane.showMessageDialog(this, "A booking already exists for this child on the selected visit date.", "Booking Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // If no booking exists and the date is valid, proceed with the booking
        try {
          
            insertBookingDestination(username, childName, destination, selectedVisitDate);
            JOptionPane.showMessageDialog(this, "You have successfully booked the visit", "Booking Successful", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Booking successful.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to book the visit. Please try again later.", "Booking Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Booking failed: " + ex.getMessage());
        }
        
        this.dispose();
    
    }//GEN-LAST:event_bookButtonActionPerformed

    private void DestinationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationIDActionPerformed
        // Get the entered destination ID from the text field
        int destinationID = Integer.parseInt(DestinationID.getText());

        // Retrieve the destinations displayed in the displayDestination area
        String[] lines = displayDestination.getText().split("\n");

        // Initialize destination name as "Invalid Destination ID"
        String destinationName = "Invalid Destination ID";

        // Iterate through each line to find the matching destination ID
        for (String line : lines) {
            if (line.startsWith("[" + destinationID + "]")) {
                // Extract the destination name from the line
                destinationName = line.substring(line.indexOf("]") + 2);
                break;
            }
        }

        // Display the retrieved destination name in the DestinationName plane
        DestinationName.setText(destinationName.trim());
//        storeDestinationInDatabase(destinationName);

    }//GEN-LAST:event_DestinationIDActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        MainPageParent MainPageParentsFrame = new MainPageParent(getUsername());
        MainPageParentsFrame.setVisible(true);
        MainPageParentsFrame.pack();
        MainPageParentsFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_backButtonActionPerformed

    private void childUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_childUsernameActionPerformed
        // Get the child's username from the text field
        String childName = childUsername.getText();

        // Retrieve all event dates for the child
        List<String> childEventDates = getChildEventDates(childName);

        // Display the event dates
        if (!childEventDates.isEmpty()) {
            StringBuilder childEventDateDisplay = new StringBuilder("Child Event Dates:\n");
            for (String eventDate : childEventDates) {
                childEventDateDisplay.append(eventDate).append("\n");
            }
            System.out.println(childEventDateDisplay.toString());
        } else {
            System.out.println("No event dates found for the child.");
        }

        // Now you can proceed with displaying available time slots or performing other actions based on the event dates.
        // For example:
        displayAvailableTimeSlots(childEventDates);
    }//GEN-LAST:event_childUsernameActionPerformed

    private void visitDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitDateActionPerformed
        // Get the entered date ID from the text field
        int dateID = Integer.parseInt(visitDate.getText());

        // Retrieve the dates displayed in the displayDestination area
        String[] dates = chooseTimeSlot.getText().split("\n");

        // Initialize selected date as "Invalid Visit Date"
        String selectedDate = "Invalid Visit Date";

        // Iterate through each line to find the matching date ID
        for (String date : dates) {
            // Assuming each date line starts with a date ID in square brackets, e.g., "[1] 2024-05-08"
            if (date.startsWith("[" + dateID + "]")) {
                // Extract the date from the line (excluding the date ID)
                selectedDate = date.substring(date.indexOf("]") + 2);
                break;
            }
        }

        // Display the retrieved date in a separate component (assuming visitDate is a JTextField)
        // Replace visitDate with the appropriate component you want to update
        // For example, if you want to display the selected date in a JTextPane named selectedDatePane:
        // selectedDatePane.setText(selectedDate.trim());
        visitDate.setText(selectedDate.trim());
        //storeDestinationInDatabase(destinationName); // Uncomment if needed
    }//GEN-LAST:event_visitDateActionPerformed

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
            java.util.logging.Logger.getLogger(ShowDestinationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowDestinationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowDestinationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowDestinationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

                ShowDestinationPage showDestinationPage = new ShowDestinationPage();
                showDestinationPage.setVisible(true);
                showDestinationPage.pack();
                showDestinationPage.setLocationRelativeTo(null);
                showDestinationPage.takeInformation(); // Call takeInformation method to retrieve username

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DestinationID;
    private javax.swing.JTextPane DestinationName;
    private javax.swing.JButton backButton;
    private javax.swing.JButton bookButton;
    private javax.swing.JTextField childUsername;
    private javax.swing.JTextArea chooseTimeSlot;
    private javax.swing.JTextArea displayDestination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField visitDate;
    // End of variables declaration//GEN-END:variables
}
