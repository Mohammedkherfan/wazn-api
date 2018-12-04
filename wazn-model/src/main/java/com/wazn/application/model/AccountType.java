package com.wazn.application.model;

public class AccountType {

    private String mobile;
    private Integer type;

    public AccountType(String mobile, Integer type) {
        this.mobile = mobile;
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public Integer getType() {
        return type;
    }

    public static class Builder {

        private String mobile;
        private Integer type;

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        public AccountType build() {
            return new AccountType(mobile, type);
        }
    }
}
