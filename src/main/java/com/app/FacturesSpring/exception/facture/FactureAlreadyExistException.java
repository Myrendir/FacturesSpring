package com.app.FacturesSpring.exception.facture;

public class FactureAlreadyExistException extends Exception {
    public FactureAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactureAlreadyExistException(String message) {
        super(message);
    }
}
