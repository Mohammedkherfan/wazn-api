package com.wazn.application.response;

public class AddMeetingScheduleResponse {

    private String mobile;

    public AddMeetingScheduleResponse() {
    }

    public AddMeetingScheduleResponse(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
