package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StringCalculatorTest {

    private final ILogger logger = mock(ILogger.class);
    private final IWebService webService = mock(IWebService.class);
    private final StringCalculator stringCalculator = new StringCalculator(logger, webService);

    @Test
    void zero_value_when_the_string_value_is_empty() throws Exception {
        int result = stringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    void sum_value_when_the_string_has_single_value() throws Exception {
        int result = stringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    void sum_value_when_the_string_has_two_values() throws Exception {
        int result = stringCalculator.add("1,2");

        assertEquals(3, result);
    }

    @Test
    void sum_value_when_the_string_has_more_values() throws Exception {
        int result = stringCalculator.add("1,2,3");

        assertEquals(6, result);
    }

    @Test
    void handle_new_line_delimiter_with_two_values() throws Exception {
        int result = stringCalculator.add("1\n2");

        assertEquals(3, result);
    }

    @Test
    void handle_new_line_delimiter() throws Exception {
        int result = stringCalculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    void handle_dynamic_delimiters() throws Exception {
        int result = stringCalculator.add("//;\n1;2");

        assertEquals(3, result);
    }

    @Test
    void throw_exception_with_negative_numbers() {
        Exception exception = assertThrows(Exception.class, () -> stringCalculator.add("1,4,-1"));
        assertEquals("negatives not allowed: -1", exception.getMessage());
    }

    @Test
    void ignore_big_numbers() throws Exception {
        int result = stringCalculator.add("//;\n1;1000");

        assertEquals(1, result);
    }

    @Test
    void result_logging() throws Exception {
        int result = stringCalculator.add("//;\n1;1000");

        verify(logger).write(String.valueOf(result));
    }

    @Test
    void send_notify_to_web_service_when_logging_fail() throws Exception {
        doThrow(new LoggerException("Cannot log the result")).when(logger).write("1");

        int result = stringCalculator.add("//;\n1;1000");

        verify(webService).notify("Cannot log the result");
        assertEquals(1, result);
    }
}