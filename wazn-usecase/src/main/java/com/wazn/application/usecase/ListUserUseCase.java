package com.wazn.application.usecase;

import com.wazn.application.response.ListUserResponse;

import java.util.List;

public interface ListUserUseCase {

    List<ListUserResponse> listUser();
}
