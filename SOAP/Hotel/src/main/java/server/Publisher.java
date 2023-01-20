package server;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.ws.Endpoint;

import hotelModel.Chambre;
import hotelModel.Hotel;
import hotelModel.Chambre.typeChambre;
import hotelModel.Hotel.nombreEtoile;
import serviceWeb1.HotelServiceImpl1;
import serviceWeb2.HotelServiceImpl2;

public class Publisher {

	public static void main(String[] args) {
		ArrayList<Hotel> hotelList=new ArrayList<Hotel>();
		Chambre chambre1=new Chambre(1,typeChambre.DoubleConfort, 80);
		Chambre chambre2=new Chambre(2,typeChambre.quintuple,  210);
		Chambre chambre3=new Chambre(3,typeChambre.simple,  70);
		Chambre chambre4=new Chambre(4,typeChambre.QuadrupleFamiliale,  150);
		Chambre chambre5=new Chambre(5,typeChambre.TripleFamiliale,  100);
		
		Hotel hotel1= new Hotel("Atlantis", "France","Paris" ,"rue leclerc", 115, "Butty"," 41.40, 2.174" , 70, 210, nombreEtoile.cinqEtoile);
		hotel1.addAgencePartenaire("fly1","0001");
		hotel1.addAgencePartenaire("fly2", "0002");	
		hotel1.addAgencePartenaire("fly3", "0003");	
		hotel1.addAgencePartenaire("fly4", "0004");	
		hotel1.getChambreList().addAll(Arrays.asList( chambre1,chambre2, chambre3, chambre4, chambre5 ));		
		
		Hotel hotel2= new  Hotel("Delagare", "France","Nancy" ,"rue de la liberté ", 115, "birel","12.4,80.322" , 20, 100, nombreEtoile.deuxEtoiles);
		
		hotel2.addAgencePartenaire("fly5","0005");
		hotel2.addAgencePartenaire("fly2", "0004");	
		hotel2.addAgencePartenaire("fly7", "0007");	
		hotel2.addAgencePartenaire("fly1", "0001");	
		hotel2.getChambreList().addAll(Arrays.asList( 
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
				new Chambre(11,typeChambre.quintuple, 100)
				));		
		
		Hotel hotel3= new  Hotel("Millie Rose", "France", "Montpellier" ,"rue bergère ", 110, "Berg ","12.4,80.322" , 62, 190, nombreEtoile.quatreEtoile);
		
		hotel3.addAgencePartenaire("fly5","0005");
		hotel3.addAgencePartenaire("fly2", "0004");	
		hotel3.addAgencePartenaire("fly7", "0007");	
		hotel3.addAgencePartenaire("fly1", "0001");	
		hotel3.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 62),
				new Chambre(2,typeChambre.simple,62), 
				new Chambre(3,typeChambre.DoubleConfort, 75),
				new Chambre(4,typeChambre.DoubleConfort, 75),
				new Chambre(5,typeChambre.DoubleConfort, 75), 
				new Chambre(6,typeChambre.TripleFamiliale, 111),
				new Chambre(7,typeChambre.TripleFamiliale, 111),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(10,typeChambre.quintuple, 190),
				new Chambre(11,typeChambre.quintuple, 190)
				));	
		
		Hotel hotel4= new  Hotel("Comtesse", "France", "Montpellier" ,"rue mere teresa ", 119, "tourville ","12.4,80.322" , 15, 70, nombreEtoile.uneEtoile);
		
		hotel4.addAgencePartenaire("fly5","0005");
		hotel4.addAgencePartenaire("fly2", "0004");	
		hotel4.addAgencePartenaire("fly7", "0007");	
		hotel4.addAgencePartenaire("fly1", "0001");	
		hotel4.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 15),
				new Chambre(2,typeChambre.simple,15), 
				new Chambre(3,typeChambre.DoubleConfort, 32),
				new Chambre(4,typeChambre.DoubleConfort, 32),
				new Chambre(5,typeChambre.DoubleConfort, 32), 
				new Chambre(6,typeChambre.TripleFamiliale, 41),
				new Chambre(7,typeChambre.TripleFamiliale, 41),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 65),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 65),
				new Chambre(10,typeChambre.quintuple, 70),
				new Chambre(11,typeChambre.quintuple, 70)
				));	
		Hotel hotel5= new  Hotel("Favart", "France", "Montpellier" ,"rue mere teresa ", 119, "tourville ","12.4,80.322" , 62, 190, nombreEtoile.quatreEtoile);
		
		hotel5.addAgencePartenaire("fly5","0005");
		hotel5.addAgencePartenaire("fly2", "0004");	
		hotel5.addAgencePartenaire("fly7", "0007");	
		hotel5.addAgencePartenaire("fly1", "0001");	
		hotel5.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 62),
				new Chambre(2,typeChambre.simple,62), 
				new Chambre(3,typeChambre.DoubleConfort, 75),
				new Chambre(4,typeChambre.DoubleConfort, 75),
				new Chambre(5,typeChambre.DoubleConfort, 75), 
				new Chambre(6,typeChambre.TripleFamiliale, 111),
				new Chambre(7,typeChambre.TripleFamiliale, 111),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(10,typeChambre.quintuple, 190),
				new Chambre(11,typeChambre.quintuple, 190)
				));	
		
		Hotel hotel6= new  Hotel("Les Halles", "France", "Nancy" ,"rue mere teresa ", 119, "tourville ","12.4,80.322" , 62, 190, nombreEtoile.quatreEtoile);
		
		hotel6.addAgencePartenaire("fly5","0005");
		hotel6.addAgencePartenaire("fly2", "0004");	
		hotel6.addAgencePartenaire("fly7", "0007");	
		hotel6.addAgencePartenaire("fly1", "0001");	
		hotel6.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 62),
				new Chambre(2,typeChambre.simple,62), 
				new Chambre(3,typeChambre.DoubleConfort, 75),
				new Chambre(4,typeChambre.DoubleConfort, 75),
				new Chambre(5,typeChambre.DoubleConfort, 75), 
				new Chambre(6,typeChambre.TripleFamiliale, 111),
				new Chambre(7,typeChambre.TripleFamiliale, 111),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(10,typeChambre.quintuple, 190),
				new Chambre(11,typeChambre.quintuple, 190)
				));	
		
		Hotel hotel7= new  Hotel("Malte", "France", "Lille" ,"rue mere teresa ", 119, "tourville ","12.4,80.322" , 70, 210, nombreEtoile.cinqEtoile);
		
		hotel7.addAgencePartenaire("fly5","0005");
		hotel7.addAgencePartenaire("fly2", "0004");	
		hotel7.addAgencePartenaire("fly7", "0007");	
		hotel7.addAgencePartenaire("fly1", "0001");	
		hotel7.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.DoubleConfort, 80),
				new Chambre(2,typeChambre.quintuple,  210),
				new Chambre(3,typeChambre.simple,  70),
				new Chambre(4,typeChambre.QuadrupleFamiliale,  150),
				new Chambre(5,typeChambre.TripleFamiliale,  100)
				));	
		
		Hotel hotel8= new  Hotel("Chatillon", "Espagne", "Barcelone" ,"rue mere teresa ", 119, "tourville ","12.4,80.322" , 62, 190, nombreEtoile.troisEtoile);
		
		hotel8.addAgencePartenaire("fly5","0005");
		hotel8.addAgencePartenaire("fly2", "0004");	
		hotel8.addAgencePartenaire("fly7", "0007");	
		hotel8.addAgencePartenaire("fly1", "0001");	
		hotel8.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 62),
				new Chambre(2,typeChambre.simple,62), 
				new Chambre(3,typeChambre.DoubleConfort, 75),
				new Chambre(4,typeChambre.DoubleConfort, 75),
				new Chambre(5,typeChambre.DoubleConfort, 75), 
				new Chambre(6,typeChambre.TripleFamiliale, 111),
				new Chambre(7,typeChambre.TripleFamiliale, 111),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(10,typeChambre.quintuple, 190),
				new Chambre(11,typeChambre.quintuple, 190)
				));	
		Hotel hotel11= new  Hotel("Elisée", "France", "Paris" ,"rue mere teresa ", 119, "tourville ","12.4,80.322" , 62, 190, nombreEtoile.troisEtoile);
		
		hotel11.addAgencePartenaire("fly5","0005");
		hotel11.addAgencePartenaire("fly2", "0004");	
		hotel11.addAgencePartenaire("fly7", "0007");	
		hotel11.addAgencePartenaire("fly1", "0001");	
		hotel11.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 62),
				new Chambre(2,typeChambre.simple,62), 
				new Chambre(3,typeChambre.DoubleConfort, 75),
				new Chambre(4,typeChambre.DoubleConfort, 75),
				new Chambre(5,typeChambre.DoubleConfort, 75), 
				new Chambre(6,typeChambre.TripleFamiliale, 111),
				new Chambre(7,typeChambre.TripleFamiliale, 111),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 170),
				new Chambre(10,typeChambre.quintuple, 190),
				new Chambre(11,typeChambre.quintuple, 190)
				));	
		
