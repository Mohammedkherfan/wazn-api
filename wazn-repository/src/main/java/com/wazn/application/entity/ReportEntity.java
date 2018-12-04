package com.wazn.application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "WAZN_ACCOUNT_REPORT")
public class ReportEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "ENTERED_ON", nullable = false)
    private LocalDateTime enteredOn;

    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Column(name = "ENTERED_BY", nullable = false)
    private String enteredBy;

    @OneToOne
    @JoinColumn(name = "MOBILE")
    private DocumentEntity documentEntity;

    public ReportEntity() {
    }

    public ReportEntity(String mobile, LocalDateTime enteredOn, String location, String enteredBy) {
        this.mobile = mobile;
        this.enteredOn = enteredOn;
        this.location = location;
        this.enteredBy = enteredBy;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getEnteredOn() {
        return enteredOn;
    }

    public void setEnteredOn(LocalDateTime enteredOn) {
        this.enteredOn = enteredOn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public DocumentEntity getDocumentEntity() {
        return documentEntity;
    }

    public void setDocumentEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }
}
