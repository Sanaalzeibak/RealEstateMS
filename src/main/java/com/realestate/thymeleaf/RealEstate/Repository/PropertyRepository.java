package com.realestate.thymeleaf.RealEstate.Repository;

import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyData,Long> {
}
