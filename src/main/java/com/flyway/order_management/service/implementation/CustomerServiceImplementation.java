package com.flyway.order_management.service.implementation;

import com.flyway.order_management.mapper.specification.CustomerMapper;
import com.flyway.order_management.model.dto.CustomerDTO;
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

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::mapToCustomersDTO).toList();
    }
}
