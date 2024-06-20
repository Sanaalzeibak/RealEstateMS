package com.realestate.thymeleaf.RealEstate.Repository;

import com.realestate.thymeleaf.RealEstate.Model.SoldProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldPropertiesRepository extends JpaRepository<SoldProperties, Long> {

}
