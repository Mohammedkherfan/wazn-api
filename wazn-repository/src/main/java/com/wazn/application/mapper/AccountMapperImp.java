package com.wazn.application.mapper;

import com.wazn.application.entity.AccountEntity;
import com.wazn.application.model.Account;

public class AccountMapperImp implements AccountMapper {

    @Override
    public Account toAccount(AccountEntity accountEntity) {
        return new Account.Builder()
                .email(accountEntity.getEmail())
                .mobile(accountEntity.getMobile())
                .fullName(accountEntity.getName())
                .verificationCode(accountEntity.getVerificationCode())
                .password(accountEntity.getPassword())
                .confirmPassword(accountEntity.getPassword())
                .build();
    }

    @Override
    public AccountEntity toAccountEntity(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setEmail(account.getEmail());
        accountEntity.setMobile(account.getMobile());
        accountEntity.setName(account.getFullName());
        accountEntity.setVerificationCode(account.getVerificationCode());
        accountEntity.setPassword(account.getPassword());
        return accountEntity;
    }
}
