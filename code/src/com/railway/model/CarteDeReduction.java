package com.railway.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarteDeReduction {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/reservation_system";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void createCarteDeReduction(CarteDeReduction carteDeReduction) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO carte_de_reduction (type, reduction) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carteDeReduction.getType());
            preparedStatement.setDouble(2, carteDeReduction.getReduction());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<CarteDeReduction> getAllCarteDeReduction() {
        List<CarteDeReduction> carteDeReductions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM carte_de_reduction";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String type = resultSet.getString("type");
                double reduction = resultSet.getDouble("reduction");
                CarteDeReduction carteDeReduction = new CarteDeReduction(id, type, reduction);
                carteDeReductions.add(carteDeReduction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carteDeReductions;
    }

    public static void updateCarteDeReduction(CarteDeReduction carteDeReduction) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "UPDATE carte_de_reduction SET type=?, reduction=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carteDeReduction.getType());
            preparedStatement.setDouble(2, carteDeReduction.getReduction());
            preparedStatement.setString(3, carteDeReduction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCarteDeReduction(String id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String query = "DELETE FROM carte_de_reduction WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
