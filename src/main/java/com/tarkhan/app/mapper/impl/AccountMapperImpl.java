package com.tarkhan.app.mapper.impl;

import com.tarkhan.app.entity.Account;
import com.tarkhan.app.mapper.AccountMapper;
import com.tarkhan.app.model.account.AccountResponseModel;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public AccountResponseModel toResponseModel(Account account) {
        return AccountResponseModel
                .builder()
                .cardNumber(account.getCardNumber())
                .cvv(account.getCvv())
                .balance(account.getBalance())
                .build();
    }
}
