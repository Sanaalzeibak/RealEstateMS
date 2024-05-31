package com.realestate.thymeleaf.RealEstate;

import com.realestate.thymeleaf.RealEstate.DataStorage.PropertyDataStorage;
import com.realestate.thymeleaf.RealEstate.DataStorage.UserDataStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PropertyDataStorage propertyDataStorage() {
        return new PropertyDataStorage();
    }

    @Bean
    public UserDataStorage userDataStorage() {
        return new UserDataStorage();
    }

}