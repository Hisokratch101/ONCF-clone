package com.railway.model;

import java.util.Date;

public class Trajets {
    private String depart;
    private String arriver;
    private Date dateDepart;
    private Date dateArrivee;
    private double prix;
    private int id;


    public Trajets(String depart, String arriver, Date dateDepart, Date dateArrivee, double prix, int id) {
        this.depart = depart;
        this.arriver = arriver;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.prix = prix;
        this.id = id;
    }

    public void setPrix(double prix) {

        this.prix = prix;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    // Obtient le prix du trajet
    public double getPrix() {

        return this.prix;
    }
    // Getter and setter for private String depart
    public String getDepart() {

        return this.depart;
    }

    public void setDepart(String depart) {

        this.depart = depart;
    }

    // Getter and setter for private String arriver
    public String getArriver() {

        return this.arriver;
    }

    public void setArriver(String arriver) {

        this.arriver = arriver;
    }

    // Getter and setter for private String dateDepart
    public Date getDateDepart() {

        return this.dateDepart;
    }

    public void setDateDepart(Date dateDepart) {

        this.dateDepart = dateDepart;
    }

    // Getter and setter for private String dateArrivee
    public Date getDateArrivee() {

        return this.dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {

        this.dateArrivee = dateArrivee;
    }
    

    // Obtient les détails du trajet
    public String getDetails() {
        return String.format("%s à %s de %s à %s", this.depart, this.arriver, this.dateDepart, this.dateArrivee);
    }
}
