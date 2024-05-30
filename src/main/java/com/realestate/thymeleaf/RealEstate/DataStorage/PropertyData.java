package com.realestate.thymeleaf.RealEstate.DataStorage;
public class PropertyData {
    private String id;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    // Add other attributes as needed

    // Constructor, getters, and setters
    public PropertyData(String id, String address, String city, String zipCode, String country) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
