package com.realestate.thymeleaf.RealEstate.Controllers;



import com.google.gson.Gson;

import com.realestate.thymeleaf.RealEstate.Model.UserData;
import com.realestate.thymeleaf.RealEstate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class DashboardController {

    private final UserRepository userRepository;

    @Autowired
    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/Dashboard")
    public String getUsers(Model model) {
        List<UserData> userData = userRepository.findAll();
        Gson gson = new Gson();
        String jsonUserData = gson.toJson(userData);
        model.addAttribute("userData", jsonUserData);
        return "dashboard";
    }
}