package com.realestate.thymeleaf.RealEstate;

import com.realestate.thymeleaf.RealEstate.Controllers.DataStorage;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@SpringBootApplication
public class RealEstateApplication {
	@Autowired
	private DataStorage dataStorage;
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

			// Execute a SQL query to select all data from the "apartment" table
			ResultSet resultSet = statement.executeQuery("SELECT * FROM properties");

			// Create a DataStorage object to store the extracted data
			//DataStorage dataStorage = new DataStorage();

			// Extract data from the ResultSet and store it in the DataStorage object
			dataStorage.extractData(resultSet);



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

