package com.wazn.application.usecase;

import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.response.AddAccountResponse;

public interface AddAccountUseCase {

    AddAccountResponse addAccount(AddAccountRequest request);
}
