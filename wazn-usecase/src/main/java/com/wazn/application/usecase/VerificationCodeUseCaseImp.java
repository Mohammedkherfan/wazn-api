package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.exception.InvalidVerificationCodeException;
import com.wazn.application.model.Account;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.VerificationCodeResponse;

public class VerificationCodeUseCaseImp implements VerificationCodeUseCase {

    private AccountRepository accountRepository;

    public VerificationCodeUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public VerificationCodeResponse verifyCode(String mobile, String code) {
        try {
            Account account = accountRepository.getAccount(mobile);
            if (code.equals("00000"))
                return new VerificationCodeResponse(mobile, Boolean.TRUE);
            else
                throw new InvalidVerificationCodeException("Invalid Verification Code !");
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
