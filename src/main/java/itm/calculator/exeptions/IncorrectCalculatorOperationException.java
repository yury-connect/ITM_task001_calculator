package itm.calculator.exeptions;


public class IncorrectCalculatorOperationException extends IllegalArgumentException {

    public IncorrectCalculatorOperationException(String message) {
        super(message);
    }
}
