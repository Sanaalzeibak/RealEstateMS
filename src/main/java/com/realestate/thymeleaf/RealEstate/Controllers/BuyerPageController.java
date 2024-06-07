package com.realestate.thymeleaf.RealEstate.Controllers;


import com.realestate.thymeleaf.RealEstate.DataStorage.PropertyData;
import com.realestate.thymeleaf.RealEstate.DataStorage.PropertyDataStorage;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BuyerPageController {

    private final PropertyDataStorage propertyDataStorage;

    @Autowired
    public BuyerPageController(PropertyDataStorage propertyDataStorage) {
        this.propertyDataStorage = propertyDataStorage;
    }
    @GetMapping("/BuyerPage")
    public String getProperties(Model model) {

        List<PropertyData> properties = propertyDataStorage.getProperties();
        Gson gson = new Gson();
        String jsonProperties = gson.toJson(properties);
        model.addAttribute("jsonProperties", jsonProperties);
        return "buyerPage";
    }
}