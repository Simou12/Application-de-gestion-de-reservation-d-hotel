package serviceWeb2;

import java.util.ArrayList;

import javax.jws.WebService;

import hotelModel.Hotel;

@WebService(endpointInterface = "serviceWeb2.IHotelService2")
public class HotelServiceImpl2 implements IHotelService2{
	ArrayList<Hotel> hotelList;

	public HotelServiceImpl2(ArrayList<Hotel> listHotel) {
		this.hotelList=listHotel;
		
	}
	public ArrayList<Hotel> getHotelList2() {
		return hotelList;
	}
	
	
	public boolean ReservChambre(String idAgence, String codeAgence, String nomHotel,int numChambre, int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF, int pourcentage) {
		for(Hotel hotel:this.getHotelList2()) {
				if(hotel.getNom().equals(nomHotel)) {
					if(hotel.isAgencePartenaire(idAgence, codeAgence)) {
						return hotel.ReserverChambre(numChambre, nbrPersonne, dateD, dateF, pourcentage);
					}
				}
		}
		return false;
	}

	public boolean cancelReservationChambre(String idAgence, String codeAgence,String nomHotel, int numChambre, String dateDeb, String dateFin) {
		for(Hotel hotel:this.getHotelList2()) {		
				if(hotel.getNom().equals(nomHotel)) {
					if(hotel.isAgencePartenaire(idAgence, codeAgence)) {
						return hotel.annulerReservationChambre(numChambre, dateDeb, dateFin);
					}
				}
		}
		return false;
	}


}
