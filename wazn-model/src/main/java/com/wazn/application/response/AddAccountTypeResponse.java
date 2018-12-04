package com.wazn.application.response;

public class AddAccountTypeResponse {

    private String mobile;

    public AddAccountTypeResponse() {
    }

    public AddAccountTypeResponse(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
