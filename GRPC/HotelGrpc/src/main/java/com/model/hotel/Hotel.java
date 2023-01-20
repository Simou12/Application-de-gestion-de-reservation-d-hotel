package com.model.hotel;

import java.util.ArrayList;
import java.util.Arrays;

import com.model.hotel.Chambre.typeChambre;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;



public class Hotel {

	private String nom;
	private String pays;
	private String ville;
	private int categorie ;
	private ArrayList<Chambre> listChambres= new ArrayList<Chambre>();
	private ArrayList<Reservation> listReservation = new ArrayList<>();

	public Hotel() {
		this.nom = "Atlantis";
		this.pays = "France";
		this.ville = "Montpellier";
		this.categorie = 4;
		this.listChambres.addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 20),
				new Chambre(2,typeChambre.simple,20), 
				new Chambre(3,typeChambre.DoubleConfort, 35),
				new Chambre(4,typeChambre.DoubleConfort, 35),
				new Chambre(5,typeChambre.DoubleConfort, 35), 
				new Chambre(6,typeChambre.TripleFamiliale, 50),
				new Chambre(7,typeChambre.TripleFamiliale, 50),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 80),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 80),
				new Chambre(10,typeChambre.quintuple, 100),
				new Chambre(11,typeChambre.quintuple, 100),
				new Chambre(12,typeChambre.simple, 20),
				new Chambre(13,typeChambre.simple,20),
				new Chambre(14,typeChambre.DoubleConfort, 35),
				new Chambre(15,typeChambre.DoubleConfort, 35),
				new Chambre(16,typeChambre.DoubleConfort, 35), 
				new Chambre(17,typeChambre.TripleFamiliale, 50),
				new Chambre(18,typeChambre.TripleFamiliale, 50),
				new Chambre(19,typeChambre.QuadrupleFamiliale, 80),
				new Chambre(20,typeChambre.QuadrupleFamiliale, 80),
				new Chambre(21,typeChambre.quintuple, 100),
				new Chambre(22,typeChambre.quintuple, 100)
				));		
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

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public ArrayList<Chambre> getChambreList() {
		return listChambres;
	}

	public void setChambreList(ArrayList<Chambre> chambreList) {
		this.listChambres = chambreList;
	}

	public ArrayList<Chambre> getChambreByPrix( double prixMax){
		ArrayList<Chambre> listChambresCritere = new ArrayList<Chambre>();
		for(Chambre chambre: listChambres) {
			if(chambre.getPrix()<=prixMax  ) {
				listChambresCritere.add(chambre);
			}
		}
		return listChambresCritere;
	}


	public String createReservation( String nomClient,   String prenomClient,   int  num,  LocalDate dateDeb,  LocalDate dateFin) {
		Reservation res= new Reservation(prenomClient, nomClient, prenomClient, prenomClient, num, dateDeb, dateFin);
		listReservation.add(res);
		return res.getNumReservation();
	}


	public boolean deleteReservation( String refReservation ) {
		for(int i=0;i< listReservation.size(); i++) {
			Reservation res=listReservation.get(i);	
			if(res.getNumReservation().equals(refReservation)) { 
				LocalDate dateD= res.getDateDeb();
				LocalDate dateNow = LocalDate.now();
				long nbJour = ChronoUnit.DAYS.between(dateNow, dateD);
				if(nbJour>=2) {
					listReservation.remove(i);
					return true;
				}else return false;
			}
		}
		return false;
	}



	public String getChambreDispo( LocalDate dateDeb,  LocalDate dateFin, int nbrPersonnes, double prix ) {
		String chambreDispo = "";
		int prixBase;
		ArrayList<Chambre> listChambreDispo = getChambreByPrix(prix);
		if(listReservation.isEmpty()) {
			for(Chambre chambre : listChambreDispo) {
				if((chambre.getTypeNbrPersonne(nbrPersonnes)+"").equals(chambre.getType()+"")){
					prixBase=chambre.getPrix();
					chambreDispo+="Chambre numéro : "+chambre.getNumeroChambre()+" ,type : "+chambre.getType()+" prix basique :" +prixBase+" ,Prix incluant les frais d'agence: "+prixBase +"\n";
				}
			}
			return chambreDispo;
		}
		boolean ischambreDispo=false;
		for(Chambre chambre : listChambreDispo) {
			ischambreDispo=false;
			if((chambre.getTypeNbrPersonne(nbrPersonnes)+"").equals(chambre.getType()+"")){
				ischambreDispo=true;
				for(Reservation reservation: listReservation) {
					LocalDate dateDR=reservation.getDateDeb();
					LocalDate dateFR=reservation.getDateFin();
					if(reservation.getNumChambre()==chambre.getNumeroChambre()) {
						if(( dateDeb.isBefore(dateFR) && (dateDeb.isEqual(dateDR)   || dateDeb.isAfter(dateDR) )) || ( ( dateFin.isBefore(dateFR) && (dateFin.isEqual(dateDR)   || dateFin.isAfter(dateDR) ) ) )){
							ischambreDispo=false;
						}
					}   
				}
			}
			if(ischambreDispo) {
				prixBase=chambre.getPrix();
				chambreDispo+="Chambre numéro : "+chambre.getNumeroChambre()+" ,type : "+chambre.getType()+"prix basique : "+prixBase+ " prix incluant les frais d'agence "+prixBase+"\n";
			}	
		}

		return chambreDispo;
	}


	public boolean verifyChambreDispo( int numChambre,  LocalDate dateDeb,  LocalDate dateFin) {
		boolean isDispo=false;
		for(Chambre chambre: listChambres) {
			if(chambre.getNumeroChambre()==numChambre) {
				isDispo=true;
				for(Reservation reservation: listReservation) {
					if(reservation.getNumChambre()==numChambre) {
						LocalDate dateDR=reservation.getDateDeb();
						LocalDate dateFR=reservation.getDateFin();
						if(( dateDeb.isBefore(dateFR) && (dateDeb.isEqual(dateDR)   || dateDeb.isAfter(dateDR) )) || ( ( dateFin.isBefore(dateFR) && (dateFin.isEqual(dateDR)   || dateFin.isAfter(dateDR) ) ) ))
							return false;
					}         
				}

			}
		}
		return isDispo;
	}








}










