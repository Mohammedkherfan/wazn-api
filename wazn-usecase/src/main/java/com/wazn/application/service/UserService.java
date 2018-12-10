package com.wazn.application.service;

import com.wazn.application.request.AddUserRequest;
import com.wazn.application.request.UpdateUserRequest;
import com.wazn.application.response.AddUserResponse;
import com.wazn.application.response.ListUserResponse;
import com.wazn.application.response.UpdateUserResponse;

import java.util.List;

public interface UserService {

    AddUserResponse addUser(AddUserRequest request);

    List<ListUserResponse> listUser();

    UpdateUserResponse updateUser(String userName, UpdateUserRequest request);
}
