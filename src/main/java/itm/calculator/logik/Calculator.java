package itm.calculator.logik;

import itm.calculator.enums.Operations;
import itm.calculator.exeptions.IncorrectCalculatorOperationException;

import java.util.Arrays;
import java.util.Scanner;


public class Calculator {

    private final Scanner tokenLine;


    public Calculator(String line) {
        this.tokenLine = new Scanner(line);
    }


    public int calculate() {
        int a = Integer.parseInt(getToken());
        Operations operation = parseOperation(getToken());
        int b = Integer.parseInt(getToken());

        int result = operation.calculate(a, b);
        return result;
    }


    private String getToken() {
        return tokenLine.next();
    }

    private Operations parseOperation(String token) {
        Operations result;

        result = Arrays.stream(Operations.values())
                .filter(op -> op.toString().equals(token))
                .findFirst()
                .orElse(null);

        if (result == null) {
            throw new IncorrectCalculatorOperationException("Invalid operation: " + token);
        }

        return result;
    }
}
