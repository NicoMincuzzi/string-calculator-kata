package org.example;

import java.util.List;

import static java.lang.String.*;
import static java.util.Arrays.asList;

public class StringCalculator {

    private final ILogger logger;

    public StringCalculator(ILogger logger) {
        this.logger = logger;
    }

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

        logger.write(valueOf(result));
        return result;
    }
}
