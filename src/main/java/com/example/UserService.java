// package main.java.com.example;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.Statement;

// public class UserService {

//     // SECURITY ISSUE: Hardcoded credentials
//     private String password = "admin123";

//     // VULNERABILITY: SQL Injection
//     public void findUser(String username) throws Exception {

//         Connection conn =
//             DriverManager.getConnection("jdbc:mysql://localhost/db",
//                     "root", password);

//         Statement st = conn.createStatement();

//         String query =
//             "SELECT * FROM users WHERE name = '" + username + "'";

//         st.executeQuery(query);
//     }

//     // SMELL: Unused method
//     public void notUsed() {
//         System.out.println("I am never called");
//     }

//     // EVEN WORSE: another SQL injection 
//     public void deleteUser(String username) throws Exception { 
        
//         Connection conn = 
//             DriverManager.getConnection("jdbc:mysql://localhost/db", 
//                  "root", password); 
                 
//             Statement st = conn.createStatement(); 
            
//             String query = "DELETE FROM users WHERE name = '" + username + "'"; 
            
//             st.execute(query); } 

// }




package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserService {

    private static final Logger LOGGER =
            Logger.getLogger(UserService.class.getName());

    private static final String URL = "jdbc:mysql://localhost/db";
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public void findUser(String username) throws SQLException {

        String sql = "SELECT id, name, email FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {

        String sql = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeUpdate();
           if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
    LOGGER.info(String.format("User deleted: %s", username));
}

        }
    }
}
