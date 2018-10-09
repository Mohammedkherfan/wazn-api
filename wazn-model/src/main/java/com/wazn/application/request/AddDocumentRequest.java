package com.wazn.application.request;

public class AddDocumentRequest {

    private String documentType;
    private String documentNumber;
    private String issuingCountry;
    private String personalNumber;
    private String regNumber;
    private String validThrough;
    private String ownComment;
    private String helpDeskComment;
    private String birthDate;
    private String gender;
    private String nationality;

    private byte[] documentIdImageFace;
    private byte[] documentIdImageBack;
    private byte[] personalImage;

    private String enteredOn;
    private String location;
    private String enteredBy;

    private Boolean assessmentDocumentBearer;
    private Boolean faceMatch;
    private Boolean checkMRZ;
    private Boolean automationAuthentications;

    public AddDocumentRequest() {
    }

    public AddDocumentRequest(String documentType, String documentNumber, String issuingCountry, String personalNumber, String regNumber, String validThrough, String ownComment, String helpDeskComment, String birthDate, String gender, String nationality, byte[] documentIdImageFace, byte[] documentIdImageBack, byte[] personalImage, String enteredOn, String location, String enteredBy, Boolean assessmentDocumentBearer, Boolean faceMatch, Boolean checkMRZ, Boolean automationAuthentications) {
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
        this.enteredOn = enteredOn;
        this.location = location;
        this.enteredBy = enteredBy;
        this.assessmentDocumentBearer = assessmentDocumentBearer;
        this.faceMatch = faceMatch;
        this.checkMRZ = checkMRZ;
        this.automationAuthentications = automationAuthentications;
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

    public String getValidThrough() {
        return validThrough;
    }

    public void setValidThrough(String validThrough) {
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

    public byte[] getDocumentIdImageFace() {
        return documentIdImageFace;
    }

    public void setDocumentIdImageFace(byte[] documentIdImageFace) {
        this.documentIdImageFace = documentIdImageFace;
    }

    public byte[] getDocumentIdImageBack() {
        return documentIdImageBack;
    }

    public void setDocumentIdImageBack(byte[] documentIdImageBack) {
        this.documentIdImageBack = documentIdImageBack;
    }

    public byte[] getPersonalImage() {
        return personalImage;
    }

    public void setPersonalImage(byte[] personalImage) {
        this.personalImage = personalImage;
    }

    public String getEnteredOn() {
        return enteredOn;
    }

    public void setEnteredOn(String enteredOn) {
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

    public Boolean getAssessmentDocumentBearer() {
        return assessmentDocumentBearer;
    }

    public void setAssessmentDocumentBearer(Boolean assessmentDocumentBearer) {
        this.assessmentDocumentBearer = assessmentDocumentBearer;
    }

    public Boolean getFaceMatch() {
        return faceMatch;
    }

    public void setFaceMatch(Boolean faceMatch) {
        this.faceMatch = faceMatch;
    }

    public Boolean getCheckMRZ() {
        return checkMRZ;
    }

    public void setCheckMRZ(Boolean checkMRZ) {
        this.checkMRZ = checkMRZ;
    }

    public Boolean getAutomationAuthentications() {
        return automationAuthentications;
    }

    public void setAutomationAuthentications(Boolean automationAuthentications) {
        this.automationAuthentications = automationAuthentications;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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
}
