package hackingthefuture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookingPage {
    private String destinationName;
    private String locationID;
    private Connection con;

    public BookingPage(String destinationName, String locationID) {
        this.destinationName = destinationName;
        this.locationID = locationID;
        try {
            this.con = getConnection(); // Establish database connection
        } catch (SQLException e) {
            e.printStackTrace(); // Handle connection error
        }
    }

    public List<String> getAvailableTimeSlots(String eventName) {
        LocalDate currentDate = LocalDate.now();
        LocalDate maxDate = currentDate.plusWeeks(1);

        List<String> availableTimeSlots = new ArrayList<>();
        int slotNumber = 1;
        LocalDate date = currentDate;
        while (date.isBefore(maxDate)) {
            boolean hasConflict = hasEventConflict(eventName, date);
            if (!hasConflict) {
                availableTimeSlots.add("[" + slotNumber + "] " + date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                slotNumber++;
            }
            date = date.plusDays(1);
        }
        return availableTimeSlots;
    }

    private boolean hasEventConflict(String eventName, LocalDate eventDate) {
        try (Connection conn = getConnection()) {
            String query = "SELECT COUNT(*) FROM event WHERE eventName = ? AND eventDate = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, eventName);
                pstmt.setString(2, eventDate.toString());

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle SQL error
        }
        return false;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3307/hackingthefuture", "root", "");
    }
}
