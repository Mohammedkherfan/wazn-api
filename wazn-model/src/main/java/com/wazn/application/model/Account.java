package com.wazn.application.model;

import com.wazn.application.validation.Validator;

public class Account {

    private String email;
    private String mobile;
    private String fullName;
    private String verificationCode;
    private String password;
    private String confirmPassword;
    private AccountType accountType;
    private Integer status;

    public Account(String email, String mobile, String fullName, String verificationCode, String password, String confirmPassword, AccountType accountType, Integer status) {
        new Validator(email, mobile, fullName, password, confirmPassword);
        this.email = email;
        this.mobile = mobile;
        this.fullName = fullName;
        this.verificationCode = verificationCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.accountType = accountType;
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFullName() {
        return fullName;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Integer getStatus() {
        return status;
    }

    public static class Builder {

        private String email;
        private String mobile;
        private String fullName;
        private String verificationCode;
        private String password;
        private String confirmPassword;
        private AccountType accountType;
        private Integer status;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder verificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder confirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public Builder accountType(AccountType accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }
        public Account build() {
            return new Account(email, mobile, fullName, verificationCode, password, confirmPassword, accountType, status);
        }
    }
}
