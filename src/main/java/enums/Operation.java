package enums;

public enum Operation {

    ADD {
        @Override
        public float calculate(float a, float b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public float calculate(float a, float b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public float calculate(float a, float b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        public float calculate(float a, float b) {
            return a / b;
        }
    };

    public abstract float calculate(float a, float b);      // metoda abstrakcyjna musi zostać zaimplementowana w każdej z zdefiniowanych wartości enum'a
}
