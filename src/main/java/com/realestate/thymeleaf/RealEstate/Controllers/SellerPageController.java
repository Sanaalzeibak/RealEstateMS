package com.realestate.thymeleaf.RealEstate.Controllers;


import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import com.realestate.thymeleaf.RealEstate.Model.PropertyDataStorage;
import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SellerPageController {
    /*

    private final PropertyDataStorage propertyDataStorage;

    @Autowired
    public SellerPageController(PropertyDataStorage propertyDataStorage) {
        this.propertyDataStorage = propertyDataStorage;
    }
    @GetMapping("/sellerPage")
    public String getProperties(Model model) {

        List<PropertyData> properties = propertyDataStorage.getProperties();
        Gson gson = new Gson();
        String jsonProperties = gson.toJson(properties);
        model.addAttribute("jsonProperties", jsonProperties);
        return "sellerPage"; // returns the name of the view template (properties.html)
    }

     */

    private final PropertyRepository propertyRepository;

    @Autowired
    public SellerPageController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @GetMapping("/SellerPage")
    public String getProperties(Model model){
        List<PropertyData> properties = propertyRepository.findAll();
        Gson gson = new Gson();
        String jsonProperties = gson.toJson(properties);
        model.addAttribute("jsonProperties",jsonProperties);
        return "sellerPage";
    }
}