package com.wazn.application.model;

import com.wazn.application.validation.Validator;

import java.time.LocalDateTime;

public class Meeting {

    private String mobile;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String note;

    public Meeting(String mobile, LocalDateTime startDate, LocalDateTime endDate,String note) {
        new Validator(mobile, startDate, endDate);
        this.mobile = mobile;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
    }

    public String getMobile() {
        return mobile;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getNote() {
        return note;
    }

    public static class Builder {

        private String mobile;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String note;

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder startDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder note(String  note) {
            this.note = note;
            return this;
        }

        public Meeting build() {
            return new Meeting(mobile, startDate, endDate, note);
        }
    }
}
