package com.flyway.order_management.Mapper.Implementation;

import com.flyway.order_management.Mapper.Specification.CustomersMapper;
import com.flyway.order_management.exception.customExceptions.CustomersDTONullPointerException;
import com.flyway.order_management.exception.customExceptions.CustomersNullPointerException;
import com.flyway.order_management.model.dto.CustomersDTO;
import com.flyway.order_management.model.entity.Customers;
import org.springframework.stereotype.Component;

/**
 * Implementation of CustomersMapper Class that has methods to map Customers Entity to CustomersDTO object and vice versa.
 */
@Component
public class CustomersMapperImplementation implements CustomersMapper {

    /**
     * Method to map CustomersDTO object to Customers Entity.
     *
     * @param customersDTO CustomersDTO object to be mapped.
     * @return Customers entity that has the CustomersDTO object mapped.
     */
    @Override
    public Customers mapToCustomersEntity(CustomersDTO customersDTO) {

        try {
            return new Customers(customersDTO.getFullName(), customersDTO.getEmail(),
                    customersDTO.getPhoneNumber(), customersDTO.getAddress());
        } catch (NullPointerException exception) {
            throw new CustomersDTONullPointerException("CustomersDTO Object is null - " + exception.getMessage());
        }

    }

    /**
     * Method to map Customers Entity to CustomersDTO object.
     *
     * @param customers Customers Entity to be mapped.
     * @return CustomersDTO object that had Customers Entity mapped.
     */
    @Override
    public CustomersDTO mapToCustomersDTO(Customers customers) {
        try {
            return new CustomersDTO(customers.getCustomerId(), customers.getFullName(),
                    customers.getEmail(), customers.getPhoneNumber(), customers.getAddress());
        } catch (NullPointerException exception) {
            throw new CustomersNullPointerException("Customers Entity is null - " + exception.getMessage());
        }
    }

}
