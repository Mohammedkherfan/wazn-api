package com.wazn.application.response;

public class GetAccountResponse {

    private String email;
    private String mobile;
    private String fullName;

    public GetAccountResponse() {
    }

    public GetAccountResponse(String email, String mobile, String fullName) {
        this.email = email;
        this.mobile = mobile;
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
