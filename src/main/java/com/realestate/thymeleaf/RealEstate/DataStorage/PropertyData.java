package com.realestate.thymeleaf.RealEstate.DataStorage;
public class PropertyData {
    private String id;
    private String address;
    private String city;
    private String zip;
    private String country;
    private String type;
    private String pPrice;
    private String rPrice;
    private String perimeter;
    private String room;
    private String bathroom;
    private String squarefootage;
    private String listingstatus;


    // Add other attributes as needed

    // Constructor, getters, and setters


    public PropertyData(String id, String address, String city, String zip, String country, String type, String pPrice, String rPrice, String perimeter, String room, String bathroom, String squarefootage, String listingstatus) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
