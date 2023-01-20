package com.agence.rest.models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Component
public class Hotel {
	
	public enum nombreEtoile{
		ZeroEtoile, uneEtoile, deuxEtoiles, troisEtoiles, quatreEtoiles, cinqEtoiles
	};
	@Id
	@GeneratedValue
	private long idHotel;
	private String uri;
	private String nom;
	private String pays;
	private String ville;
	private String rue ;
	private int numRue;
	private String lieu ;
	private String positionGPS;
	private double prixMax;
	private String categorie ;
	
	
	
	public Hotel() {
	}

	public Hotel(String uri, String nom, String pays, String ville, String rue, int numRue, String lieu, String positionGPS
			 , double prixMax, String categorie) {
		this.uri=uri;
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numRue = numRue;
		this.lieu = lieu;
		this.positionGPS = positionGPS;
		this.prixMax = prixMax;
		this.categorie = categorie+"";
	}

	public long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(long idHotel) {
		this.idHotel = idHotel;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
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


	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public String getCategorie() {
		return categorie;
	}

	public String toString(double pourcentage) {
		return "Hotel [idHotel=" + idHotel + ", nom=" + nom + ", pays=" + pays + ", ville=" + ville + ", rue=" + rue
				+ ", numRue=" + numRue + ", lieu=" + lieu + ", positionGPS=" + positionGPS
				+ ", prixMax=" + prixMax+(prixMax*(pourcentage/100)) + ", categorie=" + categorie+ "]";
	}
	
	public String nbrEtoiles(int nbEtoile) {
		switch(nbEtoile) {
		case 1 :
			return "uneEtoile";
		case 2:
			return "deuxEtoiles";
		case 3 :
			return "troisEtoiles";
		case 4 :
			return "quatreEtoiles";
		case 5 :
			return "cinqEtoiles";
		}
		return "Le nombre d'étoile n'est pas valide";
	}
	
	

}
