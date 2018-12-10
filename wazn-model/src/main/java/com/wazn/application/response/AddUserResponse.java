package com.wazn.application.response;

public class AddUserResponse {

    private String userName;

    public AddUserResponse() {
    }

    public AddUserResponse(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
