package com.wazn.application.model;

import com.wazn.application.validation.Validator;

import java.time.LocalDateTime;

public class Meeting {

    private String mobile;
    private LocalDateTime startDate;
    private String note;
    private Integer status;

    public Meeting(String mobile, LocalDateTime startDate,String note, Integer status) {
        new Validator(mobile, startDate);
        this.mobile = mobile;
        this.startDate = startDate;
        this.note = note;
        this.status = status;
    }

    public Meeting(String mobile,String note , LocalDateTime startDate, Integer status) {
        this.mobile = mobile;
        this.startDate = startDate;
        this.note = note;
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public String getNote() {
        return note;
    }

    public Integer getStatus() {
        return status;
    }

    public static class Builder {

        private String mobile;
        private LocalDateTime startDate;
        private String note;
        private Integer status;

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder note(String  note) {
            this.note = note;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Meeting build() {
            return new Meeting(mobile, startDate, note, status);
        }

        public Meeting getBuild() {
            return new Meeting(mobile, note, startDate, status);
        }
    }
}
