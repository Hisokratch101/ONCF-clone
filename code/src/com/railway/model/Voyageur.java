package com.railway.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.railway.model.database.DatabaseConnection;

public class Voyageur {
    private String nomComplet;
    private CarteDeReduction carteDeReduction;
    private String email;
    private String motDePasse;
    private String id;


    public Voyageur(String nomComplet, String email, String motDePasse) {
        this.nomComplet = nomComplet;
        this.email = email;
        this.motDePasse = motDePasse;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public CarteDeReduction getCarteDeReduction() {
        return carteDeReduction;
    }

    public void setCarteDeReduction(CarteDeReduction carteDeReduction) {
        this.carteDeReduction = carteDeReduction;
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

    public Billet reserver(Trajets trajet) throws SQLException {
        double prix = trajet.getPrix();
        int id = trajet.getId();
        String depart = trajet.getDepart();
        String arriver = trajet.getArriver();
        Date dateDepart = trajet.getDateDepart();
        Date dateArrivee = trajet.getDateArrivee();

        if (this.carteDeReduction != null) {
            prix = this.carteDeReduction.calculerPrix(prix);
        }

        // Insert reservation into database
        String insertQuery = "INSERT INTO reservations (prix, depart, arriver, date_depart, date_arrivee) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection()){
        	PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setDouble(1, prix);
            preparedStatement.setString(2, depart);
            preparedStatement.setString(3, arriver);
            preparedStatement.setTime(4, new java.sql.Time(dateDepart.getTime()));
            preparedStatement.setTime(5, new java.sql.Time(dateArrivee.getTime()));
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Reservation successful, fetch the auto-generated reservation ID
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int reservationId = generatedKeys.getInt(1);
                        return new Billet(reservationId, trajet, this, prix);
                    }
                }
            }
        }

        // If reservation failed or could not fetch reservation ID, return null
        return null;
    }

    public boolean login(String email, String motDePasse) throws SQLException {
        validateEmailAndPassword(email, motDePasse);

        String query = "SELECT COUNT(*) FROM voyageurs WHERE email = ? AND mot_de_passe = ?";
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, motDePasse);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    public boolean signUp() throws SQLException {
        validateEmailAndPassword(email, motDePasse);

        String query = "INSERT INTO voyageurs (nom_complet, email, mot_de_passe) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {
            preparedStatement.setString(1, nomComplet);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, motDePasse);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        }
    }

    private void validateEmailAndPassword(String email, String motDePasse) {
        if (email == null || email.isEmpty() || motDePasse == null || motDePasse.isEmpty()) {
            throw new IllegalArgumentException("L'email et le mot de passe ne peuvent pas être vides.");
        }
    }

    public void imprimerBillet(int billetId) throws SQLException {
        String query = "SELECT * FROM billets WHERE id = ?";
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(query)) {
            preparedStatement.setInt(1, billetId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
            }
        }
    }
}
