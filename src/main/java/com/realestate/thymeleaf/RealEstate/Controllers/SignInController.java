package com.realestate.thymeleaf.RealEstate.Controllers;



import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.Model.UserData;
import com.realestate.thymeleaf.RealEstate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class SignInController {

    private final UserRepository userRepository;

    @Autowired
    public SignInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/signIn")
    public String getUsers(Model model) {
        UserData userData = new UserData();
        model.addAttribute("userData", userData);
        List<UserData> users = userRepository.findAll();
        Gson gson = new Gson();
        String jsonUsers = gson.toJson(users);
        //model.addAttribute("users", users);
        return "signIn"; // returns the name of the view template (users.html)
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";  // returns the name of the success view template (success.html)
    }

    @PostMapping("/signIn")
    public String saveUser(@ModelAttribute UserData userData, Model model) {

        try {
        userRepository.save(userData);
        model.addAttribute("message", "Property added successfully.");
            if ("Buyer".equalsIgnoreCase(userData.getRole())) {
                return "redirect:/BuyerPage";  // Redirect to buyer page
            } else if ("Seller".equalsIgnoreCase(userData.getRole())) {
                return "redirect:/sellerPage";  // Redirect to seller page
            } else {
                return "signIn";
            }
    } catch (IllegalArgumentException e) {
        model.addAttribute("error", e.getMessage());
        return "signIn";  // Return to the form page if there's an error
    }
    }
}