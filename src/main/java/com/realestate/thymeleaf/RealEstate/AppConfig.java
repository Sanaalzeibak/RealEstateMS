package com.realestate.thymeleaf.RealEstate;

import com.realestate.thymeleaf.RealEstate.Controllers.DataStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DataStorage dataStorage() {
        return new DataStorage();
    }
}