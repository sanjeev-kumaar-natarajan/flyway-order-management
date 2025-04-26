package com.flyway.order_management.Mapper.Specification;

import com.flyway.order_management.model.dto.CustomersDTO;
import com.flyway.order_management.model.entity.Customers;

/**
 * Mapper interface that provides to methods to map Customers entity object to CustomersDTO object and vice versa.
 */
public interface CustomersMapper {

    /**
     * Mapper method to map CustomersDTO object to Customers Entity.
     *
     * @param customersDTO CustomersDTO object to be mapped.
     * @return Customers Entity that has CustomersDTO objects mapped.
     */
    Customers mapToCustomersEntity(CustomersDTO customersDTO);

    /**
     * Mapper method to map Customers Entity to CustomersDTO object.
     *
     * @param customers Customers Entity to be mapped.
     * @return CustomersDTO object that has the Customers Entity mapped.
     */
    CustomersDTO mapToCustomersDTO(Customers customers);

}
