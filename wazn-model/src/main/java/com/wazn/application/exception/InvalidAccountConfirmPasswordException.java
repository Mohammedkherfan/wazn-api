package com.wazn.application.exception;

public class InvalidAccountConfirmPasswordException extends AccountException {

    public InvalidAccountConfirmPasswordException(String message) {
        super(message);
    }
}
