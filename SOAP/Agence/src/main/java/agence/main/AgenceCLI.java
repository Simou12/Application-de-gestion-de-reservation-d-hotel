package agence.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import agence.model.Agence;
import agence.model.Client;
import agence.model.Reservation;
import service.web.hotel1.Hotel;
import service.web.hotel1.HotelServiceImpl1Service;
import service.web.hotel1.IHotelService1;
import service.web.hotel1.NombreEtoile;
import service.web.hotel2.HotelServiceImpl2Service;
import service.web.hotel2.IHotelService2;

public class AgenceCLI extends AbstractMain{
	
	public static IntegerInputProcessor inputProcessor;
	
	public static void main(String[] args)  {
		AgenceCLI main = new AgenceCLI();
		IHotelService1 proxy=null;
		IHotelService2 proxy2=null;
		BufferedReader inputReader;
		String userInput = "";
		Agence agence=new Agence("fly1","0001", 20);
		
		try {
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			//main.setTestServiceWSDLUrl(inputReader);
			proxy = getProxy();
			//main.setTestServiceWSDLUrl(inputReader);
			proxy2 = getProxy2();
			
			do {
				main.menu();
				userInput = inputReader.readLine();
				main.processUserInput(inputReader,userInput, proxy,proxy2,agence);
				Thread.sleep(3000);
				
			} while(!userInput.equals(QUIT));
		} catch (MalformedInputException e) {
			System.err.println(SERVICE_WSDL_URL+ " n'est pas une URL valide");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void processUserInput(BufferedReader Reader, String userInput, IHotelService1 proxy, IHotelService2 proxy2, Agence agence) {
		try {
			String pays,nomVille, dateDeb, dateFin, nomHotel, nomClient, prenomClient, adresseClient, dateNaissanceClient, cordonneBCClient, refReservation,
			idAgence, codeAgence;
			int prixMin, prixMax, nbEtoile, nbPersonne, numChambre;
			LocalDate dateNaissanceCl;
			List<Hotel> listHotel=proxy.getHotelList();
			LocalDate today=LocalDate.now();
			switch(userInput) {
			
			case "1":
				 //Ajouter un hotel partenaire
				System.out.println("id de l'agence: ");
				idAgence=Reader.readLine();	
				System.out.println("le code de l'agence ");
				codeAgence=Reader.readLine();
				if(!agence.checkConnexion(idAgence, codeAgence)) {
					System.err.println("Id ou mot de passe incorrect, Veuillez réessayer");
					return;
				}
				System.out.println("Veuillez saisir le nom de l'hotel que vous voulez ajouter ");
				nomHotel=Reader.readLine();
				agence.addHotelPartenaire(nomHotel);
				break;
			case "2":
				//Affichage des hotels partenaire de l'agence
				System.out.println("id de l'agence: ");
				idAgence=Reader.readLine();
				
				System.out.println("le code de l'agence ");
				codeAgence=Reader.readLine();
				
				if(!agence.checkConnexion(idAgence, codeAgence)) {
					System.err.println("Id ou mot de passe incorrect, Veuillez réessayer");
					return;
				}
				agence.AfficherHotelPartenaire();
				break;	
			case "3": 
				//Afficher les reservation d'un client donné
				System.out.println("id de l'agence: ");
				idAgence=Reader.readLine();	
				System.out.println("le code de l'agence ");
				codeAgence=Reader.readLine();
				if(!agence.checkConnexion(idAgence, codeAgence)) {
					System.err.println("Id ou mot de passe incorrect, Veuillez réessayer");
					return;
				}
				System.out.println("Veuillez saisir le nom du client ");
				nomClient=Reader.readLine();
				System.out.println("Veuillez saisir le prénom du client ");
				prenomClient=Reader.readLine();
				agence.afficherReservationByClient(nomClient, prenomClient);
				break;
			case "4":
				
				//affichage des hotels+ chambres et reservation
				System.out.println("Veuillez entrer l'identifiant de l'agence");
				idAgence=Reader.readLine();
				
				System.out.println("Veuillez entrer le code de l'agence");
				codeAgence=Reader.readLine();
				
				if(!agence.checkConnexion(idAgence, codeAgence)) {
					System.err.println("Id ou mot de passe incorrect, Veuillez réessayer");
					return;
				}
			
				System.out.println("Entrez le nom du pays");
				 pays = Reader.readLine();
				
				System.out.println("Entrez le nom de la ville");
				 nomVille = Reader.readLine();
				
				
				 do{
					 System.out.println("veuillez saisir une date valide superieur à la date d'aujourd'hui, respectant le format AAAA-MM-JJ");
					 System.out.println("Entrez la date du début du sejour");
					 dateDeb = Reader.readLine();
				 }while(LocalDate.parse(dateDeb).isBefore(today));
				 
				 do{
					 System.out.println("veuillez saisir une date valide superieur ou égale à la date du début de séjour, respectant le format AAAA-MM-JJ");
					 System.out.println("Entrez la date de fin du sejour");
					 dateFin = Reader.readLine();
				 }while((LocalDate.parse(dateFin)).isBefore(LocalDate.parse(dateDeb)));
				 
				
				
				System.out.println("Entrez le prix minimum");
				inputProcessor = new IntegerInputProcessor(Reader);
				 prixMin = inputProcessor.process();
				
				System.out.println("Entrez le prix maximum");
				inputProcessor = new IntegerInputProcessor(Reader);
				 prixMax = inputProcessor.process();
				
				System.out.println("Entrez le nombre d'etoiles souhaité");
				inputProcessor = new IntegerInputProcessor(Reader);
				 nbEtoile = inputProcessor.process();
				NombreEtoile nombreEtoile=null;
				switch(nbEtoile) {
				case 1:
					nombreEtoile=NombreEtoile.UNE_ETOILE;
					break;
				case 2:
					nombreEtoile=NombreEtoile.DEUX_ETOILES;
					break;
				case 3:
					nombreEtoile=NombreEtoile.TROIS_ETOILE;
					break;
				case 4:
					nombreEtoile=NombreEtoile.QUATRE_ETOILE;
					break;
				case 5:
					nombreEtoile=NombreEtoile.CINQ_ETOILE;
					break;
				}
				
				System.out.println("Entrez le nombre de personnes");
				inputProcessor = new IntegerInputProcessor(Reader);
				 nbPersonne = inputProcessor.process();
				 boolean noChambreDispo=true; String chambreDispo;
				for(Hotel hotel:listHotel) {
					 nomHotel=hotel.getNom();
					 if(hotel.getCategorie().equals(nombreEtoile) && hotel.getVille().equals(nomVille) && hotel.getPays().equals(pays)) {
						 chambreDispo= proxy.printChambreDispo(nomHotel, dateDeb, dateFin, nbPersonne, prixMin, prixMax,agence.getPoucentage() );
						 if(!(chambreDispo.equals("Aucune chambre n'est disponible pour ces critères") && chambreDispo.equals(""))) { 
							 System.out.println( "Hotel "+hotel.getNom()+"  Adresse:  "+hotel.getNumRue()+" "+hotel.getRue()+" lieu dit "+hotel.getLieu()+"  Ville: "+hotel.getVille()+"  Pays: "+hotel.getPays()+"  Position GPS: "+hotel.getPositionGPS()+
							 " hotel de "+hotel.getCategorie());	
							 noChambreDispo=false;
							 System.out.println(chambreDispo);	
						 }
					 }
				}
				if(noChambreDispo) {
					System.out.println("Aucune chambre ne correspond aux critères saisies ");
					return ;
				}
				JFrame f = new JFrame("Welcome");  
				JPanel panel = new JPanel();
				panel.setBounds(20,20,500,500);  
				List<String> nbChambreDispo= proxy.listChambreDispoService(nbPersonne, prixMin, prixMax, dateDeb, dateFin);
			      
			    for(int i=0; i<nbChambreDispo.size();i++) {
			    	  String nomImage = nbChambreDispo.get(i);
			    	  ImageIcon image = new ImageIcon("imagehotel/"+nomImage+".jpg");
			    	  JLabel label= new JLabel();
					  label.setIcon(image);
					  label.setText(nomImage);
					  label.setHorizontalTextPosition(JLabel.LEFT);
					  panel.add(label);  
			      }
			     
			      f.add(panel);
			      f.setSize(600,600);  
			      f.setLayout(null);  
			      f.setVisible(true);
				
				System.out.println("Entrez le nom de l'hotel dans lequel vous voulez effectuer une réservation");
				 nomHotel = Reader.readLine();
				 
				 System.out.println("Pour effectuer une reservation à l'hotel "+nomHotel);
				 System.out.println("Veuillez saisir l'identifiant de l'agence");
				 idAgence=Reader.readLine();	
				System.out.println("Veuillez saisir le code de l'agence");
					codeAgence=Reader.readLine();
					
				if(!(proxy.checkAgencePartenaire(nomHotel, idAgence, codeAgence))) {
					System.out.println("il ne vous est pas possible d'accéder aux services de l'hotel "+nomHotel);
					return ;
				}
				
				System.out.println("Entrez le numero de la chambre que vous voulez reserver");
				inputProcessor = new IntegerInputProcessor(Reader);
				 numChambre = inputProcessor.process();
				
				boolean chambreReserved;
				chambreReserved=proxy2.reservChambre(idAgence , codeAgence, nomHotel, numChambre, nbPersonne, prixMin, prixMax, dateDeb, dateFin, agence.getPoucentage());
				System.out.println("chambre reserve "+chambreReserved);
				if(chambreReserved) {
					proxy.updateR(nomHotel, numChambre, dateDeb, dateFin);
					System.out.println("Veuillez entrer les informations du client ");
					System.out.println(" Nom du client : ");
					nomClient=Reader.readLine();
					
					System.out.println(" Prenom du client: ");
					prenomClient=Reader.readLine();
					
					System.out.println(" Adresse du client: ");
					adresseClient=Reader.readLine();
					
					System.out.println("La date de naissance du client: Veuillez respecter le format aaaa-mm-jj");
					dateNaissanceClient=Reader.readLine();
					dateNaissanceCl= LocalDate.parse(dateNaissanceClient);	
					
					System.out.println("Les cordonnées bancaire du client");
					cordonneBCClient=Reader.readLine();
					Client client =new Client(nomHotel, prenomClient, adresseClient, cordonneBCClient, dateNaissanceCl);
					refReservation= agence.addReservation( client, dateDeb, dateFin, nomHotel, numChambre);
					System.out.println("La reservation de référence "+refReservation+ " est effectuée avec succèe ");
				}else {
					System.out.println("Votre demande de réservation a échoué, veuillez réessayer ultérieurement");
				}
				break;
				
			case "5":
				// Annulation des reservations
				System.out.println("Une reservation peut être annulée au moins 2 jours avant son début");
				System.out.println(" Veuillez saisir les informations suivantes pour pouvoir annuler une réservation ");
				
				System.out.println("id de l'agence: ");
				idAgence=Reader.readLine();
				
				System.out.println("le code de l'agence ");
				codeAgence=Reader.readLine();
				
				
				if(!agence.checkConnexion(idAgence, codeAgence)) {
					System.err.println("Id ou mot de passe incorrect, Veuillez réessayer");
					return;
				}
						
				System.out.println("Le nom de l'hotel ");
				nomHotel=Reader.readLine();
				
				System.out.println("Le numéro de la chambre :");
				inputProcessor = new IntegerInputProcessor(Reader);
				numChambre = inputProcessor.process();
				
				 do{
					 System.out.println("veuillez saisir une date valide superieur ou égale à la date d'aujourd'hui, respectant le format AAAA-MM-JJ");
					 System.out.println("Entrez la date du début du sejour");
					 dateDeb = Reader.readLine();
				 }while(LocalDate.parse(dateDeb).isBefore(today));
				
				 do{
					 System.out.println("veuillez saisir une date valide superieur ou égale à la date de début du séjour, respectant le format AAAA-MM-JJ");
					 System.out.println("Entrez la date de fin du sejour");
					 dateFin = Reader.readLine();
				 }while((LocalDate.parse(dateFin)).isBefore(LocalDate.parse(dateDeb)));
				
				if( proxy2.cancelReservationChambre(idAgence, codeAgence, nomHotel, numChambre, dateDeb, dateFin) ) {
					String referenceReserv=agence.deleteReservation(nomHotel, numChambre, dateDeb, dateFin);
					System.out.println("Votre reservation "+referenceReserv+" est annulée ");
					proxy.updateC(nomHotel, numChambre, dateDeb, dateFin);
				}else {
					System.out.println(" L'operation d'annulation a echoué ");
				}
				break;

			case QUIT:
				System.out.println("A bientot!");
				return;		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*JFrame f = new JFrame("Welcome");  
	JPanel panel = new JPanel();
	panel.setBounds(20,20,500,500);  
	int nbChambreDispo=4;
      
    for(int i=1; i<=nbChambreDispo;i++) {
    	  String nomImage = "room"+i;
    	  ImageIcon image = new ImageIcon(nomImage+".jpg");
    	  JLabel label= new JLabel();
		  label.setIcon(image);
		  label.setText(nomImage);
		  label.setHorizontalTextPosition(JLabel.LEFT);
		  panel.add(label);  
      }
     
      f.add(panel);
      f.setSize(600,600);  
      f.setLayout(null);  
      f.setVisible(true);*/
	@Override
	protected boolean valideServiceWSDL() {
		return SERVICE_WSDL_URL.equals("http://localhost:8080/hotelService1?wsdl");
	}
	
	@Override
	protected boolean valideServiceWSDL2() {
		return SERVICE_WSDL_URL.equals("http://localhost:8080/hotelService2?wsdl");
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit");
		builder.append("\n1. Ajouter un hotel partenaire  ");
		builder.append("\n2. Afficher les hotels partenaires de l'agence ");
		builder.append("\n3. Afficher les réservations d'un client donné");
		builder.append("\n4. Effectuer une reservation");
		builder.append("\n5. Annuler une reservation");
		
		
		System.out.println(builder);
		
	}
	
	private static IHotelService1 getProxy() throws MalformedURLException{
		return new HotelServiceImpl1Service(new URL("http://localhost:8080/hotelService1?wsdl")).getHotelServiceImpl1Port();
	}
	
	private static IHotelService2 getProxy2() throws MalformedURLException{
		return new HotelServiceImpl2Service(new URL("http://localhost:8080/hotelService2?wsdl")).getHotelServiceImpl2Port();
	}
	

}



