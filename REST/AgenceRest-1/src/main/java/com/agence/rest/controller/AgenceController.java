package com.agence.rest.controller;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.agence.rest.exception.NotFoundException;
import com.agence.rest.models.Agence;
import com.agence.rest.models.Client;
import com.agence.rest.models.Hotel;
import com.agence.rest.models.Reservation;
import com.agence.rest.repository.AgenceRepository;
import com.agence.rest.repository.ClientRepository;
import com.agence.rest.repository.HotelRepository;
import com.agence.rest.repository.ReservationRepository;

@RestController
public class AgenceController  {
	
	private static final String uri ="tour/api";
	private static final String reservationUri="/reservation/{dateDeb}/{dateFin}/{nbrPersonnes}/{pourcentage}";
	
	@Autowired
	private RestTemplate proxy;

	@Autowired
	private AgenceRepository repositoryAgence;
	@Autowired
	private HotelRepository repositoryHotel;
	@Autowired
	private ReservationRepository repositoryReservation;
	@Autowired
	private ClientRepository repositoryClient;
	
	@GetMapping(uri+"/agences")
	public List<Agence> getAllAgences(){
		return repositoryAgence.findAll(); 
	}
	@GetMapping(uri+"/agence")
	public Agence getAgence() {
		return (getAllAgences()).get(0);
	}
	
	@GetMapping(uri+"/hotels")
	public List<Hotel> getAllHotels(){
		return repositoryHotel.findAll();
	}
	
	@GetMapping(uri+"/hotels/partenaire")
	public List<Hotel> getAllHotelPartenaire(){
		String hotelUri;
	    Agence agence= getAgence();
		String nomAgence= agence.getId();
		String code= agence.getCodeAgence();
		List<Hotel> listHotel= getAllHotels();
		List<Hotel> listHotelsPartenaires=new ArrayList<Hotel>();
		if(listHotel.isEmpty()) return listHotelsPartenaires;
		for(Hotel hotel:listHotel) {
			 hotelUri = hotel.getUri()+"/agence/{name}/{code}";
			 Map<String, String> params=new HashMap<String, String>();
			 params.put("name", nomAgence);
			 params.put("code", code);
			 agence = proxy.getForObject(hotelUri, Agence.class, params);
			if(!(agence.equals(null))) listHotelsPartenaires.add(hotel);
		}
		return listHotelsPartenaires;	
	}
	
	@GetMapping(uri+"/hotels/{pays}/{ville}/{nbEtoile}/{prixMax}") 
	public List<Hotel> getHotelCritere (@PathVariable String pays, @PathVariable String ville, @PathVariable int nbEtoile, @PathVariable double prixMax)throws NotFoundException, IllegalArgumentException{
		double pourcentage= getAgence().getPourcentage();
		List<Hotel> listHotels = getAllHotelPartenaire();
		List<Hotel> hotels = new ArrayList<Hotel>();
		for(Hotel hotel : listHotels) {
			double prixBase=hotel.getPrixMax();
			double prix = prixBase+((prixBase*pourcentage)/100);
			if(hotel.getPays().equals(pays) && hotel.getVille().equals(ville) && hotel.nbrEtoiles(nbEtoile).equals(hotel.getCategorie()) && prix<=prixMax) {
				hotel.setPrixMax(prix);
				hotels.add(hotel);
			}
		}
		return hotels;
	}
	
	@GetMapping(uri+"/hotels/chambres/{pays}/{ville}/{nbEtoile}/{prixMax}/{nbrPersonnes}/{dateDeb}/{dateFin}")
	public String afficherChambreDispo(@PathVariable String pays, @PathVariable String ville, @PathVariable int nbEtoile, @PathVariable double prixMax, @PathVariable int nbrPersonnes,  @PathVariable LocalDate dateDeb, @PathVariable LocalDate dateFin) throws NotFoundException, IllegalArgumentException {
		double pourcentage= getAgence().getPourcentage();
		String hotelUri;
		String nomHotel=" ";
		String chambreDispo=" ";
		List<Hotel> hotelsPartenaire= getHotelCritere(pays, ville,nbEtoile, prixMax);
		if(hotelsPartenaire.isEmpty()) return "Aucun hotel correspondant aux critères saisies";
		for(Hotel hotel: hotelsPartenaire) {
			nomHotel=hotel.toString(pourcentage)+"\n";
			 hotelUri = hotel.getUri()+reservationUri;
			 Map<String, Object> paramsDate=new HashMap<String, Object>();
			 paramsDate.put("dateDeb", dateDeb);
			 paramsDate.put("dateFin", dateFin );
			 paramsDate.put("nbrPersonnes", nbrPersonnes);
			 paramsDate.put("prixMax", prixMax);
			 paramsDate.put("pourcentage", pourcentage);
			 chambreDispo += proxy.getForObject(hotelUri, String.class, paramsDate)+"\n";	
			 if(!chambreDispo.equals(" ")) chambreDispo=nomHotel+"\n"+chambreDispo;
		}
		if(chambreDispo.equals(" ")) return "Aucun hotel correspondant aux critères saisies"; 
		return chambreDispo;
	}
	
