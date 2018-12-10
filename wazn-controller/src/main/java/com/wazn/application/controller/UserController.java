package com.wazn.application.controller;

import com.wazn.application.request.AddUserRequest;
import com.wazn.application.request.UpdateUserRequest;
import com.wazn.application.response.AddUserResponse;
import com.wazn.application.response.ListUserResponse;
import com.wazn.application.response.UpdateUserResponse;
import org.springframework.hateoas.Resource;

import java.util.List;

public interface UserController {

    Resource<AddUserResponse> addUser(AddUserRequest request);

    List<Resource<ListUserResponse>> listUser();

    Resource<UpdateUserResponse> updateUser(String userName, UpdateUserRequest request);
}
