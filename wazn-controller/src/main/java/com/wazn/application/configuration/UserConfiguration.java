package com.wazn.application.configuration;

import com.wazn.application.gateway.UserGateway;
import com.wazn.application.repository.UserRepository;
import com.wazn.application.repository.UserRepositoryImp;
import com.wazn.application.service.UserService;
import com.wazn.application.service.UserServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserService getUserService() {
        return new UserServiceImp(getUserRepository());
    }

    @Bean
    public UserRepository getUserRepository() {
        return new UserRepositoryImp();
    }

    @Bean
    public UserGateway getUserGateway() {
        return new UserGateway();
    }

}
