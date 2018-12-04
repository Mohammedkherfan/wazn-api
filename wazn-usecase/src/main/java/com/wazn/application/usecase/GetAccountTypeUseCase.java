package com.wazn.application.usecase;

import com.wazn.application.response.GetAccountTypeResponse;

public interface GetAccountTypeUseCase {

    GetAccountTypeResponse getAccountType(String mobile);
}
