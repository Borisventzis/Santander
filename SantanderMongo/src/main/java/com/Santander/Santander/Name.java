package com.Santander.Santander;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Usuarios")
public class Name {

	// fields-----------------------------
	@Id
	
	private String firstName;
	private String lastName;
	private String username;
	
	private ArrayList<Address> address;
	// constructors-----------------------
	public Name() {
		super();
	}
	private String DNI;
	public Name(String dNI, String firstName, String lastName,ArrayList<Address> address) {
		super();
		this.DNI=dNI;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName+"."+lastName;
		this.address = address;
	}
	


	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Address> getAddress() {
		return address;
	}



	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Name [DNI=" + DNI + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ "]";
	}

	
}