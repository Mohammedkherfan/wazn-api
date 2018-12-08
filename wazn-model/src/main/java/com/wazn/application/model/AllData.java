package com.wazn.application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AllData {

    private String email;
    private String mobile;
    private String fullName;
    private String verificationCode;
    private String password;
    private String confirmPassword;
    private Integer status;

    private Integer type;

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

    private byte[] documentIdImageFace;
    private byte[] documentIdImageBack;
    private byte[] personalImage;

    private LocalDateTime startDate;
    private String note;

    private LocalDateTime enteredOn;
    private String location;
    private String enteredBy;

    private Boolean assessmentDocumentBearer;
    private Boolean faceMatch;
    private Boolean checkMRZ;
    private Boolean automationAuthentications;

    private byte[] passportOrVisaImage;
    private byte[] salaryCertificateImage;
    private byte[] taxDeclarationImage;

    public AllData() {
    }

    public AllData(String email, String mobile, String fullName, String verificationCode, String password, String confirmPassword, Integer type, String documentType, String documentNumber, String issuingCountry, String personalNumber, String regNumber, LocalDate validThrough, String ownComment, String helpDeskComment, LocalDate birthDate, String gender, String nationality, byte[] documentIdImageFace, byte[] documentIdImageBack, byte[] personalImage, LocalDateTime startDate, String note, LocalDateTime enteredOn, String location, String enteredBy, Boolean assessmentDocumentBearer, Boolean faceMatch, Boolean checkMRZ, Boolean automationAuthentications, byte[] passportOrVisaImage, byte[] salaryCertificateImage, byte[] taxDeclarationImage, Integer status) {
        this.email = email;
        this.mobile = mobile;
        this.fullName = fullName;
        this.verificationCode = verificationCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.type = type;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issuingCountry = issuingCountry;
        this.personalNumber = personalNumber;
        this.regNumber = regNumber;
        this.validThrough = validThrough;
        this.ownComment = ownComment;
        this.helpDeskComment = helpDeskComment;
        this.birthDate = birthDate;
        this.gender = gender;
        this.nationality = nationality;
        this.documentIdImageFace = documentIdImageFace;
        this.documentIdImageBack = documentIdImageBack;
        this.personalImage = personalImage;
        this.startDate = startDate;
        this.note = note;
        this.enteredOn = enteredOn;
        this.location = location;
        this.enteredBy = enteredBy;
        this.assessmentDocumentBearer = assessmentDocumentBearer;
        this.faceMatch = faceMatch;
        this.checkMRZ = checkMRZ;
        this.automationAuthentications = automationAuthentications;
        this.passportOrVisaImage = passportOrVisaImage;
        this.salaryCertificateImage = salaryCertificateImage;
        this.taxDeclarationImage = taxDeclarationImage;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFullName() {
        return fullName;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public Integer getType() {
        return type;
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

    public byte[] getDocumentIdImageFace() {
        return documentIdImageFace;
    }

    public byte[] getDocumentIdImageBack() {
        return documentIdImageBack;
    }

    public byte[] getPersonalImage() {
        return personalImage;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public String getNote() {
        return note;
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

    public Boolean getAssessmentDocumentBearer() {
        return assessmentDocumentBearer;
    }

    public Boolean getFaceMatch() {
        return faceMatch;
    }

    public Boolean getCheckMRZ() {
        return checkMRZ;
    }

    public Boolean getAutomationAuthentications() {
        return automationAuthentications;
    }

    public byte[] getPassportOrVisaImage() {
        return passportOrVisaImage;
    }

    public byte[] getSalaryCertificateImage() {
        return salaryCertificateImage;
    }

    public byte[] getTaxDeclarationImage() {
        return taxDeclarationImage;
    }

    public static class Builder {

        private String email;
        private String mobile;
        private String fullName;
        private String verificationCode;
        private String password;
        private String confirmPassword;
        private Integer status;

        private Integer type;

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

        private byte[] documentIdImageFace;
        private byte[] documentIdImageBack;
        private byte[] personalImage;

        private LocalDateTime startDate;
        private String note;

        private LocalDateTime enteredOn;
        private String location;
        private String enteredBy;

        private Boolean assessmentDocumentBearer;
        private Boolean faceMatch;
        private Boolean checkMRZ;
        private Boolean automationAuthentications;

        private byte[] passportOrVisaImage;
        private byte[] salaryCertificateImage;
        private byte[] taxDeclarationImage;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder verificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder confirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public Builder type(Integer type) {
            this.type = type;
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

        public Builder documentIdImageFace(byte[] documentIdImageFace) {
            this.documentIdImageFace = documentIdImageFace;
            return this;
        }

        public Builder documentIdImageBack(byte[] documentIdImageBack) {
            this.documentIdImageBack = documentIdImageBack;
            return this;
        }

        public Builder personalImage(byte[] personalImage) {
            this.personalImage = personalImage;
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

        public Builder assessmentDocumentBearer(Boolean assessmentDocumentBearer) {
            this.assessmentDocumentBearer = assessmentDocumentBearer;
            return this;
        }

        public Builder faceMatch(Boolean faceMatch) {
            this.faceMatch = faceMatch;
            return this;
        }

        public Builder checkMRZ(Boolean checkMRZ) {
            this.checkMRZ = checkMRZ;
            return this;
        }

        public Builder automationAuthentications(Boolean automationAuthentications) {
            this.automationAuthentications = automationAuthentications;
            return this;
        }


        public Builder passportOrVisaImage(byte[] passportOrVisaImage) {
            this.passportOrVisaImage = passportOrVisaImage;
            return this;
        }

        public Builder salaryCertificateImage(byte[] salaryCertificateImage) {
            this.salaryCertificateImage = salaryCertificateImage;
            return this;
        }

        public Builder taxDeclarationImage(byte[] taxDeclarationImage) {
            this.taxDeclarationImage = taxDeclarationImage;
            return this;
        }


        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public AllData build() {
            return new AllData(email, mobile, fullName, verificationCode, password, confirmPassword, type, documentType, documentNumber, issuingCountry, personalNumber, regNumber, validThrough, ownComment, helpDeskComment, birthDate, gender, nationality, documentIdImageFace, documentIdImageBack, personalImage, startDate, note, enteredOn, location, enteredBy, assessmentDocumentBearer, faceMatch, checkMRZ, automationAuthentications, passportOrVisaImage, salaryCertificateImage, taxDeclarationImage, status);
        }
    }
}
