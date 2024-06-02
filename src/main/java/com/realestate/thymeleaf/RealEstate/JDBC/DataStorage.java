package com.realestate.thymeleaf.RealEstate.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DataStorage {
    // ArrayLists to store IDs and addresses extracted from the ResultSet
    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> addresses = new ArrayList<>();

    // Method to extract data from the ResultSet and store it in the ArrayLists
    public void extractData(ResultSet resultSet) {
        try {
            // Loop through the ResultSet
            while(resultSet.next()) {
                String id = resultSet.getString("id");
                String address = resultSet.getString("address");
                ids.add(id);
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve the ArrayList of IDs
    public ArrayList<String> getIds() {
        return ids;
    }

    // Method to retrieve the ArrayList of addresses
    public ArrayList<String> getAddress() {
        return addresses;
    }
}
