package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.AccountType;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.AddAccountTypeRequest;
import com.wazn.application.response.AddAccountTypeResponse;

public class AddAccountTypeUseCaseImp implements AddAccountTypeUseCase {

    private AccountRepository repository;

    public AddAccountTypeUseCaseImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public AddAccountTypeResponse addAccountType(String mobile, AddAccountTypeRequest request) {
        try {
            AccountType accountType = new AccountType.Builder()
                    .mobile(mobile)
                    .type(request.getType())
                    .build();
            return new AddAccountTypeResponse(repository.addAccountType(accountType));
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
