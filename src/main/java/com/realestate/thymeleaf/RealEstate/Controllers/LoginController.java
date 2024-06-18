package com.realestate.thymeleaf.RealEstate.Controllers;

import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.Model.UserCredentials;
import com.realestate.thymeleaf.RealEstate.Repository.UserCredentialsRepository;
import com.realestate.thymeleaf.RealEstate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {
    private final UserCredentialsRepository userCredentialsRepository;


    @Autowired
    public LoginController(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }


    @GetMapping("/login")
    public String getUsers(Model model) {
        List<UserCredentials> userCredentials = userCredentialsRepository.findAll();
        Gson gson = new Gson();
        String jsonUserCredentials = gson.toJson(userCredentials);
        model.addAttribute("userCredentials", jsonUserCredentials);
        return "login";
    }
}
