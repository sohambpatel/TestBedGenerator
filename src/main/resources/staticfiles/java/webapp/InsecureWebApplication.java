package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

    @SpringBootApplication
    public class InsecureWebApplication {

        // Security vulnerability: Hardcoded credentials
        private static final String DB_URL = "jdbc:mysql://localhost:3306/insecure_db";
        private static final String DB_USER = "root";
        private static final String DB_PASSWORD = "root_password";

        public static void main(String[] args) {
            SpringApplication.run(InsecureWebApplication.class, args);
        }

        // Code smell: Excessive logic in the controller
        @RestController
        public static class InsecureController {

            // Security vulnerability: SQL injection
            @GetMapping("/insecure")
            public String insecureEndpoint(@RequestParam String username) {
                String insecureQuery = "SELECT * FROM users WHERE username = '" + username + "'";

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(insecureQuery);

                    // Security vulnerability: Revealing details in error messages
                    if (resultSet.next()) {
                        return "Welcome, " + resultSet.getString("username") + "!";
                    } else {
                        return "User not found!";
                    }

                } catch (Exception e) {
                    // Code smell: Catching generic Exception
                    System.err.println("Error: " + e.getMessage());
                    return "Error occurred!";
                }
            }
        }
    }

