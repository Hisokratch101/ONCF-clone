package com.railway.model;

import java.sql.*;

public class Billet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/reservation_system";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";
    private int Id;
    private Trajets trajet;
    private Voyageur voyageur;
    private double prix;
    

    public Billet(int id, Trajets trajet, Voyageur voyageur, double prix) {
        Id = id;
        this.trajet = trajet;
        this.voyageur = voyageur;
        this.prix = prix;
    }


    public static String getJdbcUrl() {
        return JDBC_URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Trajets getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajets trajet) {
        this.trajet = trajet;
    }

    public Voyageur getVoyageur() {
        return voyageur;
    }

    public void setVoyageur(Voyageur voyageur) {
        this.voyageur = voyageur;
    }

    

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Additional methods for updating and querying billets can be added similarly
}