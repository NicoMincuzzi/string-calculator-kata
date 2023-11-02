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
    void sum_value_when_the_string_has_two_values() {
        int result = stringCalculator.add("1,2");

        assertEquals(3, result);
    }

    @Test
    void sum_value_when_the_string_has_more_values() {
        int result = stringCalculator.add("1,2,3");

        assertEquals(6, result);
    }

    @Test
    void handle_new_line_delimiter_with_two_values() {
        int result = stringCalculator.add("1\n2");

        assertEquals(3, result);
    }

    @Test
    void handle_new_line_delimiter() {
        int result = stringCalculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    void handle_dynamic_delimiters() {
        int result = stringCalculator.add("//;\n1;2");

        assertEquals(3, result);
    }
}