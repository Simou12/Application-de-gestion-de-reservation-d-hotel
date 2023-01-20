package com.model.hotel;

import java.time.LocalDate;

public class Reservation {

	private String numReservation;
	String nomclient;
	String prenomClient;
	String dateNaissance;
	private int numChambre ;
	private LocalDate dateDeb;
	private LocalDate dateFin;
	static private int ref=0;
	public Reservation(String numReservation, String nomclient, String prenomClient, String dateNaissance,
			int numChambre, LocalDate dateDeb, LocalDate dateFin) {
		ref++;
		this.numReservation =  "res"+ref+nomclient+numChambre;
		this.nomclient = nomclient;
		this.prenomClient = prenomClient;
		this.dateNaissance = dateNaissance;
		this.numChambre = numChambre;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
	}
	public String getNumReservation() {
		return numReservation;
	}
	public void setNumReservation(String numReservation) {
		this.numReservation = numReservation;
	}
	public String getNomclient() {
		return nomclient;
	}
	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
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



}
