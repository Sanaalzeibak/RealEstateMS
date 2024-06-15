package com.realestate.thymeleaf.RealEstate.Model;


import jakarta.persistence.*;


@Entity
@Table(name="properties")
public class PropertyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // attributes of table properties


    private Long id;

    private String address;

    private String city;

    private String zip;

    private String country;
    @Column(name = "PropertyType")
    private String propertyType;
    @Column(name = "PurchasePrice")
    private String purchasePrice;
    @Column(name = "RentalPrice")
    private String rentalPrice;
    @Column(name = "Perimeter")
    private String perimeter;
    @Column(name = "rooms")
    private String rooms;
    @Column(name = "bathrooms")
    private String bathrooms;
    @Column(name = "SquareFootage")
    private String squareFootage;
    @Column(name = "ListingStatus")
    private String listingStatus;


    // Constructor
    public PropertyData(Long id, String address, String city, String zip, String country, String propertyType, String purchasePrice, String rentalPrice, String perimeter, String rooms, String bathrooms, String squareFootage, String listingStatus) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.propertyType = propertyType;
        this.purchasePrice = purchasePrice;
        this.rentalPrice = rentalPrice;
        this.perimeter = perimeter;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.squareFootage = squareFootage;
        this.listingStatus = listingStatus;
    }

    public PropertyData() {

    }


}
