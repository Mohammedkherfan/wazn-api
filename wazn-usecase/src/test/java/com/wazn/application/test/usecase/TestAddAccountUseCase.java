package com.wazn.application.test.usecase;

import com.wazn.application.exception.*;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.request.AddMeetingScheduleRequest;
import com.wazn.application.response.*;
import com.wazn.application.service.AccountService;
import com.wazn.application.service.AccountServiceImp;
import com.wazn.application.test.repository.AccountTestRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestAddAccountUseCase {

    private AccountRepository accountRepository;
    private AccountService accountService;
    private AddAccountRequest addAccountRequest;
    private AddDocumentRequest addDocumentRequest;
    private AddMeetingScheduleRequest addMeetingScheduleRequest;

    @Before
    public void setUp() throws Exception {
        accountRepository = new AccountTestRepository();
        accountService = new AccountServiceImp(accountRepository);
        addAccountRequest = new AddAccountRequest("mohammed.kherfan@gmail.com", "+962798988910", "Mohammed Kherfan", "P@ssw0rd", "P@ssw0rd");
        addDocumentRequest = new AddDocumentRequest("V-doc", "073955554", "UAE", "1561656", "53153", LocalDate.now().toString(), "own", "help desk commint", LocalDate.now().minusYears(22).toString(), "Male", "Jordanian", new byte[]{1}, new byte[]{1}, new byte[]{2}, LocalDateTime.now().toString(), "Office", "Mohammed", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
        addMeetingScheduleRequest = new AddMeetingScheduleRequest(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1), "note");
    }

    @Test(expected = InvalidAccountRequestException.class)
    public void whenAddAccount_AndAccountRequestIsNull_ThenShouldPersistException() {
        accountService.addAccount(null);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsNull_ThenShouldPersistException() {
        addAccountRequest.setEmail(null);
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setEmail("");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsSpace_ThenShouldPersistException() {
        addAccountRequest.setEmail("   ");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsInvalidFormat_ThenShouldPersistException() {
        addAccountRequest.setEmail("moahmmed.kherfangmail.com");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsNull_ThenShouldPersistException() {
        addAccountRequest.setMobile(null);
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setMobile("");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsSpace_ThenShouldPersistException() {
        addAccountRequest.setMobile("   ");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsInvalidFormat_ThenShouldPersistException() {
        addAccountRequest.setEmail("0798988910");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNameIsNull_ThenShouldPersistException() {
        addAccountRequest.setFullName(null);
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNameIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setFullName("");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNameIsSpace_ThenShouldPersistException() {
        addAccountRequest.setFullName("   ");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountPasswordIsNull_ThenShouldPersistException() {
        addAccountRequest.setPassword(null);
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountPasswordIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setPassword("");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountPasswordIsSpace_ThenShouldPersistException() {
        addAccountRequest.setPassword("   ");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordIsNull_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword(null);
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword("");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordIsSpace_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword("   ");
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordNotMatchWithPassword_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword("P@ssw0rd123");
        accountService.addAccount(addAccountRequest);
    }

    @Test
    public void whenAddAccount_AndAccountDataIsValid_ThenShouldPersistToRepository() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        assertNotNull(addAccountResponse);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailAlreadyExist_ThenShouldPersistException() {
        accountService.addAccount(addAccountRequest);
        accountService.addAccount(addAccountRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileIsNull_ThenShouldPersistException() {
        accountService.getAccount(null);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileIsEmpty_ThenShouldPersistException() {
        accountService.getAccount("");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileIsSpace_ThenShouldPersistException() {
        accountService.getAccount("   ");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileWrongFormat_ThenShouldPersistException() {
        accountService.getAccount("0798988910");
    }

    @Test(expected = AccountException.class)
    public void whenGetAccount_AndAccountNotFoundInRepository_ThenShouldPersistException() {
        accountService.getAccount("+962798988910");
    }

    @Test
    public void whenGetAccount_AndAccountMobileExistedInRepository_ThenShouldPersistAccountFromRepository() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        GetAccountResponse getAccountResponse = accountService.getAccount(addAccountResponse.getMobile());
        assertNotNull(getAccountResponse);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_andAccountMobileIsNull_ThenShouldPersistException() {
        accountService.verifyCode(null, "00000");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountService.verifyCode("", "00000");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountService.verifyCode("   ", "00000");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_AndAccountMobileIsInvalidFormat_ThenShouldPersistException() {
        accountService.verifyCode("0798988910", "00000");
    }

    @Test(expected = InvalidVerificationCodeException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsNull_ThenShouldPersistException() {
        accountService.verifyCode("+962798988910", null);
    }

    @Test(expected = InvalidVerificationCodeException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsEmpty_ThenShouldPersistException() {
        accountService.verifyCode("+962798988910", "");
    }

    @Test(expected = InvalidVerificationCodeException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsSpace_ThenShouldPersistException() {
        accountService.verifyCode("+962798988910", "   ");
    }

    @Test(expected = AccountException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsNotMatch_ThenShouldPersistException() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        accountService.verifyCode(addAccountResponse.getMobile(), "12345");
    }

    @Test
    public void whenVerifyCode_andAccountVerificationCodeIsMatch_ThenShouldPersistFromRepository() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        VerificationCodeResponse verificationCodeResponse = accountService.verifyCode(addAccountResponse.getMobile(), "00000");
        assertTrue(verificationCodeResponse.getResult());
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountService.addDocument(null, addDocumentRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountService.addDocument("", addDocumentRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountService.addDocument("   ", addDocumentRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsInvalidFormat_ThenShouldPersistException() {
        accountService.addDocument("0798988910", addDocumentRequest);
    }

    @Test(expected = InvalidAccountRequestException.class)
    public void whenAddDocument_AndDocumentIsNull_ThenShouldPersistException() {
        accountService.addDocument("+962798988910", null);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentTypeIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentType(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentTypeIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setDocumentType("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentTypeIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setDocumentType("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentNumberIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentNumber(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentNumberIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setDocumentNumber("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentNumberIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setDocumentNumber("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountIssuingCountryIsNull_ThenShouldPersistException() {
        addDocumentRequest.setIssuingCountry(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountIssuingCountryIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setIssuingCountry("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountIssuingCountryIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setIssuingCountry("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountValidThroughIsNull_ThenShouldPersistException() {
        addDocumentRequest.setValidThrough(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountValidThroughIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setValidThrough("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountValidThroughIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setValidThrough("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageFaceIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageFace(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageFaceIsZeroLength_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageFace(new byte[0]);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageBackIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageBack(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageBackIsZeroLength_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageBack(new byte[0]);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdPersonalImageIsNull_ThenShouldPersistException() {
        addDocumentRequest.setPersonalImage(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdPersonalImageIsZeroLength_ThenShouldPersistException() {
        addDocumentRequest.setPersonalImage(new byte[0]);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountBirthDateIsNull_ThenShouldPersistException() {
        addDocumentRequest.setBirthDate(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountBirthDateIsAfterToday_ThenShouldPersistException() {
        addDocumentRequest.setBirthDate(LocalDate.now().plusDays(1).toString());
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountBirthDateIsToday_ThenShouldPersistException() {
        addDocumentRequest.setBirthDate(LocalDate.now().toString());
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountGenderIsNull_ThenShouldPersistException() {
        addDocumentRequest.setGender(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountGenderIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setGender("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountGenderIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setGender("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNationalityIsNull_ThenShouldPersistException() {
        addDocumentRequest.setNationality(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNationalityIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setNationality("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNationalityIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setNationality("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredOnIsNull_ThenShouldPersistException() {
        addDocumentRequest.setEnteredOn(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredOnIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setEnteredOn("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredOnIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setEnteredOn("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredByIsNull_ThenShouldPersistException() {
        addDocumentRequest.setEnteredBy(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredByIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setEnteredBy("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredByIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setEnteredBy("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountLocationIsNull_ThenShouldPersistException() {
        addDocumentRequest.setLocation(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountLocationIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setLocation("");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountLocationIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setLocation("   ");
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountAssessmentDocumentBearerIsNull_ThenShouldPersistException() {
        addDocumentRequest.setAssessmentDocumentBearer(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountFaceMatchIsNull_ThenShouldPersistException() {
        addDocumentRequest.setFaceMatch(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountMRZIsNull_ThenShouldPersistException() {
        addDocumentRequest.setCheckMRZ(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountAutomationAuthenticationsIsNull_ThenShouldPersistException() {
        addDocumentRequest.setAutomationAuthentications(null);
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountNotFoundInAccountRepository_ThenShouldPersistException() {
        accountService.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountAlreadyExistInAccountRepository_ThenShouldPersistException() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        AddDocumentResponse addDocumentResponse = accountService.addDocument(addAccountResponse.getMobile(), addDocumentRequest);
        accountService.addDocument(addDocumentResponse.getMobile(), addDocumentRequest);
    }

    @Test
    public void whenAddDocument_AndAccountFoundInAccountRepository_ThenShouldPersistToRepository() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        AddDocumentResponse addDocumentResponse = accountService.addDocument(addAccountResponse.getMobile(), addDocumentRequest);
        assertNotNull(addDocumentResponse.getMobile());
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountService.login(null, "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountService.login("", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountService.login("   ", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsInvalid_ThenShouldPersistException() {
        accountService.login("0798988910", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountPasswordIsNull_ThenShouldPersistException() {
        accountService.login("+962798988910", null);
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountPasswordIsEmpty_ThenShouldPersistException() {
        accountService.login("+962798988910", "");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountPasswordIsSpace_ThenShouldPersistException() {
        accountService.login("+962798988910", "   ");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileNotExistInRepository_ThenShouldPersistException() {
        accountService.login("+962798988910", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountButPasswordInvalid_ThenShouldPersistException() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        accountService.login(addAccountResponse.getMobile(), "P@ssw0rd123");
    }

    @Test
    public void whenLogin_AndAccountWithValidMobileAndPassword_ThenShouldPersistToRepository() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        LoginResponse loginResponse = accountService.login(addAccountResponse.getMobile(), "P@ssw0rd");
        assertTrue(loginResponse.getResult());
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGenerateReport_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountService.generateReport(null);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGenerateReport_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountService.generateReport("");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGenerateReport_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountService.generateReport("   ");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGenerateReport_AndAccountMobileIsInvalid_ThenShouldPersistException() {
        accountService.generateReport("0798988910");
    }

    @Test(expected = ReportException.class)
    public void whenGenerateReport_AndAndAccountNotExist_ThenShouldPersistException() {
        accountService.generateReport("+962798988910");
    }

    //@Test
    //public void whenGenerateReport_AndAccountExist_ThenShouldGenerateReport() {
      //  AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
       // AddDocumentResponse addDocumentResponse = accountService.addDocument(addAccountResponse.getMobile(), addDocumentRequest);
        //accountService.generateReport(addDocumentResponse.getMobile());
    //}

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountService.addMeeting(null, addMeetingScheduleRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountService.addMeeting("", addMeetingScheduleRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountService.addMeeting("   ", addMeetingScheduleRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsInvalid_ThenShouldPersistException() {
        accountService.addMeeting("0798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountStartDateIsNull_ThenShouldPersistException() {
        addMeetingScheduleRequest.setStartDate(null);
        accountService.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountStartDateIsBeforeToday_ThenShouldPersistException() {
        addMeetingScheduleRequest.setStartDate(LocalDateTime.now().minusDays(1));
        accountService.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountEndDateIsNull_ThenShouldPersistException() {
        addMeetingScheduleRequest.setEndDate(null);
        accountService.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountEndDateIsBeforeToday_ThenShouldPersistException() {
        addMeetingScheduleRequest.setEndDate(LocalDateTime.now().minusDays(1));
        accountService.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountEndDateIsBeforeStartdate_ThenShouldPersistException() {
        addMeetingScheduleRequest.setEndDate(LocalDateTime.now().minusDays(1));
        addMeetingScheduleRequest.setStartDate(LocalDateTime.now().plusDays(1));
        accountService.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountNotExist_ThenShouldPersistException() {
        accountService.addAccount(addAccountRequest);
        accountService.addMeeting("+962798988911", addMeetingScheduleRequest);
    }

    @Test
    public void whenAddMeeting_AndAccountExist_ThenShouldAddMeeting() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        AddMeetingScheduleResponse addMeetingScheduleResponse = accountService.addMeeting(addAccountResponse.getMobile(), addMeetingScheduleRequest);
        assertNotNull(addMeetingScheduleResponse.getMobile());
    }

    @Test
    public void whenListMeeting_AndMeetingRepositoryIsEmpty_ThenShouldReturnEmptyList() {
        List<ListMeetingResponse> listMeetingResponses = accountService.listMeeting();
        assertTrue(listMeetingResponses.isEmpty());
    }

    @Test
    public void whenListMeeting_AndMeetingRepositoryIsNotEmpty_ThenShouldReturnListOfMeeting() {
        AddAccountResponse addAccountResponse = accountService.addAccount(addAccountRequest);
        accountService.addMeeting(addAccountResponse.getMobile(), addMeetingScheduleRequest);
        List<ListMeetingResponse> listMeetingResponses = accountService.listMeeting();
        assertTrue(!listMeetingResponses.isEmpty());
    }
}
