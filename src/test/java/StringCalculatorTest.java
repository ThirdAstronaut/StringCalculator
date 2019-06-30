import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void shouldReturnZeroIfPassedStringIsEmpty() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void shouldReturnPassedNumberIfOnlyOneIsGiven() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    void shouldReturnSumOfTwoNumbersSeparatedByComma() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    void shouldReturnSumOfMoreThanTwoNumbersSeparatedByComma() {
        assertEquals(16, StringCalculator.add("1,2,3,0,4,6"));
    }

    @Test
    void shouldReturnSumOfNumbersSeparatedByCommaOrNewLine() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }


}