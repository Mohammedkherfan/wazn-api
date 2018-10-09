package com.wazn.application.response;

public class AddAccountResponse {

    private String mobile;

    public AddAccountResponse() {
    }

    public AddAccountResponse(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
