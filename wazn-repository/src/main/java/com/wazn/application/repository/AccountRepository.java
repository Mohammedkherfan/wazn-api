package com.wazn.application.repository;

import com.wazn.application.model.Account;
import com.wazn.application.model.Document;
import com.wazn.application.model.Meeting;

import java.util.List;

public interface AccountRepository {

    String addAccount(Account account);

    Account getAccount(String mobile);

    String addDocument(Document document);

    Document getDocument(String mobile);

    String addMeeting(Meeting meeting);

    List<Meeting> listMeeting();
}
