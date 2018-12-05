package com.wazn.application.service;

import com.wazn.application.request.*;
import com.wazn.application.response.*;

import java.util.List;

public interface AccountService {

    AddAccountResponse addAccount(AddAccountRequest request);

    GetAccountResponse getAccount(String mobile);

    VerificationCodeResponse verifyCode(String mobile, String code);

    AddDocumentResponse addDocument(String mobile, AddDocumentRequest request);

    LoginResponse login(String mobile, String password);

    void generateReport(String mobile);

    AddMeetingScheduleResponse addMeeting(String mobile, AddMeetingScheduleRequest request);

    List<ListMeetingResponse> listMeeting();

    GetMeetingScheduleResponse getMeeting(String mobile);

    Boolean checkMeetingTime(String mobile);

    UpdateMeetingScheduleResponse updateMeeting(String mobile, UpdateMeetingScheduleRequest request);

    AddAccountTypeResponse addAccountType(String mobile, AddAccountTypeRequest request);

    GetAccountTypeResponse getAccountType(String mobile);

    UploadDocumentResponse uploadDocument(String mobile, UploadDocumentRequest request);
}
