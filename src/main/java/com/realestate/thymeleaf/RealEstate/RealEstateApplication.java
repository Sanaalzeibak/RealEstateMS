package com.realestate.thymeleaf.RealEstate;

import com.realestate.thymeleaf.RealEstate.DataStorage.PropertyDataStorage;
import com.realestate.thymeleaf.RealEstate.DataStorage.UserDataStorage;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class RealEstateApplication {
	@Autowired
	private PropertyDataStorage propertyDataStorage;

	@Autowired
	private UserDataStorage userDataStorage;
	public static void main(String[] args) {
		SpringApplication.run(RealEstateApplication.class, args);
	}

	@PostConstruct
	public void init() {
		try {
			// Establish a connection to the MySQL database
			Connection connection = DriverManager.getConnection("jdbc:mysql://descus.de:3306/immobilial", "immo", "Wt7?03(RLG#rF6]JzL}dk9~1y*H48N@I");

			// Create a statement object for executing SQL queries
			Statement statement = connection.createStatement();

			// Execute a SQL query to select all data from the "properties" table
			ResultSet resultSet = statement.executeQuery("SELECT * FROM properties");
			// Create a DataStorage object to store the extracted data
			propertyDataStorage.extractData(resultSet);

			// Execute a SQL query to select all data from the "users" table
			ResultSet resultSet2 = statement.executeQuery("SELECT * FROM users");

			// Extract data from the ResultSet and store it in the DataStorage object
			userDataStorage.extractData(resultSet2);



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

