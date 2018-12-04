package com.wazn.application.usecase;

import com.wazn.application.request.AddAccountTypeRequest;
import com.wazn.application.response.AddAccountTypeResponse;

public interface AddAccountTypeUseCase {

    AddAccountTypeResponse addAccountType(String mobile, AddAccountTypeRequest request);
}
