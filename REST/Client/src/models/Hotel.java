package com.client.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {
	
	public enum nombreEtoile{
		ZeroEtoile, uneEtoile, deuxEtoiles, troisEtoile, quatreEtoile, cinqEtoile
	};
	private int idHotel;
	private String nom;
	private String pays;
	private String ville;
	private String rue ;
	private int numRue;
	private String lieu ;
	private String positionGPS;
	private int prixMin;
	private int prixMax;
	private String categorie ;
	
	public Hotel(String nom, String pays, String ville, String rue, int numRue, String lieu, String positionGPS,
			int prixMin, int prixMax, String categorie) {
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numRue = numRue;
		this.lieu = lieu;
		this.positionGPS = positionGPS;
		this.prixMin = prixMin;
		this.prixMax = prixMax;
		this.categorie = categorie;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNumRue() {
		return numRue;
	}

	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getPositionGPS() {
		return positionGPS;
	}

	public void setPositionGPS(String positionGPS) {
		this.positionGPS = positionGPS;
	}

	public int getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(int prixMin) {
		this.prixMin = prixMin;
	}

	public int getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(int prixMax) {
		this.prixMax = prixMax;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Hotel [idHotel=" + idHotel + ", nom=" + nom + ", pays=" + pays + ", ville=" + ville + ", rue=" + rue
				+ ", numRue=" + numRue + ", lieu=" + lieu + ", positionGPS=" + positionGPS
				+ ", prixMax=" + prixMax + ", categorie=" + categorie + "]";
	}
	
	

}
