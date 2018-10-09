package com.wazn.application.gateway;

import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.request.AddMeetingScheduleRequest;
import com.wazn.application.response.*;
import com.wazn.application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

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
}
