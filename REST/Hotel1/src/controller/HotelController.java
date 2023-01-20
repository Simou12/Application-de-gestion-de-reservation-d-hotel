package com.hotel.rest.controller;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.rest.exception.NotFoundException;
import com.hotel.rest.model.Agence;
import com.hotel.rest.model.Chambre;
import com.hotel.rest.model.Hotel;
import com.hotel.rest.model.Reservation;
import com.hotel.rest.repositories.AgenceRepository;
import com.hotel.rest.repositories.ChambreRepository;
import com.hotel.rest.repositories.HotelRepository;
import com.hotel.rest.repositories.ReservationRepository;

@RestController
public class HotelController {
	@Autowired
	private HotelRepository repositoryHotel;
	@Autowired
	private AgenceRepository repositoryAgence;
	@Autowired
	private ChambreRepository repositoryChambre;
	@Autowired
	private ReservationRepository repositoryReservation;
	private static final String uri ="deLaGareService/api";
	
	@GetMapping(uri+"/hotel")
	public List<Hotel> getAllHotels(){
		return repositoryHotel.findAll();
	}
	
	@GetMapping(uri+"/hotel/{id}")
	public Hotel getHotelById(@PathVariable long id) throws NotFoundException{
		return repositoryHotel.findById(id).orElseThrow(() -> 
		new NotFoundException("Error : could find the hotel with id"+id));	
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/hotel")
	public Reservation createReservation(@RequestBody Reservation reservation ) {
		return repositoryReservation.save(reservation);	
	}
	@GetMapping(uri+"/chambreDispo/{numChambre}/{dateDeb}/{dateFin}")
	public boolean verifyChambreDispo(@PathVariable int numChambre, @PathVariable LocalDate dateDeb, @PathVariable LocalDate dateFin) {
		List<Chambre> listChambre= getAllChambres();
		List<Reservation> listReservation= getAllReservation();
		boolean isDispo=false;
		for(Chambre chambre: listChambre) {
			if(chambre.getNumeroChambre()==numChambre) {
				isDispo=true;
				for(Reservation reservation: listReservation) {
                    if(reservation.getNumChambre()==numChambre) {
                    	LocalDate dateDR=reservation.getDateDeb();
                        LocalDate dateFR=reservation.getDateFin();
                        if(( dateDeb.isBefore(dateFR) && (dateDeb.isEqual(dateDR)   || dateDeb.isAfter(dateDR) )) || ( ( dateFin.isBefore(dateFR) && (dateFin.isEqual(dateDR)   || dateFin.isAfter(dateDR) ) ) ))
                             return false;
                    }         
                 }
            	
			}
		}
		return isDispo;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri+"/hotel/{nomHotel}/{num}/{dateDeb}/{dateFin}/{nomClient}/{prenomClient}/{nomUtilisateur}/{mdp}")
	public Reservation createReservation1(@RequestBody @PathVariable String nomHotel, @PathVariable String nomClient,  @PathVariable String prenomClient,  @PathVariable int  num, @PathVariable String nomUtilisateur, @PathVariable String mdp, @PathVariable LocalDate dateDeb, @PathVariable LocalDate dateFin) {
					return repositoryReservation.save(new Reservation(nomUtilisateur,mdp,nomClient,prenomClient,nomHotel,num, dateDeb, dateFin));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(uri+"/reservation/{refReservation}")
	public void deleteReservation(@PathVariable String refReservation ) throws NotFoundException {
		 List<Reservation> listReservation= getAllReservation();
		 for(Reservation reservation: listReservation) {
			 if(reservation.getIdReservation().equals(refReservation)) 	 repositoryReservation.delete(reservation);
			 
		 }	
	}

	@GetMapping(uri+"/chambre/{id}")
	public Chambre getChambreById(@PathVariable long id) throws NotFoundException{
		return repositoryChambre.findById(id).orElseThrow(() -> 
		new NotFoundException("Error : could find the room with id"+id));	
	}
	
	@GetMapping(uri+"/chambre")
    public List<Chambre> getAllChambres(){
        return repositoryChambre.findAll();
    }
	
	@GetMapping(uri+"/chambre/{prixMax}")
    public List<Chambre> getChambreByPrix(@PathVariable double prixMax) throws NotFoundException{
        List<Chambre> listChambres =getAllChambres();
        List<Chambre> listChambresCritere = new ArrayList<Chambre>();
        for(Chambre chambre: listChambres) {
            if(chambre.getPrix()<=prixMax  ) {
                listChambresCritere.add(chambre);
            }
        }
        return listChambresCritere;
    }
	
	
	@GetMapping(uri+"/chambre/{prixMax}/{nbrPersonnes}")
    public List<Chambre> getChambreByPrix(@PathVariable double prixMax, @PathVariable int nbrPersonnes) throws NotFoundException{
        List<Chambre> listChambres =getAllChambres();
        List<Chambre> listChambresCritere = new ArrayList<Chambre>();
        for(Chambre chambre: listChambres) {
            if(chambre.getPrix()<=prixMax  && (chambre.getTypeNbrPersonne(nbrPersonnes)+"").equals(chambre.getType())) {
                listChambresCritere.add(chambre);
            }
        }
        return listChambresCritere;
    }
	
	@GetMapping(uri+"/reservation")
	public List<Reservation> getAllReservation(){
		return repositoryReservation.findAll();
	}

	@GetMapping(uri+"/reservation/{dateDeb}/{dateFin}/{nbrPersonnes}/{pourcentage}")
    public String getChambreDispo(@PathVariable LocalDate dateDeb, @PathVariable LocalDate dateFin,@PathVariable  int nbrPersonnes, @PathVariable double pourcentage ) throws NotFoundException {
        List<Reservation> listReservation= getAllReservation();
        List<Chambre> listChambres =getAllChambres();
        double prixBase=0;
        String chambreDispo = "";
        	if(listReservation.isEmpty()) {
                 for(Chambre chambre : listChambres) {
                    if((chambre.getTypeNbrPersonne(nbrPersonnes)+"").equals(chambre.getType())){
                    	 prixBase=chambre.getPrix();
                    	 chambreDispo+="Chambre numéro : "+chambre.getNumeroChambre()+" ,type : "+chambre.getType()+" prix basique :" +prixBase+" ,Prix incluant les frais d'agence: "+((double)prixBase+((double)prixBase*(pourcentage/100))) +"\n";
                    }
                }
        		return chambreDispo;
        	}
            boolean ischambreDispo=false;
        	 for(Chambre chambre : listChambres) {
                 ischambreDispo=false;
                 if((chambre.getTypeNbrPersonne(nbrPersonnes)+"").equals(chambre.getType())){
                    ischambreDispo=true;
                    for(Reservation reservation: listReservation) {
                        LocalDate dateDR=reservation.getDateDeb();
                        LocalDate dateFR=reservation.getDateFin();
                        if(reservation.getNumChambre()==chambre.getNumeroChambre()) {
                            if(( dateDeb.isBefore(dateFR) && (dateDeb.isEqual(dateDR)   || dateDeb.isAfter(dateDR) )) || ( ( dateFin.isBefore(dateFR) && (dateFin.isEqual(dateDR)   || dateFin.isAfter(dateDR) ) ) )){
                                ischambreDispo=false;
                            }
                        }   
                    }
                 }
                 if(ischambreDispo) {
                	 prixBase=chambre.getPrix();
                	 chambreDispo+="Chambre numéro : "+chambre.getNumeroChambre()+" ,type : "+chambre.getType()+"prix basique : "+prixBase+ " prix incluant les frais d'agence "+((double)prixBase+((double)prixBase*(pourcentage/100)))+"\n";
	        }	}
        
         return chambreDispo;
    }
	
	
	@GetMapping(uri+"/agences")
	public List<Agence> getAllAgencePartenaire(){
		return repositoryAgence.findAll();
	}
	
	@GetMapping(uri+"/agence/{name}/{code}")
    public Optional<Agence> isAgencePartenaire(@PathVariable String name, @PathVariable String code) throws NotFoundException {
        Optional<Agence> agence= repositoryAgence.findById(name);
        if((agence.get().getCode()).equals(code)) return agence;
        
        return null;
    }
	
	
	

}
