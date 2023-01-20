package hotelModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

public class Chambre {
	
	public enum typeChambre{
	   simple, DoubleConfort, TripleFamiliale ,QuadrupleFamiliale, quintuple
	};
	private int numeroChambre;
	private typeChambre type;
	private int prix;
	ArrayList<LocalDate> dateReserve;
	
public Chambre() {}
	public Chambre(int numeroChambre, typeChambre type, int prix) {
		super();
		this.numeroChambre = numeroChambre;
		this.type = type;
		this.prix=prix;
	
		this.dateReserve = new ArrayList<LocalDate>();
	}
	
	public ArrayList<LocalDate> getDateReserve() {
		return dateReserve;
	}
	
	public void setDateReserve(ArrayList<LocalDate> dateReserve) {
		this.dateReserve = dateReserve;
	}
	public int getNumeroChambre() {
		return numeroChambre;
	}
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public typeChambre getType() {
		return type;
	}
	public void setType(typeChambre type) {
		this.type = type;
	}
	
	public void addDate(String dateD, String dateF) {
		 LocalDate dateDeb= LocalDate.parse(dateD);	
		 LocalDate dateFin= LocalDate.parse(dateF);
		 long nbrJours=ChronoUnit.DAYS.between(dateDeb, dateFin); 
		 (this.dateReserve).add(dateDeb);
		 for(int i=0;i<=nbrJours;i++) {
			 LocalDate date = dateDeb.plusDays(1);
			 dateDeb = date;
			 (this.dateReserve).add(date);
		 }
	}
	
	public void deleteDate(LocalDate date) {
		for(int i=0;i<this.dateReserve.size();i++) {
			if(date.equals(dateReserve.get(i))) dateReserve.remove(i);
		}
	}
	
	public boolean isReserve(String dateDebut, String dateFin ) {
		 LocalDate dateDeb= LocalDate.parse(dateDebut);	
		 LocalDate dateF= LocalDate.parse(dateFin);
		 long nbrJours=ChronoUnit.DAYS.between(dateDeb, dateF); 
		 for(int i=0;i<nbrJours;i++) {
			 LocalDate date = dateDeb.plusDays(1);
			 dateDeb = date;
			 if(dateReserve.contains(date)) {
				 System.out.println("Chambre deja prise le "+date); 
				 return true;
			 }
		 }
		 return false;
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
