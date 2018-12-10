package com.wazn.application.usecase;

import com.wazn.application.request.AddUserRequest;
import com.wazn.application.response.AddUserResponse;

public interface AddUserUseCase {

    AddUserResponse addUser(AddUserRequest request);
}
