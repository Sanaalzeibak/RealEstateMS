package com.realestate.thymeleaf.RealEstate.Controllers;


import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BuyerPageController {
    private final PropertyRepository propertyRepository;

    @Autowired
    public BuyerPageController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @GetMapping("/BuyerPage")
    public String showSellerForm(Model model) {
        // Initialize an empty PropertyData object for the form
        model.addAttribute("propertyData", new PropertyData());

        // Load properties for jsonProperties, jsonPropertiesGC, and jsonPropertiesDS
        List<PropertyData> properties = propertyRepository.findAll();
        Gson gson = new Gson();
        String jsonProperties = gson.toJson(properties);
        String jsonPropertiesGC = gson.toJson(properties);
        String jsonPropertiesDS = gson.toJson(properties);
        String jsonContactProperties = gson.toJson(properties);

        // Add these to the model
        model.addAttribute("jsonProperties", jsonProperties);
        model.addAttribute("jsonPropertiesGC", jsonPropertiesGC);
        model.addAttribute("jsonPropertiesDS", jsonPropertiesDS);
        model.addAttribute("jsonContactProperties", jsonContactProperties);

        return "buyerPage";
    }
}