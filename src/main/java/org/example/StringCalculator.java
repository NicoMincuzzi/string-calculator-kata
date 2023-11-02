package org.example;

import java.util.List;

public class StringCalculator {

    public int add(String numbers) throws Exception {
        Delimiters delimiters = new Delimiters(numbers);
        List<Integer> numsArray = new Numbers(numbers).retrieveSplittingBy(delimiters);

        int result = 0;
        for (int number : numsArray) {
            if (isNegativeNumber(number)) {
                throw new Exception("negatives not allowed: " + number);
            }
            if (isBigNumbers(number)) {
                continue;
            }
            result += number;
        }
        return result;
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private boolean isBigNumbers(int number) {
        return number >= 1000;
    }
}
