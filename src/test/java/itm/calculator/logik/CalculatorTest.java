package itm.calculator.logik;

import itm.calculator.exeptions.CalculatorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Nested
    public class CalculateCorrectValues {

        // ADDITION("+")
        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMinValue_AndAddition() {
            final String expression = "1 + 1";
            int expected = 2;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMiddleValue_AndAddition() {
            final String expression = "4 + 6";
            int expected = 10;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMaxValue_AndAddition() {
            final String expression = "10 + 10";
            int expected = 20;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }



        // SUBTRACTION("-")
        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMinValue_AndSubtraction() {
            final String expression = "1 - 1";
            int expected = 0;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMiddleValue_AndSubtraction() {
            final String expression = "6 - 4";
            int expected = 2;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMaxValue_AndSubtraction() {
            final String expression = "9 - 10";
            int expected = -1;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }



        // MULTIPLICATION("*")
        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMinValue_AndMultiplication() {
            final String expression = "1 * 1";
            int expected = 1;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMiddleValue_AndMultiplication() {
            final String expression = "4 * 6";
            int expected = 24;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMaxValue_AndMultiplication() {
            final String expression = "10 * 10";
            int expected = 100;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }



        // DIVISION("/")
        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMinValue_AndDivision() {
            final String expression = "1 / 1";
            int expected = 1;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMiddleValue_AndDivision() {
            final String expression = "7 / 3";
            int expected = 2;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnCorrectResult_WhenCorrectValuesWerePassedMaxValue_AndDivision() {
            final String expression = "10 / 3";
            int expected = 3;
            int actual = new Calculator(expression).calculate();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    public class CalculateNotCorrectValues {
        @Test
        public void shouldThrowException_WhenPassed_UnnecessaryArguments() {
            final String expression = "1 + 2 + 3";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }

        @Test
        public void shouldThrowException_WhenPassed_NotEnoughArguments() {
            final String expression = "1 + ";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }

        @Test
        public void shouldThrowException_WhenPassed_IncorrectLine_IsEmpty() {
            final String expression = "";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }

        @Test
        public void shouldThrowException_WhenPassed_IncorrectLine_NotNumber() {
            final String expression = "AbC";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }

        @Test
        public void shouldThrowException_WhenPassed_IncorrectLine_UnsupportedOperation() {
            final String expression = "2 ABCD 3";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }

        @Test
        public void shouldThrowException_WhenPassed_IncorrectLine_UnsupportedOperationDouble() {
            final String expression = "2 ++ 3";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }

        @Test
        public void shouldThrowException_WhenPassed_InvalidValue_TooBig() {
            final String expression = "2 + 123456";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }

        @Test
        public void shouldThrowException_WhenPassed_InvalidValue_TooSmall() {
            final String expression = "-3 - 1";
            Class<CalculatorException> expected = CalculatorException.class;
            Assertions.assertThrows(expected, () -> new Calculator(expression).calculate());
        }
    }
}