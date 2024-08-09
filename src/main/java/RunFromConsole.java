import itm.calculator.Main;
import itm.calculator.inputProcessors.InProc;
import itm.calculator.inputProcessors.InProcConsole;


public class RunFromConsole {

    public static void main(String[] args) {
        InProc inProc = new InProcConsole();
        String expression = inProc.get();

        System.out.println(Main.calc(expression));
    }
}
