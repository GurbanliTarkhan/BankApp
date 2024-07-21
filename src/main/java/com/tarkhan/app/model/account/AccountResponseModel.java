package com.tarkhan.app.model.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponseModel {
    private String cardNumber;
    private String cvv;
    private Double balance;
}
