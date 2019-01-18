package com.wazn.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "WAZN_ACCOUNT_RESULT")
public class ResultEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "ASS_DOC_BEARER", nullable = true)
    private Integer assessmentDocumentBearer;

    @Column(name = "FACE_MATCH", nullable = true)
    private Integer faceMatch;

    @Column(name = "MRZ", nullable = true)
    private Integer checkMRZ;

    @Column(name = "AUTO_AUTH", nullable = true)
    private Integer automationAuthentications;

    @OneToOne
    @JoinColumn(name = "MOBILE")
    private DocumentEntity documentEntity;

    public ResultEntity() {
    }

    public ResultEntity(String mobile, Integer assessmentDocumentBearer, Integer faceMatch, Integer checkMRZ, Integer automationAuthentications) {
        this.mobile = mobile;
        this.assessmentDocumentBearer = assessmentDocumentBearer;
        this.faceMatch = faceMatch;
        this.checkMRZ = checkMRZ;
        this.automationAuthentications = automationAuthentications;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getAssessmentDocumentBearer() {
        return assessmentDocumentBearer;
    }

    public void setAssessmentDocumentBearer(Integer assessmentDocumentBearer) {
        this.assessmentDocumentBearer = assessmentDocumentBearer;
    }

    public Integer getFaceMatch() {
        return faceMatch;
    }

    public void setFaceMatch(Integer faceMatch) {
        this.faceMatch = faceMatch;
    }

    public Integer getCheckMRZ() {
        return checkMRZ;
    }

    public void setCheckMRZ(Integer checkMRZ) {
        this.checkMRZ = checkMRZ;
    }

    public Integer getAutomationAuthentications() {
        return automationAuthentications;
    }

    public void setAutomationAuthentications(Integer automationAuthentications) {
        this.automationAuthentications = automationAuthentications;
    }

    public DocumentEntity getDocumentEntity() {
        return documentEntity;
    }

    public void setDocumentEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }
}
