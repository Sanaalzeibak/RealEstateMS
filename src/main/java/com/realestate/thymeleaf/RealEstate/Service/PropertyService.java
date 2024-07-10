package com.realestate.thymeleaf.RealEstate.Service;
import com.realestate.thymeleaf.RealEstate.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;
}
