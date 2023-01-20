package serviceWeb1;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import hotel.service.exception.HotelNotFound;
import hotelModel.Hotel;
import hotelModel.Hotel.nombreEtoile;

@WebService
public interface IHotelService1 {
	@WebMethod
	public ArrayList<Hotel> getHotelList();
	@WebMethod
	public void setHotelList(ArrayList<Hotel> hotelList);
	@WebMethod
	public Hotel getHotelByName(String nom) throws HotelNotFound;
	@WebMethod
	public boolean checkAgencePartenaire(String nomHotel, String id, String code);
	@WebMethod
	public boolean ajouteAgencePartenaire(String nomHotel, String id, String code);
	@WebMethod
	public String printChambreDispo(String nomHotel, String dateD, String dateF, int nbrPersonne, int prixMin, int prixMax, int pourcentage);
	@WebMethod
	public String printHotel(String ville, String dateDeb, String dateFin, int prixMin, int prixMax, nombreEtoile nbrEToile, int nbrPersonnes );
	@WebMethod
	public boolean verifChambreType(String nomHotel, int nbrPersonne);
	@WebMethod
	public boolean verifChambreDispo(String nomHotel, int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF);
	@WebMethod
	public void updateR(String n, int num, String d, String d2);
	@WebMethod 
	public void updateC(String n, int num, String d, String d2);
	@WebMethod
	public ArrayList<String> listChambreDispoService(int nbrPersonne, int prixMin, int prixMax, String dateD, String dateF);
}
