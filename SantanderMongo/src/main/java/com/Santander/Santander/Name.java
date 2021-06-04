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
	private PhoneNumber phone;
	private ArrayList<Address> address;
	private Job job;
	private Business business;
	// constructors-----------------------
	
	private String DNI;
	
	

	public Name() {
		super();
	}
	

	public Name(String dNI, String firstName, String lastName,Job job, Business business,PhoneNumber phone,ArrayList<Address> address) {
		super();
		this.DNI=dNI;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName+"."+lastName;
		this.phone=phone;
		this.address = address;
		this.job=job;
		this.business=business;
	}
	

	

	public PhoneNumber getPhone() {
		return phone;
	}

	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


	public Business getBusiness() {
		return business;
	}


	public void setBusiness(Business business) {
		this.business = business;
	}


	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
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

	public ArrayList<Address> getAddress() {
		return address;
	}



	public void setAddress(ArrayList<Address> list) {
		this.address = list;
	}


	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", phone=" + phone
				+ ", address=" + address + ", job=" + job + ", business=" + business + ", DNI=" + DNI + "]";
	}




	
}