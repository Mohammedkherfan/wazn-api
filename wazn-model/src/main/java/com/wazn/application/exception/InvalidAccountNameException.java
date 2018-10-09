package com.wazn.application.exception;

public class InvalidAccountNameException extends AccountException {

    public InvalidAccountNameException(String message) {
        super(message);
    }
}
