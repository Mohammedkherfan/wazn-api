package com.wazn.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "WAZN_ACCOUNT")
public class AccountEntity implements Serializable {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "FULL_NAME", nullable = false)
    private String name;

    @Column(name = "VERIFICATION_CODE", nullable = false)
    private String verificationCode;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    public AccountEntity() {
    }

    public AccountEntity(String mobile, String email, String name, String verificationCode, String password) {
        this.mobile = mobile;
        this.email = email;
        this.name = name;
        this.verificationCode = verificationCode;
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
