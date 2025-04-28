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

    /**
     * Method to return a customer by its ID.
     *
     * @param id The ID of the customer to be fetched.
     * @return The customer data stored as a CustomerDTO object.
     */
    CustomerDTO findById(int id);

    /**
     * Method to add a new customer to the database.
     *
     * @param customerDTO The customer data to be added stored as a CustomerDTO object.
     * @return The added customer data stored as a CustomerDTO object.
     */
    CustomerDTO addCustomer(CustomerDTO customerDTO);

    /**
     * Method to update an existing customer in the database.
     *
     * @param customerDTO The customer data to be updated stored as a CustomerDTO object.
     * @return The updated customer data stored as a CustomerDTO object.
     */
    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    /**
     * Method to delete a customer from the database by its ID.
     *
     * @param id The ID of the customer to be deleted.
     */
    void deleteCustomer(int id);

}
