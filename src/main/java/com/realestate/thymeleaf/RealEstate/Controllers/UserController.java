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
public class UserController {
    /*
        private final UserDataStorage userDataStorage;

        @Autowired
        public UserController(UserDataStorage userDataStorage) {
            this.userDataStorage = userDataStorage;
        }
        @GetMapping("/users")
        public String getUsers(Model model) {

            //List<UserData> users = userDataStorage.getUsers();
            Gson gson = new Gson();
            String jsonUsers = gson.toJson(userDataStorage.getUsers());
            model.addAttribute("jsonUsers", jsonUsers);
            return "users"; // returns the name of the view template (users.html)
        }
     */
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String getUsers(Model model) {
        List<UserData> users = userRepository.findAll();
        Gson gson = new Gson();
        String jsonUsers = gson.toJson(users);
        model.addAttribute("users", jsonUsers);
        return "login"; // returns the name of the view template (users.html)
    }

    @PostMapping("/login")
    public String saveUser(@ModelAttribute UserData user) {
        userRepository.save(user);
        return "redirect:/success";  // Redirect to a success page or the desired page
    }

}