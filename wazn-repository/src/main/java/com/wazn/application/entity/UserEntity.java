package com.wazn.application.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WAZN_USERS")
public class UserEntity {

    @Id
    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String userName;

    @Column(name = "PASSWORD", nullable = true)
    private String password;

    @Column(name = "FULL_NAME", nullable = true)
    private String fullName;

    @Column(name = "BUSS_UNIT", nullable = true)
    private String businessUnit;

    @Column(name = "ROLE", nullable = true)
    private Integer role;

    @Column(name = "MOBILE", nullable = true)
    private String phoneNumber;

    @Column(name = "ADDRESS", nullable = true)
    private String address;

    @Column(name = "EMAIL", nullable = true)
    private String email;

    public UserEntity() {
    }

    public UserEntity(String userName, String password, String fullName, String businessUnit, Integer role, String phoneNumber, String address, String email) {
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
