package com.wazn.application.model;

public class User {

    private String userName;
    private String password;
    private String fullName;
    private String businessUnit;
    private Integer role;
    private String phoneNumber;
    private String address;
    private String email;

    public User(String userName, String password, String fullName, String businessUnit, Integer role, String phoneNumber, String address, String email) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.businessUnit = businessUnit;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public Integer getRole() {
        return role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {

        private String userName;
        private String password;
        private String fullName;
        private String businessUnit;
        private Integer role;
        private String phoneNumber;
        private String address;
        private String email;

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder businessUnit(String businessUnit) {
            this.businessUnit = businessUnit;
            return this;
        }

        public Builder role(Integer role) {
            this.role = role;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(userName, password, fullName, businessUnit, role, phoneNumber, address, email);
        }
    }
}
