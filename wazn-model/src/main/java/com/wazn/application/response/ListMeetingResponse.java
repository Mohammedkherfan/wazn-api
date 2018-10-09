package com.wazn.application.response;

import java.time.LocalDateTime;

public class ListMeetingResponse {

    private String mobile;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String note;

    public ListMeetingResponse() {
    }

    public ListMeetingResponse(String mobile, LocalDateTime startDate, LocalDateTime endDate, String note) {
        this.mobile = mobile;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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
