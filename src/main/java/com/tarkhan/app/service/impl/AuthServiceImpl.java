package com.tarkhan.app.service.impl;

import com.tarkhan.app.entity.User;
import com.tarkhan.app.mapper.UserMapper;
import com.tarkhan.app.model.authentication.AuthenticationResponseModel;
import com.tarkhan.app.model.authentication.LoginRequestModel;
import com.tarkhan.app.model.authentication.RegisterRequestModel;
import com.tarkhan.app.repository.UserRepository;
import com.tarkhan.app.service.AuthService;
import com.tarkhan.app.service.auth.JwtService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseModel register(RegisterRequestModel request) {
        if (isEmailOrPhoneAlreadyExists(request.getEmail(), request.getPhone())) {
            throw new EntityExistsException("Email or Phone Number is already exists");
        }

        User user = userRepository.save(userMapper.toUser(request));

        return AuthenticationResponseModel.builder().token(jwtService.generateToken(user)).build();
    }

    private boolean isEmailOrPhoneAlreadyExists(String email, String phone) {
        return userRepository.existsByEmail(email) || userRepository.existsByPhone(phone);
    }

    @Override
    public AuthenticationResponseModel login(LoginRequestModel request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User " + request.getEmail() + " Not Found"));

        return AuthenticationResponseModel
                .builder()
                .token(jwtService.generateToken(user))
                .build();
    }
}
