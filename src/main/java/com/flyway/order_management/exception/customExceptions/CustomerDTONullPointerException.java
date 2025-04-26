package com.flyway.order_management.exception.customExceptions;

/**
 * CustomersDTONullPointerException class for throwing a custom exception when CustomersDTO object is null.
 */
public class CustomerDTONullPointerException extends NullPointerException {

    /**
     * Method to call the super method with the exception.
     *
     * @param message The error message to be supplied.
     */
    public CustomerDTONullPointerException(String message) {
        super(message);
    }

}
