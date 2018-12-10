package com.wazn.application.response;

public class UpdateUserResponse {

    private String userName;

    public UpdateUserResponse() {
    }

    public UpdateUserResponse(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
