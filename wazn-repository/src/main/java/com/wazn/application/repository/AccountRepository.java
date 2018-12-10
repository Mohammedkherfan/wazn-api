package com.wazn.application.repository;

import com.wazn.application.model.*;

import java.util.List;

public interface AccountRepository {

    String addAccount(Account account);

    Account getAccount(String mobile);

    String addDocument(Document document);

    Document getDocument(String mobile);

    String addMeeting(Meeting meeting);

    List<Meeting> listMeeting();

    Meeting getMeeting(String mobile);

    String updateMeeting(Meeting meeting);

    String addAccountType(AccountType accountType);

    AccountType getAccountType(String mobile);

    String uploadDocument(UploadDocument uploadDocument);

    UploadDocument getUploadedDocument(String mobile);

    List<AllData> getAllData();

    AllData getAllData(String mobile);

    void updateStatus(String mobile, Integer status);

    void saveComment(String mobile, String comment);
}
