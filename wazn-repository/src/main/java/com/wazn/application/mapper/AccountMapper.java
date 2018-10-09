package com.wazn.application.mapper;

import com.wazn.application.entity.AccountEntity;
import com.wazn.application.model.Account;

public interface AccountMapper {

    Account toAccount(AccountEntity accountEntity);

    AccountEntity toAccountEntity(Account account);
}
