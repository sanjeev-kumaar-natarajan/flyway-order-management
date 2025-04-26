package com.flyway.order_management.mock;

import com.flyway.order_management.model.dto.CustomerDTO;
import com.flyway.order_management.model.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

/**
 * MockData class that provides mock data for testing purposes.
 */
public class MockData {

    public static List<Customer> getMockCustomers() {
        Customer customer = new Customer("Sarulatha", "sarurengarajan@gmail.com",
                BigDecimal.valueOf(9488125763L),
                "E2/263, BHEL Township, Kailasapuram, Trichy - 620014");
        customer.setCustomerId(1);
        return List.of(customer);
    }

    public static List<CustomerDTO> getMockCustomersDTO() {
        return List.of(
                new CustomerDTO(1, "Sarulatha", "sarurengarajan@gmail.com",
                        BigDecimal.valueOf(9488125763L),
                        "E2/263, BHEL Township, Kailasapuram, Trichy - 620014"));
    }

    public static Customer getMockCustomer() {
        Customer customer = new Customer("Sarulatha", "sarurengarajan@gmail.com",
                BigDecimal.valueOf(9488125763L),
                "E2/263, BHEL Township, Kailasapuram, Trichy - 620014");
        customer.setCustomerId(1);
        return customer;
    }

    public static CustomerDTO getMockCustomerDTO() {
        return new CustomerDTO(1, "Sarulatha", "sarurengarajan@gmail.com",
                BigDecimal.valueOf(9488125763L),
                "E2/263, BHEL Township, Kailasapuram, Trichy - 620014");
    }
}
