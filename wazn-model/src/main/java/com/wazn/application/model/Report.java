package com.wazn.application.model;

import com.wazn.application.validation.Validator;

import java.time.LocalDateTime;

public class Report {

    private LocalDateTime enteredOn;
    private String location;
    private String enteredBy;

    public Report(LocalDateTime enteredOn, String location, String enteredBy) {
        new Validator(enteredOn, location, enteredBy);
        this.enteredOn = enteredOn;
        this.location = location;
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredOn() {
        return enteredOn;
    }

    public String getLocation() {
        return location;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public static class Builder {

        private LocalDateTime enteredOn;
        private String location;
        private String enteredBy;

        public Builder enteredOn(LocalDateTime enteredOn) {
            this.enteredOn = enteredOn;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder enteredBy(String enteredBy) {
            this.enteredBy = enteredBy;
            return this;
        }

        public Report build() {
            return new Report(enteredOn, location, enteredBy);
        }
    }
}
