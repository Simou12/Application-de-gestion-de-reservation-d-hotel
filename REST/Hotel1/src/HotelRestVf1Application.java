package com.hotel.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
		"com.hotel.rest.model"	
})
@EnableJpaRepositories(basePackages = {
		"com.hotel.rest.repositories"		
})
@SpringBootApplication(scanBasePackages = {
		"com.hotel.rest.data",
		"com.hotel.rest.exception",
		"com.hotel.rest.controller"
})
public class HotelRestVf1Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelRestVf1Application.class, args);
	}

}
