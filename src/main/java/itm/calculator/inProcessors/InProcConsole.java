package itm.calculator.inProcessors;

import java.util.Scanner;

public class InProcConsole implements InProc {

    private Scanner scanner;

    @Override
    public String get() {
        System.out.println("Введите выражение для вычисления:");
        scanner = new Scanner(System.in);
        String expression = scanner.nextLine().trim().toUpperCase();

        System.out.println("Введено выражение: " + expression);
        return expression;
    }
}
