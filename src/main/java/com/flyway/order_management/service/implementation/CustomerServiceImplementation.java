package com.flyway.order_management.service.implementation;

import com.flyway.order_management.exception.customExceptions.CustomerNotFoundException;
import com.flyway.order_management.mapper.specification.CustomerMapper;
import com.flyway.order_management.model.dto.CustomerDTO;
import com.flyway.order_management.model.entity.Customer;
import com.flyway.order_management.repository.CustomerRepository;
import com.flyway.order_management.service.specification.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the Customers Service Interface that contains the business logic for Customer management.
 */
@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    /**
     * All argument constructor to inject the necessary objects.
     *
     * @param customerMapper     Customers Mapper Object.
     * @param customerRepository Customers Repository Interface Object.
     */
    public CustomerServiceImplementation(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    /**
     * Method to find all the customers in the system.
     *
     * @return List of CustomersDTO object that contains all the customers data.
     */
    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::mapToCustomersDTO).toList();
    }

    /**
     * Method to find a customer by its ID.
     *
     * @param id the ID of the customer to be found.
     * @return CustomersDTO object that contains the customer data.
     */
    @Override
    public CustomerDTO findById(int id) {
        return customerMapper.mapToCustomersDTO(customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found")));
    }

    /**
     * Method to add a new customer to the system.
     *
     * @param customerDTO CustomersDTO object that contains the customer data to be added.
     * @return CustomersDTO object that contains the added customer data.
     */
    @Override
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        return customerMapper.mapToCustomersDTO(customerRepository.save(customerMapper.mapToCustomersEntity(customerDTO)));
    }

    /**
     * Method to update an existing customer in the system.
     *
     * @param customerDTO CustomersDTO object that contains the customer data to be updated.
     * @return CustomersDTO object that contains the updated customer data.
     */
    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
        if (customerDTO.getFullName() != null) {
            customer.setFullName(customerDTO.getFullName());
        }
        if (customerDTO.getEmail() != null) {
            customer.setEmail(customerDTO.getEmail());
        }
        if (customerDTO.getPhoneNumber() != null) {
            customer.setPhoneNumber(customerDTO.getPhoneNumber());
        }
        if (customerDTO.getAddress() != null) {
            customer.setAddress(customerDTO.getAddress());
        }
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.mapToCustomersDTO(updatedCustomer);
    }

    /**
     * Method to delete a customer from the system by its ID.
     *
     * @param id the ID of the customer to be deleted.
     */
    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }


}
