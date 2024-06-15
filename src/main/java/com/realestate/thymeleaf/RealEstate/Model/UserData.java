package com.realestate.thymeleaf.RealEstate.Model;

import jakarta.persistence.*;

@Entity
@Table(name="user_data")
public class UserData {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 private String email;
 private String phoneNumber;
 private String password;
 private String role;

 // Constructor


 public UserData(Long id, String firstName, String lastName, String email, String phoneNumber, String password, String role) {
  this.id = id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.email = email;
  this.phoneNumber = phoneNumber;
  this.password = password;
  this.role = role;
 }

 public UserData() {

 }


}