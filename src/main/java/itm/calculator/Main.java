package itm.calculator;

import itm.calculator.logik.Calculator;


public class Main {

    public static String calc(String input) {
        Calculator calculator = new Calculator(input);
        int result = calculator.calculate();
        return String.valueOf(result);
    }
}