Hotel hotel9= new  Hotel("Bercy", "France", "Paris" ,"rue mere teresa ", 119, "tourville ","12.4,80.322" , 20, 100, nombreEtoile.deuxEtoiles);
		
		hotel9.addAgencePartenaire("fly5","0005");
		hotel9.addAgencePartenaire("fly2", "0004");	
		hotel9.addAgencePartenaire("fly7", "0007");	
		hotel9.addAgencePartenaire("fly1", "0001");	
		hotel9.getChambreList().addAll(Arrays.asList( 
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
				new Chambre(11,typeChambre.quintuple, 100)
				));	
		
Hotel hotel10= new  Hotel("Ibis", "France", "Montpellier" ,"rue bourrely ", 119, "tourville ","12.4,80.322" , 15, 70, nombreEtoile.uneEtoile);
		
		hotel10.addAgencePartenaire("fly5","0005");
		hotel10.addAgencePartenaire("fly2", "0004");	
		hotel10.addAgencePartenaire("fly7", "0007");	
		hotel10.addAgencePartenaire("fly1", "0001");	
		hotel10.getChambreList().addAll(Arrays.asList( 
				new Chambre(1,typeChambre.simple, 15),
				new Chambre(2,typeChambre.simple,15), 
				new Chambre(3,typeChambre.DoubleConfort, 32),
				new Chambre(4,typeChambre.DoubleConfort, 32),
				new Chambre(5,typeChambre.DoubleConfort, 32), 
				new Chambre(6,typeChambre.TripleFamiliale, 41),
				new Chambre(7,typeChambre.TripleFamiliale, 41),
				new Chambre(8,typeChambre.QuadrupleFamiliale, 65),
				new Chambre(9,typeChambre.QuadrupleFamiliale, 65),
				new Chambre(10,typeChambre.quintuple, 70),
				new Chambre(11,typeChambre.quintuple, 70)
				));	
			
	
		hotelList.addAll(Arrays.asList( hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8, hotel9, hotel10, hotel11));	
		Endpoint.publish("http://localhost:8080/hotelService1", new HotelServiceImpl1(hotelList));
		Endpoint.publish("http://localhost:8080/hotelService2", new HotelServiceImpl2(hotelList));
		System.out.println("server hotel ready");
	}

}
