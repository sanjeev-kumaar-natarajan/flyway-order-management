package com.flyway.order_management.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Customers Entity class that represents customers table in the database.
 */
@Entity
@Table(name = "customer", schema = "order_management_schema")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;

    String fullName;
    String email;
    BigDecimal phoneNumber;
    String address;

    public Customer(String fullName, String email, BigDecimal phoneNumber, String address) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}
