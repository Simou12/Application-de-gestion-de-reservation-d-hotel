package com.hotel.rest.model;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Offre {
	@Id
	@GeneratedValue
	private long idOffre;
	private String nomOffre;
	
	public Offre( String nomOffre) {
		super();
		this.nomOffre = nomOffre;
	}
	public long getIdOffre() {
		return idOffre;
	}
	public void setIdOffre(long idOffre) {
		this.idOffre = idOffre;
	}
	public String getNomOffre() {
		return nomOffre;
	}
	public void setNomOffre(String nomOffre) {
		this.nomOffre = nomOffre;
	}
	public boolean checkChambreType(int nbrPersonne) {
		/*switch (nbrPersonne) {
			case 1:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.simple)) return true;
				}
				break;
			case 2:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.DoubleConfort)) return true;
				}
				break;
			case 3:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.TripleFamiliale)) return true;
				}
				break;
			case 4:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.QuadrupleFamiliale)) return true;
				}
				break;
			case 5:
				for(Chambre chambre: chambreList) {
					if(chambre.getType().equals(typeChambre.quintuple)) return true;
				}
				break;
			default:
				return false;
			}*/
		return false;
	}
	
	public boolean checkChambreDispo(int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF) {
		/*for(Chambre chambre : chambreList) {
			if(chambre.getPrix()>=prixMin && chambre.getPrix()<=prixMax && !chambre.isReserve(dateD, dateF) && checkChambreType(nbrPersonne)) 
				return true;
		}*/
		return false;
		
	}
	
	public ArrayList<String> listChambreDispo(int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF){
	/*	ArrayList<String> list=new ArrayList<String>();
		for(Chambre chambre : chambreList) {
			if(chambre.getPrix()>=prixMin && chambre.getPrix()<=prixMax && !chambre.isReserve(dateD, dateF) && checkChambreType(nbrPersonne)) 
				list.add(this.getNom()+chambre.getNumeroChambre());
		}
		return list;
		*/
		return null;
	}
	
	

}
