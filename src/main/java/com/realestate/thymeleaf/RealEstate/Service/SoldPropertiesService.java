package com.realestate.thymeleaf.RealEstate.Service;

import com.realestate.thymeleaf.RealEstate.Model.SoldProperties;
import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import com.realestate.thymeleaf.RealEstate.Model.UserData;
import com.realestate.thymeleaf.RealEstate.Repository.SoldPropertiesRepository;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import com.realestate.thymeleaf.RealEstate.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SoldPropertiesService {

    @Autowired
    private SoldPropertiesRepository soldPropertyRepository;

    @Autowired
    private PropertyRepository propertyRepository;


    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void sellProperty(Long propertyId, String buyerEmail) {
        Optional<Long> buyerIdOptional = userRepository.findIdByEmail(buyerEmail);
        if (!buyerIdOptional.isPresent()) {
            throw new IllegalArgumentException("Buyer not found with email: " + buyerEmail);
        }
        Long buyerId = buyerIdOptional.get();

        Optional<PropertyData> propertyOptional = propertyRepository.findById(propertyId);
        if (!propertyOptional.isPresent()) {
            throw new IllegalArgumentException("Property not found with id: " + propertyId);
        }
        PropertyData property = propertyOptional.get();

        // Create a new SoldProperty record
        SoldProperties soldProperties = new SoldProperties(propertyId, buyerId, LocalDateTime.now());
        soldPropertyRepository.save(soldProperties);

        // Update property status to "Sold" using custom repository method
        propertyRepository.updateListingStatus(propertyId, "Sold");
    }
}

