package agence.main;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import agence.model.Agence;
import service.web.hotel1.Hotel;
import service.web.hotel1.HotelServiceImpl1Service;
import service.web.hotel1.IHotelService1;
import service.web.hotel1.NombreEtoile;
import service.web.hotel2.HotelServiceImpl2Service;
import service.web.hotel2.IHotelService2;


public class Main {

	public static void main(String[] args)  {
		
		try {
			URL url = new URL("http://localhost:8080/hotelService1?wsdl");
		HotelServiceImpl1Service hotelService=new HotelServiceImpl1Service(url);
			IHotelService1 proxy=hotelService.getHotelServiceImpl1Port();
			System.out.println(proxy.checkAgencePartenaire("Atlantis", "fly1", "000"));
			
			URL url2 = new URL("http://localhost:8080/hotelService2?wsdl");
			HotelServiceImpl2Service hotelService2=new HotelServiceImpl2Service(url2);
			IHotelService2 proxy2=hotelService2.getHotelServiceImpl2Port();
			
			List<Hotel> list=proxy.getHotelList();
			System.out.println( proxy.printHotel("Montpellier", "2022-12-23", "2022-12-27", 10, 250, NombreEtoile.QUATRE_ETOILE, 2 ));
			for(Hotel hotel: list ){
				System.out.println("Hotel "+hotel.getNom());
			System.out.println(proxy.printChambreDispo(hotel.getNom(),  "2022-12-23", "2022-12-27", 2, 10, 250, 20));
			
			}
			System.out.println( proxy2.reservChambre("fly1", "0001", "Bercy",3, 2,10, 250, "2022-12-23", "2022-12-27", 20));
			proxy.updateR("Bercy", 3, "2022-12-23", "2022-12-27");
			System.out.println("ezfbhkebfjh");
			System.out.println(proxy.printChambreDispo("Bercy",  "2022-12-23", "2022-12-27", 2, 10, 250, 20));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
	
