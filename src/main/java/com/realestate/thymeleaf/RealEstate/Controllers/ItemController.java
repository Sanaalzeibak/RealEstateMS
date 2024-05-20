package com.realestate.thymeleaf.RealEstate.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ItemController {

    @GetMapping("/items")
    public String getItems(Model model) {
        List<String> items = new ArrayList<>();
        items.add("Wassup");
        items.add("whatchu want huh?");
        items.add("alright i gotcha");
        model.addAttribute("itemsalot", items);
        return "items"; // returns the name of the view template (items.html)
    }
}
