package com.flyway.order_management.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Product Entity class that represents products table in the database.
 */
@Entity
@Table(name = "product", schema = "order_management_schema")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;
    String name;
    BigDecimal price;
    int stock;

    public Product(String name, BigDecimal price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
