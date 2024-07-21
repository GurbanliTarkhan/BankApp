package com.tarkhan.app.service;

import com.tarkhan.app.model.authentication.AuthenticationResponseModel;
import com.tarkhan.app.model.authentication.LoginRequestModel;
import com.tarkhan.app.model.authentication.RegisterRequestModel;

public interface AuthService {
    public AuthenticationResponseModel register(RegisterRequestModel request);

    public AuthenticationResponseModel login(LoginRequestModel request);
}
