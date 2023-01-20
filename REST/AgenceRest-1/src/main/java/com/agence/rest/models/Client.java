package com.agence.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	private int idClient;
	private String nomUtilisateur;
	private String nom;
	private String prenom;
	private String mdp;
	
	public Client() {}

	public Client(String nom, String prenom,String nomutilisateur,String mdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur=nomutilisateur;
		this.mdp = mdp;
	}
	
	public Client(String nom, String prenom,String nomutilisateur ) {
		this.nom = nom;
		this.prenom = prenom;
		this.nomUtilisateur=nomutilisateur;
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

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
