package com.wazn.application.configuration;

import com.wazn.application.gateway.AccountGateway;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.repository.AccountRepositoryImp;
import com.wazn.application.service.AccountService;
import com.wazn.application.service.AccountServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfiguration {

    @Bean
    public AccountService getAccountServiceImp() {
        return new AccountServiceImp(getAccountRepository());
    }

    @Bean
    public AccountRepository getAccountRepository() {
        return new AccountRepositoryImp();
    }

    @Bean
    public AccountGateway getAccountGateway() {
        return new AccountGateway();
    }

}
