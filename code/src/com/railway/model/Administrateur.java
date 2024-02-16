package com.railway.model;

import com.railway.model.database.DatabaseConnection;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Administrateur {
    private String nomComplet;
    private String email;
    private String motDePasse;

    public Administrateur(String nomComplet, String email, String motDePasse) {
        this.nomComplet = nomComplet;
        this.email = email;
        // Hashing the password before storing it
        this.motDePasse = hashPassword(motDePasse);
    }

    public void ajouterTrajet(Trajets trajet) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO trajets (depart, destination, horaire, prix) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trajet.getDepart());
            preparedStatement.setString(2, trajet.getDestination());
            preparedStatement.setString(3, trajet.getHoraire());
            preparedStatement.setDouble(4, trajet.getPrix());
            preparedStatement.executeUpdate();
            System.out.println("Trajet ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierTrajet(Trajets trajet) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE trajets SET depart=?, destination=?, horaire=?, prix=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trajet.getDepart());
            preparedStatement.setString(2, trajet.getDestination());
            preparedStatement.setString(3, trajet.getHoraire());
            preparedStatement.setDouble(4, trajet.getPrix());
            preparedStatement.setInt(5, trajet.getId());
            preparedStatement.executeUpdate();
            System.out.println("Trajet modifié avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void supprimerTrajet(int trajetId) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM trajets WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, trajetId);
            preparedStatement.executeUpdate();
            System.out.println("Trajet supprimé avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterCarteReduction(CarteDeReduction carte) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO cartes_reduction (type, description) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carte.getType());
            preparedStatement.setString(2, carte.getDescription());
            preparedStatement.executeUpdate();
            System.out.println("Carte de réduction ajoutée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifierCarteReduction(CarteDeReduction carte) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE cartes_reduction SET description=? WHERE type=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carte.getDescription());
            preparedStatement.setString(2, carte.getType());
            preparedStatement.executeUpdate();
            System.out.println("Carte de réduction modifiée avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
