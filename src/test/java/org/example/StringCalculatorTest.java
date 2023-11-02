package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void zero_value_when_the_string_value_is_empty() {
        int result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    void sum_value_when_the_string_has_single_value() {
        int result = stringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void sum_value_when_the_string_has_more_values() {
        int result = stringCalculator.add("1,2");

        assertEquals(3, result);
    }
}