package com.realestate.thymeleaf.RealEstate.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sold_properties")
public class SoldProperties {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "property_id")
        private Long propertyId;
        @Column(name = "buyer_id")
        private Long buyerId;
        @Column(name = "sold_date")
        private LocalDateTime soldDate;


    //Constructor
        public SoldProperties(Long propertyId, Long buyerId, LocalDateTime now) {
            this.propertyId = propertyId;
            this.buyerId = buyerId;
            this.soldDate = soldDate;
        }

        //Default Constructor
        public SoldProperties() {
        }



}
