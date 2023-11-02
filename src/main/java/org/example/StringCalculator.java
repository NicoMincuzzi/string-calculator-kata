package org.example;

import java.util.List;

import static java.util.Arrays.asList;

public class StringCalculator {

    public int add(String numbers) throws Exception {
        Delimiters delimiters = new Delimiters(numbers);
        List<Integer> numsArray = new Numbers(numbers).retrieveSplittingBy(delimiters);

        int result = 0;
        for (int number : numsArray) {
            for (Rule rule : asList(new NegativeNumberRule(), new BigNumbersRule())) {
                number = rule.execute(number);
            }
            result += number;
        }
        return result;
    }
}
