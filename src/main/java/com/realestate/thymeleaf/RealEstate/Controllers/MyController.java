package com.realestate.thymeleaf.RealEstate.Controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @GetMapping("/users")
    public String getUsers(Model model) {
        List<String> list = new ArrayList<>(); // Using ArrayList implementation
        list.add("John");
        list.add("Jane");
        list.add("Jim");

        return "users"; // returns the name of the view template
    }
}
