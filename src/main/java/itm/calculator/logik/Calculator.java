package itm.calculator.logik;

import itm.calculator.enums.Operations;
import itm.calculator.exeptions.CalculatorException;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Calculator {

    private final Scanner tokenLine;


    public Calculator(String line) {
        this.tokenLine = new Scanner(line);
    }


    public int calculate() {
        int result;
        try {
            int a = Integer.parseInt(getToken());
            Operations operation = parseOperation(getToken());
            int b = Integer.parseInt(getToken());

            result = operation.calculate(a, b);

            if (tokenLine.hasNext()) {
                StringBuffer errorMessage = new StringBuffer();
                errorMessage.append("\n\tВ строке введены лишние аргументы.\n Extra arguments have been entered in the line");
                while (tokenLine.hasNext()) {
                    errorMessage.append("\n" + getToken());
                }
                throw new CalculatorException(errorMessage.toString());
            }
        } catch (NoSuchElementException e) {
            throw new CalculatorException("\n\tInvalid input.\n В строке не хватает аргументов // " +
                    "There are not enough arguments in the string\n" + e.getMessage());
        }

        return result;
    }


    private String getToken() throws NoSuchElementException {
        return tokenLine.next();
    }

    private Operations parseOperation(String token) {
        Operations result;

        result = Arrays.stream(Operations.values())
                .filter(op -> op.toString().equals(token))
                .findFirst()
                .orElse(null);

        if (result == null) {
            throw new CalculatorException("\n\tВведена неподдерживаемая операция // " +
                    "An unsupported operation has been introduced: " + token);
        }

        return result;
    }
}
