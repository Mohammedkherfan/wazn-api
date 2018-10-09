package com.wazn.application.request;

public class AddAccountRequest {

    private String email;
    private String mobile;
    private String fullName;
    private String password;
    private String confirmPassword;

    public AddAccountRequest() {
    }

    public AddAccountRequest(String email, String mobile, String fullName, String password, String confirmPassword) {
        this.email = email;
        this.mobile = mobile;
        this.fullName = fullName;
        this.password = password;
        this.confirmPassword = confirmPassword;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
