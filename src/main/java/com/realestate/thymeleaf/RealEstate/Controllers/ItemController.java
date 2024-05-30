package com.realestate.thymeleaf.RealEstate.Controllers;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {

    private final DataStorage dataStorage;

    @Autowired
    public ItemController(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }
    @GetMapping("/items")
    public String getItems(Model model) {

        List<Property> properties = dataStorage.getProperties();
        Gson gson = new Gson();
        String jsonProperties = gson.toJson(properties);
        model.addAttribute("jsonProperties", jsonProperties);
        return "items"; // returns the name of the view template (items.html)
    }
}
