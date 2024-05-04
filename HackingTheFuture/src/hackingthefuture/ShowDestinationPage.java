/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
        
           
    
    public ShowDestinationPage(){
        initComponents();
    }

    // Setter method to set the username
    public void setUsername(String username) {
        this.username = username;
        takeInformation(); // Retrieve user information
        displayBookingDestination(); // Display booking destinations
    }


    public ShowDestinationPage(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
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
            Scanner inputStream = new Scanner(new FileInputStream("C:/Users/weiqi/OneDrive/Documents/BookingDestination.txt"));
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
    
     


public void displayAvailableTimeSlots(String destinationName, String locationID) {
    JTextArea timeSlotsTextArea = new JTextArea();
    timeSlotsTextArea.setEditable(false);

    // Call the BookingPage class to get available time slots
    BookingPage bookingPage = new BookingPage(destinationName, locationID);
    List<String> availableTimeSlots = bookingPage.getAvailableTimeSlots(destinationName);

    // Display available time slots in the timeSlotsTextArea
    for (String slot : availableTimeSlots) {
        timeSlotsTextArea.append(slot + "\n");
    }
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
        nextButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        displayDestination = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        DestinationID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DestinationName = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TimeSlot = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Booking Page");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("======================================================================================");

        nextButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        displayDestination.setColumns(20);
        displayDestination.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        displayDestination.setRows(5);
        jScrollPane5.setViewportView(displayDestination);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Enter destination ID for booking :");

        DestinationID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        DestinationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationIDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Selected booking for                     : ");

        DestinationName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(DestinationName);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Available Time Slots                      :");

        TimeSlot.setColumns(20);
        TimeSlot.setRows(5);
        jScrollPane2.setViewportView(TimeSlot);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DestinationID, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nextButton)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(358, 358, 358))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DestinationID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(nextButton)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    BookingDestinationPage MakeBookingsPageFrame = new BookingDestinationPage();
        MakeBookingsPageFrame.setVisible(true);
        MakeBookingsPageFrame.pack();
        MakeBookingsPageFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_nextButtonActionPerformed

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

    }//GEN-LAST:event_DestinationIDActionPerformed

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
    private javax.swing.JTextArea TimeSlot;
    private javax.swing.JTextArea displayDestination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton nextButton;
    // End of variables declaration//GEN-END:variables
}
