package org.example;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int result = 0;
        String[] numsArray = numbers.split(",");
        for (String number : numsArray) {
            result += parseInt(number);
        }
        return result;
    }
}
