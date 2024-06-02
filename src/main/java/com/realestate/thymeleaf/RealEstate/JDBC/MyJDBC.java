package com.realestate.thymeleaf.RealEstate.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MyJDBC {
    public static void main(String[] args) {
        try{
            // Establish a connection to the MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/real_estate", "root","123");

            // Create a statement object for executing SQL queries
            Statement statement = connection.createStatement();

            // Execute a SQL query to select all data from the "apartment" table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM apartment");

            // Create a DataStorage object to store the extracted data
            DataStorage dataStorage = new DataStorage();

            // Extract data from the ResultSet and store it in the DataStorage object
            dataStorage.extractData(resultSet);



            /*
            // Retrieve the extracted data from the DataStorage object
            ArrayList<String> ids = dataStorage.getIds();
            ArrayList<String> address = dataStorage.getAddress();
  */
            // Iterate over the retrieved data and print it
            for(int i = 0; i<dataStorage.getIds().size(); i++){
                System.out.println("ID: " + dataStorage.getIds().get(i) + " Address: " + dataStorage.getAddress().get(i));
            }

        } catch(Exception e){
            e.printStackTrace();
        }


    }
}