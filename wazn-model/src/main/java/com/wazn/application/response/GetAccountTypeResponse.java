package com.wazn.application.response;

public class GetAccountTypeResponse {

    private String mobile;
    private Integer type;

    public GetAccountTypeResponse() {
    }

    public GetAccountTypeResponse(String mobile, Integer type) {
        this.mobile = mobile;
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
