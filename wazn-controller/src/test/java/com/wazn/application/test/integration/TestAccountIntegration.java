package com.wazn.application.test.integration;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.wazn.application.controller.AccountController;
import com.wazn.application.exception.*;
import com.wazn.application.repository.AccountCrudRepository;
import com.wazn.application.repository.DocumentCrudRepository;
import com.wazn.application.repository.MeetingScheduleCrudRepository;
import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.request.AddMeetingScheduleRequest;
import com.wazn.application.response.*;
import com.wazn.application.test.configuration.TestAccountConfiguration;
import com.wazn.application.test.configuration.TestRepoFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestRepoFactory.class, TestAccountConfiguration.class, AccountCrudRepository.class, DocumentCrudRepository.class, MeetingScheduleCrudRepository.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionDbUnitTestExecutionListener.class})
public class TestAccountIntegration {

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    @Autowired
    private DocumentCrudRepository documentCrudRepository;

    @Autowired
    private MeetingScheduleCrudRepository meetingScheduleCrudRepository;

    @Autowired
    private AccountController accountController;

    private AddAccountRequest addAccountRequest;
    private AddDocumentRequest addDocumentRequest;
    private AddMeetingScheduleRequest addMeetingScheduleRequest;

    @Before
    public void setUp() throws Exception {
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(new MockHttpServletRequest()));
        addAccountRequest = new AddAccountRequest("mohammed.kherfan@gmail.com", "+962798988910", "Mohammed Kherfan", "P@ssw0rd", "P@ssw0rd");
        addDocumentRequest = new AddDocumentRequest("V-doc", "073955554", "UAE", "1561656", "53153", LocalDate.now().toString(), "own", "help desk commint", LocalDate.now().minusYears(22).toString(), "Male", "Jordanian", new byte[]{1}, new byte[]{1}, new byte[]{2}, LocalDateTime.now().toString(), "Office", "Mohammed", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
        addMeetingScheduleRequest = new AddMeetingScheduleRequest(LocalDateTime.now().plusDays(1).toString(), LocalDateTime.now().plusDays(1).toString(), "note");
    }

    @After
    public void tearDown() throws Exception {
        accountCrudRepository.deleteAll();
        documentCrudRepository.deleteAll();
        meetingScheduleCrudRepository.deleteAll();
    }

