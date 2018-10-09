package com.wazn.application.exception;

public class InvalidVerificationCodeException extends AccountException {

    public InvalidVerificationCodeException(String message) {
        super(message);
    }
}
