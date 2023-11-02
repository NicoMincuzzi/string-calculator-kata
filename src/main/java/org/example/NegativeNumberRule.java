package org.example;

public class NegativeNumberRule implements Rule {
    @Override
    public int execute(int number) throws Exception {
        if (isNegativeNumber(number)) {
            throw new Exception("negatives not allowed: " + number);
        }
        return number;
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }
}
