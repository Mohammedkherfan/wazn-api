package com.wazn.application.model;

import com.wazn.application.validation.Validator;

public class Result {

    private Boolean assessmentDocumentBearer;
    private Boolean faceMatch;
    private Boolean checkMRZ;
    private Boolean automationAuthentications;

    public Result(Boolean assessmentDocumentBearer, Boolean faceMatch, Boolean checkMRZ, Boolean automationAuthentications) {
        new Validator(assessmentDocumentBearer, faceMatch, checkMRZ, automationAuthentications);
        this.assessmentDocumentBearer = assessmentDocumentBearer;
        this.faceMatch = faceMatch;
        this.checkMRZ = checkMRZ;
        this.automationAuthentications = automationAuthentications;
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

    public static class Builder {

        private Boolean assessmentDocumentBearer;
        private Boolean faceMatch;
        private Boolean checkMRZ;
        private Boolean automationAuthentications;

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

        public Result build() {
            return new Result(assessmentDocumentBearer, faceMatch, checkMRZ, automationAuthentications);
        }
    }
}
