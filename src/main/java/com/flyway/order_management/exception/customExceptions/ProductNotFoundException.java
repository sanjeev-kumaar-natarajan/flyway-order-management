package com.flyway.order_management.exception.customExceptions;

/**
 * ProductNotFoundException class that extends RuntimeException to handle cases where a product is not found.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
