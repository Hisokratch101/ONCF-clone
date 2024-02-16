package com.railway.model;

import java.util.*;

public class Billet {

    public int Id;
    public Trajets Trajet;
    public Voyageur Voyageur;
    public int Prix;

    public Billet() {
    }

    public void AfficherBillet() {
        System.out.println("Billet ID: " + Id);
        System.out.println("Trajet: " + Trajet);
        System.out.println("Voyageur: " + Voyageur);
        System.out.println("Prix: " + Prix);
    }

    // Getters and Setters for Id, Trajet, Voyageur, and Prix
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Trajets getTrajet() {
        return Trajet;
    }

    public void setTrajet(Trajets trajet) {
        Trajet = trajet;
    }

    public Voyageur getVoyageur() {
        return Voyageur;
    }

    public void setVoyageur(Voyageur voyageur) {
        Voyageur = voyageur;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }
}