package com.wazn.application.exception;

public class InvalidAccountPasswordException extends AccountException {

    public InvalidAccountPasswordException(String message) {
        super(message);
    }
}
