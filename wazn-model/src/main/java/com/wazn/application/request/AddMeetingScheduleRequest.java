package com.wazn.application.request;

public class AddMeetingScheduleRequest {

    private String startDate;
    private String endDate;
    private String note;

    public AddMeetingScheduleRequest() {
    }

    public AddMeetingScheduleRequest(String startDate, String endDate, String note) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
