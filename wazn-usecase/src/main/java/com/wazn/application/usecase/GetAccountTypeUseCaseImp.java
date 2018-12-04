package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.AccountType;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.GetAccountTypeResponse;

public class GetAccountTypeUseCaseImp implements GetAccountTypeUseCase {

    private AccountRepository repository;

    public GetAccountTypeUseCaseImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetAccountTypeResponse getAccountType(String mobile) {
        try {
            AccountType accountType = repository.getAccountType(mobile);
            return new GetAccountTypeResponse(accountType.getMobile(), accountType.getType());
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
