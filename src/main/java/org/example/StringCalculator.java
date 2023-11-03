package org.example;

import java.util.List;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

public class StringCalculator {

    private final ILogger logger;
    private final IWebService webService;

    public StringCalculator(ILogger logger, IWebService webService) {
        this.logger = logger;
        this.webService = webService;
    }

    public int add(String sentence) throws Exception {
        int result = 0;
        try {
            Delimiters delimiters = new Delimiters(sentence);
            List<Integer> numbers = new Numbers(sentence).retrieveSplittingBy(delimiters);

            result = calculateSum(numbers);

            logger.write(valueOf(result));
        } catch (LoggerException e) {
            webService.notify(e.getMessage());
        }
        return result;
    }

    private int calculateSum(List<Integer> numbers) throws Exception {
        int result = 0;
        for (int number : numbers) {
            for (Rule rule : asList(new NegativeNumberRule(), new BigNumbersRule())) {
                number = rule.execute(number);
            }
            result += number;
        }
        return result;
    }
}
