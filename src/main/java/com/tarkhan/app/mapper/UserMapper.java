package com.tarkhan.app.mapper;

import com.tarkhan.app.entity.User;
import com.tarkhan.app.model.authentication.RegisterRequestModel;

public interface UserMapper {
    User toUser(RegisterRequestModel request);
}
