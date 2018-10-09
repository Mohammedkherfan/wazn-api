package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.exception.InvalidAccountPasswordException;
import com.wazn.application.model.Account;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.response.AddAccountResponse;
import com.wazn.application.util.Encode;
import com.wazn.application.util.VerificationCode;

public class AddAccountUseCaseImp implements AddAccountUseCase {

    private AccountRepository accountRepository;

    public AddAccountUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AddAccountResponse addAccount(AddAccountRequest request) {
        try {
            Account account = new Account.Builder()
                    .email(request.getEmail())
                    .mobile(request.getMobile())
                    .fullName(request.getFullName())
                    .verificationCode(Encode.encode(VerificationCode.generateVerificationCode()))
                    .password(Encode.encode(request.getPassword()))
                    .confirmPassword(Encode.encode(request.getConfirmPassword()))
                    .build();
            if (isPasswordMatch(account))
                accountRepository.addAccount(account);
            return new AddAccountResponse(account.getMobile());
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    private Boolean isPasswordMatch(Account account) {
        if (account.getPassword().equals(account.getConfirmPassword()))
            return Boolean.TRUE;
        else
            throw new InvalidAccountPasswordException("Password and Confirm Password Not Match !");
    }
}
