package com.flyway.order_management.repository;

import com.flyway.order_management.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Customers Repository Interface to interact and fetch from customers database table.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
