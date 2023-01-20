package com.agence.rest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Agence {

	@Id
	private String idAgence;
	private String codeAgence;
	private int pourcentage;
	private String uri;
	
	public Agence() {
	}

	public Agence(String idAgence, String codeAgence, int pourcentage,String uri) {
		this.idAgence = idAgence;
		this.codeAgence = codeAgence;
		this.pourcentage = pourcentage;
		this.uri = uri;
	}
	
	
	
	public String getId() {
		return idAgence;
	}

	public void setId(String id) {
		this.idAgence = id;
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}



	public String getCodeAgence() {
		return codeAgence;
	}



	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	public double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
}
