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



    public int calculate() throws CalculatorException {
        int result;
        try {
            int a = Integer.parseInt(getToken());
            Operations operation = parseOperation(getToken());
            int b = Integer.parseInt(getToken());
            validate(a, b);

            result = operation.calculate(a, b);

            if (tokenLine.hasNext()) {
                StringBuilder errorMessage = new StringBuilder();
                errorMessage.append("\n\tВ строке введены лишние аргументы. \t//\t Extra arguments have been entered in the line");
                errorMessage.append("\n\tВывожу перечень избыточных аргументов. \t//\t I am displaying a list of redundant arguments:");
                while (tokenLine.hasNext()) {
                    errorMessage.append("\n" + getToken());
                }
                throw new CalculatorException(errorMessage.toString());
            }
        } catch (NoSuchElementException e) {
            throw new CalculatorException("\n\tВ строке не хватает аргументов \t//\t " +
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
            throw new CalculatorException("\n\tВведена неподдерживаемая операция \t//\t " +
                    "An unsupported operation has been introduced: '" + token +
                    "'\n\tПеречень поддерживаемых операций: " + Arrays.toString(Operations.values()) + "\n");
        }

        return result;
    }


    private void validate (int... values) {
        final int min = 1;
        final int max = 10;
        Arrays.stream(values)
                .filter(val -> val < min || val > max)
                .findFirst()
                .ifPresent(v -> {
                    throw new CalculatorException("\n\tВведено недопустимое значение \t//\t " +
                            "An invalid value has been introduced: '" + v +
                            "'\n\tДопустимые значения: " + min + " - " + max + "\n");
                });
    }
}
