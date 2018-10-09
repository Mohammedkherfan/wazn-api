package com.wazn.application.usecase;

import com.wazn.application.response.LoginResponse;

public interface LoginUseCase {

    LoginResponse login(String mobile, String password);
}
