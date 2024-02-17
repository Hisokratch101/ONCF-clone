package com.railway.controller;

import com.railway.model.Administrateur;
import com.railway.model.Trajets;
import com.railway.model.CarteDeReduction;

public class AdministrateurController {
    private Administrateur administrateur;

    public AdministrateurController(Administrateur administrateur) {

        this.administrateur = administrateur;
    }

    public void ajouterTrajet(Trajets trajet) {

        Administrateur.ajouterTrajet(trajet);
    }

    public void modifierTrajet(Trajets trajet) {

        administrateur.modifierTrajet(trajet);
    }

    public void supprimerTrajet(int trajetId) {

        administrateur.supprimerTrajet(trajetId);
    }

    public void ajouterCarteReduction(CarteDeReduction carte) {

        administrateur.ajouterCarteReduction(carte);
    }

    public void modifierCarteReduction(CarteDeReduction carte) {

        administrateur.modifierCarteReduction(carte);
    }
}
