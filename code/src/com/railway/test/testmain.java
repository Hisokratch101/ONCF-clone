package com.railway.test;

import com.railway.model.Administrateur;
import com.railway.model.Trajets;

import java.sql.Time;
import java.time.LocalTime;

public class testmain {
    public static void main(String[] args) {
        Administrateur admin = new Administrateur("iadias", "ssdd", "dfjdij");
        Time dep = new Time(15, 50, 0);
        Time arr = new Time(22,20,0);
        Trajets trajet = new Trajets("gg", "FfdsggfsES", dep,arr, 245, 55);
        Administrateur.ajouterTrajet(trajet);
        Voyageur voyageur = new Voyageur("iadias", "ssdd", "dfjdij", null);
    }
}
