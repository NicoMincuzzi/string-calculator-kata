package org.example;

public class BigNumbersRule implements Rule {
    @Override
    public int execute(int number) {
        return isBigNumbers(number) ? 0 : number;
    }

    private boolean isBigNumbers(int number) {
        return number >= 1000;
    }
}
