package com.tarkhan.app.repository;

import com.tarkhan.app.entity.Account;
import com.tarkhan.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByCardNumber(String cardNumber);
    List<Account> findAllByUser(User user);
    Optional<Account> findByCardNumber(String cardNumber);
    Optional<Account> findByCardNumberAndCvv(String cardNumber, String cvv);
}
