package com.Santander.Santander;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Job {

	private String DNI;
	private String keySkills;
	private String position;
	private String seniority;
	private String title;
	
	public Job(String dNI, String keySkills, String position, String seniority, String title) {
		super();
		DNI = dNI;
		this.keySkills = keySkills;
		this.position = position;
		this.seniority = seniority;
		this.title = title;
	}

	public Job() {
		super();
		
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getKeySkills() {
		return keySkills;
	}

	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Job [DNI=" + DNI + ", keySkills=" + keySkills + ", position=" + position + ", seniority=" + seniority
				+ ", title=" + title + "]";
	}
	
	

	
	
	
	
}
