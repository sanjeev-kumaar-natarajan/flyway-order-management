package com.flyway.order_management.service.implementation;

import com.flyway.order_management.Mapper.Specification.CustomersMapper;
import com.flyway.order_management.model.dto.CustomersDTO;
import com.flyway.order_management.repository.CustomersRepository;
import com.flyway.order_management.service.specification.CustomersService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the Customers Service Interface that contains the business logic for Customer management.
 */
@Service
public class CustomersServiceImplementation implements CustomersService {

    private final CustomersMapper customersMapper;
    private final CustomersRepository customersRepository;

    /**
     * All argument constructor to inject the necessary objects.
     *
     * @param customersMapper     Customers Mapper Object.
     * @param customersRepository Customers Repository Interface Object.
     */
    public CustomersServiceImplementation(CustomersMapper customersMapper, CustomersRepository customersRepository) {
        this.customersMapper = customersMapper;
        this.customersRepository = customersRepository;
    }

    @Override
    public List<CustomersDTO> findAll() {
        return customersRepository.findAll().stream().map(customersMapper::mapToCustomersDTO).toList();
    }
}
