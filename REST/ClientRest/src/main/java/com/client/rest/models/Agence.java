package com.client.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Agence {
	
	private String idAgence;
	private String code;
	private int pourcentage;
	
	public Agence() {}

	public Agence(String idAgence, String code,int pourcentage) {
		this.idAgence = idAgence;
		this.code = code;
		this.pourcentage = pourcentage;
	}

	public String getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(String idAgence) {
		this.idAgence = idAgence;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage(int pourcentage) {
		this.pourcentage = pourcentage;
	}

	@Override
	public String toString() {
		return "Agence [idAgence=" + idAgence + ", pourcentage=" + pourcentage + "%]";
	}
	
	

}
