package com.tarkhan.app.mapper.impl;

import com.tarkhan.app.entity.Account;
import com.tarkhan.app.entity.Transaction;
import com.tarkhan.app.entity.TransactionType;
import com.tarkhan.app.mapper.TransactionMapper;
import com.tarkhan.app.model.transaction.TransactionResponseModel;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toEntity(double amount, Account account, TransactionType type) {
        return Transaction
                .builder()
                .amount(amount)
                .account(account)
                .type(type)
                .timestamp(new Date())
                .notes("Account Balance" + account.getBalance())
                .build();
    }

    @Override
    public TransactionResponseModel toResponseModel(Long id, double amount, double balance) {
        return TransactionResponseModel
                .builder()
                .id(id)
                .amount(amount)
                .balance(balance)
                .build();
    }
}
