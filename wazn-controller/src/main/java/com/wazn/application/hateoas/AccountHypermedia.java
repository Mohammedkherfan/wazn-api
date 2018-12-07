package com.wazn.application.hateoas;

import com.wazn.application.controller.AccountControllerImp;
import com.wazn.application.request.*;
import com.wazn.application.response.*;
import org.springframework.hateoas.Resource;

import static java.util.Objects.isNull;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class AccountHypermedia {

    private static final String ADD_ACCOUNT = "add";
    private static final String FIND = "find";
    private static final String VERIFY = "verify";
    private static final String ADD_DOCUMENT = "addDocument";
    private static final String LOGIN = "login";
    private static final String ADD_MEETING = "addMeeting";
    private static final String LIST_MEETING = "listMeeting";
    private static final String FIND_MEETING = "findMeeting";
    private static final String UPDATE_MEETING = "updateMeeting";
    private static final String ADD_ACCOUNT_TYPE = "addAccountType";
    private static final String FIND_ACCOUNT_TYPE = "findAccountType";
    private static final String UPLOAD_DOCUMENT = "uploadDocument";
    private static final String FIND_UPLOADED_DOC = "findUploadedDocument";
    
    public Resource getAccountResources(Object object, String operation) {
        Resource resource = null;

        if (operation.equals(ADD_ACCOUNT))
            resource = getAddResources(object);
        if (operation.equals(FIND))
            resource = getFindResources(object);
        if (operation.equals(VERIFY))
            resource = getVerifyResources(object);
        if (operation.equals(ADD_DOCUMENT))
            resource = getAddDocumentResources(object);
        if (operation.equals(LOGIN))
            resource = getLoginResources(object);
        if (operation.equals(ADD_MEETING))
            resource = getAddMeetingResources(object);
        if (operation.equals(LIST_MEETING))
            resource = getListMeetingResources(object);
        if (operation.equals(FIND_MEETING))
            resource = getFindMeeting(object);
        if (operation.equals(UPDATE_MEETING))
            resource = getUpdateMeeting(object);
        if (operation.equals(ADD_ACCOUNT_TYPE))
            resource = getAddAccountType(object);
        if (operation.equals(FIND_ACCOUNT_TYPE))
            resource = getFindAccountType(object);
        if (operation.equals(UPLOAD_DOCUMENT))
            resource = getUploadDocument(object);
        if (operation.equals(FIND_UPLOADED_DOC))
            resource = getfindUploadedDocument(object);
        return resource;
    }

    private Resource getfindUploadedDocument(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            GetUploadedDocumentResponse response = (GetUploadedDocumentResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).getUploadedDocument(response.getMobile())).withSelfRel().withType("GET"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new GetUploadedDocumentResponse());
    }

    private Resource getUploadDocument(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            UploadDocumentResponse response = (UploadDocumentResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).uploadDocument(response.getMobile(), new UploadDocumentRequest())).withSelfRel().withType("POST"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new UploadDocumentResponse());
    }

    private Resource getFindAccountType(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            GetAccountTypeResponse response = (GetAccountTypeResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).getAccountType(response.getMobile())).withSelfRel().withType("GET"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new GetAccountTypeResponse());
    }

    private Resource getAddAccountType(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            AddAccountTypeResponse response = (AddAccountTypeResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).addAccountType(response.getMobile(), new AddAccountTypeRequest())).withSelfRel().withType("POST"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new AddAccountTypeResponse());
    }

    private Resource getUpdateMeeting(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            UpdateMeetingScheduleResponse response = (UpdateMeetingScheduleResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).updateMeeting(response.getMobile(), new UpdateMeetingScheduleRequest())).withSelfRel().withType("PUT"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new UpdateMeetingScheduleResponse());
    }

    private Resource getFindMeeting(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            ListMeetingResponse response = (ListMeetingResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).getMeeting(response.getMobile())).withSelfRel().withType("GET"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new ListMeetingResponse());
    }

    private Resource getListMeetingResources(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            ListMeetingResponse response = (ListMeetingResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).listMeeting()).withSelfRel().withType("GET"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new ListMeetingResponse());
    }

    private Resource getAddMeetingResources(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            AddMeetingScheduleResponse response = (AddMeetingScheduleResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).addMeeting(response.getMobile(), new AddMeetingScheduleRequest())).withSelfRel().withType("POST"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new AddMeetingScheduleResponse());
    }

    private Resource getLoginResources(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            LoginResponse response = (LoginResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).login(response.getMobile(), new String())).withSelfRel().withType("POST"));
            resource.add(linkTo(methodOn(AccountControllerImp.class).getAccount(response.getMobile())).withRel("find").withType("GET"));
            resource.add(linkTo(methodOn(AccountControllerImp.class).addMeeting(response.getMobile(), new AddMeetingScheduleRequest())).withRel("addMeeting").withType("POST"));

            resource = new Resource(response);
            return resource;
        }
        return new Resource(new LoginResponse());
    }

    private Resource getAddDocumentResources(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            AddDocumentResponse response = (AddDocumentResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).addDocument(response.getMobile(),new AddDocumentRequest())).withSelfRel().withType("POST"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new AddDocumentResponse());
    }

    private Resource getVerifyResources(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            VerificationCodeResponse response = (VerificationCodeResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).verifyCode(response.getMobile(),new String())).withSelfRel().withType("GET"));
            resource.add(linkTo(methodOn(AccountControllerImp.class).addDocument(response.getMobile(),new AddDocumentRequest())).withRel("addDocument").withType("POST"));
            resource = new Resource(response);
            return resource;
        }
        return new Resource(new VerificationCodeResponse());
    }

    private Resource getFindResources(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            GetAccountResponse response = (GetAccountResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).getAccount(response.getMobile())).withRel("find").withType("GET"));
            return resource;
        }
        return new Resource(new GetAccountResponse());
    }

    private Resource getAddResources(Object object) {
        Resource resource = null;
        if (!isNull(object)) {
            AddAccountResponse response = (AddAccountResponse) object;
            resource = new Resource(response);
            resource.add(linkTo(methodOn(AccountControllerImp.class).addAccount(new AddAccountRequest())).withSelfRel().withType("POST"));
            resource.add(linkTo(methodOn(AccountControllerImp.class).verifyCode(response.getMobile(),new String())).withRel("verify").withType("GET"));
            return resource;
        }
        return new Resource(new AddAccountResponse());
    }
}
