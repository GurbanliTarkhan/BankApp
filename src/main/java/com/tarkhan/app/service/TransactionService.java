package com.tarkhan.app.service;

import com.tarkhan.app.model.transaction.DepositRequestModel;
import com.tarkhan.app.model.transaction.TransactionResponseModel;
import com.tarkhan.app.model.transaction.WithdrawRequestModel;

public interface TransactionService {
    TransactionResponseModel deposit(DepositRequestModel request);
    TransactionResponseModel withdraw(WithdrawRequestModel request);
}
