package com.realestate.thymeleaf.RealEstate;

import com.realestate.thymeleaf.RealEstate.DataStorage.PropertyDataStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PropertyDataStorage propertyDataStorage() {
        return new PropertyDataStorage();
    }
}