package com.tarkhan.app.service;

import com.tarkhan.app.model.account.AccountResponseModel;

import java.util.List;

public interface AccountService {
    AccountResponseModel createNewAccount();
    List<AccountResponseModel> getMyAccounts();
}
