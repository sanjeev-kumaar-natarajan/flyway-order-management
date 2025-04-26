package com.flyway.order_management.exception.customExceptions;

/**
 * CustomersNullPointerException class for throwing a custom exception when Customers entity is null.
 */
public class CustomerNullPointerException extends NullPointerException {

    /**
     * Method to call the super method with the exception.
     *
     * @param message The error message to be supplied.
     */
    public CustomerNullPointerException(String message) {
        super(message);
    }

}
