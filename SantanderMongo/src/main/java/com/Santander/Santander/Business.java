package com.Santander.Santander;

import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Business {
	
	private String DNI;
	private String creditCardNumber;
	private String creditCardExpiry;
	private String creditCardType;
	
	
	
	public Business(String dNI, String creditCardNumber, String creditCardExpiry, String creditCardType) {
		super();
		DNI = dNI;
		this.creditCardNumber = creditCardNumber;
		this.creditCardExpiry = creditCardExpiry;
		this.creditCardType = creditCardType;
	}




	public Business(com.github.javafaker.Business business) {
		// TODO Esbozo de constructor generado automáticamente
	}




	public Business(String string, com.github.javafaker.Business business) {
		// TODO Esbozo de constructor generado automáticamente
	}




	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public String getCreditCardNumber() {
		return creditCardNumber;
	}



	public void setCreditCardNumber(String business) {
		this.creditCardNumber = business;
	}



	public String getCreditCardExpiry() {
		return creditCardExpiry;
	}



	public void setCreditCardExpiry(String creditCardExpiry) {
		this.creditCardExpiry = creditCardExpiry;
	}



	public String getCreditCardType() {
		return creditCardType;
	}



	public void setCreditCardType(String business) {
		this.creditCardType = business;
	}



	@Override
	public String toString() {
		return "Business [DNI=" + DNI + ", creditCardNumber=" + creditCardNumber + ", creditCardExpiry="
				+ creditCardExpiry + ", creditCardType=" + creditCardType + "]";
	}

	
	
	
}
