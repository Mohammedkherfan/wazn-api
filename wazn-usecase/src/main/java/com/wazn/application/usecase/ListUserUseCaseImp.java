package com.wazn.application.usecase;

import com.wazn.application.exception.UserException;
import com.wazn.application.repository.UserRepository;
import com.wazn.application.response.ListUserResponse;

import java.util.ArrayList;
import java.util.List;

public class ListUserUseCaseImp implements ListUserUseCase {

    private UserRepository repository;

    public ListUserUseCaseImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ListUserResponse> listUser() {
        try {
            List<ListUserResponse> list = new ArrayList<>();
            repository.listUser().forEach(e -> {
                list.add(new ListUserResponse(e.getUserName(), e.getPassword(), e.getFullName(), e.getBusinessUnit(), getRole(e.getRole()), e.getPhoneNumber(), e.getAddress(), e.getEmail()));
            });
            return list;
        }catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }

    private String getRole(Integer role) {
        if (role == 1)
            return "Admin";
        if (role == 2)
            return "Review Officer";
        if (role == 3)
            return "Approval Officer";
        return "";
    }
}
