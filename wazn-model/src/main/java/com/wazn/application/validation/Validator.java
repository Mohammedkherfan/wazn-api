package com.wazn.application.validation;

import com.wazn.application.exception.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class Validator {

    public Validator(String documentType, String documentNumber, String issuingCountry, String personalNumber, LocalDate validThrough, LocalDate birthDate, String gender, String nationality) {
        this.documentTypeValidation.validate(documentType);
        this.documentNumberValidation.validate(documentNumber);
        this.issuingCountryValidation.validate(issuingCountry);
        this.personalNumberValidation.validate(personalNumber);
        this.validThroughValidation.validate(validThrough);
        this.birthDateValidation.validate(birthDate);
        this.genderValidation.validate(gender);
        this.nationalityValidation.validate(nationality);
    }

    public Validator(Boolean assessmentDocumentBearer, Boolean faceMatch, Boolean checkMRZ, Boolean automationAuthentications) {
        this.assessmentDocumentBearerValidation.validate(assessmentDocumentBearer);
        this.faceMatchValidation.validate(faceMatch);
        this.checkMRZValidation.validate(checkMRZ);
        this.automationAuthenticationsValidation.validate(automationAuthentications);
    }

    public Validator(LocalDateTime enteredOn, String location, String enteredBy) {
        this.enteredOnValidation.validate(enteredOn);
        this.locationValidation.validate(location);
        this.enteredByValidation.validate(enteredBy);
    }

    public Validator(byte[] documentIdImageFace, byte[] documentIdImageBack, byte[] personalImage) {
        this.documentIdImageFaceValidation.validate(documentIdImageFace);
        this.documentIdImageBackValidation.validate(documentIdImageBack);
        this.personalImageValidation.validate(personalImage);
    }

    public Validator(String email, String mobile, String fullName, String password, String confirmPassword) {
        this.emailValidation.validate(email);
        this.emailPatternValidation.validate(email);
        this.mobileValidation.validate(mobile);
        this.mobilePatternValidation.validate(mobile);
        this.nameValidation.validate(fullName);
        this.passwordValidation.validate(password);
        this.confirmPasswordValidation.validate(confirmPassword);
    }

    public Validator(String mobile, LocalDateTime startDate, LocalDateTime endDate) {
        this.mobileValidation.validate(mobile);
        this.mobilePatternValidation.validate(mobile);
        this.startDateValidation.validate(startDate);
        this.endDateValidation.validate(endDate);
        this.meetingTimeValidation(startDate, endDate);
    }

    private void meetingTimeValidation(LocalDateTime startDate, LocalDateTime endDate) {
        if (endDate.isBefore(startDate))
            throw new MeetingScheduleException("Invalid Meeting End Date Before Start Date !");
    }


    @FunctionalInterface
    public interface Validation<T> {
        void validate(T value);
    }

    private Validation<LocalDateTime> startDateValidation = (value -> {
        if (isNull(value) || value.isBefore(LocalDateTime.now())) {
            throw new MeetingScheduleException("Invalid Meeting Start Date");
        }
    });

    private Validation<LocalDateTime> endDateValidation = (value -> {
        if (isNull(value) || value.isBefore(LocalDateTime.now())) {
            throw new MeetingScheduleException("Invalid Meeting End Date");
        }
    });

    private Validation<Boolean> assessmentDocumentBearerValidation = (value -> {
        if (isNull(value)) {
            throw new ReportException("Invalid Report Assessment Document Bearer");
        }
    });

    private Validation<Boolean> faceMatchValidation = (value -> {
        if (isNull(value)) {
            throw new ReportException("Invalid Report Face Match");
        }
    });

    private Validation<Boolean> checkMRZValidation = (value -> {
        if (isNull(value)) {
            throw new ReportException("Invalid Report Check MRZ");
        }
    });

    private Validation<Boolean> automationAuthenticationsValidation = (value -> {
        if (isNull(value)) {
            throw new ReportException("Invalid Report Automation Authentications");
        }
    });

    private Validation<String> documentTypeValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Report Document Type");
        }
    });

    private Validation<String> documentNumberValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Report Document Number");
        }
    });

    private Validation<String> issuingCountryValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Report Issuing Country");
        }
    });

    private Validation<LocalDate> validThroughValidation = (value -> {
        if (isNull(value)) {
            throw new ReportException("Invalid Report Valid Through");
        }
    });

    private Validation<LocalDate> birthDateValidation = (value -> {
        if (isNull(value) || value.isAfter(LocalDate.now()) || value.equals(LocalDate.now())) {
            throw new ReportException("Invalid Report Birth Date");
        }
    });

    private Validation<String> genderValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Report Gender");
        }
    });

    private Validation<String> nationalityValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Report Nationality");
        }
    });

    private Validation<LocalDateTime> enteredOnValidation = (value -> {
        if (isNull(value) || value.toLocalDate().isBefore(LocalDate.now())) {
            throw new ReportException("Invalid Report Entered On Date");
        }
    });

    private Validation<String> locationValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Report Location");
        }
    });

    private Validation<String> enteredByValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Report Entered By");
        }
    });

    private Validation<String> emailValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidAccountEmailException("Invalid Email");
        }
    });

    private Validation<String> emailPatternValidation = (value -> {
        EmailValidator validator = new EmailValidator();
        if (!validator.validateEmail(value)) {
            throw new InvalidAccountEmailException("Invalid Email");
        }
    });

    private Validation<String> mobileValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidAccountMobileException("Invalid Mobile");
        }
    });

    private Validation<String> mobilePatternValidation = (value -> {
        MobileValidator validator = new MobileValidator();
        if (!validator.validateMobile(value)) {
            throw new InvalidAccountEmailException("Invalid Mobile");
        }
    });

    private Validation<String> nameValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidAccountNameException("Invalid Full Name");
        }
    });

    private Validation<String> passwordValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidAccountPasswordException("Invalid Password");
        }
    });

    private Validation<String> confirmPasswordValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new InvalidAccountConfirmPasswordException("Invalid Confirm Password");
        }
    });

    private Validation<byte[]> documentIdImageFaceValidation = (value -> {
        if (isNull(value) || value.length == 0) {
            throw new InvalidAccountDocumentIdImageFaceException("Invalid Document Id Image Face");
        }
    });

    private Validation<byte[]> documentIdImageBackValidation = (value -> {
        if (isNull(value) || value.length == 0) {
            throw new InvalidAccountDocumentIdImageBackException("Invalid Document Id Image Back");
        }
    });

    private Validation<byte[]> personalImageValidation = (value -> {
        if (isNull(value) || value.length == 0) {
            throw new InvalidAccountPersonalImageException("Invalid Personal Image");
        }
    });

    private Validation<String> personalNumberValidation = (value -> {
        if (isNull(value) || value.trim().isEmpty()) {
            throw new ReportException("Invalid Personal Number");
        }
    });
}
