package com.wazn.application.usecase;

import com.wazn.application.response.GetAccountResponse;

public interface GetAccountUseCase {

    GetAccountResponse getAccount(String mobile);
}
