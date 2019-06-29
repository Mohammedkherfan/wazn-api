package com.wazn.application.service;

import com.wazn.application.repository.UserRepository;
import com.wazn.application.request.AddUserRequest;
import com.wazn.application.request.UpdateUserRequest;
import com.wazn.application.response.AddUserResponse;
import com.wazn.application.response.ListUserResponse;
import com.wazn.application.response.UpdateUserResponse;
import com.wazn.application.usecase.*;

import java.sql.Blob;
import java.util.List;

public class UserServiceImp implements UserService {

    private AddUserUseCase addUserUseCase;
    private ListUserUseCase listUserUseCase;
    private UpdateUserUseCase updateUserUseCase;

    public UserServiceImp(UserRepository repository) {
        this.addUserUseCase = new AddUserUseCaseImp(repository);
        this.listUserUseCase = new ListUserUseCaseImp(repository);
        this.updateUserUseCase = new UpdateUserUseCaseImp(repository);
    }

    @Override
    public AddUserResponse addUser(AddUserRequest request) {
        return addUserUseCase.addUser(request);
    }

    @Override
    public List<ListUserResponse> listUser() {
        return listUserUseCase.listUser();
    }

    @Override
    public UpdateUserResponse updateUser(String userName, UpdateUserRequest request) {
        return updateUserUseCase.updateUser(userName, request);
    }
}
