package com.hotel.rest.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Chambre {
	
	public enum typeChambre{
	   simple, DoubleConfort, TripleFamiliale ,QuadrupleFamiliale, quintuple
	};
	@Id
	@GeneratedValue
	private long idChambre;
	private int numeroChambre;
	private String type;
	private double prix;
	
	public Chambre() {}
		public Chambre(int numeroChambre, typeChambre type, double prix) {
			super();
			this.numeroChambre = numeroChambre;
			this.type = type+"";
			this.prix=prix;
	}
	

	public int getNumeroChambre() {
		return numeroChambre;
	}
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getType() {
		return type;
	}
	public void setType(typeChambre type) {
		this.type = type+"";
	}	
	public typeChambre getTypeNbrPersonne(int nbr) {
		switch (nbr) {
		case 1: return typeChambre.simple;
		case 2: return typeChambre.DoubleConfort;
		case 3: return typeChambre.TripleFamiliale;
		case 4: return typeChambre.QuadrupleFamiliale;
		case 5: return typeChambre.quintuple;
		default:
			break;
		}
		return null;		
	}
	
	
	
	

}
