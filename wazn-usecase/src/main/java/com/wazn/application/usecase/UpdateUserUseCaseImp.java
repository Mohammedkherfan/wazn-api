package com.wazn.application.usecase;

import com.wazn.application.exception.UserException;
import com.wazn.application.model.User;
import com.wazn.application.repository.UserRepository;
import com.wazn.application.request.UpdateUserRequest;
import com.wazn.application.response.UpdateUserResponse;

public class UpdateUserUseCaseImp implements UpdateUserUseCase {

    private UserRepository repository;

    public UpdateUserUseCaseImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UpdateUserResponse updateUser(String userName, UpdateUserRequest request) {
        try {
            User user = new User.Builder()
                    .userName(userName)
                    .fullName(request.getFullName())
                    .address(request.getAddress())
                    .businessUnit(request.getBusinessUnit())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .phoneNumber(request.getPhoneNumber())
                    .role(request.getRole())
                    .build();
            return new UpdateUserResponse(repository.updateUser(userName, user));
        }catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
