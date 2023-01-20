package com.hotel.rest.data;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hotel.rest.model.Agence;
import com.hotel.rest.model.Chambre;
import com.hotel.rest.model.Chambre.typeChambre;
import com.hotel.rest.model.Hotel;
import com.hotel.rest.repositories.AgenceRepository;
import com.hotel.rest.repositories.ChambreRepository;
import com.hotel.rest.repositories.HotelRepository;


@Configuration
public class HotelData {
	/* ATTRIBUTES  */
	private Logger logger = LoggerFactory.getLogger(HotelData.class);
	
	@Bean 
	public CommandLineRunner initDatabaseHotel(HotelRepository repository) {
		return args -> {
			logger.info("Preloading database with"+ repository.save(
				new Hotel("Atlantis", "France", "Montpellier", "rue FBG", 119,"Boutonnet" ,"0051", 150,
						"troisEtoile")	
					));
		};	
	}
	@Bean 
	public CommandLineRunner initDatabaseChambre(ChambreRepository repository) {
		return args -> {
			logger.info("Preloading database with"+ repository.save(
				new Chambre(1,typeChambre.simple,35)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(2,typeChambre.simple,35)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(3,typeChambre.DoubleConfort,55)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(4,typeChambre.DoubleConfort,55)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(5,typeChambre.TripleFamiliale,84)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(6,typeChambre.TripleFamiliale,84)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(7,typeChambre.QuadrupleFamiliale,111)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(8,typeChambre.QuadrupleFamiliale,111)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(9,typeChambre.quintuple,150)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(10,typeChambre.quintuple,150)
			));
			logger.info("Preloading database with"+ repository.save(
					new Chambre(11,typeChambre.quintuple,150)
			));
		};	
	}
	
	@Bean 
	public CommandLineRunner initDatabaseAgence(AgenceRepository repository) {
		return args -> {
			logger.info("Preloading database with"+ repository.save(
				new Agence("Fly", "fly1", 10)
					));
			logger.info("Preloading database with"+ repository.save(
					new Agence("Tour", "tour1", 20)
						));
		};	
	}
	

	
	
	
	
	
}
