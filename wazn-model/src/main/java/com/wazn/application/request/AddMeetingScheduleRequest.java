package com.wazn.application.request;

import java.time.LocalDateTime;

public class AddMeetingScheduleRequest {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String note;

    public AddMeetingScheduleRequest() {
    }

    public AddMeetingScheduleRequest(LocalDateTime startDate, LocalDateTime endDate, String note) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
