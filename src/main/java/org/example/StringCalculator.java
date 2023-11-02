package org.example;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class StringCalculator {

    public int add(String numbers) throws Exception {
        Delimiters delimiters = new Delimiters(numbers);
        List<Integer> numsArray = getNumbers(numbers, delimiters);

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

    private List<Integer> getNumbers(String numbers, Delimiters delimiters) {
        if (delimiters.isDynamic()) {
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        return stream(numbers.split(delimiters.retrieve()))
                .filter(it -> !it.isEmpty())
                .map(Integer::parseInt)
                .collect(toList());
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private boolean isBigNumbers(int number) {
        return number >= 1000;
    }
}
