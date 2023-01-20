package agence.model;

import java.time.LocalDate;

public class Reservation {
	
	private String refReservation;
	private Client client;
	private LocalDate dateDeb;
	private LocalDate dateFin;
	private String nomhotel;
	private int numChambre;
	static private int ref=0;
	public Reservation( Client client, LocalDate dateDeb, LocalDate dateFin, String nomhotel, int numChambre) {
		super();
		ref++;
		this.refReservation = "res"+ref+client.getNom()+nomhotel;
		this.client = client;
		this.dateDeb = dateDeb;
		this.dateFin = dateFin;
		this.nomhotel = nomhotel;
		this.numChambre=numChambre;
	}
	public String getRefReservation() {
		return refReservation;
	}
	public void setRefReservation(String refReservation) {
		this.refReservation = refReservation;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
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
	public String getNomhotel() {
		return nomhotel;
	}
	public void setNomhotel(String nomhotel) {
		this.nomhotel = nomhotel;
	}
	public int getNumChambre() {
		return numChambre;
	}
	public void setNumChambre(int numChambre) {
		this.numChambre = numChambre;
	}
	
	
	
	
	
	

}
