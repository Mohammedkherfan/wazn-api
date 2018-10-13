package com.wazn.application.controller;

import com.wazn.application.exception.AccountException;
import com.wazn.application.exception.MeetingScheduleException;
import com.wazn.application.exception.ReportException;
import com.wazn.application.gateway.AccountGateway;
import com.wazn.application.hateoas.AccountHypermedia;
import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.request.AddMeetingScheduleRequest;
import com.wazn.application.response.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/wazn/accounts")
@Api(description = "Wazn Application API (Add Account, Get Account).")
public class AccountControllerImp implements AccountController {

    @Autowired
    private AccountGateway gateway;
    private AccountHypermedia hypermedia = new AccountHypermedia();
    private final Logger log = LoggerFactory.getLogger(AccountControllerImp.class.getClass());

    @Override
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to create new account.", notes = "This method used when you want to add account.")
    @ApiParam(value = "The parameter for this operation.", name = "addAccountRequest")
    public Resource<AddAccountResponse> addAccount(@RequestBody AddAccountRequest request) {
        AddAccountResponse addAccountResponse = null;
        try {
            addAccountResponse = gateway.addAccount(request);
            return hypermedia.getAccountResources(addAccountResponse, "add");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: addAccount" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/find", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to get account.", notes = "This method used when you want to get account.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile")
    public Resource<GetAccountResponse> getAccount(@PathVariable String mobile) {
        GetAccountResponse getAccountResponse = null;
        try {
            getAccountResponse = gateway.getAccount(mobile);
            return hypermedia.getAccountResources(getAccountResponse, "find");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: getAccount" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/{code}/verify", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to verify account code.", notes = "This method used when you want to verify account code.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, code")
    public Resource<VerificationCodeResponse> verifyCode(@PathVariable String mobile, @PathVariable String code) {
        VerificationCodeResponse verificationCodeResponse = null;
        try {
            verificationCodeResponse = gateway.verifyCode(mobile, code);
            return hypermedia.getAccountResources(verificationCodeResponse, "verify");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: verifyCode" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/addDocument", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to create new document.", notes = "This method used when you want to add document.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, addDocumentRequest")
    public Resource<AddDocumentResponse> addDocument(@PathVariable String mobile, @RequestBody AddDocumentRequest request) {
        AddDocumentResponse addDocumentResponse = null;
        try {
            addDocumentResponse = gateway.addDocument(mobile, request);
            return hypermedia.getAccountResources(addDocumentResponse, "addDocument");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: addDocument" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/{password}/login", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to login to account.", notes = "This method used when you want to login to account.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, password")
    public Resource<LoginResponse> login(String mobile, String password) {
        LoginResponse loginResponse = null;
        try {
            loginResponse = gateway.login(mobile, password);
            return hypermedia.getAccountResources(loginResponse, "login");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: login" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/print", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to generate report.", notes = "This method used when you want to generate report.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile")
    public void generateReport(String mobile) {
        try {
            gateway.generateReport(mobile);
        }catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: generateReport" + ", Exception: " + ex);
            throw new ReportException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/addMeeting", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to create new meeting.", notes = "This method used when you want to add meeting.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, addMeetingScheduleRequest")
    public Resource<AddMeetingScheduleResponse> addMeeting(String mobile, AddMeetingScheduleRequest request) {
        AddMeetingScheduleResponse addMeetingScheduleResponse = null;
        try {
            addMeetingScheduleResponse = gateway.addMeeting(mobile, request);
            return hypermedia.getAccountResources(addMeetingScheduleResponse, "addMeeting");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: addMeeting" + ", Exception: " + ex);
            throw new MeetingScheduleException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/listMeeting", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to list meeting.", notes = "This method used when you want to list meeting.")
    public List<Resource<ListMeetingResponse>> listMeeting() {
        List<Resource<ListMeetingResponse>> list = new ArrayList<>();
        try {
            gateway.listMeeting().forEach(e -> {
                list.add(hypermedia.getAccountResources(e, "listMeeting"));
            });
            return list;
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: listMeeting" + ", Exception: " + ex);
            throw new MeetingScheduleException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/findMeeting", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to find meeting.", notes = "This method used when you want to find meeting.")
    public Resource<GetMeetingScheduleResponse> getMeeting(String mobile) {
        GetMeetingScheduleResponse getMeetingScheduleResponse = null;
        try {
            getMeetingScheduleResponse = gateway.getMeeting(mobile);
            return hypermedia.getAccountResources(getMeetingScheduleResponse, "findMeeting");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: getMeeting" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/checkMeeting", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to check meeting.", notes = "This method used when you want to check meeting.")
    public Boolean checkMeetingTime(String mobile) {
        try {
             return gateway.checkMeetingTime(mobile);
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: checkMeetingTime" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }
}
