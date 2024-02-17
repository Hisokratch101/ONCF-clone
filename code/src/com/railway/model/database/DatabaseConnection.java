package com.railway.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // JDBC URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/oncf";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // Establishes a connection to the database
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
