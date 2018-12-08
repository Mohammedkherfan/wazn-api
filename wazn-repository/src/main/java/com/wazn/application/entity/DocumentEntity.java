package com.wazn.application.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "WAZN_ACCOUNT_DOC")
public class DocumentEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "NATIONALITY", nullable = false)
    private String nationality;

    @Column(name = "DOC_TYPE", nullable = false)
    private String documentType;

    @Column(name = "DOC_NUMBER", nullable = false)
    private String documentNumber;

    @Column(name = "ISSUING_COUNTRY", nullable = false)
    private String issuingCountry;

    @Column(name = "PERSONAL_NUM", nullable = false)
    private String personalNumber;

    @Column(name = "REG_NUM", nullable = false)
    private String regNumber;

    @Column(name = "VALID_THROUGH", nullable = false)
    private LocalDate validThrough;

    @Column(name = "OWN_COMMENT", nullable = false, length = 1000000)
    private String ownComment;

    @Column(name = "HELP_COMMENT", nullable = false, length = 1000000)
    private String helpDeskComment;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "documentEntity", cascade = CascadeType.ALL)
    private AccountImageEntity accountImageEntity;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "documentEntity", cascade = CascadeType.ALL)
    private ReportEntity reportEntity;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "documentEntity", cascade = CascadeType.ALL)
    private ResultEntity resultEntity;

    @OneToOne
    @JoinColumn(name = "MOBILE")
    private AccountEntity accountEntity;

    public DocumentEntity() {
    }

    public DocumentEntity(String mobile, LocalDate birthDate, String gender, String nationality, String documentType, String documentNumber, String issuingCountry, String personalNumber, String regNumber, LocalDate validThrough, String ownComment, String helpDeskComment, AccountImageEntity accountImageEntity, ReportEntity reportEntity, ResultEntity resultEntity) {
        this.mobile = mobile;
        this.birthDate = birthDate;
        this.gender = gender;
        this.nationality = nationality;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issuingCountry = issuingCountry;
        this.personalNumber = personalNumber;
        this.regNumber = regNumber;
        this.validThrough = validThrough;
        this.ownComment = ownComment;
        this.helpDeskComment = helpDeskComment;
        this.accountImageEntity = accountImageEntity;
        this.reportEntity = reportEntity;
        this.resultEntity = resultEntity;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public LocalDate getValidThrough() {
        return validThrough;
    }

    public void setValidThrough(LocalDate validThrough) {
        this.validThrough = validThrough;
    }

    public String getOwnComment() {
        return ownComment;
    }

    public void setOwnComment(String ownComment) {
        this.ownComment = ownComment;
    }

    public String getHelpDeskComment() {
        return helpDeskComment;
    }

    public void setHelpDeskComment(String helpDeskComment) {
        this.helpDeskComment = helpDeskComment;
    }

    public AccountImageEntity getAccountImageEntity() {
        return accountImageEntity;
    }

    public void setAccountImageEntity(AccountImageEntity accountImageEntity) {
        this.accountImageEntity = accountImageEntity;
    }

    public ReportEntity getReportEntity() {
        return reportEntity;
    }

    public void setReportEntity(ReportEntity reportEntity) {
        this.reportEntity = reportEntity;
    }

    public ResultEntity getResultEntity() {
        return resultEntity;
    }

    public void setResultEntity(ResultEntity resultEntity) {
        this.resultEntity = resultEntity;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
