import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroIfPassedStringIsEmpty() {
        assertEquals(0, StringCalculator.add(""), "Should return 0");
    }

    @Test
    void shouldReturnPassedNumberIfOnlyOneIsGiven() {
        assertEquals(1, StringCalculator.add("1"), "Should return 1");
    }

    @Test
    void shouldReturnSumOfTwoNumbersSeparatedByComma() {
        assertEquals(3, StringCalculator.add("1,2"), "Should return 3");
    }

    @Test
    void shouldReturnSumOfMoreThanTwoNumbersSeparatedByComma() {
        assertEquals(16, StringCalculator.add("1,2,3,0,4,6"), "Should return 16");
    }

    @Test
    void shouldReturnSumOfNumbersSeparatedByCommaOrNewLine() {
        assertEquals(6, StringCalculator.add("1\n2,3"), "Should return 6");
    }

    @Test
    void shouldReturnSumOfIntegersSeparatedByPassedDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"), "Should return 3");
    }


    @Test
    void shouldThrowExceptionWhenNegativeNumbersPassedAndListThemAll() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//,\n1,2,-1,-2,-3"));
        assertEquals("negatives not allowed -1 -2 -3", exception.getMessage());
    }

    @Test
    void shouldIgnoreNumbersBiggerThan1000() {
        assertEquals(6, StringCalculator.add("1\n2,1001,3\n2000"), "Should return six");
    }
}