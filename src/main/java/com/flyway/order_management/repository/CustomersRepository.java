package com.flyway.order_management.repository;

import com.flyway.order_management.model.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Customers Repository Interface to interact and fetch from customers database table.
 */
@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
}
