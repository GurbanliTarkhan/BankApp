package com.tarkhan.app.mapper.impl;

import com.tarkhan.app.entity.Role;
import com.tarkhan.app.entity.User;
import com.tarkhan.app.mapper.UserMapper;
import com.tarkhan.app.model.authentication.RegisterRequestModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(RegisterRequestModel request) {
        return User
                .builder()
                .name(request.getName())
                .role(Role.USER)
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(request.getPassword())
                .build();
    }
}
