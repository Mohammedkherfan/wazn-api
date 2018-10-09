package com.wazn.application.response;

public class AddDocumentResponse {

    private String mobile;

    public AddDocumentResponse() {
    }

    public AddDocumentResponse(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
