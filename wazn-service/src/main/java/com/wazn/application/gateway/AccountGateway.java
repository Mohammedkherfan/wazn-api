package com.wazn.application.gateway;

import com.wazn.application.request.*;
import com.wazn.application.response.*;
import com.wazn.application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Blob;
import java.util.List;

public class AccountGateway {

    @Autowired
    private AccountService service;

    public AddAccountResponse addAccount(AddAccountRequest request) { return service.addAccount(request); }

    public GetAccountResponse getAccount(String mobile) {
        return service.getAccount(mobile);
    }

    public VerificationCodeResponse verifyCode(String mobile, String code) { return service.verifyCode(mobile, code); }

    public AddDocumentResponse addDocument(String mobile, AddDocumentRequest request) { return service.addDocument(mobile, request); }

    public LoginResponse login(String mobile, String password) { return service.login(mobile, password); }

    public void generateReport(String mobile) { service.generateReport(mobile); }

    public AddMeetingScheduleResponse addMeeting(String mobile, AddMeetingScheduleRequest request) { return service.addMeeting(mobile, request); }

    public List<ListMeetingResponse> listMeeting() { return service.listMeeting(); }

    public GetMeetingScheduleResponse getMeeting(String mobile) { return service.getMeeting(mobile); }

    public Boolean checkMeetingTime(String mobile) { return service.checkMeetingTime(mobile); }

    public UpdateMeetingScheduleResponse updateMeeting(String mobile, UpdateMeetingScheduleRequest request) { return service.updateMeeting(mobile, request); }

    public AddAccountTypeResponse addAccountType(String mobile, AddAccountTypeRequest request) { return service.addAccountType(mobile, request); }

    public GetAccountTypeResponse getAccountType(String mobile) { return service.getAccountType(mobile); }

    public UploadDocumentResponse uploadDocument(String mobile, UploadDocumentRequest request) { return service.uploadDocument(mobile, request); }

    public GetUploadedDocumentResponse getUploadedDocument(String mobile) { return service.getUploadedDocument(mobile); }

    public List<GetAllDataResponse> getAllData() {
        return service.getAllData();
    }

    public GetAllDataResponse getAllData(String mobile) {
        return service.getAllData(mobile);
    }

    public void updateStatus(String mobile, String status) {
        service.updateStatus(mobile, status);
    }

    public void saveComment(String mobile, String comment) {
        service.saveComment(mobile, comment);
    }

    public byte[] download(String mobile, String type) {
        return service.download(mobile, type);
    }
}

