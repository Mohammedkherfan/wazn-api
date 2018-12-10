package com.wazn.application.usecase;

import com.wazn.application.exception.UserException;
import com.wazn.application.model.User;
import com.wazn.application.repository.UserRepository;
import com.wazn.application.request.AddUserRequest;
import com.wazn.application.response.AddUserResponse;

public class AddUserUseCaseImp implements AddUserUseCase {

    private UserRepository repository;

    public AddUserUseCaseImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public AddUserResponse addUser(AddUserRequest request) {
        try {
            User user = new User.Builder()
                    .userName(request.getUserName())
                    .fullName(request.getFullName())
                    .address(request.getAddress())
                    .businessUnit(request.getBusinessUnit())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .phoneNumber(request.getPhoneNumber())
                    .role(request.getRole())
                    .build();
            return new AddUserResponse(repository.addUser(user));
        }catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
