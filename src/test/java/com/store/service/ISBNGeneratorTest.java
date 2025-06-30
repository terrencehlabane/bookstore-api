package com.example.bookstore.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ISBNGeneratorTest {

    private final ISBNGenerator generator = new ISBNGenerator();

    @Test
    void generateISBN_shouldReturnValid13DigitISBN() {
        String isbn = generator.generateISBN();

        assertEquals(13, isbn.length());

        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            sum += digit * ((i % 2 == 0) ? 1 : 3);
        }

        int checkDigit = Character.getNumericValue(isbn.charAt(12));
        int total = sum + checkDigit;

        assertEquals(0, total % 10, "Check digit is invalid");
    }
}
