package com.flyway.order_management.exception.customExceptions;

/**
 * CustomerNotFoundException class that extends RuntimeException to handle cases where a customer is not found.
 */
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
