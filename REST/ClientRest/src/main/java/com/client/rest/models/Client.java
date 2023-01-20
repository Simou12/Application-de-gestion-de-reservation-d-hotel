package com.client.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Client {
	@GeneratedValue
	@Id
	private int idclient;
	private String nom;
	private String prenom;
	private String nomUtilisateur;
	private String mdp;
	
	public Client() {
	}

	public Client(String nom, String prenom, String nomUtilisateur,String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur=nomUtilisateur;
		this.mdp=mdp;
	}
	
	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	

	
	
}
