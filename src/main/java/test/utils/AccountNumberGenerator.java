package test.utils;

import java.util.Random;

public class AccountNumberGenerator {

    private static final String NUMBERS = "0123456789";
    private static final int NUMBER_LENGTH = 12;

    private static final Random random = new Random();

    private AccountNumberGenerator() {
    }

    public static String generate() {
        char[] buffer = new char[NUMBER_LENGTH];
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            buffer[i] = NUMBERS.charAt(random.nextInt(NUMBERS.length()));
        }

        return new String(buffer);
    }
}
