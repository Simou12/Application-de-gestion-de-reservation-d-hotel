package agence.model;

import java.time.LocalDate;

public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private LocalDate dateNaissance;
	private String cordonneCB;
	

	
	public Client(String nom, String prenom, String adresse, String cordonneCB, LocalDate dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.cordonneCB = cordonneCB;
		this.dateNaissance = dateNaissance;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCordonneCB() {
		return cordonneCB;
	}
	public void setCordonneCB(String cordonneCB) {
		this.cordonneCB = cordonneCB;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	

}
