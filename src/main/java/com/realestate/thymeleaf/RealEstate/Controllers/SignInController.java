package com.realestate.thymeleaf.RealEstate.Controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SignInController {
    @GetMapping("/signIn")
    public String getProperties() {
        return "signIn";
    }
}