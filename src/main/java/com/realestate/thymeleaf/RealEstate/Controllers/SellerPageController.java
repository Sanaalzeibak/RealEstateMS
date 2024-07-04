package com.realestate.thymeleaf.RealEstate.Controllers;

import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import com.realestate.thymeleaf.RealEstate.Service.SoldPropertiesService;
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
    private final SoldPropertiesService soldPropertiesService;
    private final UserService userService;

    @Autowired
    public SellerPageController(PropertyRepository propertyRepository, SoldPropertiesService soldPropertiesService, UserService userService) {
        this.propertyRepository = propertyRepository;
        this.soldPropertiesService = soldPropertiesService;
        this.userService = userService;
    }

    @GetMapping("/sellerPage")
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

        return "sellerPage";
    }

    @PostMapping(value = "/sellerPage", params = {"propertyId", "buyerEmail"})
    public String buyProperty(@RequestParam("propertyId") Long propertyId, @RequestParam("buyerEmail") String buyerEmail, Model model) {
        try {
            soldPropertiesService.sellProperty(propertyId, buyerEmail);
            model.addAttribute("message", "Property purchased successfully.");
            return "redirect:/sellerPage";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "sellerPage";
        }
    }

    @PostMapping(value = "/sellerPage", params = "propertyData")
    public String addProperty(@ModelAttribute PropertyData propertyData, Model model) {
        try {
            // Save property
            propertyRepository.save(propertyData);
            model.addAttribute("message", "Property added successfully.");
            return "successBuy";  // Replace with your success page name
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "sellerPage";  // Return to the form page if there's an error
        }
    }
}