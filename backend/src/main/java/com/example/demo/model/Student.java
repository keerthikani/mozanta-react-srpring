package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constrains.NotNull;


import lombok.Data;
@Document(collection = "student")
public class Student{
    
   @Transient
   public static final String SEQUENCE_NAME = "user_sequence";


   @Id
    String id;
    String userName;
    String dob;
    String standard;
    String division;
    String gender;
    
 
    public Student(String id, String name, String dob, String clas, String division, String gender) {

        this.id = id;
        this.username = username;
        this.dob = dob;
        this.standard = standard;
        this.division = division;
        this.gender  = gender;
    }  



 public String getId(){
    return id;
 }
 public void setId(String id) {
    this.id = id;
 }

 public String getuserName(){
    return name;
 }

 public void setuserName() {
    this.userName = userName;
 }
 public String getDob(){
    return dob;
 }
 public void setDob(String dob) {
    this.dob = dob; 
    
 }

 public string getStandard() {
    return standard;
    
 }
 public void setStandard() {
    this.standard = standard;
    
 }

 public string getDivision() {
    return division;
    
 }
 public void setDivision() {
    this.division = division;
    
 }

public string getGender() {
    return gender;
    
  }
 public void setGender() {
    this.gender = gender;
    
 }
 public static String getSequenceName(){
    return SEQUENCE_NAME;
 }
}



