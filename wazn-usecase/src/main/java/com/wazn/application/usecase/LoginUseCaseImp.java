package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.Account;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.LoginResponse;
import com.wazn.application.util.Decode;

public class LoginUseCaseImp implements LoginUseCase {

    private AccountRepository accountRepository;

    public LoginUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public LoginResponse login(String mobile, String password) {
        try {
            Account account = accountRepository.getAccount(mobile);
            if (!account.getMobile().equals(mobile))
                throw new AccountException("Account Not Exist !");
                if (Decode.decode(account.getPassword()).equals(password))
                    return new LoginResponse(mobile, Boolean.TRUE);
                else
                    throw new AccountException("Invalid Login");
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
