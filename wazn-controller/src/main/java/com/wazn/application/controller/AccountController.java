package com.wazn.application.controller;

import com.wazn.application.request.*;
import com.wazn.application.response.*;
import org.springframework.hateoas.Resource;

import java.util.List;

public interface AccountController {

    Resource<AddAccountResponse> addAccount(AddAccountRequest request);

    Resource<GetAccountResponse> getAccount(String mobile);

    Resource<VerificationCodeResponse> verifyCode(String mobile, String code);

    Resource<AddDocumentResponse> addDocument(String mobile, AddDocumentRequest request);

    Resource<LoginResponse> login(String mobile, String password);

    void generateReport(String mobile);

    Resource<AddMeetingScheduleResponse> addMeeting(String mobile, AddMeetingScheduleRequest request);

    List<Resource<ListMeetingResponse>> listMeeting();

    Resource<GetMeetingScheduleResponse> getMeeting(String mobile);

    Boolean checkMeetingTime(String mobile);

    Resource<UpdateMeetingScheduleResponse> updateMeeting(String mobile, UpdateMeetingScheduleRequest request);

    Resource<AddAccountTypeResponse> addAccountType(String mobile, AddAccountTypeRequest request);

    Resource<GetAccountTypeResponse> getAccountType(String mobile);
}
