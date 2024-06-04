package com.realestate.thymeleaf.RealEstate.Controllers;


import com.realestate.thymeleaf.RealEstate.DataStorage.PropertyData;
import com.realestate.thymeleaf.RealEstate.DataStorage.PropertyDataStorage;
import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.DataStorage.UserData;
import com.realestate.thymeleaf.RealEstate.DataStorage.UserDataStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserDataStorage userDataStorage;

    @Autowired
    public UserController(UserDataStorage userDataStorage) {
        this.userDataStorage = userDataStorage;
    }
    @GetMapping("/users")
    public String getUsers(Model model) {

        List<UserData> users = userDataStorage.getUsers();
        Gson gson = new Gson();
        String jsonUsers = gson.toJson(users);
        model.addAttribute("jsonUsers", jsonUsers);
        return "users"; // returns the name of the view template (users.html)
    }
}
