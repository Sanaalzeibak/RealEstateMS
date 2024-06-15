package com.realestate.thymeleaf.RealEstate.Model;


import jakarta.persistence.*;


@Entity
@Table(name="properties")
public class PropertyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // attributes of table properties

    @Column(name = "PropertyID")
    private Long id;
    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "ZIPCode")
    private String zip;
    @Column(name = "Country")
    private String country;
    @Column(name = "PropertyType")
    private String type;
    @Column(name = "PurchasePrice")
    private String pPrice;
    @Column(name = "RentalPrice")
    private String rPrice;
    @Column(name = "Perimeter")
    private String perimeter;
    @Column(name = "Rooms")
    private String room;
    @Column(name = "Bathrooms")
    private String bathroom;
    @Column(name = "SquareFootage")
    private String squarefootage;
    @Column(name = "ListingStatus")
    private String listingstatus;


    // Constructor
    public PropertyData(Long id, String address, String city, String zip, String country, String type, String pPrice, String rPrice, String perimeter, String room, String bathroom, String squarefootage, String listingstatus) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.type = type;
        this.pPrice= pPrice;
        this.rPrice= rPrice;
        this.perimeter = perimeter;
        this.room = room;
        this.bathroom = bathroom;
        this.squarefootage = squarefootage;
        this.listingstatus = listingstatus;
    }

    public PropertyData() {

    }

    // getter and setter methods
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String pPrice() {
        return pPrice;
    }

    public void setPPrice(String pPrice) {
        this.type = pPrice;
    }

    public String rPrice() {
        return rPrice;
    }

    public void setRPrice(String rPrice) {
        this.type = rPrice;
    }

    public String getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(String perimeter) {
        this.perimeter = perimeter;
    }

    // Getter and Setter for room
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    // Getter and Setter for bathroom
    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    // Getter and Setter for squarefootage
    public String getSquarefootage() {
        return squarefootage;
    }

    public void setSquarefootage(String squarefootage) {
        this.squarefootage = squarefootage;
    }

    // Getter and Setter for listingstatus
    public String getListingstatus() {
        return listingstatus;
    }

    public void setListingstatus(String listingstatus) {
        this.listingstatus = listingstatus;
    }


}
