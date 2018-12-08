package com.wazn.application.entity;

import javax.persistence.*;
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

    @Column(name = "STATUS", nullable = false)
    private Integer status;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "accountEntity", cascade = CascadeType.ALL)
    private AccountTypeEntity accountTypeEntity;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "accountEntity", cascade = CascadeType.ALL)
    private DocumentEntity documentEntity;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "accountEntity", cascade = CascadeType.ALL)
    private MeetingEntity meetingEntity;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "accountEntity", cascade = CascadeType.ALL)
    private UploadDocumentEntity uploadDocumentEntity;

    public AccountEntity() {
    }

    public AccountEntity(String mobile, String email, String name, String verificationCode, String password, Integer status, AccountTypeEntity accountTypeEntity, DocumentEntity documentEntity, MeetingEntity meetingEntity, UploadDocumentEntity uploadDocumentEntity) {
        this.mobile = mobile;
        this.email = email;
        this.name = name;
        this.status = status;
        this.verificationCode = verificationCode;
        this.password = password;
        this.accountTypeEntity = accountTypeEntity;
        this.documentEntity = documentEntity;
        this.meetingEntity = meetingEntity;
        this.uploadDocumentEntity = uploadDocumentEntity;
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

    public AccountTypeEntity getAccountTypeEntity() {
        return accountTypeEntity;
    }

    public void setAccountTypeEntity(AccountTypeEntity accountTypeEntity) {
        this.accountTypeEntity = accountTypeEntity;
    }

    public DocumentEntity getDocumentEntity() {
        return documentEntity;
    }

    public void setDocumentEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }

    public MeetingEntity getMeetingEntity() {
        return meetingEntity;
    }

    public void setMeetingEntity(MeetingEntity meetingEntity) {
        this.meetingEntity = meetingEntity;
    }

    public UploadDocumentEntity getUploadDocumentEntity() {
        return uploadDocumentEntity;
    }

    public void setUploadDocumentEntity(UploadDocumentEntity uploadDocumentEntity) {
        this.uploadDocumentEntity = uploadDocumentEntity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
