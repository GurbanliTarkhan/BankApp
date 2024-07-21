package com.tarkhan.app.mapper.impl;

import com.tarkhan.app.entity.User;
import com.tarkhan.app.mapper.UserProfileMapper;
import com.tarkhan.app.model.authentication.UserProfileResponseModel;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapperImpl implements UserProfileMapper {

    @Override
    public UserProfileResponseModel toUserProfile(User user) {
        return UserProfileResponseModel
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }
}
