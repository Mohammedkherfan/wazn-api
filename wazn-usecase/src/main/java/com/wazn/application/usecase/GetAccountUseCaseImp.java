package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.Account;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.GetAccountResponse;

public class GetAccountUseCaseImp implements GetAccountUseCase {

    private AccountRepository accountRepository;

    public GetAccountUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public GetAccountResponse getAccount(String mobile) {
        try {
            Account account = accountRepository.getAccount(mobile);
            return new GetAccountResponse(account.getEmail(), account.getMobile(), account.getFullName());
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
