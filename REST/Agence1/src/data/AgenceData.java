package com.agence.rest.data;

import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.agence.rest.models.Agence;
import com.agence.rest.models.Hotel;
import com.agence.rest.repository.AgenceRepository;
import com.agence.rest.repository.HotelRepository;

@Configuration
public class AgenceData {

private Logger logger = LoggerFactory.getLogger(AgenceData.class);
	
	@Bean 
	public CommandLineRunner initDatabaseAgence(AgenceRepository repository) {
		return args -> {
			logger.info("Preloading database with"+ repository.save(
					new Agence("Tour", "tour1", 20, "http://localhost:8082/tour/api")
					));
		};	
	}
	 
	@Bean 
	public CommandLineRunner initDatabaseHotel(HotelRepository repository) {
		return args -> {
			logger.info("Preloading database with"+ repository.save(
					new Hotel("http://localhost:8080/hotelService/api", "Atlantis", "France", "Montpellier", " rue FBG", 119," Boutonnet" ,"0051", 150,
							"troisEtoiles")
						));  
			logger.info("Preloading database with"+ repository.save(
					new  Hotel("http://localhost:8081/deLaGareService/api","Delagare", "France","Nancy" ,"rue de la liberté ", 115, "birel","12.4,80.322" , 100, "deuxEtoiles")
						));
			/*logger.info("Preloading database with"+ repository.save(
					new Hotel("http://localhost:8082/paris/data"," Parisien", "France", "Paris", " rue pompidor", 19," louis" ,"0051", 25, 100,
							nombreEtoile.uneEtoile)
						));*/
			
		};
	
	}
}

