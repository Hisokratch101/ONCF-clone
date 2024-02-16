package com.railway.model;

import java.sql.*;

public class Billet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/reservation_system";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void createBillet(Billet billet) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO billets (trajet_id, voyageur_id, prix) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, billet.getTrajet().getId());
            preparedStatement.setInt(2, billet.getVoyageur().getId());
            preparedStatement.setDouble(3, billet.getPrix());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBillet(int billetId) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM billets WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, billetId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Additional methods for updating and querying billets can be added similarly
}