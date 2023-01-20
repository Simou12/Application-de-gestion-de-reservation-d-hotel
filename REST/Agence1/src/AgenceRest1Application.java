package com.agence.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {
		"com.agence.rest.models"	
})
@EnableJpaRepositories(basePackages = {
		"com.agence.rest.repository"		
})
@SpringBootApplication(scanBasePackages = {
		"com.agence.rest.data",
		"com.agence.rest.repository",
		"com.agence.rest.models",
		"com.agence.rest.controller", 
		"com.agence.rest.client"
		
		
})
public class AgenceRest1Application {

	public static void main(String[] args) {
		SpringApplication.run(AgenceRest1Application.class, args);
	}

}
