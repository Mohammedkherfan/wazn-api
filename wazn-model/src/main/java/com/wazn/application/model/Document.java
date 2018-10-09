package com.wazn.application.model;

import com.wazn.application.validation.Validator;

import java.time.LocalDate;

public class Document {

    private String mobile;
    private String documentType;
    private String documentNumber;
    private String issuingCountry;
    private String personalNumber;
    private String regNumber;
    private LocalDate validThrough;
    private String ownComment;
    private String helpDeskComment;
    private LocalDate birthDate;
    private String gender;
    private String nationality;
    private Image image;
    private Report report;
    private Result result;

    public Document(String mobile, String documentType, String documentNumber, String issuingCountry, String personalNumber, String regNumber, LocalDate validThrough, String ownComment, String helpDeskComment, LocalDate birthDate, String gender, String nationality, Image image, Report report, Result result) {
        new Validator(documentType, documentNumber, issuingCountry, personalNumber, validThrough, birthDate,  gender, nationality);
        this.mobile = mobile;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issuingCountry = issuingCountry;
        this.personalNumber = personalNumber;
        this.regNumber = regNumber;
        this.validThrough = validThrough;
        this.ownComment = ownComment;
        this.helpDeskComment = helpDeskComment;
        this.birthDate = birthDate;
        this.gender =gender;
        this.nationality = nationality;
        this.image = image;
        this.report = report;
        this.result = result;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public LocalDate getValidThrough() {
        return validThrough;
    }

    public String getOwnComment() {
        return ownComment;
    }

    public String getHelpDeskComment() {
        return helpDeskComment;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getNationality() {
        return nationality;
    }

    public Image getImage() {
        return image;
    }

    public Report getReport() {
        return report;
    }

    public Result getResult() {
        return result;
    }

    public static class Builder {

        private String mobile;
        private String documentType;
        private String documentNumber;
        private String issuingCountry;
        private String personalNumber;
        private String regNumber;
        private LocalDate validThrough;
        private String ownComment;
        private String helpDeskComment;
        private LocalDate birthDate;
        private String gender;
        private String nationality;
        private Image image;
        private Report report;
        private Result result;

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder documentType(String documentType) {
            this.documentType = documentType;
            return this;
        }

        public Builder documentNumber(String documentNumber) {
            this.documentNumber = documentNumber;
            return this;
        }

        public Builder issuingCountry(String issuingCountry) {
            this.issuingCountry = issuingCountry;
            return this;
        }

        public Builder personalNumber(String personalNumber) {
            this.personalNumber = personalNumber;
            return this;
        }

        public Builder regNumber(String regNumber) {
            this.regNumber = regNumber;
            return this;
        }

        public Builder validThrough(LocalDate validThrough) {
            this.validThrough = validThrough;
            return this;
        }

        public Builder ownComment(String ownComment) {
            this.ownComment = ownComment;
            return this;
        }

        public Builder helpDeskComment(String helpDeskComment) {
            this.helpDeskComment = helpDeskComment;
            return this;
        }

        public Builder image(Image image) {
            this.image = image;
            return this;
        }

        public Builder result(Result result) {
            this.result = result;
            return this;
        }

        public Builder report(Report report) {
            this.report = report;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder nationality(String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Document build() {
            return new Document(mobile, documentType, documentNumber, issuingCountry, personalNumber, regNumber, validThrough, ownComment, helpDeskComment, birthDate, gender, nationality, image, report, result);
        }
    }
}
