package com.wazn.application.repository;

import com.wazn.application.model.User;

import java.util.List;

public interface UserRepository {

    String addUser(User user);

    String updateUser(String userName, User user);

    List<User> listUser();
}
