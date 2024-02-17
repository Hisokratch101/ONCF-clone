package com.railway.controller;

import com.railway.model.Voyageur;
import com.railway.model.CarteDeReduction;
import com.railway.model.Billet;
import com.railway.model.Trajets;

import java.sql.Connection;

public class VoyageurController {
	private Voyageur voyageur;

	public VoyageurController(String nomComplet, String email, String motDePasse, Connection connection) {
		voyageur = new Voyageur(nomComplet, email, motDePasse, connection);
	}

	public void setCarteDeReduction(CarteDeReduction carteDeReduction) {
		voyageur.setCarteDeReduction(carteDeReduction);
	}

	public Billet reserver(Trajets trajet) {
		return voyageur.reserver(trajet);
	}

	public boolean login(String email, String motDePasse) {
		return voyageur.login(email, motDePasse);
	}

	public boolean signUp() {
		return voyageur.signUp();
	}

	public void imprimerBillet(int billetId) {

		voyageur.imprimerBillet(billetId);
	}

	public String getId() {

		return voyageur.getId();
	}

	public void setId(String id) {

		voyageur.setId(id);
	}
}