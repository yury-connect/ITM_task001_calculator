import itm.calculator.Main;

import java.util.Arrays;


public class RunnerForArgs {

    public static void main(String[] args) {
        String expression = Arrays.stream(args).reduce((a, b) -> a + " " + b).get();
        System.out.println("Произвожу вычисление следующего выражения: [" + expression + "]");

        System.out.println(Main.calc(expression));
    }
}
