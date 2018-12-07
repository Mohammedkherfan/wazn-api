package com.wazn.application.request;

public class UpdateMeetingScheduleRequest {

    private String startDate;
    private String note;

    public UpdateMeetingScheduleRequest() {
    }

    public UpdateMeetingScheduleRequest(String startDate, String note) {
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
