package com.wazn.application.gateway;

import com.wazn.application.request.AddUserRequest;
import com.wazn.application.request.UpdateUserRequest;
import com.wazn.application.response.AddUserResponse;
import com.wazn.application.response.ListUserResponse;
import com.wazn.application.response.UpdateUserResponse;
import com.wazn.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Blob;
import java.util.List;

public class UserGateway {

    @Autowired
    private UserService service;

    public AddUserResponse addUser(AddUserRequest request) { return service.addUser(request); }

    public List<ListUserResponse> listUser() { return service.listUser(); }

    public UpdateUserResponse updateUser(String userName, UpdateUserRequest request) { return service.updateUser(userName, request); }
}
