package com.tarkhan.app.service.impl;

import com.tarkhan.app.entity.Account;
import com.tarkhan.app.entity.User;
import com.tarkhan.app.mapper.AccountMapper;
import com.tarkhan.app.model.account.AccountResponseModel;
import com.tarkhan.app.repository.AccountRepository;
import com.tarkhan.app.repository.UserRepository;
import com.tarkhan.app.service.AccountService;
import com.tarkhan.app.utils.Utils;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final UserRepository userRepository;

    @Override
    public AccountResponseModel createNewAccount() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email).orElseThrow(()
                -> new EntityNotFoundException("User " + email + " Not Found"));

        Account account = accountRepository.save(
                Account.builder()
                        .cardNumber(generateUniqueCardNumber())
                        .cvv(Utils.generateCVV())
                        .balance(0.0)
                        .user(user)
                        .build()
        );

        return accountMapper.toResponseModel(account);
    }

    public String generateUniqueCardNumber() {
        String cardNumber = Utils.generateCardNumber(accountRepository);

        while (accountRepository.existsByCardNumber(cardNumber)) {
            cardNumber = Utils.generateCardNumber(accountRepository);
        }

        return cardNumber;
    }

    @Override
    public List<AccountResponseModel> getMyAccounts() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User " + email + " Not Found"));

        return accountRepository
                .findAllByUser(user)
                .stream()
                .map(accountMapper::toResponseModel)
                .toList();
    }
}
