package com.app.FacturesSpring.exception;

public class ClientAlreadyExistException extends Exception {
    public ClientAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientAlreadyExistException(String message) {
        super(message);
    }
}
