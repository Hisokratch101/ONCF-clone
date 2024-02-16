package com.railway.model.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // JDBC URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/guichetgare";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Establishes a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
