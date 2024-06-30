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
    //@Column(name = "PurchasePrice")
    //private String purchasePrice;
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
        // this.purchasePrice = purchasePrice;
        this.rentalPrice = rentalPrice;
        this.perimeter = perimeter;
        this.rooms = rooms;
        this.bathrooms = bathrooms;
        this.squareFootage = squareFootage;
        this.listingStatus = listingStatus;
    }

    public PropertyData() {

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }


    public String getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(String rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(String perimeter) {
        this.perimeter = perimeter;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(String squareFootage) {
        this.squareFootage = squareFootage;
    }

    public String getListingStatus() {
        return listingStatus;
    }

    public void setListingStatus(String listingStatus) {
        this.listingStatus = listingStatus;
    }


    @Override
    public String toString() {
        return "PropertyData{" +
                "address='" + address + '\'' +
                ", bathrooms=" + bathrooms +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", listingStatus='" + listingStatus + '\'' +
                ", perimeter=" + perimeter +
                ", propertyType='" + propertyType + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", rooms=" + rooms +
                ", squareFootage=" + squareFootage +
                ", userId=" + id +
                ", zip='" + zip + '\'' +
                '}';
    }


}