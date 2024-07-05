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


    //Constructor
        public SoldProperties(Long propertyId, Long buyerId) {
            this.propertyId = propertyId;
            this.buyerId = buyerId;
        }

        //Default Constructor
        public SoldProperties() {
        }



}
