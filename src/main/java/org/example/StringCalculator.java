package org.example;

import static java.lang.Integer.parseInt;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numsArray = retrieveNumbers(numbers);

        int result = 0;
        for (String number : numsArray) {
            result += parseInt(number);
        }
        return result;
    }

    private static String[] retrieveNumbers(String numbers) {
        String regex = ",|\\n";

        if (numbers.startsWith("//")) {
            int endDelimiters = numbers.indexOf("\n");
            regex = numbers.substring(2, endDelimiters);
            numbers = numbers.substring(endDelimiters + 1);
        }

        return numbers.split(regex);
    }
}
