package com.flyway.order_management.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * CustomersDTO class that represents the customer data transfer object.
 */
@Data
public class CustomersDTO {

    int customerId;
    String fullName;
    String email;
    BigDecimal phoneNumber;
    String address;

    public CustomersDTO(int customerId, String fullName, String email, BigDecimal phoneNumber, String address) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CustomersDTO() {
    }

}
