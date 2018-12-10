package com.wazn.application.usecase;

import com.wazn.application.request.UpdateUserRequest;
import com.wazn.application.response.UpdateUserResponse;

public interface UpdateUserUseCase {

    UpdateUserResponse updateUser(String userName, UpdateUserRequest request);
}
