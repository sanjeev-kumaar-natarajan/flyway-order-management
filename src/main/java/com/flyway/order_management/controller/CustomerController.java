package com.flyway.order_management.controller;

import com.flyway.order_management.model.dto.CustomerDTO;
import com.flyway.order_management.service.specification.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Customers Controller class provides methods for customer management.
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    /**
     * All Argument constructor to inject all the dependencies.
     *
     * @param customerService Customer Service object for fetching customers related data.
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Get Mapping Find All method to fetch all the customers data.
     *
     * @return A list of all customers data stored in CustomersDTO object.
     */
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

}
