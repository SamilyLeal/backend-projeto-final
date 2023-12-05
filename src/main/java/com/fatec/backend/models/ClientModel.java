package com.fatec.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENT_TB")
@Getter
@Setter
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotBlank(message = "Name cannot be empty!")
    @Column(name = "NAME")
    String name;

    @NotBlank(message = "Email cannot be empty!")
    @Email(message = "Email is invalid!")
    @Column(name = "EMAIL")
    String email;

    @NotBlank(message = "Phone cannot be empty!")
    @Column(name = "PHONE")
    String phone;

    @NotBlank(message = "Address cannot be empty!")
    @Column(name = "ADDRESS")
    String address;

    @NotBlank(message = "ZipCode cannot be empty!")
    @Column(name = "ZIPCODE")
    String zipCode;

    @NotBlank(message = "City cannot be empty!")
    @Column(name = "CITY")
    String city;

    @NotBlank(message = "State cannot be empty!")
    @Column(name = "STATE")
    String state;
    
}
