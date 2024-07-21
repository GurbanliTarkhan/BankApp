package com.tarkhan.app.mapper;

import com.tarkhan.app.entity.Account;
import com.tarkhan.app.model.account.AccountResponseModel;

public interface AccountMapper {
    AccountResponseModel toResponseModel(Account account);
}
