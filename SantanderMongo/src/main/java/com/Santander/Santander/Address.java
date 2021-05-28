package com.Santander.Santander;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;
///Classe Address1235645
@Document
public class Address {

	private String DNI;
	private String fullAddress;
	private	String City;
	private String state;
	private int streetAddressNumber;
	private String streetName;
	private long zipCode;
	
	
	
	
	public Address(String dNI, String city, String state, int streetAddressNumber, String streetName, long zipCode) {
		super();
		DNI = dNI;
		City = city;
		this.state = state;
		this.streetAddressNumber = streetAddressNumber;
		this.streetName = streetName;
		this.zipCode = zipCode;
	}
	
	public Address(String fullAddress) {
		super();
		this.fullAddress = fullAddress;
	}

	public Address() {
		super();
	}

	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = this.state+" "+this.City+" "+this.streetName+" "+this.streetAddressNumber+" "+this.zipCode;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getStreetAddressNumber() {
		return streetAddressNumber;
	}
	public void setStreetAddressNumber(int streetAddressNumber) {
		this.streetAddressNumber = streetAddressNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [DNI=" + DNI + ", fullAddress=" + fullAddress + ", City=" + City + ", state=" + state
				+ ", streetAddressNumber=" + streetAddressNumber + ", streetName=" + streetName + ", zipCode=" + zipCode
				+ "]";
	}
	
	
}
