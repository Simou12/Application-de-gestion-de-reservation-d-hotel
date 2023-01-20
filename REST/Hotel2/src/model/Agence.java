package com.hotel.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Agence {
	@Id
	private String idAgence;
	private String code;
	private double pourcentage;
	
	public Agence() {
	
	}
	public Agence(String nom, String code, double pourcentage) {
		super();
		this.idAgence = nom;
		this.code = code;
		this.pourcentage = pourcentage;
	}

	
	public String getIdAgence() {
		return idAgence;
	}
	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	public boolean isAgencePartenaire(String id, String code) {
		/*	if(listAgencePartenaire.containsKey(id)) {
			 String value=listAgencePartenaire.get(id);
			 return value.equals(code);
			}
			System.err.println("Malheureusement, il ne vous est pas possible d'accéder au service de l'hotel "+this.getNom());
			*/
			return false;
		}
		
		public boolean addAgencePartenaire(String id, String code) {
			/*if(listAgencePartenaire.containsKey(id)) {
				System.out.println("Cette agence existe deja dans la liste des agences partenaires");	
				return false;
			}else {
				listAgencePartenaire.put(id, code);
				return true;
			}	*/ return false;
		}
		
		public boolean deleteAgencePartenaire(String id) {
			/*if(listAgencePartenaire.containsKey(id)) {
				listAgencePartenaire.remove(id);
				return true;
			}else{
				System.out.println("Cette agence existe deja dans la liste des agences partenaires");	
				return false;	
			}*/
			return false;
		}
		
	

}
