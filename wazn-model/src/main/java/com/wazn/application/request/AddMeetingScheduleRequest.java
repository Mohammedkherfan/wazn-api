package com.wazn.application.request;

public class AddMeetingScheduleRequest {

    private String startDate;
    private String note;

    public AddMeetingScheduleRequest() {
    }

    public AddMeetingScheduleRequest(String startDate, String note) {
        this.startDate = startDate;
        this.note = note;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
