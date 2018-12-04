package com.wazn.application.response;

public class UpdateMeetingScheduleResponse {

    private String mobile;

    public UpdateMeetingScheduleResponse() {
    }

    public UpdateMeetingScheduleResponse(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
