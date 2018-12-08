package com.wazn.application.repository;

import com.wazn.application.entity.AccountEntity;
import com.wazn.application.entity.UploadDocumentEntity;
import com.wazn.application.exception.*;
import com.wazn.application.mapper.*;
import com.wazn.application.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class AccountRepositoryImp implements AccountRepository {

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    @Autowired
    private DocumentCrudRepository documentCrudRepository;

    @Autowired
    private MeetingScheduleCrudRepository meetingScheduleCrudRepository;

    @Autowired
    private AccountTypeCrudRepository accountTypeCrudRepository;

    @Autowired
    private UploadDocumentCrudRepository uploadDocumentCrudRepository;

    private AccountMapper accountMapper = new AccountMapperImp();
    private DocumentMapper documentMapper = new DocumentMapperImp();
    private MeetingMapper meetingMapper = new MeetingMapperImp();
    private AccountTypeMapper accountTypeMapper = new AccountTypeMapperImp();
    private UploadDocumentMapper uploadDocumentMapper = new UploadDocumentMapperImp();

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
            if (accountCrudRepository.existsById(mobile)) {
                return accountMapper.toAccount(accountCrudRepository.findById(mobile).get());
            }
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

    @Override
    public Meeting getMeeting(String mobile) {
        try {
            if (meetingScheduleCrudRepository.existsById(mobile))
                return meetingMapper.toMeeting(meetingScheduleCrudRepository.findById(mobile).get());
            else
                throw new MeetingScheduleException("Meeting Not Found");
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public String updateMeeting(Meeting meeting) {
        try {
            if (meetingScheduleCrudRepository.existsById(meeting.getMobile()))
                return meetingScheduleCrudRepository.save(meetingMapper.toMeetingEntity(meeting)).getMobile();
            else
                throw new MeetingScheduleException("Meeting Not Found");
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public String addAccountType(AccountType accountType) {
        try {
            if (accountCrudRepository.existsById(accountType.getMobile())) {
                if (accountTypeCrudRepository.existsById(accountType.getMobile()))
                    throw new DocumentAlreadyExistException("Account Already Exist !");
                else
                    return accountTypeCrudRepository.save(accountTypeMapper.toAccountTypeEntity(accountType)).getMobile();
            } else {
                throw new AccountNotFoundException("Account Not Found !");
            }
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public AccountType getAccountType(String mobile) {
        try {
            if (accountTypeCrudRepository.existsById(mobile))
                return accountTypeMapper.toAccountType(accountTypeCrudRepository.findById(mobile).get());
            else
                throw new AccountNotFoundException("Account Not Found !");
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public String uploadDocument(UploadDocument uploadDocument) {
        try {
            if (accountCrudRepository.existsById(uploadDocument.getMobile())) {
                UploadDocumentEntity uploadDocumentEntity = uploadDocumentMapper.toUploadDocumentEntity(uploadDocument);
                return uploadDocumentCrudRepository.save(uploadDocumentEntity).getMobile();
            } else {
                throw new AccountNotFoundException("Account Not Found !");
            }
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public UploadDocument getUploadedDocument(String mobile) {
        try {
            if (uploadDocumentCrudRepository.existsById(mobile))
                return uploadDocumentMapper.toUploadDocument(uploadDocumentCrudRepository.findById(mobile).get());
            else
                return null;
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public List<AllData> getAllData() {
        List<AllData> allData = new ArrayList<>();
        accountCrudRepository.findAll().forEach(e -> {
            allData.add(new AllData.Builder()
                    .mobile(e.getMobile())
                    .email(e.getEmail())
                    .fullName(e.getName())
                    .verificationCode(e.getVerificationCode())
                    .status(e.getStatus())
                    .type(isNull(e.getAccountTypeEntity()) ? null : e.getAccountTypeEntity().getType())
                    .documentType(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getDocumentType())
                    .documentNumber(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getDocumentNumber())
                    .issuingCountry(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getIssuingCountry())
                    .personalNumber(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getPersonalNumber())
                    .regNumber(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getRegNumber())
                    .validThrough(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getValidThrough())
                    .ownComment(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getOwnComment())
                    .helpDeskComment(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getHelpDeskComment())
                    .birthDate(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getBirthDate())
                    .gender(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getGender())
                    .nationality(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getNationality())
                    .documentIdImageFace(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getAccountImageEntity().getDocumentIdImageFace())
                    .documentIdImageBack(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getAccountImageEntity().getDocumentIdImageBack())
                    .personalImage(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getAccountImageEntity().getPersonalImage())
                    .startDate(isNull(e.getMeetingEntity()) ? null : e.getMeetingEntity().getStartDate())
                    .note(isNull(e.getMeetingEntity()) ? null : e.getMeetingEntity().getNote())
                    .enteredOn(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getReportEntity().getEnteredOn())
                    .location(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getReportEntity().getLocation())
                    .enteredBy(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getReportEntity().getEnteredBy())
                    .assessmentDocumentBearer(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getResultEntity().getAssessmentDocumentBearer() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .faceMatch(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getResultEntity().getFaceMatch() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .checkMRZ(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getResultEntity().getCheckMRZ() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .automationAuthentications(isNull(e.getDocumentEntity()) ? null : e.getDocumentEntity().getResultEntity().getAutomationAuthentications() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .passportOrVisaImage(isNull(e.getUploadDocumentEntity()) ? null : e.getUploadDocumentEntity().getPassportOrVisaImage())
                    .salaryCertificateImage(isNull(e.getUploadDocumentEntity()) ? null : e.getUploadDocumentEntity().getSalaryCertificateImage())
                    .taxDeclarationImage(isNull(e.getUploadDocumentEntity()) ? null : e.getUploadDocumentEntity().getTaxDeclarationImage())
                    .build()
            );
        });
        return allData;
    }

    @Override
    public AllData getAllData(String mobile) {
        AllData allData;
        if (accountCrudRepository.existsById(mobile)) {
            AccountEntity accountEntity = accountCrudRepository.findById(mobile).get();
            allData = new AllData.Builder()
                    .mobile(accountEntity.getMobile())
                    .email(accountEntity.getEmail())
                    .fullName(accountEntity.getName())
                    .verificationCode(accountEntity.getVerificationCode())
                    .status(accountEntity.getStatus())
                    .type(isNull(accountEntity.getAccountTypeEntity()) ? null : accountEntity.getAccountTypeEntity().getType())
                    .documentType(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getDocumentType())
                    .documentNumber(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getDocumentNumber())
                    .issuingCountry(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getIssuingCountry())
                    .personalNumber(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getPersonalNumber())
                    .regNumber(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getRegNumber())
                    .validThrough(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getValidThrough())
                    .ownComment(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getOwnComment())
                    .helpDeskComment(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getHelpDeskComment())
                    .birthDate(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getBirthDate())
                    .gender(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getGender())
                    .nationality(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getNationality())
                    .documentIdImageFace(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getAccountImageEntity().getDocumentIdImageFace())
                    .documentIdImageBack(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getAccountImageEntity().getDocumentIdImageBack())
                    .personalImage(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getAccountImageEntity().getPersonalImage())
                    .startDate(isNull(accountEntity.getMeetingEntity()) ? null : accountEntity.getMeetingEntity().getStartDate())
                    .note(isNull(accountEntity.getMeetingEntity()) ? null : accountEntity.getMeetingEntity().getNote())
                    .enteredOn(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getReportEntity().getEnteredOn())
                    .location(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getReportEntity().getLocation())
                    .enteredBy(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getReportEntity().getEnteredBy())
                    .assessmentDocumentBearer(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getResultEntity().getAssessmentDocumentBearer() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .faceMatch(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getResultEntity().getFaceMatch() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .checkMRZ(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getResultEntity().getCheckMRZ() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .automationAuthentications(isNull(accountEntity.getDocumentEntity()) ? null : accountEntity.getDocumentEntity().getResultEntity().getAutomationAuthentications() == 1 ? Boolean.TRUE : Boolean.FALSE)
                    .passportOrVisaImage(isNull(accountEntity.getUploadDocumentEntity()) ? null : accountEntity.getUploadDocumentEntity().getPassportOrVisaImage())
                    .salaryCertificateImage(isNull(accountEntity.getUploadDocumentEntity()) ? null : accountEntity.getUploadDocumentEntity().getSalaryCertificateImage())
                    .taxDeclarationImage(isNull(accountEntity.getUploadDocumentEntity()) ? null : accountEntity.getUploadDocumentEntity().getTaxDeclarationImage())
                    .build();
        }else {
            allData = new AllData.Builder().build();
        }
        return allData;
    }
}
