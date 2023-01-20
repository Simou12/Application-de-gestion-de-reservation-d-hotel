package agence.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.jws.WebService;

import service.web.hotel1.NombreEtoile;




public class Agence {
	
	private String idAgence;
	private String codeAgence;
	private ArrayList<String> listHotelPartenaire;
	private HashMap<String, String> listClient;
	private ArrayList<Reservation> listReservations;
	private int poucentage;
	public Agence() {}
	public Agence(String idAgence, String codeAgence, int pourcentage) {
		super();
		this.idAgence = idAgence;
		this.codeAgence = codeAgence;
		this.poucentage=pourcentage;
		this.listHotelPartenaire=new ArrayList<String>();	
		this.listClient=new HashMap<String, String>();
		this.listReservations=new ArrayList<Reservation>();
	}	
	
	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public String getCodeAgence() {
		return codeAgence;
	}
	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}
	public ArrayList<String> getListHotelPartenaire() {
		return listHotelPartenaire;
	}
	public void setListHotelPartenaire(ArrayList<String> listHotelPartenaire) {
		this.listHotelPartenaire = listHotelPartenaire;
	}
	public HashMap<String, String> getListClient() {
		return listClient;
	}
	public void setListClient(HashMap<String, String> listClient) {
		this.listClient = listClient;
	}
	
	public int getPoucentage() {
		return poucentage;
	}

	public void setPoucentage(int poucentage) {
		this.poucentage = poucentage;
	}
   
	
	public ArrayList<Reservation> getListReservations() {
		return listReservations;
	}
	public void setListReservations(ArrayList<Reservation> listReservations) {
		this.listReservations = listReservations;
	}
	public boolean addHotelPartenaire(String nomHotel) {
		if(listHotelPartenaire.contains(nomHotel)) {
			System.out.println("Cet hotel existe deja dans la liste des hotels partenaires");	
			return false;
		}else {
			listHotelPartenaire.add(nomHotel);
			return true;
		}	
	}
	
	public boolean deleteHotelPartenaire(String nomHotel) {
		if(listHotelPartenaire.contains(nomHotel)) {
			listHotelPartenaire.remove(nomHotel);
			return true;
		}else {
			System.out.println("Cet hotel existe deja dans la liste des hotels partenaires");	
			return false;	
		}
	}
	public 	String addReservation( Client client, String dateDeb, String dateF, String nomhotel, int numChambre) {
		LocalDate dateDebut= LocalDate.parse(dateDeb);
		LocalDate dateFin= LocalDate.parse(dateF);
		Reservation reservation=new Reservation( client, dateDebut, dateFin, nomhotel, numChambre);
		return reservation.getRefReservation();
	}
	
	public String deleteReservation(String nomhotel, int numChambre, String dateDeb, String dateF) {
		String reference="";
		for(int i=0; i<this.getListReservations().size();i++) {
			Reservation res= this.getListReservations().get(i);
			if(res.getNomhotel().equals(nomhotel)&& res.getNumChambre()==numChambre && res.getDateDeb().equals(dateDeb) && res.getDateFin().equals(dateF)) {
				reference= res.getRefReservation();
				this.getListReservations().remove(i);
				return reference;
			}
		}
		return reference;
	}
	public void afficherReservationByClient(String nomClient, String prenomClient) {
		boolean isVoid=true;
		for(Reservation res: this.getListReservations()) {
			if(res.getClient().getNom().equals(nomClient) && res.getClient().getPrenom().equals(prenomClient)) {
				isVoid=false;
				System.out.println("Client "+nomClient+ " "+prenomClient);
				System.out.println("Reservation "+res.getRefReservation()+" Hotel "+res.getNomhotel()+" Chambre numéro "
				+res.getNumChambre()+" date de début de réservation "+res.getDateDeb()+" date de fin de réservation "+res.getDateFin()+" ");
			}
		}
		if(isVoid) {
			System.out.println("Aucune reservation n'est enregistré pour ce client");
		}
	}
	
	public boolean addClient(String id, String code) {
		if(!listClient.containsKey(id)) {
			 listClient.put(id, code);
			 return true;
		}
		return false;
	}
	
	public boolean deleteClient(String id) {
		if(listClient.containsKey(id)) {
			listClient.remove(id);
			return true;
		}else {
			System.out.println("ce client ne figure pas dans la liste des clients de l'agence");	
			return false;	
		}
	}
	
	public boolean checkConnexion(String id, String code) {
		return ((id.equals(this.idAgence)) && code.equals(this.codeAgence));
	}
	
	public void AfficherHotelPartenaire( ) throws MalformedURLException   {
		if(this.getListHotelPartenaire().isEmpty()) System.out.println(" aucun hotel partenaire n'est ajouté ");
		else {
	       for(String hotel: this.getListHotelPartenaire()) {
	    	   System.out.println(" Hotel "+hotel); 
	       }
		}
	}
	
	
}
	

