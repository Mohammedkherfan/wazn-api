package com.wazn.application.exception;

public class MeetingAlreadyExistException extends MeetingScheduleException {

    public MeetingAlreadyExistException(String message) {
        super(message);
    }
}
