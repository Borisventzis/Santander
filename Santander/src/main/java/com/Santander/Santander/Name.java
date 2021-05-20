package com.Santander.Santander;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Name")
public class Name {

	// fields-----------------------------
	@Id
	private long DNI;
	public Name(long dNI, String firstName, String lastName) {
		super();
		DNI = dNI;
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.username = firstName+"."+lastName;
	}

	private String firstName;
	private String lastName;
	private String username;

	// constructors-----------------------
	public Name() {
		super();
	}


	public long getDNI() {
		return DNI;
	}

	public void setDNI(long dNI) {
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


	@Override
	public String toString() {
		return "Name [DNI=" + DNI + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ "]";
	}

	
}