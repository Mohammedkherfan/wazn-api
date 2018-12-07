package com.wazn.application.service;

import com.wazn.application.exception.InvalidAccountMobileException;
import com.wazn.application.exception.InvalidAccountPasswordException;
import com.wazn.application.exception.InvalidAccountRequestException;
import com.wazn.application.exception.InvalidVerificationCodeException;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.*;
import com.wazn.application.response.*;
import com.wazn.application.usecase.*;
import com.wazn.application.validation.MobileValidator;

import java.util.List;

import static java.util.Objects.isNull;

public class AccountServiceImp implements AccountService {

    private AddAccountUseCase addAccountUseCase;
    private GetAccountUseCase getAccountUseCase;
    private VerificationCodeUseCase verificationCodeUseCase;
    private AddDocumentUseCase addDocumentUseCase;
    private LoginUseCase loginUseCase;
    private GenerateReportUseCase generateReportUseCase;
    private AddMeetingScheduleUseCase addMeetingScheduleUseCase;
    private ListMeetingUseCase listMeetingUseCase;
    private GetMeetingScheduleUseCase getMeetingScheduleUseCase;
    private CheckMeetingTimeUseCase checkMeetingTimeUseCase;
    private UpdateMeetingScheduleUseCase updateMeetingScheduleUseCase;
    private AddAccountTypeUseCase addAccountTypeUseCase;
    private GetAccountTypeUseCase getAccountTypeUseCase;
    private UploadDocumentUseCase uploadDocumentUseCase;
    private GetUploadedDocumentUseCase getUploadedDocumentUseCase;

    public AccountServiceImp(AccountRepository repository) {
        this.addAccountUseCase = new AddAccountUseCaseImp(repository);
        this.getAccountUseCase = new GetAccountUseCaseImp(repository);
        this.verificationCodeUseCase = new VerificationCodeUseCaseImp(repository);
        this.addDocumentUseCase = new AddDocumentUseCaseImp(repository);
        this.loginUseCase = new LoginUseCaseImp(repository);
        this.generateReportUseCase = new GenerateReportUseCaseImp(repository);
        this.addMeetingScheduleUseCase = new AddMeetingScheduleUseCaseImp(repository);
        this.listMeetingUseCase = new ListMeetingUseCaseImp(repository);
        this.getMeetingScheduleUseCase = new GetMeetingScheduleUseCaseImp(repository);
        this.checkMeetingTimeUseCase = new CheckMeetingTimeUseCaseImp(repository);
        this.updateMeetingScheduleUseCase = new UpdateMeetingScheduleUseCaseImp(repository);
        this.addAccountTypeUseCase = new AddAccountTypeUseCaseImp(repository);
        this.getAccountTypeUseCase = new GetAccountTypeUseCaseImp(repository);
        this.uploadDocumentUseCase = new UploadDocumentUseCaseImp(repository);
        this.getUploadedDocumentUseCase = new GetUploadedDocumentUseCaseImp(repository);
    }

    @Override
    public AddAccountResponse addAccount(AddAccountRequest request) {
        if (isNull(request)) throw new InvalidAccountRequestException("Invalid Request");
        return addAccountUseCase.addAccount(request);
    }

    @Override
    public GetAccountResponse getAccount(String mobile) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        return getAccountUseCase.getAccount(mobile);
    }

    @Override
    public VerificationCodeResponse verifyCode(String mobile, String code) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        if (isNull(code) || code.trim().isEmpty()) throw new InvalidVerificationCodeException("Invalid Verification Code");
        return verificationCodeUseCase.verifyCode(mobile, code);
    }

    @Override
    public AddDocumentResponse addDocument(String mobile, AddDocumentRequest request) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        if (isNull(request)) throw new InvalidAccountRequestException("Invalid Request");
        return addDocumentUseCase.addDocument(mobile, request);
    }

    @Override
    public LoginResponse login(String mobile, String password) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        if (isNull(password) || password.trim().isEmpty()) throw new InvalidAccountPasswordException("Invalid Password (Password Empty)");
        return loginUseCase.login(mobile, password);
    }

    @Override
    public void generateReport(String mobile) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        generateReportUseCase.generateReport(mobile);
    }

    @Override
    public AddMeetingScheduleResponse addMeeting(String mobile, AddMeetingScheduleRequest request) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        if (isNull(request)) throw new InvalidAccountRequestException("Invalid Request");
        return addMeetingScheduleUseCase.addMeeting(mobile, request);
    }

    @Override
    public List<ListMeetingResponse> listMeeting() {
        return listMeetingUseCase.listMeeting();
    }

    @Override
    public GetMeetingScheduleResponse getMeeting(String mobile) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        return getMeetingScheduleUseCase.getMeeting(mobile);
    }

    @Override
    public Boolean checkMeetingTime(String mobile) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        return checkMeetingTimeUseCase.checkMeetingTime(mobile);
    }

    @Override
    public UpdateMeetingScheduleResponse updateMeeting(String mobile, UpdateMeetingScheduleRequest request) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        if (isNull(request)) throw new InvalidAccountRequestException("Invalid Request");
        return updateMeetingScheduleUseCase.updateMeeting(mobile, request);
    }

    @Override
    public AddAccountTypeResponse addAccountType(String mobile, AddAccountTypeRequest request) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        if (isNull(request)) throw new InvalidAccountRequestException("Invalid Request");
        return addAccountTypeUseCase.addAccountType(mobile, request);
    }

    @Override
    public GetAccountTypeResponse getAccountType(String mobile) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        return getAccountTypeUseCase.getAccountType(mobile);
    }

    @Override
    public UploadDocumentResponse uploadDocument(String mobile, UploadDocumentRequest request) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        if (isNull(request)) throw new InvalidAccountRequestException("Invalid Request");
        return uploadDocumentUseCase.uploadDocument(mobile, request);
    }

    @Override
    public GetUploadedDocumentResponse getUploadedDocument(String mobile) {
        MobileValidator mobileValidator = new MobileValidator();
        if (isNull(mobile) || mobile.trim().isEmpty()) throw new InvalidAccountMobileException("Invalid Mobile");
        if (!mobileValidator.validateMobile(mobile)) throw new InvalidAccountMobileException("Invalid Mobile");
        return getUploadedDocumentUseCase.getUploadedDocument(mobile);
    }
}
