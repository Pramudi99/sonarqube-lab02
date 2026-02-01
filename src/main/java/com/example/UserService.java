

// package com.example;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;
// import java.util.logging.Logger;

// public class UserService {

//     private static final Logger LOGGER =
//             Logger.getLogger(UserService.class.getName());

//     private static final String URL = "jdbc:mysql://localhost/db";
//     private static final String USER = System.getenv("DB_USER");
//     private static final String PASSWORD = System.getenv("DB_PASSWORD");

//     public void findUser(String username) throws SQLException {

//         String sql = "SELECT id, name, email FROM users WHERE name = ?";

//         try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//              PreparedStatement ps = conn.prepareStatement(sql)) {

//             ps.setString(1, username);
//             ps.executeQuery();
//         }
//     }

//     public void deleteUser(String username) throws SQLException {

//         String sql = "DELETE FROM users WHERE name = ?";

//         try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//              PreparedStatement ps = conn.prepareStatement(sql)) {

//             ps.setString(1, username);
//             ps.executeUpdate();
//            if (LOGGER.isLoggable(java.util.logging.Level.INFO)) {
//     LOGGER.info(String.format("User deleted: %s", username));
// }

//         }
//     }
// }






package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Logger;

public class UserService {

    private static final Logger LOGGER =
            Logger.getLogger(UserService.class.getName());

    private static final String URL = "jdbc:mysql://localhost/db";

    private static final String USER =
            Objects.requireNonNull(System.getenv("DB_USER"), "DB_USER not set");

    private static final String PASSWORD =
            Objects.requireNonNull(System.getenv("DB_PASSWORD"), "DB_PASSWORD not set");

    public void findUser(String username) throws SQLException {

        String sql = "SELECT id, name, email FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeQuery();

            LOGGER.info("User search executed");
        }
    }

    public void deleteUser(String username, String role) throws SQLException {

        // Authorization check (fixes Security Hotspot)
        if (!"ADMIN".equals(role)) {
            throw new SecurityException("Unauthorized delete attempt");
        }

        String sql = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.executeUpdate();

            LOGGER.info("User deletion operation executed");
        }
    }
}