	public Hotel ExistHotel(String nomHotel) {
		List<Hotel> hotels= getAllHotelPartenaire();
		for(Hotel hotel: hotels) {
			if(hotel.getNom().equals(nomHotel)) return hotel;
		}
		return null;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/reservation/{nomHotel}/{numChambre}/{nomUtilisateur}/{mdp}/{nomClient}/{prenomClient}/{dateDeb}/{dateFin}")
	public Reservation createReservation(@RequestBody @PathVariable String nomHotel, @PathVariable int numChambre, @PathVariable String nomUtilisateur,@PathVariable String mdp,@PathVariable String nomClient, @PathVariable String prenomClient, @PathVariable LocalDate dateDeb, @PathVariable LocalDate dateFin){
		Hotel hotel = ExistHotel(nomHotel);
		if(hotel.equals(null))  return null; /*"L'hotel que vous demandez n'existe pas";*/
		Reservation reservation= new Reservation(nomUtilisateur,mdp,nomClient, prenomClient, nomHotel, numChambre, dateDeb, dateFin);
		repositoryReservation.save(reservation);
		String hotelUri=hotel.getUri()+"/hotel/{nomHotel}/{num}/{dateDeb}/{dateFin}/{nomClient}/{prenomClient}/{nomUtilisateur}/{mdp}";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("nomHotel", nomHotel);
		params.put("num", numChambre);
		params.put("dateDeb", dateDeb);
		params.put("dateFin", dateFin);
		params.put("nomClient", nomClient);
		params.put("prenomClient", prenomClient);		
		params.put("nomUtilisateur", nomUtilisateur);
		params.put("mdp", mdp);
		Reservation reserv = proxy.postForObject(hotelUri, reservation, Reservation.class,params);
		return reserv;
	}
	
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(uri+"/reservation/{refReservation}")
	public void deleteReservation(@PathVariable String refReservation ) throws NotFoundException {
		List<Hotel> listHotels=getAllHotelPartenaire();
		List<Reservation> reservations= getAllReservation();
		String nomHotel;
		for(Reservation reservation: reservations) {
			if(reservation.getIdReservation().equals(refReservation)){
				nomHotel=reservation.getNomHotel();
				for(Hotel hotel: listHotels) {
					if(hotel.getNom().equals(nomHotel)) {							
							String uri=hotel.getUri()+"/reservation/{refReservation}";	
							repositoryReservation.delete(reservation);
							proxy.delete(uri, refReservation);	
						    break;
					}
				 }
			}
		}			    
	}
		
	
	
	
	@GetMapping(uri+"/hotel/chambre/{nomHotel}/{numChambre}/{dateDeb}/{dateFin}")
	public boolean verifyChambreHotel(@PathVariable String nomHotel, @PathVariable int numChambre, @PathVariable LocalDate dateDeb, @PathVariable LocalDate dateFin) {
		Hotel hotel= ExistHotel(nomHotel);
		String uriHotel=hotel.getUri()+"/chambreDispo/{numChambre}/{dateDeb}/{dateFin}";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("numChambre", numChambre);
		params.put("dateDeb", dateDeb);
		params.put("dateFin", dateFin);
		return  proxy.getForObject(uriHotel, Boolean.class,params);	
	}
	

	@GetMapping(uri+"/agence/clients")
	public List<Client> getAllClients(){
		return repositoryClient.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/agence/inscription/{nom}/{prenom}/{nomUtilisateur}/{mdp}")
	public boolean inscription(@PathVariable String nom, @PathVariable String prenom,@PathVariable String nomUtilisateur ,@PathVariable String mdp) {
		List<Client> listClients = getAllClients();
		for(Client client : listClients) {
			if(client.getNomUtilisateur().equals(nomUtilisateur)) return false;
		}
		 repositoryClient.save(new Client(nom,prenom,nomUtilisateur, mdp));	
		 return true;
	}
	
	@GetMapping(uri+"/agence/connexion/{nomUtilisateur}/{mdp}")
	public boolean connexion(@PathVariable String nomUtilisateur,@PathVariable String mdp) {
		List<Client> listClients = getAllClients();
		for(Client client : listClients) {
			if(client.getNomUtilisateur().equals(nomUtilisateur) && client.getMdp().equals(mdp)) return true;
		}
		return false;
	}
	
	@GetMapping(uri+"/agence/reservations")
	public List<Reservation> getAllReservation(){
		return repositoryReservation.findAll();
	}
	
	
	@GetMapping(uri+"/agence/client/reservations/{nomUtilisateur}/{mdp}")
	public List<Reservation> getClientReservation(@PathVariable String nomUtilisateur, @PathVariable String mdp) {
		List<Reservation> listReserv = getAllReservation();
		List<Reservation> reservationClient = new ArrayList<Reservation>();
		for(Reservation reservation : listReserv) {
			if(reservation.getNomutilisateur().equals(nomUtilisateur) && reservation.getMdp().equals(mdp)) reservationClient.add(reservation); 
		}
		return reservationClient;
	}
	
	
	@GetMapping(uri+"/agence/uri/{name}")
		public String getUriByName(@PathVariable String name) {
		Agence agence= getAllAgences().get(0);
			if(agence.getIdAgence().equals(name)) return agence.getUri();
		return "null";
	}
	
	
}
