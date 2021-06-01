package com.Santander.Santander;

import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class PhoneNumber {
	
	private String DNI;
	private String cellPhone;
	
	
	/*public PhoneNumber(String dNI,PhoneNumber phoneNumber) {
		super();
		DNI = dNI;
		this.cellPhone = phoneNumber;
	}*/

	/*
	 * public PhoneNumber(com.github.javafaker.PhoneNumber phoneNumber) { // TODO
	 * Esbozo de constructor generado automáticamente }
	 */

	public PhoneNumber(String cellPhone) {
		super();
		this.cellPhone = cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(String dNI, com.github.javafaker.PhoneNumber phoneNumber) {
		// TODO Esbozo de constructor generado automáticamente
	}

	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	/*
	 * public PhoneNumber getCellPhone() { return cellPhone; }
	 * 
	 * 
	 * public void setCellPhone(PhoneNumber phonenumber) { this.cellPhone =
	 * phonenumber; }
	 */

	@Override
	public String toString() {
		return "PhoneNumber [DNI=" + DNI + ", cellPhone=" + cellPhone + "]";
	}
	
	
	
	
}