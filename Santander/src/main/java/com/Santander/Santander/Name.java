package com.Santander.Santander;

/*import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;*/
/*
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
*/

//@Entity
//@Table(name = "Name")

public class Name {

	
	
	//fields-----------------------------
	
	private long DNI;
	private String fullName ;
	private String firstName;
	private String lastName;
	private String Name;
	private String username;

	
	//constructors-----------------------
	public Name() {
		super();
	}

	public Name(String fullName, String firstName, String lastName, String name, String username) {
		super();
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		Name = name;
		this.username = username;
	}


	public Name(long dNI, String fullName, String firstName, String lastName, String name, String username) {
		super();
		DNI = dNI;
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		Name = name;
		this.username = username;
	}
	public long getDNI() {
		return DNI;
	}


	public void setDNI(long dNI) {
		DNI = dNI;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
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


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return "Name [DNI=" + DNI + ", fullName=" + fullName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Name=" + Name + ", username=" + username + "]";
	}

}