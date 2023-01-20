package com.client.rest.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.client.rest.models.Agence;
import com.client.rest.models.Client;
import com.client.rest.models.Hotel;
import com.client.rest.models.Reservation;

@Component
public class ClientCLI extends AbstractMain implements CommandLineRunner{
	
	/*ATTRIBUT*/
	@Autowired
	private RestTemplate proxy;
	private IntegerInputProcessor inputProcessor;
	private static Pattern DATE_PATTERN = Pattern.compile(
		      "^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$" 
		      + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
		      + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" 
		      + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

	/*METHODES*/
    public boolean connexion(String uri, String nomUtilisateur, String mdpUtilisateur) {
		Map<String, String> params=new HashMap<String, String>();
		params.put("nomUtilisateur",nomUtilisateur);		
		params.put("mdp", mdpUtilisateur);
	    return proxy.getForObject(uri, Boolean.class, params);
	}
   
	public boolean inscription(String uri, String nom,  String prenom, String nomUtilisateur , String mdp) {
		Map<String, String> params=new HashMap<String, String>();
		params.put("nom", nom);
		params.put("prenom", prenom);
		params.put("nomUtilisateur",nomUtilisateur);		
		params.put("mdp",mdp);
		Client client = new Client(nom,prenom,nomUtilisateur,mdp);
		return proxy.postForObject(uri, client, Boolean.class, params);		
	}
	public static boolean matches(String date) {
        return DATE_PATTERN.matcher(date).matches();
    }
	public boolean checkValidDate(String dateD, String dateF) {
		LocalDate now= LocalDate.now();
		LocalDate dateDeb=LocalDate.parse(dateD);
		LocalDate dateFin= LocalDate.parse(dateF);
		return ((now.isBefore(dateDeb) || now.equals(dateDeb) )  && dateFin.isAfter(dateDeb) ||  dateFin.equals(dateDeb) )  ;	
	}
	
	public String upperLowerCase(String string) {
		return ((string.charAt(0)+"").toUpperCase()+(string.substring(1)).toLowerCase());
	}
	
	public String  getUriAgenceByName(String nomAgence) {
		if(!listAgence.containsKey(nomAgence)) return " ";
		else return listAgence.get(nomAgence);
	}

	
	public void afficherHotelPartenaires(String nomAgence) {	
		String uri;
		uri=getUriAgenceByName(nomAgence);
		if(uri.equals(" ")) System.out.println("L'agence que vous avez saisie n'existe pas");
		else {
			String uriA;
			uriA=uri+"/hotels/partenaire";
			Hotel[] hotels = proxy.getForObject(uriA, Hotel[].class);
			for(Hotel h: hotels) System.out.println(h.toString());
		}
	}	
	
	@Override
	public void run(String... args) throws Exception {
		BufferedReader inputReader;
		String userInput = "";
		
		
		try {
			inputReader = new BufferedReader(new InputStreamReader(System.in));
			//setTestServiceUrl(inputReader);
			listAgence.put("Fly","http://localhost:8084/agenceService/api");
			listAgence.put("Tour","http://localhost:8082/tour/api");
			
			listUriAgences.add("http://localhost:8084/agenceService/api");
			listUriAgences.add("http://localhost:8082/tour/api");
			
			do {
				menu();
				userInput = inputReader.readLine();
				processUserInput(inputReader,userInput, proxy);
				Thread.sleep(3000);
				
			} while(!userInput.equals(QUIT));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit");
		builder.append("\n1. Afficher les agences disponibles");
		builder.append("\n2. Afficher les hotels partenaires de l'agence ");
		builder.append("\n3. Effectuer une recherche d'hotels selon vos critères ");
		builder.append("\n4. Inscription");
		builder.append("\n5. Effectuer une reservation");
		builder.append("\n6. Annuler une reservation");
		builder.append("\n7. Afficher mes réservations");
		
		System.out.println(builder);	
	}
	
	
	private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {
		String pays, ville, dateDeb, dateFin, nomHotel, nomClient, prenomClient, nomAgence, nomUtilisateur, 
		mdpUtilisateur, chambreDispo, refReservation, uri;
		int prixMax, nbEtoile, nbPersonne, numChambre; 
		try {
		switch(userInput) {	
			case "1":
				for(String uriA : listUriAgences) {
					uriA += "/agence";
					Agence agence = proxy.getForObject(uriA, Agence.class);
					 System.out.println(agence.toString());
					 //System.out.println(agence.getIdAgence()+" Pourcentage :"+agence.getPourcentage()+" %");					
				} 
				break;	
			case "2":
				System.out.println("Veuillez saisir le nom de l'agence");
				nomAgence =upperLowerCase(reader.readLine());
				afficherHotelPartenaires(nomAgence);
				break;	
			case "3":
				System.out.println("Veuillez saisir vos critères ");
				System.out.println("Pays :");
				pays =upperLowerCase( reader.readLine());
				System.out.println("Ville :");
				ville = upperLowerCase( reader.readLine());
				System.out.println("Le prix Maximum (Budget) :");
				inputProcessor = new IntegerInputProcessor(reader);
				prixMax = inputProcessor.process();
				System.out.println("Le nombre d'étoiles");
				inputProcessor = new IntegerInputProcessor(reader);
				nbEtoile = inputProcessor.process();
				System.out.println("Le nombre de personnes a heberger");
				inputProcessor = new IntegerInputProcessor(reader);
				nbPersonne = inputProcessor.process();
				System.out.println("Date du debut du sejour [format YYYY-MM-DD ]");
				dateDeb = reader.readLine();
				while(!(matches(dateDeb))){
					System.out.println("La date saisie ne correspond pas au format demandé YYYY-MM-DD");
					System.out.println("Date du debut de sejour en format YYYY-MM-DD");
					dateDeb = reader.readLine();
				}
				System.out.println("Date de fin du sejour [format YYYY-MM-DD]");
				dateFin = reader.readLine();
				while(!( matches(dateFin))) {
					System.out.println("La date saisie ne correspond pas au format demandé YYYY-MM-DD");
					System.out.println("Date de fin de sejour en format YYYY-MM-DD");
					dateFin = reader.readLine();
				}
				while(!checkValidDate(dateDeb, dateFin)) {
					System.out.println("Veuillez saisir des dates valides,\n date de début supérieure ou égale à la date d'aujourd'hui, \n date fin doit être supérieur ou egale à la date du début");
					System.out.println("Date du debut de sejour,  format YYYY-MM-DD");
					dateDeb = reader.readLine();
					System.out.println("Date de fin de sejour,  format YYYY-MM-DD");
					dateFin = reader.readLine();
				}
				LocalDate dateD = LocalDate.parse(dateDeb);
				LocalDate dateF = LocalDate.parse(dateFin);	
				
				List<String> listChambres= new ArrayList<String>();
				for(String uriA : listUriAgences) {
						Agence agence = proxy.getForObject(uriA+"/agences", Agence[].class)[0];
						System.out.println(agence.toString());
						System.out.println();
						Map<String, Object> params=new HashMap<String, Object>();
						params.put("pays", pays);
						params.put("ville", ville );
						params.put("nbEtoile", nbEtoile);
						params.put("prixMax", prixMax);
						params.put("nbrPersonnes", nbPersonne);
						params.put("dateDeb", dateD);
						params.put("dateFin", dateF );
						chambreDispo = proxy.getForObject(uriA+"/hotels/chambres/{pays}/{ville}/{nbEtoile}/{prixMax}/{nbrPersonnes}/{dateDeb}/{dateFin}", String.class, params)+"\n";
						System.out.println(chambreDispo);				    
			   }	

				break;
			case "4" :
				System.out.println("Veuillez saisir le nom de l'agence où vous souhaitez vous inscrire");
				nomAgence =upperLowerCase( reader.readLine());
				 uri=getUriAgenceByName(nomAgence);
					if(uri.equals(" ")) System.err.println("Le nom de l'agence que vous avez saisi n'existe pas");
					else{		
						System.out.println("Inscription à l'agence :"+nomAgence);
						System.out.println("Veuillez saisir les informations suivantes :");
						System.out.println("Nom :");
						nomClient =upperLowerCase( reader.readLine());
						System.out.println("Prenom :");
						prenomClient = upperLowerCase( reader.readLine());
						System.out.println("Nom d'utilisateur :");
						nomUtilisateur =upperLowerCase( reader.readLine());
						System.out.println("Le mot de passe :");
						mdpUtilisateur =  reader.readLine();
						while(!inscription(uri+"/agence/inscription/{nom}/{prenom}/{nomUtilisateur}/{mdp}", nomAgence, prenomClient, nomUtilisateur, mdpUtilisateur)) {
							System.out.println("Le nom d'utilisateur que vous avez choisi existe dèja, veuillez choisir un autre ");
							System.out.println("Nom d'utilisateur");
							nomUtilisateur = upperLowerCase( reader.readLine());
							System.out.println("Le mot de passe");
							mdpUtilisateur = reader.readLine();					
						}
						System.out.println("Inscription réussie");	
						
					}	
				break;	
			case "5": 
				System.out.println("Veuillez saisir les informations suivantes : ");
				System.out.println(" nom de l'agence ou vous souhaitez effectuer une réservation :");
				nomAgence=upperLowerCase( reader.readLine());
				 uri=getUriAgenceByName(nomAgence);
				if(uri.equals(" ")) System.out.println("Le nom de l'agence que vous avez saisi n'existe pas");
				else {
					boolean hotelExist=false;
					System.out.println("Nom hotel :");
					nomHotel=upperLowerCase( reader.readLine());
					Hotel[] listHotels = proxy.getForObject(uri+"/hotels/partenaire", Hotel[].class);
					for(Hotel h:listHotels) {
						if(h.getNom().equals(nomHotel)) {
							hotelExist=true;
							break;
						}
					}
					if(!hotelExist) System.err.println("L'hotel n'existe pas dans cette agence");
					else {
						System.out.println("Le numéro de la chambre");
						inputProcessor = new IntegerInputProcessor(reader);
						numChambre = inputProcessor.process();	
						System.out.println("Date du debut du sejour en format YYYY-MM-DD");
						dateDeb = reader.readLine();
						while(!(matches(dateDeb))){
							System.err.println("La date saisie ne correspond pas au format demandé YYYY-MM-DD");
							System.out.println("Date du debut de sejour en format YYYY-MM-DD");
							dateDeb = reader.readLine();
						}
						System.out.println("La date de le fin du sejour, format YYYY-MM-DD");
						dateFin = reader.readLine();							
						while(!( matches(dateFin))) {
							System.err.println("La date saisie ne correspond pas au format demandé YYYY-MM-DD");
							System.out.println("Date de fin de sejour en format YYYY-MM-DD");
							dateFin = reader.readLine();
						}
						while(!checkValidDate(dateDeb, dateFin)) {
							System.out.println("Veuillez ressaisir des dates valides,\n date du début de séjour supérieure ou égale à la date d'aujourd'hui, \n date de fin de séjour supérieure ou égale à la date du début de séjour");
							System.out.println();
							System.out.println("Date du debut du sejour en format YYYY-MM-DD");
							dateDeb = reader.readLine();
							System.out.println("Date de fin de sejour en format YYYY-MM-DD");
							dateFin = reader.readLine();
						}
						dateD = LocalDate.parse(dateDeb);
					    dateF = LocalDate.parse(dateFin);		
						Map<String, Object> param=new HashMap<String, Object>();						
						param.put("nomHotel", nomHotel);
						param.put("numChambre", numChambre);
						param.put("dateDeb", dateD);
						param.put("dateFin", dateF);
						if(proxy.getForObject(uri+"/hotel/chambre/{nomHotel}/{numChambre}/{dateDeb}/{dateFin}", Boolean.class, param)) {
							System.out.println(" Nom :");
							nomClient=upperLowerCase( reader.readLine());
							System.out.println("Prenom : ");
							prenomClient=upperLowerCase( reader.readLine());
							System.out.println("Nom d'utilisateur :");
							nomUtilisateur=upperLowerCase( reader.readLine());
							System.out.println(" mot de passe :");
							mdpUtilisateur=reader.readLine();
							if(!connexion(uri+"/agence/connexion/{nomUtilisateur}/{mdp}", nomUtilisateur, mdpUtilisateur)) {
								System.err.println("vous n'êtes pas client de l'agence, veuillez vous inscrire d'abord");
								return;
							}else {
								param.put("nomHotel", nomHotel);
								param.put("nomUtilisateur", nomUtilisateur);
								param.put("mdp", mdpUtilisateur);
								param.put("nomClient", nomClient);
								param.put("prenomClient", prenomClient);
								Reservation res=new Reservation(nomUtilisateur, mdpUtilisateur, nomClient, prenomClient, nomHotel, numChambre, dateD, dateF);						
								Reservation reservation=proxy.postForObject(uri+"/reservation/{nomHotel}/{numChambre}/{nomUtilisateur}/{mdp}/{nomClient}/{prenomClient}/{dateDeb}/{dateFin}",res, Reservation.class, param);
							    System.out.println("Reservation reussie, la référence de votre réservation est : "+reservation.getIdReservation()+ "\n Veuillez le garder, vous en aurez besoin en cas de modification ou d'annulation");								   
							}
						}else System.err.println("Chambre indisponible aux dates souhaitées/ numero innexistant");
					}
				}
				break;
			case "6":
				System.out.println("Veuillez saisir les informations suivantes : ");
				System.out.println(" nom de l'agence ou vous avez effectué votre reservation :");
				nomAgence=upperLowerCase( reader.readLine());
				 uri=getUriAgenceByName(nomAgence);
					if(uri.equals(" ")) System.err.println("Le nom de l'agence que vous avez saisi n'existe pas");
					else {
					   /* boolean hotelExist=false;
						System.out.println("Nom hotel :");
						nomHotel=upperLowerCase( reader.readLine());
						Hotel[] listHotels = proxy.getForObject(uri+"/hotels/partenaire", Hotel[].class);
						for(Hotel h:listHotels) {
							if(h.getNom().equals(nomHotel)) {
								hotelExist=true;
								break;
							}
						}
						if(!hotelExist) System.out.println("L'hotel que vous avez saisi n'est pas en partenariat avec l'agence "+nomAgence);
						else {*/			    
							Reservation[] listReservation= proxy.getForObject(uri+"/agence/reservations", Reservation[].class);
							System.out.println(" La référence de votre réservation :");
							refReservation=reader.readLine();
						    boolean existRef=false; 
							for(Reservation reservation: listReservation) {
								 if(reservation.getIdReservation().equals(refReservation)) {
									 existRef=true;
									 dateD= reservation.getDateDeb();
									 LocalDate dateNow = LocalDate.now();
									 long nbJour = ChronoUnit.DAYS.between(dateNow, dateD);
									 if(nbJour>=2) {
										//Map<String, String> params= new HashMap<String, String>();
										//params.put("nomHotel", nomHotel);
										//params.put("refReservation", refReservation);
										 proxy.delete(uri+"/reservation/{refReservation}", refReservation);	
										 System.out.println("Annulation de la reservation "+reservation.getIdReservation());
										 break;
									 }else {
										 System.err.println("Annulation possible uniquement sous 48h");
										 break;
									 }									 
								 }	
							}
							if(!existRef) System.out.println("La réference de reservation"+refReservation+" est innexistante");
						}
					
				break;
				
			case "7": 
				System.out.println("Veuillez saisir le nom de l'agence où vous avez effectué votre réservation");
				nomAgence = upperLowerCase( reader.readLine());
				uri=getUriAgenceByName(nomAgence);
				if(uri.equals(" ")) System.err.println("Le nom de l'agence que vous avez saisi n'existe pas");
				else {
					    //connexion 
						System.out.println("Veuillez vous connecter d'abord à l'agence "+nomAgence );
						System.out.println("Nom d'utilisateur");
						nomUtilisateur=upperLowerCase( reader.readLine());						
						System.out.println("Veuillez saisir votre mot de passe");
						mdpUtilisateur= reader.readLine();
						if(!connexion(uri+"/agence/connexion/{nomUtilisateur}/{mdp}", nomUtilisateur, mdpUtilisateur)) {
							System.err.println("vous n'êtes pas client de l'agence, veuillez vous inscrire d'abord");
							return;
						}
					    HashMap<String, String> params=new HashMap<String, String>();
						params.put("nomUtilisateur",nomUtilisateur);		
						params.put("mdp", mdpUtilisateur);
						Reservation[] reservation = proxy.getForObject(uri+"/agence/client/reservations/{nomUtilisateur}/{mdp}", Reservation[].class, params);
						if(reservation.length==0) 
							System.out.println("Aucune reservation à ce nom n'est effectuée");
						else {	
							for(Reservation res: reservation) {
								System.out.println( res.toString()); 
								System.out.println();
							}	
						}	
						
					}
				break;
				
			case QUIT:
				System.out.println("A bientot!");
				return;		
		
		} 
		}catch (IOException e) {
			e.printStackTrace();
		}	
	}
  
	
}
