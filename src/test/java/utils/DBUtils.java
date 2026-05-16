package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {

    // -------------------------------------------------------
    // CONNECTION CONFIG
    // In a real project these would point to your actual DB.
    // ParaBank uses HSQLDB internally — connection string below
    // is the standard pattern for documentation purposes.
    // -------------------------------------------------------
    private static final String DB_URL      = "jdbc:hsqldb:hsql://localhost/parabank";
    private static final String DB_USER     = "sa";
    private static final String DB_PASSWORD = "";

    private static Connection connection;

    // Open connection
    public static void openConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("DB Connection established.");
        } catch (Exception e) {
            System.out.println("DB Connection failed (expected on live demo): " + e.getMessage());
        }
    }

    // Close connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("DB Connection closed.");
            }
        } catch (Exception e) {
            System.out.println("Error closing DB connection: " + e.getMessage());
        }
    }

    // Validate user exists in DB by username
    public static boolean validateUserExists(String username) {
        String query = "SELECT COUNT(*) FROM customer WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("DB Query — Users found with username '"
                    + username + "': " + count);
                return count > 0;
            }
        } catch (Exception e) {
            System.out.println("DB Query failed (expected on live demo): " + e.getMessage());
        }
        return false;
    }

    // Validate account exists by customer ID
    public static boolean validateAccountExists(int customerId) {
        String query = "SELECT COUNT(*) FROM account WHERE customer_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("DB Query — Accounts found for customer ID "
                    + customerId + ": " + count);
                return count > 0;
            }
        } catch (Exception e) {
            System.out.println("DB Query failed (expected on live demo): " + e.getMessage());
        }
        return false;
    }
}