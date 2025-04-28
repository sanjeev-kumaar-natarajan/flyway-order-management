package com.flyway.order_management.repository;

import com.flyway.order_management.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Product Repository interface that extends JpaRepository to provide CRUD operations for Product entity
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
