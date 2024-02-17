package com.railway.test;

import com.railway.model.Administrateur;
import com.railway.model.CarteDeReduction;
import com.railway.model.Trajets;
import com.railway.model.Voyageur;

import java.sql.SQLException;
import java.sql.Time;

public class testmain {
    public static void main(String[] args) throws SQLException {
        /*Administrateur admin = new Administrateur("iadias", "ssdd", "dfjdij");
        Time dep = new Time(15, 50, 0);
        Time arr = new Time(22,20,0);
        Trajets trajet = new Trajets("gg", "FfdsggfsES", dep,arr, 245, 100);
        Administrateur.ajouterTrajet(trajet);
<<<<<<< HEAD
        Voyageur voyageur = new Voyageur("iadias", "ssdd", "dfjdij");
=======
        CarteDeReduction carte = new CarteDeReduction(1,"SMART' NAVETTE",20);
        Voyageur voyageur = new Voyageur("iadias", "ssdd", "dfjdij", null);
        voyageur.signUp();*/
        Voyageur voyageur1 = new Voyageur();
        //voyageur1.login("ssdd", "dfjdij");
        voyageur1.login("ssdd", "dfjdij");
>>>>>>> bcd5e57057e10305e6b426190c6d74c5d38bb55a
    }
}
