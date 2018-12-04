package com.wazn.application.mapper;

import com.wazn.application.entity.AccountTypeEntity;
import com.wazn.application.model.AccountType;

public class AccountTypeMapperImp implements AccountTypeMapper {

    @Override
    public AccountType toAccountType(AccountTypeEntity accountTypeEntity) {
        return new AccountType.Builder().mobile(accountTypeEntity.getMobile()).type(accountTypeEntity.getType()).build();
    }

    @Override
    public AccountTypeEntity toAccountTypeEntity(AccountType accountType) {
        AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
        accountTypeEntity.setMobile(accountType.getMobile());
        accountTypeEntity.setType(accountType.getType());
        return accountTypeEntity;
    }
}
