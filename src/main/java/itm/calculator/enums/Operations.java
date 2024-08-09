package itm.calculator.enums;


public enum Operations {
    ADDITION("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },

    SUBTRACTION("-") {
        @Override
        public int calculate(int a, int b) {
            return a - b;
        }
    },

    MULTIPLICATION("*") {
        @Override
        public int calculate(int a, int b) {
            return a * b;
        }
    },

    DIVISION("/") {
        @Override
        public int calculate(int a, int b) {
            return rounder((double)a / b);
        }
    };


    private String operation;


    Operations (String operation) {
        this.operation = operation;
    }


    public abstract int calculate(int a, int b);

    protected int rounder (double value) {
        return Rounding.DOWN.round(value);
    }

    @Override
    public String toString() {
        return operation;
    }
}
