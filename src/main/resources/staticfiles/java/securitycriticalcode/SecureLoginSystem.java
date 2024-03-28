import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class SecureLoginSystem {

    // Database connection parameters (replace with your actual database details)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/secure_login_db";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static void main(String[] args) {
        // Example usage of secure login
        String username = "user123";
        String password = "secretpassword";

        if (authenticateUser(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }

    private static boolean authenticateUser(String username, String password) {
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare a parameterized SQL query to fetch user details
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                // Execute the query
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Retrieve stored hashed password from the database
                        String hashedPassword = resultSet.getString("password");

                        // Use bcrypt to verify the entered password
                        if (BCrypt.checkpw(password, hashedPassword)) {
                            return true; // Passwords match, authentication successful
                        }
                    }
                }
            }

            // Close the database connection
            connection.close();
        } catch (SQLException e) {
            // Handle database-related exceptions
            e.printStackTrace();
        }

        return false; // Authentication failed
    }
}

