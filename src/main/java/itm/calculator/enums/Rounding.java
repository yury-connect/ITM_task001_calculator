package itm.calculator.enums;

public enum Rounding {


    UP {
        @Override
        public int round(double value) {
            return (int) Math.ceil(value);
        }
    },

    DOWN {
        @Override
        public int round(double value) {
            return (int) Math.floor(value);
        }
    },

    NEAREST {
        @Override
        public int round(double value) {
            return (int) Math.round(value);
        }
    };


    public abstract int round(double value);

    @Override
    public String toString() {
        return name().toUpperCase();
    }
}
