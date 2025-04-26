package com.flyway.order_management.service;

import com.flyway.order_management.mapper.specification.CustomerMapper;
import com.flyway.order_management.mock.MockData;
import com.flyway.order_management.model.dto.CustomerDTO;
import com.flyway.order_management.model.entity.Customer;
import com.flyway.order_management.repository.CustomerRepository;
import com.flyway.order_management.service.implementation.CustomerServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the CustomersServiceImplementation class.
 * This class tests the business logic for customer management.
 */
@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerMapper customerMapper;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerServiceImplementation customersService;

    /**
     * Tests the findAll method to ensure it retrieves all customers
     * and maps them correctly to CustomersDTO objects.
     */
    @Test
    void testFindAll() {
        // Arrange
        List<Customer> mockCustomers = MockData.getMockCustomers();
        List<CustomerDTO> expectedCustomers = MockData.getMockCustomersDTO();
        Customer customer = MockData.getMockCustomer();
        CustomerDTO customerDTO = MockData.getMockCustomerDTO();
        when(customerRepository.findAll()).thenReturn(mockCustomers);
        when(customerMapper.mapToCustomersDTO(customer)).thenReturn(customerDTO);

        // Act
        List<CustomerDTO> actualCustomers = customersService.findAll();

        // Assert
        assertThat(expectedCustomers).usingRecursiveComparison().isEqualTo(mockCustomers);

    }
}