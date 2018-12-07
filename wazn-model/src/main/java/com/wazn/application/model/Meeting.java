package com.wazn.application.model;

import com.wazn.application.validation.Validator;

import java.time.LocalDateTime;

public class Meeting {

    private String mobile;
    private LocalDateTime startDate;
    private String note;

    public Meeting(String mobile, LocalDateTime startDate,String note) {
        new Validator(mobile, startDate);
        this.mobile = mobile;
        this.startDate = startDate;
        this.note = note;
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

    public static class Builder {

        private String mobile;
        private LocalDateTime startDate;
        private String note;

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

        public Meeting build() {
            return new Meeting(mobile, startDate, note);
        }
    }
}
