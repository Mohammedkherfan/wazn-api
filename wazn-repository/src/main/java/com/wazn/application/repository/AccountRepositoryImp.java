package com.wazn.application.repository;

import com.wazn.application.exception.*;
import com.wazn.application.mapper.*;
import com.wazn.application.model.Account;
import com.wazn.application.model.Document;
import com.wazn.application.model.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImp implements AccountRepository {

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    @Autowired
    private DocumentCrudRepository documentCrudRepository;

    @Autowired MeetingScheduleCrudRepository meetingScheduleCrudRepository;

    private AccountMapper accountMapper = new AccountMapperImp();
    private DocumentMapper documentMapper = new DocumentMapperImp();
    private MeetingMapper meetingMapper = new MeetingMapperImp();

    @Override
    @Transactional
    public String addAccount(Account account) {
        try {
            if (accountCrudRepository.existsById(account.getMobile()))
                throw new AccountAlreadyExistException("Account Already Exist !");
            return accountCrudRepository.save(accountMapper.toAccountEntity(account)).getMobile();
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public Account getAccount(String mobile) {
        try {
            if (accountCrudRepository.existsById(mobile))
                return accountMapper.toAccount(accountCrudRepository.findById(mobile).get());
            throw new AccountNotFoundException("Account Not Found !");
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public String addDocument(Document document) {
        try {
            if (accountCrudRepository.existsById(document.getMobile())) {
                if (documentCrudRepository.existsById(document.getMobile()))
                    throw new DocumentAlreadyExistException("Document Already Exist !");
                else
                    return documentCrudRepository.save(documentMapper.toDocumentEntity(document)).getMobile();
            } else {
                throw new AccountNotFoundException("Account Not Found !");
            }
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public Document getDocument(String mobile) {
        try {
            if (documentCrudRepository.existsById(mobile))
                return documentMapper.toDocument(documentCrudRepository.findById(mobile).get());
            throw new AccountNotFoundException("Document Not Found !");
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public String addMeeting(Meeting meeting) {
        try {
            if (accountCrudRepository.existsById(meeting.getMobile())) {
                if (meetingScheduleCrudRepository.existsById(meeting.getMobile()))
                    throw new MeetingAlreadyExistException("Meeting Already Scheduled !");
                else
                    return meetingScheduleCrudRepository.save(meetingMapper.toMeetingEntity(meeting)).getMobile();
            } else {
                throw new AccountNotFoundException("Account Not Found !");
            }
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public List<Meeting> listMeeting() {
        try {
            List<Meeting> list = new ArrayList<>();
            meetingScheduleCrudRepository.findAll().forEach(e -> {
                list.add(meetingMapper.toMeeting(e));
            });
            return list;
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
