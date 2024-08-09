import itm.calculator.Main;
import itm.calculator.inProcessors.InProc;
import itm.calculator.inProcessors.InProcConsole;


public class Run {

    public static void main(String[] args) {
        InProc inProc = new InProcConsole();
        String expression = inProc.get();

        System.out.println(Main.calc(expression));
    }
}
