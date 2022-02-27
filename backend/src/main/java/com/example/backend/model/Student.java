package com.example.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student { 

	
	 @Transient
	 public static final String SEQUENCE_NAME = "user_sequence"; 
	

	@Id
	String id;
	String name;
	String standard;
	String division;
	String gender;
	String dob;
	int rollNumber;
	
	
	
	public Student(String name, String standard, String division, String gender, String dob, int rollNumber) {
		this.name = name;
		this.standard = standard;
		this.division = division;
		this.gender = gender;
		this.dob = dob;
		this.rollNumber = rollNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getRollNumber() {
       return rollNumber;
	}
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getSequenceName() {
		return SEQUENCE_NAME;
	}

    
    
	
}
