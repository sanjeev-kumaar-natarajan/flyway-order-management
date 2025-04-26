package com.flyway.order_management.Controller;

import com.flyway.order_management.model.dto.CustomersDTO;
import com.flyway.order_management.service.specification.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Customers Controller class provides methods for customer management.
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {

    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    /**
     * Get Mapping Find All method to fetch all the customers data.
     *
     * @return A list of all customers data stored in CustomersDTO object.
     */
    @GetMapping
    public ResponseEntity<List<CustomersDTO>> findAll() {
        return new ResponseEntity<>(customersService.findAll(), HttpStatus.OK);
    }

}
