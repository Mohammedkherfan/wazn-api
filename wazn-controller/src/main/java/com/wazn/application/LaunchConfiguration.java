package com.wazn.application;

import com.wazn.application.configuration.AccountConfiguration;
import com.wazn.application.configuration.UserConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchConfiguration {

    @Bean
    public AccountConfiguration launchAccountConfiguration() { return new AccountConfiguration(); }

    @Bean
    public UserConfiguration launchUserConfiguration() { return new UserConfiguration(); }
}
