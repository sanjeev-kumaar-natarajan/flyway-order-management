package com.flyway.order_management.mapper.implementation;

import com.flyway.order_management.exception.customExceptions.CustomerDTONullPointerException;
import com.flyway.order_management.exception.customExceptions.CustomerNullPointerException;
import com.flyway.order_management.mapper.specification.CustomerMapper;
import com.flyway.order_management.model.dto.CustomerDTO;
import com.flyway.order_management.model.entity.Customer;
import org.springframework.stereotype.Component;

/**
 * Implementation of CustomersMapper Class that has methods to map Customers Entity to CustomersDTO object and vice versa.
 */
@Component
public class CustomerMapperImplementation implements CustomerMapper {

    /**
     * Method to map CustomersDTO object to Customers Entity.
     *
     * @param customerDTO CustomersDTO object to be mapped.
     * @return Customers entity that has the CustomersDTO object mapped.
     */
    @Override
    public Customer mapToCustomersEntity(CustomerDTO customerDTO) {

        try {
            return new Customer(customerDTO.getFullName(), customerDTO.getEmail(),
                    customerDTO.getPhoneNumber(), customerDTO.getAddress());
        } catch (NullPointerException exception) {
            throw new CustomerDTONullPointerException("CustomersDTO Object is null - " + exception.getMessage());
        }

    }

    /**
     * Method to map Customers Entity to CustomersDTO object.
     *
     * @param customer Customers Entity to be mapped.
     * @return CustomersDTO object that had Customers Entity mapped.
     */
    @Override
    public CustomerDTO mapToCustomersDTO(Customer customer) {
        try {
            return new CustomerDTO(customer.getCustomerId(), customer.getFullName(),
                    customer.getEmail(), customer.getPhoneNumber(), customer.getAddress());
        } catch (NullPointerException exception) {
            throw new CustomerNullPointerException("Customers Entity is null - " + exception.getMessage());
        }
    }

}
