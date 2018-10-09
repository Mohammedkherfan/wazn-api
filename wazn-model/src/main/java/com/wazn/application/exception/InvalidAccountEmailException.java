package com.wazn.application.exception;

public class InvalidAccountEmailException extends AccountException {

    public InvalidAccountEmailException(String message) {
        super(message);
    }
}
