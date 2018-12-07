package com.wazn.application.response;

import java.time.LocalDateTime;

public class ListMeetingResponse {

    private String mobile;
    private LocalDateTime startDate;
    private String note;

    public ListMeetingResponse() {
    }

    public ListMeetingResponse(String mobile, LocalDateTime startDate, String note) {
        this.mobile = mobile;
        this.startDate = startDate;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
