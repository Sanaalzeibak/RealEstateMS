package com.realestate.thymeleaf.RealEstate;




import com.realestate.thymeleaf.RealEstate.Controllers.DataStorage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        try{
            // Establish a connection to the MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://descus.de:3306/immobilial", "immo","Wt7?03(RLG#rF6]JzL}dk9~1y*H48N@I");

            // Create a statement object for executing SQL queries
            Statement statement = connection.createStatement();

            // Execute a SQL query to select all data from the "properties" table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM properties");

            // Create a DataStorage object to store the extracted data
            DataStorage dataStorage = new DataStorage();

            // Extract data from the ResultSet and store it in the DataStorage object
            dataStorage.extractData(resultSet);


            /*
            // Retrieve the extracted data from the DataStorage object
            ArrayList<String> ids = dataStorage.getIds();
            ArrayList<String> address = dataStorage.getAddress();
            ArrayList<String> city = dataStorage.getCities();

            ArrayList<String> zip = dataStorage.getZips();
            ArrayList<String> country = dataStorage.getCountries();
            ArrayList<String> type = dataStorage.getTypes();
            ArrayList<String> pPrice = dataStorage.get_pPrices();
            ArrayList<String> rPrice = dataStorage.get_rPrices();
            ArrayList<String> perimeter = dataStorage.getPerimeters();
            ArrayList<String> rooms = dataStorage.getRooms();
            ArrayList<String> bathroom = dataStorage.getBathrooms();
            */




        } catch(Exception e){
            e.printStackTrace();
        }


    }
}