package serviceWeb1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.Arrays;

import javax.jws.WebService;

import hotel.service.exception.HotelNotFound;
import hotelModel.Chambre;
import hotelModel.Chambre.typeChambre;
import hotelModel.Hotel;
import hotelModel.Hotel.nombreEtoile;


@WebService(endpointInterface = "serviceWeb1.IHotelService1")
public class HotelServiceImpl1 implements IHotelService1 {
	ArrayList<Hotel> hotelList;

	public HotelServiceImpl1(ArrayList<Hotel> listHotel) {
		this.hotelList=listHotel;
		
	}
	
	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}
	
	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}
	
	public Hotel getHotelByName(String nom)throws HotelNotFound {
		for(Hotel hotel: this.getHotelList()) {
			if(hotel.getNom().equals(nom)) {		
				return hotel;
			}
		}
		return null;
	}
	
	public boolean checkAgencePartenaire(String nomHotel, String id, String code) {
		for(Hotel hotel: this.getHotelList()) {
			if(hotel.getNom().equals(nomHotel)) {		
				return hotel.isAgencePartenaire(id, code);
			}
		}
		return false;
	}
	
	public boolean ajouteAgencePartenaire(String nomHotel, String id, String code) {
		for(Hotel hotel: this.getHotelList()) {
			if(hotel.getNom().equals(nomHotel)) {		
				return hotel.addAgencePartenaire(id, code);
			}
		}
		return false;
	}
	
	public String printChambreDispo(String nomHotel, String dateD, String dateF, int nbrPersonne, int prixMin, int prixMax, int pourcentage) {
		for(Hotel hotel : this.getHotelList()) {
			if(hotel.getNom().equals(nomHotel)) {		
				return hotel.afficherChambreDispo(dateD, dateF, nbrPersonne, prixMin, prixMax,pourcentage );
			}
		}
		return "Aucune chambre n'est disponible pour ces critères";
	}

	public ArrayList<String> listChambreDispoService(int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF){
		ArrayList<String > list=new ArrayList<String>();
		for(Hotel hotel : this.getHotelList()) {
			list.addAll(hotel.listChambreDispo(nbrPersonne, prixMin, prixMax, dateD, dateF));		
		}
		return list;		
	}
	
	public String printHotel(String ville, String dateDeb, String dateFin, int prixMin, int prixMax, nombreEtoile nbrEToile, int nbrPersonnes ) {
		String hotelInfo="";
		for(Hotel proxy: this.getHotelList()) {
			if(proxy.getVille().equals(ville) && proxy.getCategorie().equals(nbrEToile) && proxy.checkChambreDispo(nbrPersonnes, prixMin, prixMax, dateDeb, dateFin) ) {
				hotelInfo+="Hotel "+proxy.getNom()+"  Adresse:  "+proxy.getNumRue()+" "+proxy.getRue()+" lieu dit "+proxy.getLieu()+"  Ville: "+proxy.getVille()+"  Pays: "+proxy.getPays()+"  Position GPS: "+proxy.getPositionGPS()+
						 " hotel de "+proxy.getCategorie()+"\n";	
			} 
		}
		return hotelInfo;
	}

	public boolean verifChambreType(String nomHotel, int nbrPersonne) {
		for(Hotel hotel: this.getHotelList()) {
			if(hotel.getNom().equals(nomHotel)) {		
				return hotel.checkChambreType(nbrPersonne);
			}
		}
		return false;
	}

	
	public boolean verifChambreDispo(String nomHotel, int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF) {
		for(Hotel hotel: this.getHotelList()) {
			if(hotel.getNom().equals(nomHotel)) {		
				return hotel.checkChambreDispo(nbrPersonne, prixMin, prixMax, dateD, dateF);
			}
		}
		return false;	
	}

	@Override
	public void updateR(String n, int num, String d, String d2) {
		for(Hotel hotel: this.getHotelList()) {
			if(hotel.getNom().equals(n)) {
				for(Chambre chambre: hotel.getChambreList()) {
					if(chambre.getNumeroChambre()==num) {
						chambre.addDate(d, d2);	
					}
				}	
			}		
		}
	}

	@Override
	public void updateC(String n, int num, String d, String d2) {
		 LocalDate dateDebut= LocalDate.parse(d);	
		 LocalDate dateF= LocalDate.parse(d2);
		 long nbrJours=ChronoUnit.DAYS.between(dateDebut, dateF); 
		 for(Hotel hotel: this.getHotelList()) {
			 if(hotel.getNom().equals(n)) {
				 for(Chambre chambre: hotel.getChambreList()) {
					 if(chambre.getNumeroChambre()==num) {
						 if( chambre.getDateReserve().contains(dateDebut)) chambre.deleteDate(dateDebut);
						 for(int i=0;i<nbrJours;i++) {
							 LocalDate date = dateDebut.plusDays(1);
							 dateDebut = date;
							 if( chambre.getDateReserve().contains(date)) chambre.deleteDate(date);
						}
					 }
				  }
			 }
		}	
	}
	
	
	
	
		
		

	
}

	
	
	


