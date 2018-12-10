package com.wazn.application.test.repository;

import com.wazn.application.exception.*;
import com.wazn.application.model.*;
import com.wazn.application.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountTestRepository implements AccountRepository  {

    private List<Account> listAccount = new ArrayList<>();
    private List<Document> listDocument = new ArrayList<>();
    private List<Meeting> listMeeting = new ArrayList<>();
    private List<AccountType> listAccountType = new ArrayList<>();
    private List<UploadDocument> listUploadDocuments = new ArrayList<>();

    @Override
    public String addAccount(Account account) {
        listAccount.forEach(e -> {
            if (e.getMobile().equals(account.getMobile()))
                throw new AccountAlreadyExistException("Account Already Exist !");
        });
        listAccount.add(account);
        return account.getMobile();
    }

    @Override
    public Account getAccount(String mobile) {
        for (Account account : listAccount) {
            if (account.getMobile().equals(mobile))
                return account;
        }
        throw new AccountNotFoundException("Account Not Found !");
    }

    @Override
    public String addDocument(Document document) {
        Boolean check = null;
        for (Account account : listAccount) {
            if (account.getMobile().equals(document.getMobile()))
                check = Boolean.TRUE;
            else
                check = Boolean.FALSE;
        }

        if (check) {
            for (Document document1 : listDocument) {
                if (document1.getMobile().equals(document.getMobile()))
                    throw new DocumentAlreadyExistException("Document Already Exist");
            }
        } else {
            throw new AccountNotFoundException("Account Not Found");
        }

        listDocument.add(document);
        return document.getMobile();
    }

    @Override
    public Document getDocument(String mobile) {
        for (Document document : listDocument) {
            if (document.getMobile().equals(mobile))
                return document;
        }
        throw new DocumentNotFoundException("Document Not Found !");
    }

    @Override
    public String addMeeting(Meeting meeting) {
        Boolean check = null;
        for (Account account : listAccount) {
            if (account.getMobile().equals(meeting.getMobile()))
                check = Boolean.TRUE;
            else
                check = Boolean.FALSE;
        }

        if (check) {
            for (Meeting meeting1 : listMeeting) {
                if (meeting1.getMobile().equals(meeting.getMobile()))
                    throw new MeetingAlreadyExistException("Meeting Already Scheduled");
            }
        }else {
            throw new AccountNotFoundException("Account Not Exist");
        }

        listMeeting.add(meeting);
        return meeting.getMobile();
    }

    @Override
    public List<Meeting> listMeeting() {
        return listMeeting;
    }

    @Override
    public Meeting getMeeting(String mobile) {
        for (Meeting meeting : listMeeting) {
            if (meeting.getMobile().equals(mobile))
                return meeting;
        }
        throw new MeetingScheduleException("Meeting Not Found");
    }

    @Override
    public String updateMeeting(Meeting meeting) {
        for (Meeting obj: listMeeting) {
            if (obj.getMobile().equals(meeting.getMobile())) {
                listMeeting.remove(obj);
                listMeeting.add(meeting);
                return meeting.getMobile();
            }
        }
        throw new MeetingScheduleException("Meeting Not Found");
    }

    @Override
    public String addAccountType(AccountType accountType) {
        Boolean check = null;
        for (Account account : listAccount) {
            if (account.getMobile().equals(accountType.getMobile()))
                check = Boolean.TRUE;
            else
                check = Boolean.FALSE;
        }

        if (check) {
            for (AccountType meeting1 : listAccountType) {
                if (meeting1.getMobile().equals(accountType.getMobile()))
                    throw new MeetingAlreadyExistException("Meeting Already Scheduled");
            }
        }else {
            throw new AccountNotFoundException("Account Not Exist");
        }

        listAccountType.add(accountType);
        return accountType.getMobile();
    }

    @Override
    public AccountType getAccountType(String mobile) {
        for (AccountType account : listAccountType) {
            if (account.getMobile().equals(mobile))
                return account;
        }
        throw new AccountNotFoundException("Account Not Found !");
    }

    @Override
    public String uploadDocument(UploadDocument uploadDocument) {
        Boolean check = null;
        for (Account account : listAccount) {
            if (account.getMobile().equals(uploadDocument.getMobile()))
                check = Boolean.TRUE;
            else
                check = Boolean.FALSE;
        }

        if (check) {
            for (UploadDocument doc : listUploadDocuments) {
                if (doc.getMobile().equals(uploadDocument.getMobile()))
                    throw new MeetingAlreadyExistException("Doc Already Scheduled");
            }
        }else {
            throw new AccountNotFoundException("Account Not Exist");
        }

        listUploadDocuments.add(uploadDocument);
        return uploadDocument.getMobile();
    }

    @Override
    public UploadDocument getUploadedDocument(String mobile) {
        for (UploadDocument document : listUploadDocuments) {
            if (document.getMobile().equals(mobile))
                return document;
        }
        throw new DocumentNotFoundException("Document Not Found !");
    }

    @Override
    public List<AllData> getAllData() {
        return null;
    }

    @Override
    public AllData getAllData(String mobile) {
        return null;
    }

    @Override
    public void updateStatus(String mobile, Integer status) {

    }

    @Override
    public void saveComment(String mobile, String comment) {

    }

}
