package calculator;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double reverse(int a) {
        if (a == 0) return Double.NaN;
        return 1.0 / a;
    }

    public double sqrt(int a) {
        if (a < 0) return Double.NaN;
        return Math.sqrt(a);
    }
}