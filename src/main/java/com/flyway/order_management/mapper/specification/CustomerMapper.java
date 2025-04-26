package com.flyway.order_management.mapper.specification;

import com.flyway.order_management.model.dto.CustomerDTO;
import com.flyway.order_management.model.entity.Customer;

/**
 * Mapper interface that provides to methods to map Customers entity object to CustomersDTO object and vice versa.
 */
public interface CustomerMapper {

    /**
     * Mapper method to map CustomersDTO object to Customers Entity.
     *
     * @param customerDTO CustomersDTO object to be mapped.
     * @return Customers Entity that has CustomersDTO objects mapped.
     */
    Customer mapToCustomersEntity(CustomerDTO customerDTO);

    /**
     * Mapper method to map Customers Entity to CustomersDTO object.
     *
     * @param customer Customers Entity to be mapped.
     * @return CustomersDTO object that has the Customers Entity mapped.
     */
    CustomerDTO mapToCustomersDTO(Customer customer);

}
