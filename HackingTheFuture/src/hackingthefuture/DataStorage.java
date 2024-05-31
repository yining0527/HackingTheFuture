/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hackingthefuture;

/**
 *
 * @author yingying
 */

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataStorage {
    Connection con = null;
    PreparedStatement pstUser = null;
    PreparedStatement pstParent = null;
    PreparedStatement pstChildren = null;
    
    private String username;
    private String email;
    private String password;
    private String role;
    private String locationCoordinate;
    private ArrayList<String> childrenName = new ArrayList<>();
    private ArrayList<String> siblingsOrder = new ArrayList<>();
    private String father;
    private String mother;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void setUsername(String transferUsername) {
        this.username = transferUsername;
        StoreData();
    }
    
    public void StoreData() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/hackingthefuture", "root", "");
            System.out.println("Database connection successful");

            String queryUser = "SELECT * FROM `user` WHERE `username` = ?";
            pstUser = con.prepareStatement(queryUser);
            pstUser.setString(1, username);
            ResultSet rsUser = pstUser.executeQuery();
            
            // Create CSV file writer
            FileWriter writer = new FileWriter("DataStorage.csv");

            // Iterate over the result set and write data to CSV file
            while (rsUser.next()) {
                this.email = rsUser.getString("email");
                this.password = rsUser.getString("password");
                this.role = rsUser.getString("role");
                this.locationCoordinate = rsUser.getString("LocationCoordinate");
            }
            
            String[] coordinates = locationCoordinate.split(",");
            String latitude = coordinates[0].substring(1); // Remove the opening parenthesis
            String longitude = coordinates[1].substring(0, coordinates[1].length() - 1); // Remove the closing parenthesis
            
            // Check if role is parent
                if (role.equals("parent")) {
                    System.out.println("Role in parent: " + role);
                    
                    String queryParent = "SELECT * FROM `parent` WHERE `userID` = ?";
                    pstParent = con.prepareStatement(queryParent);
                    pstParent.setString(1, username);
                    ResultSet rsParent = pstParent.executeQuery();
                    
                    // Write CSV header
                    writer.append("email, username, password, role, latitude, longitude, childrenName, siblingsOrder\n");
                    
                    while (rsParent.next()) {
                        String childName = rsParent.getString("Children");
                        childrenName.add(childName);

                        String siblingOrder = rsParent.getString("siblingsOrder");
                        siblingsOrder.add(siblingOrder);

                        
            
                        // Write user data to CSV file
                        writer.append(String.join(",", email, username, password, role, latitude, longitude, childName, siblingOrder));
                        writer.append("\n");
                    }
                }
                
                
            // Check if role is children
                else if (role.equals("children")) {
                    System.out.println("Role in children: " + role);
                    
                    String queryChildren = "SELECT * FROM `children` WHERE `userID` = ?";
                    pstChildren = con.prepareStatement(queryChildren);
                    pstChildren.setString(1, username);
                    ResultSet rsChildren = pstChildren.executeQuery();
                    
                    // Write CSV header
                    writer.append("email, username, password, role, latitude, longitude,  father, mother\n");
                    
                    while (rsChildren.next()) {
                        this.father = rsChildren.getString("Father");
                        this.mother = rsChildren.getString("Mother");
                        
                        // Write user data to CSV file
                        writer.append(String.join(",", email, username, password, role, latitude, longitude, father, mother));
                        writer.append("\n");
                    }
                }
                
                // Check if role is children
                else if (role.equals("educator")) {
                    System.out.println("Role in educator: " + role);
                    
                    // Write CSV header
                    writer.append("email, username, password, role, latitude, longitude\n");
                    
                        // Write user data to CSV file
                        writer.append(String.join(",", email, username, password, role, latitude, longitude));
                        writer.append("\n");
                }

            writer.flush();
            writer.close();
            con.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace(); // Print stack trace for debugging
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }
}
