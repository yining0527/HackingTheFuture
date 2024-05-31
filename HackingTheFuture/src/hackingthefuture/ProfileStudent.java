/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hackingthefuture;

/**
 *
 * @author yingying
 */

import java.awt.Dimension;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.BorderLayout;
import java.util.ArrayList;


public class ProfileStudent extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    
    // Variables for user information
    private String email;
    private String currentUsername;
    private String profileUsername;
    private String role;
    private String locationCoordinate;
    private String father;
    private String mother;
    private ArrayList<String> friends;
    private ArrayList<String> friendsLeaderboard = new ArrayList<>();;
    private JDialog requestDialog;
    private String userRole;
    
    private int points;

    /**
     * Creates new form ProfileStudent
     */
    public ProfileStudent() {
        initComponents();
        setPreferredSize(new Dimension(900,600));
        setResizable(true);
        this.currentUsername = currentUsername;  // Set the username
    }
    
    public void setUsername(String transferUsername) {
        this.currentUsername = transferUsername;
        takeInformation();
        takeParents();
        takeFriends();
//        fetchUserRole();
//        checkFriendshipAndDisplayButton();
    }
    
    public void setLeaderboardUsername(String profileUsername)
    {
        this.profileUsername = profileUsername;
        takeInformationLeaderboard();
        takeParentsLeaderboard();
        takeFriendsLeaderboard();
        fetchUserRole();
        checkFriendshipAndDisplayButton();
    }
    
    private void takeInformation() {
         User us = new User (currentUsername);
        this.email = us.getEmail();
        this.role = us.getRole();
        this.locationCoordinate= us.getLocationCoordinate();
        this.points=us.getCurrentPoints();

        System.out.println("Email: " + email);
        System.out.println(currentUsername);
        System.out.println(role);
        System.out.println(locationCoordinate);
        System.out.println(points);

        jLabelShowEMAIL.setText(email);
        jLabelShowUSERNAME.setText(currentUsername);
        jLabelShowROLE.setText(role);
        jLabelShowLOCATIONCOORDINATE.setText(locationCoordinate);
        jLabelShowPOINTS.setText(String.valueOf(points));
    }
    
    private void takeParents()
    {
        System.out.println("take father");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT * FROM `children` WHERE `userID` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, currentUsername); // Set the username parameter at index 1

            System.out.println("SQL Query: " + querySD); // Print SQL query for debugging
            System.out.println("Username: " + currentUsername); // Print username for debugging

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ResultSet contains data.");
                this.father = rs.getString("Father");
                this.mother = rs.getString("Mother");
            } else {
                System.out.println("ResultSet is empty.");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        System.out.println("father: " + father);
        System.out.println("mother: " + mother);

        jLabelShowFATHER.setText(father);
        jLabelShowMOTHER.setText(mother);
    }
    
    private void takeFriends() {
        friends = new ArrayList<>();
        StringBuilder friendNames = new StringBuilder();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String queryFriends = "SELECT * FROM `friend_requests` WHERE status = 'accepted'";
            pst = con.prepareStatement(queryFriends);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String friendName = "";
                if (currentUsername.equals(rs.getString("sender_username"))) {
                    friendName = rs.getString("receiver_username");
                } else if (currentUsername.equals(rs.getString("receiver_username"))) {
                    friendName = rs.getString("sender_username");
                }

                if (!friendName.isEmpty()) {
                    friends.add(friendName); // Add friend's username to the ArrayList
                    friendNames.append(friendName).append("\n"); // Append friend's username to the StringBuilder
                }
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query for friends: " + e.getMessage());
        }

        System.out.println("Friends Names: " + friends);

        // Set the text content of jLabelShowFRIENDS to the names with HTML formatting (optional)
        StringBuilder friendDisplay = new StringBuilder("<html>");
        for (String friend : friends) {
            friendDisplay.append(friend).append("<br>"); // Append each friend's username followed by a line break in HTML
        }
        friendDisplay.append("</html>"); // Close the HTML tag
        jLabelShowFRIENDS.setText(friendDisplay.toString()); // Set the text in jLabelShowFRIENDS with HTML formatting
        jLabelShowFRIENDS.setVerticalAlignment(SwingConstants.TOP); // Set vertical alignment to top
        jLabelShowFRIENDS.setHorizontalAlignment(SwingConstants.LEFT); // Optional: Set horizontal alignment to left
        System.out.println("Friends HTML: " + friendDisplay.toString());
    }
    
    private void takeFriendsLeaderboard()
    {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String queryFriends = "SELECT * FROM `friend_requests` WHERE status = 'accepted'";
            pst = con.prepareStatement(queryFriends);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String friendName = "";
                if(profileUsername.equals(rs.getString("sender_username")))
                {
                    friendName = rs.getString("receiver_username");
                }
                else if(profileUsername.equals(rs.getString("receiver_username")))
                {
                    friendName = rs.getString("sender_username");
                }
                
                friendsLeaderboard.add(friendName); // Add child's username to the ArrayList
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query for children: " + e.getMessage());
        }

        System.out.println("Friends Names: " + friends);

        // Display childrenNames using jLabelShowCHILDREN with HTML formatting for new lines
       StringBuilder childrenDisplay = new StringBuilder("<html>");
       for (String child : friendsLeaderboard) {
           childrenDisplay.append(child).append("<br>"); // Append each child's username followed by a line break in HTML
       }
       childrenDisplay.append("</html>"); // Close the HTML tag
       jLabelShowFRIENDS.setText(childrenDisplay.toString()); // Set the text in jLabelShowCHILDREN with HTML formatting
       jLabelShowFRIENDS.setVerticalAlignment(SwingConstants.TOP); // Set vertical alignment to top
        jLabelShowFRIENDS.setHorizontalAlignment(SwingConstants.LEFT); // Optional: Set horizontal alignment to left

    }
    
    private void takeInformationLeaderboard() {
        System.out.println("take information");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT * FROM `user` WHERE `username` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, profileUsername); // Set the username parameter at index 1

            System.out.println("SQL Query: " + querySD); // Print SQL query for debugging
            System.out.println("Username: " + profileUsername); // Print username for debugging

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ResultSet contains data.");
                this.email = rs.getString("email");
                this.role = rs.getString("role");
                this.locationCoordinate = rs.getString("LocationCoordinate");
                this.points = rs.getInt("points");
            } else {
                System.out.println("ResultSet is empty.");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        System.out.println("Email: " + email);
        System.out.println(profileUsername);
        System.out.println(role);
        System.out.println(locationCoordinate);
        System.out.println(points);

        jLabelShowEMAIL.setText(email);
        jLabelShowUSERNAME.setText(profileUsername);
        jLabelShowROLE.setText(role);
        jLabelShowLOCATIONCOORDINATE.setText(locationCoordinate);
        jLabelShowPOINTS.setText(String.valueOf(points));
    }
    
    private void takeParentsLeaderboard()
    {
        System.out.println("take father");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT * FROM `children` WHERE `userID` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, profileUsername); // Set the username parameter at index 1

            System.out.println("SQL Query: " + querySD); // Print SQL query for debugging
            System.out.println("Username: " + profileUsername); // Print username for debugging

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("ResultSet contains data.");
                this.father = rs.getString("Father");
                this.mother = rs.getString("Mother");
            } else {
                System.out.println("ResultSet is empty.");
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }

        System.out.println("father: " + father);
        System.out.println("mother: " + mother);

        jLabelShowFATHER.setText(father);
        jLabelShowMOTHER.setText(mother);
    }
    private void fetchUserRole() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
            System.out.println("Database connection successful.");

            String querySD = "SELECT * FROM `user` WHERE `username` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, currentUsername);
            System.out.println("hello");
            System.out.println("Fetching user details for username: " + currentUsername);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                this.userRole = rs.getString("role");
                System.out.println("Role: " + userRole);
            }

            pst.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query for friends: " + e.getMessage());
        }
        
    }
    
    private void checkFriendshipAndDisplayButton() {
        System.out.println("HHHHH user role: " + userRole);
        if (areAlreadyFriendsOrRequested(currentUsername, profileUsername) || currentUsername.equals(profileUsername) || !userRole.equals("children")) {
            jButtonSendFriendRequest.setVisible(false);  // Hide the button if they are already friends or the same user
        } else {
            jButtonSendFriendRequest.setVisible(true);   // Show the button otherwise
        }
    }
    
    private boolean areAlreadyFriendsOrRequested(String currentUser, String profileUser) {
    boolean status = false;
    // Update the SQL query to select the same number of columns in both parts of the UNION
    String sql = "SELECT 1 FROM friends WHERE (user1_username = ? AND user2_username = ?) OR (user1_username = ? AND user2_username = ?) " +
                 "UNION " +
                 "SELECT 1 FROM friend_requests WHERE ((sender_username = ? AND receiver_username = ?) OR (sender_username = ? AND receiver_username = ?)) AND status = 'accepted'";
    
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
         PreparedStatement pst = con.prepareStatement(sql)) {
        
        pst.setString(1, currentUser);
        pst.setString(2, profileUser);
        pst.setString(3, profileUser);
        pst.setString(4, currentUser);
        pst.setString(5, currentUser);
        pst.setString(6, profileUser);
        pst.setString(7, profileUser);
        pst.setString(8, currentUser);
        
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            status = true;  // There is either an existing friendship or an accepted friend request
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return status;
}


    
    public void sendFriendRequest() {
    String query = "INSERT INTO friend_requests (sender_username, receiver_username, request_date, status) VALUES (?, ?, CURRENT_TIMESTAMP, 'pending')";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
         PreparedStatement pst = con.prepareStatement(query)) {
        pst.setString(1, currentUsername);
        pst.setString(2, profileUsername);
        int result = pst.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(null, "Friend request sent successfully!");
            updateFriendshipStatusLabel(currentUsername, profileUsername);
        } else {
            JOptionPane.showMessageDialog(null, "Failed to send friend request.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error sending friend request: " + ex.getMessage());
        ex.printStackTrace();
    }
    
}


    // Method to set username and manage visibility of the send request button
    public void setUsernameAndButtonVisibility(String username, boolean showButton) {
        this.currentUsername = username;
        jButtonSendFriendRequest.setVisible(showButton);
        
    }
    
    public void setSendFriendRequestNotVisible() {
        if (jButtonSendFriendRequest != null) {
            System.out.println("Setting Send Friend Request Button visibility to false.");
            jButtonSendFriendRequest.setVisible(false);
        } else {
            System.out.println("Send Friend Request Button is null.");
        }
    }

    
    public void setInboxVisibility(String username, boolean showButton) {
        this.currentUsername = username;
        jButtonInbox.setVisible(showButton);
    }
    
    public void setFriendshipStatusVisibility(String username, boolean showButton)
    {
        this.currentUsername = username;
        jLabelShowFriendshipStatus.setVisible(!showButton);
    }
    
    private void displayFriendRequests() {
    requestDialog = new JDialog(this, "Friend Requests", true);
    requestDialog.setLayout(new BorderLayout());

    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);
    JScrollPane scrollPane = new JScrollPane(list);
    requestDialog.add(scrollPane, BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel();
    JButton acceptButton = new JButton("Accept");
    JButton rejectButton = new JButton("Reject");
    buttonPanel.add(acceptButton);
    buttonPanel.add(rejectButton);
    requestDialog.add(buttonPanel, BorderLayout.SOUTH);

    // Add button actions
    acceptButton.addActionListener(e -> acceptFriendRequest(list.getSelectedValue(), requestDialog));
    rejectButton.addActionListener(e -> rejectFriendRequest(list.getSelectedValue(), requestDialog));

    loadFriendRequests(model);  // Load friend requests into the list model

    requestDialog.setSize(300, 400);
    requestDialog.setLocationRelativeTo(this);
    requestDialog.setVisible(true);
}
    
    private void loadFriendRequests(DefaultListModel<String> model) {
        System.out.println("load friend request");
    String query = "SELECT * FROM friend_requests WHERE receiver_username = ? AND status = 'pending'";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
         PreparedStatement pst = con.prepareStatement(query)) {
        pst.setString(1, currentUsername);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String entry = rs.getString("sender_username") + " (ID: " + rs.getInt("request_id") + ")";
            model.addElement(entry);
            System.out.println("Added to model: " + entry);  // Debug output
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
    
    private void acceptFriendRequest(String requestDetail, JDialog dialog) {
    System.out.println("acceptFriendRequest called with: " + requestDetail);
    if (requestDetail != null && !requestDetail.isEmpty()) {
        try {
            String requestId = requestDetail.split("ID: ")[1].replace(")", "").trim();
            System.out.println("Parsed request ID: " + requestId);

            String queryUpdateRequest = "UPDATE friend_requests SET status = 'accepted' WHERE request_id = ?";
            String queryInsertFriend = "INSERT INTO friends (user1_username, user2_username, friendship_date) SELECT sender_username, receiver_username, CURRENT_TIMESTAMP FROM friend_requests WHERE request_id = ?";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
                 PreparedStatement pstUpdate = con.prepareStatement(queryUpdateRequest);
                 PreparedStatement pstInsert = con.prepareStatement(queryInsertFriend)) {
                
                // First, update the friend request status
                pstUpdate.setInt(1, Integer.parseInt(requestId));
                int resultUpdate = pstUpdate.executeUpdate();
                if (resultUpdate > 0) {
                    // Then, insert the new friend record
                    pstInsert.setInt(1, Integer.parseInt(requestId));
                    int resultInsert = pstInsert.executeUpdate();
                    if (resultInsert > 0) {
                        JOptionPane.showMessageDialog(dialog, "Friend request accepted and friendship recorded.");
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Friend request accepted but failed to record friendship.");
                    }
                } else {
                    JOptionPane.showMessageDialog(dialog, "No records updated for friend request.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid request ID format: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(dialog, "SQL Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "Error processing request: " + ex.getMessage());
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(dialog, "No request detail provided.");
    }
    requestDialog.setVisible(false);
    displayFriendRequests();
    takeFriends();
}



private void rejectFriendRequest(String requestDetail, JDialog dialog) {
    System.out.println("rejectFriendRequest called with: " + requestDetail);
    if (requestDetail != null && !requestDetail.isEmpty()) {
        try {
            String requestId = requestDetail.split("ID: ")[1].replace(")", "").trim();
            System.out.println("Parsed request ID: " + requestId);

            String query = "UPDATE friend_requests SET status = 'rejected' WHERE request_id = ?";

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
                 PreparedStatement pst = con.prepareStatement(query)) {
                pst.setInt(1, Integer.parseInt(requestId));
                int result = pst.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(dialog, "Friend request rejected.");
                } else {
                    JOptionPane.showMessageDialog(dialog, "No records updated. Request might already be processed.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(dialog, "Invalid request ID format: " + ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(dialog, "SQL Error: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(dialog, "Error processing request: " + ex.getMessage());
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(dialog, "No request detail provided.");
    }
    requestDialog.setVisible(false);
    displayFriendRequests();
    takeFriends();
}

public void updateFriendshipStatusLabel(String currentUser, String profileUser) {
    String query = "SELECT sender_username, receiver_username, status FROM friend_requests WHERE (sender_username = ? AND receiver_username = ?) OR (sender_username = ? AND receiver_username = ?)";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
         PreparedStatement pst = con.prepareStatement(query)) {
        pst.setString(1, currentUser);
        pst.setString(2, profileUser);
        pst.setString(3, profileUser);
        pst.setString(4, currentUser);

        ResultSet rs = pst.executeQuery();
        boolean foundRequest = false;

        while (rs.next()) {
            String senderUsername = rs.getString("sender_username");
            String receiverUsername = rs.getString("receiver_username");
            String status = rs.getString("status");

            if ("accepted".equals(status)) {
                if (currentUser.equals(senderUsername)) {
                    jLabelShowFriendshipStatus.setText("You and " + receiverUsername + " are now friends.");
                } else {
                    jLabelShowFriendshipStatus.setText("You and " + senderUsername + " are now friends.");
                }
                foundRequest = true;
                break;  // Once we find an accepted request, we can stop checking
            } else if ("rejected".equals(status)) {
                if (currentUser.equals(senderUsername)) {
                    jLabelShowFriendshipStatus.setText(receiverUsername + " has rejected your friend request.");
                } else {
                    jLabelShowFriendshipStatus.setText("You have rejected the friend request from " + senderUsername + ".");
                }
                foundRequest = true;
            } else if ("pending".equals(status)) {
                if (currentUser.equals(senderUsername)) {
                    jLabelShowFriendshipStatus.setText("Your friend request to " + receiverUsername + " is pending.");
                    jButtonSendFriendRequest.setVisible(false);
                } else {
                    jLabelShowFriendshipStatus.setText(senderUsername + " has sent you a friend request.");
                }
                foundRequest = true;
            }
        }

        if (!foundRequest) {
            jLabelShowFriendshipStatus.setVisible(false);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        ex.printStackTrace();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelEMAIL = new javax.swing.JLabel();
        jLabelUSERNAME = new javax.swing.JLabel();
        jLabelROLE = new javax.swing.JLabel();
        jLabelLOCATIONCOORDINATE = new javax.swing.JLabel();
        jLabelFATHER = new javax.swing.JLabel();
        jLabelShowUSERNAME = new javax.swing.JLabel();
        jLabelShowEMAIL = new javax.swing.JLabel();
        jLabelShowROLE = new javax.swing.JLabel();
        jLabelShowLOCATIONCOORDINATE = new javax.swing.JLabel();
        jLabelShowMOTHER = new javax.swing.JLabel();
        jLabelMOTHER = new javax.swing.JLabel();
        jLabelShowFATHER = new javax.swing.JLabel();
        jLabelPOINTS = new javax.swing.JLabel();
        jLabelShowPOINTS = new javax.swing.JLabel();
        jLabelPOINTS1 = new javax.swing.JLabel();
        jButtonSendFriendRequest = new javax.swing.JButton();
        jButtonInbox = new javax.swing.JButton();
        jLabelShowFriendshipStatus = new javax.swing.JLabel();
        jScrollPaneShowFRIENDS = new javax.swing.JScrollPane();
        jLabelShowFRIENDS = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("User");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(650, 550));

        jLabelEMAIL.setBackground(new java.awt.Color(102, 102, 102));
        jLabelEMAIL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelEMAIL.setForeground(new java.awt.Color(255, 153, 153));
        jLabelEMAIL.setText("Email");

        jLabelUSERNAME.setBackground(new java.awt.Color(102, 102, 102));
        jLabelUSERNAME.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUSERNAME.setForeground(new java.awt.Color(255, 153, 153));
        jLabelUSERNAME.setText("Username");

        jLabelROLE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelROLE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelROLE.setForeground(new java.awt.Color(255, 153, 153));
        jLabelROLE.setText("Role");

        jLabelLOCATIONCOORDINATE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelLOCATIONCOORDINATE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelLOCATIONCOORDINATE.setForeground(new java.awt.Color(255, 153, 153));
        jLabelLOCATIONCOORDINATE.setText("Location Coordinate");

        jLabelFATHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelFATHER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFATHER.setForeground(new java.awt.Color(255, 153, 153));
        jLabelFATHER.setText("Father");

        jLabelShowUSERNAME.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowUSERNAME.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowUSERNAME.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowEMAIL.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowEMAIL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowEMAIL.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowROLE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowROLE.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowROLE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowLOCATIONCOORDINATE.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowLOCATIONCOORDINATE.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowLOCATIONCOORDINATE.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelShowMOTHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowMOTHER.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowMOTHER.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelMOTHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelMOTHER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMOTHER.setForeground(new java.awt.Color(255, 153, 153));
        jLabelMOTHER.setText("Mother");

        jLabelShowFATHER.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowFATHER.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowFATHER.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPOINTS.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPOINTS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPOINTS.setForeground(new java.awt.Color(255, 153, 153));
        jLabelPOINTS.setText("Points");

        jLabelShowPOINTS.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowPOINTS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowPOINTS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPOINTS1.setBackground(new java.awt.Color(102, 102, 102));
        jLabelPOINTS1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelPOINTS1.setForeground(new java.awt.Color(255, 153, 153));
        jLabelPOINTS1.setText("Friend(s)");

        jButtonSendFriendRequest.setBackground(new java.awt.Color(255, 153, 153));
        jButtonSendFriendRequest.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSendFriendRequest.setText("Send Friend Request");
        jButtonSendFriendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendFriendRequestActionPerformed(evt);
            }
        });

        jButtonInbox.setBackground(new java.awt.Color(255, 153, 153));
        jButtonInbox.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonInbox.setText("Inbox");
        jButtonInbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInboxActionPerformed(evt);
            }
        });

        jLabelShowFriendshipStatus.setBackground(new java.awt.Color(102, 102, 102));
        jLabelShowFriendshipStatus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabelShowFriendshipStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPaneShowFRIENDS.setBackground(new java.awt.Color(255, 255, 255));

        jLabelShowFRIENDS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jScrollPaneShowFRIENDS.setViewportView(jLabelShowFRIENDS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPOINTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowROLE, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowMOTHER, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jLabelShowPOINTS, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(jScrollPaneShowFRIENDS)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap(177, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSendFriendRequest))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInbox)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelShowFriendshipStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelShowFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(176, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSendFriendRequest)
                            .addComponent(jButtonInbox))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelShowFriendshipStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelShowUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelShowEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowROLE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowLOCATIONCOORDINATE, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowFATHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowMOTHER, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelShowPOINTS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPOINTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneShowFRIENDS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 610, 610));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("Account");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 176, -1));

        backButton.setBackground(new java.awt.Color(255, 153, 153));
        backButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\FOP\\Netbeans Project\\HackingTheFuture1\\HackingTheFuture\\HackingTheFuture\\src\\hackingthefuture\\Image\\back3.jpg")); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 300, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jButtonSendFriendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendFriendRequestActionPerformed
        // TODO add your handling code here:
        sendFriendRequest();
    }//GEN-LAST:event_jButtonSendFriendRequestActionPerformed

    private void jButtonInboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInboxActionPerformed
        // TODO add your handling code here:
        displayFriendRequests();
    }//GEN-LAST:event_jButtonInboxActionPerformed
 
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
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProfileStudent ProfileStudentFrame = new ProfileStudent();
                ProfileStudentFrame.pack(); // Pack the frame before displaying it
                ProfileStudentFrame.setVisible(true);
                ProfileStudentFrame.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton jButtonInbox;
    private javax.swing.JButton jButtonSendFriendRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelEMAIL;
    private javax.swing.JLabel jLabelFATHER;
    private javax.swing.JLabel jLabelLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelMOTHER;
    private javax.swing.JLabel jLabelPOINTS;
    private javax.swing.JLabel jLabelPOINTS1;
    private javax.swing.JLabel jLabelROLE;
    private javax.swing.JLabel jLabelShowEMAIL;
    private javax.swing.JLabel jLabelShowFATHER;
    private javax.swing.JLabel jLabelShowFRIENDS;
    private javax.swing.JLabel jLabelShowFriendshipStatus;
    private javax.swing.JLabel jLabelShowLOCATIONCOORDINATE;
    private javax.swing.JLabel jLabelShowMOTHER;
    private javax.swing.JLabel jLabelShowPOINTS;
    private javax.swing.JLabel jLabelShowROLE;
    private javax.swing.JLabel jLabelShowUSERNAME;
    private javax.swing.JLabel jLabelUSERNAME;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPaneShowFRIENDS;
    // End of variables declaration//GEN-END:variables
}
