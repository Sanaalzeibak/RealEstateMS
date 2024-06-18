package com.realestate.thymeleaf.RealEstate.Model;

import jakarta.persistence.*;

@Entity
@Table(name="user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;

    // Constructor


    public UserCredentials(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserCredentials() {

    }
}