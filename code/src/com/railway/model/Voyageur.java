package com.railway.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Voyageur {
    private String nomComplet;
    private CarteDeReduction carteDeReduction;
    private String email;
    private String motDePasse;
    private String Id;
    
    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public CarteDeReduction getCarteDeReduction() {
        return carteDeReduction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Database connection
    private Connection connection;

    public Voyageur(String nomComplet, String email, String motDePasse, Connection connection) {
        this.nomComplet = nomComplet;
        this.email = email;
        this.motDePasse = motDePasse;
        this.connection = connection;
    }

    public void setCarteDeReduction(CarteDeReduction carteDeReduction) {
        this.carteDeReduction = carteDeReduction;
    }

    public Billet reserver(Trajets trajet) {
        double prix = trajet.getPrix();
        int id = trajet.getId();
        if (this.carteDeReduction != null) {
            prix = this.carteDeReduction.calculerPrix(prix);
        }
        return new Billet(id,trajet, this, prix);
    }

    public boolean login(String email, String motDePasse) {
        if (email == null || email.isEmpty() || motDePasse == null || motDePasse.isEmpty()) {
            throw new IllegalArgumentException("L'email et le mot de passe ne peuvent pas être vides.");
        }
        try {
            String query = "SELECT * FROM voyageurs WHERE email = ? AND mot_de_passe = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, motDePasse);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signUp() {
        if (email == null || email.isEmpty() || motDePasse == null || motDePasse.isEmpty()) {
            throw new IllegalArgumentException("L'email et le mot de passe ne peuvent pas être vides.");
        }
        try {
            String query = "INSERT INTO voyageurs (nom_complet, email, mot_de_passe) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nomComplet);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, motDePasse);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void imprimerBillet(int billetId) {
        try {
            String query = "SELECT * FROM billets WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, billetId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String classe = resultSet.getString("classe");
                String destination = resultSet.getString("destination");
                double prix = resultSet.getDouble("prix");

                // Print the ticket details
                System.out.println("Billet No: " + billetId);
                System.out.println("Classe: " + classe);
                System.out.println("Destination: " + destination);
                System.out.println("Prix: " + prix);
                System.out.println("Imprimé avec succès.");
            } else {
                System.out.println("Billet non trouvé.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
