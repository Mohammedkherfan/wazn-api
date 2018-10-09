package com.wazn.application.exception;

public class InvalidAccountRequestException extends AccountException {

    public InvalidAccountRequestException(String message) {
        super(message);
    }
}
