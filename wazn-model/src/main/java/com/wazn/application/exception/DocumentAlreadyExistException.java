package com.wazn.application.exception;

public class DocumentAlreadyExistException extends AccountException {

    public DocumentAlreadyExistException(String message) {
        super(message);
    }
}
