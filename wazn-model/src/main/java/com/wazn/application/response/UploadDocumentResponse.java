package com.wazn.application.response;

public class UploadDocumentResponse {

    private String mobile;

    public UploadDocumentResponse() {
    }

    public UploadDocumentResponse(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
