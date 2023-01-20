package com.hotel.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Hotel {
	public enum nombreEtoile{
		ZeroEtoile, uneEtoile, deuxEtoiles, troisEtoile, quatreEtoile, cinqEtoile
	};
	@Id
	@GeneratedValue
	private long idHotel;
	private String nom;
	private String pays;
	private String ville;
	private String rue ;
	private int numRue;
	private String lieu ;
	private String positionGPS;
	private double prixMax;
	private String categorie ;
	
	public Hotel() {}
	public Hotel(String nom, String pays, String ville, String rue, int numRue, String lieu,String position, double prixMax,
			String categorie) {
		super();
		this.nom = nom;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numRue = numRue;
		this.lieu = lieu;
		this.prixMax=prixMax;
		this.positionGPS=position;
		this.categorie = categorie;
		
	}
	
	
	public long getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(long idHotel) {
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
	
	public double getPrixMax() {
		return prixMax;
	}
	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getPositionGPS() {
		return positionGPS;
	}
	public void setPositionGPS(String positionGPS) {
		this.positionGPS = positionGPS;
	}
	
	
	
	
	
	
	
	
	

	
	
	
}