package com.wazn.application.repository;

import com.wazn.application.exception.UserException;
import com.wazn.application.mapper.UserMapper;
import com.wazn.application.mapper.UserMapperImp;
import com.wazn.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImp implements UserRepository {

    @Autowired
    private UserCrudRepository repository;

    private UserMapper mapper = new UserMapperImp();

    @Override
    public String addUser(User user) {
        try {
            if (repository.existsById(user.getUserName()))
                throw new UserException("User already exist");
            return repository.save(mapper.toUserEntity(user)).getUserName();
        }catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    public String updateUser(String userName, User user) {
        try {
            if (repository.existsById(userName))
                return repository.save(mapper.toUserEntity(user)).getUserName();
            else
                throw new UserException("User not exist");
        }catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    public List<User> listUser() {
        try {
            List<User> list = new ArrayList<>();
            repository.findAll().forEach(e -> {
                list.add(mapper.toUser(e));
            });
            return list;
        }catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }
}
