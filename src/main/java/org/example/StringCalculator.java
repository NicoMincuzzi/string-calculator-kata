package org.example;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.length() == 1) {
            return parseInt(numbers);
        }
        return 0;
    }
}
