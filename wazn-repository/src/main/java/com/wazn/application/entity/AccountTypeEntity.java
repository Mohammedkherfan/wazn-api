package com.wazn.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "WAZN_ACCOUNT_TYPE")
public class AccountTypeEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "ACCOUNT_TYPE", nullable = false)
    private Integer type;

    public AccountTypeEntity() {
    }

    public AccountTypeEntity(String mobile, Integer type) {
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
