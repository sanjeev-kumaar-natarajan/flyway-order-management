package com.flyway.order_management.service.specification;

import com.flyway.order_management.model.dto.CustomerDTO;

import java.util.List;

/**
 * Customer Service Interface class that contains business logic for customer management
 * and to interact with the database through CustomersRepository.
 */
public interface CustomerService {

    /**
     * Method to return all the customers fetched from the database.
     *
     * @return A list of all customers data stored as CustomerDTO objects.
     */
    List<CustomerDTO> findAll();

}
