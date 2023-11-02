package org.example;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class StringCalculator {

    public int add(String numbers) throws Exception {
        String regex = getRegex(numbers);
        List<Integer> numsArray = getNumbers(numbers, regex);

        int result = 0;
        for (int number : numsArray) {
            if (isNegativeNumber(number)) {
                throw new Exception("negatives not allowed: " + number);
            }
            result += number;
        }
        return result;
    }

    private String getRegex(String numbers) {
        return (hasDynamicDelimiter(numbers))
                ? numbers.substring(2, numbers.indexOf("\n"))
                : ",|\\n";
    }

    private List<Integer> getNumbers(String numbers, String regex) {
        if (hasDynamicDelimiter(numbers)) {
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
        }

        return stream(numbers.split(regex))
                .filter(it -> !it.isEmpty())
                .map(Integer::parseInt)
                .collect(toList());
    }

    private boolean hasDynamicDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }
}
