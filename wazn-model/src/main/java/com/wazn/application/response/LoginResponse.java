package com.wazn.application.response;

public class LoginResponse {

    private String mobile;
    private Boolean result;

    public LoginResponse() {
    }

    public LoginResponse(String mobile, Boolean result) {
        this.mobile = mobile;
        this.result = result;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
