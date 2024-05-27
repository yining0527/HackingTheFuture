package hackingthefuture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class user1 {
    private Connection con = null;
    private PreparedStatement pst = null;

    private String email;
    private String currentUsername;
    private String username;
    private String password;
    private String role;
    private ArrayList<String> parents = new ArrayList<>();
    private ArrayList<String> children = new ArrayList<>();
    private String locationCoordinate;
    private int currentPoints;
    public String fatherName;
    public String motherName;
    private String childName;

    // Default Constructor
    public user1() {
        // Initialize lists
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Constructor to fetch user details from database
    public user1(String transferUsername) {
        this(); // Initialize lists
        this.username = transferUsername;
        fetchUserDetails();
        fetchParentNames();
        fetchChildNames();
    }

    // Method to initialize database connection
    private void connectToDatabase() throws SQLException {
        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackingthefuture", "root", "");
        }
    }

    // Method to fetch user details from the database
    private void fetchUserDetails() {
        try {
            connectToDatabase();
            String querySD = "SELECT * FROM `user` WHERE `username` = ?";
            pst = con.prepareStatement(querySD);
            pst.setString(1, username);
            System.out.println("hello");

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                this.email = rs.getString("email");
                this.role = rs.getString("role");
                this.password = rs.getString("password");
                this.fatherName = rs.getString("fatherName");
                this.motherName = rs.getString("motherName");
                this.locationCoordinate = rs.getString("LocationCoordinate");
                this.currentPoints = rs.getInt("points");
            }

            rs.close();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error executing SQL query: " + e.getMessage());
        }
    }

    // Method to fetch parent names from the database
    private void fetchParentNames() {
        if ("children".equalsIgnoreCase(role)) {
            try {
                connectToDatabase();
                String querySD = "SELECT * FROM `children` WHERE `userID` = ?";
                pst = con.prepareStatement(querySD);
                pst.setString(1, username);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    this.fatherName = rs.getString("Father");
                    this.motherName = rs.getString("Mother");
                    parents.add(fatherName);
                    parents.add(motherName);
                }

                rs.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error executing SQL query: " + e.getMessage());
            }
        }
    }

    // Method to fetch child names from the database
    private void fetchChildNames() {
        if ("parents".equalsIgnoreCase(role)) {
            try {
                connectToDatabase();
                String querySD = "SELECT * FROM `parent` WHERE `userID` = ?";
                pst = con.prepareStatement(querySD);
                pst.setString(1, username);

                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    String childName = rs.getString("children");
                    children.add(childName);
                }

                rs.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Error executing SQL query: " + e.getMessage());
            }
        }
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getParents() {
        return parents;
    }

    public void setParents(ArrayList<String> parents) {
        this.parents = parents;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children) {
        this.children = children;
    }

    public String getLocationCoordinate() {
        return locationCoordinate;
    }

    public void setLocationCoordinate(String locationCoordinate) {
        this.locationCoordinate = locationCoordinate;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }
}
