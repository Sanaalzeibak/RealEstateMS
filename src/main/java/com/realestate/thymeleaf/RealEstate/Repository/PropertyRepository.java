package com.realestate.thymeleaf.RealEstate.Repository;

import com.realestate.thymeleaf.RealEstate.Model.PropertyData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropertyRepository extends JpaRepository<PropertyData,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE PropertyData p SET p.listingStatus = :status WHERE p.id = :propertyId")
    void updateListingStatus(@Param("propertyId") Long propertyId, @Param("status") String status);
}
