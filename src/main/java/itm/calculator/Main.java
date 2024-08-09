package itm.calculator;

import itm.calculator.logik.Calculator;


/*
 * @author Lapitski Yury
 * @date 09-Aug-2024
 */
public class Main {

    public static String calc(String input) {
        Calculator calculator = new Calculator(input);
        int result = calculator.calculate();
        return String.valueOf(result);
    }
}
