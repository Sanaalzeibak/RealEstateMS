package com.realestate.thymeleaf.RealEstate.Controllers;

import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import com.realestate.thymeleaf.RealEstate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SellerPageController {

    private final PropertyRepository propertyRepository;
    private final UserService userService;

    @Autowired
    public SellerPageController(PropertyRepository propertyRepository, UserService userService) {
        this.propertyRepository = propertyRepository;
        this.userService = userService;
    }

    @GetMapping("/sellerPage")
    public String getProperties(Model model){
        List<PropertyData> properties = propertyRepository.findAll();
        Gson gson = new Gson();
        String jsonProperties = gson.toJson(properties);
        model.addAttribute("jsonProperties",jsonProperties);
        return "sellerPage";
    }

    @GetMapping("/testSeller")
    public String showSellerForm(Model model) {
        model.addAttribute("propertyData", new PropertyData());  // Initialize an empty PropertyData object for the form
        return "testSeller";
    }


    @PostMapping("/testSeller")
    public String addProperty(@ModelAttribute PropertyData propertyData, Model model) {
        try {
            // Save property
            propertyRepository.save(propertyData);
            model.addAttribute("message", "Property added successfully.");
            return "successBuy";  // Replace with your success page name
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "testSeller";  // Return to the form page if there's an error
        }
    }
}