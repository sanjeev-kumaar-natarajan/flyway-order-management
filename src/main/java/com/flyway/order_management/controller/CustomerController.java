package com.flyway.order_management.controller;

import com.flyway.order_management.model.dto.CustomerDTO;
import com.flyway.order_management.service.specification.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Get Mapping Find By Id method to fetch a customer data by its id.
     *
     * @param id the id of the customer to be fetched.
     * @return A CustomersDTO object containing the customer data.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(int id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    /**
     * Post Mapping Add Customer method to add a new customer.
     *
     * @param customerDTO the customer data to be added.
     * @return A CustomersDTO object containing the added customer data.
     */
    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.addCustomer(customerDTO), HttpStatus.CREATED);
    }

    /**
     * Put Mapping Update Customer method to update an existing customer.
     *
     * @param customerDTO the customer data to be updated.
     * @return A CustomersDTO object containing the updated customer data.
     */
    @PutMapping
    public ResponseEntity<CustomerDTO> updateCustomer(CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.updateCustomer(customerDTO), HttpStatus.OK);
    }

    /**
     * Delete Mapping Delete Customer method to delete a customer by its id.
     *
     * @param id the id of the customer to be deleted.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
