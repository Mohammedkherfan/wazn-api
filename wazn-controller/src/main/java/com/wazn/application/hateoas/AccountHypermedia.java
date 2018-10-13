package com.wazn.application.hateoas;

import com.wazn.application.controller.AccountControllerImp;
import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.request.AddMeetingScheduleRequest;
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
        return resource;
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
        return new Resource(new AddMeetingScheduleResponse());
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
        return new Resource(new AddMeetingScheduleResponse());
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
