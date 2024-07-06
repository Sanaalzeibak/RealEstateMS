package com.realestate.thymeleaf.RealEstate.Controllers;

import com.google.gson.Gson;
import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import com.realestate.thymeleaf.RealEstate.Model.UserData;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import com.realestate.thymeleaf.RealEstate.Repository.UserRepository;
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
import java.util.Optional;

@Controller
public class SellerPageController {

    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;
    private final SoldPropertiesService soldPropertiesService;
    private final UserService userService;

    @Autowired
    public SellerPageController(PropertyRepository propertyRepository, UserRepository userRepository, SoldPropertiesService soldPropertiesService, UserService userService) {
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
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
        String jsonPropertiesGC = gson.toJson(properties);
        String jsonPropertiesDS = gson.toJson(properties);

        // Add these to the model
        model.addAttribute("jsonPropertiesGC", jsonPropertiesGC);
        model.addAttribute("jsonPropertiesDS", jsonPropertiesDS);

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
    @PostMapping("/sellerPage")
    public String addProperty(@ModelAttribute PropertyData propertyData, String ownerEmail, Model model) {
        try {
            //get user id from String ownerEmail and set it to property
            /*Optional<Long> ownerIdOptional = userRepository.findIdByEmail(ownerEmail);
            if (!ownerIdOptional.isPresent()) {
                throw new IllegalArgumentException("Owner not found with email: " + ownerEmail);
            }
            long ownerId = ownerIdOptional.get();
            propertyData.setUserId(ownerId);  // assuming PropertyData has a setUserId method
            */
            // Save property
            propertyData.setListingStatus("Active");
            propertyRepository.save(propertyData);
            model.addAttribute("message", "Property added successfully.");
            //return "successBuy";  // Replace with your success page name
            return "redirect:/sellerPage";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "sellerPage";  // Return to the form page if there's an error
        }
    }
}
