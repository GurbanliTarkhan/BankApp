package com.tarkhan.app.model.transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositRequestModel {
    @NotNull(message = "Card number is required")
    private String cardNumber;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount can't be negative")
    private Double amount;
}
