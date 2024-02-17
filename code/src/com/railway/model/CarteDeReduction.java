package com.railway.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.railway.model.database.DatabaseConnection;

public class CarteDeReduction {
    
    private int id;
    private String type;
    private double reduction ;

    
    
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public double getReduction() {

        return reduction;
    }

    public void setReduction(double reduction) {

        this.reduction = reduction;
    }
    

    public CarteDeReduction(int id, String type, double reduction) {
        this.id = id;
        this.type = type;
        this.reduction = reduction;
    }

    public static void createCarteDeReduction(CarteDeReduction carteDeReduction) {
        try (Connection connection = DatabaseConnection.getConnection()) {
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
        try (Connection connection = DatabaseConnection.getConnection()){
 
            String query = "SELECT * FROM carte_de_reduction";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
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
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE carte_de_reduction SET type=?, reduction=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carteDeReduction.getType());
            preparedStatement.setDouble(2, carteDeReduction.getReduction());
            preparedStatement.setInt(3, carteDeReduction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteCarteDeReduction(String id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM carte_de_reduction WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public double calculerPrix(double prixOriginal) {
        return prixOriginal * (1 - this.reduction*0.01);
    }
}
