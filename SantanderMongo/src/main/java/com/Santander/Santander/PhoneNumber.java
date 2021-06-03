package com.Santander.Santander;

import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class PhoneNumber {
	
	private String DNI;
	private String cellPhone;
	
	
	public PhoneNumber(String dNI, String cellPhone) {
		super();
		DNI = dNI;
		this.cellPhone = cellPhone;
	}


	public PhoneNumber() {
		super();
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getCellPhone() {
		return cellPhone;
	}


	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}


	@Override
	public String toString() {
		return "PhoneNumber [DNI=" + DNI + ", cellPhone=" + cellPhone + "]";
	}
	
	
	
	
	
}