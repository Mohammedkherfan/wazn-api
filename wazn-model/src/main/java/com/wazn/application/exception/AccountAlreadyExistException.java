package com.wazn.application.exception;

public class AccountAlreadyExistException extends AccountException {

    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
