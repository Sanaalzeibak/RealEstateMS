package com.realestate.thymeleaf.RealEstate.DataStorage;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class PropertyDataStorage {
    private List<PropertyData> properties = new ArrayList<PropertyData>();

    // ArrayLists to store IDs and addresses extracted from the ResultSet
    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> addresses = new ArrayList<>();
    private ArrayList<String> cities = new ArrayList<>();
    private ArrayList<String> zips = new ArrayList<>();
    private ArrayList<String> countries = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> pPrices = new ArrayList<>();
    private ArrayList<String> rPrices = new ArrayList<>();
    private ArrayList<String> perimeters = new ArrayList<>();
    private ArrayList<String> rooms = new ArrayList<>();
    private ArrayList<String> bathrooms = new ArrayList<>();
    private ArrayList<String> squarefootages = new ArrayList<>();
    private ArrayList<String> listingsstatus = new ArrayList<>();


    // Method to extract data from the ResultSet and store it in the ArrayLists
    public void extractData(ResultSet resultSet) {
        try {
            // Loop through the ResultSet
            while (resultSet.next()) {
                String id = resultSet.getString("PropertyID");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");
                String zip = resultSet.getString("ZIPCode");
                String country = resultSet.getString("Country");
                String type = resultSet.getString("PropertyType");
                String pPrice = resultSet.getString("PurchasePrice");
                String rPrice = resultSet.getString("RentalPrice");
                String perimeter = resultSet.getString("Perimeter");
                String room = resultSet.getString("Rooms");
                String bathroom = resultSet.getString("Bathrooms");
                String squarefootage = resultSet.getString("SquareFootage");
                String listingstatus = resultSet.getString("ListingStatus");

                ids.add(id);
                addresses.add(address);
                cities.add(city);
                zips.add(zip);
                countries.add(country);
                types.add(type);
                pPrices.add(pPrice);
                rPrices.add(rPrice);
                perimeters.add(perimeter);
                rooms.add(room);
                bathrooms.add(bathroom);
                squarefootages.add(squarefootage);
                listingsstatus.add(listingstatus);
                PropertyData propertyData = new PropertyData(id, address, city, zip, country, type, pPrice, rPrice, perimeter, room, bathroom, squarefootage, listingstatus);
                properties.add(propertyData);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getter properties
    public List<PropertyData> getProperties() {
        return properties;
    }

    /*
    // Method to retrieve the ArrayList of IDs
    public ArrayList<String> getIds() {
        return ids;
    }

    // Method to retrieve the ArrayList of addresses
    public ArrayList<String> getAddress() {
        return addresses;
    }

    // Method to retrieve the ArrayList of
    public ArrayList<String> getCities() {
        return cities;
    }
    */

}