package com.wazn.application.controller;

import com.wazn.application.exception.AccountException;
import com.wazn.application.exception.MeetingScheduleException;
import com.wazn.application.exception.ReportException;
import com.wazn.application.exception.UserException;
import com.wazn.application.gateway.AccountGateway;
import com.wazn.application.hateoas.AccountHypermedia;
import com.wazn.application.request.*;
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

import java.sql.Blob;
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
    public Resource<LoginResponse> login(@PathVariable String mobile, @PathVariable String password) {
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
    public void generateReport(@PathVariable String mobile) {
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
    public Resource<AddMeetingScheduleResponse> addMeeting(@PathVariable String mobile, @RequestBody AddMeetingScheduleRequest request) {
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
    public Resource<GetMeetingScheduleResponse> getMeeting(@PathVariable String mobile) {
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
    public Boolean checkMeetingTime(@PathVariable String mobile) {
        try {
             return gateway.checkMeetingTime(mobile);
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: checkMeetingTime" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/updateMeeting", method = RequestMethod.PUT, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to update new meeting.", notes = "This method used when you want to update meeting.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, updateMeetingScheduleRequest")
    public Resource<UpdateMeetingScheduleResponse> updateMeeting(@PathVariable String mobile, @RequestBody UpdateMeetingScheduleRequest request) {
        UpdateMeetingScheduleResponse updateMeetingScheduleResponse = null;
        try {
            updateMeetingScheduleResponse = gateway.updateMeeting(mobile, request);
            return hypermedia.getAccountResources(updateMeetingScheduleResponse, "updateMeeting");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: updateMeeting" + ", Exception: " + ex);
            throw new MeetingScheduleException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/addAccountType", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to add account type new meeting.", notes = "This method used when you want to add account type meeting.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, addAccountTypeRequest")
    public Resource<AddAccountTypeResponse> addAccountType(@PathVariable String mobile, @RequestBody AddAccountTypeRequest request) {
        AddAccountTypeResponse addAccountTypeResponse = null;
        try {
            addAccountTypeResponse = gateway.addAccountType(mobile, request);
            return hypermedia.getAccountResources(addAccountTypeResponse, "addAccountType");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: addAccountType" + ", Exception: " + ex);
            throw new MeetingScheduleException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/findAccountType", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to get account type.", notes = "This method used when you want to get account.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, getAccountTypeRequest")
    public Resource<GetAccountTypeResponse> getAccountType(@PathVariable String mobile) {
        GetAccountTypeResponse getAccountTypeResponse = null;
        try {
            getAccountTypeResponse = gateway.getAccountType(mobile);
            return hypermedia.getAccountResources(getAccountTypeResponse, "findAccountType");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: getAccountType" + ", Exception: " + ex);
            throw new MeetingScheduleException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/uploadDocument", method = RequestMethod.POST, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    @ApiOperation(value = "Method to create upload Document.", notes = "This method used when you want to upload Document.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile, uploadDocumentRequest")
    public Resource<UploadDocumentResponse> uploadDocument(@PathVariable String mobile, @RequestBody UploadDocumentRequest request) {
        UploadDocumentResponse uploadDocumentResponse = null;
        try {
            uploadDocumentResponse = gateway.uploadDocument(mobile, request);
            return hypermedia.getAccountResources(uploadDocumentResponse, "uploadDocument");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: uploadDocument" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/findUploadedDocument", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to get uploaded document.", notes = "This method used when you want to get uploaded document.")
    @ApiParam(value = "The parameter for this operation.", name = "mobile")
    public Resource<GetUploadedDocumentResponse> getUploadedDocument(@PathVariable String mobile) {
        GetUploadedDocumentResponse getAccountTypeResponse = null;
        try {
            getAccountTypeResponse = gateway.getUploadedDocument(mobile);
            return hypermedia.getAccountResources(getAccountTypeResponse, "findUploadedDocument");
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: getUploadedDocument" + ", Exception: " + ex);
            throw new MeetingScheduleException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    public List<Resource<GetAllDataResponse>> getAllData() {
        List<Resource<GetAllDataResponse>> list = new ArrayList<>();
        try {
            gateway.getAllData().forEach(e -> {
                list.add(hypermedia.getAccountResources(e, "all"));
            });
            return list;
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: getAllData" + ", Exception: " + ex);
            throw new MeetingScheduleException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/all", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    public Resource<GetAllDataResponse> getAllData(@PathVariable String mobile) {
        GetAllDataResponse allDataResponse = null;
        try {
            allDataResponse = gateway.getAllData(mobile);
            return hypermedia.getAccountResources(allDataResponse, "all");
        } catch (AccountException ex) {
            return hypermedia.getAccountResources(new GetAllDataResponse(), "all");
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: getAllData" + ", Exception: " + ex);
            return hypermedia.getAccountResources(new GetAllDataResponse(), "all");
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/{comment}/save", method = RequestMethod.PUT, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    public void saveComment(@PathVariable String mobile, @PathVariable String comment) {
        try {
            gateway.saveComment(mobile, comment);
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: saveComment" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/{status}/status", method = RequestMethod.PUT, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin()
    public void updateStatus(@PathVariable String mobile, @PathVariable String status) {
        try {
            gateway.updateStatus(mobile, status);
        } catch (AccountException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: AccountControllerImp" + ", Method: updateStatus" + ", Exception: " + ex);
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    @RequestMapping(value = "/{mobile}/{type}/download", method = RequestMethod.GET, produces = {"application/hal+json"})
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin()
    @ApiOperation(value = "Method to list users.", notes = "This method used when you want to list users.")
    public byte[] download(@PathVariable String mobile, @PathVariable String type) {
        try {
            return gateway.download(mobile, type);
        } catch (UserException ex) {
            throw ex;
        } catch (Exception ex) {
            log.error("Class: UserControllerImp" + ", Method: download" + ", Exception: " + ex);
            throw new UserException(ex.getMessage());
        }
    }

}
