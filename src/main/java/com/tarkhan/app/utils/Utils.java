package com.tarkhan.app.utils;

import com.tarkhan.app.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Utils {
    private static final Random RANDOM = new Random();
    private static final int START_NUM = 4169;
    private static final int CARD_NUMBER_LENGTH = 16;

    public static String generateCardNumber(AccountRepository accountRepository) {
        int prefix = START_NUM;
        String cardNumber = generateCardNumberWithPrefix(prefix);

        // Check for existing card numbers and increase prefix if needed
        while (accountRepository.existsByCardNumber(cardNumber)) {
            prefix++;
            cardNumber = generateCardNumberWithPrefix(prefix);
        }

        return cardNumber;
    }

    private static String generateCardNumberWithPrefix(int prefix) {
        String prefixStr = Integer.toString(prefix);
        int remainingLength = CARD_NUMBER_LENGTH - prefixStr.length();
        String randomPart = generateRandomNumber(remainingLength);
        return prefixStr + randomPart;
    }

    private static String generateRandomNumber(int len) {
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int digit = RANDOM.nextInt(10);
            number.append(digit);
        }
        return number.toString();
    }

    public static String generateCVV() {
        return generateRandomNumber(3);
    }
}
