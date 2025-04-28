package com.flyway.order_management.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ProductDTO class that represents the product data transfer object.
 */
@Data
public class ProductDTO {

    int productId;
    String name;
    BigDecimal price;
    int stock;

    public ProductDTO(int productId, String name, BigDecimal price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
