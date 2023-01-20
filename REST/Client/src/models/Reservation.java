package com.client.rest.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reservation {
	@Id
	private String idReservation;
	static private int ref=0;
	private String nomUtilisateur;
	private String mdp;
	private String nomClient;
	private String prenomClient;
	private String nomHotel;
	private int numChambre;
	private LocalDate dateDeb;
	private LocalDate dateFin;
	
	public Reservation() {}
	public Reservation(String nomUtilisateur, String mdp, String nomClient, String prenomClient, String nomHotel, int numChambre,
			LocalDate dateDeb, LocalDate dateFin) {
		super();
		ref++;
		this.idReservation ="res"+ref+nomClient+nomHotel;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.nomHotel = nomHotel;
		this.numChambre = numChambre;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.nomUtilisateur=nomUtilisateur;
		this.mdp=mdp;
	}
	public String getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}
	
	public static int getRef() {
		return ref;
	}
	public static void setRef(int ref) {
		Reservation.ref = ref;
	}
	public String getNomutilisateur() {
		return nomUtilisateur;
	}
	public void setNomutilisateur(String nomutilisateur) {
		this.nomUtilisateur = nomutilisateur;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getNomHotel() {
		return nomHotel;
	}
	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}
	public int getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}
	public LocalDate getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(LocalDate dateDeb) {
		this.dateDeb = dateDeb;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", nomutilisateur=" + nomUtilisateur + ", nomClient="
				+ nomClient + ", prenomClient=" + prenomClient + ", nomHotel=" + nomHotel + ", numChambre=" + numChambre
				+ ", dateDeb=" + dateDeb + ", dateFin=" + dateFin + "]";
	}
	 
	
	
	
}
