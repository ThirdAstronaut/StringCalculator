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


}