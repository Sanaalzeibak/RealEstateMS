package com.realestate.thymeleaf.RealEstate.Model;
import org.springframework.stereotype.Component;

@Component
public class UserDataStorage {
    /*
    private List<UserData> users = new ArrayList<UserData>();

    // ArrayLists to store IDs and addresses extracted from the ResultSet
    private ArrayList<String> ids = new ArrayList<>();
    private ArrayList<String> firstNames = new ArrayList<>();
    private ArrayList<String> lastNames = new ArrayList<>();
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<String> phoneNumbers = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> roles = new ArrayList<>();


    // Method to extract data from the ResultSet and store it in the ArrayLists
    public void extractData(ResultSet resultSet) {
        try {
            // Loop through the ResultSet
            while (resultSet.next()) {
                String id = resultSet.getString("UserID");
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String email = resultSet.getString("Email");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String password = resultSet.getString("Password");
                String role = resultSet.getString("Role");

                ids.add(id);
                firstNames.add(firstName);
                lastNames.add(lastName);
                emails.add(email);
                phoneNumbers.add(phoneNumber);
                passwords.add(password);
                roles.add(role);
                UserData userData = new UserData(id, firstName, lastName, email, phoneNumber, password, role);
                users.add(userData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // getter users
    public List<UserData> getUsers() {
        return users;
    }

     */

}