    @Test(expected = InvalidAccountRequestException.class)
    public void whenAddAccount_AndAccountRequestIsNull_ThenShouldPersistException() {
        accountController.addAccount(null);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsNull_ThenShouldPersistException() {
        addAccountRequest.setEmail(null);
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setEmail("");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsSpace_ThenShouldPersistException() {
        addAccountRequest.setEmail("   ");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailIsInvalidFormat_ThenShouldPersistException() {
        addAccountRequest.setEmail("moahmmed.kherfangmail.com");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsNull_ThenShouldPersistException() {
        addAccountRequest.setMobile(null);
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setMobile("");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsSpace_ThenShouldPersistException() {
        addAccountRequest.setMobile("   ");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountMobileIsInvalidFormat_ThenShouldPersistException() {
        addAccountRequest.setEmail("0798988910");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNameIsNull_ThenShouldPersistException() {
        addAccountRequest.setFullName(null);
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNameIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setFullName("");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNameIsSpace_ThenShouldPersistException() {
        addAccountRequest.setFullName("   ");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountPasswordIsNull_ThenShouldPersistException() {
        addAccountRequest.setPassword(null);
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountPasswordIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setPassword("");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountPasswordIsSpace_ThenShouldPersistException() {
        addAccountRequest.setPassword("   ");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordIsNull_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword(null);
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordIsEmpty_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword("");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordIsSpace_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword("   ");
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountConfirmPasswordNotMatchWithPassword_ThenShouldPersistException() {
        addAccountRequest.setConfirmPassword("P@ssw0rd123");
        accountController.addAccount(addAccountRequest);
    }

    @Test
    public void whenAddAccount_AndAccountDataIsValid_ThenShouldPersistToRepository() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        assertNotNull(addAccountResponse);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountEmailAlreadyExist_ThenShouldPersistException() {
        accountController.addAccount(addAccountRequest);
        accountController.addAccount(addAccountRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileIsNull_ThenShouldPersistException() {
        accountController.getAccount(null);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileIsEmpty_ThenShouldPersistException() {
        accountController.getAccount("");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileIsSpace_ThenShouldPersistException() {
        accountController.getAccount("   ");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenGetAccountInfo_AndMobileWrongFormat_ThenShouldPersistException() {
        accountController.getAccount("0798988910");
    }

    @Test(expected = AccountException.class)
    public void whenGetAccount_AndAccountNotFoundInRepository_ThenShouldPersistException() {
        accountController.getAccount("+962798988910");
    }

    @Test
    public void whenGetAccount_AndAccountMobileExistedInRepository_ThenShouldPersistAccountFromRepository() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        GetAccountResponse getAccountResponse = accountController.getAccount(addAccountResponse.getMobile()).getContent();
        assertNotNull(getAccountResponse);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_andAccountMobileIsNull_ThenShouldPersistException() {
        accountController.verifyCode(null, "00000");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountController.verifyCode("", "00000");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountController.verifyCode("   ", "00000");
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenVerifyCode_AndAccountMobileIsInvalidFormat_ThenShouldPersistException() {
        accountController.verifyCode("0798988910", "00000");
    }

    @Test(expected = InvalidVerificationCodeException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsNull_ThenShouldPersistException() {
        accountController.verifyCode("+962798988910", null);
    }

    @Test(expected = InvalidVerificationCodeException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsEmpty_ThenShouldPersistException() {
        accountController.verifyCode("+962798988910", "");
    }

    @Test(expected = InvalidVerificationCodeException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsSpace_ThenShouldPersistException() {
        accountController.verifyCode("+962798988910", "   ");
    }

    @Test(expected = AccountException.class)
    public void whenVerifyCode_andAccountVerificationCodeIsNotMatch_ThenShouldPersistException() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        accountController.verifyCode(addAccountResponse.getMobile(), "12345");
    }

    @Test
    public void whenVerifyCode_andAccountVerificationCodeIsMatch_ThenShouldPersistFromRepository() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        VerificationCodeResponse verificationCodeResponse = accountController.verifyCode(addAccountResponse.getMobile(), "00000").getContent();
        assertTrue(verificationCodeResponse.getResult());
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountController.addDocument(null, addDocumentRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountController.addDocument("", addDocumentRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountController.addDocument("   ", addDocumentRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddDocument_AndAccountMobileIsInvalidFormat_ThenShouldPersistException() {
        accountController.addDocument("0798988910", addDocumentRequest);
    }

    @Test(expected = InvalidAccountRequestException.class)
    public void whenAddDocument_AndDocumentIsNull_ThenShouldPersistException() {
        accountController.addDocument("+962798988910", null);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentTypeIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentType(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentTypeIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setDocumentType("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentTypeIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setDocumentType("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentNumberIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentNumber(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentNumberIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setDocumentNumber("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentNumberIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setDocumentNumber("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountIssuingCountryIsNull_ThenShouldPersistException() {
        addDocumentRequest.setIssuingCountry(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountIssuingCountryIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setIssuingCountry("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountIssuingCountryIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setIssuingCountry("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountValidThroughIsNull_ThenShouldPersistException() {
        addDocumentRequest.setValidThrough(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountValidThroughIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setValidThrough("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountValidThroughIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setValidThrough("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageFaceIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageFace(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageFaceIsZeroLength_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageFace(new byte[0]);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageBackIsNull_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageBack(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdImageBackIsZeroLength_ThenShouldPersistException() {
        addDocumentRequest.setDocumentIdImageBack(new byte[0]);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdPersonalImageIsNull_ThenShouldPersistException() {
        addDocumentRequest.setPersonalImage(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountDocumentIdPersonalImageIsZeroLength_ThenShouldPersistException() {
        addDocumentRequest.setPersonalImage(new byte[0]);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountBirthDateIsNull_ThenShouldPersistException() {
        addDocumentRequest.setBirthDate(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountBirthDateIsAfterToday_ThenShouldPersistException() {
        addDocumentRequest.setBirthDate(LocalDate.now().plusDays(1).toString());
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountBirthDateIsToday_ThenShouldPersistException() {
        addDocumentRequest.setBirthDate(LocalDate.now().toString());
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountGenderIsNull_ThenShouldPersistException() {
        addDocumentRequest.setGender(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountGenderIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setGender("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountGenderIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setGender("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNationalityIsNull_ThenShouldPersistException() {
        addDocumentRequest.setNationality(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNationalityIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setNationality("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddAccount_AndAccountNationalityIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setNationality("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredOnIsNull_ThenShouldPersistException() {
        addDocumentRequest.setEnteredOn(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredOnIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setEnteredOn("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredOnIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setEnteredOn("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredByIsNull_ThenShouldPersistException() {
        addDocumentRequest.setEnteredBy(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredByIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setEnteredBy("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountEnteredByIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setEnteredBy("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountLocationIsNull_ThenShouldPersistException() {
        addDocumentRequest.setLocation(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountLocationIsEmpty_ThenShouldPersistException() {
        addDocumentRequest.setLocation("");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountLocationIsSpace_ThenShouldPersistException() {
        addDocumentRequest.setLocation("   ");
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountAssessmentDocumentBearerIsNull_ThenShouldPersistException() {
        addDocumentRequest.setAssessmentDocumentBearer(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountFaceMatchIsNull_ThenShouldPersistException() {
        addDocumentRequest.setFaceMatch(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountMRZIsNull_ThenShouldPersistException() {
        addDocumentRequest.setCheckMRZ(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountAutomationAuthenticationsIsNull_ThenShouldPersistException() {
        addDocumentRequest.setAutomationAuthentications(null);
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountNotFoundInAccountRepository_ThenShouldPersistException() {
        accountController.addDocument("+962798988910", addDocumentRequest);
    }

    @Test(expected = AccountException.class)
    public void whenAddDocument_AndAccountAlreadyExistInAccountRepository_ThenShouldPersistException() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        AddDocumentResponse addDocumentResponse = accountController.addDocument(addAccountResponse.getMobile(), addDocumentRequest).getContent();
        accountController.addDocument(addDocumentResponse.getMobile(), addDocumentRequest);
    }

    @Test
    public void whenAddDocument_AndAccountFoundInAccountRepository_ThenShouldPersistToRepository() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        AddDocumentResponse addDocumentResponse = accountController.addDocument(addAccountResponse.getMobile(), addDocumentRequest).getContent();
        assertNotNull(addDocumentResponse.getMobile());
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountController.login(null, "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountController.login("", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountController.login("   ", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileIsInvalid_ThenShouldPersistException() {
        accountController.login("0798988910", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountPasswordIsNull_ThenShouldPersistException() {
        accountController.login("+962798988910", null);
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountPasswordIsEmpty_ThenShouldPersistException() {
        accountController.login("+962798988910", "");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountPasswordIsSpace_ThenShouldPersistException() {
        accountController.login("+962798988910", "   ");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountMobileNotExistInRepository_ThenShouldPersistException() {
        accountController.login("+962798988910", "P@ssw0rd");
    }

    @Test(expected = AccountException.class)
    public void whenLogin_AndAccountButPasswordInvalid_ThenShouldPersistException() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        accountController.login(addAccountResponse.getMobile(), "P@ssw0rd123");
    }

    @Test
    public void whenLogin_AndAccountWithValidMobileAndPassword_ThenShouldPersistToRepository() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        LoginResponse loginResponse = accountController.login(addAccountResponse.getMobile(), "P@ssw0rd").getContent();
        assertTrue(loginResponse.getResult());
    }

    @Test(expected = ReportException.class)
    public void whenGenerateReport_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountController.generateReport(null);
    }

    @Test(expected = ReportException.class)
    public void whenGenerateReport_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountController.generateReport("");
    }

    @Test(expected = ReportException.class)
    public void whenGenerateReport_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountController.generateReport("   ");
    }

    @Test(expected = ReportException.class)
    public void whenGenerateReport_AndAccountMobileIsInvalid_ThenShouldPersistException() {
        accountController.generateReport("0798988910");
    }

    @Test(expected = ReportException.class)
    public void whenGenerateReport_AndAndAccountNotExist_ThenShouldPersistException() {
        accountController.generateReport("+962798988910");
    }

    @Test
    public void whenGenerateReport_AndAccountExist_ThenShouldGenerateReport() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        AddDocumentResponse addDocumentResponse = accountController.addDocument(addAccountResponse.getMobile(), addDocumentRequest).getContent();
        accountController.generateReport(addDocumentResponse.getMobile());
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsNull_ThenShouldPersistException() {
        accountController.addMeeting(null, addMeetingScheduleRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsEmpty_ThenShouldPersistException() {
        accountController.addMeeting("", addMeetingScheduleRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsSpace_ThenShouldPersistException() {
        accountController.addMeeting("   ", addMeetingScheduleRequest);
    }

    @Test(expected = InvalidAccountMobileException.class)
    public void whenAddMeeting_AndAccountMobileIsInvalid_ThenShouldPersistException() {
        accountController.addMeeting("0798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountStartDateIsNull_ThenShouldPersistException() {
        addMeetingScheduleRequest.setStartDate(null);
        accountController.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountStartDateIsBeforeToday_ThenShouldPersistException() {
        addMeetingScheduleRequest.setStartDate(LocalDateTime.now().minusDays(1).toString());
        accountController.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountEndDateIsNull_ThenShouldPersistException() {
        addMeetingScheduleRequest.setEndDate(null);
        accountController.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountEndDateIsBeforeToday_ThenShouldPersistException() {
        addMeetingScheduleRequest.setEndDate(LocalDateTime.now().minusDays(1).toString());
        accountController.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountEndDateIsBeforeStartdate_ThenShouldPersistException() {
        addMeetingScheduleRequest.setEndDate(LocalDateTime.now().minusDays(1).toString());
        addMeetingScheduleRequest.setStartDate(LocalDateTime.now().plusDays(1).toString());
        accountController.addMeeting("+962798988910", addMeetingScheduleRequest);
    }

    @Test(expected = MeetingScheduleException.class)
    public void whenAddMeeting_AndAccountNotExist_ThenShouldPersistException() {
        accountController.addAccount(addAccountRequest);
        accountController.addMeeting("+962798988911", addMeetingScheduleRequest);
    }

    @Test
    public void whenAddMeeting_AndAccountExist_ThenShouldAddMeeting() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        AddMeetingScheduleResponse addMeetingScheduleResponse = accountController.addMeeting(addAccountResponse.getMobile(), addMeetingScheduleRequest).getContent();
        assertNotNull(addMeetingScheduleResponse.getMobile());
    }

    @Test
    public void whenListMeeting_AndMeetingRepositoryIsEmpty_ThenShouldReturnEmptyList() {
        List<Resource<ListMeetingResponse>> listMeetingResponses = accountController.listMeeting();
        assertTrue(listMeetingResponses.isEmpty());
    }

    @Test
    public void whenListMeeting_AndMeetingRepositoryIsNotEmpty_ThenShouldReturnListOfMeeting() {
        AddAccountResponse addAccountResponse = accountController.addAccount(addAccountRequest).getContent();
        accountController.addMeeting(addAccountResponse.getMobile(), addMeetingScheduleRequest);
        List<Resource<ListMeetingResponse>> listMeetingResponses = accountController.listMeeting();
        assertTrue(!listMeetingResponses.isEmpty());
    }
}
