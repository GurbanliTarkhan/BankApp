package com.tarkhan.app.mapper;

import com.tarkhan.app.entity.User;
import com.tarkhan.app.model.authentication.UserProfileResponseModel;

public interface UserProfileMapper {
    UserProfileResponseModel toUserProfile(User user);
}
