package com.railway.controller;

import com.railway.model.Voyageur;
import com.railway.model.CarteDeReduction;
import com.railway.model.Billet;
import com.railway.model.Trajets;

import java.sql.Connection;
import java.sql.SQLException;

public class VoyageurController {
	private Voyageur voyageur;

	public VoyageurController(String nomComplet, String email, String motDePasse) {
		voyageur = new Voyageur(nomComplet, email, motDePasse);
	}

	public void setCarteDeReduction(CarteDeReduction carteDeReduction) {
		voyageur.setCarteDeReduction(carteDeReduction);
	}

	public Billet reserver(Trajets trajet) {
		try {
			return voyageur.reserver(trajet);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean login(String email, String motDePasse) throws SQLException {
		return voyageur.login(email, motDePasse);
	}

	public boolean signUp() throws SQLException {
		return voyageur.signUp();
	}

	public void imprimerBillet(int billetId) throws SQLException {
		voyageur.imprimerBillet(billetId);
	}

	public String getId() {
		return voyageur.getId();
	}

	public void setId(String id) {
		voyageur.setId(id);
	}
}
