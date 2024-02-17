package com.railway.model;

import java.sql.Time;
import java.time.LocalTime;

public class testmain {
    public static void main(String[] args) {
        Administrateur admin = new Administrateur("iadias", "ssdd", "dfjdij");
        Time dep = new Time(15, 50, 0);
        Time arr = new Time(22,20,0);
        Trajets trajet = new Trajets("MARRAKECH", "FES", dep,arr, 245, 1);
        Administrateur.ajouterTrajet(trajet);
    }
}
