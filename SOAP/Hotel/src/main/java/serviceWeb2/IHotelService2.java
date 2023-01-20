package serviceWeb2;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import hotelModel.Hotel;
@WebService
public interface IHotelService2 {
	@WebMethod
	public ArrayList<Hotel> getHotelList2();
	@WebMethod
	public boolean ReservChambre(String idAgence, String codeAgence, String nomHotel,int numChambre, int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF, int pourcentage);
	@WebMethod
	public boolean cancelReservationChambre(String idAgence, String codeAgence, String nomHotel, int numChambre, String dateDeb, String dateFin);
}
