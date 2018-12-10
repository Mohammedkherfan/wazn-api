package com.wazn.application.mapper;

import com.wazn.application.entity.UserEntity;
import com.wazn.application.model.User;

public interface UserMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);
}
