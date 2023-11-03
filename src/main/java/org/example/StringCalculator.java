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

    public int add(String numbers) throws Exception {
        int result = 0;
        try {
            Delimiters delimiters = new Delimiters(numbers);
            List<Integer> numsArray = new Numbers(numbers).retrieveSplittingBy(delimiters);


            for (int number : numsArray) {
                for (Rule rule : asList(new NegativeNumberRule(), new BigNumbersRule())) {
                    number = rule.execute(number);
                }
                result += number;
            }

            logger.write(valueOf(result));
        } catch (LoggerException e) {
            webService.notify(e.getMessage());
        }
        return result;
    }
}
