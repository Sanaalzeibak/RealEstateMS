package com.realestate.thymeleaf.RealEstate.Controllers;

import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import com.realestate.thymeleaf.RealEstate.Service.SoldPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PropertySaleController {

    private SoldPropertiesService soldPropertiesService;
    private PropertyRepository propertyRepository;

    @Autowired
    public PropertySaleController(SoldPropertiesService soldPropertiesService, PropertyRepository propertyRepository) {
        this.soldPropertiesService = soldPropertiesService;
        this.propertyRepository = propertyRepository;
    }

    @GetMapping("/buyProperty")
    public String showBuyPropertyForm(Model model) {
        List<PropertyData> properties = propertyRepository.findAll();
        model.addAttribute("properties", properties);
        return "buyProperty";
    }
    @PostMapping("/buyProperty")
    public String buyProperty(@RequestParam("propertyId") Long propertyId, @RequestParam("buyerEmail") String buyerEmail,
            Model model){
        try {
            soldPropertiesService.sellProperty(propertyId, buyerEmail);
            model.addAttribute("message", "Property purchased successfully.");
            return "successBuy";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "buyProperty";
        }
    }
}
