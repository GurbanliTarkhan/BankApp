package com.tarkhan.app.mapper;

import com.tarkhan.app.entity.Account;
import com.tarkhan.app.entity.Transaction;
import com.tarkhan.app.entity.TransactionType;
import com.tarkhan.app.model.transaction.TransactionResponseModel;

public interface TransactionMapper {
    Transaction toEntity(double amount, Account account, TransactionType type);
    TransactionResponseModel toResponseModel(Long id, double amount, double balance);
}
