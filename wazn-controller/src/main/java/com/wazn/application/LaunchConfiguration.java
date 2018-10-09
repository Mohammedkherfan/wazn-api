package com.wazn.application;

import com.wazn.application.configuration.AccountConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaunchConfiguration {

    @Bean
    public AccountConfiguration launchAccountConfiguration() { return new AccountConfiguration(); }
}
