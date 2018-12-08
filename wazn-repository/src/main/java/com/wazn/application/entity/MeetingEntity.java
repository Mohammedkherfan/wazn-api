package com.wazn.application.entity;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "WAZN_MEETING_SCHEDULE")
public class MeetingEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "NOTE", nullable = false)
    private String note;

    @OneToOne
    @JoinColumn(name = "MOBILE")
    private AccountEntity accountEntity;

    public MeetingEntity() {
    }

    public MeetingEntity(String mobile, LocalDateTime startDate, String note) {
        this.mobile = mobile;
        this.startDate = startDate;
        this.note = note;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
