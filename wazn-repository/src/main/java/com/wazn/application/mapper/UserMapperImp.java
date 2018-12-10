package com.wazn.application.mapper;

import com.wazn.application.entity.UserEntity;
import com.wazn.application.model.User;

public class UserMapperImp implements UserMapper {


    @Override
    public User toUser(UserEntity userEntity) {
        return new User.Builder()
                .userName(userEntity.getUserName())
                .fullName(userEntity.getFullName())
                .address(userEntity.getAddress())
                .businessUnit(userEntity.getBusinessUnit())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .phoneNumber(userEntity.getPhoneNumber())
                .role(userEntity.getRole())
                .build();
    }

    @Override
    public UserEntity toUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setFullName(user.getFullName());
        userEntity.setAddress(user.getAddress());
        userEntity.setBusinessUnit(user.getBusinessUnit());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setRole(user.getRole());
        return userEntity;
    }
}
