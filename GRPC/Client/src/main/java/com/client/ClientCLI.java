
package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import java.util.regex.Pattern;


import com.resHotel.grpc.reservationGrpc;
import com.resHotel.grpc.Reservation.ApiRes;
import com.resHotel.grpc.Reservation.CritereReservation;
import com.resHotel.grpc.Reservation.c;
import com.resHotel.grpc.Reservation.deleteRef;
import com.resHotel.grpc.Reservation.deleteResultat;
import com.resHotel.grpc.reservationGrpc.reservationBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;



public class ClientCLI extends AbstractMain  {

	/*ATTRIBUT*/

	private IntegerInputProcessor inputProcessor;
	private  Pattern DATE_PATTERN = Pattern.compile(
			"^((2000|2400|2800|(19|2[0-9])(0[48]|[2468][048]|[13579][26]))-02-29)$" 
					+ "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
					+ "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" 
					+ "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

	/*METHODES*/

	public  boolean matches(String date) {
		return DATE_PATTERN.matcher(date).matches();
	}
	public boolean checkValidDate(String dateD, String dateF) {
		LocalDate now= LocalDate.now();
		LocalDate dateDeb=LocalDate.parse(dateD);
		LocalDate dateFin= LocalDate.parse(dateF);
		return ((now.isBefore(dateDeb) || now.equals(dateDeb) )  && (dateFin.isAfter(dateDeb) ||  dateFin.equals(dateDeb)) )  ;	
	}

	public String upperLowerCase(String string) {
		return ((string.charAt(0)+"").toUpperCase()+(string.substring(1)).toLowerCase());
	}



	public static void main(String... args) throws Exception {
		BufferedReader inputReader;
		String userInput = "";
		ClientCLI client=new ClientCLI();

		try {
			inputReader = new BufferedReader(new InputStreamReader(System.in));

			ManagedChannel channel= ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
			//stubs generated from protofile
			reservationBlockingStub hotelStub = reservationGrpc.newBlockingStub(channel);


			do {
				client.menu();
				userInput = inputReader.readLine();
				client.processUserInput(inputReader,userInput,hotelStub);
				Thread.sleep(3000);

			} while(!userInput.equals(QUIT));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	protected void menu() {
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit");
		builder.append("\n1. Trouvez une chambre selon vos critères ");
		builder.append("\n2. Effectuer une reservation");
		builder.append("\n3. Supprimer une reservation ");
		System.out.println(builder);	
	}


	private void processUserInput(BufferedReader reader, String userInput, reservationBlockingStub hotelStub) throws IllegalAccessException {
		String  dateDeb, dateFin, nomClient, prenomClient, refReservation;
		int prixMax, nbPersonne, numChambre; 
		try {
			switch(userInput) {	
			case "1":
				System.out.println("Veuillez saisir vos critères ");
				System.out.println("Le prix Maximum (Budget) :");
				inputProcessor = new IntegerInputProcessor(reader);
				prixMax = inputProcessor.process();
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

				System.out.println((hotelStub.afficherChambreDispo(c.newBuilder().setDateDeb(dateDeb).setDateFin(dateFin).setNbPersonne(nbPersonne).setPrix(prixMax).build())).getChambreDispo());

				break;

			case "2": 
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
				System.out.println(" Nom :");
				nomClient=upperLowerCase( reader.readLine());
				System.out.println("Prenom : ");
				prenomClient=upperLowerCase( reader.readLine());
				CritereReservation reservation= CritereReservation.newBuilder().setNumChambre(numChambre).setNomClient(nomClient).setPrenomClient(prenomClient).setDateDeb(dateDeb).setDateFin(dateFin).build();
				ApiRes responseRes= hotelStub.reserverChambre(reservation);
				System.out.println(responseRes.getResMessage());
				break;

			case "3":
				System.out.println(" La référence de votre réservation :");
				refReservation=reader.readLine();
				deleteRef deleteReq=deleteRef.newBuilder().setRefReservation(refReservation).build();
				deleteResultat deleteRes= hotelStub.deleteReservation(deleteReq);
				System.out.println(deleteRes.getResMessage());
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
