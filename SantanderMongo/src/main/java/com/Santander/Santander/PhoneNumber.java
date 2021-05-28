package com.Santander.Santander;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PhoneNumber")

public class PhoneNumber {

	
	//-----Fields------
@Id
private String cellPhone;

//------Constructors-----
public PhoneNumber(String cellPhone) {
	super();
}

private String DNI;

public PhoneNumber(String cellPhone, String dNI) {
	super();
	this.cellPhone = cellPhone;
	this.DNI = dNI;
}

public String getCellPhone() {
	return cellPhone;
}

public void setCellPhone(String cellPhone) {
	this.cellPhone = cellPhone;
}

public String getDNI() {
	return DNI;
}

public void setDNI(String dNI) {
	DNI = dNI;
}

@Override
public String toString() {
	return "PhoneNumber [cellPhone=" + cellPhone + ", DNI=" + DNI + "]";
}



	
}
