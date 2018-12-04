package com.wazn.application.mapper;

import com.wazn.application.entity.AccountTypeEntity;
import com.wazn.application.model.AccountType;

public interface AccountTypeMapper {

    AccountType toAccountType(AccountTypeEntity accountTypeEntity);

    AccountTypeEntity toAccountTypeEntity(AccountType accountType);
}
